package com.github.unithon.unithon.model;

import java.io.Serializable;

public class SearchInfo implements Serializable {
    private String title;
    private String link;
    private String image;
    private String author;
    private String price;
    private String discount;
    private String publisher;
    private String pubdate;
    private String isbn;
    private String description;

    public SearchInfo(String title, String link, String image, String author, String price, String discount, String publisher,
    String pubdate, String isbn, String description)
    {
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.isbn = isbn;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


//    String model_Image;
//    String model_Bookname;
//    String model_Writer;
//    String model_Code;
//
//    public SearchInfo(String Image, String Bookname, String Writer, String Code) {
//        this.model_Image = Image;
//        this.model_Bookname = Bookname;
//        this.model_Writer = Writer;
//        this.model_Code = Code;
//    }
//
//    public String getModel_Image() {
//        return model_Image;
//    }
//
//    public void setModel_Image(String model_Image) {
//        this.model_Image = model_Image;
//    }
//
//    public String getModel_Bookname() {
//        return model_Bookname;
//    }
//
//    public void setModel_Bookname(String model_Bookname) {
//        this.model_Bookname = model_Bookname;
//    }
//
//    public String getModel_Writer() {
//        return model_Writer;
//    }
//
//    public void setModel_Writer(String model_Writer) {
//        this.model_Writer = model_Writer;
//    }
//
//    public String getMode_Code() {
//        return model_Code;
//    }
//
//    public void setMode_Code(String model_Code) {
//        this.model_Code = model_Code;
//    }
}
