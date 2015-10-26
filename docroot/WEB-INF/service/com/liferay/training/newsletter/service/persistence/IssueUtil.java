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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.training.newsletter.model.Issue;

import java.util.List;

/**
 * The persistence utility for the issue service. This utility wraps {@link IssuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Greenwald
 * @see IssuePersistence
 * @see IssuePersistenceImpl
 * @generated
 */
public class IssueUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Issue issue) {
		getPersistence().clearCache(issue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Issue update(Issue issue) throws SystemException {
		return getPersistence().update(issue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Issue update(Issue issue, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(issue, serviceContext);
	}

	/**
	* Returns the issue where issueNo = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param issueNo the issue no
	* @return the matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByIssueNo(
		int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByIssueNo(issueNo);
	}

	/**
	* Returns the issue where issueNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param issueNo the issue no
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByIssueNo(
		int issueNo) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIssueNo(issueNo);
	}

	/**
	* Returns the issue where issueNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param issueNo the issue no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByIssueNo(
		int issueNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIssueNo(issueNo, retrieveFromCache);
	}

	/**
	* Removes the issue where issueNo = &#63; from the database.
	*
	* @param issueNo the issue no
	* @return the issue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue removeByIssueNo(
		int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().removeByIssueNo(issueNo);
	}

	/**
	* Returns the number of issues where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIssueNo(int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIssueNo(issueNo);
	}

	/**
	* Returns the issue where issueNo = &#63; and status = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param issueNo the issue no
	* @param status the status
	* @return the matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByIssueNoAndStatus(
		int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByIssueNoAndStatus(issueNo, status);
	}

	/**
	* Returns the issue where issueNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param issueNo the issue no
	* @param status the status
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByIssueNoAndStatus(
		int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIssueNoAndStatus(issueNo, status);
	}

	/**
	* Returns the issue where issueNo = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param issueNo the issue no
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByIssueNoAndStatus(
		int issueNo, int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIssueNoAndStatus(issueNo, status, retrieveFromCache);
	}

	/**
	* Removes the issue where issueNo = &#63; and status = &#63; from the database.
	*
	* @param issueNo the issue no
	* @param status the status
	* @return the issue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue removeByIssueNoAndStatus(
		int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().removeByIssueNoAndStatus(issueNo, status);
	}

	/**
	* Returns the number of issues where issueNo = &#63; and status = &#63;.
	*
	* @param issueNo the issue no
	* @param status the status
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIssueNoAndStatus(int issueNo, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIssueNoAndStatus(issueNo, status);
	}

	/**
	* Returns the issue where status = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param status the status
	* @return the matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByStatus(
		int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns the issue where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus(status);
	}

	/**
	* Returns the issue where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByStatus(
		int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus(status, retrieveFromCache);
	}

	/**
	* Removes the issue where status = &#63; from the database.
	*
	* @param status the status
	* @return the issue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue removeByStatus(
		int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of issues where status = &#63;.
	*
	* @param status the status
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the issues where status = &#63;.
	*
	* @param status the status
	* @return the matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findByApproved(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApproved(status);
	}

	/**
	* Returns a range of all the issues where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @return the range of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findByApproved(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApproved(status, start, end);
	}

	/**
	* Returns an ordered range of all the issues where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findByApproved(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApproved(status, start, end, orderByComparator);
	}

	/**
	* Returns the first issue in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByApproved_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByApproved_First(status, orderByComparator);
	}

	/**
	* Returns the first issue in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByApproved_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByApproved_First(status, orderByComparator);
	}

	/**
	* Returns the last issue in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByApproved_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByApproved_Last(status, orderByComparator);
	}

	/**
	* Returns the last issue in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByApproved_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByApproved_Last(status, orderByComparator);
	}

	/**
	* Returns the issues before and after the current issue in the ordered set where status = &#63;.
	*
	* @param issueId the primary key of the current issue
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue[] findByApproved_PrevAndNext(
		long issueId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence()
				   .findByApproved_PrevAndNext(issueId, status,
			orderByComparator);
	}

	/**
	* Removes all the issues where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApproved(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApproved(status);
	}

	/**
	* Returns the number of issues where status = &#63;.
	*
	* @param status the status
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApproved(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApproved(status);
	}

	/**
	* Returns the issue where journalArticleId = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param journalArticleId the journal article ID
	* @return the matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByJournalArticleId(journalArticleId);
	}

	/**
	* Returns the issue where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param journalArticleId the journal article ID
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJournalArticleId(journalArticleId);
	}

	/**
	* Returns the issue where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param journalArticleId the journal article ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByJournalArticleId(
		long journalArticleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJournalArticleId(journalArticleId, retrieveFromCache);
	}

	/**
	* Removes the issue where journalArticleId = &#63; from the database.
	*
	* @param journalArticleId the journal article ID
	* @return the issue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue removeByJournalArticleId(
		long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().removeByJournalArticleId(journalArticleId);
	}

	/**
	* Returns the number of issues where journalArticleId = &#63;.
	*
	* @param journalArticleId the journal article ID
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJournalArticleId(long journalArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJournalArticleId(journalArticleId);
	}

	/**
	* Caches the issue in the entity cache if it is enabled.
	*
	* @param issue the issue
	*/
	public static void cacheResult(
		com.liferay.training.newsletter.model.Issue issue) {
		getPersistence().cacheResult(issue);
	}

	/**
	* Caches the issues in the entity cache if it is enabled.
	*
	* @param issues the issues
	*/
	public static void cacheResult(
		java.util.List<com.liferay.training.newsletter.model.Issue> issues) {
		getPersistence().cacheResult(issues);
	}

	/**
	* Creates a new issue with the primary key. Does not add the issue to the database.
	*
	* @param issueId the primary key for the new issue
	* @return the new issue
	*/
	public static com.liferay.training.newsletter.model.Issue create(
		long issueId) {
		return getPersistence().create(issueId);
	}

	/**
	* Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param issueId the primary key of the issue
	* @return the issue that was removed
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue remove(
		long issueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().remove(issueId);
	}

	public static com.liferay.training.newsletter.model.Issue updateImpl(
		com.liferay.training.newsletter.model.Issue issue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(issue);
	}

	/**
	* Returns the issue with the primary key or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByPrimaryKey(
		long issueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence().findByPrimaryKey(issueId);
	}

	/**
	* Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue, or <code>null</code> if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByPrimaryKey(
		long issueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(issueId);
	}

	/**
	* Returns all the issues.
	*
	* @return the issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the issues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of issues.
	*
	* @return the number of issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IssuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IssuePersistence)PortletBeanLocatorUtil.locate(com.liferay.training.newsletter.service.ClpSerializer.getServletContextName(),
					IssuePersistence.class.getName());

			ReferenceRegistry.registerReference(IssueUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(IssuePersistence persistence) {
	}

	private static IssuePersistence _persistence;
}