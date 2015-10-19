create index IX_2AC8BAD4 on newsletter_Article (issueNo);
create index IX_52C2BF44 on newsletter_Article (journalArticleId);

create index IX_914B7952 on newsletter_Issue (issueMonth, issueYear);
create index IX_AE19C491 on newsletter_Issue (issueNo);
create index IX_E9C45A27 on newsletter_Issue (journalArticleId);