package com.noi.oj.service.impl;

import com.noi.oj.dao.*;
import com.noi.oj.domain.*;
import com.noi.oj.service.ProblemService;
import com.noi.oj.utils.PageBean;
import com.noi.oj.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProblemImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private ProblemClassMapper problemClassMapper;

    @Autowired
    private ProblemTagShipMapper problemTagShipMapper;

    @Autowired
    private ProblemPacketShipMapper problemPacketShipMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private PacketOrderMapper packetOrderMapper;

    @Override
    public int deleteByPrimaryKey(Integer problemId){
        int flag=0;
        if(deleteDir(SystemConstant.LINUX_Problem_PATH + problemId))
            if(problemPacketShipMapper.deleteByProblemId(problemId)>0)
                if(problemTagShipMapper.deleteByProblemId(problemId)>0)
                    if(problemClassMapper.deleteByProblemId(problemId)>0)
                        if(problemMapper.deleteByPrimaryKey(problemId)>0)
                            flag=1;
        return flag;
    }

    @Override
    public int insertSelective(Map<String,Object> map,Long userId) throws RuntimeException {
        int flag = 0;
        ProblemWithBLOBs record = getProblemMap(map);
        if (problemMapper.insertSelective(record) > 0) {
            int problemId = record.getProblemId();
            if(uploadSample(record)>0){
                ProblemClass problemClass = getProblemClassMap(map);
                problemClass.setProblemId(problemId);
                problemClass.setUserId(userId);
                if(problemClassMapper.insert(problemClass)>0){
                    List<ProblemTagShip> list = getTagShips(map,problemId);
                    if(problemTagShipMapper.insertList(list)>0){
                        ProblemPacketShip packetShip = getProblemPacketShip(map);
                        packetShip.setProblemId(problemId);
                        if(problemPacketShipMapper.insertSelective(packetShip)>0)
                            flag=1;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public ProblemWithBLOBs selectByPrimaryKey(Integer problemId){
        ProblemWithBLOBs problem = problemMapper.selectByPrimaryKey(problemId);
        problem.setTags(tagMapper.selectByProblemId(problemId));
        return problem;
    }

    @Override
    public PageBean selectList(Conditions record){
        if(record == null)
            return null;
        int count = problemMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<Problem> problems = problemMapper.getList(record);
        if(problems==null || problems.size()<1)
            return null;
        pageBean.setList(problems);
        return pageBean;
    }

    @Override
    public int updateByPrimaryKeySelective(Map<String,Object> map){
        int flag = 0;
        ProblemWithBLOBs record = getProblemMap(map);
        record.setProblemId(Integer.parseInt(map.get("problemId").toString()));
        if (problemMapper.updateByPrimaryKeySelective(record) > 0) {
            int problemId = record.getProblemId();
            if(uploadSample(record)>0){
                ProblemClass problemClass = getProblemClassMap(map);
                problemClass.setProblemId(problemId);
                if(problemClassMapper.updateByProblemIdSelective(problemClass)>0){
                    if(problemTagShipMapper.deleteByProblemId(problemId)>0){
                        List<ProblemTagShip> list = getTagShips(map,problemId);
                        if(problemTagShipMapper.insertList(list)>0)
                            flag=1;
                    }
                }
            }
        }
        return flag;
    }

    public Map<String,Object> isBuy(Conditions record){
        Map<String,Object> map = new HashMap<>();
        int count = packetOrderMapper.count(record);
        map.put("isBuy",count <1 ? 0 : 1);
        map.put("packetId",problemPacketShipMapper.selectPacketIdByProblemId(record));
        return map;
    }

    private boolean createFile(String path,String output){
        if(path == null || output == null)
            return false;
        try {
            File file = new File(path);
            if(!file.exists())
                file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(output.getBytes());
            fileOutputStream.close();
            return true;
        }catch (IOException e){
            return false;
        }
    }

    private int uploadSample(ProblemWithBLOBs record){
        String path = SystemConstant.LINUX_Problem_PATH + record.getProblemId() + File.separator;
        String inputPath = null;
        String outputPath = null;
        String sampleInput = record.getSampleInput();
        String sampleOutput = record.getSampleOutput();
        if (sampleInput != null && !"".equals(sampleInput))
            inputPath = path + "sample.in";
        if (sampleOutput != null && !"".equals(sampleOutput))
            outputPath = path + "sample.out";
        File file = new File(path);
        if (!file.exists())
            System.out.println(file.mkdirs());
        if(inputPath!=null)
            if(!createFile(inputPath, sampleInput))
                return 0;
        if(outputPath!=null)
            if(!createFile(outputPath, sampleOutput))
                return 0;
        return 1;
    }

    private boolean deleteDir(String path){
        if(path==null || "".equals(path))
            return false;
        deleteAllFile(path);
        File file = new File(path);
        if(!file.exists())
            return false;
        if(!file.isDirectory())
            return false;
        else
            return file.delete();
    }

    private boolean deleteAllFile(String path){
        if(path==null || "".equals(path))
            return false;
        File file = new File(path);
        if(!file.exists())
            return false;
        if(!file.isDirectory())
            return false;
        File[] files = file.listFiles();
        File temp = null;
        for(int i=0;i<files.length;i++){
            temp = files[i];
            if(temp.isFile())
                temp.delete();
            if(temp.isDirectory()){
                deleteAllFile(files[i].getPath());
                deleteDir(files[i].getPath());
            }
        }
        return true;
    }

    private ProblemWithBLOBs getProblemMap(Map<String,Object> map){
        if(map==null)
            return null;
        ProblemWithBLOBs record = new ProblemWithBLOBs();
        if(isEmpty(map.get("title")))
            record.setTitle(null);
        else
            record.setTitle(map.get("title").toString());
        if(isEmpty(map.get("timeLimit")))
            record.setTimeLimit(null);
        else
            record.setTimeLimit(Integer.parseInt(map.get("timeLimit").toString()));
        if(isEmpty(map.get("submit")))
            record.setSubmit(null);
        else
            record.setSubmit(Integer.parseInt(map.get("submit").toString()));
        if(isEmpty(map.get("spj")))
            record.setSpj(null);
        else
            record.setSpj(map.get("spj").toString());
        if(isEmpty(map.get("source")))
            record.setSource(null);
        else
            record.setSource(map.get("source").toString());
        if(isEmpty(map.get("solved")))
            record.setSolved(null);
        else
            record.setSolved(Integer.parseInt(map.get("solved").toString()));
        if(isEmpty(map.get("memoryLimit")))
            record.setMemoryLimit(null);
        else
            record.setMemoryLimit(Integer.parseInt(map.get("memoryLimit").toString()));
        try {
            if(isEmpty(map.get("inDate")))
                record.setInDate(new Date());
            else
                record.setInDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(map.get("inDate").toString()));
        }catch (ParseException e){
            throw new RuntimeException(e.getMessage());
        }
        if(isEmpty(map.get("defunct")))
            record.setMemoryLimit(null);
        else
            record.setDefunct(map.get("defunct").toString());
        if(isEmpty(map.get("accepted")))
            record.setAccepted(null);
        else
            record.setAccepted(Integer.parseInt(map.get("accepted").toString()));
        if(isEmpty(map.get("sampleOutput")))
            record.setAccepted(null);
        else
            record.setSampleOutput(map.get("sampleOutput").toString());
        if(isEmpty(map.get("sampleInput")))
            record.setAccepted(null);
        else
            record.setSampleInput(map.get("sampleInput").toString());
        if(isEmpty(map.get("input")))
            record.setAccepted(null);
        else
            record.setInput(map.get("input").toString());
        if(isEmpty(map.get("output")))
            record.setAccepted(null);
        else
            record.setOutput(map.get("output").toString());
        if(isEmpty(map.get("hint")))
            record.setAccepted(null);
        else
            record.setHint(map.get("hint").toString());
        if(isEmpty(map.get("description")))
            record.setAccepted(null);
        else
            record.setDescription(map.get("description").toString());
        return record;
    }

    private ProblemClass getProblemClassMap(Map<String,Object> map){
        if(map==null)
            return null;
        ProblemClass record = new ProblemClass();
        if(isEmpty(map.get("difficulty")))
            record.setDifficulty(null);
        else
            record.setDifficulty(new Byte(map.get("difficulty").toString()));
        if(isEmpty(map.get("type")))
            record.setType(null);
        else
            record.setType(new Byte(map.get("type").toString()));
        if(isEmpty(map.get("isFree")))
            record.setIsFree(null);
        else
            record.setIsFree(new Byte(map.get("isFree").toString()));
        return record;
    }

    private ProblemPacketShip getProblemPacketShip(Map<String,Object> map){
        if(map==null)
            return null;
        ProblemPacketShip record = new ProblemPacketShip();
        if(isEmpty(map.get("packetId")))
            record.setPacketId(null);
        else
            record.setPacketId(Integer.parseInt(map.get("packetId").toString()));
        return record;
    }

    private List<ProblemTagShip> getTagShips(Map<String,Object> map,Integer problemId){
        String[] tagIds;
        if(isEmpty(map.get("tags")))
            return null;
        else
           tagIds = map.get("tags").toString().split(",");
        if(tagIds==null)
            return null;
        List<ProblemTagShip> list = new ArrayList<>();
        for(int i=0;i<tagIds.length;i++){
            ProblemTagShip ship = new ProblemTagShip();
            ship.setProblemId(problemId);
            ship.setTagId(Integer.parseInt(tagIds[i]));
            list.add(ship);
        }
        return list;
    }

    private boolean isEmpty(Object str){
        if(null==str)
            return true;
        else
            if("".equals(str.toString()))
                return true;
            else
                return false;
    }

}
