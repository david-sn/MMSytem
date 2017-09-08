create table ichalet_user(user_Id number PRIMARY KEY,password VARCHAR2(150),email_address VARCHAR2(75),ACCESS_TOKEN VARCHAR2(75));create TABLE ichalet_system_roles(Role_ID NUMBER PRIMARY key,Role_Name VARCHAR2(75));create TABLE account_role(user_Id NUMBER REFERENCES ichalet_user(user_Id), Role_ID NUMBER REFERENCES ichalet_system_roles(Role_ID));


create TABLE book_store(
dbid NUMBER(18,0) CONSTRAINT bo_st_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER(1,0) DEFAULT '0',
locked NUMBER (1,0)DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
store_name VARCHAR2(255),
open_time TIMESTAMP,
close_time TIMESTAMP,
day_index VARCHAR2(20),
plicy_rule VARCHAR2(1000),
phone VARCHAR2(25),
address VARCHAR2(255),
member_detail_dbid_responsible NUMBER(18,0) CONSTRAINT bo_st_me_de_db_re_fk REFERENCES member_detail(dbid),
user_Account_dbid_responsible NUMBER(18,0) CONSTRAINT bo_st_us_ac_db_re_fk REFERENCES user_Account(dbid),
max_number_to_borrow NUMBER(3),
max_days_to_borrow NUMBER(3)
);
 


create TABLE submit_task(
dbid NUMBER(18,0)CONSTRAINT su_ta_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
notes VARCHAR2(255),
attach_file BFILE,
attach_file2 BFILE,
attach_file3 BFILE,
actual_degree NUMBER,
member_detail_dbid NUMBER,
lookup_task_dbid NUMBER(18,0)CONSTRAINT as_de_ta_lo_ta_db_fk REFERENCES lookup_task(dbid)
);


create table lookup_task(
dbid NUMBER(18,0)CONSTRAINT lo_ta_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
task_title VARCHAR2(255),
task_title_en VARCHAR2(255),
expire_date DATE,
attach_file BFILE,
attach_file2 BFILE,
attach_file3 BFILE,
description CLOB,
lookup_task_type_dbid NUMBER(18,0)CONSTRAINT lo_ta_lo_ta_ty_db_fk REFERENCES lookup_task_type(dbid),
lookup_department_dbid_assign NUMBER,
min_degree NUMBER(4),
max_degree NUMBER(4),
top_delivered_full_mark NUMBER
);


create table lookup_task_type(
dbid NUMBER(18,0)CONSTRAINT lo_ta_ty_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
task_title VARCHAR2(255),
task_title_en VARCHAR2(255)
);


create TABLE follow_up_sheet_Detail(
dbid NUMBER(18,0)CONSTRAINT fo_up_sh_de_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
follow_up_sheet_dbid NUMBER(18,0)CONSTRAINT fo_up_sh_de_fo_up_sh_db_fk REFERENCES follow_up_sheet(dbid),
follow_up_dbid NUMBER(18,0)CONSTRAINT fo_up_sh_de_fo_up_db_fk REFERENCES follow_up(dbid),
notes CLOB,
target_success CHAR DEFAULT '0',
lookup_sheet_status_dbid NUMBER(18,0)CONSTRAINT fo_up_sh_de_lo_sh_st_db_fk REFERENCES lookup_sheet_status(dbid)
);


create TABLE lookup_sheet_status(
dbid NUMBER(18,0)CONSTRAINT lo_sh_st_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
sheet_status_name VARCHAR2(255),
sheet_status_name_en VARCHAR2(255)
);


create TABLE follow_up_sheet(
dbid NUMBER(18,0)CONSTRAINT fo_up_sh_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
sheet_from_date DATE,
sheet_to_date DATE,
sheet_title VARCHAR2(255),
sheet_title_en VARCHAR2(255),
assigned_to_member_detail_dbid NUMBER(18,0)CONSTRAINT fo_up_sh_as_to_me_de_db_fk REFERENCES member_detail(dbid)
);


