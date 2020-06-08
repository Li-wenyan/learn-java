package com.wuli.operation;

import com.wuli.book.Book;
import com.wuli.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的图书");
        String name = scanner.nextLine();
        int curSize = bookList.getUsedSize();
        int pos = 0;
        int i;
        for ( i = 0; i <curSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                pos = i;
                break;
            }
        }
        if(i == curSize) {
            System.out.println("没有这本书！");
            return;
        }
        //开始删除
        for(int j = pos;j < curSize-1;j++) {
            Book book = bookList.getBook(j+1);
            bookList.setBooks(j,book);
        }
        bookList.setUsedSize(curSize-1);
        System.out.println("删除书籍成功！");
    }
}
