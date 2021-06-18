-- 관리자 접속

CREATE TABLESPACE HschoolDB
DATAFILE 'C:/oraclexe/data/hschool.dbf'
SIZE 1M AUTOEXTEND ON NEXT 1K;

CREATE USER hschool IDENTIFIED BY hschool
DEFAULT TABLESPACE HschoolDB;

GRANT DBA TO hschool;