package pl.eud.pwr.ztw.books;

import java.util.ArrayList;

public class Bookshelf {
    private int bookLimit = 100;
    private String genre;
    private String name;
    private ArrayList<BookshelfPosition> books;

    public Bookshelf(String genre, String name) {
        this.genre = genre;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(BookshelfPosition book) {
        this.books.add(book);
    }
    public BookshelfPosition updateBook(BookshelfPosition bookPos){
        BookshelfPosition bookPosToUpdate = books.stream()
                .filter(b -> b.getId() == bookPos.getId())
                .findAny()
                .orElse(null);

        if(bookPosToUpdate != null) {
            bookPosToUpdate.setBook(bookPos.getBook());
            bookPosToUpdate.setCount(bookPos.getCount());
        }

        return bookPosToUpdate;
    }
    public boolean deleteBook(int id){
        return books.removeIf(b -> b.getId() == id);
    }
    public boolean borrowBook(int bookId){
        BookshelfPosition pos = books.stream()
                .filter(b -> b.getBook() == bookId)
                .findAny()
                .orElse(null);

        if(pos != null) {
            if (pos.getCount() >0){
                pos.setCount(pos.getCount()-1);
                return true;
            }
        }

        return false;
    }
    public boolean restoreBook(int bookId){
        BookshelfPosition pos = books.stream()
                .filter(b -> b.getBook() == bookId)
                .findAny()
                .orElse(null);

        if(pos != null) {
                pos.setCount(pos.getCount()+1);
                return true;
        }
        return false;
    }

}
