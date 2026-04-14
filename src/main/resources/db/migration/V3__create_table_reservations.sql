CREATE TABLE reservations (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    table_id UUID NOT NULL,
    reservation_timestamp TIMESTAMP NOT NULL,
    reservation_status TEXT NOT NULL,

    CONSTRAINT fk_reservation_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_reservation_table
        FOREIGN KEY (table_id)
        REFERENCES tables(id)
        ON DELETE CASCADE
);