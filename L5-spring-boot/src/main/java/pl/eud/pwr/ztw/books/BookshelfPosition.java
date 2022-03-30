package pl.eud.pwr.ztw.books;

public class BookshelfPosition {
    private int id;
    private int book;
    private int count;


    public BookshelfPosition(int id,int book, int count) {
        this.id = id;
        this.book = book;
        this.count = count;
    }
    public void setBook(int book) {
        this.book = book;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getBook() {
        return book;
    }

    public int getCount() {
        return count;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
