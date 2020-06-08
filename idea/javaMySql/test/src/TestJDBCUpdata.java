import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdata {
    public static void main(String[] args) throws SQLException {
        //让用户输入要修改id 为n的同学的姓名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的学生id： ");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的学生姓名： ");
        String name = scanner.next();

        //1.创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("liwenyan");

        //2.创建连接
        Connection connection = dataSource.getConnection();

        //3.拼装SQL语句
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);

        //4.执行SQL
        int ret = statement.executeUpdate();
        if(ret == 1) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        //5.关闭资源
        statement.close();
        connection.close();
    }
}
