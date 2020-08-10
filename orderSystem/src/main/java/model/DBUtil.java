package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * DBUtile本质上是一个管理了单例的DataSource的类
 * User:LiWenYan
 * Date:2020-08-10
 * Time:11:18
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/dingdan?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME ="root";
    private static final String PASSWORD = "";

    private static volatile DataSource dataSource = null;
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if(dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }
    //数据库连接失败很常见，常见问题：
    //url , uesrname, password等信息写错了，或者数据库没有启动
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库启动失败，检查数据库是否启动正确，url是否正确");
        return null;
    }

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
