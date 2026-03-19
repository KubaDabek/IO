package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Book;
import vod.model.Bookstore;
import vod.repository.BookstoreDao;

import java.util.List;

@Repository
public class JpaBookstoreDao implements BookstoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bookstore> findAll() {
        return entityManager
                .createQuery("select b from Bookstore b")
                .getResultList();
    }

    @Override
    public Bookstore findById(int id) {
        return entityManager.find(Bookstore.class, id);
    }

    @Override
    public List<Bookstore> findByBook(Book b) {
        return entityManager
                .createQuery("select b from Bookstore b inner join b.books book where book=:book")
                .setParameter("book", b)
                .getResultList();
    }

    @Override
    public Bookstore save(Bookstore bookstore) {
        entityManager.persist(bookstore);
        return bookstore;
    }
}