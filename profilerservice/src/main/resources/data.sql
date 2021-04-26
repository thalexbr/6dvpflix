DROP TABLE IF EXISTS tbl_user_movies;

CREATE TABLE tbl_user_movies (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT DEFAULT NULL,
  movie_id INT DEFAULT NULL,
  liked BOOLEAN DEFAULT FALSE,
  watched BOOLEAN DEFAULT FALSE,
  watch_later BOOLEAN DEFAULT FALSE
);



INSERT INTO tbl_user_movies (user_id, movie_id, liked, watched, watch_later) VALUES
  (1, 1, FALSE, FALSE, FALSE),
  (2, 2, FALSE, TRUE, TRUE),
  (3, 1, FALSE, TRUE, TRUE),
  (3, 2, FALSE, TRUE, FALSE),
  (3, 3, FALSE, TRUE, FALSE),
  (3, 4, TRUE, TRUE, FALSE),
  (4, 1, FALSE, FALSE, TRUE);

