CREATE TABLE reservas (
    id UUID PRIMARY KEY,
    usuario_id UUID NOT NULL,
    mesa_id UUID NOT NULL,
    data_reserva TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,

    CONSTRAINT fk_reservas_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios(id),

    CONSTRAINT fk_reservas_mesa
        FOREIGN KEY (mesa_id) REFERENCES mesas(id)
);