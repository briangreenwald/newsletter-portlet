/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.newsletter.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.training.newsletter.NoSuchArticleException;
import com.liferay.training.newsletter.NoSuchIssueException;
import com.liferay.training.newsletter.model.Article;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;
import com.liferay.training.newsletter.service.base.ArticleLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are 
 * added, rerun ServiceBuilder to copy their definitions into the 
 * {@link com.liferay.training.newsletter.service.ArticleLocalService} 
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security 
 * checks based on the propagated JAAS credentials because this service can only 
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Greenwald
 * @see com.liferay.training.newsletter.service.base.ArticleLocalServiceBaseImpl
 * @see com.liferay.training.newsletter.service.ArticleLocalServiceUtil
 */
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use 
	 * {@link com.liferay.training.newsletter.service.ArticleLocalServiceUtil} 
	 * to access the article local service.
	 */
	
	/**
	 * Creates a new Article object and persists it to the database. 
	 * 
	 * @param journalArticleId the articleId of the JournalArticle that this
	 * Article is created from.
	 * @param groupId the groupId of the Article.
	 * @param companyId the companyId of the Article.
	 * @param userId the userId of the Article's creator.
	 * @param userName the screenName of the Article's creator
	 * @param issueNo the issueNo that this Article belongs to.
	 * @param title the title of this Article.
	 * @param author the author of this Article.
	 * @param order the order in which this Article is to appear in an Issue's 
	 * list of Articles.
	 * @param content the html content of this Article.
	 * @param status the workflow status of this Article 
	 * (0=Approved, 1=Unapproved)
	 * 
	 */
	public Article addArticle(
			String journalArticleId, long groupId, long companyId, long userId, 
			String userName, int issueNo, String title, String author, 
			int order, String content, int status) 
		throws SystemException, PortalException {

		long articleId = Long.valueOf(journalArticleId) + groupId;
		Article article = createArticle(articleId);

		Issue issue = 
			IssueLocalServiceUtil.getIssueByIssueNo(issueNo);
		long issueId = issue.getIssueId();
		article.setIssueId(issueId);

		article.setJournalArticleId(journalArticleId);
		article.setGroupId(groupId);
		article.setCompanyId(companyId);
		article.setUserId(userId);
		article.setUserName(userName);

		Date now = new Date();
		article.setCreateDate(now);
		article.setModifiedDate(now);

		article.setIssueNo(issueNo);
		article.setTitle(title);
		article.setAuthor(author);
		article.setOrder(order);
		article.setContent(content);

		article.setStatus(status);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);
			try {
				indexer.reindex(issue);
			}
			catch (SearchException se) {
				_log.error(String.format(
					"Unable to index Issue{id = %d} for Article{id = %d}: %s", 
					article.getArticleId(), issue.getIssueId(), se));
			}
		}

		return super.addArticle(article);
	}

	/**
	 * Updates an Article object and persists the changes to the database.
	 * 
	 * This method will be called when either the workflow status of the 
	 * associated JournalArticle changes and when a new version of said
	 * JournalArticle is approved.
	 * 
	 * @param journalArticleId the articleId of the JournalArticle that this
	 * Article is created from.
	 * @param groupId the groupId of the Article.
	 * @param companyId the companyId of the Article.
	 * @param userId the userId of the Article's creator.
	 * @param userName the screenName of the Article's creator
	 * @param issueNo the issueNo that this Article belongs to.
	 * @param title the title of this Article.
	 * @param author the author of this Article.
	 * @param order the order in which this Article is to appear in an Issue's article
	 * list.
	 * @param content the html content of this Article.
	 * @param status the workflow status of this Article 
	 * (0=Approved, 1=Unapproved)
	 * 
	 */
	public Article updateArticle(
			String journalArticleId, long groupId, long companyId, 
			long userId, String userName, int issueNo, String title, 
			String author, int order, String content, int status)
		throws SystemException, PortalException {

		Article article = getArticleByJournalArticleId(journalArticleId);

		Date now = new Date();
		Issue issue =
			IssueLocalServiceUtil.getIssueByIssueNo(issueNo);
		long issueId = issue.getIssueId();

		article.setIssueId(issueId);
		article.setGroupId(groupId);
		article.setCompanyId(companyId);
		article.setUserId(userId);
		article.setUserName(userName);

		article.setModifiedDate(now);

		article.setIssueNo(issueNo);
		article.setTitle(title);
		article.setAuthor(author);
		article.setOrder(order);
		article.setContent(content);

		article.setStatus(status);

		if (status == WorkflowConstants.STATUS_APPROVED) {

			Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);
			try {
				indexer.reindex(issue);
			}
			catch (SearchException se) {
				_log.error(String.format(
					"Unable to index Issue{id = %d} for Article{id = %d}: %s", 
					article.getArticleId(), issue.getIssueId(), se));
			}
		}
		return super.updateArticle(article);
	}

	/**
	 * Removes the specified Article from the database.
	 * 
	 * @param article the article to be removed.
	 * 
	 * @return the removed article.
	 * 
	 */
	public Article deleteArticle(Article article) throws SystemException {

		int issueNo = article.getIssueNo();

		super.deleteArticle(article);

		// Reindex the issue to reflect the removal of an article
		try {
			Issue issue = IssueLocalServiceUtil.getIssueByIssueNo(issueNo);

			Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);

			try {
				indexer.reindex(issue);
			}
			catch (SearchException se) {
				_log.error(String.format(
					"Unable to index Issue{id = %d} for Article{id = %d}: %s", 
					article.getArticleId(), issue.getIssueId(), se));
			}
		}
		catch (NoSuchIssueException e) {
			_log.error(String.format("Unable to locate"));
		}

		return article;
	}

	/**
	 * Gets all Articles with the specified IssueNo that are Approved.
	 * 
	 * @param issueNo the issueNo for which to get Articles.
	 * 
	 * @return the approved Articles with the given issueNo.
	 */
	public List<Article> getApprovedArticlesByIssueNo(int issueNo) 
		throws SystemException {

		return articlePersistence.findByIssueNo(
			issueNo, WorkflowConstants.STATUS_APPROVED);
	}

	public Article getArticleByJournalArticleId(String journalArticleId) 
		throws NoSuchArticleException, SystemException {

		return articlePersistence.findByJournalArticleId(journalArticleId);
	}

	private static Log _log = 
		LogFactoryUtil.getLog(ArticleLocalServiceImpl.class.getName());

}