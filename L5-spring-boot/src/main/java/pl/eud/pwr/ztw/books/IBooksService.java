package pl.eud.pwr.ztw.books;

import java.util.Collection;

public interface IBooksService {
    public abstract Collection<Book> getBooks();

    public abstract Book getBook(int id);

    public abstract Book addBook(Book newBook);

    public abstract Book updateBook(Book book);

    public abstract boolean deleteBook(int id);

    public abstract Book updateBookAuthor(int bookId,String author);
}