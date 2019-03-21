package com.noi.oj.core.config;


import com.noi.oj.domain.ProgramLanguage;
import com.noi.oj.domain.ResultType;
import com.noi.oj.service.ProgramLanguageService;
import com.noi.oj.service.impl.ProgramLanguageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OJConfig{

    @Autowired
    public ProgramLanguageService programLanguageServiceed;
    public static ProgramLanguageService programLanguageService;

    public static List<ProgramLanguage> programLanguages;
    public static Map<Integer,ProgramLanguage> languageType = new HashMap<>();
    public static Map<String,Integer> languageID = new HashMap<>();
    public static Map<Integer, ResultType> resultType = new HashMap<>();
    public static List<ResultType> judgeResult;
    public static final String workPath="E:\\work\\judge\\temp";
    public static final String dataPath="E:\\work\\judge\\data";
    public static final String compileShell="E:\\work\\bin\\com.exe";
    public static final String runShell="E:\\work\\bin\\run.exe";

    @PostConstruct
    public void init() {
        programLanguageService = this.programLanguageServiceed;
        loadLanguage();
        initJudgeResult();
    }

    public static void loadLanguage()
    {

        languageType = new HashMap<>();

        programLanguages = programLanguageService.selectAll();

        for(ProgramLanguage language : programLanguages)
        {
            languageID.put(language.getName(),language.getId());
            languageType.put(language.getId(),language);
        }
    }

    public static void initJudgeResult() {
        judgeResult = new ArrayList<>();
        judgeResult.add(new ResultType(ResultType.AC, "AC", "Accepted"));
        judgeResult.add(new ResultType(ResultType.PE, "PE", "Presentation Error"));
        judgeResult.add(new ResultType(ResultType.WA, "WA", "Wrong Answer"));
        judgeResult.add(new ResultType(ResultType.TLE, "TLE", "Time Limit Exceed"));
        judgeResult.add(new ResultType(ResultType.MLE, "MLE", "Memory Limit Exceed"));
        judgeResult.add(new ResultType(ResultType.OLE, "OLE", "Output Limit Exceed"));
        judgeResult.add(new ResultType(ResultType.CE, "CE", "Compile Error"));
        judgeResult.add(new ResultType(ResultType.RF, "RF", "Restricted Function"));
        judgeResult.add(new ResultType(ResultType.RE, "RE", "Runtime Error"));
        judgeResult.add(new ResultType(ResultType.SE, "SE", "System Error"));
        judgeResult.add(new ResultType(ResultType.VE, "VE", "Validate Error"));
        judgeResult.add(new ResultType(ResultType.RUN, "RUN", "Running"));
        judgeResult.add(new ResultType(ResultType.WAIT, "WAIT", "Waiting"));
        judgeResult.add(new ResultType(ResultType.REJUDGE, "REJUDGE", "Rejudging"));
        judgeResult.add(new ResultType(ResultType.SIM, "SIM", "Similar"));
        judgeResult.add(new ResultType(ResultType.COM, "COM", "Compiling"));
        judgeResult.add(new ResultType(ResultType.QUE, "QUE", "Queuing"));
        resultType = new HashMap<>();
        for (ResultType result : judgeResult) {
            resultType.put(result.getId(), result);
        }
    }

    public static String getWorkPath()
    {
        return workPath;
    }
}
