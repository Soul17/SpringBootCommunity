create table question
(
	id int auto_increment primary key,
	title VARCHAR(50),
	description TEXT,
	gmt_create BIGINT,
	gmt_modified BIGINT,
	creator int,
	view_count int default 0,
	like_count int default 0,
	tag VARCHAR(256)
);