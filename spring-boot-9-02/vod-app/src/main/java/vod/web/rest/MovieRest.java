package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Cinema;
import vod.model.Movie;
import vod.service.CinemaService;
import vod.service.MovieService;
import vod.web.rest.dto.MovieDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class MovieRest {

    private final CinemaService cinemaService;
    private final MovieService movieService;

    // GET wszystkich filmów
    @GetMapping("/movies")
    List<Movie> getMovies() {
        log.info("about to retrieve movies list");
        List<Movie> movies = movieService.getAllMovies();
        log.info("{} movies found", movies.size());
        return movies;
    }

    // GET film po id
    @GetMapping("/movies/{id}")
    ResponseEntity<Movie> getMovie(@PathVariable("id") int id) {
        log.info("about to retrieve movie {}", id);
        Movie movie = movieService.getMovieById(id);
        log.info("movie found: {}", movie);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // GET filmy grane w kinie
    @GetMapping("/cinemas/{cinemaId}/movies")
    ResponseEntity<List<Movie>> getMoviesPlayedAtCinema(
            @PathVariable("cinemaId") int cinemaId) {
        log.info("about to retrieve movies playing at cinema {}", cinemaId);
        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        if (cinema == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Movie> movies = cinemaService.getMoviesInCinema(cinema);
            log.info("there's {} movies played at cinema {}", movies.size(), cinema.getName());
            return ResponseEntity.ok(movies);
        }
    }

    // POST - dodaj nowy film
    @PostMapping("/movies")
    ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO) {
        log.info("about to add new movie {}", movieDTO);
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setPoster(movieDTO.getPoster());
        movie.setRating(movieDTO.getRating());
        movie.setDirector(movieService.getDirectorById(movieDTO.getDirectorId()));

        movie = movieService.addMovie(movie);
        log.info("new movie added: {}", movie);

        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + movie.getId())
                                .build()
                                .toUri())
                .body(movie);
    }
}