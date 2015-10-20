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
import com.liferay.training.newsletter.NoSuchIssueException;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.base.IssueLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
			Date issueDate, String byline)
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

		return super.addIssue(issue);
	}

	public Issue updateIssue(
			long journalArticleId, long groupId, long companyId, 
			long userId, String userName, int issueNo, String title, 
			String description,	Date issueDate, String byline)
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
		
		issue.setByline(byline);

		return super.updateIssue(issue);
	}
	
	public List<Issue> getApprovedIssuesByMonthAndYear(
			int issueMonth, int issueYear)
		throws SystemException, PortalException {
		
		List<Issue> allIssues = getIssuesByMonthAndYear(issueMonth, issueYear);
		List<Issue> approvedIssues = new ArrayList<Issue>();
		
		for (Issue issue : allIssues) {
			long journalArticleId = issue.getJournalArticleId();
			JournalArticle journalArticle 
				= JournalArticleLocalServiceUtil.getArticle(journalArticleId);
			
			if (journalArticle.isApproved()) {
				approvedIssues.add(issue);
			}
		}
		return approvedIssues;
	}
	
	public Issue getIssueByJournalArticleId(long journalArticleId) 
		throws NoSuchIssueException, SystemException {
		
		return issuePersistence.findByJournalArticleId(journalArticleId);
	}
	
	public Issue getIssueByIssueNo(int issueNo) 
		throws NoSuchIssueException, SystemException {
		
		return issuePersistence.findByIssueNo(issueNo);
	}
	
	public List<Issue> getIssuesByMonthAndYear(int issueMonth, int issueYear) 
		throws SystemException {
		
		return issuePersistence.findByMonthAndYear(issueMonth, issueYear);
	}

}
