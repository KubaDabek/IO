package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Author;
import vod.model.Book;
import vod.model.Bookstore;
import vod.repository.BookDao;

import java.util.List;

@Repository
public class JpaBookDao implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager
                .createQuery("select b from Book b")
                .getResultList();
    }

    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findByAuthor(Author d) {
        return entityManager
                .createQuery("select b from Book b where b.author=:author")
                .setParameter("author", d)
                .getResultList();
    }

    @Override
    public List<Book> findByBookstore(Bookstore c) {
        return entityManager
                .createQuery("select b from Book b inner join b.bookstores bookstore where bookstore=:bookstore")
                .setParameter("bookstore", c)
                .getResultList();
    }

    @Override
    public Book add(Book m) {
        entityManager.persist(m);
        return m;
    }
}