package pl.eud.pwr.ztw.author;

import java.util.Collection;

public interface IAuthorService {
    public abstract Collection<Author> getAuthors();

    public abstract Author getAuthor(int id);

    public abstract Author addAuthor(Author newAuthor);

    public abstract Author updateAuthor(Author author);

    public abstract boolean deleteAuthor(int id);
}