package vod.repository;

import vod.model.Cinema;
import vod.model.Director;
import vod.model.Movie;

import java.util.List;
import java.util.Set;

public interface MovieDao {

    List<Movie> findAll();

    Movie findById(int id);

    List<Movie> findByDirector(Director d);

    List<Movie> findByCinema(Cinema c);

    Movie add(Movie m);

}
