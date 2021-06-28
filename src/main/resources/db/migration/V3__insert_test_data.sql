insert into item
values ('602f347c-a79e-11eb-bcbc-0242ac130001', 'item1', 'item1 description');
insert into item
values ('602f347c-a79e-11eb-bcbc-0242ac130002', 'item2', 'item2 description');
insert into item
values ('602f347c-a79e-11eb-bcbc-0242ac130003', 'item3', 'item3 description');
insert into item
values ('602f347c-a79e-11eb-bcbc-0242ac130004', 'item4', 'item4 description');
insert into item
values ('602f347c-a79e-11eb-bcbc-0242ac130005', 'item5', 'item5 description');

insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130001', 'sale');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130002', 'LG');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130003', 'samsung');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130004', 'black');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130005', 'white');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130006', 'apple');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130007', 'sony');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130008', 'phone');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130009', 'camera');
insert into tag
values ('7889d51e-a79d-11eb-bcbc-0242ac130010', 'canon');

insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130001', '7889d51e-a79d-11eb-bcbc-0242ac130009');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130001', '7889d51e-a79d-11eb-bcbc-0242ac130010');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130001', '7889d51e-a79d-11eb-bcbc-0242ac130004');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130002', '7889d51e-a79d-11eb-bcbc-0242ac130006');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130002', '7889d51e-a79d-11eb-bcbc-0242ac130005');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130002', '7889d51e-a79d-11eb-bcbc-0242ac130008');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130003', '7889d51e-a79d-11eb-bcbc-0242ac130006');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130003', '7889d51e-a79d-11eb-bcbc-0242ac130004');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130003', '7889d51e-a79d-11eb-bcbc-0242ac130008');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130004', '7889d51e-a79d-11eb-bcbc-0242ac130002');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130004', '7889d51e-a79d-11eb-bcbc-0242ac130001');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130005', '7889d51e-a79d-11eb-bcbc-0242ac130003');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130005', '7889d51e-a79d-11eb-bcbc-0242ac130008');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130005', '7889d51e-a79d-11eb-bcbc-0242ac130005');
insert into item_tag
values ('602f347c-a79e-11eb-bcbc-0242ac130005', '7889d51e-a79d-11eb-bcbc-0242ac130001');


insert into users
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130001', 'user1', '$2y$12$A0ecnCOnBHT9p0Hnp6GkAe6WIaddNNcJDNvHoE3jFbgUimkdi.3PW', 'user1@gmail.com', 'USER');
insert into users
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130002', 'user2', '$2y$12$A0ecnCOnBHT9p0Hnp6GkAe6WIaddNNcJDNvHoE3jFbgUimkdi.3PW', 'user2@gmail.com', 'USER');
insert into users
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130003', 'user3', '$2y$12$A0ecnCOnBHT9p0Hnp6GkAe6WIaddNNcJDNvHoE3jFbgUimkdi.3PW', 'user3@gmail.com', 'USER');
insert into users
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130004', 'admin1', '$2y$12$xexAfRm4EkszF2Aq0bDOAOobvI2nFmkbJfJ9pHE37YYAjDhJzdf0O', 'admin1@gmail.com', 'ADMIN');
insert into users
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130005', 'admin2', '$2y$12$xexAfRm4EkszF2Aq0bDOAOobvI2nFmkbJfJ9pHE37YYAjDhJzdf0O', 'admin2@gmail.com', 'ADMIN');

insert into cart
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130001', '602f347c-a79e-11eb-bcbc-0242ac130001');
insert into cart
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130001', '602f347c-a79e-11eb-bcbc-0242ac130002');
insert into cart
values ('8ba50dc4-a79f-11eb-bcbc-0242ac130002', '602f347c-a79e-11eb-bcbc-0242ac130003');
