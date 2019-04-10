package com.noi.oj.service.impl;

import com.noi.oj.dao.PacketOrderMapper;
import com.noi.oj.dao.UsersMapper;
import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.PacketOrder;
import com.noi.oj.domain.Users;
import com.noi.oj.service.OrderService;
import com.noi.oj.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {

    @Autowired
    private PacketOrderMapper packetOrderMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int insert(PacketOrder record){
        Users users = usersMapper.selectByPrimaryKey(record.getUserId());
        if(users.getBalance().compareTo(record.getPrice()) < 0)
            return 0;
        users.setBalance(users.getBalance().subtract(record.getPrice()));
        if(usersMapper.updateByPrimaryKeySelective(users)>0)
            return packetOrderMapper.insert(record);
        else
            return 0;
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = packetOrderMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit());
        record.setOffset(pageBean.getStart());
        List<PacketOrder> packetOrders = packetOrderMapper.selectList(record);
        if(packetOrders != null && packetOrders.size()>0)
            pageBean.setList(packetOrders);
        else
            pageBean.setList(null);
        return pageBean;
    }
}
