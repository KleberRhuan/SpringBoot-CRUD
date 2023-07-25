alter table doctors add column inactive boolean default false;
alter table clients add column inactive boolean default false;
update clients set inactive = false;
update doctors set inactive = false;
