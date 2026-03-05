package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.repository.CinemaDao;
import vod.repository.MovieDao;
import vod.repository.mem.MemCinemaDao;
import vod.repository.mem.MemMovieDao;
import vod.model.Cinema;
import vod.service.impl.CinemaServiceBean;

import java.util.List;
import java.util.Set;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find cinemas!");
        CinemaDao cinemaDao = new MemCinemaDao();
        MovieDao movieDao = new MemMovieDao();

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        //CinemaService service = new CinemaServiceBean(cinemaDao, movieDao);
        CinemaService service = context.getBean(CinemaService.class);
        CinemaService service2 = context.getBean(CinemaService.class);


        List<Cinema> cinemas = service.getAllCinemas();
        System.out.println(cinemas.size() + " cinemas found:");
        cinemas.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
