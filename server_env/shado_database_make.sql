CREATE DATABASE IF NOT EXISTS shado_database;
USE shado_database;

-- cleaning before create
DROP TABLE IF EXISTS SHADO_SESSION;
DROP TABLE IF EXISTS SHADO_USER;
DROP TABLE IF EXISTS SHADO_GROUP;
DROP TABLE IF EXISTS SHADO_PROGRAM_LOG;
/*
 TABLE FOR STORING USER GROUPS DATA
 Default user groups:
 shado_group_code: ADMIN - full privileges,
 shado_group_code: USER  - normal privileges
 */
CREATE TABLE SHADO_GROUP
(
    shado_group_id INT AUTO_INCREMENT PRIMARY KEY,
    shado_group_name VARCHAR(10),
    shado_group_desc VARCHAR(250),
    shado_group_code VARCHAR(20)
)AUTO_INCREMENT = 10;

/*
 TABLE FOR STORING SHADO LOG DATA
 */
CREATE TABLE SHADO_PROGRAM_LOG
(
    shado_programlog_id INT AUTO_INCREMENT PRIMARY KEY,
    program_log_desc VARCHAR(450),
    program_log_code VARCHAR(70)
);
/*
 TABLE FOR STORING USER
 Login generated by server, password stored as hash
 */
CREATE TABLE SHADO_USER
(
    shado_user_id INT AUTO_INCREMENT PRIMARY KEY,
    shado_group_id INT,
    shado_user_login VARCHAR(40),
    shado_user_name VARCHAR(100),
    shado_user_surname VARCHAR(150),
    shado_user_password VARCHAR(400),
    shado_user_email VARCHAR(250),

    CONSTRAINT fk_shado_user1 FOREIGN KEY (shado_group_id) REFERENCES SHADO_GROUP(shado_group_id)
)AUTO_INCREMENT=1000;
/*
 TABLE FOR STORING USER SESSIONS
 */
CREATE TABLE SHADO_SESSION
(
    shado_session_id INT AUTO_INCREMENT PRIMARY KEY,
    shado_session_time TIMESTAMP,
    shado_session_code VARCHAR(20),
    shado_user_id INT,

    CONSTRAINT fk_shado_session1 FOREIGN KEY (shado_user_id) REFERENCES SHADO_USER(shado_user_id)
)AUTO_INCREMENT=10000;

/*
 SETTING DEFAULT VALUES FOR STARING STATE OF DATABASE
 */
INSERT INTO SHADO_GROUP (shado_group_name,shado_group_desc,shado_group_code) VALUES ('ADMIN','Users with admin privileges','ADMIN-USR');
INSERT INTO SHADO_GROUP (shado_group_name,shado_group_desc,shado_group_code) VALUES ('USER','Normal users of SHADO APP','SHD-USER');
INSERT INTO SHADO_USER (shado_group_id, shado_user_login,shado_user_name,shado_user_surname,shado_user_password,shado_user_email)
VALUES(10,'admin','Admin','Admin','21232f297a57a5a743894a0e4a801fc3','');