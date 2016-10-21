drop table Book if exists;

create table Book (ID bigint identity primary key, NAME varchar(200) not null,
                        AUTHOR varchar(50) not null, QUANTITY int);
