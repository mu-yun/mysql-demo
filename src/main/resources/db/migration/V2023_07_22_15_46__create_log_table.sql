create table log
(
    id           bigint unsigned auto_increment
        primary key,
    operation    varchar(255) null,
    created_by   bigint unsigned  null,
    created_time datetime  null
);