INSERT INTO users.accounts (username, password, email, created_on)
VALUES ('vzahnitko', '1111', 'MARS', now());

INSERT INTO users.roles (role_name)
VALUES ('ADMIN');

INSERT INTO users.account_roles (user_id, role_id, grant_date)
VALUES (1, 1, now());