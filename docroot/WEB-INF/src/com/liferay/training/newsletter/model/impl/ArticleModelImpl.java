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

package com.liferay.training.newsletter.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.training.newsletter.model.Article;
import com.liferay.training.newsletter.model.ArticleModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Article service. Represents a row in the &quot;newsletter_Article&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.training.newsletter.model.ArticleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ArticleImpl}.
 * </p>
 *
 * @author Brian Greenwald
 * @see ArticleImpl
 * @see com.liferay.training.newsletter.model.Article
 * @see com.liferay.training.newsletter.model.ArticleModel
 * @generated
 */
public class ArticleModelImpl extends BaseModelImpl<Article>
	implements ArticleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a article model instance should use the {@link com.liferay.training.newsletter.model.Article} interface instead.
	 */
	public static final String TABLE_NAME = "newsletter_Article";
	public static final Object[][] TABLE_COLUMNS = {
			{ "articleId", Types.BIGINT },
			{ "issueId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "issueNo", Types.INTEGER },
			{ "title", Types.VARCHAR },
			{ "author", Types.VARCHAR },
			{ "order_", Types.INTEGER },
			{ "content", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table newsletter_Article (articleId LONG not null primary key,issueId LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,issueNo INTEGER,title VARCHAR(75) null,author VARCHAR(75) null,order_ INTEGER,content VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table newsletter_Article";
	public static final String ORDER_BY_JPQL = " ORDER BY article.order ASC";
	public static final String ORDER_BY_SQL = " ORDER BY newsletter_Article.order_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.newsletter.model.Article"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.newsletter.model.Article"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.newsletter.model.Article"),
			true);
	public static long ISSUENO_COLUMN_BITMASK = 1L;
	public static long ORDER_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.newsletter.model.Article"));

	public ArticleModelImpl() {
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
	}

	@Override
	public long getIssueId() {
		return _issueId;
	}

	@Override
	public void setIssueId(long issueId) {
		_issueId = issueId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public int getIssueNo() {
		return _issueNo;
	}

	@Override
	public void setIssueNo(int issueNo) {
		_columnBitmask |= ISSUENO_COLUMN_BITMASK;

		if (!_setOriginalIssueNo) {
			_setOriginalIssueNo = true;

			_originalIssueNo = _issueNo;
		}

		_issueNo = issueNo;
	}

	public int getOriginalIssueNo() {
		return _originalIssueNo;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getAuthor() {
		if (_author == null) {
			return StringPool.BLANK;
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_author = author;
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_columnBitmask = -1L;

		_order = order;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Article.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Article toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Article)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ArticleImpl articleImpl = new ArticleImpl();

		articleImpl.setArticleId(getArticleId());
		articleImpl.setIssueId(getIssueId());
		articleImpl.setGroupId(getGroupId());
		articleImpl.setCompanyId(getCompanyId());
		articleImpl.setUserId(getUserId());
		articleImpl.setUserName(getUserName());
		articleImpl.setCreateDate(getCreateDate());
		articleImpl.setModifiedDate(getModifiedDate());
		articleImpl.setIssueNo(getIssueNo());
		articleImpl.setTitle(getTitle());
		articleImpl.setAuthor(getAuthor());
		articleImpl.setOrder(getOrder());
		articleImpl.setContent(getContent());

		articleImpl.resetOriginalValues();

		return articleImpl;
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

		if (!(obj instanceof Article)) {
			return false;
		}

		Article article = (Article)obj;

		long primaryKey = article.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ArticleModelImpl articleModelImpl = this;

		articleModelImpl._originalIssueNo = articleModelImpl._issueNo;

		articleModelImpl._setOriginalIssueNo = false;

		articleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Article> toCacheModel() {
		ArticleCacheModel articleCacheModel = new ArticleCacheModel();

		articleCacheModel.articleId = getArticleId();

		articleCacheModel.issueId = getIssueId();

		articleCacheModel.groupId = getGroupId();

		articleCacheModel.companyId = getCompanyId();

		articleCacheModel.userId = getUserId();

		articleCacheModel.userName = getUserName();

		String userName = articleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			articleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			articleCacheModel.createDate = createDate.getTime();
		}
		else {
			articleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			articleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			articleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		articleCacheModel.issueNo = getIssueNo();

		articleCacheModel.title = getTitle();

		String title = articleCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			articleCacheModel.title = null;
		}

		articleCacheModel.author = getAuthor();

		String author = articleCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			articleCacheModel.author = null;
		}

		articleCacheModel.order = getOrder();

		articleCacheModel.content = getContent();

		String content = articleCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			articleCacheModel.content = null;
		}

		return articleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{articleId=");
		sb.append(getArticleId());
		sb.append(", issueId=");
		sb.append(getIssueId());
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
		StringBundler sb = new StringBundler(43);

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

	private static ClassLoader _classLoader = Article.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Article.class
		};
	private long _articleId;
	private long _issueId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _issueNo;
	private int _originalIssueNo;
	private boolean _setOriginalIssueNo;
	private String _title;
	private String _author;
	private int _order;
	private String _content;
	private long _columnBitmask;
	private Article _escapedModel;
}