CREATE TABLE paciente (

id BIGINT(20) NOT NULL AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
rg VARCHAR(12) NOT NULL,
cpf VARCHAR(12) NOT NULL,
email VARCHAR(50) NOT NULL,
telefone VARCHAR(20) NOT NULL,
celular VARCHAR(20) NOT NULL,
logradouro VARCHAR(50) NOT NULL,
numero VARCHAR(6) NOT NULL,
complemento VARCHAR(30),
cidade VARCHAR(25) NOT NULL,
estado VARCHAR(20) NOT NULL,
cep VARCHAR(10) NOT NULL,
PRIMARY KEY (id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(1, 'João Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(2, 'Bruno Pedro Moraes Santos', '510974632', '45065878425', 'bruno@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(3, 'Jackson Pedro Moraes Santos', '510974632', '45065878425', 'jackson@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(4, 'Jeffersom Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(5, 'Caio Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(6, 'Marcos Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(7, 'Paulo Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(8, 'Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(9, 'João Marcos Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
INSERT INTO paciente(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(10, 'Isaque Pedro Moraes Santos', '510974632', '45065878425', 'joaopedro@hotmail.com', '1984848484', '1987877878', 'Av Saudade', '200', 'Bloco G Apto 2', 'Campinas', 'São Paulo', '13069788');
