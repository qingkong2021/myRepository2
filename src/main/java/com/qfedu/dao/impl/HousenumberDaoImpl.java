package com.qfedu.dao.impl;

import com.qfedu.bean.Housenumber;
import com.qfedu.bean.PageInfo;
import com.qfedu.dao.HousenumberDao;
import com.qfedu.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class HousenumberDaoImpl implements HousenumberDao {
    @Override
    public List<Housenumber> selectListByPage(Integer begin, Integer pageSize) throws Exception {
        return new QueryRunner(JDBCUtils.getDataSource()).query("select * from housenumber limit ?, ?",
                new BeanListHandler<>(Housenumber.class),
                begin,
                pageSize);
    }

    @Override
    public long selectTotalSize() throws Exception {
       return (long) new QueryRunner(JDBCUtils.getDataSource()).query("select count(*) from housenumber",
                new ScalarHandler<>());
    }
}
