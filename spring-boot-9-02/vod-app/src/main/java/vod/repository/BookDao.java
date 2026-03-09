package vod.repository;

import vod.model.Book;
import vod.model.Bookstore;
import vod.model.Author;

import java.util.List;

public interface BookDao {

    List<Book> findAll();

    Book findById(int id);

    List<Book> findByAuthor(Author d);

    List<Book> findByBookstore(Bookstore c);

    Book add(Book m);

}
