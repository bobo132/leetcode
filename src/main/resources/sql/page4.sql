

-- quest_194

use db1;
create table person(
    id int primary key auto_increment,
    email varchar(65)
) charset utf8mb4 auto_increment = 0 engine innodb;

insert into person(email) values ('john@example.com'), ('bob@example.com'), ('john@example.com'), ('cc@boke.com');


#  quest_194
#  编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
# Id 是这个表的主键。

delete from person where id not in (select id from (select min(id) id from person group by email) t);
