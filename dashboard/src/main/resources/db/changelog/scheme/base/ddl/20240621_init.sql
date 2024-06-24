create table http_request
(
    id          char(36)             not null
        primary key,
    path_url    varchar(255)         not null,
    header      jsonb                not null,
    body        jsonb                not null,
    enabled     boolean default true not null,
    created_at  numeric              not null,
    updated_at  numeric,
    deleted     boolean              not null,
    method      varchar(20)          not null,
    query_param jsonb                not null
);

create table http_response
(
    id                      char(36)             not null
        primary key,
    header                  jsonb                not null,
    body                    jsonb                not null,
    http_status_code        smallint             not null,
    response_time_in_millis numeric              not null,
    enabled                 boolean default true not null,
    created_at              numeric              not null,
    updated_at              numeric,
    is_deleted              boolean              not null,
    http_request_id         char(36)             not null
        references http_request
);

create table http_histories
(
    id                        char(36)     not null
        primary key,
    path_url                  varchar(255) not null,
    request_content_type      varchar(255) not null,
    request_headers           jsonb        not null,
    request_body              jsonb        not null,
    response_headers          jsonb        not null,
    response_body             jsonb        not null,
    response_http_status_code smallint     not null,
    created_at                numeric      not null,
    updated_at                numeric
);
