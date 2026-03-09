package vod.repository;

import vod.model.Book;
import vod.model.Bookstore;

import java.util.List;

public interface BookstoreDao {

    List<Bookstore> findAll();

    Bookstore findById(int id);

    List<Bookstore> findByBook(Book m);

    Bookstore save(Bookstore bookstore);

}
