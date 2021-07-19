-- Table: public.TSVETA

-- DROP TABLE public."TSVETA";

CREATE TABLE public."TSVETA"
(
    id integer NOT NULL,
    color_number character varying(2) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "TSVETA_pkey" PRIMARY KEY (id)
)
