use test;

drop table if exists questionNaire;

create table if not exists questionNaire
(
    qid       INT unsigned auto_increment,
    title     varchar(16) unique not null,
    info      varchar(128)       not null,
    uid       INT unsigned,
    authority INT unsigned,
    itemType  INT unsigned,
    itemInfo  varchar(8096),
    primary key (qid)
) engine = InnoDB
  Default charset = utf8mb4;

DROP PROCEDURE IF EXISTS pro_initData;/*如果存在此存储过程则删掉*/
DELIMITER $
CREATE PROCEDURE pro_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 30
        DO
            INSERT INTO questionNaire
                (title, info, uid, authority, itemType, itemInfo)
            VALUES (concat('title', i + 60), 'info', 3, i % 3, i % 7, 'item_info');
            SET i = i + 1;
        END WHILE;
END $
CALL pro_initData();

select *
from questionNaire