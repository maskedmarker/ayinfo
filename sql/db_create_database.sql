--drop database `ayinfo`;
create database `ayinfo` character set utf8 collate utf8_general_ci;

create user `ayinfo`@`localhost` identified by `ayinfo1234`;

grant all privileges on ayinfo.* to `ayinfo`@`localhost` identified by 'ayinfo1234';
flush priviliges;