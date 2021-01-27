package com.qfedu.dao;

import com.qfedu.bean.User;
import com.qfedu.dao.impl.UserDaoImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class UserDaoTest{

    @Test
    public void testSelectUserById() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectUserById(52);
        System.out.println(user);
    }
}