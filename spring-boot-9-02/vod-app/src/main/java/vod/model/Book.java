package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String poster;

    private float rating;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "book_bookstore",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bookstore_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Bookstore> bookstores = new ArrayList<>();

    public Book(int id, String title, String poster, Author author, float rating) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.author = author;
        this.rating = rating;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Bookstore> getBookstores() {
        return bookstores;
    }

    public void setBookstores(List<Bookstore> bookstores) {
        this.bookstores = bookstores;
    }

    public void addBookstore(Bookstore c) {
        this.bookstores.add(c);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", rating=" + rating +
                '}';
    }
}