package com.train.day14;

import com.sun.org.apache.bcel.internal.generic.LLOAD;
import com.train.day05.prototype.Rectangle;
import com.train.day14.another.HeroOperatable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tjy
 * @version 1.0
 * @date 2019/8/5 18:59
 */
public class HomeWorkOperator implements HomeWorkOperatable {


    @Override
    public List<HomeWork> FindAll() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<HomeWork> homeWorkList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "select * from homework";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                Date sbirthhday = rs.getDate(4);
                String sclass = rs.getString(5);
                HomeWork homeWork = new HomeWork();
                homeWork.setSno(sno);
                homeWork.setSname(sname);
                homeWork.setSsex(ssex);
                homeWork.setSbirthday(sbirthhday);
                homeWork.setSclass(sclass);
                homeWorkList.add(homeWork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return homeWorkList;
    }

    @Override
    public int updateBySno(HomeWork homeWork) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement =null;

        try {
            statement = connection.createStatement();
            String sql = "update homework set 列名称 = 新值 where 列名称 = 某值 ";
            System.out.println(sql);

            int affectedRows = statement.executeUpdate(sql);
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int insert(HomeWork homeWork) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement =null;

        try {
            statement = connection.createStatement();
            String sql = "insert int homework values(" + "'" + homeWork.getSno() + "'" + ","+ "'" + homeWork.getSname() + "'" + ","+ "'" + homeWork.getSsex() + "'" + ","+ "'" + homeWork.getSbirthday() + "'" + ","+ "'" + homeWork.getSclass() + "'" + ")";
            System.out.println(sql);

            int affectedRows = statement.executeUpdate(sql);
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int deleteBySno(String sno) {

        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement =null;

        try {
            statement = connection.createStatement();
            String sql = "delect from homework where sno=" +sno ;
            System.out.println(sql);

            int affectedRows = statement.executeUpdate(sql);
            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }
}
