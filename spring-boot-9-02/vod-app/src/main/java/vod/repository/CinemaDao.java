package vod.repository;

import vod.model.Cinema;
import vod.model.Movie;

import java.util.List;
import java.util.Set;

public interface CinemaDao {

    List<Cinema> findAll();

    Cinema findById(int id);

    List<Cinema> findByMovie(Movie m);

}
