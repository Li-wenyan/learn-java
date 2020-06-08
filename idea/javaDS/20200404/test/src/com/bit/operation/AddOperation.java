package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 10:34
 */
public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者：");
        String  author = scanner.nextLine();
        System.out.println("请输入图书的价格：");
        int price  = scanner.nextInt();
        System.out.println("请输入图书的类型:");
        String type = scanner.next();//java    bia

        Book book = new Book(name,author,price,type);
        int curSize = bookList.getUsedSize();
        //xxxxxxxxxxxxxxxxxxxxxxxxxx
        bookList.setBooks(curSize,book);
        bookList.setUsedSize(curSize+1);
        System.out.println("新增图书成功！");
    }

}
