CREATE TABLE profissional (

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

INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(1, 'Andressa Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(2, 'Mariana Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(3, 'Bruna Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(4, 'Fernanda Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(5, 'Giovanna Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(6, 'Maria Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(7, 'Flávia Cristina', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(8, 'Paulo Augusto', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(9, 'Marcos Fernando', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
INSERT INTO profissional(id, nome, rg, cpf, email, telefone, celular , logradouro, numero, complemento, cidade, estado, cep)
VALUES(10, 'Luiz Ricardo', '490974633', '42265878438', 'andressacristina@hotmail.com', '1186788484', '2347877878', 'Rua Mario Trenti', '120', NULL, 'Campinas', 'São Paulo', '13032788');
