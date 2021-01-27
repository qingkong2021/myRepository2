package com.qfedu.dao;

import com.qfedu.bean.User;

public interface UserDao {
    User selectUserById(int id) throws Exception;
}
