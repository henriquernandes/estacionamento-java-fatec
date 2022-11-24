DROP table IF exists `carro` cascade;
DROP table IF exists `cliente` cascade;
DROP table IF exists `vaga` cascade;

CREATE TABLE `carro`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `modelocarro` VARCHAR(255) NOT NULL,
    `marcacarro` VARCHAR(255) NOT NULL,
    `anocarro` VARCHAR(255) NOT NULL,
    `placacarro` VARCHAR(255) NOT NULL,
    `cliente_id` INT NOT NULL
);
CREATE TABLE `cliente`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nomecliente` VARCHAR(255) NOT NULL,
    `enderecocliente` VARCHAR(255) NOT NULL,
    `telefonecliente` VARCHAR(255) NOT NULL,
    `mensalista` boolean NOT NULL
);
CREATE TABLE `vaga`(
    `id` INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `codvaga` VARCHAR(255) NOT NULL,
    `carro_id` INT NOT NULL,
    `vagacoberta` boolean NOT NULL
);
ALTER TABLE
    `carro` ADD CONSTRAINT `carro_idcliente_foreign` FOREIGN KEY(`cliente_id`) REFERENCES `cliente`(`id`);
    ALTER TABLE
    `vaga` ADD CONSTRAINT `vaga_idcarro_foreign` FOREIGN KEY(`carro_id`) REFERENCES `carro`(`id`);