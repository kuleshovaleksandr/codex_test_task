create table item
(
    id       uuid not null,
    name     varchar(255),
    description varchar(255),
    primary key (id)
);

create table tag
(
    id      uuid         not null,
    name    varchar(255) not null,
    primary key (id)
);

create table users
(
    id      uuid     not null,
    name    varchar(255),
    password varchar(255),
    email varchar(255),
    role varchar(10),
    primary key (id)
);

create table item_tag
(
    item_id  uuid not null,
    tag_id uuid not null
);

create table bag
(
    user_id  uuid not null,
    item_id uuid not null
);

alter table item_tag
    add constraint FK_item_id_item foreign key (item_id) references item;

alter table item_tag
    add constraint FK_tag_id_tag foreign key (tag_id) references tag;

alter table bag
    add constraint FK_user_id_user foreign key (user_id) references users;

alter table bag
    add constraint FK_item_id_item_bag foreign key (item_id) references item;
