--Roles table
-- 1
INSERT INTO roles (name, is_active)
VALUES ('admin', true);
-- 2
INSERT INTO roles (name, is_active)
VALUES ('moderator', true);
-- 3
INSERT INTO roles (name, is_active)
VALUES ('user', true);

--------------------------------------------------------------------------------
--Users table
-- 1
INSERT INTO users (login, password, role_id, is_active)
VALUES ('admin', 'admin', 1 , true);
-- 2
INSERT INTO users (login, password, role_id, is_active)
VALUES ('moderator', 'moderator', 2, true);
-- 3
INSERT INTO users (login, password, role_id, is_active)
VALUES ('user', 'user', 3, true );