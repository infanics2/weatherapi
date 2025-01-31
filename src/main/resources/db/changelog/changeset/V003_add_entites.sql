CREATE TABLE public.city (
    id BIGSERIAL primary key,
    name varchar(128) not null,
    country varchar(128) not null,
    lat double precision not null,
    lon double precision not null
);

CREATE TABLE public.weather (
     id BIGSERIAL primary key,
     city_id int,
     temp_c double precision not null,
     temp_color varchar(128) not null,
     wind_kph double precision not null,
     wind_color varchar(128) not null,
     cloud int not null,
     cloud_color varchar(128) not null,
     created_at timestamp default current_timestamp,
     updated_at timestamp default current_timestamp,
     CONSTRAINT fk_city_id foreign key (city_id) references public.city (id)
);

CREATE INDEX city_name_idx on public.city(name);

