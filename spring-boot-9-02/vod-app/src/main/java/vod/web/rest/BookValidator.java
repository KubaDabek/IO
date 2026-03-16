package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Author;
import vod.service.BookService;
import vod.web.rest.dto.BookDTO;

@Component
@RequiredArgsConstructor
public class BookValidator implements Validator {
    private final BookService movieService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(BookDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDTO movie = (BookDTO) target;
        Author author = movieService.getAuthorById(movie.getAuthorId());
        if (author == null) {
            errors.rejectValue("authorId", "book.author.missing");
        }
    }
}