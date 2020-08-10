package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 主要实现三个功能：
 * 1，插入用户-注册时使用
 * 2，按名字查找用户-登录时使用
 * 3，按照用户id查找-展示信息时使用
 * User:LiWenYan
 * Date:2020-08-10
 * Time:12:06
 */
public class UserDao {
    public void add(User user) throws OrderSystemException {
        //下面是JDBC编程的基础流程
        //1,先获取和数据库的连接（dataSource）
        Connection connection = DBUtil.getConnection();
        //2，拼装SQL语句(PrepareStatement)
        String sql = "insert into user values(null,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1,user.getPassword());
            statement.setInt(2,user.getIsAdmin());
            statement.setString(3,user.getName());
            //3，执行SQL语句(executeQuery,executeUpdate)
            int ret = statement.executeUpdate();
            if(ret != 1){
                throw new OrderSystemException("插入用户异常");
            }
            System.out.println("插入用户成功");
        }catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入用户异常");
        }finally {
            // 4，关闭连接(close)（如果是查询语句，还需要遍历结果集）.
            DBUtil.close(connection,statement,null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
        //1，获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2，拼装sql
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            //3,执行sql
            resultSet = statement.executeQuery();
            //4，遍历结果集(按照名字查找，只能查找一个记录，要求名字不能重复)
            if (resultSet.next()) {
                User user = new User();
                user.setUesrId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按姓名查找用户失败");
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
    public User selectById(int userId) throws OrderSystemException {
        //1,获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2,拼装sql
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //3，执行sql
            resultSet = statement.executeQuery();
            //4.遍历结果集，userId是主键，不会重复，最多只能查到一条数据
            if(resultSet.next()) {
                User user = new User();
                user.setUesrId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按id查找用户失败");
        }finally {
            //5，断开连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //这个方法中进行UserDao的单元测试
    public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();
        //1.验证插入数据
        User user = new User();
        user.setName("liwenyan");
        user.setPassword("123456");
        user.setIsAdmin(0);
        userDao.add(user);
        //2，验证按照名字查找数据
        user = userDao.selectByName("liwenyan");
        System.out.println("按照名字查找");
        System.out.println(user);

        user = userDao.selectById(1);
        System.out.println("按照id查找");
        System.out.println(user);
    }
}
