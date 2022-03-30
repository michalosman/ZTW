package pl.eud.pwr.ztw.books;

public class Book {
    int pages;
    private int id;
    private String title;
    private Author author;

//    public Book(int id, String title, Author author, int pages) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.pages = pages;
//    }

    public Book(int id, String title, String author, int pages) {
        this.id = id;
        this.title = title;
        this.author = new Author(author);
        this.pages = pages;
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

    public String getAuthorString() {
        return author.toString();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAuthorByString(String author) {
        this.author = new Author(author);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
