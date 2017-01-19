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
  name                          varchar(50) default '',
  mobile                        varchar(50) default '',
  type                          int(4) default 1,
  updated_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
  created_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
  constraint pk_contact primary key (id)
);

create table credential (
  id                            integer auto_increment not null,
  house_id                      integer,
  business_licence              int(2) default 0,
  whole_business                int(2) default 0,
  food_and_beverage_business_license int(2) default 0,
  fire_safety_permission        int(2) default 0,
  invoice                       int(2) default 0,
  updated_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
  created_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
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
  rent_business_type            int(4) default 1,
  rent_status                   int(4) default 1,
  province_code                 int(10) default 110000,
  city_code                     int(10) default 110100,
  area_code                     int(10) default 110101,
  district_code                 int(4) default 0,
  address                       varchar(500) default '',
  longitude                     varchar(500) default '',
  latitude                      varchar(500) default '',
  map_url                       varchar(500) default '',
  map_url_type                  varchar(500) default '',
  whole_map_url                 varchar(500) default '',
  hot_map_url                   varchar(500) default '',
  operate_status                int(4) default 0,
  business_name                 varchar(500) default '',
  business_status               varchar(500) default '',
  house_type                    int(4) default 0,
  owner_type                    int(4) default 0,
  owner                         varchar(40) default '',
  property_right_type           int(4) default 1,
  floor                         varchar(100) default '1',
  max_floor                     varchar(255),
  areas                         bigint(20) default 0,
  build_areas                   bigint(20) default 0,
  use_areas                     bigint(20) default 0,
  effien                        bigint,
  show_length                   varchar(20) default '0',
  height                        bigint(20) default 0,
  rent_type                     int(4) default 0,
  shade                         bigint(20) default 0,
  decoration                    int(4) default 0,
  shop_sign_size_one            bigint,
  shop_sign_size_two            bigint,
  power                         int(4) default 0,
  capacitance                   varchar(20) default '0',
  capacity_increase             int(4) default 0,
  up_pipe                       int(4) default 0,
  down_pipe                     int(4) default 0,
  down_pipe_diameter            varchar(20) default '0',
  gas                           int(4) default 0,
  gas_cylinders                 int(4) default 0,
  fire                          int(4) default 0,
  duct                          int(4) default 0,
  duct_rate                     int(4) default 0,
  blow_off                      int(4) default 0,
  grease_trap                   int(4) default 0,
  oil_fume                      int(4) default 0,
  self_car_port_size            int(4) default 0,
  around_car_port_size          int(4) default 0,
  out_ward                      int(4) default 0,
  business                      varchar(255),
  chummage_daily                bigint(20) default 0,
  chummage_month                bigint(20) default 0,
  chummage_year                 bigint(20) default 0,
  chummage_increase             int(4) default 0,
  chummage_increase_rule        varchar(20) default '',
  transfer_cost                 bigint(20) default 0,
  pledge_month                  varchar(20) default '',
  pay_month                     varchar(20) default '',
  property_fee                  bigint(20) default 0,
  water_fee                     bigint(20) default 0,
  gas_fee                       bigint(20) default 0,
  elas_fee                      bigint(20) default 0,
  shop_sign_rate                bigint,
  next_pay_rent_date            datetime(6),
  max_rent_year                 varchar(50) default '',
  repetition                    int(4) default 0,
  marchat_level                 int(4) default 10,
  house_level                   int(4) default 10,
  good                          varchar(255),
  bad                           varchar(255),
  proposed                      varchar(255),
  per_person_min                bigint(20) default 0,
  per_person_max                bigint(20) default 0,
  describtion                   varchar(255),
  house_source                  integer,
  source_name                   varchar(255),
  status                        int(4) default 2,
  contact_id                    integer,
  updated_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
  created_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
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
  title                         int(4) default 1,
  status                        integer,
  updated_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
  created_date                  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP not null,
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

