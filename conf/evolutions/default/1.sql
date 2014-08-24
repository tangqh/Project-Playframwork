# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        bigint not null,
  name                      varchar(255),
  due_date                  timestamp,
  constraint pk_task primary key (id))
;

create sequence task_seq;




# --- !Downs

drop table if exists task cascade;

drop sequence if exists task_seq;

