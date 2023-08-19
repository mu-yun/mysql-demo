create table t_invoice
(
    invoice_id           bigint unsigned  primary key,
    order_id           bigint unsigned,
    operation    varchar(255) null,
    created_by   bigint unsigned  null,
    created_time datetime  null,
    updated_time datetime  null
);
