package vod;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Bookstore;
import vod.service.BookstoreService;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final BookstoreService bookstoreService;

    @PostConstruct
    void init() {
        List<Bookstore> bookstores = bookstoreService.getAllBookstores();
        log.info("{} bookstores found.", bookstores.size());
        bookstores.forEach(bookstore -> log.info("{}", bookstore));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Bookstore> bookstores =  bookstoreService.getAllBookstores();
        log.info("{} bookstores found.", bookstores.size());
        bookstores.forEach(bookstore->log.info("{}", bookstore));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {log.info("on context refreshed (from annotated method)");}
}