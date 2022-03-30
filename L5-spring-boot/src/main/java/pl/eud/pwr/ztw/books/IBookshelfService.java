package pl.eud.pwr.ztw.books;

import java.util.ArrayList;
import java.util.Collection;

public interface IBookshelfService {
    public abstract Collection<Book> getBook();
    public abstract Collection<Client> getClient();
    public abstract Collection<Borrow> getBorrow();

    public abstract Book addBook(Book newBook);
    public abstract Book updateBook(Book book);
    public abstract boolean deleteBook(int id);

    public abstract Client addClient(Client newClient);
    public abstract Client updateClient(Client newClient);
    public abstract boolean deleteClient(int id);

    public abstract BookshelfPosition addBookshelfPos(BookshelfPosition newPos);
    public abstract BookshelfPosition updateBookshelfPos(BookshelfPosition newPos);
    public abstract boolean deleteBookshelfPos(int id);

    public boolean borrowBook(int clientId,int bookPosId);
    public boolean restoreBook(int clientId,int bookPosId);

}
