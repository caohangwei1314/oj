package com.noi.oj.service.impl;

import com.noi.oj.dao.ChallengeMapper;
import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.dao.UsersMapper;
import com.noi.oj.domain.*;
import com.noi.oj.service.ChallengeService;
import com.noi.oj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ChallengeImpl implements ChallengeService {

    @Autowired
    private ChallengeMapper challengeMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private UsersMapper usersMapper;

    public Problem insert(Long userId){
        Users users = usersMapper.selectByPrimaryKey(userId);
        Conditions record = new Conditions();
        switch (users.getLevelId()){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                record.setDifficulty((byte)0);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                record.setDifficulty((byte)1);
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                record.setDifficulty((byte)2);
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                record.setDifficulty((byte)3);
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                record.setDifficulty((byte)4);
                break;
        }
        List<Integer> problemIds = problemMapper.selectPrimaryKey(record);
        Random r = new Random();
        int problemId = problemIds.get(r.nextInt(problemIds.size()));
        Challenge challenge = new Challenge();
        challenge.setProblemId(problemId);
        challenge.setUserId(userId);
        long time = System.currentTimeMillis();
        Date startTime = new Date(time);
        Date endTime = new Date(time + 1000*60*15);
        challenge.setStartTime(startTime);
        challenge.setEndTime(endTime);
        if(challengeMapper.insertSelective(challenge)>0){
            Problem problem = problemMapper.selectByPrimaryKey(problemId);
            problem.setStartTime(startTime);
            problem.setEndTime(endTime);
            return problem;
        }else{
            return null;
        }
    }

    @Override
    public ProblemWithBLOBs select(Long userId){
        return challengeMapper.selectChallenge(userId);
    }
}
