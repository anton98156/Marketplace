CREATE TABLE IF NOT EXISTS productTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    description varchar(50) NOT NULL,
    price INT NOT NULL,
    stock BOOLEAN NOT NULL
);