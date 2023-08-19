create table t_order
(
    id           bigint unsigned  primary key,
    operation    varchar(255) null,
    created_by   bigint unsigned  null,
    created_time datetime  null,
    updated_time datetime  null
);
