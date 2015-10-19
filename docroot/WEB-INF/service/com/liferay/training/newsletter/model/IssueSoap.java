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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Greenwald
 * @generated
 */
public class IssueSoap implements Serializable {
	public static IssueSoap toSoapModel(Issue model) {
		IssueSoap soapModel = new IssueSoap();

		soapModel.setIssueId(model.getIssueId());
		soapModel.setJournalArticleId(model.getJournalArticleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIssueNo(model.getIssueNo());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setIssueMonth(model.getIssueMonth());
		soapModel.setIssueYear(model.getIssueYear());
		soapModel.setByline(model.getByline());

		return soapModel;
	}

	public static IssueSoap[] toSoapModels(Issue[] models) {
		IssueSoap[] soapModels = new IssueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IssueSoap[][] toSoapModels(Issue[][] models) {
		IssueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IssueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IssueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IssueSoap[] toSoapModels(List<Issue> models) {
		List<IssueSoap> soapModels = new ArrayList<IssueSoap>(models.size());

		for (Issue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IssueSoap[soapModels.size()]);
	}

	public IssueSoap() {
	}

	public long getPrimaryKey() {
		return _issueId;
	}

	public void setPrimaryKey(long pk) {
		setIssueId(pk);
	}

	public long getIssueId() {
		return _issueId;
	}

	public void setIssueId(long issueId) {
		_issueId = issueId;
	}

	public long getJournalArticleId() {
		return _journalArticleId;
	}

	public void setJournalArticleId(long journalArticleId) {
		_journalArticleId = journalArticleId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getIssueNo() {
		return _issueNo;
	}

	public void setIssueNo(int issueNo) {
		_issueNo = issueNo;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public int getIssueMonth() {
		return _issueMonth;
	}

	public void setIssueMonth(int issueMonth) {
		_issueMonth = issueMonth;
	}

	public int getIssueYear() {
		return _issueYear;
	}

	public void setIssueYear(int issueYear) {
		_issueYear = issueYear;
	}

	public String getByline() {
		return _byline;
	}

	public void setByline(String byline) {
		_byline = byline;
	}

	private long _issueId;
	private long _journalArticleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _issueNo;
	private String _title;
	private String _description;
	private Date _issueDate;
	private int _issueMonth;
	private int _issueYear;
	private String _byline;
}