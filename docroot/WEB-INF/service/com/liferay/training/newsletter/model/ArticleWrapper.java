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
 * This class is a wrapper for {@link Article}.
 * </p>
 *
 * @author Brian Greenwald
 * @see Article
 * @generated
 */
public class ArticleWrapper implements Article, ModelWrapper<Article> {
	public ArticleWrapper(Article article) {
		_article = article;
	}

	@Override
	public Class<?> getModelClass() {
		return Article.class;
	}

	@Override
	public String getModelClassName() {
		return Article.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("articleId", getArticleId());
		attributes.put("issueId", getIssueId());
		attributes.put("journalArticleId", getJournalArticleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("issueNo", getIssueNo());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("order", getOrder());
		attributes.put("content", getContent());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long issueId = (Long)attributes.get("issueId");

		if (issueId != null) {
			setIssueId(issueId);
		}

		String journalArticleId = (String)attributes.get("journalArticleId");

		if (journalArticleId != null) {
			setJournalArticleId(journalArticleId);
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

		Integer issueNo = (Integer)attributes.get("issueNo");

		if (issueNo != null) {
			setIssueNo(issueNo);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this article.
	*
	* @return the primary key of this article
	*/
	@Override
	public long getPrimaryKey() {
		return _article.getPrimaryKey();
	}

	/**
	* Sets the primary key of this article.
	*
	* @param primaryKey the primary key of this article
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_article.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the article ID of this article.
	*
	* @return the article ID of this article
	*/
	@Override
	public long getArticleId() {
		return _article.getArticleId();
	}

	/**
	* Sets the article ID of this article.
	*
	* @param articleId the article ID of this article
	*/
	@Override
	public void setArticleId(long articleId) {
		_article.setArticleId(articleId);
	}

	/**
	* Returns the issue ID of this article.
	*
	* @return the issue ID of this article
	*/
	@Override
	public long getIssueId() {
		return _article.getIssueId();
	}

	/**
	* Sets the issue ID of this article.
	*
	* @param issueId the issue ID of this article
	*/
	@Override
	public void setIssueId(long issueId) {
		_article.setIssueId(issueId);
	}

	/**
	* Returns the journal article ID of this article.
	*
	* @return the journal article ID of this article
	*/
	@Override
	public java.lang.String getJournalArticleId() {
		return _article.getJournalArticleId();
	}

	/**
	* Sets the journal article ID of this article.
	*
	* @param journalArticleId the journal article ID of this article
	*/
	@Override
	public void setJournalArticleId(java.lang.String journalArticleId) {
		_article.setJournalArticleId(journalArticleId);
	}

	/**
	* Returns the group ID of this article.
	*
	* @return the group ID of this article
	*/
	@Override
	public long getGroupId() {
		return _article.getGroupId();
	}

	/**
	* Sets the group ID of this article.
	*
	* @param groupId the group ID of this article
	*/
	@Override
	public void setGroupId(long groupId) {
		_article.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this article.
	*
	* @return the company ID of this article
	*/
	@Override
	public long getCompanyId() {
		return _article.getCompanyId();
	}

	/**
	* Sets the company ID of this article.
	*
	* @param companyId the company ID of this article
	*/
	@Override
	public void setCompanyId(long companyId) {
		_article.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this article.
	*
	* @return the user ID of this article
	*/
	@Override
	public long getUserId() {
		return _article.getUserId();
	}

	/**
	* Sets the user ID of this article.
	*
	* @param userId the user ID of this article
	*/
	@Override
	public void setUserId(long userId) {
		_article.setUserId(userId);
	}

	/**
	* Returns the user uuid of this article.
	*
	* @return the user uuid of this article
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _article.getUserUuid();
	}

	/**
	* Sets the user uuid of this article.
	*
	* @param userUuid the user uuid of this article
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_article.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this article.
	*
	* @return the user name of this article
	*/
	@Override
	public java.lang.String getUserName() {
		return _article.getUserName();
	}

	/**
	* Sets the user name of this article.
	*
	* @param userName the user name of this article
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_article.setUserName(userName);
	}

	/**
	* Returns the create date of this article.
	*
	* @return the create date of this article
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _article.getCreateDate();
	}

	/**
	* Sets the create date of this article.
	*
	* @param createDate the create date of this article
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_article.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this article.
	*
	* @return the modified date of this article
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _article.getModifiedDate();
	}

	/**
	* Sets the modified date of this article.
	*
	* @param modifiedDate the modified date of this article
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_article.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the issue no of this article.
	*
	* @return the issue no of this article
	*/
	@Override
	public int getIssueNo() {
		return _article.getIssueNo();
	}

	/**
	* Sets the issue no of this article.
	*
	* @param issueNo the issue no of this article
	*/
	@Override
	public void setIssueNo(int issueNo) {
		_article.setIssueNo(issueNo);
	}

	/**
	* Returns the title of this article.
	*
	* @return the title of this article
	*/
	@Override
	public java.lang.String getTitle() {
		return _article.getTitle();
	}

	/**
	* Sets the title of this article.
	*
	* @param title the title of this article
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_article.setTitle(title);
	}

	/**
	* Returns the author of this article.
	*
	* @return the author of this article
	*/
	@Override
	public java.lang.String getAuthor() {
		return _article.getAuthor();
	}

	/**
	* Sets the author of this article.
	*
	* @param author the author of this article
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_article.setAuthor(author);
	}

	/**
	* Returns the order of this article.
	*
	* @return the order of this article
	*/
	@Override
	public int getOrder() {
		return _article.getOrder();
	}

	/**
	* Sets the order of this article.
	*
	* @param order the order of this article
	*/
	@Override
	public void setOrder(int order) {
		_article.setOrder(order);
	}

	/**
	* Returns the content of this article.
	*
	* @return the content of this article
	*/
	@Override
	public java.lang.String getContent() {
		return _article.getContent();
	}

	/**
	* Sets the content of this article.
	*
	* @param content the content of this article
	*/
	@Override
	public void setContent(java.lang.String content) {
		_article.setContent(content);
	}

	/**
	* Returns the status of this article.
	*
	* @return the status of this article
	*/
	@Override
	public int getStatus() {
		return _article.getStatus();
	}

	/**
	* Sets the status of this article.
	*
	* @param status the status of this article
	*/
	@Override
	public void setStatus(int status) {
		_article.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _article.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_article.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _article.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_article.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _article.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _article.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_article.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _article.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_article.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_article.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_article.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArticleWrapper((Article)_article.clone());
	}

	@Override
	public int compareTo(com.liferay.training.newsletter.model.Article article) {
		return _article.compareTo(article);
	}

	@Override
	public int hashCode() {
		return _article.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.training.newsletter.model.Article> toCacheModel() {
		return _article.toCacheModel();
	}

	@Override
	public com.liferay.training.newsletter.model.Article toEscapedModel() {
		return new ArticleWrapper(_article.toEscapedModel());
	}

	@Override
	public com.liferay.training.newsletter.model.Article toUnescapedModel() {
		return new ArticleWrapper(_article.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _article.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _article.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_article.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleWrapper)) {
			return false;
		}

		ArticleWrapper articleWrapper = (ArticleWrapper)obj;

		if (Validator.equals(_article, articleWrapper._article)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Article getWrappedArticle() {
		return _article;
	}

	@Override
	public Article getWrappedModel() {
		return _article;
	}

	@Override
	public void resetOriginalValues() {
		_article.resetOriginalValues();
	}

	private Article _article;
}