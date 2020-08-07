package dao;


import entity.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static util.DBUtils.getConnection;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 有关用户的数据库操作
 * User:LiWenYan
 * Date:2020-07-26
 * Time:20:42
 */
public class UserDao {
    //登陆
    public  User login(User loginUser) {
        User user = null;
        com.mysql.jdbc.Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement("select*from user where username=? and password=?");
            ps.setString(1, loginUser.getUsername());
            ps.setString(2, loginUser.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            DBUtils.getClose(connection, ps, rs);
        }
        return user;
    }

    //注册
    public void register(User user) {
        com.mysql.jdbc.Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement("insert into user values(null,?,?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getGender());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            DBUtils.getClose(connection, ps, null);
        }
    }

    public static void main(String[] args) {
        /*User user = new User();
        user.setUsername("bit");
        user.setPassword("123");
        User loginUser = login(user);
        System.out.println(loginUser);*/
    }
}
