CREATE TABLE titulo (
id BIGINT(20) NOT NULL AUTO_INCREMENT,
tipo VARCHAR(7) NOT NULL,
descricao VARCHAR(40) NOT NULL,
data_pagamento DATE,
data_vencimento DATE NOT NULL,
categoria_id BIGINT NOT NULL,
profissional_id BIGINT NOT NULL,
valor NUMERIC NOT NULL,
observacao VARCHAR(50),
PRIMARY KEY(id),
FOREIGN KEY(categoria_id) REFERENCES categoria(id),
FOREIGN KEY(profissional_id) REFERENCES profissional(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(1, 'RECEITA', 'recebimento serviço prestado', '2019-10-14', '2019-10-12', 6, 1, 4300, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(2, 'DESPESA', 'pagamento da conta de água', '2019-10-14', '2019-10-13', 1, 2, 400, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(3, 'DESPESA', 'pagamento da conta de internet', '2019-10-14', '2019-10-15', 3, 3, 150, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(4, 'DESPESA', 'pagamento de produtos encomendados', '2019-10-14', '2019-10-17', 4, 4, 7500, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(5, 'RECEITA', 'recebimento serviço prestado', '2019-10-14', '2019-10-18', 6, 1, 3567, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(6, 'RECEITA', 'recebimento serviço prestado', '2019-10-14', '2019-10-21', 6, 2, 3565, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(7, 'RECEITA', 'recebimento serviço prestado', '2019-10-11', '2019-10-25', 6, 3, 2324, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(8, 'RECEITA', 'recebimento serviço prestado', '2019-10-12', '2019-10-21', 6, 4, 3475, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(9, 'DESPESA', 'pagamento da conta de água', '2019-10-13', '2019-10-10', 1, 1, 400, NULL);
INSERT INTO titulo (id, tipo, descricao, data_pagamento, data_vencimento, categoria_id, profissional_id, valor, observacao)
VALUES(10, 'DESPESA', 'pagamento da conta de luz', '2019-10-15', '2019-10-15', 2, 3, 350, NULL);



