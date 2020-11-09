create table auth
(
    email    varchar(30)
        constraint email_unique
            unique,
    id       bigserial not null
        constraint auth_pkey
            primary key,
    password varchar(300)
);


create table review
(
    id         bigserial not null
        constraint review_pkey
            primary key,
    title      varchar(20),
    user_email varchar
        constraint review_user_email_fkey
            references auth (email)
            on update restrict on delete cascade,
    content    varchar(500)
);



create table watchlist
(
    id         bigserial not null
        constraint watchlist_pkey
            primary key,
    title      varchar(20),
    add_date   date,
    user_email varchar
        constraint watchlist_user_email_fkey
            references auth (email)
            on update restrict on delete cascade,
    rating     varchar(20),
    status     varchar(50)
);

create table auth_review
(
    auth_id   bigserial not null
        constraint auth_review_auth_id_fkey
            references auth
            on update cascade on delete cascade,
    review_id bigserial not null
        constraint auth_review_review_id_fkey
            references review
            on update cascade on delete cascade,
    constraint auth_review_pkey
        primary key (auth_id, review_id)
);


