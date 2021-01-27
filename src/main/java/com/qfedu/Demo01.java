package com.qfedu;

import com.qfedu.bean.User;

import java.sql.*;

/**
 * 原始JDBC存在的问题
 * 1 数据库连接会频繁创建销毁
 * 2 需要手动拼接输入参数
 * 3 需要手动处理结果集
 * 4 需要手动释放资源
 * 5 常量参数存在硬编码  driverClass jdbcUrl username password
 *
 * 解决方案
 * 1 引入数据库连接池
 * 2 使用反射完成内省操作（默认）
 * 3 使用反射完成内省操作
 * 4 通用方法释放资源
 * 5 常量 参数存储到配置文件
 *
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接jdbc:mysql://localhost:3306/test
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
            //获取执行对象
            statement = connection.prepareStatement("select  * from tb_money where id = ?");
            statement.setInt(1, 1);
            //执行sql
            resultSet = statement.executeQuery();
            //处理结果集
            while (resultSet.next()) {
                User user = new User(resultSet.getInt(1),
                        resultSet.getString("name"),
                        resultSet.getString("password"));
                System.out.println(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection = null;
            }
        }



    }
}
