--
-- Script to create initial database for PhoenixContact app store
--


--
-- User and Schema
--
-- appstore = application user with minimal grants
create user appstore with password '12345678';
drop schema if exists appstore cascade;
create schema appstore;


--
-- Sequences
--
create sequence appstore.app_attachment_id_seq;
create sequence appstore.app_id_seq;
create sequence appstore.app_license_id_seq;
create sequence appstore.billing_address_id_seq;
create sequence appstore.order_id_seq;
create sequence appstore.qa_conversation_id_seq;
create sequence appstore.question_answer_id_seq;
create sequence appstore.rating_id_seq;
create sequence appstore.role_id_seq;
create sequence appstore.technical_detail_id_seq;
create sequence appstore.user_principal_id_seq;

create table appstore._user
(
    uuid varchar(30) not null,
    user_name varchar(100) not null,
    icon_url varchar(255),
    first_name varchar(50),
    last_name varchar(50),
    email varchar(50) not null,
    general_tacaccepted boolean not null,
    developer_tacaccepted boolean not null,
    active boolean not null,
    created_at date not null,  --really needed?
    company varchar(50),
    general_info varchar(500),
    constraint user_pkey primary key (uuid),
    constraint user_email_key unique (email),
    constraint user_username_key unique (user_name)
);

create table appstore.app
(
    id bigint not null default nextval('appstore.app_id_seq'::regclass),
    user_uuid varchar(30) not null,
    _name varchar(100) not null,
    icon_url varchar(255),
    description varchar(4000),
    price numeric(10,2) not null,
    active boolean not null,
    _version varchar(20) not null,
    whats_new varchar(500),
    last_update date not null,
    downloads integer not null,
    certified boolean not null,
    constraint app_pkey primary key (id),
    constraint appname unique (user_uuid, _name),
	--	possible values for on update|delete are: no action|set null|cascade
    constraint fk_user foreign key (user_uuid)
        references appstore._user (uuid) match simple
        on update no action
        on delete no action
);

create table appstore.rating
(
    id bigint not null default nextval('appstore.rating_id_seq'::regclass),
    app_id bigint not null,
    user_uuid varchar(30) not null,
    rating_date timestamp without time zone not null,
    rating_value integer not null,
    review varchar(1000),
    constraint rating_pkey primary key (id),
    constraint rating_rating_value_check check (rating_value >= 0 and rating_value <= 5),
    constraint fk_app foreign key (app_id)
        references appstore.app (id) match simple
        on update no action
        on delete no action,
    constraint fk_user foreign key (user_uuid)
        references appstore._user (uuid) match simple
        on update no action
        on delete no action
);

create table appstore.technical_detail
(
    id bigint not null default nextval('appstore.technical_detail_id_seq'::regclass),
    app_id bigint not null,
    attribute_name varchar(100) not null,
    attribute_value varchar(100) not null,
    constraint technical_detail_pkey primary key (id),
    constraint fk_app foreign key (app_id)
        references appstore.app (id) match simple
        on update no action
        on delete no action
);

create table appstore.device
( 
	uuid varchar(30) not null,
	user_uuid varchar(30) not null,
	_name varchar(50) not null,
	icon_url varchar(255) not null,
	description varchar(100),
	constraint device_pkey primary key (uuid),
	constraint fk_user foreign key (user_uuid)
		references appstore._user (uuid) match simple
			on update no action
			on delete no action
);

create table appstore.app_license
(
    id bigint not null default nextval('appstore.app_license_id_seq'::regclass),
    app_id bigint not null,
    user_uuid varchar(30) not null,
	device_uuid varchar(30),
    _version varchar(10) not null,
    status int not null,
    update_available boolean not null,
    constraint app_license_pkey primary key (id),
	constraint fk_app foreign key (app_id)
        references appstore.app (id) match simple
        on update no action
        on delete no action,
    constraint fk_user foreign key (user_uuid)
        references appstore._user (uuid) match simple
        on update no action
        on delete no action,
    constraint fk_device foreign key (device_uuid)
        references appstore.device (uuid) match simple
        on update no action
        on delete no action
);

