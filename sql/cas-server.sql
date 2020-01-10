-- auto-generated definition
create table oauth_access_token
(
    token_id          varchar(256) null,
    token             blob         null,
    authentication_id varchar(256) not null
        primary key,
    user_name         varchar(256) null,
    client_id         varchar(256) null,
    authentication    blob         null,
    refresh_token     varchar(256) null
);

-- auto-generated definition
create table oauth_client_details
(
    id                             varchar(255) not null
        primary key,
    resource_ids                   varchar(255) null,
    client_id                      varchar(255) null,
    client_secret                  varchar(255) null,
    grant_type                     varchar(255) null,
    redirect_uri                   varchar(255) null,
    auto_approve                   varchar(255) null,
    authorities                    varchar(255) null,
    scope                          varchar(255) null,
    access_token_validity_seconds  int          null,
    refresh_token_validity_seconds int          null,
    login_url                      varchar(255) null
);

INSERT INTO `oauth_client_details`
VALUES ('06b616ff-bbd1-4b8b-9f42-d3b9a3aa1e99', 'cas-server', 'community',
        '$2a$10$MRvz/BeD7LsXNFfByECtfe7mQb21z7SNw.RwUXCAkKIc2XQ22qHg2', 'authorization_code',
        'http://www.community.com:8081/login/oauth2/code/community', 'true', NULL, 'userInfo', -1, -1,
        'http://www.community.com:8081/remote_login'),
       ('4c5e419c-6a39-4b4a-9fdf-9c89d1700f32', 'cas-server', 'smartcity',
        '$2a$10$MRvz/BeD7LsXNFfByECtfe7mQb21z7SNw.RwUXCAkKIc2XQ22qHg2', 'authorization_code',
        'http://www.community.com:8082/login/oauth2/code/smartcity', 'true', NULL, 'userInfo', -1, -1, NULL);