package com.noi.oj.service.impl;

import com.noi.oj.dao.ContestMapper;
import com.noi.oj.dao.ContestProblemMapper;
import com.noi.oj.dao.ProblemMapper;
import com.noi.oj.dao.SolutionMapper;
import com.noi.oj.domain.*;
import com.noi.oj.service.ContestService;
import com.noi.oj.service.ProblemService;
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
    private ProblemService problemService;

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private SolutionService solutionService;

    @Override
    public int insertSelective(Contest record){
        if(isContest(record.getUserId())!=null)
            return 0;
        record.setStartTime(new Date());
        record.setEndTime(new Date(System.currentTimeMillis() + 1000 * 60 * 90));
        int id = contestMapper.selectMaxId() + 1;
        record.setTitle("虚拟竞赛 " + id);
        if(contestMapper.insertSelective(record)>0){
            List<Integer> list = problemMapper.selectPrimaryKey(new Conditions());
            Set<Integer> set = new HashSet<>();
            Random r = new Random();
            set.add(1028);
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
        int count = contestMapper.countUsers(record);
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
    public PageBean selectProblem(Conditions record){
        return problemService.selectList(record);
    }

    @Override
    public PageBean selectSolution(Conditions record){
        return solutionService.selectList(record);
    }

    @Override
    public Contest isContest(Long userId){
        return contestMapper.selectByUserId(userId);
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = contestMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        pageBean.setList(contestMapper.selectList(record));
        return pageBean;
    }

    @Override
    public int deleteByContestIdAndUserId(Conditions record){
        if(contestMapper.deleteByContestIdAndUserId(record)>0)
            return contestProblemMapper.deleteByContestId(record);
        else
            return 0;
    }

    @Override
    public Contest selectByPrimaryKey(Integer contestId){
        return contestMapper.selectByPrimaryKey(contestId);
    }

    @Override
    public int updateByPrimaryKeySelective(Contest record){
        return contestMapper.updateByPrimaryKeySelective(record);
    }
}
