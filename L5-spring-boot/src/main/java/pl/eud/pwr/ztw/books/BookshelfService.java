package pl.eud.pwr.ztw.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class BookshelfService implements IBookshelfService{
    private static List<Book> booksRepo = new ArrayList<>();
    private static List<Client> clientRepo = new ArrayList<>();
    private static List<Borrow> borrowRepo = new ArrayList<>();
    private static Bookshelf bookshelf = new Bookshelf("fantastyka","regal 1");
    static {
        booksRepo.add(new Book(1, "Potop", "Henryk Sienkiewicz", 936));
        booksRepo.add(new Book(2, "Wesele", "Stanisław Reymont", 150));
        booksRepo.add(new Book(3, "Dziady", "Adam Mickiewicz", 292));

        clientRepo.add(new Client(1,"Jan Nowak"));
        clientRepo.add(new Client(2,"Jan Kowalski"));
        clientRepo.add(new Client(3,"Adam Nowak"));

        bookshelf.addBook(new BookshelfPosition(1,1,10));

        borrowRepo.add(new Borrow(1,1));
    }
    @Override
    public Collection<Book> getBook() {
        return booksRepo;
    }
    @Override
    public Collection<Client> getClient() {
        return clientRepo;
    }
    @Override
    public Collection<Borrow> getBorrow() {
        return borrowRepo;
    }

    @Override
    public Book addBook(Book newBook) {
        newBook.setId(booksRepo.size() + 1);
        booksRepo.add(newBook);
        return newBook;
    }

    @Override
    public Book updateBook(Book book) {
        Book bookToUpdate = booksRepo.stream()
                .filter(b -> b.getId() == book.getId())
                .findAny()
                .orElse(null);

        if(bookToUpdate != null) {
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setPages(book.getPages());
        }

        return bookToUpdate;
    }

    @Override
    public boolean deleteBook(int id) {
        return booksRepo.removeIf(b -> b.getId() == id);
    }

    @Override
    public Client addClient(Client newClient) {
        newClient.setId(clientRepo.size() + 1);
        clientRepo.add(newClient);
        return newClient;
    }

    @Override
    public Client updateClient(Client newClient) {
        Client clientToUpdate = clientRepo.stream()
                .filter(b -> b.getId() == newClient.getId())
                .findAny()
                .orElse(null);

        if(clientToUpdate != null) {
            clientToUpdate.setName(newClient.getName());
        }

        return clientToUpdate;
    }

    @Override
    public boolean deleteClient(int id) {
        return clientRepo.removeIf(b -> b.getId() == id);
    }

    @Override
    public BookshelfPosition addBookshelfPos(BookshelfPosition newPos) {
        newPos.setId(clientRepo.size() + 1);
        bookshelf.addBook(newPos);
        return newPos;
    }

    @Override
    public BookshelfPosition updateBookshelfPos(BookshelfPosition newPos) {
        return bookshelf.updateBook(newPos);
    }

    @Override
    public boolean deleteBookshelfPos(int id) {
        return bookshelf.deleteBook(id);
    }

    @Override
    public boolean borrowBook(int clientId, int bookPosId) {
        Borrow b = new Borrow(clientId,bookPosId);
        boolean state = bookshelf.borrowBook(bookPosId);
        if (state)
            borrowRepo.add(b);
        return state;
    }

    @Override
    public boolean restoreBook(int clientId, int bookPosId) {
        boolean state = bookshelf.restoreBook(bookPosId);
        if(state)
            borrowRepo.removeIf(b ->(b.getClient() == clientId && b.getBook() == bookPosId));
        return state;
    }
}
