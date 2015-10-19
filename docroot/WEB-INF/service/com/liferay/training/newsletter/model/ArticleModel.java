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
 * The base model interface for the Article service. Represents a row in the &quot;newsletter_Article&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.newsletter.model.impl.ArticleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.newsletter.model.impl.ArticleImpl}.
 * </p>
 *
 * @author Brian Greenwald
 * @see Article
 * @see com.liferay.training.newsletter.model.impl.ArticleImpl
 * @see com.liferay.training.newsletter.model.impl.ArticleModelImpl
 * @generated
 */
public interface ArticleModel extends BaseModel<Article>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a article model instance should use the {@link Article} interface instead.
	 */

	/**
	 * Returns the primary key of this article.
	 *
	 * @return the primary key of this article
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this article.
	 *
	 * @param primaryKey the primary key of this article
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the article ID of this article.
	 *
	 * @return the article ID of this article
	 */
	public long getArticleId();

	/**
	 * Sets the article ID of this article.
	 *
	 * @param articleId the article ID of this article
	 */
	public void setArticleId(long articleId);

	/**
	 * Returns the issue ID of this article.
	 *
	 * @return the issue ID of this article
	 */
	public long getIssueId();

	/**
	 * Sets the issue ID of this article.
	 *
	 * @param issueId the issue ID of this article
	 */
	public void setIssueId(long issueId);

	/**
	 * Returns the journal article ID of this article.
	 *
	 * @return the journal article ID of this article
	 */
	public long getJournalArticleId();

	/**
	 * Sets the journal article ID of this article.
	 *
	 * @param journalArticleId the journal article ID of this article
	 */
	public void setJournalArticleId(long journalArticleId);

	/**
	 * Returns the group ID of this article.
	 *
	 * @return the group ID of this article
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this article.
	 *
	 * @param groupId the group ID of this article
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this article.
	 *
	 * @return the company ID of this article
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this article.
	 *
	 * @param companyId the company ID of this article
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this article.
	 *
	 * @return the user ID of this article
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this article.
	 *
	 * @param userId the user ID of this article
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this article.
	 *
	 * @return the user uuid of this article
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this article.
	 *
	 * @param userUuid the user uuid of this article
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this article.
	 *
	 * @return the user name of this article
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this article.
	 *
	 * @param userName the user name of this article
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this article.
	 *
	 * @return the create date of this article
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this article.
	 *
	 * @param createDate the create date of this article
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this article.
	 *
	 * @return the modified date of this article
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this article.
	 *
	 * @param modifiedDate the modified date of this article
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the issue no of this article.
	 *
	 * @return the issue no of this article
	 */
	public int getIssueNo();

	/**
	 * Sets the issue no of this article.
	 *
	 * @param issueNo the issue no of this article
	 */
	public void setIssueNo(int issueNo);

	/**
	 * Returns the title of this article.
	 *
	 * @return the title of this article
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this article.
	 *
	 * @param title the title of this article
	 */
	public void setTitle(String title);

	/**
	 * Returns the author of this article.
	 *
	 * @return the author of this article
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this article.
	 *
	 * @param author the author of this article
	 */
	public void setAuthor(String author);

	/**
	 * Returns the order of this article.
	 *
	 * @return the order of this article
	 */
	public int getOrder();

	/**
	 * Sets the order of this article.
	 *
	 * @param order the order of this article
	 */
	public void setOrder(int order);

	/**
	 * Returns the content of this article.
	 *
	 * @return the content of this article
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this article.
	 *
	 * @param content the content of this article
	 */
	public void setContent(String content);

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
	public int compareTo(com.liferay.training.newsletter.model.Article article);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.training.newsletter.model.Article> toCacheModel();

	@Override
	public com.liferay.training.newsletter.model.Article toEscapedModel();

	@Override
	public com.liferay.training.newsletter.model.Article toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}