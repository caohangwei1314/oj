package com.noi.oj.core.judge;

import com.noi.oj.core.config.OJConfig;
import com.noi.oj.core.config.OJConstants;
import com.noi.oj.domain.*;
import com.noi.oj.service.ProblemService;
import com.noi.oj.service.UsersService;
import jodd.format.Printf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
public final class JudgeService implements Serializable {
    public static final JudgeService me = new JudgeService();

    public static JudgeService me(){return me;}

    @Autowired
    private ProblemService problemServiceed;
    private static ProblemService problemService;

    @Autowired
    private UsersService usersServiceed;
    private static UsersService usersService;

    @PostConstruct
    public void init(){
        problemService = this.problemServiceed;
        usersService = this.usersServiceed;
    }

    public void judge(Solution solution){
        if(solution instanceof Solution){
            problemService.updateProblemSubmit(solution.getProblemId());
            usersService.updateUsersSubmit(solution.getUserId());
        }
        startJudgeThread(solution,false);
    }

    private void startJudgeThread(Solution solution,boolean deleteTempDir){
        synchronized (JudgeAdapter.class){
            JudgeAdapter judgeThread = new NojJudgeAdapter(solution);
            RejudgeTask task = new RejudgeTask(solution.getContestId(),solution.getSolutionId(),RejudgeType.SOLUTION);
            task.setDeleteTempDir(deleteTempDir);
            Thread thread = new Thread(judgeThread);
            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public int getDataFiles(Integer pid,List<String> inFiles,List<String> outFiles) throws IOException{
        File dataDir = new File(OJConfig.dataPath+File.separator+pid);
        if(!dataDir.isDirectory()){
            throw new IOException("Data files does not exist.");
        }

        File[] arrayOfFile = dataDir.listFiles();
        if(arrayOfFile == null){
            return 0;
        }

        if(arrayOfFile.length>3){
            Arrays.sort(arrayOfFile);
        }

        for(File inFile : arrayOfFile){
            if(!inFile.getName().toLowerCase().endsWith(OJConstants.DATA_EXT_IN)){
                continue;
            }
            File outFile = new File(dataDir.getAbsolutePath()+File.separator+inFile.getName()
                    .substring(0,inFile.getName().length() - OJConstants.DATA_EXT_IN.length()) + OJConstants.DATA_EXT_OUT);
            if(!outFile.isFile()){
                throw new IOException(Printf.str("Output file for input file does not exist: %s",inFile.getAbsolutePath()));
            }
            inFiles.add(inFile.getAbsolutePath());
            outFiles.add(outFile.getAbsolutePath());
        }
        return inFiles.size();
    }

    public String getWorkPath(Solution solution)
    {
        String workPath = OJConfig.getWorkPath();

        workPath = workPath + File.separator + "c" + solution.getContestId() + File.separator;

        File contestDir = new File(workPath);

        if(!contestDir.isDirectory())
        {
            contestDir.mkdir();
        }
        return workPath;
    }
}
