CREATE TABLE weather (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    temperature NUMERIC(5, 2),
    time TIMESTAMP
);

CREATE SEQUENCE public.hibernate_sequence
	INCREMENT BY 10
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;