CREATE TABLE EMPRESA(
	id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	razao_social VARCHAR(255) NOT NULL,
	cnpj VARCHAR(255) NOT NULL,
	ativo BOOLEAN NOT NULL,
	data_cadastro DATE NULL,
	data_edicao DATE NULL
);