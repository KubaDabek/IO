package vod;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Cinema;
import vod.service.CinemaService;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final CinemaService cinemaService;

    @PostConstruct
    void init() {
        List<Cinema> cinemas = cinemaService.getAllCinemas();
        log.info("{} cinemas found.", cinemas.size());
        cinemas.forEach(cinema -> log.info("{}", cinema));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Cinema> cinemas =  cinemaService.getAllCinemas();
        log.info("{} cinemas found.", cinemas.size());
        cinemas.forEach(cinema->log.info("{}", cinema));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {log.info("on context refreshed (from annotated method)");}
}