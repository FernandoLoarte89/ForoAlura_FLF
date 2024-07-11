CREATE TABLE respuestas(

    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje MEDIUMTEXT NOT NULL,
    topico BIGINT NOT NULL,
    fecha_de_creacion DATE NOT NULL,
    usuario bigint NOT NULL,
    solucion tinyint,

    PRIMARY KEY (id)
);