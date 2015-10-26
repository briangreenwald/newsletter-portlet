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

package com.liferay.training.newsletter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.training.newsletter.model.Article;

/**
 * The persistence interface for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Greenwald
 * @see ArticlePersistenceImpl
 * @see ArticleUtil
 * @generated
 */
public interface ArticlePersistence extends BasePersistence<Article> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the articles where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @return the matching articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Article> findByIssueNo(
		int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the articles where issueNo = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issueNo the issue no
	* @param status the status
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Article> findByIssueNo(
		int issueNo, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the articles where issueNo = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issueNo the issue no
	* @param status the status
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Article> findByIssueNo(
		int issueNo, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first article in the ordered set where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article findByIssueNo_First(
		int issueNo, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the first article in the ordered set where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByIssueNo_First(
		int issueNo, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last article in the ordered set where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article findByIssueNo_Last(
		int issueNo, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the last article in the ordered set where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByIssueNo_Last(
		int issueNo, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the articles before and after the current article in the ordered set where issueNo = &#63; and status = &#63;.
	*
	* @param articleId the primary key of the current article
	* @param issueNo the issue no
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article[] findByIssueNo_PrevAndNext(
		long articleId, int issueNo, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Removes all the articles where issueNo = &#63; and status = &#63; from the database.
	*
	* @param issueNo the issue no
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIssueNo(int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of articles where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByIssueNo(int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article where status = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchArticleException} if it could not be found.
	*
	* @param status the status
	* @return the matching article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article findByStatus(
		int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the article where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByStatus(
		int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the article where status = &#63; from the database.
	*
	* @param status the status
	* @return the article that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article removeByStatus(
		int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the number of articles where status = &#63;.
	*
	* @param status the status
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article where journalArticleId = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchArticleException} if it could not be found.
	*
	* @param journalArticleId the journal article ID
	* @return the matching article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article findByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param journalArticleId the journal article ID
	* @return the matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param journalArticleId the journal article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByJournalArticleId(
		long journalArticleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the article where journalArticleId = &#63; from the database.
	*
	* @param journalArticleId the journal article ID
	* @return the article that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article removeByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the number of articles where journalArticleId = &#63;.
	*
	* @param journalArticleId the journal article ID
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByJournalArticleId(long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the article in the entity cache if it is enabled.
	*
	* @param article the article
	*/
	public void cacheResult(
		com.liferay.training.newsletter.model.Article article);

	/**
	* Caches the articles in the entity cache if it is enabled.
	*
	* @param articles the articles
	*/
	public void cacheResult(
		java.util.List<com.liferay.training.newsletter.model.Article> articles);

	/**
	* Creates a new article with the primary key. Does not add the article to the database.
	*
	* @param articleId the primary key for the new article
	* @return the new article
	*/
	public com.liferay.training.newsletter.model.Article create(long articleId);

	/**
	* Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleId the primary key of the article
	* @return the article that was removed
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article remove(long articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	public com.liferay.training.newsletter.model.Article updateImpl(
		com.liferay.training.newsletter.model.Article article)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the article with the primary key or throws a {@link com.liferay.training.newsletter.NoSuchArticleException} if it could not be found.
	*
	* @param articleId the primary key of the article
	* @return the article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article findByPrimaryKey(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException;

	/**
	* Returns the article with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param articleId the primary key of the article
	* @return the article, or <code>null</code> if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Article fetchByPrimaryKey(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the articles.
	*
	* @return the articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Article> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Article> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the articles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of articles.
	*
	* @return the number of articles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}