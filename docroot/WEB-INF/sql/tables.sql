create table newsletter_Article (
	articleId LONG not null primary key,
	issueId LONG,
	journalArticleId VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	issueNo INTEGER,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	order_ INTEGER,
	content STRING null,
	status INTEGER
);

create table newsletter_Issue (
	issueId LONG not null primary key,
	journalArticleId VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	issueNo INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	issueDate DATE null,
	issueMonth INTEGER,
	issueYear INTEGER,
	byline VARCHAR(75) null,
	status INTEGER
);