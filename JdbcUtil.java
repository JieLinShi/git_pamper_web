package com.train.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tjy
 * @version 1.0
 * @date 2019/8/5 18:53
 */
public class JdbcUtil {

    private static final JdbcUtil JDBC_UTIL = new JdbcUtil();

    private JdbcUtil() {

    }

    public static JdbcUtil getInstance() {
        return JDBC_UTIL;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework","root","Abc1234!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeResource(AutoCloseable autoCloseable) {
        if (null != autoCloseable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
