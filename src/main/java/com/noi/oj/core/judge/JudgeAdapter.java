package com.noi.oj.core.judge;

import com.noi.oj.core.config.OJConfig;
import com.noi.oj.core.config.OJConstants;
import com.noi.oj.domain.ProgramLanguage;
import com.noi.oj.domain.Solution;
import com.noi.oj.domain.SourceCode;
import jodd.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class JudgeAdapter implements Runnable{

    protected static final JudgeService judgeService = JudgeService.me();

    private static final Pattern classNamePattern =
            Pattern.compile("\\s*(?:public)?\\s*(?:final)?\\s+class\\s+(\\w+)\\s*");

    private static final int RESERVED_TEMP_DIRS=25;

    protected Solution solution;

    protected SourceCode sourceCode;

    private boolean deleteTempDir = false;

    public JudgeAdapter() {
        super();
    }

    public JudgeAdapter(Solution solution,SourceCode sourceCode) {
        this();
        this.solution = solution;
        this.sourceCode = sourceCode;
    }

    protected abstract boolean compile() throws IOException;

    protected abstract boolean runProcess() throws IOException, InterruptedException;

    public void run()
    {
        synchronized (JudgeAdapter.class)
        {
            try {
                prepare();
                if(compile())
                {
                    runProcess();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    protected void  prepare() throws IOException,URISyntaxException
    {
        ProgramLanguage programLanguage = OJConfig.languageType.get(solution.getSolutionId());

        String workPath = judgeService.getWorkPath(solution);

        if(solution instanceof Solution && !getDeleteTempDir())
        {
            File prevWorkDir = new File(workPath + (solution.getSolutionId() - RESERVED_TEMP_DIRS));
            if(prevWorkDir.isDirectory())
            {
                FileUtil.deleteDir(prevWorkDir);
            }
        }

        File workDir = new File(workPath+solution.getSolutionId());
        if(workDir.isDirectory())
        {
            FileUtil.cleanDir(workDir);
        }else{
            FileUtil.mkdirs(workDir);
        }

        String workDirPath = workDir.getAbsolutePath();

        if(solution.getLanguage().equals(OJConfig.languageID.get("Java")))
        {
            String className = getJavaPublishClass(sourceCode.getSource());
            if(className!=null && !className.equals(OJConstants.SOURCE_FILE_NAME)){
                generateClassFiles(programLanguage,workDirPath,className);
                return;
            }
        }

        File sourceFile = new File(getFilePath(programLanguage,workDirPath,OJConstants.SOURCE_FILE_NAME));
        FileUtil.touch(sourceFile);
        String content =
                sourceCode.getSource().replaceAll("#\\s*include\\s*\"\\.*/.*\".*", "#error \"Your action is logged!\"")
                        .replaceAll("#\\s*include\\s*<\\.*/.*>.*", "#error \"Your action is logged!\"");
//        if(content.length()!=solution.getCodeLength())
//        {
//
//        }
        FileUtil.writeString(sourceFile,content);
    }

    private void generateClassFiles(ProgramLanguage programLanguage,String workDirPath,String className)
            throws IOException,URISyntaxException{

        generateMainClass(programLanguage,workDirPath,className);

        generateUserClass(programLanguage,workDirPath,className);

    }

    private void generateUserClass(ProgramLanguage programLanguage,String workDirPath,String className)
            throws IOException{
        File sourceFile = new File(getFilePath(programLanguage,workDirPath,className));
        FileUtil.touch(sourceFile);
        String content = sourceCode.getSource().replaceAll("\\s*package\\s+.*;", "");
        FileUtil.writeString(sourceFile,content);
    }

    private void generateMainClass(ProgramLanguage programLanguage,String workDirPath,String className)
        throws IOException,URISyntaxException{
        File sourceFile = new File(getFilePath(programLanguage,workDirPath,className));
        FileUtil.touch(sourceFile);
        File file = new File(getClass().getResource("/Main.ftl").toURI());
        String content = FileUtil.readString(file).replace("${_CLASS_NAME_}", className);
        FileUtil.writeString(sourceFile,content);
    }

    private String getFilePath(ProgramLanguage programLanguage,String workDirPath,String name){
        return workDirPath + File.separator + name + '.' + programLanguage.getExt();
    }

    private String getJavaPublishClass(String content)
    {
        String className = null;
        Matcher matcher = classNamePattern.matcher(content);
        if(matcher.find())
        {
            className = matcher.group(1);
        }
        return className;
    }

    public boolean getDeleteTempDir()
    {
        return deleteTempDir;
    }
}
