package pl.restserver;

import java.util.List;

public interface BookService {

    List<Book> getList();

    Book getBook(long id);

    public void addBook(Book book);

    public void deleteBook(long id);

    public void updateBook(Book book, long id);

}
