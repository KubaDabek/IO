package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.CinemaDao;
import vod.model.Cinema;
import vod.model.Movie;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MemCinemaDao implements CinemaDao {

    @Override
    public List<Cinema> findAll() {
        return SampleData.cinemas;
    }

    @Override
    public Cinema findById(int id) {
        return SampleData.cinemas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Cinema> findByMovie(Movie m) {
        return SampleData.cinemas.stream().filter(c -> c.getMovies().contains(m)).collect(Collectors.toList());
    }
}
