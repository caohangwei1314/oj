package com.noi.oj.service;

import com.noi.oj.domain.Conditions;
import com.noi.oj.domain.PacketOrder;
import com.noi.oj.utils.PageBean;

public interface OrderService {

    int insert(PacketOrder record);

    PageBean selectList(Conditions record);

}
