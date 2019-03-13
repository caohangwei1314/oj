package com.noi.oj.core.judge;

import com.noi.oj.core.config.OJConfig;
import com.noi.oj.core.config.OJConstants;
import com.noi.oj.domain.*;
import com.noi.oj.service.ProblemService;
import com.noi.oj.service.SolutionService;
import jodd.io.FileUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NojJudgeAdapter extends JudgeAdapter{

    public NojJudgeAdapter(){super();}

    public NojJudgeAdapter(Solution solution, SourceCode code){super(solution,code);}

    public static void main(String[] args){

    }

    @Autowired
    private SolutionService solutionService;

    @Autowired
    private ProblemService problemService;

    public boolean compile() throws IOException
    {
        ProgramLanguage programLanguage = OJConfig.languageType.get(solution.getLanguage());
        String workDirPath = judgeService.getWorkPath(solution);
        String comShellName = OJConfig.compileShell;
        String compileCmdName =
                getCompileCmd(programLanguage.getCompilecmd(),workDirPath,OJConstants.SOURCE_FILE_NAME,programLanguage.getExt());
        /*
         * execute compiler command
         */
        Process compileProcess = Runtime.getRuntime().exec(comShellName);
        OutputStream comShellOutputStream = compileProcess.getOutputStream();
        comShellOutputStream.write(compileCmdName.getBytes());
        comShellOutputStream.flush();

        BufferedReader compileErrorBufferedReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        String errorOutput = "";
        while((startTime+10000L>System.currentTimeMillis()) && (
                (errorOutput=compileErrorBufferedReader.readLine())!=null))
        {
            stringBuilder.append(errorOutput).append("\n");
        }
        compileErrorBufferedReader.close();

        int ret = 0;
        try{
            ret = compileProcess.waitFor();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        File mainProgram = new File(
            new StringBuilder(4).append(workDirPath).append(File.separator).append(OJConstants.SOURCE_FILE_NAME)
                .append("").append(programLanguage.getExe()).toString());
        boolean success = mainProgram.isFile();

        if(!success){
            updateCompileError(stringBuilder.toString());
        }
        return true;
    }

    @Override
    public boolean runProcess() throws IOException
    {
        ProgramLanguage programLanguage = OJConfig.languageType.get(solution.getLanguage());
        String workDirPath = judgeService.getWorkPath(solution);
        /*
         * execute run command
         */
        Process runProcess = Runtime.getRuntime().exec(OJConfig.runShell);
        OutputStream runProcessOutputStream = runProcess.getOutputStream();

        ProblemWithBLOBs problem = problemService.selectByPrimaryKey(solution.getProblemId());
        List<String> inFiles = new ArrayList<String>();
        List<String> outFiles = new ArrayList<String>();
        int numOfData = judgeService.getDataFiles(solution.getProblemId(),inFiles,outFiles);

        long timeLimit =
                problem.getTimeLimit() * programLanguage.getTimefactor() + numOfData * programLanguage.getExttime();
        long caseTimeLimit =
                problem.getTimeLimit() * programLanguage.getTimefactor() + programLanguage.getExttime();
        runProcessOutputStream.write((timeLimit + "\n").getBytes());
        runProcessOutputStream.write((caseTimeLimit + "\n").getBytes());

        long memoryLimit = (problem.getMemoryLimit() + programLanguage.getExtmemory()) * 1024L;
        runProcessOutputStream.write((memoryLimit + "\n").getBytes());

        String mainProgram =
                new StringBuilder(6).append(workDirPath).append(File.separator).append(OJConstants.SOURCE_FILE_NAME)
                    .append("").append(programLanguage.getExe()).append("\n").toString();
        runProcessOutputStream.write(mainProgram.getBytes());
        runProcessOutputStream.write((workDirPath + "\n").getBytes());

        runProcessOutputStream.write((numOfData + "\n").getBytes());

        if(numOfData < 1){
            //throw new Exception()
        }
        for(int i=0;i<numOfData;++i){
            runProcessOutputStream.write((inFiles.get(i) + "\n").getBytes());

            String userOutFile = new StringBuilder(4).append(workDirPath).append(File.separator)
                    .append(new File(outFiles.get(i)).getName()).append("\n").toString();
            runProcessOutputStream.write(userOutFile.getBytes());
            runProcessOutputStream.write((outFiles.get(i) + "\n").getBytes());
        }
        runProcessOutputStream.flush();

        BufferedReader inputStreamBufferedReader =
                new BufferedReader(new InputStreamReader(runProcess.getInputStream()));

        String buff = inputStreamBufferedReader.readLine();

        int time = Integer.parseInt(buff);
        buff = inputStreamBufferedReader.readLine();
        int memory = Integer.parseInt(buff);
        if(memory>0){
            memory -= programLanguage.getExtmemory();
        }
        StringBuilder sb = new StringBuilder();

        InputStream errorStream = runProcess.getErrorStream();
        while(errorStream.available()>0){
            Character c = new Character((char) errorStream.read());
            sb.append(c);
        }
        String errorOut = sb.toString();

        runProcessOutputStream.close();
        inputStreamBufferedReader.close();
        errorStream.close();

        int result = runProcess.exitValue();

        if(result!=ResultType.AC && (errorOut.indexOf("Exception") != -1 || errorOut.indexOf("Traceback") != -1)
                || errorOut.indexOf("Runtime error") != -1){
            result = ResultType.RE;
        }

        if(result < 0){
            result = ResultType.SE;
        }

        synchronized (JudgeAdapter.class){
            boolean ret = updateResult(result,time,memory);
        }
        return true;
    }

    protected boolean updateCompileError(String error){
        solution.setResult(ResultType.CE);
        if(StringUtil.isNotBlank(error)){
//            solution.set
        }
        return true;
    }

    protected boolean updateResult(int result,int time,int memory){
        solution.setResult(result);
        solution.setTime(time);
        solution.setMemory(memory);
        return solutionService.updateByPrimaryKeySelective(solution)>0;
    }

    private String getCompileCmd(String compileCmd,String path,String name,String ext) {
        path = new StringBuilder(2).append(path).append(File.separator).toString();
        compileCmd = StringUtil.replace(compileCmd,"%PATH%",path);
        compileCmd = StringUtil.replace(compileCmd,"%NAME%",name);
        compileCmd = StringUtil.replace(compileCmd,"%EXT%",ext);
        compileCmd = new StringBuilder(2).append(compileCmd).append("\n").toString();
        return compileCmd;
    }
}
