DROP table IF exists `carro` cascade;
DROP table IF exists `cliente` cascade;
DROP table IF exists `vaga` cascade;

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
                          `endereco` VARCHAR(255) NOT NULL,
                          `telefone` VARCHAR(255) NOT NULL,
                          `mensalista` boolean NOT NULL
);
CREATE TABLE `vaga`(
                       `id` INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `cod_vaga` VARCHAR(255) NOT NULL,
                       `carro_id` INT NOT NULL,
                       `coberta` boolean NOT NULL
);
ALTER TABLE
    `carro` ADD CONSTRAINT `carro_idcliente_foreign` FOREIGN KEY(`cliente_id`) REFERENCES `cliente`(`id`);
ALTER TABLE
    `vaga` ADD CONSTRAINT `vaga_idcarro_foreign` FOREIGN KEY(`carro_id`) REFERENCES `carro`(`id`);