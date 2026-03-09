package vod.repository.mem;

import vod.model.Book;
import vod.model.Bookstore;
import vod.model.Author;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Bookstore> bookstores = new ArrayList<>();

    static List<Author> authors = new ArrayList<>();

    static List<Book> books = new ArrayList<>();

    static {

        Author smarzowski = new Author(1, "Wojciech", "Smarzowski");
        Author vega = new Author(2, "Patryk", "Vega");
        Author wajda = new Author(3, "Andrzej", "Wajda");
        Author skolimowski = new Author(4, "Jerzy", "Skolimowski");

        Book wolyn = new Book(1, "Wolyn", "https://ocdn.eu/pulscms-transforms/1/D0gk9kuTURBXy8zYzFhMDRhZS1jOGRiLTQxN2YtOTcwYy1iNjRjZDBkMjc4MDYuanBlZ5GTBc0DFM0BvIGhMAU", smarzowski, (float) 4.1);
        Book wesele = new Book(2, "Wesele", "https://fwcdn.pl/fpo/40/98/124098/7521214.6.jpg", smarzowski, (float) 4.3);

        Book polityka = new Book(3, "Polityka", "https://i.iplsc.com/-/00094J03E94SMPSS-C122.jpg", vega, (float) 3.9);
        Book pitbul = new Book(4, "Pitbul", "https://bi.im-g.pl/im/5b/9b/12/z19510363V,-Pitbull--Nowe-porzadki---rez--Patryk-Vega--plakat.jpg", vega, (float) 3.1);

        Book katyn = new Book(5, "Katyn", "http://www.gokmichalowo.pl/imprezy2007/katyn/plakat_maly.jpg", wajda, (float) 4.7);
        Book tatarak = new Book(6, "Tatarak", "http://gapla.fn.org.pl/public/cache/P21829-483x700.jpg", wajda, (float) 4.4);

        Book essential = new Book(7, "Essential killing", "https://m.media-amazon.com/images/M/MV5BNTE5NjAxMTEzNl5BMl5BanBnXkFtZTcwMjYzMDQ0Ng@@._V1_UX182_CR0,0,182,268_AL_.jpg", skolimowski, (float) 4.9);
        Book ferdydurke = new Book(8, "Ferdydurke", "http://gapla.fn.org.pl/public/cache/P19423-483x700.jpg", skolimowski, (float) 4.3);

        bind(wolyn, smarzowski);
        bind(wesele, smarzowski);

        bind(polityka, vega);
        bind(pitbul, vega);

        bind(katyn, wajda);
        bind(tatarak, wajda);

        bind(essential, skolimowski);
        bind(ferdydurke, skolimowski);

        Bookstore kinoteka = new Bookstore(1, "Kinoteka", "https://www.kinoteka.pl/img/logo.png");
        Bookstore podBaranami = new Bookstore(2, "Kino pod Baranami", "http://www.festiwalfilmuniemego.pl/wp-content/uploads/2015/11/Kino-pod-Baranami.png");
        Bookstore noweHoryzonty = new Bookstore(3, "Kino Nowe Horyzonty", "https://i2.wp.com/garretreza.pl/wp-content/uploads/2018/07/nh.jpg");
        Bookstore zak = new Bookstore(4, "Kino Zak", "https://static2.s-trojmiasto.pl/zdj/c/n/19/2276/250x0/2276445.jpg");

        bind(kinoteka, wesele);
        bind(noweHoryzonty, wesele);
        bind(noweHoryzonty, wolyn);
        bind(noweHoryzonty, polityka);

        bind(kinoteka, tatarak);
        bind(zak, tatarak);
        bind(zak, essential);
        bind(podBaranami, essential);
        bind(podBaranami, polityka);

        books.add(wolyn);
        books.add(wesele);
        books.add(polityka);
        books.add(pitbul);
        books.add(katyn);
        books.add(tatarak);
        books.add(essential);
        books.add(ferdydurke);

        authors.add(smarzowski);
        authors.add(vega);
        authors.add(wajda);
        authors.add(skolimowski);

        bookstores.add(kinoteka);
        bookstores.add(podBaranami);
        bookstores.add(noweHoryzonty);
        bookstores.add(zak);

    }

    private static void bind(Bookstore c, Book m) {
        c.addBook(m);
        m.addBookstore(c);
    }

    private static void bind(Book m, Author d) {
        d.addBook(m);
        m.setAuthor(d);
    }

}
