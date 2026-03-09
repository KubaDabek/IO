package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.CinemaDao;
import vod.model.Cinema;
import vod.model.Movie;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("cinemaDao")
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

    @Override
    public Cinema save(Cinema cinema) {
        int maxId = SampleData.cinemas.stream()
                .sorted((c1, c2) -> c2.getId() - c1.getId())
                .findFirst()
                .map(c -> c.getId())
                .orElse(0);
        cinema.setId(maxId + 1);
        SampleData.cinemas.add(cinema);
        return cinema;
    }

}
