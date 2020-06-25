--Authors table
-- 1
INSERT INTO authors (author_name)
VALUES ('Herbert George Wells');
-- 2
INSERT INTO authors (author_name)
VALUES ('Jules Verne');
-- 3
INSERT INTO authors (author_name)
VALUES ('Stephen King');
-- 4
INSERT INTO authors (author_name)
VALUES ('J.R.R.Tolkien');
-- 5
INSERT INTO authors (author_name)
VALUES ('Niccolo Machiavelli');
-- 6
INSERT INTO authors (author_name)
VALUES ('William Shakespeare');
-- 7
INSERT INTO authors (author_name)
VALUES ('Sir Arthur Conan Doyle');
-- 8
INSERT INTO authors (author_name)
VALUES ('Robert Lafore');
-- 9
INSERT INTO authors (author_name)
VALUES ('Jane Austen');


--------------------------------------------------------------------------------
--Genres table
-- 1
INSERT INTO genres (name)
VALUES ('Biography');
-- 2
INSERT INTO genres (name)
VALUES ('Action & Adventure');
-- 3
INSERT INTO genres (name)
VALUES ('Drama');
-- 4
INSERT INTO genres (name)
VALUES ('Fantasy');
-- 5
INSERT INTO genres (name)
VALUES ('History');
-- 6
INSERT INTO genres (name)
VALUES ('Horror');
-- 7
INSERT INTO genres (name)
VALUES ('Mystery');
-- 8
INSERT INTO genres (name)
VALUES ('Computers & Technology');
-- 9
INSERT INTO genres (name)
VALUES ('Romance');
-- 10
INSERT INTO genres (name)
VALUES ('Science');
-- 11
INSERT INTO genres (name)
VALUES ('Sci-fi');

--------------------------------------------------------------------------------
--Roles table
-- 1
INSERT INTO roles (name)
VALUES ('admin');
-- 2
INSERT INTO roles (name)
VALUES ('moderator');
-- 3
INSERT INTO roles (name)
VALUES ('user');

--------------------------------------------------------------------------------
--Users table
-- 1
INSERT INTO users (login, password, role_id)
VALUES ('admin', 'admin', 1);
-- 2
INSERT INTO users (login, password, role_id)
VALUES ('moderator', 'moderator', 2);
-- 3
INSERT INTO users (login, password, role_id)
VALUES ('user', 'user', 3);


