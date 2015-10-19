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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.training.newsletter.service.ClpSerializer;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Greenwald
 */
public class IssueClp extends BaseModelImpl<Issue> implements Issue {
	public IssueClp() {
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
	public long getPrimaryKey() {
		return _issueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIssueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _issueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("issueNo", getIssueNo());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("issueMonth", getIssueMonth());
		attributes.put("issueYear", getIssueYear());
		attributes.put("byline", getByline());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

	@Override
	public long getIssueId() {
		return _issueId;
	}

	@Override
	public void setIssueId(long issueId) {
		_issueId = issueId;

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueId", long.class);

				method.invoke(_issueRemoteModel, issueId);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_issueRemoteModel, groupId);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_issueRemoteModel, companyId);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_issueRemoteModel, userId);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_issueRemoteModel, userName);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_issueRemoteModel, createDate);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_issueRemoteModel, modifiedDate);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueNo", int.class);

				method.invoke(_issueRemoteModel, issueNo);
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

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_issueRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_issueRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIssueMonth() {
		return _issueMonth;
	}

	@Override
	public void setIssueMonth(int issueMonth) {
		_issueMonth = issueMonth;

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueMonth", int.class);

				method.invoke(_issueRemoteModel, issueMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIssueYear() {
		return _issueYear;
	}

	@Override
	public void setIssueYear(int issueYear) {
		_issueYear = issueYear;

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueYear", int.class);

				method.invoke(_issueRemoteModel, issueYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getByline() {
		return _byline;
	}

	@Override
	public void setByline(String byline) {
		_byline = byline;

		if (_issueRemoteModel != null) {
			try {
				Class<?> clazz = _issueRemoteModel.getClass();

				Method method = clazz.getMethod("setByline", String.class);

				method.invoke(_issueRemoteModel, byline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIssueRemoteModel() {
		return _issueRemoteModel;
	}

	public void setIssueRemoteModel(BaseModel<?> issueRemoteModel) {
		_issueRemoteModel = issueRemoteModel;
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

		Class<?> remoteModelClass = _issueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_issueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IssueLocalServiceUtil.addIssue(this);
		}
		else {
			IssueLocalServiceUtil.updateIssue(this);
		}
	}

	@Override
	public Issue toEscapedModel() {
		return (Issue)ProxyUtil.newProxyInstance(Issue.class.getClassLoader(),
			new Class[] { Issue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IssueClp clone = new IssueClp();

		clone.setIssueId(getIssueId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setIssueNo(getIssueNo());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setIssueMonth(getIssueMonth());
		clone.setIssueYear(getIssueYear());
		clone.setByline(getByline());

		return clone;
	}

	@Override
	public int compareTo(Issue issue) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), issue.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof IssueClp)) {
			return false;
		}

		IssueClp issue = (IssueClp)obj;

		long primaryKey = issue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{issueId=");
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
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", issueMonth=");
		sb.append(getIssueMonth());
		sb.append(", issueYear=");
		sb.append(getIssueYear());
		sb.append(", byline=");
		sb.append(getByline());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.newsletter.model.Issue");
		sb.append("</model-name>");

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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueMonth</column-name><column-value><![CDATA[");
		sb.append(getIssueMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueYear</column-name><column-value><![CDATA[");
		sb.append(getIssueYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>byline</column-name><column-value><![CDATA[");
		sb.append(getByline());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _issueId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _issueNo;
	private String _title;
	private String _description;
	private int _issueMonth;
	private int _issueYear;
	private String _byline;
	private BaseModel<?> _issueRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.training.newsletter.service.ClpSerializer.class;
}