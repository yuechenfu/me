
INSERT INTO person (id, firstName, lastName, phone, email,   type, imgsrc, location, jobTitle, createAt, updateAt) VALUES (2, 'User2', 'dr', '1233232342', 'user_b@hiveel.com',  'SE', '',  'walnut'    ,  '', '2019-02-28T02:20:21', '2019-02-28T02:20:21');
INSERT INTO person (id, firstName, lastName, phone, email,   type, imgsrc, location, jobTitle, createAt, updateAt) VALUES (3, 'User3', 'mg', '1233232342', 'user_c@hiveel.com',  'MG', '',  'diamond bar', '','2019-02-28T02:20:22', '2019-02-28T02:20:22');


INSERT INTO account (id, username, lastName, phone, email,   type, imgsrc, location, jobTitle, createAt, updateAt) VALUES (1,'tom@abc.com','87475dd38a4df178d3c95e77a216a61d','2',  'SE','Active','2019-06-11 04:55:41','2019-06-23 05:41:54');
INSERT INTO account (id, username, lastName, phone, email,   type, imgsrc, location, jobTitle, createAt, updateAt) VALUES (2,'admin@xyz.com','87475dd38a4df178d3c95e77a216a61d','3',   'MG','Active','2019-06-10 16:14:02','2019-06-10 16:14:10');
INSERT INTO account (id, username, lastName, phone, email,   type, imgsrc, location, jobTitle, createAt, updateAt) VALUES (3,'infnic@epm.com','87475dd38a4df178d3c95e77a216a61d','1','CO','Active','2019-06-10 16:14:47','2019-06-14 23:31:24');


INSERT INTO  `jobsetting` (`id`,`jobId`, `name`, `value`, `createAt`, `updateAt`) VALUES ('1','1', 'reciveType', 'email', '2019-02-28T02:20:20', '2019-02-28T02:20:20');
INSERT INTO  `jobsetting` (`id`, `jobId`,`name`, `value`, `createAt`, `updateAt`) VALUES ('2', '1', 'hireCount', '10', '2019-02-28T02:20:20', '2019-02-28T02:20:20');
INSERT INTO  `jobsetting` (`id`,`jobId`, `name`, `value`, `createAt`, `updateAt`) VALUES ('3', '1', 'ugently', '1 to 3 days', '2019-02-28T02:20:20', '2019-02-28T02:20:20');
INSERT INTO  `jobsetting` (`id`, `jobId`,`name`, `value`, `createAt`, `updateAt`) VALUES ('4', '1', 'reciveEmail', 'abc@163.com', '2019-02-28T02:20:20', '2019-02-28T02:20:20');
INSERT INTO  `jobsetting` (`id`, `jobId`,`name`, `value`, `createAt`, `updateAt`) VALUES ('5', '1', 'reciveEmail', 'xyz@163.com', '2019-02-28T02:20:20', '2019-02-28T02:20:20');
INSERT INTO  `jobsetting` (`id`, `jobId`,`name`, `value`, `createAt`, `updateAt`) VALUES ('6', '1', 'qualification', '1 to 3 years experience', '2019-02-28T02:20:20', '2019-02-28T02:20:20');