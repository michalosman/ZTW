package pl.eud.pwr.ztw.books;

public class Borrow {
    int client;
    int book;

    public Borrow(int client, int book) {
        this.client = client;
        this.book = book;
    }
    public int getClient() {
        return client;
    }

    public int getBook() {
        return book;
    }
}
