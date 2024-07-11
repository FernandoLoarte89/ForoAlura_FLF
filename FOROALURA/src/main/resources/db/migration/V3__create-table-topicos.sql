CREATE TABLE topicos (

  id BIGINT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  mensaje VARCHAR(255) NOT NULL,
  fecha_de_creacion  DATE NOT NULL,
  status varchar(20) NOT NULL,
  usuario BIGINT NOT NULL,
  curso BIGINT NOT NULL,

  PRIMARY KEY (id)
  );