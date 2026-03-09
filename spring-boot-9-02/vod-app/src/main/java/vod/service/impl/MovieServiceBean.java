package vod.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.repository.CinemaDao;
import vod.repository.DirectorDao;
import vod.repository.MovieDao;
import vod.model.Cinema;
import vod.model.Director;
import vod.model.Movie;
import vod.service.MovieService;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class MovieServiceBean implements MovieService {

    private static final Logger log = Logger.getLogger(MovieService.class.getName());

    private DirectorDao directorDao;
    private CinemaDao cinemaDao;
    private MovieDao movieDao;

    public MovieServiceBean(DirectorDao directorDao, CinemaDao cinemaDao, MovieDao movieDao) {
        this.directorDao = directorDao;
        this.cinemaDao = cinemaDao;
        this.movieDao = movieDao;
    }

    public List<Movie> getAllMovies() {
        log.info("searching all movies...");
        return movieDao.findAll();
    }

    public List<Movie> getMoviesByDirector(Director d) {
        log.info("serching movies by diretor " + d.getId());
        return movieDao.findByDirector(d);
    }

    public List<Movie> getMoviesInCinema(Cinema c) {
        log.info("searching movies played in cinema " + c.getId());
        return movieDao.findByCinema(c);
    }

    public Movie getMovieById(int id) {
        log.info("searching movie by id " + id);
        return movieDao.findById(id);
    }

    public List<Cinema> getAllCinemas() {
        log.info("searching all cinemas");
        return cinemaDao.findAll();
    }

    public List<Cinema> getCinemasByMovie(Movie m) {
        log.info("searching cinemas by movie " + m.getId());
        return cinemaDao.findByMovie(m);
    }

    public Cinema getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return cinemaDao.findById(id);
    }

    public List<Director> getAllDirectors() {
        log.info("searching all directors");
        return directorDao.findAll();
    }

    public Director getDirectorById(int id) {
        log.info("searching director by id " + id);
        return directorDao.findById(id);
    }

    @Override
    public Movie addMovie(Movie m) {
        log.info("about to add movie " + m);
        return movieDao.add(m);
    }

    @Override
    public Director addDirector(Director d) {
        log.info("about to add director " + d);
        return directorDao.add(d);
    }

}