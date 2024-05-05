CREATE TABLE categorias (
	id CHAR(36),
	nome VARCHAR(50) NOT NULL,
	icone VARCHAR(100) NOT NULL,
	data_e_hora_criacao TIMESTAMP NOT NULL,
	criado_por_usuario_id CHAR(36) NOT NULL,
	data_e_hora_ultima_alteracao TIMESTAMP,
	alterado_por_usuario_id CHAR(36),
	numero_apostas BIGINT,
	numero_eventos BIGINT,
	total_reais_movimentado NUMERIC(24,3),
	total_dolar_movimentado NUMERIC(24,3),
	total_euro_movimentado NUMERIC(24,3),
	total_bitcoin_movimentado NUMERIC(24,3),
	ativo BOOLEAN NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (alterado_por_usuario_id)
		REFERENCES usuarios (id)
);