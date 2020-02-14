package pl.restserver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "1453875115", "The Dunwich Horror And Others", "H. P. Lovecraft",
                "CreateSpace Independent Publishing Platform", "Horror"));
        list.add(new Book(2L, "9781616614317", "Android Novel: Strange Flesh",
                "Matthew Farrer ", "Fantasy Flight Games", "Sci-fi"));
        list.add(new Book(3L, "0312536631", "The Forever War",
                "Joe Haldemann", "St. Martin's Griffin;", "Sci-fi"));
    }

    public List<Book> getList() {
        return list;
    }

    public Book getBook(long id) {
        return list.stream().filter(b -> b.getId() == id).findAny().get();
    }

    public void addBook(Book book) {
        this.list.add(book);
    }

    public void deleteBook(long id) {
        this.list = this.list.stream().filter(b -> b.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(Book book, long id) {
        getBook(id).setIsbn(book.getIsbn());
        getBook(id).setTitle(book.getTitle());
        getBook(id).setAuthor(book.getAuthor());
        getBook(id).setPublisher(book.getPublisher());
        getBook(id).setType(book.getType());
    }

}
