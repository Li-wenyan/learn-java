package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 操作订单
 * 1，新增订单
 * 2，查看所有订单
 * 3，查看指定用户订单
 * 4，查看指定订单的详细信息
 * 5，修改订单状态（订单是否已经完成）
 * User:LiWenYan
 * Date:2020-08-10
 * Time:16:30
 */
public class OrderDao {
    //新增订单
    //订单是和两个表关联的
    // 第一个表是order_user(数据库中由于名字冲突，把所有的order换成了dingdan)
    // 第二个表是order_dish，一个订单中可能涉及点多个菜，
    // 就需要给这个表中一次性插入多条记录。
    public void add(Order order) throws OrderSystemException {
        //1,先操作order_user表
        addOrderUser(order);
        //2，再操作order_dish表
        //执行add这个方法的时候，order对象中的orderId字段还是空着的
        //这个字段要交给数据库，由自增主键来决定
        addOrderDish(order);
    }

    private void addOrderUser(Order order) throws OrderSystemException {
        //1.先获取到数据库连接
        Connection connection = DBUtil.getConnection();
        //2,拼装sql
        String sql = "insert into dingdan_user values(null,?,now(),0)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //加上RETURN_GENERATED_KEYS这个选项，插入的同时就会把数据库自动生成的自增主键的值获取到
            statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1,order.getUserId());
            //3,执行sql
            int ret = statement.executeUpdate();
            if(ret != 1) {
                throw new OrderSystemException("插入订单失败");
            }
            //把自增主键的值读出来
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                //读取resultSet的结果时，可以使用列名，也可以使用下标
                //由于一个表中的自增列可以有多个，返回的时候都返回回来了
                //就表示想获取到第一个自增列生成的值
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("插入订单第一步成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入订单失败");
        }finally {
            //4，关闭连接
            DBUtil.close(connection,statement,resultSet);
        }
    }

    //把菜品信息插入到order_dish表中
    private void addOrderDish(Order order) throws OrderSystemException {
        //1,获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2，拼装sql
        String sql = "insert into dingdan_dish values(?, ?)";
        PreparedStatement statement = null;
        try {
            //3,关闭自动提交SQL语句
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            //由于一个订单对应到多个菜单，就需要遍历Order中包含的菜品数组，把每个记录都取出来
            //4,遍历dishes给SQL添加多个values的值
            List<Dish> dishes = order.getDishes();
            for(Dish dish : dishes) {
                //OrderId是在刚刚进行插入order_user表的时候,获取到的自增主键
                statement.setInt(1,order.getOrderId());
                statement.setInt(2,dish.getDishId());
                statement.addBatch();//给sql新增一个片段
            }
            // 5，执行sql（并不是真的执行）
            statement.executeBatch();//把刚才的sql进行执行
            //6，真正执行（发给服务器）commit可以去执行多个SQL，一次调用commit统一发给服务器
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //如果上面的操作出现异常，就认为整体的新增订单操作失败，回滚之前的插入order_user表的内容
            deleteOrderUser(order.getOrderId());
        }finally {
            // 7，关闭连接.
            DBUtil.close(connection,statement,null);
        }
    }

    //这个方法用于删除order_user表中的记录
    private void deleteOrderUser(int orderId) throws OrderSystemException {
        //1,获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2，拼装sql
        String sql = "delete from dingdan_user where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            // 3,执行sql
            int ret = statement.executeUpdate();
            if(ret != 1) {
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("回滚失败");
        }finally {
            // 4，关闭连接,
            DBUtil.close(connection,statement,null);
        }
    }

    //获取到所有的订单信息
    //Order对象里，有一些OrderId，userId这些属性，直接借助order_user表就获取到了
    //还有一个重要的属性，dishes（List<Dish>）
    // 详细信息需要先根据order_dish表，获取到所有的相关的dishId，然后根据dishId去dishes表中查.
    //这里的订单获取不需要那么详细的内容，只获取到订单的一些基本信息就行了
    //菜品信息，有一个查看指定订单详细信息的接口
    //当前这个接口返回的Order对象中，不包含dishes详细数据
    //这样代码就可以更简单，更高效了
    public List<Order> selectAll() {
        List<Order> orders = new ArrayList<>();
        //1,获取到数据库连接
        Connection connection = DBUtil.getConnection();
        //2,拼装sql
        String sql = "selecr * from dingdan_user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            // 3，执行sql
            resultSet = statement.executeQuery();
            //4,遍历结果集
            while(resultSet.next()) {
                //此时order对象中，没有dishes字段
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 5，关闭连接,
            DBUtil.close(connection,statement,resultSet);
        }
        return orders;
    }


    public List<Order> selectByUserId (int userId) {
        List<Order> orders = new ArrayList<>();
        //1,获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2，拼装sql
        String sql = "select * from dingdan_user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            // 3，执行sql
            resultSet = statement.executeQuery();
            // 4，遍历结果集
            while(resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5，关闭连接。
            DBUtil.close(connection,statement,resultSet);
        }
        return orders;
    }

    //这个方法中就要把这个Order对象完整的填写进去
    //包括Order中有哪些菜品，以及菜品的详情
    // 此处使用多次查询的方式完成，除此之外，
    // 也可以使用多表查询（sql语句会更复杂，但java代码会更简单一点）.
    public Order selectById(int orderId) throws OrderSystemException {
        //1,先根据orderId得到一个Order对象
        Order order = buildOrder(orderId);
        //2,根据orderId得到该orderId对应的菜品id列表
        List<Integer> dishIds = selectDishIds(orderId);
        // 3，根据菜品id列表，查询dishes表，获取到菜品详情.
        order = getDishDetail(order,dishIds);
        return order;
    }

    //根据OrderId来查询对应的Order对象的基本信息
    //查找order_user表
    private Order buildOrder(int orderId) {
        //1,获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2，拼装sql
        String sql = "select * from dingdan_user where orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            // 3，执行sql
            resultSet = statement.executeQuery();
            // 4，遍历结果集
            if(resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 5，关闭连接.
            DBUtil.close(connection,statement,resultSet);
        }
        return null;

    }

    //查找order_dish表
    private List<Integer> selectDishIds(int orderId) {
        List<Integer> dishIds = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from dingdan_dish where orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dishIds.add(resultSet.getInt("dishId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return dishIds;
    }

    private Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException {
        //1,准备好要返回的结果
        List<Dish> dishes = new ArrayList<>();
        //2,遍历dishIds在dishes表中查
        DishDao dishDao = new DishDao();
        for (Integer dishId : dishIds) {
            Dish dish = dishDao.selectById(dishId);
            dishes.add(dish);
        }
        //3,把dishes设置到order对象中
        order.setDishes(dishes);
        return order;
    }

    public void changeState(int orderId, int isDone) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "update dingdan_user set isDone = ? where orderId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,isDone);
            statement.setInt(2,orderId);
            int ret = statement.executeUpdate();
            if(ret != 1) {
                throw new OrderSystemException("修改订单状态失败");
            }
            System.out.println("修改订单状态成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单状态失败");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
}
