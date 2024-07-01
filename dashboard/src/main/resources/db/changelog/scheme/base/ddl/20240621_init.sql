create table http
(
    id                        char(36)     not null
        primary key,
    request_path_url          varchar(255) not null,
    request_method            varchar(20)  not null,
    request_header            jsonb        not null,
    request_body              jsonb        not null,
    request_query_param       jsonb        not null,

    response_header           jsonb        not null,
    response_body             jsonb        not null,
    response_http_status_code smallint     not null,
    response_time_in_millis   numeric      not null,

    created_at                numeric      not null,
    updated_at                numeric,
    deleted                   boolean      not null
);

create table http_history
(
    id                  BIGSERIAL not null
        primary key,
    request_path_url    varchar(255),
    request_method      varchar(20),
    request_header      text,
    request_body        text,
    request_query_param text,
    created_at          numeric   not null
);
