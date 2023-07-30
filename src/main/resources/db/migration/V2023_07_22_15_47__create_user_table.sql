create table user
(
    id           bigint unsigned auto_increment
        primary key,
    username     varchar(255) not null,
    name         varchar(255) null,
    phone_number varchar(255) null,
    created_by   bigint unsigned      null,
    created_time datetime  null,
    updated_by   bigint unsigned      null,
    updated_time datetime  null,
    is_deleted   tinyint unsigned     not null,
    constraint uk_username
        unique (username)
);