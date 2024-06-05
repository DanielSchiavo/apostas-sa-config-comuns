CREATE TABLE jogos (
	id CHAR(36),
	nome VARCHAR(50) NOT NULL,
	icone VARCHAR(100) NOT NULL,
	descricao TEXT NOT NULL,
	imagem VARCHAR(100) NOT NULL,
    data_e_hora_criacao TIMESTAMP NOT NULL ,
    criado_por_usuario_cpf CHAR(36) NOT NULL,
    data_e_hora_ultima_alteracao TIMESTAMP,
    alterado_por_usuario_cpf CHAR(36),
	numero_eventos BIGINT,
    numero_apostas BIGINT,
    total_reais_movimentado NUMERIC(24,3),
    total_dolar_movimentado NUMERIC(24,3),
    total_euro_movimentado NUMERIC(24,3),
    total_bitcoin_movimentado NUMERIC(24,3),
    ativo BOOLEAN NOT NULL,
	sub_categoria_id CHAR(36) NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (criado_por_usuario_cpf)
        REFERENCES usuarios (cpf),
    FOREIGN KEY (alterado_por_usuario_cpf)
        REFERENCES usuarios (cpf),
	FOREIGN KEY (sub_categoria_id)
		REFERENCES sub_categorias (id)
);