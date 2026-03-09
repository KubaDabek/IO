package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Cinema;
import vod.service.CinemaService;

@Component
@RequiredArgsConstructor
public class CinemaValidator implements Validator {

    private final CinemaService cinemaService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Cinema.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cinema validatedCinema = (Cinema) target;

        boolean duplicated = cinemaService.getAllCinemas().stream()
                .anyMatch(cinema -> cinema.getName()
                        .equalsIgnoreCase(validatedCinema.getName()));

        if (duplicated) {
            errors.rejectValue("name", "cinema.name.duplicated");
        }
    }
}