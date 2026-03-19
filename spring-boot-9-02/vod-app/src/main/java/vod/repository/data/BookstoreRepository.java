package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Book;
import vod.model.Bookstore;

import java.util.List;

public interface BookstoreRepository extends JpaRepository<Bookstore, Integer> {

    @Query("select b from Bookstore b inner join b.books book where book=:book")
    List<Bookstore> findAllByBook(@Param("book") Book book);
}