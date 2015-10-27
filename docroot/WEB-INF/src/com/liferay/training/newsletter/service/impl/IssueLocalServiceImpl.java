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
import com.liferay.training.newsletter.NoSuchIssueException;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.base.IssueLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the issue local service. <p> All custom service methods
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the
 * {@link com.liferay.training.newsletter.service.IssueLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Brian Greenwald
 * @see com.liferay.training.newsletter.service.base.IssueLocalServiceBaseImpl
 * @see com.liferay.training.newsletter.service.IssueLocalServiceUtil
 */
public class IssueLocalServiceImpl extends IssueLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.liferay.training.newsletter.service.IssueLocalServiceUtil} to
	 * access the issue local service.
	 */

	/**
	 * Creates a new Issue object and persists it to the database. 
	 * 
	 * @param journalIssueId the articleId of the JournalArticle that this
	 * Issue is created from.
	 * @param groupId the groupId of the Issue.
	 * @param companyId the companyId of the Issue.
	 * @param userId the userId of the Issue's creator.
	 * @param userName the screenName of the Issue's creator
	 * @param issueNo the issueNo that this Issue belongs to.
	 * @param title the title of this Issue.
	 * @param byline the byline of this Issue.
	 * @param description the description of the Issue.
	 * @param status the workflow status of this Issue 
	 * (0=Approved, 1=Unapproved)
	 * 
	 */
	public Issue addIssue(
		String journalArticleId, long groupId, long companyId, long userId,
		String userName, int issueNo, String title, String description,
		Date issueDate, String byline, int status)
		throws SystemException {

		long issueId = counterLocalService.increment(Issue.class.getName());
		Issue issue = createIssue(issueId);

		issue.setJournalArticleId(journalArticleId);
		issue.setGroupId(groupId);
		issue.setCompanyId(companyId);
		issue.setUserId(userId);
		issue.setUserName(userName);

		Date now = new Date();
		issue.setCreateDate(now);
		issue.setModifiedDate(now);

		issue.setIssueNo(issueNo);
		issue.setTitle(title);
		issue.setDescription(description);

		issue.setIssueDate(issueDate);

		Calendar cal = Calendar.getInstance();
		cal.setTime(issueDate);
		int issueMonth = cal.get(Calendar.MONTH);
		int issueYear = cal.get(Calendar.YEAR);

		issue.setIssueMonth(issueMonth);
		issue.setIssueYear(issueYear);
		issue.setByline(byline);
		
		issue.setStatus(status);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			
			Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);
			try {
				indexer.reindex(issue);
			}
			catch (SearchException se) {
				System.out.println("Search Exception:" + se);
			}
		}

		return super.addIssue(issue);
	}

	/**
	 * Updates an Issue object and persists it to the database. 
	 * 
	 * This method will be called when either the workflow status of the 
	 * associated JournalArticle changes and when a new version of said
	 * JournalArticle is approved.
	 * 
	 * @param journalIssueId the articleId of the JournalArticle that this
	 * Issue is created from.
	 * @param groupId the groupId of the Issue.
	 * @param companyId the companyId of the Issue.
	 * @param userId the userId of the Issue's creator.
	 * @param userName the screenName of the Issue's creator
	 * @param issueNo the issueNo that this Issue belongs to.
	 * @param title the title of this Issue.
	 * @param byline the byline of this Issue.
	 * @param description the description of the Issue.
	 * @param status the workflow status of this Issue 
	 * (0=Approved, 1=Unapproved)
	 * 
	 */
	public Issue updateIssue(
		String journalArticleId, long groupId, long companyId, long userId,
		String userName, int issueNo, String title, String description,
		Date issueDate, String byline, int status)
		throws SystemException, PortalException {

		Issue issue = getIssueByJournalArticleId(journalArticleId);

		issue.setGroupId(groupId);
		issue.setCompanyId(companyId);
		issue.setUserId(userId);
		issue.setUserName(userName);

		Date now = new Date();
		issue.setModifiedDate(now);

		issue.setIssueNo(issueNo);
		issue.setTitle(title);
		issue.setDescription(description);

		issue.setIssueDate(issueDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(issueDate);
		int issueMonth = cal.get(Calendar.MONTH);
		int issueYear = cal.get(Calendar.YEAR);
		issue.setIssueMonth(issueMonth);
		issue.setIssueYear(issueYear);

		issue.setByline(byline);
		
		issue.setStatus(status);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			
			Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);
			try {
				indexer.reindex(issue);
			}
			catch (SearchException se) {
				System.out.println("Search Exception:" + se);
			}
		}
		
		return super.updateIssue(issue);
	}
	
	/**
	 * Removes the Issue from the database.
	 * 
	 * @param issue the issue to be removed.
	 * 
	 * @retun the removed Issue.
	 * 
	 */
	public Issue deleteIssue(Issue issue) throws SystemException {
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);
		
		try {
			indexer.delete(issue);
		}
		catch (SearchException se) {
			System.out.println("Search Exception:" + se);
		}
		
		return super.deleteIssue(issue);
	}
	
	public Issue getApprovedIssueByIssueNo(int issueNo)
		throws SystemException, NoSuchIssueException {

		return issuePersistence.findByIssueNoAndStatus(
				issueNo, WorkflowConstants.STATUS_APPROVED);
	}
	
	/**
	 * Gets a range of Issues that are approved.
	 * 
	 * @return the range of approved Issues.
	 */
	@Override
	public List<Issue> getIssues(int start, int end) throws SystemException {
		
		return issuePersistence.findByStatus(WorkflowConstants.STATUS_APPROVED, start, end);
	}
	
	/**
	 * Gets the count of all issues that are approved.
	 * 
	 * @return the number of all issues that are approved.
	 */
	@Override 
	public int getIssuesCount() throws SystemException {
		
		return issuePersistence.countByStatus(WorkflowConstants.STATUS_APPROVED);
	}
	
	/**
	 * Gets the Issue matching the IssueNo.
	 * 
	 * @param issueNo the issueNo to find the Issue by.
	 * 
	 * @return the Issue with the given issueNo.
	 */
	public Issue getIssueByIssueNo(int issueNo) 
		throws SystemException, NoSuchIssueException{
		
		return issuePersistence.findByIssueNo(issueNo);
	}

	/**
	 * Gets a mapping of all approved Issues by year.
	 * 
	 * @return the mapping of all approved Issues by year.
	 * 
	 */
	public Map<Integer, List<Issue>> getApprovedIssuesByYear()
		throws SystemException, PortalException {

		List<Issue> issues = 
			issuePersistence.findByStatus(WorkflowConstants.STATUS_APPROVED);
		
		Map<Integer, List<Issue>> issuesByYear 
			= new LinkedHashMap<Integer, List<Issue>>();
		
		for (Issue issue : issues) {
			int issueYear = issue.getIssueYear();

			List<Issue> issuesThisYear;
			if (issuesByYear.containsKey(issueYear)) {
				issuesThisYear = issuesByYear.get(issueYear);

			}
			else {
				issuesThisYear = new ArrayList<Issue>();
			}	
			issuesThisYear.add(issue);
			issuesByYear.put(issueYear, issuesThisYear);
		}
		
		return issuesByYear;
	}

	public Issue getIssueByJournalArticleId(String journalArticleId)
		throws NoSuchIssueException, SystemException {

		return issuePersistence.findByJournalArticleId(journalArticleId);
	}
	
}
