use test;

drop table user;

create table if not exists user (
uid INT unsigned auto_increment,
uname varchar(16) unique not null,
password varchar(16) not null,
email varchar(40) unique not null,
primary key (uid)
)engine=InnoDB Default charset = utf8mb4;

DROP PROCEDURE IF EXISTS pro_initData;/*如果存在此存储过程则删掉*/
DELIMITER $
CREATE PROCEDURE pro_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=30 DO
        INSERT INTO user 
        (uname,password,email) 
        VALUES
        (concat('user',i),'123456',concat(concat('email',i),'@zju.com'));
        SET i = i+1;
    END WHILE;
END $
CALL pro_initData();


select * from user