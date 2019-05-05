package com.noi.oj.service.impl;

import com.noi.oj.dao.ContestMapper;
import com.noi.oj.dao.ContestProblemMapper;
import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.domain.Contest;
import com.noi.oj.domain.ContestProblem;
import com.noi.oj.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContestImpl implements ContestService {

    @Autowired
    private ContestMapper contestMapper;

    @Autowired
    private ContestProblemMapper contestProblemMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public int insertSelective(Contest record){
        if(contestMapper.insertSelective(record)>0){
            List<Integer> list = problemMapper.selectPrimaryKey();
            Set<Integer> set = new HashSet<>();
            Random r = new Random();
            while(set.size()<4){
                set.add(list.get(r.nextInt(list.size())));
            }
            Iterator<Integer> iterator = set.iterator();
            int i=1;
            while(iterator.hasNext()){
                ContestProblem contestProblem = new ContestProblem();
                contestProblem.setNum(i);
                contestProblem.setProblemId(iterator.next());
                contestProblem.setContestId(record.getContestId());
                contestProblemMapper.insertSelective(contestProblem);
            }
            return 1;
        }else{
            return 0;
        }
    }
}
