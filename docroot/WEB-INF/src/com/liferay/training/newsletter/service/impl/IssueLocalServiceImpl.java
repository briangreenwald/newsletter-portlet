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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
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

	public Issue addIssue(
		long journalArticleId, long groupId, long companyId, long userId,
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

		return super.addIssue(issue);
	}

	public Issue updateIssue(
		long journalArticleId, long groupId, long companyId, long userId,
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

		return super.updateIssue(issue);
	}
	
	public Issue getIssueByIssueNo(int issueNo) 
		throws SystemException, NoSuchIssueException{
		
		return issuePersistence.findByIssueNo(issueNo);
	}

	public Issue getApprovedIssueByIssueNo(int issueNo)
		throws SystemException, NoSuchIssueException {

		return issuePersistence.findByIssueNoAndStatus(
			issueNo, WorkflowConstants.STATUS_APPROVED);
	}

	public Map<Integer, List<Issue>> getApprovedIssuesByYear()
		throws SystemException, PortalException {

		List<Issue> issues = 
			issuePersistence.findByApproved(WorkflowConstants.STATUS_APPROVED);
		
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

	public Issue getIssueByJournalArticleId(long journalArticleId)
		throws NoSuchIssueException, SystemException {

		return issuePersistence.findByJournalArticleId(journalArticleId);
	}
	
}
