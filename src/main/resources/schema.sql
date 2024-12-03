
    CREATE TABLE IF NOT EXISTS users (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255),
        email VARCHAR(255) UNIQUE);

    CREATE TABLE IF NOT EXISTS orders (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        status VARCHAR(255),
        user_id BIGINT,
        FOREIGN KEY (user_id) REFERENCES users(id));

    CREATE TABLE IF NOT EXISTS products (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255),
        price DOUBLE,
        order_id BIGINT,
        FOREIGN KEY (order_id) REFERENCES orders(id));