package com.github.unithon.unithon.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Review {

    private String isbn;
    private String id;
    private String title;
    private String content;
    @SerializedName("is_like")
    private int isLikeInteger;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsLike() {
        return isLikeInteger;
    }

    public void setIsLike(int isLikeInteger) {
        this.isLikeInteger = isLikeInteger;
    }

    public int getIsLikeInteger() {
        return isLikeInteger;
    }

    public void setIsLikeInteger(int isLikeInteger) {
        this.isLikeInteger = isLikeInteger;
    }

    public boolean isLike() {
        return isLikeInteger == 1;
    }

    public void setLike(boolean like) {
        isLikeInteger = like ? 1 : 0;
    }
}