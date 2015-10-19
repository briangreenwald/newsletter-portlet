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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.training.newsletter.service.ArticleLocalServiceUtil;
import com.liferay.training.newsletter.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Greenwald
 */
public class ArticleClp extends BaseModelImpl<Article> implements Article {
	public ArticleClp() {
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
	public long getPrimaryKey() {
		return _articleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _articleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Long journalArticleId = (Long)attributes.get("journalArticleId");

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
	}

	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_articleId = articleId;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleId", long.class);

				method.invoke(_articleRemoteModel, articleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIssueId() {
		return _issueId;
	}

	@Override
	public void setIssueId(long issueId) {
		_issueId = issueId;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueId", long.class);

				method.invoke(_articleRemoteModel, issueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJournalArticleId() {
		return _journalArticleId;
	}

	@Override
	public void setJournalArticleId(long journalArticleId) {
		_journalArticleId = journalArticleId;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setJournalArticleId",
						long.class);

				method.invoke(_articleRemoteModel, journalArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_articleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_articleRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_articleRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_articleRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_articleRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_articleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIssueNo() {
		return _issueNo;
	}

	@Override
	public void setIssueNo(int issueNo) {
		_issueNo = issueNo;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueNo", int.class);

				method.invoke(_articleRemoteModel, issueNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_articleRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_articleRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder", int.class);

				method.invoke(_articleRemoteModel, order);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_articleRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getArticleRemoteModel() {
		return _articleRemoteModel;
	}

	public void setArticleRemoteModel(BaseModel<?> articleRemoteModel) {
		_articleRemoteModel = articleRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _articleRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_articleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ArticleLocalServiceUtil.addArticle(this);
		}
		else {
			ArticleLocalServiceUtil.updateArticle(this);
		}
	}

	@Override
	public Article toEscapedModel() {
		return (Article)ProxyUtil.newProxyInstance(Article.class.getClassLoader(),
			new Class[] { Article.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ArticleClp clone = new ArticleClp();

		clone.setArticleId(getArticleId());
		clone.setIssueId(getIssueId());
		clone.setJournalArticleId(getJournalArticleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setIssueNo(getIssueNo());
		clone.setTitle(getTitle());
		clone.setAuthor(getAuthor());
		clone.setOrder(getOrder());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(Article article) {
		int value = 0;

		if (getOrder() < article.getOrder()) {
			value = -1;
		}
		else if (getOrder() > article.getOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleClp)) {
			return false;
		}

		ArticleClp article = (ArticleClp)obj;

		long primaryKey = article.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{articleId=");
		sb.append(getArticleId());
		sb.append(", issueId=");
		sb.append(getIssueId());
		sb.append(", journalArticleId=");
		sb.append(getJournalArticleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", issueNo=");
		sb.append(getIssueNo());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.newsletter.model.Article");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueId</column-name><column-value><![CDATA[");
		sb.append(getIssueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>journalArticleId</column-name><column-value><![CDATA[");
		sb.append(getJournalArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueNo</column-name><column-value><![CDATA[");
		sb.append(getIssueNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _articleId;
	private long _issueId;
	private long _journalArticleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _issueNo;
	private String _title;
	private String _author;
	private int _order;
	private String _content;
	private BaseModel<?> _articleRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.training.newsletter.service.ClpSerializer.class;
}