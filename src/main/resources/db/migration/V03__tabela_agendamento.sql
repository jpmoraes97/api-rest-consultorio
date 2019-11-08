CREATE TABLE agendamento (

id BIGINT(20) AUTO_INCREMENT,
data DATE NOT NULL,
horario TIME NOT NULL,
paciente_id BIGINT NOT NULL,
profissional_id BIGINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY(paciente_id) REFERENCES paciente(id),
FOREIGN KEY(profissional_id) REFERENCES profissional(id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (1, '2019-10-10', '20:30:00', 1 ,1);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (2, '2019-10-11', '20:30:00', 2 ,2);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (3, '2019-10-12', '20:30:00', 3 ,3);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (4, '2019-10-13', '20:30:00', 4 ,4);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (5, '2019-10-14', '20:30:00', 5 ,5);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (6, '2019-10-15', '20:30:00', 6 ,6);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (7, '2019-10-16', '20:30:00', 7 ,7);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (8, '2019-10-17', '20:30:00', 8 ,8);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (9, '2019-10-18', '20:30:00', 9 ,9);
INSERT INTO agendamento(id, data, horario, paciente_id, profissional_id) VALUES (10, '2019-10-19', '20:30:00', 10 ,10);