
    CREATE TABLE IF NOT EXISTS user (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255),
        email VARCHAR(255) UNIQUE
    );

    CREATE TABLE IF NOT EXISTS order (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        status VARCHAR(255),
        user_id BIGINT FOREIGN KEY REFERENCES user(id)
    );

    CREATE TABLE IF NOT EXISTS product (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255),
        price DOUBLE,
        order_id BIGINT FOREIGN KEY REFERENCES order(id)
    );