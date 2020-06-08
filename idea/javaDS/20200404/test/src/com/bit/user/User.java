package com.bit.user;

import com.bit.book.BookList;
import com.bit.operation.IOperation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 10:44
 */
abstract public class User {
    public String name;
    //这个数组当中  保存 每个对象对应的操作
    public IOperation[] Operations;

    public User(String name) {
        this.name = name;
    }

    //如果没有这个方法  那么不可以通过user来访问这个方法
    public abstract  int menu() ;

    public void doOperation(int choice,BookList bookList) {
        //Operations[choice]  ==》拿到的是数组当中元素的对象
        //Operations[choice].work(bookList) 通过.号  调用对应的操作方法
        Operations[choice].work(bookList);
    }
}
