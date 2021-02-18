package com.ssafy;

public class BookManager {
    private static BookManager instance;
    public static BookManager getInstance() {
        if(instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    private int  idx;
    private Book[] book;

    BookManager() {
        book = new Book[100];
        idx = 0;
    }

    public void addBook(String title, String ISBN, String author, String publisher, int price, String desc) {
        Book b = new Book();

        b.setTitle(title);
        b.setISBN(ISBN);
        b.setAuthor(author);
        b.setPublisher(publisher);
        b.setPrice(price);
        b.setDesc(desc);

        book[idx] = b;
        idx++;
    }

    public void removeBook(String ISBN) {
        for(int i = 0; i < idx; i++){
            if(book[i].getISBN().equals(ISBN)) {
                for(int j = i + 1; j < idx; j++) {
                    book[j-1] = book[j];
                }
            }
        }

        idx--;
    }

    public Book[] getList() {
        Book[] b = new Book[idx];

        for(int i = 0; i < idx; i++) {
            b[i] = book[i];
        }

        return b;
    }

    public Book searchByISBN(String ISBN) {
        for(int i = 0; i < idx; i++) {
            if(book[i].getISBN().equals(ISBN)) {
                return book[i];
            }
        }
        return null;
    }
}

