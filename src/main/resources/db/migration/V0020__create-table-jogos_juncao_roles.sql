CREATE TABLE jogos_juncao_roles (
    jogo_id CHAR(36),
    role_jogo_id CHAR(36),
    data_e_hora_atribuicao TIMESTAMP NOT NULL,
    atribuido_por_usuario_id CHAR(36) NOT NULL,
    PRIMARY KEY (jogo_id, role_jogo_id),
    FOREIGN KEY (jogo_id)
        REFERENCES jogos (id),
    FOREIGN KEY (role_jogo_id)
        REFERENCES jogos_roles (id),
    FOREIGN KEY (atribuido_por_usuario_id)
        REFERENCES usuarios (id)
);