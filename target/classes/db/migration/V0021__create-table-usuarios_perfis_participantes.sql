CREATE TABLE usuarios_perfis_participantes (
    usuario_id CHAR(36),
    foto      VARCHAR(100),
    instagram VARCHAR(50),
    facebook  VARCHAR(50),
    twitter   VARCHAR(50),
    frase     VARCHAR(200),
    data_e_hora_criacao TIMESTAMP NOT NULL,
    ativo BOOLEAN NOT NULL,
    PRIMARY KEY (usuario_id),
    FOREIGN KEY (usuario_id)
        REFERENCES usuarios (id)
);