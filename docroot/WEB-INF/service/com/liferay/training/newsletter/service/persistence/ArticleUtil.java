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

import com.liferay.training.newsletter.model.Article;

import java.util.List;

/**
 * The persistence utility for the article service. This utility wraps {@link ArticlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Greenwald
 * @see ArticlePersistence
 * @see ArticlePersistenceImpl
 * @generated
 */
public class ArticleUtil {
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
	public static void clearCache(Article article) {
		getPersistence().clearCache(article);
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
	public static List<Article> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Article update(Article article) throws SystemException {
		return getPersistence().update(article);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Article update(Article article, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(article, serviceContext);
	}

	/**
	* Returns all the articles where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @return the matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Article> findByissueNo(
		int issueNo) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByissueNo(issueNo);
	}

	/**
	* Returns a range of all the articles where issueNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issueNo the issue no
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Article> findByissueNo(
		int issueNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByissueNo(issueNo, start, end);
	}

	/**
	* Returns an ordered range of all the articles where issueNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param issueNo the issue no
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Article> findByissueNo(
		int issueNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByissueNo(issueNo, start, end, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article findByissueNo_First(
		int issueNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException {
		return getPersistence().findByissueNo_First(issueNo, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article fetchByissueNo_First(
		int issueNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByissueNo_First(issueNo, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article findByissueNo_Last(
		int issueNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException {
		return getPersistence().findByissueNo_Last(issueNo, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article fetchByissueNo_Last(
		int issueNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByissueNo_Last(issueNo, orderByComparator);
	}

	/**
	* Returns the articles before and after the current article in the ordered set where issueNo = &#63;.
	*
	* @param articleId the primary key of the current article
	* @param issueNo the issue no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article[] findByissueNo_PrevAndNext(
		long articleId, int issueNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException {
		return getPersistence()
				   .findByissueNo_PrevAndNext(articleId, issueNo,
			orderByComparator);
	}

	/**
	* Removes all the articles where issueNo = &#63; from the database.
	*
	* @param issueNo the issue no
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByissueNo(int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByissueNo(issueNo);
	}

	/**
	* Returns the number of articles where issueNo = &#63;.
	*
	* @param issueNo the issue no
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByissueNo(int issueNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByissueNo(issueNo);
	}

	/**
	* Caches the article in the entity cache if it is enabled.
	*
	* @param article the article
	*/
	public static void cacheResult(
		com.liferay.training.newsletter.model.Article article) {
		getPersistence().cacheResult(article);
	}

	/**
	* Caches the articles in the entity cache if it is enabled.
	*
	* @param articles the articles
	*/
	public static void cacheResult(
		java.util.List<com.liferay.training.newsletter.model.Article> articles) {
		getPersistence().cacheResult(articles);
	}

	/**
	* Creates a new article with the primary key. Does not add the article to the database.
	*
	* @param articleId the primary key for the new article
	* @return the new article
	*/
	public static com.liferay.training.newsletter.model.Article create(
		long articleId) {
		return getPersistence().create(articleId);
	}

	/**
	* Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleId the primary key of the article
	* @return the article that was removed
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article remove(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException {
		return getPersistence().remove(articleId);
	}

	public static com.liferay.training.newsletter.model.Article updateImpl(
		com.liferay.training.newsletter.model.Article article)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(article);
	}

	/**
	* Returns the article with the primary key or throws a {@link com.liferay.training.newsletter.NoSuchArticleException} if it could not be found.
	*
	* @param articleId the primary key of the article
	* @return the article
	* @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article findByPrimaryKey(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.training.newsletter.NoSuchArticleException {
		return getPersistence().findByPrimaryKey(articleId);
	}

	/**
	* Returns the article with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param articleId the primary key of the article
	* @return the article, or <code>null</code> if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.training.newsletter.model.Article fetchByPrimaryKey(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(articleId);
	}

	/**
	* Returns all the articles.
	*
	* @return the articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.training.newsletter.model.Article> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.training.newsletter.model.Article> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.training.newsletter.model.Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the articles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of articles.
	*
	* @return the number of articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ArticlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ArticlePersistence)PortletBeanLocatorUtil.locate(com.liferay.training.newsletter.service.ClpSerializer.getServletContextName(),
					ArticlePersistence.class.getName());

			ReferenceRegistry.registerReference(ArticleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ArticlePersistence persistence) {
	}

	private static ArticlePersistence _persistence;
}