package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Book;
import vod.model.Bookstore;
import vod.repository.BookstoreDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataBookstoreDao implements BookstoreDao {

    private final BookstoreRepository repository;

    @Override
    public List<Bookstore> findAll() {
        return repository.findAll();
    }

    @Override
    public Bookstore findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Bookstore> findByBook(Book b) {
        return repository.findAllByBook(b);
    }

    @Override
    public Bookstore save(Bookstore bookstore) {
        return repository.save(bookstore);
    }
}