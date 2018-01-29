package com.github.unithon.unithon.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecommendBook implements Serializable {

    private String isbn;
    private String title;
    private String author;
    private String image;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static List<RecommendBook> getDummyRecommendBookList() {
        final List<RecommendBook> recommendBooks = new ArrayList<>();

        for(int i=0; i<5; i++) {
            final RecommendBook recommendBook = new RecommendBook();
            recommendBook.setTitle("title" + i);
            recommendBook.setAuthor("title" + i);
            recommendBook.setImage("http://bookthumb.phinf.naver.net/cover/109/245/10924505.jpg?type=m1&udate=20171007");
            recommendBooks.add(recommendBook);
        }

        return recommendBooks;
    }

}
