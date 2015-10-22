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

import com.liferay.training.newsletter.model.Issue;

/**
 * The persistence interface for the issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Greenwald
 * @see IssuePersistenceImpl
 * @see IssueUtil
 * @generated
 */
public interface IssuePersistence extends BasePersistence<Issue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IssueUtil} to access the issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the issue where issueNo = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param issueNo the issue no
	* @return the matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue findByIssueNo(
		int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException;

	/**
	* Returns the issue where issueNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param issueNo the issue no
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue fetchByIssueNo(
		int issueNo) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the issue where issueNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param issueNo the issue no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue fetchByIssueNo(
		int issueNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the issue where issueNo = &#63; from the database.
	*
	* @param issueNo the issue no
	* @return the issue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue removeByIssueNo(
		int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException;

	/**
	* Returns the number of issues where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public int countByIssueNo(int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the issue where journalArticleId = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param journalArticleId the journal article ID
	* @return the matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue findByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException;

	/**
	* Returns the issue where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param journalArticleId the journal article ID
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue fetchByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the issue where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param journalArticleId the journal article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue fetchByJournalArticleId(
		long journalArticleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the issue where journalArticleId = &#63; from the database.
	*
	* @param journalArticleId the journal article ID
	* @return the issue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue removeByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException;

	/**
	* Returns the number of issues where journalArticleId = &#63;.
	*
	* @param journalArticleId the journal article ID
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public int countByJournalArticleId(long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the issue in the entity cache if it is enabled.
	*
	* @param issue the issue
	*/
	public void cacheResult(com.liferay.training.newsletter.model.Issue issue);

	/**
	* Caches the issues in the entity cache if it is enabled.
	*
	* @param issues the issues
	*/
	public void cacheResult(
		java.util.List<com.liferay.training.newsletter.model.Issue> issues);

	/**
	* Creates a new issue with the primary key. Does not add the issue to the database.
	*
	* @param issueId the primary key for the new issue
	* @return the new issue
	*/
	public com.liferay.training.newsletter.model.Issue create(long issueId);

	/**
	* Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param issueId the primary key of the issue
	* @return the issue that was removed
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue remove(long issueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException;

	public com.liferay.training.newsletter.model.Issue updateImpl(
		com.liferay.training.newsletter.model.Issue issue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the issue with the primary key or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue findByPrimaryKey(
		long issueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException;

	/**
	* Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue, or <code>null</code> if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.training.newsletter.model.Issue fetchByPrimaryKey(
		long issueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the issues.
	*
	* @return the issues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Issue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the issues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @return the range of issues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Issue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the issues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of issues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.training.newsletter.model.Issue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the issues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of issues.
	*
	* @return the number of issues
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}