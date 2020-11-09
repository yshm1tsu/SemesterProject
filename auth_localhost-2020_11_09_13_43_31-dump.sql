--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: auth; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auth (
    email character varying(30),
    id bigint NOT NULL,
    password character varying(300)
);


ALTER TABLE public.auth OWNER TO postgres;

--
-- Name: auth_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auth_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auth_id_seq OWNER TO postgres;

--
-- Name: auth_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.auth_id_seq OWNED BY public.auth.id;


--
-- Name: auth_review; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auth_review (
    auth_id bigint NOT NULL,
    review_id bigint NOT NULL
);


ALTER TABLE public.auth_review OWNER TO postgres;

--
-- Name: auth_review_auth_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auth_review_auth_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auth_review_auth_id_seq OWNER TO postgres;

--
-- Name: auth_review_auth_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.auth_review_auth_id_seq OWNED BY public.auth_review.auth_id;


--
-- Name: auth_review_review_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auth_review_review_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auth_review_review_id_seq OWNER TO postgres;

--
-- Name: auth_review_review_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.auth_review_review_id_seq OWNED BY public.auth_review.review_id;


--
-- Name: review; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.review (
    id bigint NOT NULL,
    title character varying(20),
    user_email character varying,
    content character varying(500)
);


ALTER TABLE public.review OWNER TO postgres;

--
-- Name: review_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.review_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.review_id_seq OWNER TO postgres;

--
-- Name: review_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.review_id_seq OWNED BY public.review.id;


--
-- Name: watchlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.watchlist (
    id bigint NOT NULL,
    title character varying(20),
    add_date date,
    user_email character varying,
    rating character varying(20),
    status character varying(50)
);


ALTER TABLE public.watchlist OWNER TO postgres;

--
-- Name: watchlist_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.watchlist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.watchlist_id_seq OWNER TO postgres;

--
-- Name: watchlist_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.watchlist_id_seq OWNED BY public.watchlist.id;


--
-- Name: auth id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth ALTER COLUMN id SET DEFAULT nextval('public.auth_id_seq'::regclass);


--
-- Name: auth_review auth_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_review ALTER COLUMN auth_id SET DEFAULT nextval('public.auth_review_auth_id_seq'::regclass);


--
-- Name: auth_review review_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_review ALTER COLUMN review_id SET DEFAULT nextval('public.auth_review_review_id_seq'::regclass);


--
-- Name: review id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review ALTER COLUMN id SET DEFAULT nextval('public.review_id_seq'::regclass);


--
-- Name: watchlist id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watchlist ALTER COLUMN id SET DEFAULT nextval('public.watchlist_id_seq'::regclass);


--
-- Data for Name: auth; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auth (email, id, password) FROM stdin;
musa@gmail.com	6	$2a$12$fMPKHchAiRciEmBk3qIKWOMy.HwiaGpwiGaEEo45e8FJEG3.JkNx6
musa@musa	7	$2a$12$UXplsNeCGyqEdNHeL5YK0uV6MNT0m5B6bERePLuqhI//ZML1cZot2
mu@sa	8	$2a$12$NDi9t3q6f2EAiNm8TyGqouRFrwYNJzcGKUr.df81KVJeWOgGpcegu
test@mail.ru	9	$2a$12$zIHOw/Dz7M9fuxvKa1fTDOr64BZ0BEbkPyhszx9mRInuGBnT4Nanq
	18	$2a$12$R2X1cYmOXqUbx0x8pePZcOSB6wFyw760t4YeUrR7ni4IffHxxuUcu
musa@qwe	19	$2a$12$S8vcbZ2cLDcmeiAMKFox8.xHZVbW7OY8o5BCyK.tuYChfcGitqWPy
musa@qwe.ru	20	$2a$12$H0hr0xah/L/4QPxuiWdo6ej/1Pqmw0JW8ahlsjGHTrPTCwpoYgMJC
\.


--
-- Data for Name: auth_review; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auth_review (auth_id, review_id) FROM stdin;
\.


--
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.review (id, title, user_email, content) FROM stdin;
5	svati	musa@musa	nice one!
6	antoha	musa@musa	Ð½Ðµ Ð¾ÑÐµÐ½Ñ
7	Taxi	\N	nice one
8	Taxi	\N	awful movie
\.


--
-- Data for Name: watchlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.watchlist (id, title, add_date, user_email, rating, status) FROM stdin;
9	wefqwef	2020-11-19	\N	200	2
10	qwef	2020-10-28	\N	100	1
15	nice movie	2020-11-10	musa@musa	finished	pretty ok
16	wefwef	2020-11-13	\N	haven't started yet	bad
\.


--
-- Name: auth_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auth_id_seq', 20, true);


--
-- Name: auth_review_auth_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auth_review_auth_id_seq', 1, false);


--
-- Name: auth_review_review_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auth_review_review_id_seq', 1, false);


--
-- Name: review_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.review_id_seq', 8, true);


--
-- Name: watchlist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.watchlist_id_seq', 16, true);


--
-- Name: auth auth_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth
    ADD CONSTRAINT auth_pkey PRIMARY KEY (id);


--
-- Name: auth_review auth_review_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_review
    ADD CONSTRAINT auth_review_pkey PRIMARY KEY (auth_id, review_id);


--
-- Name: auth email_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth
    ADD CONSTRAINT email_unique UNIQUE (email);


--
-- Name: review review_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT review_pkey PRIMARY KEY (id);


--
-- Name: watchlist watchlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watchlist
    ADD CONSTRAINT watchlist_pkey PRIMARY KEY (id);


--
-- Name: auth_review auth_review_auth_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_review
    ADD CONSTRAINT auth_review_auth_id_fkey FOREIGN KEY (auth_id) REFERENCES public.auth(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: auth_review auth_review_review_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auth_review
    ADD CONSTRAINT auth_review_review_id_fkey FOREIGN KEY (review_id) REFERENCES public.review(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: review review_user_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.review
    ADD CONSTRAINT review_user_email_fkey FOREIGN KEY (user_email) REFERENCES public.auth(email) ON UPDATE RESTRICT ON DELETE CASCADE;


--
-- Name: watchlist watchlist_user_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.watchlist
    ADD CONSTRAINT watchlist_user_email_fkey FOREIGN KEY (user_email) REFERENCES public.auth(email) ON UPDATE RESTRICT ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

