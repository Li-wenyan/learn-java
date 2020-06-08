package com.wuli.operation;

import com.wuli.book.Book;
import com.wuli.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的图书");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println(book);
                System.out.println("找到了这本书！");
                return;
            }
        }
        System.out.println("没有这本书！");
    }
}