create table follow_up(
dbid NUMBER(18,0)CONSTRAINT fo_up_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
member_detail_dbid_subervise NUMBER(18,0)CONSTRAINT fo_up_me_de_db_su_fk REFERENCES member_detail(dbid) CONSTRAINT fo_up_me_de_db_su_un UNIQUE,
member_detail_dbid_child NUMBER(18,0)CONSTRAINT fo_up_me_de_db_ch_fk REFERENCES member_detail(dbid) CONSTRAINT fo_up_me_de_db_ch_un UNIQUE
);


CREATE TABLE lookup_message_templete(
dbid NUMBER(18,0)CONSTRAINT lo_me_te_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
message_title VARCHAR2(255),
message_title_en VARCHAR2(255),
message_body VARCHAR2(500) DEFAULT'' CONSTRAINT lo_me_te_me_bo_nn NOT NULL,
message_body_en VARCHAR2(500)DEFAULT'' CONSTRAINT lo_me_te_me_boe_nn NOT NULL,
lookup_category_message_dbid NUMBER(18,0)CONSTRAINT lo_me_te_lo_ca_db REFERENCES lookup_message_category(dbid),
lookup_category_message_dbid_d NUMBER(18,0)CONSTRAINT lo_me_te_lo_ca_me_db_de REFERENCES lookup_message_category(dbid)
);


create TABLE lookup_message_category(
dbid NUMBER(18,0)CONSTRAINT lo_me_ca_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
category_name VARCHAR2(255),
send_every_day_index NUMBER(1),
send_every_date DATE,
last_send_date DATE
);


create TABLE lookup_user_type(
dbid NUMBER(18,0)CONSTRAINT lo_us_ty_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
user_type_name VARCHAR2(255),
user_type_name_en VARCHAR2(255)
);


create TABLE user_Account(
dbid NUMBER(18,0)CONSTRAINT us_ac_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
first_name VARCHAR2(255),
last_name VARCHAR2(255),
email VARCHAR2(255) CONSTRAINT us_ac_em UNIQUE,
password VARCHAR2(255),
img BFILE,
phone VARCHAR2(50),
address VARCHAR2(255),
lookup_user_type_dbid NUMBER(18,0)CONSTRAINT us_ac_lo_us_ty_fk REFERENCES lookup_user_type(dbid),
member_detail_dbid NUMBER(18,0)CONSTRAINT us_ac_me_de_db_fk REFERENCES member_detail(dbid),
allow_user_creation  NUMBER (1,0) ,
last_login_date DATE,
mac_address_login VARCHAR2(20),
ip_address VARCHAR2(100),
access_token VARCHAR2(255),
password_expire_duration_days NUMBER(18,0)DEFAULT 100,
expire_date DATE,
login_start_time TIMESTAMP DEFAULT to_timestamp('12:00 am','hh:mi am'),
login_end_time TIMESTAMP DEFAULT to_timestamp('12:00 pm','hh:mi pm')
);


create TABLE lookup_role(
dbid NUMBER(18,0)CONSTRAINT lo_ro_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
role_name VARCHAR2(255)
);


create TABLE user_Role(
lookup_role_dbid NUMBER(18,0)CONSTRAINT us_ro_lo_ro_db_fk REFERENCES lookup_role(dbid),
user_Account_dbid NUMBER(18,0)CONSTRAINT us_ro_us_ac_db_fk REFERENCES user_Account(dbid)
);


CREATE TABLE attendance_segment(
dbid NUMBER(18,0)CONSTRAINT at_se_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
CHECK_in_date DATE,
member_detail_dbid NUMBER,
time_segment_rules_dbid NUMBER,
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate
);


