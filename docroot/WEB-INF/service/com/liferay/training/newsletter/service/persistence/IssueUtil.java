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
	* Returns all the issues where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @return the matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findByMonthAndYear(
		int issueMonth, int issueYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMonthAndYear(issueMonth, issueYear);
	}

	/**
	* Returns a range of all the issues where issueMonth = &#63; and issueYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @return the range of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findByMonthAndYear(
		int issueMonth, int issueYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMonthAndYear(issueMonth, issueYear, start, end);
	}

	/**
	* Returns an ordered range of all the issues where issueMonth = &#63; and issueYear = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Issue> findByMonthAndYear(
		int issueMonth, int issueYear, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMonthAndYear(issueMonth, issueYear, start, end,
			orderByComparator);
	}

	/**
	* Returns the first issue in the ordered set where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByMonthAndYear_First(
		int issueMonth, int issueYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence()
				   .findByMonthAndYear_First(issueMonth, issueYear,
			orderByComparator);
	}

	/**
	* Returns the first issue in the ordered set where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByMonthAndYear_First(
		int issueMonth, int issueYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMonthAndYear_First(issueMonth, issueYear,
			orderByComparator);
	}

	/**
	* Returns the last issue in the ordered set where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue findByMonthAndYear_Last(
		int issueMonth, int issueYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence()
				   .findByMonthAndYear_Last(issueMonth, issueYear,
			orderByComparator);
	}

	/**
	* Returns the last issue in the ordered set where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching issue, or <code>null</code> if a matching issue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue fetchByMonthAndYear_Last(
		int issueMonth, int issueYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMonthAndYear_Last(issueMonth, issueYear,
			orderByComparator);
	}

	/**
	* Returns the issues before and after the current issue in the ordered set where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueId the primary key of the current issue
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next issue
	* @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Issue[] findByMonthAndYear_PrevAndNext(
		int issueId, int issueMonth, int issueYear,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchIssueException {
		return getPersistence()
				   .findByMonthAndYear_PrevAndNext(issueId, issueMonth,
			issueYear, orderByComparator);
	}

	/**
	* Removes all the issues where issueMonth = &#63; and issueYear = &#63; from the database.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMonthAndYear(int issueMonth, int issueYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMonthAndYear(issueMonth, issueYear);
	}

	/**
	* Returns the number of issues where issueMonth = &#63; and issueYear = &#63;.
	*
	* @param issueMonth the issue month
	* @param issueYear the issue year
	* @return the number of matching issues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMonthAndYear(int issueMonth, int issueYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMonthAndYear(issueMonth, issueYear);
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
		int issueId) {
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
		int issueId)
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
		int issueId)
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
		int issueId) throws com.liferay.portal.kernel.exception.SystemException {
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