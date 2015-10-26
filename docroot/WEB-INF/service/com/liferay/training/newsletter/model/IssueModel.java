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

package com.liferay.training.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Issue service. Represents a row in the &quot;newsletter_Issue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.newsletter.model.impl.IssueModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.newsletter.model.impl.IssueImpl}.
 * </p>
 *
 * @author Brian Greenwald
 * @see Issue
 * @see com.liferay.training.newsletter.model.impl.IssueImpl
 * @see com.liferay.training.newsletter.model.impl.IssueModelImpl
 * @generated
 */
public interface IssueModel extends BaseModel<Issue>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a issue model instance should use the {@link Issue} interface instead.
	 */

	/**
	 * Returns the primary key of this issue.
	 *
	 * @return the primary key of this issue
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this issue.
	 *
	 * @param primaryKey the primary key of this issue
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the issue ID of this issue.
	 *
	 * @return the issue ID of this issue
	 */
	public long getIssueId();

	/**
	 * Sets the issue ID of this issue.
	 *
	 * @param issueId the issue ID of this issue
	 */
	public void setIssueId(long issueId);

	/**
	 * Returns the journal article ID of this issue.
	 *
	 * @return the journal article ID of this issue
	 */
	public long getJournalArticleId();

	/**
	 * Sets the journal article ID of this issue.
	 *
	 * @param journalArticleId the journal article ID of this issue
	 */
	public void setJournalArticleId(long journalArticleId);

	/**
	 * Returns the group ID of this issue.
	 *
	 * @return the group ID of this issue
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this issue.
	 *
	 * @param groupId the group ID of this issue
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this issue.
	 *
	 * @return the company ID of this issue
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this issue.
	 *
	 * @param companyId the company ID of this issue
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this issue.
	 *
	 * @return the user ID of this issue
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this issue.
	 *
	 * @param userId the user ID of this issue
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this issue.
	 *
	 * @return the user uuid of this issue
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this issue.
	 *
	 * @param userUuid the user uuid of this issue
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this issue.
	 *
	 * @return the user name of this issue
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this issue.
	 *
	 * @param userName the user name of this issue
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this issue.
	 *
	 * @return the create date of this issue
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this issue.
	 *
	 * @param createDate the create date of this issue
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this issue.
	 *
	 * @return the modified date of this issue
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this issue.
	 *
	 * @param modifiedDate the modified date of this issue
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the issue no of this issue.
	 *
	 * @return the issue no of this issue
	 */
	public int getIssueNo();

	/**
	 * Sets the issue no of this issue.
	 *
	 * @param issueNo the issue no of this issue
	 */
	public void setIssueNo(int issueNo);

	/**
	 * Returns the title of this issue.
	 *
	 * @return the title of this issue
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this issue.
	 *
	 * @param title the title of this issue
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this issue.
	 *
	 * @return the description of this issue
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this issue.
	 *
	 * @param description the description of this issue
	 */
	public void setDescription(String description);

	/**
	 * Returns the issue date of this issue.
	 *
	 * @return the issue date of this issue
	 */
	public Date getIssueDate();

	/**
	 * Sets the issue date of this issue.
	 *
	 * @param issueDate the issue date of this issue
	 */
	public void setIssueDate(Date issueDate);

	/**
	 * Returns the issue month of this issue.
	 *
	 * @return the issue month of this issue
	 */
	public int getIssueMonth();

	/**
	 * Sets the issue month of this issue.
	 *
	 * @param issueMonth the issue month of this issue
	 */
	public void setIssueMonth(int issueMonth);

	/**
	 * Returns the issue year of this issue.
	 *
	 * @return the issue year of this issue
	 */
	public int getIssueYear();

	/**
	 * Sets the issue year of this issue.
	 *
	 * @param issueYear the issue year of this issue
	 */
	public void setIssueYear(int issueYear);

	/**
	 * Returns the byline of this issue.
	 *
	 * @return the byline of this issue
	 */
	@AutoEscape
	public String getByline();

	/**
	 * Sets the byline of this issue.
	 *
	 * @param byline the byline of this issue
	 */
	public void setByline(String byline);

	/**
	 * Returns the status of this issue.
	 *
	 * @return the status of this issue
	 */
	public int getStatus();

	/**
	 * Sets the status of this issue.
	 *
	 * @param status the status of this issue
	 */
	public void setStatus(int status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.liferay.training.newsletter.model.Issue issue);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.training.newsletter.model.Issue> toCacheModel();

	@Override
	public com.liferay.training.newsletter.model.Issue toEscapedModel();

	@Override
	public com.liferay.training.newsletter.model.Issue toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}