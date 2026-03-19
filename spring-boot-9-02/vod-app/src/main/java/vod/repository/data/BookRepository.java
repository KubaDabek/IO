package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Author;
import vod.model.Book;
import vod.model.Bookstore;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByAuthor(Author author);
    List<Book> findAllByBookstores(Bookstore bookstore);
}