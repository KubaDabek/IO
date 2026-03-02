package vod.service;

import vod.model.Cinema;
import vod.model.Movie;

import java.util.List;

public interface CinemaService {
//api zwraca nam wszystkie kina
    Cinema getCinemaById(int id);

    List<Cinema> getAllCinemas();

    List<Cinema> getCinemasByMovie(Movie m);

    List<Movie> getMoviesInCinema(Cinema c);

}
