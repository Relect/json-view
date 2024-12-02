
    INSERT INTO user (name, email) VALUES
    ('user1', 'user1@mail.ru'),
    ('user2', 'user2@mail.ru');

    INSERT INTO order (user_id, status) VALUES
    (1, 'PENDING'),
    (1, 'PENDING'),
    (2, 'COMPLETED');

    INSERT INTO product (order_id, name, price) VALUES
    (1, 'smartphone', 8000.0),
    (2, 'java book', 2000.0),
    (3, 'golang book', 3000.0),
    (3, 'java book', 2000.0);