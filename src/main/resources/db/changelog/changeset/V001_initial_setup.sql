CREATE TABLE IF NOT EXISTS public.userz (
    id bigserial primary key not null,
    name varchar(64) not null,
    surname varchar(64) not null,
    username varchar(64) not null,
    password varchar(128) not null,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone default now(),
    CONSTRAINT unique_username UNIQUE(username),
    CONSTRAINT password_length CHECK (LENGTH(password) >= 6)
);
