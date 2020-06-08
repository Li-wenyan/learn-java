package com.bit;

import com.bit.book.BookList;
import com.bit.user.AdminUser;
import com.bit.user.NormalUser;
import com.bit.user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 10:52
 */
public class Main {

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你的姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入你的身份：1-》管理员 0：普通用户");
        int num = scanner.nextInt();
        if(num == 1) {
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        //准备书籍
        BookList bookList = new BookList();
        //2、登录   user是对应的管理元  或者 普通用户
        User user = login();

        while (true) {
            int choice = user.menu();//0
            //3、根据你的选择  确定调用那个操作方法
            user.doOperation(choice, bookList);
        }
    }


}
