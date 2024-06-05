CREATE TABLE usuarios_transacoes_saques (
	usuario_cpf CHAR(14) NOT NULL,
	valor NUMERIC (10,7) NOT NULL,
	moeda_id CHAR(5) NOT NULL,
	saldo_atual NUMERIC (10,7) NOT NULL,
	data_e_hora TIMESTAMP NOT NULL,
	FOREIGN KEY (usuario_cpf)
		REFERENCES usuarios (cpf)
);