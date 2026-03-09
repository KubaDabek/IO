package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Cinema;
import vod.model.Movie;
import vod.service.CinemaService;
import vod.service.MovieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class CinemaRest {

    private final CinemaService cinemaService;
    private final MovieService movieService;

    // GET wszystkie kina (z opcjonalnymi parametrami)
    @GetMapping("/cinemas")
    List<Cinema> getCinemas(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie) {

        log.info("about to retrieve cinemas list");
        log.info("phrase param: {}", phrase);
        log.info("custom header param: {}", customHeader);
        log.info("some cookie value: {}", someCookie);
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        log.info("{} cinemas found", cinemas.size());
        return cinemas;
    }

    // GET kino po ID
    @GetMapping("/cinemas/{id}")
    ResponseEntity<Cinema> getCinema(@PathVariable("id") int id) {
        log.info("about to retrieve cinema {}", id);
        Cinema cinema = cinemaService.getCinemaById(id);
        log.info("cinema found: {}", cinema);
        if (cinema != null) {
            return ResponseEntity.status(200).body(cinema);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // GET kina grające dany film
    @GetMapping("/movies/{movieId}/cinemas")
    ResponseEntity<List<Cinema>> getCinemasPlayingMovie(
            @PathVariable("movieId") int movieId) {

        log.info("about to retrieve cinemas playing movie {}", movieId);
        Movie movie = movieService.getMovieById(movieId);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Cinema> cinemas = cinemaService.getCinemasByMovie(movie);
            log.info("there's {} cinemas playing movie {}",
                    cinemas.size(), movie.getTitle());
            return ResponseEntity.ok(cinemas);
        }
    }

    // POST — dodaj nowe kino
    @PostMapping("/cinemas")
    ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
        log.info("about to add new cinema {}", cinema);
        // TODO validation
        cinema = cinemaService.addCinema(cinema);
        log.info("new cinema added {}", cinema);
        return ResponseEntity.status(HttpStatus.CREATED).body(cinema);
    }
}