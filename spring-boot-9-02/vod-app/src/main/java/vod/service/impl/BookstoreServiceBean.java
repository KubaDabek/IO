package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import vod.model.Bookstore;
import vod.model.Book;
import vod.repository.BookstoreDao;
import vod.repository.BookDao;
import vod.service.BookstoreService;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class BookstoreServiceBean implements BookstoreService {

    private static final Logger log = Logger.getLogger(BookstoreService.class.getName());

    private BookstoreDao bookstoreDao;
    private BookDao bookDao;

    public BookstoreServiceBean(BookstoreDao bookstoreDao, BookDao bookDao) {
        log.info("creating bookstore service bean");
        this.bookstoreDao = bookstoreDao;
        this.bookDao = bookDao;
    }

    @Override
    public Bookstore getBookstoreById(int id) {
        log.info("searching bookstore by id " + id);
        return bookstoreDao.findById(id);
    }

    @Override
    public List<Book> getBooksInBookstore(Bookstore c) {
        log.info("searching books played in bookstore " + c.getId());
        return bookDao.findByBookstore(c);
    }

    @Override
    public List<Bookstore> getAllBookstores() {
        log.info("searching all bookstores");
        return bookstoreDao.findAll();
    }

    @Override
    public List<Bookstore> getBookstoresByBook(Book m) {
        log.info("searching bookstores by book " + m.getId());
        return bookstoreDao.findByBook(m);
    }

    @Override
    public Bookstore addBookstore(Bookstore bookstore) {
        log.info("adding new bookstore " + bookstore);
        return bookstoreDao.save(bookstore);
    }

}
