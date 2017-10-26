select * from votingSystem.user;


CREATE TABLE  votingSystem.user(
     username        VARCHAR (20)  NOT NULL,
     email           VARCHAR (80)  NOT NULL,
     fullname        VARCHAR (20)  NOT NULL,
     password        VARCHAR (20)  NOT NULL,
     type          VARCHAR (20)  NOT NULL,
     PRIMARY KEY (username)
);

insert into votingSystem.user values ("DeepaliPa24", "patil.de@husky.neu.edu", "Deepali", "DeepaliPa24", "Admin");
