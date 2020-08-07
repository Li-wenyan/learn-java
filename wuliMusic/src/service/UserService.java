package service;

import dao.UserDao;
import entity.User;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-07-29
 * Time:10:20
 */
public class UserService {
    public User login(User loginUser) {
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }

}
