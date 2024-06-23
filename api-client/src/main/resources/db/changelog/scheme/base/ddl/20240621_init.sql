create table http_request
(
    id             char(36)     not null primary key,

    path_url       varchar(255) not null,
    request_header jsonb        not null,
    request_body   jsonb        not null,
    method         varchar(20)  not null,
    enabled        boolean      not null default true,

    created_at     numeric      not null,
    updated_at     numeric,
    is_deleted     boolean      not null
);

create table http_response
(
    id                        char(36) not null primary key,

    header          jsonb    not null,
    body             jsonb    not null,
    http_status_code smallint not null,
    response_time_in_millis   numeric  not null,
    enabled                   boolean  not null default true,

    created_at                numeric  not null,
    updated_at                numeric,
    is_deleted                boolean  not null,
    http_request_id           char(36) not null,
    foreign key (http_request_id) references http_request (id)
);

create table http_histories
(
    id                        char(36)     not null primary key,

    path_url                  varchar(255) not null,
    request_headers           jsonb        not null,
    request_body              jsonb        not null,

    response_headers          jsonb        not null,
    response_body             jsonb        not null,
    response_http_status_code smallint     not null,

    created_at                numeric      not null,
    updated_at                numeric
);
