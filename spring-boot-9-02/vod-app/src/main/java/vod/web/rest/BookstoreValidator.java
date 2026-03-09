package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Bookstore;
import vod.service.BookstoreService;

@Component
@RequiredArgsConstructor
public class BookstoreValidator implements Validator {

    private final BookstoreService bookstoreService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Bookstore.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Bookstore validatedBookstore = (Bookstore) target;

        boolean duplicated = bookstoreService.getAllBookstores().stream()
                .anyMatch(bookstore -> bookstore.getName()
                        .equalsIgnoreCase(validatedBookstore.getName()));

        if (duplicated) {
            errors.rejectValue("name", "bookstore.name.duplicated");
        }
    }
}