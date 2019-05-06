package com.noi.oj.service.impl;

import com.noi.oj.dao.ContestMapper;
import com.noi.oj.dao.ContestProblemMapper;
import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.dao.SolutionMapper;
import com.noi.oj.domain.*;
import com.noi.oj.service.ContestService;
import com.noi.oj.service.SolutionService;
import com.noi.oj.utils.PageBean;
import com.noi.oj.utils.UploadUtils;
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

    @Autowired
    private SolutionService solutionService;

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

    @Override
    public PageBean rank(Conditions record){
        int count = contestMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<Users> usersList = contestMapper.rank(record);
        for(Users users : usersList)
            users.setImage(UploadUtils.getUrl(users.getImage(),"users"));
        pageBean.setList(usersList);
        return pageBean;
    }

    @Override
    public List<Problem> selectProblem(Conditions record){
        return problemMapper.selectContestProblem(record);
    }

    @Override
    public PageBean selectSolution(Conditions record){
        return solutionService.selectList(record);
    }
}
