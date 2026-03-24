package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Author;
import vod.model.Book;
import vod.model.Bookstore;
import vod.repository.BookDao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Repository
@Primary
@RequiredArgsConstructor
public class DataBookDao implements BookDao {

    private final BookRepository repository;

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

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Book add(Book m) {
        return repository.save(m);
    }
}