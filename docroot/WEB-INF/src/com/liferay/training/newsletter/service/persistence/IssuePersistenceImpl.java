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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.training.newsletter.NoSuchIssueException;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.model.impl.IssueImpl;
import com.liferay.training.newsletter.model.impl.IssueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Greenwald
 * @see IssuePersistence
 * @see IssueUtil
 * @generated
 */
public class IssuePersistenceImpl extends BasePersistenceImpl<Issue>
	implements IssuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IssueUtil} to access the issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IssueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ISSUENO = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIssueNo",
			new String[] { Integer.class.getName() },
			IssueModelImpl.ISSUENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUENO = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueNo",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the issue where issueNo = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	 *
	 * @param issueNo the issue no
	 * @return the matching issue
	 * @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue findByIssueNo(int issueNo)
		throws NoSuchIssueException, SystemException {
		Issue issue = fetchByIssueNo(issueNo);

		if (issue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("issueNo=");
			msg.append(issueNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIssueException(msg.toString());
		}

		return issue;
	}

	/**
	 * Returns the issue where issueNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param issueNo the issue no
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue fetchByIssueNo(int issueNo) throws SystemException {
		return fetchByIssueNo(issueNo, true);
	}

	/**
	 * Returns the issue where issueNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param issueNo the issue no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue fetchByIssueNo(int issueNo, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { issueNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ISSUENO,
					finderArgs, this);
		}

		if (result instanceof Issue) {
			Issue issue = (Issue)result;

			if ((issueNo != issue.getIssueNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ISSUE_WHERE);

			query.append(_FINDER_COLUMN_ISSUENO_ISSUENO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNo);

				List<Issue> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISSUENO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"IssuePersistenceImpl.fetchByIssueNo(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Issue issue = list.get(0);

					result = issue;

					cacheResult(issue);

					if ((issue.getIssueNo() != issueNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISSUENO,
							finderArgs, issue);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ISSUENO,
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
			return (Issue)result;
		}
	}

	/**
	 * Removes the issue where issueNo = &#63; from the database.
	 *
	 * @param issueNo the issue no
	 * @return the issue that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue removeByIssueNo(int issueNo)
		throws NoSuchIssueException, SystemException {
		Issue issue = findByIssueNo(issueNo);

		return remove(issue);
	}

	/**
	 * Returns the number of issues where issueNo = &#63;.
	 *
	 * @param issueNo the issue no
	 * @return the number of matching issues
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

			query.append(_SQL_COUNT_ISSUE_WHERE);

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

	private static final String _FINDER_COLUMN_ISSUENO_ISSUENO_2 = "issue.issueNo = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_JOURNALARTICLEID = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJournalArticleId",
			new String[] { Long.class.getName() },
			IssueModelImpl.JOURNALARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOURNALARTICLEID = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJournalArticleId", new String[] { Long.class.getName() });

	/**
	 * Returns the issue where journalArticleId = &#63; or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching issue
	 * @throws com.liferay.training.newsletter.NoSuchIssueException if a matching issue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue findByJournalArticleId(long journalArticleId)
		throws NoSuchIssueException, SystemException {
		Issue issue = fetchByJournalArticleId(journalArticleId);

		if (issue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("journalArticleId=");
			msg.append(journalArticleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIssueException(msg.toString());
		}

		return issue;
	}

	/**
	 * Returns the issue where journalArticleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue fetchByJournalArticleId(long journalArticleId)
		throws SystemException {
		return fetchByJournalArticleId(journalArticleId, true);
	}

	/**
	 * Returns the issue where journalArticleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param journalArticleId the journal article ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue fetchByJournalArticleId(long journalArticleId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { journalArticleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
					finderArgs, this);
		}

		if (result instanceof Issue) {
			Issue issue = (Issue)result;

			if ((journalArticleId != issue.getJournalArticleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ISSUE_WHERE);

			query.append(_FINDER_COLUMN_JOURNALARTICLEID_JOURNALARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(journalArticleId);

				List<Issue> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"IssuePersistenceImpl.fetchByJournalArticleId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Issue issue = list.get(0);

					result = issue;

					cacheResult(issue);

					if ((issue.getJournalArticleId() != journalArticleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
							finderArgs, issue);
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
			return (Issue)result;
		}
	}

	/**
	 * Removes the issue where journalArticleId = &#63; from the database.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the issue that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue removeByJournalArticleId(long journalArticleId)
		throws NoSuchIssueException, SystemException {
		Issue issue = findByJournalArticleId(journalArticleId);

		return remove(issue);
	}

	/**
	 * Returns the number of issues where journalArticleId = &#63;.
	 *
	 * @param journalArticleId the journal article ID
	 * @return the number of matching issues
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

			query.append(_SQL_COUNT_ISSUE_WHERE);

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
		"issue.journalArticleId = ?";

	public IssuePersistenceImpl() {
		setModelClass(Issue.class);
	}

	/**
	 * Caches the issue in the entity cache if it is enabled.
	 *
	 * @param issue the issue
	 */
	@Override
	public void cacheResult(Issue issue) {
		EntityCacheUtil.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueImpl.class, issue.getPrimaryKey(), issue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISSUENO,
			new Object[] { issue.getIssueNo() }, issue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
			new Object[] { issue.getJournalArticleId() }, issue);

		issue.resetOriginalValues();
	}

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	@Override
	public void cacheResult(List<Issue> issues) {
		for (Issue issue : issues) {
			if (EntityCacheUtil.getResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
						IssueImpl.class, issue.getPrimaryKey()) == null) {
				cacheResult(issue);
			}
			else {
				issue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all issues.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IssueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IssueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the issue.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Issue issue) {
		EntityCacheUtil.removeResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueImpl.class, issue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(issue);
	}

	@Override
	public void clearCache(List<Issue> issues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Issue issue : issues) {
			EntityCacheUtil.removeResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
				IssueImpl.class, issue.getPrimaryKey());

			clearUniqueFindersCache(issue);
		}
	}

	protected void cacheUniqueFindersCache(Issue issue) {
		if (issue.isNew()) {
			Object[] args = new Object[] { issue.getIssueNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISSUENO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISSUENO, args, issue);

			args = new Object[] { issue.getJournalArticleId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
				args, issue);
		}
		else {
			IssueModelImpl issueModelImpl = (IssueModelImpl)issue;

			if ((issueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ISSUENO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { issue.getIssueNo() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISSUENO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ISSUENO, args,
					issue);
			}

			if ((issueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JOURNALARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { issue.getJournalArticleId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
					args, issue);
			}
		}
	}

	protected void clearUniqueFindersCache(Issue issue) {
		IssueModelImpl issueModelImpl = (IssueModelImpl)issue;

		Object[] args = new Object[] { issue.getIssueNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSUENO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ISSUENO, args);

		if ((issueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ISSUENO.getColumnBitmask()) != 0) {
			args = new Object[] { issueModelImpl.getOriginalIssueNo() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSUENO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ISSUENO, args);
		}

		args = new Object[] { issue.getJournalArticleId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID, args);

		if ((issueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_JOURNALARTICLEID.getColumnBitmask()) != 0) {
			args = new Object[] { issueModelImpl.getOriginalJournalArticleId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOURNALARTICLEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOURNALARTICLEID,
				args);
		}
	}

	/**
	 * Creates a new issue with the primary key. Does not add the issue to the database.
	 *
	 * @param issueId the primary key for the new issue
	 * @return the new issue
	 */
	@Override
	public Issue create(long issueId) {
		Issue issue = new IssueImpl();

		issue.setNew(true);
		issue.setPrimaryKey(issueId);

		return issue;
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue that was removed
	 * @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue remove(long issueId)
		throws NoSuchIssueException, SystemException {
		return remove((Serializable)issueId);
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue that was removed
	 * @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue remove(Serializable primaryKey)
		throws NoSuchIssueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Issue issue = (Issue)session.get(IssueImpl.class, primaryKey);

			if (issue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIssueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(issue);
		}
		catch (NoSuchIssueException nsee) {
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
	protected Issue removeImpl(Issue issue) throws SystemException {
		issue = toUnwrappedModel(issue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(issue)) {
				issue = (Issue)session.get(IssueImpl.class,
						issue.getPrimaryKeyObj());
			}

			if (issue != null) {
				session.delete(issue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (issue != null) {
			clearCache(issue);
		}

		return issue;
	}

	@Override
	public Issue updateImpl(com.liferay.training.newsletter.model.Issue issue)
		throws SystemException {
		issue = toUnwrappedModel(issue);

		boolean isNew = issue.isNew();

		Session session = null;

		try {
			session = openSession();

			if (issue.isNew()) {
				session.save(issue);

				issue.setNew(false);
			}
			else {
				session.merge(issue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !IssueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueImpl.class, issue.getPrimaryKey(), issue);

		clearUniqueFindersCache(issue);
		cacheUniqueFindersCache(issue);

		return issue;
	}

	protected Issue toUnwrappedModel(Issue issue) {
		if (issue instanceof IssueImpl) {
			return issue;
		}

		IssueImpl issueImpl = new IssueImpl();

		issueImpl.setNew(issue.isNew());
		issueImpl.setPrimaryKey(issue.getPrimaryKey());

		issueImpl.setIssueId(issue.getIssueId());
		issueImpl.setJournalArticleId(issue.getJournalArticleId());
		issueImpl.setGroupId(issue.getGroupId());
		issueImpl.setCompanyId(issue.getCompanyId());
		issueImpl.setUserId(issue.getUserId());
		issueImpl.setUserName(issue.getUserName());
		issueImpl.setCreateDate(issue.getCreateDate());
		issueImpl.setModifiedDate(issue.getModifiedDate());
		issueImpl.setIssueNo(issue.getIssueNo());
		issueImpl.setTitle(issue.getTitle());
		issueImpl.setDescription(issue.getDescription());
		issueImpl.setIssueDate(issue.getIssueDate());
		issueImpl.setIssueMonth(issue.getIssueMonth());
		issueImpl.setIssueYear(issue.getIssueYear());
		issueImpl.setByline(issue.getByline());

		return issueImpl;
	}

	/**
	 * Returns the issue with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue
	 * @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIssueException, SystemException {
		Issue issue = fetchByPrimaryKey(primaryKey);

		if (issue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIssueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return issue;
	}

	/**
	 * Returns the issue with the primary key or throws a {@link com.liferay.training.newsletter.NoSuchIssueException} if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue
	 * @throws com.liferay.training.newsletter.NoSuchIssueException if a issue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue findByPrimaryKey(long issueId)
		throws NoSuchIssueException, SystemException {
		return findByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Issue issue = (Issue)EntityCacheUtil.getResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
				IssueImpl.class, primaryKey);

		if (issue == _nullIssue) {
			return null;
		}

		if (issue == null) {
			Session session = null;

			try {
				session = openSession();

				issue = (Issue)session.get(IssueImpl.class, primaryKey);

				if (issue != null) {
					cacheResult(issue);
				}
				else {
					EntityCacheUtil.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
						IssueImpl.class, primaryKey, _nullIssue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
					IssueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return issue;
	}

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Issue fetchByPrimaryKey(long issueId) throws SystemException {
		return fetchByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns all the issues.
	 *
	 * @return the issues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Issue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Issue> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Issue> findAll(int start, int end,
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

		List<Issue> list = (List<Issue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ISSUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ISSUE;

				if (pagination) {
					sql = sql.concat(IssueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Issue>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Issue>(list);
				}
				else {
					list = (List<Issue>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the issues from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Issue issue : findAll()) {
			remove(issue);
		}
	}

	/**
	 * Returns the number of issues.
	 *
	 * @return the number of issues
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

				Query q = session.createQuery(_SQL_COUNT_ISSUE);

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

	/**
	 * Initializes the issue persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.training.newsletter.model.Issue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Issue>> listenersList = new ArrayList<ModelListener<Issue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Issue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IssueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ISSUE = "SELECT issue FROM Issue issue";
	private static final String _SQL_SELECT_ISSUE_WHERE = "SELECT issue FROM Issue issue WHERE ";
	private static final String _SQL_COUNT_ISSUE = "SELECT COUNT(issue) FROM Issue issue";
	private static final String _SQL_COUNT_ISSUE_WHERE = "SELECT COUNT(issue) FROM Issue issue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "issue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Issue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Issue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IssuePersistenceImpl.class);
	private static Issue _nullIssue = new IssueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Issue> toCacheModel() {
				return _nullIssueCacheModel;
			}
		};

	private static CacheModel<Issue> _nullIssueCacheModel = new CacheModel<Issue>() {
			@Override
			public Issue toEntityModel() {
				return _nullIssue;
			}
		};
}