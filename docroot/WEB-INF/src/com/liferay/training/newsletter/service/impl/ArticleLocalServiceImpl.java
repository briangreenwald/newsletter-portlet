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
	
	public Article addArticle(
			String journalArticleId, long groupId, long companyId, long userId, 
			String userName, int issueNo, String title, String author, 
			int order, String content, int status) 
		throws SystemException, PortalException {

		long articleId = counterLocalService.increment(Article.class.getName());
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
				System.out.println("Search Exception:" + se);
			}
		}

		return super.addArticle(article);
	}

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
				System.out.println("Search Exception:" + se);
			}
		}
		return super.updateArticle(article);
	}
	
	public Article deleteArticle(Article article) throws SystemException {
		
		int issueNo = article.getIssueNo();
		
		try {
			Issue issue = IssueLocalServiceUtil.getIssueByIssueNo(issueNo);
		
			Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);
		
			try {
				indexer.delete(issue);
			}
			catch (SearchException se) {
				System.out.println("Search Exception:" + se);
			}
		}
		catch (NoSuchIssueException e) {
			
		}
		
		return super.deleteArticle(article);
	}
	
	public List<Article> getApprovedArticlesByIssueNo(int issueNo) 
		throws SystemException {
		
		return articlePersistence.findByIssueNo(issueNo, WorkflowConstants.STATUS_APPROVED);
	}
	
	public Article getArticleByJournalArticleId(String journalArticleId) 
		throws NoSuchArticleException, SystemException {
		
		return articlePersistence.findByJournalArticleId(journalArticleId);
	}
	
}