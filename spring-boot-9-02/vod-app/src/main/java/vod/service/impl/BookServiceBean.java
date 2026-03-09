package vod.service.impl;

import org.springframework.stereotype.Service;
import vod.model.Author;
import vod.model.Book;
import vod.repository.BookstoreDao;
import vod.repository.AuthorDao;
import vod.repository.BookDao;
import vod.model.Bookstore;
import vod.service.BookService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServiceBean implements BookService {

    private static final Logger log = Logger.getLogger(BookService.class.getName());

    private AuthorDao authorDao;
    private BookstoreDao bookstoreDao;
    private BookDao bookDao;

    public BookServiceBean(AuthorDao authorDao, BookstoreDao bookstoreDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookstoreDao = bookstoreDao;
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks() {
        log.info("searching all books...");
        return bookDao.findAll();
    }

    public List<Book> getBooksByAuthor(Author d) {
        log.info("serching books by author " + d.getId());
        return bookDao.findByAuthor(d);
    }

    public List<Book> getMoviesInCinema(Bookstore c) {
        log.info("searching books placed in bookstore " + c.getId());
        return bookDao.findByBookstore(c);
    }

    public Book getBookById(int id) {
        log.info("searching book by id " + id);
        return bookDao.findById(id);
    }

    public List<Bookstore> getAllBookstores() {
        log.info("searching all bookstores");
        return bookstoreDao.findAll();
    }

    public List<Bookstore> getBookstoresByBook(Book m) {
        log.info("searching bookstores by book " + m.getId());
        return bookstoreDao.findByBook(m);
    }

    public Bookstore getBookstoreById(int id) {
        log.info("searching bookstore by id " + id);
        return bookstoreDao.findById(id);
    }

    public List<Author> getAllAuthors() {
        log.info("searching all authors");
        return authorDao.findAll();
    }

    public Author getAuthorById(int id) {
        log.info("searching author by id " + id);
        return authorDao.findById(id);
    }

    @Override
    public Book addBook(Book m) {
        log.info("about to add book " + m);
        return bookDao.add(m);
    }

    @Override
    public Author addAuthor(Author d) {
        log.info("about to add author " + d);
        return authorDao.add(d);
    }

}