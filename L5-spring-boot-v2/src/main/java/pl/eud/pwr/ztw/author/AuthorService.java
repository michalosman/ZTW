package pl.eud.pwr.ztw.author;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    private static final List<Author> authorsRepo = new ArrayList<>();

    static {
        authorsRepo.add(new Author(1, "Henryk", "Sienkiewicz"));
        authorsRepo.add(new Author(2, "Stanisław", "Reymont"));
        authorsRepo.add(new Author(3, "Adam", "Mickiewicz"));
    }

    @Override
    public Collection<Author> getAuthors() {
        return authorsRepo;
    }

    @Override
    public Author getAuthor(int id) {
        return authorsRepo.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Author addAuthor(Author newAuthor) {
        newAuthor.setId(authorsRepo.size() + 1);
        authorsRepo.add(newAuthor);
        return newAuthor;
    }

    @Override
    public Author updateAuthor(Author author) {
        Author authorToUpdate = authorsRepo.stream()
                .filter(a -> a.getId() == author.getId())
                .findAny()
                .orElse(null);

        if (authorToUpdate != null) {
            authorToUpdate.setFirstName(author.getFirstName());
            authorToUpdate.setLastName(author.getLastName());
        }

        return authorToUpdate;
    }

    @Override
    public boolean deleteAuthor(int id) {
        return authorsRepo.removeIf(a -> a.getId() == id);
    }
}