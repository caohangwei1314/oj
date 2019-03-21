package com.noi.oj.core.judge;

import com.noi.oj.core.config.OJConfig;
import com.noi.oj.core.config.OJConstants;
import com.noi.oj.domain.*;
import com.noi.oj.service.ProblemService;
import com.noi.oj.service.SolutionService;
import com.noi.oj.service.UsersService;
import jodd.io.FileUtil;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NojJudgeAdapter extends JudgeAdapter{

    public NojJudgeAdapter(){super();}

    public NojJudgeAdapter(Solution solution){super(solution);}

    public static void main(String[] args){

    }

    @Autowired
    private UsersService usersServiceed;
    private static UsersService usersService;

    @Autowired
    private SolutionService solutionServiceed;
    private static SolutionService solutionService;

    @Autowired
    private ProblemService problemServiceed;
    private static ProblemService problemService;

    @PostConstruct
    public void init(){
        usersService=this.usersServiceed;
        solutionService=this.solutionServiceed;
        problemService=this.problemServiceed;
    }

    public boolean compile() throws IOException
    {
        ProgramLanguage programLanguage = OJConfig.languageType.get(solution.getLanguage());
        String workDirPath = judgeService.getWorkPath(solution);
        String comShellName = OJConfig.compileShell;
        String compileCmdName =
                getCompileCmd(programLanguage.getCompilecmd(),workDirPath,OJConstants.SOURCE_FILE_NAME,programLanguage.getExt()).replaceAll("\\\\","/");
        /*
         * execute compiler command
         */
        Process compileProcess = Runtime.getRuntime().exec(comShellName);
        StringBuilder stringBuilder = new StringBuilder();
        int ret = 0;
        try{
            //获取进程的标注你输出流
            final OutputStream os1 = compileProcess.getOutputStream();
            //获取进程的错误流
            final InputStream is2 = compileProcess.getErrorStream();
            //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流

            new Thread() {
                public void run() {
                    try {
                        os1.write(compileCmdName.getBytes());
                        os1.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally{
                        try {
                            os1.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            new Thread() {
                public void  run() {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(is2,"GBK"));
                        long startTime = System.currentTimeMillis();
                        String errorOutput = "";
                        while((startTime+10000L>System.currentTimeMillis()) && (
                                (errorOutput=br.readLine())!=null))
                        {
                            stringBuilder.append(errorOutput).append("\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            is2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
            ret = compileProcess.waitFor();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        String mainProgramPath =
                new StringBuilder().append(workDirPath).append(solution.getSolutionId())
                        .append(File.separator).append(OJConstants.SOURCE_FILE_NAME)
                        .append(".").append(programLanguage.getExe()).toString();
        File mainProgram = new File(mainProgramPath);
//        File mainProgram = new File("E:\\work\\judge\\temp\\c1\\1096\\Main.class");
        boolean success = mainProgram.isFile();

        if(!success){
            updateCompileError(stringBuilder.toString());
        }
        return true;
    }

    @Override
    public boolean runProcess() throws IOException, InterruptedException
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


        int result = runProcess.waitFor();
        result = runProcess.exitValue();

        if(result!=ResultType.AC && (errorOut.indexOf("Exception") != -1 || errorOut.indexOf("Traceback") != -1)
                || errorOut.indexOf("Runtime error") != -1){
            result = ResultType.RE;
        }

        if(result < 0){
            result = ResultType.SE;
        }

        synchronized (JudgeAdapter.class){
            boolean ret = updateResult(result,time,memory);
            updateUser();
            updateProblem();
            return ret;
        }
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

    protected boolean updateUser(){
        if(solution.getResult()!=ResultType.AC){
            return false;
        }

        Integer cid = solution.getContestId();
        if(cid !=null && cid>0){
            return false;
        }
        Users users = usersService.selectByPrimaryKey(solution.getUserId());
        users.setSubmit(users.getSubmit()+1);
        long count = solutionService.countAccess(users.getPkId());
        users.setSolved((int) count);
        return usersService.updateByPrimaryKeySelective(users)>0;
    }

    protected boolean updateProblem(){
        ProblemWithBLOBs problem = problemService.selectByPrimaryKey(solution.getProblemId());
        problem.setSubmit(problem.getSubmit()+1);
        problem.setSolved((int) solutionService.countAccess(null));
        return problemService.updateByPrimaryKeySelective(problem)>0;
    }

    private String getCompileCmd(String compileCmd,String path,String name,String ext) {
        path = new StringBuilder(3).append(path).append(solution.getSolutionId()).toString();
        compileCmd = StringUtil.replace(compileCmd,"%PATH%",path);
        compileCmd = StringUtil.replace(compileCmd,"%NAME%",name);
        compileCmd = StringUtil.replace(compileCmd,"%EXT%",ext);
        return compileCmd;
    }
}
