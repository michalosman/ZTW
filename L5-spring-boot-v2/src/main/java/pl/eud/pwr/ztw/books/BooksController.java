package pl.eud.pwr.ztw.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {
    @Autowired
    IBooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<Object> getBooks() {
        return new ResponseEntity<>(booksService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") int id) {
        Book foundBook = booksService.getBook(id);

        if (foundBook != null)
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody Book newBook) {
        return new ResponseEntity<>(booksService.addBook(newBook), HttpStatus.OK);
    }

    @PutMapping("/books")
    public ResponseEntity<Object> updateBook(@RequestBody Book book) {
        Book updatedBook = booksService.updateBook(book);

        if (updatedBook != null)
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id) {
        boolean isDeleted = booksService.deleteBook(id);

        if (isDeleted)
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Book with given ID not found", HttpStatus.NOT_FOUND);
    }
}