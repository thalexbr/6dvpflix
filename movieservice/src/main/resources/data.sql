DROP TABLE IF EXISTS tbl_movie;
CREATE TABLE tbl_movie (
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(250) NOT NULL,
price DOUBLE NOT NULL
);
INSERT INTO tbl_movie (description, price) VALUES
('Movie 1', 10.00),
('Movie 2', 20.00),
('Movie 3', 30.00),
('Movie 4', 40.00),
('Movie 5', 50.00),
('Movie 6', 60.00),
('Movie 7', 70.00),
('Movie 8', 80.00),
('Movie 9', 90.00),
('Movie 10', 100.00);
