create database dingdan;
use dingdan;

drop table if exists dishes;
create table dishes (
  dishId int primary key auto_increment,
  name varchar (50),
  price int
);
--price以分为单位，使用int表示，尽量不用double或者float，会存在误差
drop table if exists user;
create table user(
  userId int primary key auto_increment,
  name varchar (50) unique ,
  password varchar (50),
  isAdmin int
);
--isAdmin是否为管理员，0表示普通用户，1表示管理员
drop table if exists dingdan_user;
create table dingdan_user(
  orderId int primary key auto_increment,
  userId int,
  time datetime,
  isDone int,
  foreign key(userId) references user (userId)
);
--userId这个用户Id需要和user表中的userId具有关联关系
-- --下单时间
--isDone,1表示订单完结，0表示订单未完结
drop table if exists dingdan_dish;
create table dingdan_dish(
  orderId int,
  dishId int,
  foreign key (orderId) references dingdan_user(orderId),
  foreign key (dishId) references dishes(dishId)
);
--orderId也和order_user表的orderId字段有外键关系
-- --dishId也和dishes表中的dishId存在外键关系