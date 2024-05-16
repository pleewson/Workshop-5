package project.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {
    private List<Book> list = new ArrayList<>(); // stack books there

    public MockBookService() {
        list.add(new Book("9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        list.add(new Book("9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        list.add(new Book("250", "test1", "test1", "test1", "test"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void add(Book book) {
        list.add(book);
    }

    @Override
    public void delete(Book book) {
    }

    @Override
    public void update(Book book) {

    }
}
