CREATE TABLE book(
    id SERIAL PRIMARY KEY NOT NULL,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    pages_number INT NOT NULL
);