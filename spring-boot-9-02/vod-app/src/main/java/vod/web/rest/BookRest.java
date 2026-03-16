package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Book;
import vod.model.Bookstore;
import vod.service.BookstoreService;
import vod.service.BookService;
import vod.web.rest.dto.BookDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class BookRest {

    private final BookstoreService bookstoreService;
    private final BookService bookService;

    @GetMapping("/books")
    List<Book> getMovies() {
        log.info("about to retrieve books list");
        List<Book> books = bookService.getAllBooks();
        log.info("{} books found", books.size());
        return books;
    }

    @GetMapping("/books/{id}")
    ResponseEntity<Book> getMovie(@PathVariable("id") int id) {
        log.info("about to retrieve book {}", id);
        Book book = bookService.getBookById(id);
        log.info("book found: {}", book);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/bookstores/{bookstoreId}/books")
    ResponseEntity<List<Book>> getBooksPlayedAtBookstore(
            @PathVariable("bookstoreId") int bookstoreId) {
        log.info("about to retrieve books placed at bookstore {}", bookstoreId);
        Bookstore bookstore = bookstoreService.getBookstoreById(bookstoreId);
        if (bookstore == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Book> books = bookstoreService.getBooksInBookstore(bookstore);
            log.info("there's {} books played at bookstore {}", books.size(), bookstore.getName());
            return ResponseEntity.ok(books);
        }
    }

    @PostMapping("/books")
    ResponseEntity<?> addBook(@Validated @RequestBody BookDTO bookDTO, Errors errors) {
        log.info("about to add new book {}", bookDTO);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setPoster(bookDTO.getPoster());
        book.setRating(bookDTO.getRating());
        book.setAuthor(bookService.getAuthorById(bookDTO.getAuthorId()));

        book = bookService.addBook(book);
        log.info("new book added: {}", book);

        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + book.getId())
                                .build()
                                .toUri())
                .body(book);
    }
}