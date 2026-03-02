package vod.repository.mem;

import vod.model.Cinema;
import vod.model.Director;
import vod.model.Movie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SampleData {

    static List<Cinema> cinemas = new ArrayList<>();

    static List<Director> directors = new ArrayList<>();

    static List<Movie> movies = new ArrayList<>();

    static {

        Director smarzowski = new Director(1, "Wojciech", "Smarzowski");
        Director vega = new Director(2, "Patryk", "Vega");
        Director wajda = new Director(3, "Andrzej", "Wajda");
        Director skolimowski = new Director(4, "Jerzy", "Skolimowski");

        Movie wolyn = new Movie(1, "Wolyn", "https://ocdn.eu/pulscms-transforms/1/D0gk9kuTURBXy8zYzFhMDRhZS1jOGRiLTQxN2YtOTcwYy1iNjRjZDBkMjc4MDYuanBlZ5GTBc0DFM0BvIGhMAU", smarzowski, (float) 4.1);
        Movie wesele = new Movie(2, "Wesele", "https://fwcdn.pl/fpo/40/98/124098/7521214.6.jpg", smarzowski, (float) 4.3);

        Movie polityka = new Movie(3, "Polityka", "https://i.iplsc.com/-/00094J03E94SMPSS-C122.jpg", vega, (float) 3.9);
        Movie pitbul = new Movie(4, "Pitbul", "https://bi.im-g.pl/im/5b/9b/12/z19510363V,-Pitbull--Nowe-porzadki---rez--Patryk-Vega--plakat.jpg", vega, (float) 3.1);

        Movie katyn = new Movie(5, "Katyn", "http://www.gokmichalowo.pl/imprezy2007/katyn/plakat_maly.jpg", wajda, (float) 4.7);
        Movie tatarak = new Movie(6, "Tatarak", "http://gapla.fn.org.pl/public/cache/P21829-483x700.jpg", wajda, (float) 4.4);

        Movie essential = new Movie(7, "Essential killing", "https://m.media-amazon.com/images/M/MV5BNTE5NjAxMTEzNl5BMl5BanBnXkFtZTcwMjYzMDQ0Ng@@._V1_UX182_CR0,0,182,268_AL_.jpg", skolimowski, (float) 4.9);
        Movie ferdydurke = new Movie(8, "Ferdydurke", "http://gapla.fn.org.pl/public/cache/P19423-483x700.jpg", skolimowski, (float) 4.3);

        bind(wolyn, smarzowski);
        bind(wesele, smarzowski);

        bind(polityka, vega);
        bind(pitbul, vega);

        bind(katyn, wajda);
        bind(tatarak, wajda);

        bind(essential, skolimowski);
        bind(ferdydurke, skolimowski);

        Cinema kinoteka = new Cinema(1, "Kinoteka", "https://www.kinoteka.pl/img/logo.png");
        Cinema podBaranami = new Cinema(2, "Kino pod Baranami", "http://www.festiwalfilmuniemego.pl/wp-content/uploads/2015/11/Kino-pod-Baranami.png");
        Cinema noweHoryzonty = new Cinema(3, "Kino Nowe Horyzonty", "https://i2.wp.com/garretreza.pl/wp-content/uploads/2018/07/nh.jpg");
        Cinema zak = new Cinema(4, "Kino Zak", "https://static2.s-trojmiasto.pl/zdj/c/n/19/2276/250x0/2276445.jpg");

        bind(kinoteka, wesele);
        bind(noweHoryzonty, wesele);
        bind(noweHoryzonty, wolyn);
        bind(noweHoryzonty, polityka);

        bind(kinoteka, tatarak);
        bind(zak, tatarak);
        bind(zak, essential);
        bind(podBaranami, essential);
        bind(podBaranami, polityka);

        movies.add(wolyn);
        movies.add(wesele);
        movies.add(polityka);
        movies.add(pitbul);
        movies.add(katyn);
        movies.add(tatarak);
        movies.add(essential);
        movies.add(ferdydurke);

        directors.add(smarzowski);
        directors.add(vega);
        directors.add(wajda);
        directors.add(skolimowski);

        cinemas.add(kinoteka);
        cinemas.add(podBaranami);
        cinemas.add(noweHoryzonty);
        cinemas.add(zak);

    }

    private static void bind(Cinema c, Movie m) {
        c.addMovie(m);
        m.addCinema(c);
    }

    private static void bind(Movie m, Director d) {
        d.addMovie(m);
        m.setDirector(d);
    }

}
