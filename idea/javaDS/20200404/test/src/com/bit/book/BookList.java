package com.bit.book;

/**
 * Created with IntelliJ IDEA.
 * Description:  顺序表
 * User: GAOBO
 * Date: 2020-04-04
 * Time: 10:26
 */
public class BookList {

    private Book[] books;

    private int usedSize;

    public BookList() {
        this.books = new Book[10];
        this.books[0] = new Book("西游记","吴承恩",13,"小说");
        this.books[1] = new Book("三国演义","施耐庵",6,"小说");
        this.books[2] = new Book("水浒传","罗贯中",23,"小说");
        this.usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBook(int pos) {
        return books[pos];
    }

    public void setBooks(int pos,Book book){
        this.books[pos] = book;
    }
}
