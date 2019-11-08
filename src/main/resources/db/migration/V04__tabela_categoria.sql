CREATE TABLE categoria(

id BIGINT(20) NOT NULL AUTO_INCREMENT,
nome VARCHAR(20) NOT NULL,

PRIMARY KEY(id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria(id, nome) VALUES (1, 'Água');
INSERT INTO categoria(id, nome) VALUES (2, 'Luz');
INSERT INTO categoria(id, nome) VALUES (3, 'Internet');
INSERT INTO categoria(id, nome) VALUES (4, 'Produtos');
INSERT INTO categoria(id, nome) VALUES (5, 'Impostos');
INSERT INTO categoria(id, nome) VALUES (6, 'Serviço prestado');
INSERT INTO categoria(id, nome) VALUES (7, 'Funcionários');
