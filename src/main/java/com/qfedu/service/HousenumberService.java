package com.qfedu.service;

import com.qfedu.bean.Housenumber;
import com.qfedu.bean.PageInfo;

import java.util.List;

public interface HousenumberService {
    //分页查询
    PageInfo<Housenumber> querylistByPage(Integer currentPage) throws Exception;
}
