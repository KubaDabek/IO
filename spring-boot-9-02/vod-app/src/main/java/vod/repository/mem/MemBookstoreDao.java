package vod.repository.mem;

import org.springframework.stereotype.Repository;
import vod.model.Book;
import vod.model.Bookstore;
import vod.repository.BookstoreDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository("bookstoreDao")
public class MemBookstoreDao implements BookstoreDao {

    @Override
    public List<Bookstore> findAll() {
        return SampleData.bookstores;
    }

    @Override
    public Bookstore findById(int id) {
        return SampleData.bookstores.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Bookstore> findByBook(Book m) {
        return SampleData.bookstores.stream().filter(c -> c.getBooks().contains(m)).collect(Collectors.toList());
    }

    @Override
    public Bookstore save(Bookstore bookstore) {
        int maxId = SampleData.bookstores.stream()
                .sorted((c1, c2) -> c2.getId() - c1.getId())
                .findFirst()
                .map(c -> c.getId())
                .orElse(0);
        bookstore.setId(maxId + 1);
        SampleData.bookstores.add(bookstore);
        return bookstore;
    }

}
