package vod.service;

import vod.model.Director;
import vod.model.Movie;

import java.util.List;

public interface MovieService {


    List<Movie> getAllMovies();

    List<Movie> getMoviesByDirector(Director d);

    Movie getMovieById(int id);

    Movie addMovie(Movie m);


    List<Director> getAllDirectors();

    Director getDirectorById(int id);

    Director addDirector(Director d);
}
