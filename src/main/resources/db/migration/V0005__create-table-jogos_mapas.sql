CREATE TABLE jogos_mapas (
	id CHAR(36),
	nome VARCHAR(50) NOT NULL,
	imagem VARCHAR(100) NOT NULL,
	jogo_id CHAR(36) NOT NULL,
    data_e_hora_criacao TIMESTAMP NOT NULL,
    criado_por_usuario_cpf CHAR(36) NOT NULL,
    data_e_hora_ultima_alteracao TIMESTAMP,
    alterado_por_usuario_cpf CHAR(36),
	PRIMARY KEY(id),
	FOREIGN KEY (jogo_id)
		REFERENCES jogos (id),
    FOREIGN KEY (criado_por_usuario_cpf)
        REFERENCES usuarios (cpf),
    FOREIGN KEY (alterado_por_usuario_cpf)
        REFERENCES usuarios (cpf)
);