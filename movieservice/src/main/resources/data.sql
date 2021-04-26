DROP TABLE IF EXISTS tbl_movie;
CREATE TABLE tbl_movie (
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(250) NOT NULL,
views DOUBLE NOT NULL,
likes DOUBLE NOT NULL
);
INSERT INTO tbl_movie (description, views, likes) VALUES
('Movie 1', 10.00, 0.00),
('Movie 2', 20.00, 0.00),
('Movie 3', 30.00, 0.00),
('Movie 4', 40.00, 0.00),
('Movie 5', 50.00, 0.00),
('Movie 6', 60.00, 0.00),
('Movie 7', 70.00, 0.00),
('Movie 8', 80.00, 0.00),
('Movie 9', 90.00, 0.00),
('Movie 10', 100.00, 0.00);
