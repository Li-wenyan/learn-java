package com.bit.operation;

import com.bit.book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 10:34
 */
public class DelOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");

    }
}
