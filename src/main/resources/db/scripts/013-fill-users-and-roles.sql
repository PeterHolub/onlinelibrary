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