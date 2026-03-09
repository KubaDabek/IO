package vod.service;

import vod.model.Bookstore;
import vod.model.Book;

import java.util.List;

public interface BookstoreService {

    Bookstore getBookstoreById(int id);

    List<Bookstore> getAllBookstores();

    List<Bookstore> getBookstoresByBook(Book m);

    List<Book> getBooksInBookstore(Bookstore c);

    Bookstore addBookstore(Bookstore bookstore);

}
