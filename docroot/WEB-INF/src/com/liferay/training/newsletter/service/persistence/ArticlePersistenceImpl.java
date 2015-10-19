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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.training.newsletter.NoSuchArticleException;
import com.liferay.training.newsletter.model.Article;
import com.liferay.training.newsletter.model.impl.ArticleImpl;
import com.liferay.training.newsletter.model.impl.ArticleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Greenwald
 * @see ArticlePersistence
 * @see ArticleUtil
 * @generated
 */
public class ArticlePersistenceImpl extends BasePersistenceImpl<Article>
	implements ArticlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArticleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUENO = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssueNo",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENO =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssueNo",
			new String[] { Integer.class.getName() },
			ArticleModelImpl.ISSUENO_COLUMN_BITMASK |
			ArticleModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUENO = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueNo",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the articles where issueNo = &#63;.
	 *
	 * @param issueNo the issue no
	 * @return the matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByIssueNo(int issueNo) throws SystemException {
		return findByIssueNo(issueNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Article> findByIssueNo(int issueNo, int start, int end)
		throws SystemException {
		return findByIssueNo(issueNo, start, end, null);
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
	@Override
	public List<Article> findByIssueNo(int issueNo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENO;
			finderArgs = new Object[] { issueNo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUENO;
			finderArgs = new Object[] { issueNo, start, end, orderByComparator };
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Article article : list) {
				if ((issueNo != article.getIssueNo())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ISSUENO_ISSUENO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNo);

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Article findByIssueNo_First(int issueNo,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByIssueNo_First(issueNo, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueNo=");
		msg.append(issueNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where issueNo = &#63;.
	 *
	 * @param issueNo the issue no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByIssueNo_First(int issueNo,
		OrderByComparator orderByComparator) throws SystemException {
		List<Article> list = findByIssueNo(issueNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Article findByIssueNo_Last(int issueNo,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByIssueNo_Last(issueNo, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueNo=");
		msg.append(issueNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where issueNo = &#63;.
	 *
	 * @param issueNo the issue no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByIssueNo_Last(int issueNo,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIssueNo(issueNo);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByIssueNo(issueNo, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Article[] findByIssueNo_PrevAndNext(long articleId, int issueNo,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByIssueNo_PrevAndNext(session, article, issueNo,
					orderByComparator, true);

			array[1] = article;

			array[2] = getByIssueNo_PrevAndNext(session, article, issueNo,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByIssueNo_PrevAndNext(Session session,
		Article article, int issueNo, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_ISSUENO_ISSUENO_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(issueNo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(article);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where issueNo = &#63; from the database.
	 *
	 * @param issueNo the issue no
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIssueNo(int issueNo) throws SystemException {
		for (Article article : findByIssueNo(issueNo, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles where issueNo = &#63;.
	 *
	 * @param issueNo the issue no
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIssueNo(int issueNo) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSUENO;

		Object[] finderArgs = new Object[] { issueNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ISSUENO_ISSUENO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNo);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISSUENO_ISSUENO_2 = "article.issueNo = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_JOURNALARTICLEID = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJournalArticleId",
			new String[] { Long.class.getName() },
			ArticleModelImpl.JOURNALARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOURNALARTICLEID = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJournalArticleId", new String[] { Long.class.getName() });

	/**
	 * Returns the article where journalArticleId = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchArticleException} if it could not be found.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article
	 * @throws com.liferay.training.newsletter.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByJournalArticleId(long journalArticleId)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByJournalArticleId(journalArticleId);

		if (article == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("journalArticleId=");
			msg.append(journalArticleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleException(msg.toString());
		}

		return article;
	}

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByJournalArticleId(long journalArticleId)
		throws SystemException {
		return fetchByJournalArticleId(journalArticleId, true);
	}

	/**
	 * Returns the article where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByJournalArticleId(long journalArticleId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { journalArticleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
					finderArgs, this);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if ((journalArticleId != article.getJournalArticleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(journalArticleId);

				List<Article> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ArticlePersistenceImpl.fetchByJournalArticleId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Article article = list.get(0);

					result = article;

					cacheResult(article);

					if ((article.getJournalArticleId() != journalArticleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
							finderArgs, article);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where journalArticleId = &#63; from the database.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the article that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article removeByJournalArticleId(long journalArticleId)
		throws NoSuchArticleException, SystemException {
		Article article = findByJournalArticleId(journalArticleId);

		return remove(article);
	}

	/**
	 * Returns the number of articles where journalArticleId = &#63;.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJournalArticleId(long journalArticleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOURNALARTICLEID;

		Object[] finderArgs = new Object[] { journalArticleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(journalArticleId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2 =
		"article.journalArticleId = ?";

	public ArticlePersistenceImpl() {
		setModelClass(Article.class);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	@Override
	public void cacheResult(Article article) {
		EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleImpl.class, article.getPrimaryKey(), article);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
			new Object[] { article.getJournalArticleId() }, article);

		article.resetOriginalValues();
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	@Override
	public void cacheResult(List<Article> articles) {
		for (Article article : articles) {
			if (EntityCacheUtil.getResult(
						ArticleModelImpl.ENTITY_CACHE_ENABLED,
						ArticleImpl.class, article.getPrimaryKey()) == null) {
				cacheResult(article);
			}
			else {
				article.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all articles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArticleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArticleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Article article) {
		EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleImpl.class, article.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(article);
	}

	@Override
	public void clearCache(List<Article> articles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Article article : articles) {
			EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
				ArticleImpl.class, article.getPrimaryKey());

			clearUniqueFindersCache(article);
		}
	}

	protected void cacheUniqueFindersCache(Article article) {
		if (article.isNew()) {
			Object[] args = new Object[] { article.getJournalArticleId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
				args, article);
		}
		else {
			ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JOURNALARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { article.getJournalArticleId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
					args, article);
			}
		}
	}

	protected void clearUniqueFindersCache(Article article) {
		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		Object[] args = new Object[] { article.getJournalArticleId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID, args);

		if ((articleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_JOURNALARTICLEID.getColumnBitmask()) != 0) {
			args = new Object[] { articleModelImpl.getOriginalJournalArticleId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
				args);
		}
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Override
	public Article create(long articleId) {
		Article article = new ArticleImpl();

		article.setNew(true);
		article.setPrimaryKey(articleId);

		return article;
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article remove(long articleId)
		throws NoSuchArticleException, SystemException {
		return remove((Serializable)articleId);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article that was removed
	 * @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article remove(Serializable primaryKey)
		throws NoSuchArticleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Article article = (Article)session.get(ArticleImpl.class, primaryKey);

			if (article == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(article);
		}
		catch (NoSuchArticleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Article removeImpl(Article article) throws SystemException {
		article = toUnwrappedModel(article);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(article)) {
				article = (Article)session.get(ArticleImpl.class,
						article.getPrimaryKeyObj());
			}

			if (article != null) {
				session.delete(article);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (article != null) {
			clearCache(article);
		}

		return article;
	}

	@Override
	public Article updateImpl(
		com.liferay.training.newsletter.model.Article article)
		throws SystemException {
		article = toUnwrappedModel(article);

		boolean isNew = article.isNew();

		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		Session session = null;

		try {
			session = openSession();

			if (article.isNew()) {
				session.save(article);

				article.setNew(false);
			}
			else {
				session.merge(article);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ArticleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						articleModelImpl.getOriginalIssueNo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSUENO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENO,
					args);

				args = new Object[] { articleModelImpl.getIssueNo() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSUENO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENO,
					args);
			}
		}

		EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleImpl.class, article.getPrimaryKey(), article);

		clearUniqueFindersCache(article);
		cacheUniqueFindersCache(article);

		return article;
	}

	protected Article toUnwrappedModel(Article article) {
		if (article instanceof ArticleImpl) {
			return article;
		}

		ArticleImpl articleImpl = new ArticleImpl();

		articleImpl.setNew(article.isNew());
		articleImpl.setPrimaryKey(article.getPrimaryKey());

		articleImpl.setArticleId(article.getArticleId());
		articleImpl.setIssueId(article.getIssueId());
		articleImpl.setJournalArticleId(article.getJournalArticleId());
		articleImpl.setGroupId(article.getGroupId());
		articleImpl.setCompanyId(article.getCompanyId());
		articleImpl.setUserId(article.getUserId());
		articleImpl.setUserName(article.getUserName());
		articleImpl.setCreateDate(article.getCreateDate());
		articleImpl.setModifiedDate(article.getModifiedDate());
		articleImpl.setIssueNo(article.getIssueNo());
		articleImpl.setTitle(article.getTitle());
		articleImpl.setAuthor(article.getAuthor());
		articleImpl.setOrder(article.getOrder());
		articleImpl.setContent(article.getContent());

		return articleImpl;
	}

	/**
	 * Returns the article with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article
	 * @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByPrimaryKey(primaryKey);

		if (article == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a {@link com.liferay.training.newsletter.NoSuchArticleException} if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws com.liferay.training.newsletter.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByPrimaryKey(long articleId)
		throws NoSuchArticleException, SystemException {
		return findByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Article article = (Article)EntityCacheUtil.getResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
				ArticleImpl.class, primaryKey);

		if (article == _nullArticle) {
			return null;
		}

		if (article == null) {
			Session session = null;

			try {
				session = openSession();

				article = (Article)session.get(ArticleImpl.class, primaryKey);

				if (article != null) {
					cacheResult(article);
				}
				else {
					EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
						ArticleImpl.class, primaryKey, _nullArticle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
					ArticleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByPrimaryKey(long articleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Article> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Article> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARTICLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLE;

				if (pagination) {
					sql = sql.concat(ArticleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the articles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Article article : findAll()) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the article persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.training.newsletter.model.Article")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Article>> listenersList = new ArrayList<ModelListener<Article>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Article>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ArticleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ARTICLE = "SELECT article FROM Article article";
	private static final String _SQL_SELECT_ARTICLE_WHERE = "SELECT article FROM Article article WHERE ";
	private static final String _SQL_COUNT_ARTICLE = "SELECT COUNT(article) FROM Article article";
	private static final String _SQL_COUNT_ARTICLE_WHERE = "SELECT COUNT(article) FROM Article article WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "article.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Article exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Article exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArticlePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
	private static Article _nullArticle = new ArticleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Article> toCacheModel() {
				return _nullArticleCacheModel;
			}
		};

	private static CacheModel<Article> _nullArticleCacheModel = new CacheModel<Article>() {
			@Override
			public Article toEntityModel() {
				return _nullArticle;
			}
		};
}