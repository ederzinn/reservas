CREATE TABLE tables (
    id UUID PRIMARY KEY,
    number INTEGER UNIQUE NOT NULL,
    capacity INTEGER NOT NULL,
    status TEXT NOT NULL
);