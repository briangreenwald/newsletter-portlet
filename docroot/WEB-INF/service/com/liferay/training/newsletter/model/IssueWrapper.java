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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Issue}.
 * </p>
 *
 * @author Brian Greenwald
 * @see Issue
 * @generated
 */
public class IssueWrapper implements Issue, ModelWrapper<Issue> {
	public IssueWrapper(Issue issue) {
		_issue = issue;
	}

	@Override
	public Class<?> getModelClass() {
		return Issue.class;
	}

	@Override
	public String getModelClassName() {
		return Issue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("issueId", getIssueId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("issueMonth", getIssueMonth());
		attributes.put("issueYear", getIssueYear());
		attributes.put("byline", getByline());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer issueId = (Integer)attributes.get("issueId");

		if (issueId != null) {
			setIssueId(issueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer issueMonth = (Integer)attributes.get("issueMonth");

		if (issueMonth != null) {
			setIssueMonth(issueMonth);
		}

		Integer issueYear = (Integer)attributes.get("issueYear");

		if (issueYear != null) {
			setIssueYear(issueYear);
		}

		String byline = (String)attributes.get("byline");

		if (byline != null) {
			setByline(byline);
		}
	}

	/**
	* Returns the primary key of this issue.
	*
	* @return the primary key of this issue
	*/
	@Override
	public int getPrimaryKey() {
		return _issue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this issue.
	*
	* @param primaryKey the primary key of this issue
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_issue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the issue ID of this issue.
	*
	* @return the issue ID of this issue
	*/
	@Override
	public int getIssueId() {
		return _issue.getIssueId();
	}

	/**
	* Sets the issue ID of this issue.
	*
	* @param issueId the issue ID of this issue
	*/
	@Override
	public void setIssueId(int issueId) {
		_issue.setIssueId(issueId);
	}

	/**
	* Returns the group ID of this issue.
	*
	* @return the group ID of this issue
	*/
	@Override
	public long getGroupId() {
		return _issue.getGroupId();
	}

	/**
	* Sets the group ID of this issue.
	*
	* @param groupId the group ID of this issue
	*/
	@Override
	public void setGroupId(long groupId) {
		_issue.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this issue.
	*
	* @return the company ID of this issue
	*/
	@Override
	public long getCompanyId() {
		return _issue.getCompanyId();
	}

	/**
	* Sets the company ID of this issue.
	*
	* @param companyId the company ID of this issue
	*/
	@Override
	public void setCompanyId(long companyId) {
		_issue.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this issue.
	*
	* @return the user ID of this issue
	*/
	@Override
	public long getUserId() {
		return _issue.getUserId();
	}

	/**
	* Sets the user ID of this issue.
	*
	* @param userId the user ID of this issue
	*/
	@Override
	public void setUserId(long userId) {
		_issue.setUserId(userId);
	}

	/**
	* Returns the user uuid of this issue.
	*
	* @return the user uuid of this issue
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _issue.getUserUuid();
	}

	/**
	* Sets the user uuid of this issue.
	*
	* @param userUuid the user uuid of this issue
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_issue.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this issue.
	*
	* @return the user name of this issue
	*/
	@Override
	public java.lang.String getUserName() {
		return _issue.getUserName();
	}

	/**
	* Sets the user name of this issue.
	*
	* @param userName the user name of this issue
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_issue.setUserName(userName);
	}

	/**
	* Returns the create date of this issue.
	*
	* @return the create date of this issue
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _issue.getCreateDate();
	}

	/**
	* Sets the create date of this issue.
	*
	* @param createDate the create date of this issue
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_issue.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this issue.
	*
	* @return the modified date of this issue
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _issue.getModifiedDate();
	}

	/**
	* Sets the modified date of this issue.
	*
	* @param modifiedDate the modified date of this issue
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_issue.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this issue.
	*
	* @return the title of this issue
	*/
	@Override
	public java.lang.String getTitle() {
		return _issue.getTitle();
	}

	/**
	* Sets the title of this issue.
	*
	* @param title the title of this issue
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_issue.setTitle(title);
	}

	/**
	* Returns the description of this issue.
	*
	* @return the description of this issue
	*/
	@Override
	public java.lang.String getDescription() {
		return _issue.getDescription();
	}

	/**
	* Sets the description of this issue.
	*
	* @param description the description of this issue
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_issue.setDescription(description);
	}

	/**
	* Returns the issue month of this issue.
	*
	* @return the issue month of this issue
	*/
	@Override
	public int getIssueMonth() {
		return _issue.getIssueMonth();
	}

	/**
	* Sets the issue month of this issue.
	*
	* @param issueMonth the issue month of this issue
	*/
	@Override
	public void setIssueMonth(int issueMonth) {
		_issue.setIssueMonth(issueMonth);
	}

	/**
	* Returns the issue year of this issue.
	*
	* @return the issue year of this issue
	*/
	@Override
	public int getIssueYear() {
		return _issue.getIssueYear();
	}

	/**
	* Sets the issue year of this issue.
	*
	* @param issueYear the issue year of this issue
	*/
	@Override
	public void setIssueYear(int issueYear) {
		_issue.setIssueYear(issueYear);
	}

	/**
	* Returns the byline of this issue.
	*
	* @return the byline of this issue
	*/
	@Override
	public java.lang.String getByline() {
		return _issue.getByline();
	}

	/**
	* Sets the byline of this issue.
	*
	* @param byline the byline of this issue
	*/
	@Override
	public void setByline(java.lang.String byline) {
		_issue.setByline(byline);
	}

	@Override
	public boolean isNew() {
		return _issue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_issue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _issue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_issue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _issue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _issue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_issue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _issue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_issue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_issue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_issue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IssueWrapper((Issue)_issue.clone());
	}

	@Override
	public int compareTo(com.liferay.training.newsletter.model.Issue issue) {
		return _issue.compareTo(issue);
	}

	@Override
	public int hashCode() {
		return _issue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.training.newsletter.model.Issue> toCacheModel() {
		return _issue.toCacheModel();
	}

	@Override
	public com.liferay.training.newsletter.model.Issue toEscapedModel() {
		return new IssueWrapper(_issue.toEscapedModel());
	}

	@Override
	public com.liferay.training.newsletter.model.Issue toUnescapedModel() {
		return new IssueWrapper(_issue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _issue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _issue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_issue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IssueWrapper)) {
			return false;
		}

		IssueWrapper issueWrapper = (IssueWrapper)obj;

		if (Validator.equals(_issue, issueWrapper._issue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Issue getWrappedIssue() {
		return _issue;
	}

	@Override
	public Issue getWrappedModel() {
		return _issue;
	}

	@Override
	public void resetOriginalValues() {
		_issue.resetOriginalValues();
	}

	private Issue _issue;
}