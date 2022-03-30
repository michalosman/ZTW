package pl.eud.pwr.ztw.books;

import org.springframework.stereotype.Service;
import pl.eud.pwr.ztw.author.Author;
import pl.eud.pwr.ztw.author.AuthorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BooksService implements IBooksService {
    private static final List<Book> booksRepo = new ArrayList<>();
    private static final AuthorService authorService = new AuthorService();

    static {
        booksRepo.add(new Book(1, "Potop", authorService.getAuthor(1), 936));
        booksRepo.add(new Book(2, "Wesele", authorService.getAuthor(2), 150));
        booksRepo.add(new Book(3, "Dziady", authorService.getAuthor(3), 292));
    }

    @Override
    public Collection<Book> getBooks() {
        return booksRepo;
    }

    @Override
    public Book getBook(int id) {
        return booksRepo.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElse(null);
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

        if (bookToUpdate != null) {
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
}