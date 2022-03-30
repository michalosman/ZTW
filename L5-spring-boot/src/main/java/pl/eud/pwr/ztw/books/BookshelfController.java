package pl.eud.pwr.ztw.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookshelfController {
    @Autowired
    IBookshelfService bookshelfService;

    @GetMapping("bookshelf/books")
    public ResponseEntity<Object> getBooks() {
        return new ResponseEntity<>(bookshelfService.getBook(), HttpStatus.OK);
    }
    @GetMapping("bookshelf/clients")
    public ResponseEntity<Object> getClients() {
        return new ResponseEntity<>(bookshelfService.getClient(), HttpStatus.OK);
    }
    @GetMapping("bookshelf/borrows")
    public ResponseEntity<Object> getBorrows() {
        return new ResponseEntity<>(bookshelfService.getBorrow(), HttpStatus.OK);
    }
    @PostMapping("bookshelf/books")
    public ResponseEntity<Object> addBook(@RequestBody Book newBook) {
        return new ResponseEntity<>(bookshelfService.addBook(newBook), HttpStatus.OK);
    }

    @PutMapping("bookshelf/books")
    public ResponseEntity<Object> updateBook(@RequestBody Book book) {
        Book updatedBook = bookshelfService.updateBook(book);

        if(updatedBook != null)
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("bookshelf/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id) {
        boolean isDeleted = bookshelfService.deleteBook(id);

        if(isDeleted == true)
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }
    @PostMapping("bookshelf/client")
    public ResponseEntity<Object> addClient(@RequestBody Client newBook) {
        return new ResponseEntity<>(bookshelfService.addClient(newBook), HttpStatus.OK);
    }

    @PutMapping("bookshelf/client")
    public ResponseEntity<Object> updateClient(@RequestBody Client book) {
        Client updatedBook = bookshelfService.updateClient(book);

        if(updatedBook != null)
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        else
            return new ResponseEntity<>("Client with given ID not found", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("bookshelf/client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable("id") int id) {
        boolean isDeleted = bookshelfService.deleteClient(id);

        if(isDeleted == true)
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }
    @PostMapping("bookshelf/pos")
    public ResponseEntity<Object> addBookshelfPos(@RequestBody BookshelfPosition newBook) {
        return new ResponseEntity<>(bookshelfService.addBookshelfPos(newBook), HttpStatus.OK);
    }

    @PutMapping("bookshelf/pos")
    public ResponseEntity<Object> updaeBookshelfPos(@RequestBody BookshelfPosition book) {
        BookshelfPosition updatedBook = bookshelfService.updateBookshelfPos(book);

        if(updatedBook != null)
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        else
            return new ResponseEntity<>("Client with given ID not found", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("bookshelf/pos/{id}")
    public ResponseEntity<Object> deleteBookshelfPos(@PathVariable("id") int id) {
        boolean isDeleted = bookshelfService.deleteBookshelfPos(id);

        if(isDeleted == true)
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }
    @PostMapping("bookshelf/borrow/")
    public ResponseEntity<Object> borrow(@RequestBody Borrow book) {
        return new ResponseEntity<>(bookshelfService.borrowBook(book.getClient(),book.getBook()), HttpStatus.OK);
    }
    @PostMapping("bookshelf/restore/")
    public ResponseEntity<Object> restore(@RequestBody Borrow book) {
        return new ResponseEntity<>(bookshelfService.restoreBook(book.getClient(),book.getBook()), HttpStatus.OK);
    }

}
