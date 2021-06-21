-- Hschool 접속

create database hschool;

use hschool;

CREATE TABLE tbl_student(
    st_num	    CHAR(8)	        PRIMARY KEY,
    st_name	    VARCHAR(20)	NOT NULL,
    st_dept	    VARCHAR(20)	NOT NULL,
    st_grade	INT	        NOT NULL,
    st_tel	    VARCHAR(15)	NOT NULL,
    st_addr	    VARCHAR(125)	
);

CREATE TABLE tbl_score(
    sc_seq	    BIGINT		auto_increment PRIMARY KEY,
    sc_stnum	CHAR(8)	        NOT NULL,
    sc_subject	VARCHAR(20)	NOT NULL,
    sc_score	INT	        NOT NULL
);

ALTER TABLE tbl_student
ADD UNIQUE(st_name, st_dept, st_tel);

   
INSERT INTO tbl_student(
    st_num, st_name, st_dept,
    st_grade, st_tel, st_addr)
    VALUES ( 
    20210001, '홍길동', '전자공학', '2', '010-1111-2222', '서울시');

INSERT INTO tbl_student(
    st_num, st_name, st_dept,
    st_grade, st_tel, st_addr)
    VALUES ( 
    20210002, '이몽룡', '컴퓨터공학', '3', '010-1111-2222', '서울시');
    
INSERT INTO tbl_score(
    sc_stnum, sc_subject, sc_score)
    VALUES(
    20210002, '국어', 80
    );
    
INSERT INTO tbl_score(
    sc_stnum, sc_subject, sc_score)
    VALUES(
    20210002, '수학', 100
    );
    
SELECT * FROM tbl_score;
    
ALTER TABLE tbl_score
ADD CONSTRAINT fk_student
FOREIGN KEY(sc_stnum)
REFERENCES tbl_student(st_num);

SELECT * FROM tbl_score;
SELECT * FROM tbl_student;

SELECT COUNT (sc_subject) FROM tbl_score
GROUP BY sc_stnum;

SELECT COUNT (sc_subject) FROM tbl_score
GROUP BY sc_stnum;

CREATE VIEW view_학생성적 AS(
SELECT st.st_num AS 학번,
        st.st_name AS 이름,
        st.st_dept AS 전공,
        st.st_grade AS 학년,
        COUNT(sc.sc_subject) AS 응시과목,
        SUM(sc.sc_score) AS 총점,
        ROUND(AVG(sc.sc_score),1) AS 평균
    FROM tbl_student st
        LEFT JOIN tbl_score sc
            ON st.st_num = sc.sc_stnum
GROUP BY st.st_num, st.st_name, st.st_dept, st.st_grade
);

SELECT * FROM view_학생성적;

    

