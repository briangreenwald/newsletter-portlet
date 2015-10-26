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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.training.newsletter.model.Issue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Issue in entity cache.
 *
 * @author Brian Greenwald
 * @see Issue
 * @generated
 */
public class IssueCacheModel implements CacheModel<Issue>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{issueId=");
		sb.append(issueId);
		sb.append(", journalArticleId=");
		sb.append(journalArticleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", issueNo=");
		sb.append(issueNo);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", issueMonth=");
		sb.append(issueMonth);
		sb.append(", issueYear=");
		sb.append(issueYear);
		sb.append(", byline=");
		sb.append(byline);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Issue toEntityModel() {
		IssueImpl issueImpl = new IssueImpl();

		issueImpl.setIssueId(issueId);

		if (journalArticleId == null) {
			issueImpl.setJournalArticleId(StringPool.BLANK);
		}
		else {
			issueImpl.setJournalArticleId(journalArticleId);
		}

		issueImpl.setGroupId(groupId);
		issueImpl.setCompanyId(companyId);
		issueImpl.setUserId(userId);

		if (userName == null) {
			issueImpl.setUserName(StringPool.BLANK);
		}
		else {
			issueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			issueImpl.setCreateDate(null);
		}
		else {
			issueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			issueImpl.setModifiedDate(null);
		}
		else {
			issueImpl.setModifiedDate(new Date(modifiedDate));
		}

		issueImpl.setIssueNo(issueNo);

		if (title == null) {
			issueImpl.setTitle(StringPool.BLANK);
		}
		else {
			issueImpl.setTitle(title);
		}

		if (description == null) {
			issueImpl.setDescription(StringPool.BLANK);
		}
		else {
			issueImpl.setDescription(description);
		}

		if (issueDate == Long.MIN_VALUE) {
			issueImpl.setIssueDate(null);
		}
		else {
			issueImpl.setIssueDate(new Date(issueDate));
		}

		issueImpl.setIssueMonth(issueMonth);
		issueImpl.setIssueYear(issueYear);

		if (byline == null) {
			issueImpl.setByline(StringPool.BLANK);
		}
		else {
			issueImpl.setByline(byline);
		}

		issueImpl.setStatus(status);

		issueImpl.resetOriginalValues();

		return issueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		issueId = objectInput.readLong();
		journalArticleId = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		issueNo = objectInput.readInt();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		issueDate = objectInput.readLong();
		issueMonth = objectInput.readInt();
		issueYear = objectInput.readInt();
		byline = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(issueId);

		if (journalArticleId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(journalArticleId);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(issueNo);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(issueDate);
		objectOutput.writeInt(issueMonth);
		objectOutput.writeInt(issueYear);

		if (byline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(byline);
		}

		objectOutput.writeInt(status);
	}

	public long issueId;
	public String journalArticleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int issueNo;
	public String title;
	public String description;
	public long issueDate;
	public int issueMonth;
	public int issueYear;
	public String byline;
	public int status;
}