create table appstore.app_attachment
(
    id bigint not null default nextval('appstore.app_attachment_id_seq'::regclass),
    app_id bigint not null,
    location_url varchar(255) not null,
    description varchar(255),
    _type smallint not null,
    constraint app_attachment_pkey primary key (id),
    constraint fk_app foreign key (app_id)
        references appstore.app (id) match simple
        on update no action
        on delete no action
);

create table appstore._order
(
    id bigint not null default nextval('appstore.order_id_seq'::regclass),
    app_id bigint not null,
    user_uuid varchar(30) not null,
    order_number int not null,
    order_date date not null,
    unit_price numeric(10,2) not null,
    total_price numeric(10,2) not null,
    amount int not null,
    description varchar(500),
    constraint order_pkey primary key (id),
    constraint fk_app foreign key (app_id)
        references appstore.app (id) match simple
        on update no action
        on delete no action,
	constraint ordernumber_key unique (order_number),
    constraint fk_user foreign key (user_uuid)
    references appstore._user (uuid) match simple
        on update no action
        on delete no action
);

create table appstore.qa_conversation
(
    id bigint not null default nextval('appstore.qa_conversation_id_seq'::regclass),
    app_id bigint not null,
    constraint qa_conversation_pkey primary key (id),
    constraint fk_app foreign key (app_id)
        references appstore.app (id) match simple
        on update no action
        on delete no action  
);

create table appstore.question_answer
(
    id bigint not null default nextval('appstore.question_answer_id_seq'::regclass),
    conversation_id bigint not null,
    user_uuid varchar(30) not null,
	_type smallint not null,  --? Possible values: Question (=1), Answer (=2)
	text varchar(1000) not null,
	_date date not null,
	constraint question_answer_pkey primary key (id),
		constraint fk_user foreign key (user_uuid)
			references appstore._user (uuid) match simple
				on update no action
				on delete no action,
		constraint fk_conversation foreign key (conversation_id)
			references appstore.qa_conversation (id) match simple
				on update no action
				on delete no action  
);

create table appstore.billing_address(
	id bigint not null default nextval('appstore.billing_address_id_seq'::regclass),
	user_uuid varchar(30) not null,
	country varchar(30)not null,
	city varchar(30)not null,
	postal_code varchar(10)not null, 
	street varchar(30)not null, 
	region varchar(30),
	constraint fk_user foreign key (user_uuid)
		references appstore._user (uuid) match simple
			on update no action
			on delete no action
);

create table appstore.user_principal(
	id bigint not null default nextval('appstore.user_principal_id_seq'::regclass),
	user_uuid varchar(30) not null,
	store_token varchar(100),
	pc_token varchar(100),
	constraint principal_pkey primary key (id),
	constraint fk_user foreign key (user_uuid)
		references appstore._user (uuid) match simple
			on update no action
			on delete no action
);

create table appstore.role
(
	id bigint not null default nextval('appstore.role_id_seq'::regclass),
	_name varchar(20) not null,
	description varchar(100),
	constraint role_pkey primary key (id)
);

create table appstore.user_role_assignment(
	principal_id bigint not null,
	role_id bigint not null,
	constraint fk_user_principal foreign key (principal_id)
		references appstore.user_principal (id) match simple
			on update no action
			on delete no action,
	constraint fk_role foreign key (role_id)
		references appstore.role (id) match simple
			on update no action
			on delete no action
);


--
-- Set owner/access grants
--
grant all on schema appstore to postgres;
grant select, insert, update, delete on all tables in schema appstore to appstore;

--TODO: Check for correct handling of sequences (postgres = full access; appstore = minimal grants)
alter sequence appstore.app_attachment_id_seq owned by appstore.app_attachment.id;
alter sequence appstore.app_id_seq owned by appstore.app.id;
alter sequence appstore.app_license_id_seq owned by appstore.app_license.id;
alter sequence appstore.billing_address_id_seq owned by appstore.billing_address.id;
alter sequence appstore.order_id_seq owned by appstore._order.id;
alter sequence appstore.qa_conversation_id_seq owned by appstore.qa_conversation.id;
alter sequence appstore.question_answer_id_seq owned by appstore.question_answer.id;
alter sequence appstore.rating_id_seq owned by appstore.rating.id;
alter sequence appstore.role_id_seq owned by appstore.role.id;
alter sequence appstore.technical_detail_id_seq owned by appstore.technical_detail.id;
alter sequence appstore.user_principal_id_seq owned by appstore.user_principal.id;
