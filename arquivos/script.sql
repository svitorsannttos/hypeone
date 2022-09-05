SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';

ALTER SCHEMA public OWNER TO hypeadvice;

SET default_tablespace = '';

SET default_table_access_method = heap;

-- CREATE TABLES

CREATE TABLE public."conselho" (
    "id" bigint NOT NULL,
    "nome" character varying(100) NOT NULL,
    "descricao" character varying(1000) NOT NULL,
    "tipo_de_conselho" character varying(20) NOT NULL
);

CREATE TABLE public."cliente" (
    "id" bigint NOT NULL,
    "nome" character varying(100) NOT NULL
);

CREATE TABLE public."venda" (
    "id" bigint NOT NULL,
    "id_cliente" bigint NOT NULL
);

CREATE TABLE public."venda_conselho" (
    "id_venda" bigint NOT NULL,
    "id_conselho" bigint NOT NULL
);

-- GRANT HYPEADVICE

ALTER TABLE public."conselho" OWNER TO hypeadvice;
ALTER TABLE public."cliente" OWNER TO hypeadvice;
ALTER TABLE public."venda" OWNER TO hypeadvice;
ALTER TABLE public."venda_conselho" OWNER TO hypeadvice;

-- PRIMARY KEY & CONSTRAINSTS

ALTER TABLE ONLY public."conselho"
    ADD CONSTRAINT "conselho_pk" PRIMARY KEY ("id");

ALTER TABLE ONLY public."cliente"
    ADD CONSTRAINT "cliente_pk" PRIMARY KEY ("id");

ALTER TABLE ONLY public."venda"
    ADD CONSTRAINT "venda_pk" PRIMARY KEY ("id");

-- FOREIGN KEY & CONSTRAINSTS

ALTER TABLE ONLY public."venda"
    ADD CONSTRAINT "venda_cliente_fk" FOREIGN KEY ("id_cliente") REFERENCES public."cliente"("id") ON DELETE RESTRICT;

ALTER TABLE ONLY public."venda_conselho"
    ADD CONSTRAINT "venda_conselho_fk" FOREIGN KEY ("id_venda") REFERENCES public."venda"("id") ON DELETE RESTRICT;

ALTER TABLE ONLY public."venda_conselho"
    ADD CONSTRAINT "conselho_venda_fk" FOREIGN KEY ("id_conselho") REFERENCES public."conselho"("id") ON DELETE RESTRICT;

-- INDEXES

CREATE INDEX "cliente_nome_idx" ON public."cliente" USING btree ("nome");

CREATE INDEX "conselho_nome_idx" ON public."conselho" USING btree ("nome");