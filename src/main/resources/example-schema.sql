--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.10
-- Dumped by pg_dump version 9.3.10
-- Started on 2015-11-16 22:07:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1961 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16390)
-- Name: dinner_guests; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dinner_guests (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.dinner_guests OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 29961)
-- Name: event; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE event (
    eid integer NOT NULL,
    name character varying,
    start_time time without time zone,
    end_time time without time zone
);


ALTER TABLE public.event OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16385)
-- Name: food; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE food (
    id bigint NOT NULL,
    kind character varying(255),
    expired_date date
);


ALTER TABLE public.food OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 29969)
-- Name: sys_log; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sys_log (
    lid bigint NOT NULL,
    message character varying,
    when_utc timestamp without time zone
);


ALTER TABLE public.sys_log OWNER TO postgres;

--
-- TOC entry 1951 (class 0 OID 16390)
-- Dependencies: 171
-- Data for Name: dinner_guests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dinner_guests (id, name) FROM stdin;
\.


--
-- TOC entry 1952 (class 0 OID 29961)
-- Dependencies: 172
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY event (eid, name, start_time, end_time) FROM stdin;
1	John Wedding	21:22:51	22:22:51
\.


--
-- TOC entry 1950 (class 0 OID 16385)
-- Dependencies: 170
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY food (id, kind, expired_date) FROM stdin;
1	Meat	2015-11-13
2	Eggs	2015-11-13
\.


--
-- TOC entry 1953 (class 0 OID 29969)
-- Dependencies: 173
-- Data for Name: sys_log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sys_log (lid, message, when_utc) FROM stdin;
1	Test1	2015-11-14 22:22:51.714
\.


--
-- TOC entry 1838 (class 2606 OID 16394)
-- Name: dinner_guests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dinner_guests
    ADD CONSTRAINT dinner_guests_pkey PRIMARY KEY (id);


--
-- TOC entry 1840 (class 2606 OID 29968)
-- Name: event_fk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY event
    ADD CONSTRAINT event_fk PRIMARY KEY (eid);


--
-- TOC entry 1836 (class 2606 OID 16389)
-- Name: food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY food
    ADD CONSTRAINT food_pkey PRIMARY KEY (id);


--
-- TOC entry 1842 (class 2606 OID 29976)
-- Name: log_fk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sys_log
    ADD CONSTRAINT log_fk PRIMARY KEY (lid);


--
-- TOC entry 1960 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-11-16 22:07:53

--
-- PostgreSQL database dump complete
--

