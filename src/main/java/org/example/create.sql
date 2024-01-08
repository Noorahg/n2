CREATE TABLE donuts (
                        id BIGINT PRIMARY KEY,
                        flavor VARCHAR(255),
                        price DECIMAL(10, 2)

);
INSERT INTO donuts (id, flavor, price) VALUES (1, 'Глазированный', 2.99);
INSERT INTO donuts (id, flavor, price) VALUES (2, 'Шоколадный', 3.49);
INSERT INTO donuts (id, flavor, price) VALUES (3, 'Клубничный', 2.79);




CREATE TABLE customers (
                           id BIGINT PRIMARY KEY,
                           name VARCHAR(255),
                           wallet DECIMAL(10, 2)

);


INSERT INTO customers (id, name, wallet) VALUES (1, 'Иван Иванов', 50.0);
INSERT INTO customers (id, name, wallet) VALUES (2, 'Мария Сидорова', 75.5);
INSERT INTO customers (id, name, wallet) VALUES (3, 'Алексей Петров', 30.25);




CREATE TABLE stores (
                        id BIGINT PRIMARY KEY,
                        revenue DECIMAL(10, 2)
);


INSERT INTO stores (id, revenue) VALUES (1, 1000.0);
INSERT INTO stores (id, revenue) VALUES (2, 1500.5);
INSERT INTO stores (id, revenue) VALUES (3, 800.75);