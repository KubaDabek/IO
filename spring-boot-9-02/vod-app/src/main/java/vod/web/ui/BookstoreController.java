package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Book;
import vod.model.Bookstore;
import vod.service.BookService;
import vod.service.BookstoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookstoreController {

    private final BookstoreService bookstoreService;
    private final BookService bookService;

    @GetMapping("/bookstores")
    String getBookstores(Model model,
                         @RequestParam(value = "bookId", required = false) Integer bookId) {
        log.info("about to display bookstores list");
        if (bookId != null) {
            Book book = bookService.getBookById(bookId);
            List<Bookstore> bookstores = bookstoreService.getBookstoresByBook(book);
            model.addAttribute("bookstores", bookstores);
            model.addAttribute("title", "Bookstores placing '" + book.getTitle() + "'");
        } else {
            List<Bookstore> bookstores = bookstoreService.getAllBookstores();
            model.addAttribute("bookstores", bookstores);
            model.addAttribute("title", "Bookstores");
        }
        return "bookstoresView";
    }
}