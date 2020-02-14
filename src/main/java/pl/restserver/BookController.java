package pl.restserver;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getList() {
        return bookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable long id) {
        bookService.updateBook(book, id);
    }

}



/*  przed stworzeniem interface'u BookService:

    private final MemoryBookService bookService;
    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }*/




/*    @GetMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }*/





    /*public int listCount(List<Book> list) {
        int listcounter = 1;
        Iterator<Book> iterator = list.iterator();
        while (iterator.hasNext()) {
            listcounter++;
        }
        return listcounter;
    }*/

