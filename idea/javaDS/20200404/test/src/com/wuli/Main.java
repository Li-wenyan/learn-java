package com.wuli;

import com.wuli.book.BookList;
import com.wuli.user.AdminUser;
import com.wuli.user.NormalUser;
import com.wuli.user.User;

import java.util.Scanner;

public class Main {
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你的姓名：");
        String name = scanner.nextLine();
        System.out.println("输入你的身份：1-》管理员  0：普通用户");
        int num = scanner.nextInt();
        if(num == 1) {
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        //1，准备书籍
        BookList bookList = new BookList();
        //2，登录  user是对应的管理员或者普通用户
        User user = login();
        while(true) {
            int choice = user.menu();
            //3,根据你的选择，确定调用哪个操作方法
            user.doOperation(choice,bookList);
        }

    }
}
