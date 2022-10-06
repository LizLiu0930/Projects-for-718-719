-- Note: you should include your ER diagram and relational schema in the same 'question02 directory as this file
-- you ER diagram and relational schema can be in any standard file format

-- Your SQL code for Question 02 here - remember to include all drop, create and insert statements so the 
-- whole SQL script will execute as a single script to create everything:

drop table if exists questions_questionSets;
drop table if exists questions_quiz;
drop table if exists questionSets;
drop table if exists quiz;
drop table if exists question;
drop table if exists answers;
drop table if exists questionCategory;

create table questionCategory (
    name varchar(128),
    description TEXT
);

create table answers (
    id integer not null primary key,
    content TEXT
	);

create table questions (
    id integer not null primary key,
    point integer,
	    content TEXT,
	hint TEXT,
    answer_id integer not null, 
	questionCategory_name varchar(128),
	    foreign key (answer_id) references answers (id),
	 foreign key (questionCategory_name) references questionCategory (name)
);

create table quiz (
    id integer not null primary key
);

create table questionSets (
    id integer not null primary key,
    description TEXT
);

create table questions_quiz (
    questions_id INTEGER not null,
	    quiz_id INTEGER not null,
		primary key (questions_id, quiz_id), 
		    foreign key (questions_id) references questions (id),
    foreign key (quiz_id) references quiz (id)

);

create table questions_quiz (
    questions_id INTEGER not null,
	    questionSets_id INTEGER not null,
		primary key (questions_id, questionSets_id), 
		    foreign key (questions_id) references questions (id),
    foreign key (questionSets_id) references questionSets (id)

);



