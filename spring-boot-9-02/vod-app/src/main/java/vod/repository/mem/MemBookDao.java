package vod.repository.mem;

import org.springframework.stereotype.Repository;
import vod.model.Author;
import vod.repository.BookDao;
import vod.model.Bookstore;
import vod.model.Book;

import java.util.List;
import java.util.stream.Collectors;

@Repository("bookDao")
public class MemBookDao implements BookDao {
    @Override
    public List<Book> findAll() {
        return SampleData.books;
    }

    @Override
    public Book findById(int id) {
        return SampleData.books.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Book> findByAuthor(Author d) {
        return SampleData.books.stream().filter(m -> m.getAuthor() == d).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByBookstore(Bookstore c) {
        return SampleData.books.stream().filter(m -> m.getBookstores().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Book add(Book m) {
        int max = SampleData.books.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.books.add(m);
        return m;
    }
}
