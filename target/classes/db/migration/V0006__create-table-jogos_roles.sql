CREATE TABLE jogos_roles (
	id CHAR(36),
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	icone VARCHAR(100) NOT NULL,
    data_e_hora_criacao TIMESTAMP NOT NULL,
    criado_por_usuario_id CHAR(36) NOT NULL,
    data_e_hora_ultima_alteracao TIMESTAMP,
    alterado_por_usuario_id CHAR(36),
	PRIMARY KEY (id),
    FOREIGN KEY (criado_por_usuario_id)
        REFERENCES usuarios (id)
);