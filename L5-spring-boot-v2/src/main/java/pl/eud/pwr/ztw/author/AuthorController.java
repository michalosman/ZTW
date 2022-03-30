package pl.eud.pwr.ztw.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Autowired
    IAuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<Object> getAuthors() {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id) {
        Author foundAuthor = authorService.getAuthor(id);

        if (foundAuthor != null)
            return new ResponseEntity<>(foundAuthor, HttpStatus.OK);
        else
            return new ResponseEntity<>("Author with given ID not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authors")
    public ResponseEntity<Object> addAuthor(@RequestBody Author newAuthor) {
        return new ResponseEntity<>(authorService.addAuthor(newAuthor), HttpStatus.OK);
    }

    @PutMapping("/authors")
    public ResponseEntity<Object> updateAuthor(@RequestBody Author author) {
        Author updatedAuthor = authorService.updateAuthor(author);

        if (updatedAuthor != null)
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        else
            return new ResponseEntity<>("Author with given ID not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") int id) {
        boolean isDeleted = authorService.deleteAuthor(id);

        if (isDeleted)
            return new ResponseEntity<>("Author deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Author with given ID not found", HttpStatus.NOT_FOUND);
    }
}