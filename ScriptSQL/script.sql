CREATE DATABASE db_sales;


CREATE USER 'test'@'%' IDENTIFIED BY '123';

GRANT ALL ON *.* TO 'test'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;

USE db_sales;

CREATE TABLE tb_clients (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
rg VARCHAR(100),
-- RG stands for "Registro Geral" in Portuguese and it is a personal identification document in Brazil. It contains the individual's full name, photograph, signature, date of birth, place of birth, and registration number.
cpf VARCHAR(20), 
-- CPF (Cadastro de Pessoas Físicas) is a unique identification number given to Brazilian citizens and resident aliens for tax and social security purposes.
email VARCHAR(200),
phone VARCHAR(30),
mobile VARCHAR(30),
zip_code VARCHAR(100),
address VARCHAR(255),
number INT,
complement VARCHAR(200),
neighborhood VARCHAR(100),
city VARCHAR(100),
state VARCHAR(2)
);

