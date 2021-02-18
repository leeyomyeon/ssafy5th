package com.ssafy;

public class Book {
    private String ISBN;
    private String Author;
    private String Publisher;
    private String title;
    private String desc;
    private int price;

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }
    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        String str = ISBN + "\t\t| "  + title + "\t\t| " +
                Author + "\t\t| " + Publisher + "\t\t| " + price
                + "\t\t| " + desc;
        return str;
    }
}

