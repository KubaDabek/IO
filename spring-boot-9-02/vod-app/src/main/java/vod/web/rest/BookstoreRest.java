package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Book;
import vod.model.Bookstore;
import vod.service.BookstoreService;
import vod.service.BookService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class BookstoreRest {

    private final BookstoreService bookstoreService;
    private final BookService bookService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/bookstores")
    List<Bookstore> getBookstores(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie) {

        log.info("about to retrieve bookstores list");
        log.info("phrase param: {}", phrase);
        log.info("custom header param: {}", customHeader);
        log.info("some cookie value: {}", someCookie);

        if (phrase != null && phrase.equals("foo")) {
            throw new IllegalArgumentException("Foo!");
        }

        List<Bookstore> bookstores = bookstoreService.getAllBookstores();
        log.info("{} bookstores found", bookstores.size());
        return bookstores;
    }

    @GetMapping("/bookstores/{id}")
    ResponseEntity<Bookstore> getBookstore(@PathVariable("id") int id) {
        log.info("about to retrieve bookstore {}", id);
        Bookstore bookstore = bookstoreService.getBookstoreById(id);
        log.info("bookstore found: {}", bookstore);
        if (bookstore != null) {
            return ResponseEntity.status(200).body(bookstore);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/books/{bookId}/bookstores")
    ResponseEntity<List<Bookstore>> getCinemasPlayingMovie(
            @PathVariable("bookId") int bookId) {

        log.info("about to retrieve bookstores placed book {}", bookId);
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Bookstore> bookstores = bookstoreService.getBookstoresByBook(book);
            log.info("there's {} bookstores placing book {}",
                    bookstores.size(), book.getTitle());
            return ResponseEntity.ok(bookstores);
        }
    }

    @PostMapping("/bookstores")
    ResponseEntity<?> addBookstore(
            @Validated @RequestBody Bookstore bookstore,
            Errors errors,
            HttpServletRequest request) {

        log.info("about to add new bookstore {}", bookstore);

        if (errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe -> messageSource.getMessage(oe, locale))
                    .reduce("errors:\n", (accu, oe) -> accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }

        bookstore = bookstoreService.addBookstore(bookstore);
        log.info("new bookstore added {}", bookstore);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookstore);
    }
}