
CREATE TABLE public.admins (
    id uuid NOT NULL,
    login character varying(50) NOT NULL,
    name character varying(35) NOT NULL,
    password character varying(20) NOT NULL,
    type_admin boolean NOT NULL
);


ALTER TABLE public.admins OWNER TO postgres;



CREATE TABLE public.clients (
    id uuid NOT NULL,
    e_mail character varying(50) NOT NULL,
    name character varying(35) NOT NULL,
    phone_number character varying(20) NOT NULL
);


ALTER TABLE public.clients OWNER TO postgres;


CREATE TABLE public.culture (
    id uuid NOT NULL,
    culture_name character varying(35) NOT NULL
);


ALTER TABLE public.culture OWNER TO postgres;


CREATE TABLE public.imagedata (
    id uuid NOT NULL,
    image_data bytea NOT NULL,
    name character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    image_list uuid
);


ALTER TABLE public.imagedata OWNER TO postgres;


CREATE TABLE public.products (
    id uuid NOT NULL,
    date timestamp(6) without time zone NOT NULL,
    description character varying(255) NOT NULL,
    product_name character varying(50) NOT NULL,
    size_area double precision NOT NULL,
    status boolean NOT NULL,
    admin_id uuid,
    culture_id uuid
);


ALTER TABLE public.products OWNER TO postgres;


CREATE TABLE public.requests (
    id uuid NOT NULL,
    date timestamp(6) without time zone NOT NULL,
    admin_id uuid,
    client_id uuid,
    product_id uuid
);


ALTER TABLE public.requests OWNER TO postgres;




ALTER TABLE ONLY public.admins
    ADD CONSTRAINT admins_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.culture
    ADD CONSTRAINT culture_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.imagedata
    ADD CONSTRAINT imagedata_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT requests_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.admins
    ADD CONSTRAINT uk_7gb4hqhf0qd8bhppyp3wq3hj UNIQUE (login);


ALTER TABLE ONLY public.admins
    ADD CONSTRAINT uk_7m02itd96ff7c8yh3bkroo5dc UNIQUE (password);


ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk81ve29lubvbbl9sicn80vfi3q FOREIGN KEY (culture_id) REFERENCES public.culture(id);


ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fk9b7l56r4k3xg2kicc29vf9exq FOREIGN KEY (product_id) REFERENCES public.products(id);


ALTER TABLE ONLY public.imagedata
    ADD CONSTRAINT fkbcfvrooivfts1xrc5xp3a1kkn FOREIGN KEY (image_list) REFERENCES public.products(id);


ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fkbtcgj56yb8exfiuhinbigi14c FOREIGN KEY (admin_id) REFERENCES public.admins(id);


ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkjnxmh4yun5vdrlotun2woo4fq FOREIGN KEY (admin_id) REFERENCES public.admins(id);



ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fkljmj9fpy346ea5hejj9ej6x6o FOREIGN KEY (client_id) REFERENCES public.clients(id);


