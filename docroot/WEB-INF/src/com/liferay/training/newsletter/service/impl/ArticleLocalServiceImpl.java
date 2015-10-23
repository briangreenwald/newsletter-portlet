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
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.training.newsletter.NoSuchArticleException;
import com.liferay.training.newsletter.model.Article;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;
import com.liferay.training.newsletter.service.base.ArticleLocalServiceBaseImpl;

import java.util.ArrayList;
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
			long journalArticleId, long groupId, long companyId, long userId, 
			String userName, int issueNo, String title, String author, 
			int order, String content) 
		throws SystemException, PortalException {

		long articleId = counterLocalService.increment(Article.class.getName());
		Article article = createArticle(articleId);
		article.setArticleId(articleId);
		
		Issue issue = 
			IssueLocalServiceUtil.getIssueByJournalArticleId(journalArticleId);
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

		return super.addArticle(article);
	}

	public Article updateArticle(
			long journalArticleId, long groupId, long companyId, 
			long userId, String userName, int issueNo, String title, 
			String author, int order, String content)
		throws SystemException, PortalException {

		Article article = getArticleByJournalArticleId(journalArticleId);

		Date now = new Date();
		Issue issue =
			IssueLocalServiceUtil.getIssueByJournalArticleId(journalArticleId);
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

		return super.updateArticle(article);
	}
	
	public List<Article> getApprovedArticlesByIssueNo(int issueNo) 
		throws SystemException, PortalException {
		
		List<Article> allArticles = articlePersistence.findByIssueNo(issueNo);
		List<Article> approvedArticles = new ArrayList<Article>();
		
		for (Article article : allArticles) {
			long journalArticleId = article.getJournalArticleId();
			JournalArticle journalArticle 
				= JournalArticleLocalServiceUtil.getArticle(journalArticleId);
			
			if (journalArticle.isApproved()) {
				approvedArticles.add(article);
			}
		}
		return approvedArticles;
	}
	
	public Article getArticleByJournalArticleId(long journalArticleId) 
		throws NoSuchArticleException, SystemException {
		
		return articlePersistence.findByJournalArticleId(journalArticleId);
	}
	
}