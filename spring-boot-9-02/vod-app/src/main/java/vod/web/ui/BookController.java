package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Author;
import vod.model.Book;
import vod.model.Bookstore;
import vod.service.BookService;
import vod.service.BookstoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookstoreService bookstoreService;
    private final BookService bookService;

    @GetMapping("/books")
    String getBooks(Model model,
                    @RequestParam(value = "bookstoreId", required = false) Integer bookstoreId,
                    @RequestParam(value = "authorId", required = false) Integer authorId) {
        log.info("about to display books list, bookstoreId={}, authorId={}", bookstoreId, authorId);
        if (bookstoreId != null) {
            Bookstore bookstore = bookstoreService.getBookstoreById(bookstoreId);
            List<Book> books = bookstoreService.getBooksInBookstore(bookstore);
            model.addAttribute("books", books);
            model.addAttribute("title", "Books in '" + bookstore.getName() + "'");
        } else if (authorId != null) {
            Author author = bookService.getAuthorById(authorId);
            List<Book> books = bookService.getBooksByAuthor(author);
            model.addAttribute("books", books);
            model.addAttribute("title", "Books by '" + author.getLastName() + "'");
        } else {
            List<Book> books = bookService.getAllBooks();
            model.addAttribute("books", books);
            model.addAttribute("title", "Books");
        }
        return "booksView";
    }

    @GetMapping("/authors")
    String getAuthors(Model model,
                      @RequestParam(value = "authorId", required = false) Integer authorId) {
        log.info("about to display authors list, authorId={}", authorId);
        if (authorId != null) {
            Author author = bookService.getAuthorById(authorId);
            List<Author> authors = List.of(author);
            model.addAttribute("authors", authors);
            model.addAttribute("title", "Author: '" + author.getLastName() + "'");
        } else {
            List<Author> authors = bookService.getAllAuthors();
            model.addAttribute("authors", authors);
            model.addAttribute("title", "Authors");
        }
        return "authorsView";
    }
}