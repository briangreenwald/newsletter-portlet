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
public class ArticleSoap implements Serializable {
	public static ArticleSoap toSoapModel(Article model) {
		ArticleSoap soapModel = new ArticleSoap();

		soapModel.setArticleId(model.getArticleId());
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
		soapModel.setAuthor(model.getAuthor());
		soapModel.setOrder(model.getOrder());
		soapModel.setContent(model.getContent());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ArticleSoap[] toSoapModels(Article[] models) {
		ArticleSoap[] soapModels = new ArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleSoap[][] toSoapModels(Article[][] models) {
		ArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleSoap[] toSoapModels(List<Article> models) {
		List<ArticleSoap> soapModels = new ArrayList<ArticleSoap>(models.size());

		for (Article model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleSoap[soapModels.size()]);
	}

	public ArticleSoap() {
	}

	public long getPrimaryKey() {
		return _articleId;
	}

	public void setPrimaryKey(long pk) {
		setArticleId(pk);
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getIssueId() {
		return _issueId;
	}

	public void setIssueId(long issueId) {
		_issueId = issueId;
	}

	public String getJournalArticleId() {
		return _journalArticleId;
	}

	public void setJournalArticleId(String journalArticleId) {
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

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _articleId;
	private long _issueId;
	private String _journalArticleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _issueNo;
	private String _title;
	private String _author;
	private int _order;
	private String _content;
	private int _status;
}