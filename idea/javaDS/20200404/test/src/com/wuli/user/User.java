package com.wuli.user;

import com.wuli.book.BookList;
import com.wuli.operation.IOperation;

abstract public class User {
    public String name;
    //这个数组当中保存每个对象对应的操作
    public IOperation[] Operations;
    public User(String name) {
        this.name = name;
    }
    //如果没有这个方法，那么不可以通过user来访问这个这个方法
    public abstract int menu();
    public void doOperation(int choice, BookList bookList) {
        // Operations[choice]==>拿到的是数组当中元素的对象
        // Operations[choice].work(bookList)通过.号调用对应 的操作方法
        Operations[choice].work(bookList);
    }
}
