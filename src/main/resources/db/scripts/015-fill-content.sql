DO
$$
    DECLARE
        docker_Patch VARCHAR(50) := '/docker-entrypoint-initdb.d/';
    BEGIN

        --Book genres table
        INSERT INTO books_genres (book_id, genre_id)
        VALUES (1, 7);
        INSERT INTO books_genres (book_id, genre_id)
        VALUES (1, 11);
        INSERT INTO books_genres (book_id, genre_id)
        VALUES (2, 10);
        INSERT INTO books_genres (book_id, genre_id)
        VALUES (2, 2);
        INSERT INTO books_genres (book_id, genre_id)
        VALUES (3, 7);
        INSERT INTO books_genres (book_id, genre_id)
        VALUES (3, 8);
        --------------------------------------------------------------------------------

--Books image table
        INSERT INTO books_image (book_id, image)
        VALUES (1, pg_read_binary_file(CONCAT(docker_Patch,
                                              'images/01' ||
                                              '.Island' ||
                                              '.jpg')));
        INSERT INTO books_image (book_id, image)
        VALUES (2, pg_read_binary_file(CONCAT(docker_Patch,
                                              'images/02' ||
                                              '.World' ||
                                              '.jpg')));
        INSERT INTO books_image (book_id, image)
        VALUES (3, pg_read_binary_file(CONCAT(docker_Patch,
                                              'images/03' ||
                                              '.Shining' ||
                                              '.jpg')));
        --------------------------------------------------------------------------------
--Books content table
        INSERT INTO books_content (book_id, content)
        VALUES (1, pg_read_binary_file(CONCAT(docker_Patch,
                                              'books/02' ||
                                              '.World' ||
                                              '.pdf')));
        INSERT INTO books_content (book_id, content)
        VALUES (2, pg_read_binary_file(CONCAT(docker_Patch,
                                              'books/02' ||
                                              '.World' ||
                                              '.pdf')));
        INSERT INTO books_content (book_id, content)
        VALUES (3, pg_read_binary_file(CONCAT(docker_Patch,
                                              'books/03' ||
                                              '.Shining' ||
                                              '.pdf')));
    END
$$;

