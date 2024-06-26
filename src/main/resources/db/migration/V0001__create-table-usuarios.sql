CREATE TABLE usuarios (
	cpf CHAR(14),
	rg VARCHAR(10) UNIQUE,
	imagem_comprovante_identidade_frente VARCHAR(100) UNIQUE,
	imagem_comprovante_identidade_verso VARCHAR(100) UNIQUE,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	ddd CHAR(2) NOT NULL,
	numero_celular CHAR(9) NOT NULL,
	senha VARCHAR(100) NOT NULL,
	data_nascimento DATE NOT NULL,
	data_criacao_conta TIMESTAMP NOT NULL,
	saldo NUMERIC(10,2) NOT NULL,
	confirmou_identidade BOOLEAN,
	PRIMARY KEY (id)
);