create TABLE time_segment_rules(
dbid NUMBER(18,0)CONSTRAINT ti_se_ru_db_pk PRIMARY KEY ,
code VARCHAR2(50),
segment_name NVARCHAR2(255) DEFAULT '' CONSTRAINT ti_se_ru_se_na_nn NOT NULL CONSTRAINT ti_se_ru_se_na_un UNIQUE,
segment_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT ti_se_ru_se_nae_nn NOT NULL CONSTRAINT ti_se_ru_se_nae_un UNIQUE,
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
lookup_meeting_dbid NUMBER(18,0)CONSTRAINT ti_se_lo_me_db REFERENCES lookup_meeting(dbid),
start_workin_date DATE DEFAULT sysdate,
end_working_date DATE,
start_day_index number(1),
early_come_min NUMBER,
actual_start_time TIMESTAMP,
late_come NUMBER,
actual_finish_time TIMESTAMP,
is_current  NUMBER (1,0) ,
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate
);


create table event(
dbid NUMBER(18,0)CONSTRAINT ev_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate,
from_date TIMESTAMP,
to_date TIMESTAMP,
event_title VARCHAR2(255),
event_title_en VARCHAR2(255),
event_description CLOB,
event_description_en CLOB,
lookup_event_type NUMBER(18,0)CONSTRAINT ev_lo_ev_ty REFERENCES lookup_event_type(dbid),
warninig_text varchar2(255),
cover_img BFILE,
img1 BLOB,
img2 BLOB,
img3 BLOB,
location_detail VARCHAR2(255),
lookup_city_dbid NUMBER,
price DECIMAL DEFAULT 0.0,
responsible1_dbid NUMBER,
responsible2_dbid NUMBER,
responsible_name VARCHAR2(255),
responsible_mobile VARCHAR2(25),
private_invitation  NUMBER (1,0) 
);


create table lookup_event_type(
dbid NUMBER(18,0)CONSTRAINT lo_ev_ty_db_pk PRIMARY KEY ,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
type_name VARCHAR2(255) DEFAULT '' CONSTRAINT lo_ev_ty_ty_na_nn NOT NULL,
type_name_en VARCHAR2(255) DEFAULT '' CONSTRAINT lo_ev_ty_ty_nae_nn NOT NULL,
description VARCHAR2(500),
description_en VARCHAR2(500)
);


create TABLE lookup_hall(
dbid NUMBER(18,0)CONSTRAINT lo_ha_db_pk PRIMARY KEY ,
code VARCHAR2(50),
hall_name NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_ha_ha_na_nn NOT NULL CONSTRAINT llo_ha_ha_na_un UNIQUE,
hall_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_ha_ha_nae_nn NOT NULL CONSTRAINT lo_ha_ha_nae_un UNIQUE,
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
location_detail VARCHAR2(255),
location_detail_en VARCHAR2(255),
near_from_place VARCHAR2(255),
behind_place VARCHAR2(255),
in_front_of_place VARCHAR2(255),
lookup_church_dbid CONSTRAINT lo_ha_lo_ch_db REFERENCES lookup_church(dbid),
capacity number(3),
responsible1_name VARCHAR2(255),
responsible1_name_en VARCHAR2(255),
responsible1_mobile1 VARCHAR2(50),
responsible1_mobile2 VARCHAR2(50),
responsible1_img VARCHAR2(50),
responsible2_name VARCHAR2(255),
responsible2_name_en VARCHAR2(255),
responsible2_mobile1 VARCHAR2(50),
responsible2_mobile2 VARCHAR2(50),
responsible2_img VARCHAR2(50)
);


create table lookup_meeting(
dbid NUMBER(18,0)CONSTRAINT lo_me_db_pk PRIMARY KEY ,
code VARCHAR2(50),
meeting_name NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_me_me_na_nn NOT NULL CONSTRAINT lo_me_me_na_un UNIQUE,
meeting_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_me_me_nae_nn NOT NULL CONSTRAINT lo_me_me_nae_un UNIQUE,
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
description CLOB,
meeting_manager number,
father_manager1 NUMBER,
father_manager2 NUMBER,
last_updated date DEFAULT sysdate,
per_monthly char(1),
per_week char(1),
no_work_per_unit NUMBER(1,0),
expected_no_attend_in_summer NUMBER,
expected_no_attend_in_winter NUMBER,
facebook_account VARCHAR2(255),
meeting_mobile1 VARCHAR2(255),
meeting_mobile2 VARCHAR2(255),
lookup_hall_dbid_fixed NUMBER(18,0)CONSTRAINT lo_me_lo_ha_db_fi_re REFERENCES lookup_hall(dbid),
place_fixed  NUMBER (1,0) ,
ignore_attendace_after_no_late NUMBER
);


