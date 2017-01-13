# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table area (
  id                            integer auto_increment not null,
  code                          integer,
  name                          varchar(255),
  city_code                     integer,
  constraint pk_area primary key (id)
);

create table city (
  id                            integer auto_increment not null,
  province_code                 integer,
  code                          integer,
  name                          varchar(255),
  constraint pk_city primary key (id)
);

create table client (
  id                            integer auto_increment not null,
  name                          varchar(255),
  mobile                        varchar(255),
  type                          integer,
  status                        integer,
  creator                       integer,
  modifier                      integer,
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_client primary key (id)
);

create table contact (
  id                            integer auto_increment not null,
  name                          varchar(255),
  mobile                        varchar(255),
  type                          integer,
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_contact primary key (id)
);

create table credential (
  id                            integer auto_increment not null,
  house_id                      integer,
  business_licence              integer,
  whole_business                integer,
  food_and_beverage_business_license integer,
  fire_safety_permission        integer,
  invoice                       integer,
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_credential primary key (id)
);

create table district (
  id                            integer auto_increment not null,
  code                          integer,
  name                          varchar(255),
  area_code                     integer,
  constraint pk_district primary key (id)
);

create table facility (
  id                            integer auto_increment not null,
  house_id                      integer,
  shop_sign_size_one            bigint,
  shop_sign_size_two            bigint,
  power                         integer,
  capacitance                   integer,
  capacity_increase             integer,
  up_pipe                       integer,
  down_pipe                     integer,
  down_pipe_diameter            integer,
  gas                           integer,
  gas_cylinders                 integer,
  fire                          integer,
  duct                          integer,
  duct_rate                     bigint,
  blow_off                      integer,
  grease_trap                   integer,
  oil_fume                      integer,
  self_car_port_size            integer,
  around_car_port_size          integer,
  out_ward                      integer,
  status                        integer,
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_facility primary key (id)
);

create table house (
  id                            integer auto_increment not null,
  code                          varchar(255),
  rent_business_type            integer,
  rent_status                   integer,
  province_code                 integer,
  city_code                     integer,
  area_code                     integer,
  district_code                 integer,
  address                       varchar(500),
  longitude                     varchar(255),
  latitude                      varchar(255),
  map_url                       varchar(255),
  map_url_type                  varchar(255),
  whole_map_url                 varchar(255),
  hot_map_url                   varchar(255),
  operate_status                integer,
  business_name                 varchar(255),
  business_status               varchar(255),
  house_type                    integer,
  owner_type                    integer,
  owner                         varchar(255),
  property_right_type           integer,
  floor                         varchar(255),
  max_floor                     varchar(255),
  areas                         bigint,
  build_areas                   bigint,
  use_areas                     bigint,
  effien                        bigint,
  show_length                   integer,
  height                        bigint,
  rent_type                     integer,
  shade                         bigint,
  decoration                    integer,
  shop_sign_size_one            bigint,
  shop_sign_size_two            bigint,
  power                         integer,
  capacitance                   varchar(255),
  capacity_increase             integer,
  up_pipe                       integer,
  down_pipe                     integer,
  down_pipe_diameter            varchar(255),
  gas                           integer,
  gas_cylinders                 integer,
  fire                          integer,
  duct                          integer,
  duct_rate                     bigint,
  blow_off                      integer,
  grease_trap                   integer,
  oil_fume                      integer,
  self_car_port_size            integer,
  around_car_port_size          integer,
  out_ward                      integer,
  business                      varchar(255),
  chummage_daily                bigint,
  chummage_month                bigint,
  chummage_year                 bigint,
  chummage_increase             integer,
  chummage_increase_rule        varchar(255),
  transfer_cost                 bigint,
  pledge_month                  varchar(255),
  pay_month                     varchar(255),
  property_fee                  bigint,
  water_fee                     bigint,
  gas_fee                       bigint,
  elas_fee                      bigint,
  shop_sign_rate                bigint,
  next_pay_rent_date            datetime(6),
  max_rent_year                 varchar(255),
  repetition                    integer,
  marchat_level                 integer,
  house_level                   integer,
  good                          varchar(255),
  bad                           varchar(255),
  proposed                      varchar(255),
  per_person_min                bigint,
  per_person_max                bigint,
  describtion                   varchar(255),
  house_source                  integer,
  source_name                   varchar(255),
  status                        integer,
  contact_id                    integer,
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_house primary key (id)
);

create table picture (
  id                            integer auto_increment not null,
  house_id                      integer,
  url                           varchar(255),
  status                        integer,
  name                          integer,
  md5                           varchar(255),
  size                          bigint,
  meta                          integer,
  constraint pk_picture primary key (id)
);

create table province (
  id                            integer auto_increment not null,
  code                          integer,
  name                          varchar(255),
  constraint pk_province primary key (id)
);

create table show_record (
  id                            integer auto_increment not null,
  staff_id                      integer,
  house_id                      integer,
  content                       varchar(500),
  status                        integer,
  show_date                     datetime(6),
  client_name                   varchar(255),
  date                          datetime(6),
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_show_record primary key (id)
);

create table signs (
  id                            integer auto_increment not null,
  house_code                    integer,
  sign_code                     integer,
  sign_name                     varchar(255),
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_signs primary key (id)
);

create table staff (
  id                            integer auto_increment not null,
  username                      varchar(255),
  password                      varchar(255),
  title                         integer,
  status                        integer,
  updated_date                  datetime(6) not null,
  created_date                  datetime(6) not null,
  constraint pk_staff primary key (id)
);


# --- !Downs

drop table if exists area;

drop table if exists city;

drop table if exists client;

drop table if exists contact;

drop table if exists credential;

drop table if exists district;

drop table if exists facility;

drop table if exists house;

drop table if exists picture;

drop table if exists province;

drop table if exists show_record;

drop table if exists signs;

drop table if exists staff;

