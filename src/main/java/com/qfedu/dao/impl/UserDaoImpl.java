package com.qfedu.dao.impl;

import com.qfedu.bean.User;
import com.qfedu.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.InputStream;

/**
 * MyBatis解决JDBC出现的问题
 * 使用输入映射，输出映射，
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User selectUserById(int id) throws Exception {

        //MyBatis核心配置文件路径
        String resource = "mybatis-config.xml";
        //获取MyBatis核心配置文件对应的输入流 Resources不要导错包了
        InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //  获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行statement
        User user = sqlSession.selectOne("selectUserById", id);
//        sqlSession.commit();//DML mybtils有添加事务，操作后需要手动提交事务管理。查询不用。
       //释放资源
        sqlSession.close();
        return user;
    }
}
