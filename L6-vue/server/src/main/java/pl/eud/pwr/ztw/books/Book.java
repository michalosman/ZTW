package pl.eud.pwr.ztw.books;

public class Book {

    private int id;
    private String title;
    private String author;
    private int pages;
    private Boolean read;

    public Book(int id, String title, String author, int pages, Boolean read) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.read = read;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}
