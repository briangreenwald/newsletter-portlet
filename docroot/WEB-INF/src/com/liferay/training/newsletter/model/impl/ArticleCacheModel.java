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

import com.liferay.training.newsletter.model.Article;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Article in entity cache.
 *
 * @author Brian Greenwald
 * @see Article
 * @generated
 */
public class ArticleCacheModel implements CacheModel<Article>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{articleId=");
		sb.append(articleId);
		sb.append(", issueId=");
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
		sb.append(", author=");
		sb.append(author);
		sb.append(", order=");
		sb.append(order);
		sb.append(", content=");
		sb.append(content);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Article toEntityModel() {
		ArticleImpl articleImpl = new ArticleImpl();

		articleImpl.setArticleId(articleId);
		articleImpl.setIssueId(issueId);
		articleImpl.setJournalArticleId(journalArticleId);
		articleImpl.setGroupId(groupId);
		articleImpl.setCompanyId(companyId);
		articleImpl.setUserId(userId);

		if (userName == null) {
			articleImpl.setUserName(StringPool.BLANK);
		}
		else {
			articleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			articleImpl.setCreateDate(null);
		}
		else {
			articleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			articleImpl.setModifiedDate(null);
		}
		else {
			articleImpl.setModifiedDate(new Date(modifiedDate));
		}

		articleImpl.setIssueNo(issueNo);

		if (title == null) {
			articleImpl.setTitle(StringPool.BLANK);
		}
		else {
			articleImpl.setTitle(title);
		}

		if (author == null) {
			articleImpl.setAuthor(StringPool.BLANK);
		}
		else {
			articleImpl.setAuthor(author);
		}

		articleImpl.setOrder(order);

		if (content == null) {
			articleImpl.setContent(StringPool.BLANK);
		}
		else {
			articleImpl.setContent(content);
		}

		articleImpl.setStatus(status);

		articleImpl.resetOriginalValues();

		return articleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		articleId = objectInput.readLong();
		issueId = objectInput.readLong();
		journalArticleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		issueNo = objectInput.readInt();
		title = objectInput.readUTF();
		author = objectInput.readUTF();
		order = objectInput.readInt();
		content = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(articleId);
		objectOutput.writeLong(issueId);
		objectOutput.writeLong(journalArticleId);
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

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeInt(order);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeInt(status);
	}

	public long articleId;
	public long issueId;
	public long journalArticleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int issueNo;
	public String title;
	public String author;
	public int order;
	public String content;
	public int status;
}