CREATE TABLE department_position(
dbid NUMBER(18,0)CONSTRAINT de_po_db_pk PRIMARY KEY ,
lookup_department NUMBER(18,0)CONSTRAINT de_po_lo_de_fk REFERENCES lookup_department(dbid),
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
start_date DATE DEFAULT sysdate,
expire_date DATE,
start_join_date DATE DEFAULT sysdate,
normal_capacity_participation number,
max_capacity_participation number,
direct_manager NUMBER(18,0)CONSTRAINT de_po_di_ma_nu NOT NULL,
last_updated date DEFAULT sysdate,
team_leader number,
description CLOB,
need_confirmation_to_join  NUMBER (1,0) ,
file_attache1 VARCHAR2(255),
file_attache2 VARCHAR2(255),
min_experienec NUMBER
);


create table lookup_department(
dbid NUMBER(18,0)CONSTRAINT lo_de_db_pk PRIMARY KEY ,
code VARCHAR2(50),
department_name NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_de_de_na_nn NOT NULL CONSTRAINT lo_de_de_na_un UNIQUE,
department_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_de_de_nae_nn NOT NULL CONSTRAINT lo_de_de_nae_un UNIQUE,
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
root  NUMBER (1,0) ,
parent_department NUMBER(18,0)CONSTRAINT lo_de_pa_de_fk REFERENCES lookup_department(dbid),
at_level NUMBER(5),
direct_manager NUMBER(18,0)CONSTRAINT lo_de_de_ma_no_nu NOT NULL,
start_date DATE DEFAULT sysdate,
expire_date DATE,
start_join_position_date DATE DEFAULT sysdate,
private_department NUMBER (1,0) DEFAULT '0'
);


create table lookup_church(
dbid NUMBER(18,0)CONSTRAINT lo_ch_db_pk PRIMARY KEY ,
church_name NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_ch_ch_na_nn NOT NULL CONSTRAINT lo_ch_ch_na_un UNIQUE,
church_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_ch_ch_nae_nn NOT NULL CONSTRAINT lo_ch_che_un UNIQUE,
lng DECIMAL,
lat DECIMAL,
lookup_city_dbid NUMBER(18,0)CONSTRAINT lo_ch_lo_ci_db_fk REFERENCES lookup_country(dbid),
 code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate
);


create table lookup_father(
dbid NUMBER(18,0)CONSTRAINT lo_fa_db_pk PRIMARY KEY ,
father_name NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_fa_fa_na_nn NOT NULL CONSTRAINT lo_fa_fa_na_un UNIQUE,
father_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_fa_fa_nae_nn NOT NULL CONSTRAINT lo_fa_fa_nae_un UNIQUE,
father_phone VARCHAR2(50) CONSTRAINT lo_fa_fa_ph_un UNIQUE,
lookup_church_dbid NUMBER(18,0)CONSTRAINT lo_fa_lo_ch_db_fk REFERENCES lookup_church(dbid),
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate
);


create table lookup_meeting_type(
dbid NUMBER(18,0)CONSTRAINT lo_me_ty_db_pk PRIMARY KEY ,
type_name NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_me_ty_ty_na_nn NOT NULL CONSTRAINT lo_me_ty_ty_na_un UNIQUE,
type_name_en NVARCHAR2(255) DEFAULT '' CONSTRAINT lo_me_ty_nae_nn NOT NULL CONSTRAINT lo_me_ty_nae_un UNIQUE,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate
);


