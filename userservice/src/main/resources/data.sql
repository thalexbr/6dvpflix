DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(250) NOT NULL
);
INSERT INTO tbl_user (name) VALUES
('Thales Gomes'),
('Helton Lustosa'),
('Jailson Silva'),
('Edilson Almeida');
