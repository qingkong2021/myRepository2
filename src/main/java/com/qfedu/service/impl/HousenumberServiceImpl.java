package com.qfedu.service.impl;

import com.qfedu.bean.Housenumber;
import com.qfedu.bean.PageInfo;
import com.qfedu.dao.HousenumberDao;
import com.qfedu.dao.impl.HousenumberDaoImpl;
import com.qfedu.service.HousenumberService;

import java.util.List;

public class HousenumberServiceImpl implements HousenumberService {
    @Override
    public PageInfo<Housenumber> querylistByPage(Integer currentPage) {
        HousenumberDao housenumberDao = new HousenumberDaoImpl();
//        select * from housenumber limit begin, pageSize;
        //begin = (currentPage - 1) * pageSize;
        PageInfo<Housenumber> pageInfo = new PageInfo<>();
        Integer pageSize = 3;
        pageInfo.setPageSize(pageSize);
        Integer begin = (currentPage - 1) * pageSize;
        try {
            List<Housenumber> housenumbers = housenumberDao.selectListByPage(begin, pageSize);
            long totalSize = housenumberDao.selectTotalSize();
            pageInfo.setTotalPage(totalSize);
            pageInfo.setList(housenumbers);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageInfo;
    }
}
