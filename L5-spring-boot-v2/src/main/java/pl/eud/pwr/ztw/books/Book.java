package pl.eud.pwr.ztw.books;

import pl.eud.pwr.ztw.author.Author;

public class Book {

    private int id;
    private int pages;
    private String title;
    private Author author;

    public Book(int id, String title, Author author, int pages) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
