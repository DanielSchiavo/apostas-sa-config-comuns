CREATE TABLE usuarios_roles (
	usuario_cpf CHAR(14) NOT NULL,
	data_atribuicao TIMESTAMP NOT NULL,
	role VARCHAR(20) NOT NULL,
	PRIMARY KEY (usuario_cpf),
	FOREIGN KEY (usuario_cpf)
		REFERENCES usuarios (cpf)
);