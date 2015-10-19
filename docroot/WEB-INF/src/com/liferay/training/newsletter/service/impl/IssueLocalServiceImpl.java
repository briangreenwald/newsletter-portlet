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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;
import com.liferay.training.newsletter.service.base.IssueLocalServiceBaseImpl;

import java.util.Date;

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
		long groupId, long companyId, long userId, String userName,
		int issueNo, String title, String description, int issueMonth,
		int issueYear, String byline)
		throws SystemException {

		long issueId = counterLocalService.increment(Issue.class.getName());
		Issue issue = IssueLocalServiceUtil.createIssue(issueId);

		Date now = new Date();

		issue.setGroupId(groupId);
		issue.setCompanyId(companyId);
		issue.setUserId(userId);
		issue.setUserName(userName);
		
		issue.setCreateDate(now);
		issue.setModifiedDate(now);
		
		issue.setIssueNo(issueNo);
		issue.setTitle(title);
		issue.setDescription(description);
		issue.setIssueMonth(issueMonth);
		issue.setIssueYear(issueYear);
		issue.setByline(byline);

		return super.addIssue(issue);
	}

	public Issue updateIssue(
			long issueId, long groupId, long companyId, long userId,
			String userName, int issueNo, String title, String description,
			int issueMonth, int issueYear, String byline)
		throws SystemException, PortalException {

		Issue issue = getIssue(issueId);

		Date now = new Date();

		issue.setGroupId(groupId);
		issue.setCompanyId(companyId);
		issue.setUserId(userId);
		issue.setUserName(userName);
		
		issue.setModifiedDate(now);
		
		issue.setIssueNo(issueNo);
		issue.setTitle(title);
		issue.setDescription(description);
		issue.setIssueMonth(issueMonth);
		issue.setIssueYear(issueYear);
		issue.setByline(byline);

		return super.updateIssue(issue);
	}

}
