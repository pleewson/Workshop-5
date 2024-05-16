package project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.Models.Book;
import project.Models.MockBookService;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private MockBookService bookService;

    @Autowired
    public BookController(MockBookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        System.out.println("JSON - came");
        try {
            bookService.add(book);
            return ResponseEntity.ok().body("Book added succesfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding book: " + e.getMessage());
        }
    }


    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }


    @GetMapping("/getBook/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable("id") Long id) {
        for (Book book : bookService.getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }


    @PutMapping("/updateBook/{id}")
    public Book updateBookById(@RequestBody Book updatedBook, @PathVariable("id") Long id) {
        bookService.getBooks().sort(Comparator.comparing(Book::getId));
        int index;
        for (Book book : bookService.getBooks()) {
            if (book.getId().equals(id)) {
                int bookIndex = bookService.getBooks().indexOf(book);
                bookService.getBooks().set(bookIndex, updatedBook);
            }
        }
        return null;
    }


    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        for(Book book : bookService.getBooks()){
            if(book.getId().equals(id)){
                bookService.getBooks().remove(book);
                return ResponseEntity.ok().body("Deleted book with id " + id);
            }
        }
        return ResponseEntity.badRequest().body("Problem with delete");
    }
}
