package vod.repository.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Author;
import vod.model.Book;
import vod.model.Bookstore;
import vod.repository.BookDao;

import java.util.List;

@Repository
@Primary
public class DataBookDao implements BookDao {

    private final BookRepository repository;

    public DataBookDao(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findByAuthor(Author d) {
        return repository.findAllByAuthor(d);
    }

    @Override
    public List<Book> findByBookstore(Bookstore c) {
        return repository.findAllByBookstores(c);
    }

    @Override
    public Book add(Book m) {
        return repository.save(m);
    }
}