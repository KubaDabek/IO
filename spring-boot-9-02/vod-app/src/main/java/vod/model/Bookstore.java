package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {

    private int id;
    @NotNull
    @Size(min=2, max=20)
    private String name;
    private String logo;
    @JsonIgnore
    private List<Book> books = new ArrayList<>();
    public Bookstore(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Bookstore() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book m) {
        this.books.add(m);
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
