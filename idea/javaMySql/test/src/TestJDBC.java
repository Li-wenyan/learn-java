
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //1.创建DataSource 对象 (DataSource对象生命周期应该是要跟随整个程序的)
        DataSource dataSource = new MysqlDataSource();
        //接下来需要针对DataSource进行一些配置，以便后面能够顺利的访问到数据库服务器，
        // 主要配置三方面信息：URL，User， Password，需要进行向下转型
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("liwenyan");

        //2.和数据库建立连接.建立连接好了之后就可以进行后续的数据传输了
        // 建立连接的意义是为了验证当前的网络通信是否正常
        // 如果不正常，就会抛出一个SQLException异常
        //connection 对象生命周期应该是较短的，每个请求创建一个新的connection
        Connection connection = dataSource.getConnection();

        //3.拼装一个SQL语句，用到 PrepareStatement对象
        //先以插入数据为例
        int id = 1;
        String name = "曹操";
        int classId = 10;
        //?是一个占位符，可以把具体的值替换到？位置
        String sql = "insert into student values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, classId);
        System.out.println("statement: " + statement);

        //4.拼装完毕之后，可以执行SQL了
        //   insert  delete   update  都使用executeUpdate方法来执行
        //    select  使用executeQuery来执行
        //  返回值表示此次操作修改了多少行
        int ret = statement.executeUpdate();
        System.out.println("ret: " + ret);

        //5.执行完毕之后，关闭释放相关资源
        // 一定是后创建的先被释放，顺序不能搞错
        statement.close();
        connection.close();

    }
}
