create table t_invoice_item
(
    id           bigint unsigned  primary key,
    invoice_id     bigint unsigned,
    order_id     bigint unsigned,
    order_item_id     bigint unsigned,
    product_id   bigint unsigned,
    product_name    varchar(255) null,
    quantity     smallint unsigned,
    operation    varchar(255) null,
    created_by   bigint unsigned  null,
    created_time datetime  null,
    updated_time datetime  null
);
