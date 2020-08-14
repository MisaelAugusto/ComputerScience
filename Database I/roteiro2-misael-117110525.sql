--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE ONLY public.funcionario DROP CONSTRAINT superior_cpf_foreignkey;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT superior_cpf_delete_restrict;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT superior_cpf_delete_cascade;
ALTER TABLE ONLY public.tarefas DROP CONSTRAINT tarefas_pkey;
ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
DROP TABLE public.tarefas;
DROP TABLE public.funcionario;
SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: funcionario; Type: TABLE; Schema: public; Owner: misael
--

CREATE TABLE public.funcionario (
    cpf character(11) NOT NULL,
    data_nasc date NOT NULL,
    nome character(40) NOT NULL,
    funcao character(11),
    nivel character(1),
    superior_cpf character(11),
    CONSTRAINT cpf_valido CHECK ((char_length(cpf) = 11)),
    CONSTRAINT funcao_valida CHECK (((funcao = 'LIMPEZA'::bpchar) OR (funcao = 'SUP_LIMPEZA'::bpchar))),
    CONSTRAINT limpeza_tem_superior CHECK ((((funcao = 'LIMPEZA'::bpchar) AND (superior_cpf IS NOT NULL)) OR (funcao = 'SUP_LIMPEZA'::bpchar))),
    CONSTRAINT nivel_valido CHECK (((nivel = 'J'::bpchar) OR (nivel = 'P'::bpchar) OR (nivel = 'S'::bpchar))),
    CONSTRAINT superior_cpf_valido CHECK ((char_length(superior_cpf) = 11))
);


ALTER TABLE public.funcionario OWNER TO misael;

--
-- Name: tarefas; Type: TABLE; Schema: public; Owner: misael
--

CREATE TABLE public.tarefas (
    id numeric NOT NULL,
    descricao character varying(160) NOT NULL,
    func_resp_cpf character(11),
    prioridade integer NOT NULL,
    status character(1) NOT NULL,
    CONSTRAINT func_resp_cpf_valido CHECK ((char_length(func_resp_cpf) = 11)),
    CONSTRAINT func_resp_id_null CHECK (((func_resp_cpf IS NOT NULL) OR ((func_resp_cpf IS NULL) AND (status = 'E'::bpchar)))),
    CONSTRAINT prioridade_valida CHECK (((prioridade >= 0) AND (prioridade <= 5))),
    CONSTRAINT prioridadevalida CHECK ((prioridade < 32768)),
    CONSTRAINT status_valido CHECK (((status = 'P'::bpchar) OR (status = 'E'::bpchar) OR (status = 'C'::bpchar)))
);


ALTER TABLE public.tarefas OWNER TO misael;

--
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: misael
--

INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678911', '1980-05-07', 'Pedro da Silva                          ', 'SUP_LIMPEZA', 'S', NULL);
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678912', '1980-03-08', 'Jose da Silva                           ', 'LIMPEZA    ', 'J', '12345678911');
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678914', '1981-01-01', 'Maria                                   ', 'SUP_LIMPEZA', 'S', NULL);
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678915', '1982-02-02', 'Pedro de Lima                           ', 'SUP_LIMPEZA', 'S', NULL);
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678916', '1983-03-03', 'Lucas                                   ', 'SUP_LIMPEZA', 'J', NULL);
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678917', '1984-04-04', 'Lúcio Azevedo                           ', 'LIMPEZA    ', 'P', '12345678915');
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678918', '1985-05-05', 'Bruna Santos                            ', 'LIMPEZA    ', 'J', '12345678915');
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678919', '1986-06-06', 'Márcia                                  ', 'SUP_LIMPEZA', 'P', '12345678916');
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678920', '1987-07-07', 'Wellington                              ', 'SUP_LIMPEZA', 'S', '12345678918');
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678921', '1988-08-08', 'Marcos                                  ', 'SUP_LIMPEZA', 'J', NULL);
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678922', '1989-09-09', 'Moisés da Silva                         ', 'SUP_LIMPEZA', 'P', NULL);
INSERT INTO public.funcionario (cpf, data_nasc, nome, funcao, nivel, superior_cpf) VALUES ('12345678923', '1990-10-10', 'Milena                                  ', 'LIMPEZA    ', 'J', '12345678914');


--
-- Data for Name: tarefas; Type: TABLE DATA; Schema: public; Owner: misael
--

INSERT INTO public.tarefas (id, descricao, func_resp_cpf, prioridade, status) VALUES (2147483646, 'limpar chão do corredor central', '98765432111', 5, 'P');
INSERT INTO public.tarefas (id, descricao, func_resp_cpf, prioridade, status) VALUES (2147483647, 'limpar janelas da sala 203', '98765432122', 5, 'P');
INSERT INTO public.tarefas (id, descricao, func_resp_cpf, prioridade, status) VALUES (2147483648, 'limpar portas do térreo', '32323232955', 5, 'P');
INSERT INTO public.tarefas (id, descricao, func_resp_cpf, prioridade, status) VALUES (2147483657, 'example 4', NULL, 0, 'E');


--
-- Name: funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: misael
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (cpf);


--
-- Name: tarefas_pkey; Type: CONSTRAINT; Schema: public; Owner: misael
--

ALTER TABLE ONLY public.tarefas
    ADD CONSTRAINT tarefas_pkey PRIMARY KEY (id);


--
-- Name: superior_cpf_delete_cascade; Type: FK CONSTRAINT; Schema: public; Owner: misael
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT superior_cpf_delete_cascade FOREIGN KEY (superior_cpf) REFERENCES public.funcionario(cpf) ON DELETE CASCADE;


--
-- Name: superior_cpf_delete_restrict; Type: FK CONSTRAINT; Schema: public; Owner: misael
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT superior_cpf_delete_restrict FOREIGN KEY (superior_cpf) REFERENCES public.funcionario(cpf) ON DELETE RESTRICT;


--
-- Name: superior_cpf_foreignkey; Type: FK CONSTRAINT; Schema: public; Owner: misael
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT superior_cpf_foreignkey FOREIGN KEY (superior_cpf) REFERENCES public.funcionario(cpf);


--
-- PostgreSQL database dump complete
--