create table lookup_city(
dbid NUMBER(18,0)CONSTRAINT lo_ci_db_pk PRIMARY KEY ,
city_name VARCHAR2(255) DEFAULT '' CONSTRAINT lo_ci_cn_nn NOT NULL CONSTRAINT lo_ci_cn_un UNIQUE,
city_name_en VARCHAR2(255)DEFAULT '' CONSTRAINT lo_ci_cne_nn NOT NULL CONSTRAINT lo_ci_cne_un UNIQUE,
shortcut VARCHAR2(20)CONSTRAINT lo_ci_sh_un UNIQUE,
lookup_country_dbid NUMBER(18,0) CONSTRAINT lo_ci_db_nn NOT NULL  CONSTRAINT lo_co_cn_fk REFERENCES lookup_country(dbid),
lng DECIMAL,
lat DECIMAL, 
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate 
);


create table lookup_country(
dbid NUMBER(18,0)CONSTRAINT lo_co_db_pk PRIMARY KEY ,
country_name VARCHAR2(255) DEFAULT '' CONSTRAINT lo_co_cn_nn NOT NULL CONSTRAINT lo_co_cn_un UNIQUE,
country_name_en VARCHAR2(255)DEFAULT '' CONSTRAINT lo_co_cne_nn NOT NULL CONSTRAINT lo_co_cne_un UNIQUE,
shortcut VARCHAR2(20)CONSTRAINT lo_co_sh_un UNIQUE,
lng DECIMAL,
lat DECIMAL,
code VARCHAR2(50),
deleted NUMBER (1,0) DEFAULT '0',
locked  NUMBER (1,0) DEFAULT '0',
last_updated date DEFAULT sysdate,
created_date DATE DEFAULT sysdate
);


create table member_detail(
dbid NUMBER(18,0)CONSTRAINT me_de_db_pk PRIMARY KEY ,
code NVARCHAR2(255),
fname NVARCHAR2(255) DEFAULT '' CONSTRAINT me_de_fn_nn NOT NULL  ,
lname NVARCHAR2(255) DEFAULT '' CONSTRAINT me_de_ln_nn NOT NULL,
fname_en NVARCHAR2(255) DEFAULT '' CONSTRAINT me_de_fne_nn NOT NULL ,
lname_en NVARCHAR2(255) DEFAULT '' CONSTRAINT me_de_lne_nn NOT NULL ,
phone1 NVARCHAR2(30) CONSTRAINT me_de_ph1_un UNIQUE,
phone2 NVARCHAR2(30) CONSTRAINT me_de_ph2_un UNIQUE,
mobile1 NVARCHAR2(30) CONSTRAINT me_de_mo1_un UNIQUE,
mobile2 NVARCHAR2(30) CONSTRAINT me_de_mo2_un UNIQUE,
address1 NVARCHAR2(255) DEFAULT '' CONSTRAINT me_de_add_nn NOT NULL ,
address2 NVARCHAR2(255) ,
birthday DATE ,
photo1 BFILE,
photo2 BFILE,
deleted NUMBER (1,0) DEFAULT '0',
create_date DATE DEFAULT sysdate,
locked NUMBER (1,0) DEFAULT '0',
last_modified_date DATE ,
expire_date DATE,
notes CLOB,
gender NUMBER (1,0) DEFAULT '1',
working_on_time NUMBER (1,0) DEFAULT '0',
live_local NUMBER (1,0) DEFAULT '1',
inivited_by_member NUMBER(18,0)CONSTRAINT me_de_in_me_fk  REFERENCES member_detail(dbid),
close_from_member1 NUMBER(18,0)CONSTRAINT me_de_cl_me1_fk  REFERENCES member_detail(dbid),
close_from_member2 
CONSTRAINT me_de_cl_me2_fk  REFERENCES member_detail(dbid),
helpful NUMBER (1,0) DEFAULT '0',
join_in_department NUMBER (1,0) DEFAULT '0',
supervised  NUMBER (1,0) ,
lookup_meeting_dbid number CONSTRAINT me_de_lo_me_db_fk  REFERENCES lookup_meeting(dbid)
);
 26