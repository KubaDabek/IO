package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private String poster;//url
    private Author author;
    private float rating;//rating
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


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book movie = (Book) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", rating=" + rating +
                '}';
    }
}
