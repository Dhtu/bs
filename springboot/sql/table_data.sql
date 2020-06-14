use test;

drop table if exists tableData;

create table if not exists tableData (
did INT unsigned auto_increment,
qid INT unsigned,
uid INT unsigned,
value varchar(1024),
primary key (did)
)engine=InnoDB Default charset = utf8mb4;

DROP PROCEDURE IF EXISTS pro_initData;--如果存在此存储过程则删掉
DELIMITER $
CREATE PROCEDURE pro_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=900 DO
        INSERT INTO tableData 
        (qid,uid,value) 
        VALUES
        (i%30+1,i/30+1,concat('value',i));
        SET i = i+1;
    END WHILE;
END $
CALL pro_initData();

select * from tableData