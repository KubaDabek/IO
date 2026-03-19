CREATE TABLE `bookstore`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `logo` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `author`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `firstname` varchar(255) NOT NULL,
    `lastname`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `book`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `poster`    varchar(255) NOT NULL,
    `rating`    float DEFAULT NULL,
    `title`     varchar(255) NOT NULL,
    `author_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `book_bookstore`
(
    `book_id`      int DEFAULT NULL,
    `bookstore_id` int DEFAULT NULL
);

INSERT INTO `bookstore`(`id`, `logo`, `name`)
VALUES ('1', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Multikino_logo.png/1198px-Multikino_logo.png',
        'Empik');
INSERT INTO `bookstore`(`id`, `logo`, `name`)
VALUES ('2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Imax.svg/330px-Imax.svg.png', 'Matras');
INSERT INTO `bookstore`(`id`, `logo`, `name`)
VALUES ('3', 'https://www.cinema-city.pl/xmedia/img/10103/logo.svg', 'BookWorld');

INSERT INTO `author`(`id`, `firstname`, `lastname`)
VALUES ('1', 'Stephen', 'King');
INSERT INTO `author`(`id`, `firstname`, `lastname`)
VALUES ('2', 'J.K.', 'Rowling');
INSERT INTO `author`(`id`, `firstname`, `lastname`)
VALUES ('3', 'J.R.R.', 'Tolkien');

INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('1', 'https://static.posters.cz/image/750webp/73584.webp', '9.1', 'The Shining', '1');
INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('2', 'https://fwcdn.pl/fpo/01/79/179/7710998.6.jpg', '8.5', 'It', '1');
INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('3', 'https://fwcdn.pl/fpo/12/15/1215/6918508.6.jpg', '9.5', 'Harry Potter', '2');
INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('4', 'https://upload.wikimedia.org/wikipedia/en/0/05/Vicky_Cristina_Barcelona_film_poster.png', '8.8',
        'Fantastic Beasts', '2');
INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('5', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Manhattan-poster01.jpg/220px-Manhattan-poster01.jpg',
        '9.8', 'The Lord of the Rings', '3');
INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('6', 'https://fwcdn.pl/fpo/13/26/1326/7635628.6.jpg', '9.2', 'The Hobbit', '3');
INSERT INTO `book`(`id`, `poster`, `rating`, `title`, `author_id`)
VALUES ('7', 'https://fwcdn.pl/fpo/19/97/441997/7239460.6.jpg', '8.7', 'The Silmarillion', '3');

INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('1', '1');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('1', '3');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('2', '3');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('3', '1');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('3', '2');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('4', '1');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('4', '3');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('5', '2');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('5', '3');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('6', '1');
INSERT INTO `book_bookstore`(`book_id`, `bookstore_id`)
VALUES ('7', '2');

CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');

INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');