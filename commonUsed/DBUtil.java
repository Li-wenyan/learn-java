package model;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//用于管理数据库连接
//a)建立连接
//b)断开连接
//JDBC 中使用DataSource来管理连接
//DBUtil相当于是对DataSource再稍微包装一层
//DataSource每个应用程序只应该有一个实例（单例）
//DBUtil 本质上就是实现了一个单例模式，管理了唯一的一个DataSource实例
//单例模式的实现，有两种风格
//1.饿汉模式
// 2.懒汉模式
// 此处使用懒汉模式。
public class DBUtil {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java_blogdemo?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2222";

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if(dataSource == null) {
                    dataSource = new MysqlDataSource();
                    //还需要给DataSource设置一些属性
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //通过这个方法来获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过这个方法来断开连接
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
