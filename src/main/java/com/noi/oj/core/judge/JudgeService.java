package com.noi.oj.core.judge;

import com.noi.oj.core.config.OJConfig;
import com.noi.oj.core.config.OJConstants;
import com.noi.oj.domain.Solution;
import jodd.format.Printf;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class JudgeService {
    public static final JudgeService me = new JudgeService();

    public static JudgeService me(){return me;}

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
