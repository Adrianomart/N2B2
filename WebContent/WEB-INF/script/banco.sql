create database projectLP;

use projectLP;

CREATE TABLE tbfornecedor (
  Codigo int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(100) NOT NULL,
  CNPJ varchar(18) NOT NULL,
  PRIMARY KEY (Codigo)
);