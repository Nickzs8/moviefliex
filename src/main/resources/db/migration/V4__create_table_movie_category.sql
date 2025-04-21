CREATE TABLE movie_category (
    movie_id BIGINT UNSIGNED NOT NULL,
    category_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_movie_category_movie FOREIGN KEY (movie_id) REFERENCES movie(id),
    CONSTRAINT fk_movie_category_category FOREIGN KEY (category_id) REFERENCES category(id)
);
