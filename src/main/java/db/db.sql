create database estacionamento;

use estacionamento;

DROP table IF exists `carro` cascade;
DROP table IF exists `cliente` cascade;
DROP table IF exists `vaga` cascade;
DROP table IF exists `mensalidade` cascade;
DROP table IF exists `endereco` cascade;

CREATE TABLE `carro`(
                        `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        `modelo` VARCHAR(255) NOT NULL,
                        `marca` VARCHAR(255) NOT NULL,
                        `ano` VARCHAR(255) NOT NULL,
                        `placa` VARCHAR(255) NOT NULL,
                        `cliente_id` INT NOT NULL
);
CREATE TABLE `cliente`(
                          `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          `nome` VARCHAR(255) NOT NULL,
                          `telefone` VARCHAR(255) NOT NULL,
                          `mensalista` boolean NOT NULL
);
CREATE TABLE `vaga`(
                       `id` INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `cod_vaga` VARCHAR(255) NOT NULL,
                       `carro_id` INT NOT NULL,
                       `coberta` boolean NOT NULL
);
CREATE TABLE `endereco`(
                       `id` INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `cep` VARCHAR(255) NULL,
                       `endereco` VARCHAR(255) NULL,
                       `numero` VARCHAR(255) NULL,
                       `complemento` VARCHAR(255) NULL,
                       `bairro` VARCHAR(255) NULL,
                       `cidade` VARCHAR(255) NULL,
                       `estado` VARCHAR(255) NULL,
                       `cliente_id` INT NOT NULL
);
CREATE TABLE `mensalidade`(
                       `id` INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `valor` FLOAT(11,2) NOT NULL
);
ALTER TABLE
    `carro` ADD CONSTRAINT `carro_idcliente_foreign` FOREIGN KEY(`cliente_id`) REFERENCES `cliente`(`id`) ON DELETE CASCADE;
ALTER TABLE
    `vaga` ADD CONSTRAINT `vaga_idcarro_foreign` FOREIGN KEY(`carro_id`) REFERENCES `carro`(`id`) ON DELETE CASCADE;
ALTER TABLE
    `endereco` ADD CONSTRAINT `endereco_idcliente_foreign` FOREIGN KEY(`cliente_id`) REFERENCES `cliente`(`id`) ON DELETE CASCADE;

INSERT INTO `mensalidade`(`valor`) VALUES (65.90);