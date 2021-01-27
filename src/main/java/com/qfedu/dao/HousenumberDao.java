package com.qfedu.dao;

import com.qfedu.bean.Housenumber;
import com.qfedu.bean.PageInfo;

import java.util.List;

public interface HousenumberDao {
    //分页查询
    List<Housenumber> selectListByPage(Integer begin, Integer pageSize) throws Exception;
    long selectTotalSize() throws Exception;
}
