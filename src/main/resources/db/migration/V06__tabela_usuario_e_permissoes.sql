CREATE TABLE usuario (
	id BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	id BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	usuario_id BIGINT(20) NOT NULL,
	permissao_id BIGINT(20) NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES usuario(id),
	FOREIGN KEY (permissao_id) REFERENCES permissao(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (id, nome, email, senha) values (1, 'Administrador', 'admin@dentalclinic.com', '$2a$10$DF4T2HI0BP5gx7luZDwrxO0TBrC.oF03kot7v1mIgbdP7os.0.RrW');
INSERT INTO usuario (id, nome, email, senha) values (2, 'Secretaria', 'secretaria@dentalclinic.com', '$2a$10$z3TopQ5hOm3.sh2ZNKzGVeCXxGJQYIll1Tdo5Fe3a3c3c7lDQcBX2');

INSERT INTO permissao (id, descricao) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissao (id, descricao) values (3, 'ROLE_CADASTRAR_PACIENTE');
INSERT INTO permissao (id, descricao) values (4, 'ROLE_REMOVER_PACIENTE');
INSERT INTO permissao (id, descricao) values (5, 'ROLE_PESQUISAR_PACIENTE');

INSERT INTO permissao (id, descricao) values (6, 'ROLE_CADASTRAR_TITULO');
INSERT INTO permissao (id, descricao) values (7, 'ROLE_REMOVER_TITULO');
INSERT INTO permissao (id, descricao) values (8, 'ROLE_PESQUISAR_TITULO');

-- admin
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 1);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 2);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 3);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 4);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 5);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 6);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 7);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (1, 8);

-- maria
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (2, 2);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (2, 5);
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (2, 8);