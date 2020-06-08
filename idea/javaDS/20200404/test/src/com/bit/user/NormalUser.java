package com.bit.user;

import com.bit.operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 10:43
 */
public class NormalUser extends User{


    public NormalUser(String name) {
        super(name);
        //普通用户的对应操作
        this.Operations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello"+ this.name +" 欢迎来到Java16班图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("0.退出系统");
        int choice = scanner.nextInt();
        return choice;
    }

}
