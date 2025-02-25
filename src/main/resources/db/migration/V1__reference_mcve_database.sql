-- SCHEMA: mcve

DROP SCHEMA mcve CASCADE;

CREATE SCHEMA mcve
    AUTHORIZATION postgres;

GRANT ALL ON SCHEMA mcve TO PUBLIC;

GRANT ALL ON SCHEMA mcve TO postgres;

-- Type: my_udt

--DROP TYPE mcve.my_udt;

CREATE TYPE mcve.my_udt AS
(
	my_id uuid,
	my_value integer
);

ALTER TYPE mcve.my_udt
    OWNER TO postgres;

-- Table: mcve.my_table

--DROP TABLE mcve.my_table;

CREATE TABLE mcve.my_table
(
    my_column mcve.my_udt
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE mcve.my_table
    OWNER to postgres;

INSERT INTO mcve.my_table(
	my_column)
	VALUES (('61dac63b-c8dc-49f7-975d-17997165be0c',1)::mcve.my_udt);

-- Table: mcve.my_other_table

--DROP TABLE mcve.my_other_table;

CREATE TABLE mcve.my_other_table
(
    my_value integer NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE mcve.my_other_table
    OWNER to postgres;

INSERT INTO mcve.my_other_table(
	my_value)
	VALUES (1);

