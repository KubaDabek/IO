package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vod.model.Cinema;
import vod.model.Movie;
import vod.repository.CinemaDao;
import vod.repository.MovieDao;
import vod.service.CinemaService;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class CinemaServiceBean implements CinemaService {

    private static final Logger log = Logger.getLogger(CinemaService.class.getName());

    private CinemaDao cinemaDao;
    private MovieDao movieDao;

    public CinemaServiceBean(CinemaDao cinemaDao, MovieDao movieDao) {
        log.info("creating cinema service bean");
        this.cinemaDao = cinemaDao;
        this.movieDao = movieDao;
    }

    @Override
    public Cinema getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return cinemaDao.findById(id);
    }

    @Override
    public List<Movie> getMoviesInCinema(Cinema c) {
        log.info("searching movies played in cinema " + c.getId());
        return movieDao.findByCinema(c);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        log.info("searching all cinemas");
        return cinemaDao.findAll();
    }

    @Override
    public List<Cinema> getCinemasByMovie(Movie m) {
        log.info("searching cinemas by movie " + m.getId());
        return cinemaDao.findByMovie(m);
    }

}
