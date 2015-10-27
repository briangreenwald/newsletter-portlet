
package com.liferay.training.newsletter.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.training.newsletter.model.Article;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.ArticleLocalServiceUtil;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;

import java.util.Date;

public class JournalArticleListener extends BaseModelListener<JournalArticle> {

	@Override
	public void onAfterCreate(JournalArticle journalArticle)
		throws ModelListenerException {

		String structureName = StringPool.BLANK;
		try {
			structureName = getStructureName(journalArticle);
		}
		catch (Exception e) {
			_log.error(String.format(
				"Failed to retrieve structure with id %s: %s",
				journalArticle.getStructureId(), e));
		}

		try {
			Document articleContent =
				SAXReaderUtil.read(journalArticle.getContent());

			String titleXML = journalArticle.getTitle();
			Document titleDoc = SAXReaderUtil.read(titleXML);
			Element root = titleDoc.getRootElement();
			Element titleElement = root.element(TITLE);
			String title = titleElement.getText();

			String issueNumnber = parseField(articleContent, ISSUE_NO);
			int issueNo = Integer.parseInt(issueNumnber);

			String journalArticleId = journalArticle.getArticleId();
			long groupId = journalArticle.getGroupId();
			long companyId = journalArticle.getCompanyId();
			long userId = journalArticle.getUserId();
			String userName = journalArticle.getUserName();
			int status = journalArticle.getStatus();

			if (structureName.equalsIgnoreCase(NEWSLETTER_ISSUE)) {
				String description = parseField(articleContent, DESCRIPTION);

				String date = parseField(articleContent, ISSUE_DATE);
				Date issueDate = new Date(Long.valueOf(date));
				String byline = parseField(articleContent, BYLINE);

				try {
					// If this is the first version, create a new Issue object.
					// Otherwise, update the existing issue associated with the
					// JournalArticle
					if (journalArticle.getVersion() == 1) {
						IssueLocalServiceUtil.addIssue(
							journalArticleId, groupId, companyId, userId, 
							userName, issueNo, title, description, issueDate, 
							byline, status);
					}
					else {
						IssueLocalServiceUtil.updateIssue(
							journalArticleId, groupId, companyId, userId, 
							userName, issueNo, title, description, issueDate, 
							byline, status);
					}
				}
				catch (Exception e) {
					_log.error(String.format(
						"Unable to add Issue entitled \"%s\": %s", title, e));
				}
			}
			else if (structureName.equalsIgnoreCase(NEWSLETTER_ARTICLE)) {
				String author = parseField(articleContent, AUTHOR);
				String orderString = parseField(articleContent, ORDER);
				int order = Integer.valueOf(orderString);
				String content = parseField(articleContent, CONTENT);

				try {
					// If this is the first version, create a new Article 
					// object. Otherwise, update the existing article associated
					// with the JournalArticle
					if (journalArticle.getVersion() == 1) {
						ArticleLocalServiceUtil.addArticle(
							journalArticleId, groupId, companyId, userId, 
							userName, issueNo, title, author, order, content, 
							status);
					}
					else {
						ArticleLocalServiceUtil.updateArticle(
							journalArticleId, groupId, companyId, userId, 
							userName, issueNo, title, author, order, content, 
							status);
					}
				}
				catch (Exception e) {
					_log.error(String.format(
						"Unable to add Article entitled \"%s\": %s", title, 
						e));
				}
			}

		}
		catch (DocumentException e) {
			_log.error(String.format(
				"Unable to retrieve contents for JournalArticle with id %d: %s",
				journalArticle.getArticleId(), e));
		}
	}

	@Override
	public void onAfterUpdate(JournalArticle journalArticle)
		throws ModelListenerException {

		String structureName = StringPool.BLANK;
		try {
			structureName = getStructureName(journalArticle);
		}
		catch (Exception e) {
			_log.error(String.format(
				"Failed to retrieve structure with id %s: %s",
				journalArticle.getStructureId(), e));
		}

		try {
			Document articleContent =
				SAXReaderUtil.read(journalArticle.getContent());

			String titleXML = journalArticle.getTitle();
			Document titleDoc = SAXReaderUtil.read(titleXML);
			Element root = titleDoc.getRootElement();
			Element titleElement = root.element(TITLE);
			String title = titleElement.getText();

			String issueNumnber = parseField(articleContent, ISSUE_NO);
			int issueNo = Integer.parseInt(issueNumnber);

			String journalArticleId = journalArticle.getArticleId();
			long groupId = journalArticle.getGroupId();
			long companyId = journalArticle.getCompanyId();
			long userId = journalArticle.getUserId();
			String userName = journalArticle.getUserName();
			int status = journalArticle.getStatus();

			if (structureName.equalsIgnoreCase(NEWSLETTER_ISSUE)) {
				String description = parseField(articleContent, DESCRIPTION);

				String date = parseField(articleContent, ISSUE_DATE);
				Date issueDate = new Date(Long.valueOf(date));
				String byline = parseField(articleContent, BYLINE);

				try {
					IssueLocalServiceUtil.updateIssue(
						journalArticleId, groupId, companyId, userId, userName,
						issueNo, title, description, issueDate, byline, status);
				}
				catch (Exception e) {
					_log.error(String.format(
						"Unable to update Issue entitled \"%s\": %s", title, e));
				}
			}
			else if (structureName.equalsIgnoreCase(NEWSLETTER_ARTICLE)) {
				String author = parseField(articleContent, AUTHOR);
				String orderString = parseField(articleContent, ORDER);
				int order = Integer.valueOf(orderString);
				String content = parseField(articleContent, CONTENT);

				try {
					ArticleLocalServiceUtil.updateArticle(
						journalArticleId, groupId, companyId, userId, userName,
						issueNo, title, author, order, content, status);
				}
				catch (Exception e) {
					_log.error(String.format(
						"Unable to update Article entitled \"%s\": %s", title, e));
				}
			}

		}
		catch (DocumentException e) {
			_log.error(String.format(
				"Unable to retrieve contents for JournalArticle with id %d: %s",
				journalArticle.getArticleId(), e));
		}

	}

	public void onAfterRemove(JournalArticle journalArticle) 
		throws ModelListenerException {
		
		String structureName = StringPool.BLANK;
		try {
			structureName = getStructureName(journalArticle);
		}
		catch (Exception e) {
			_log.error(String.format(
				"Failed to retrieve structure with id %s: %s",
				journalArticle.getStructureId(), e));
		}
		
		String journalArticleId = journalArticle.getArticleId();
		
		if (structureName.equalsIgnoreCase(NEWSLETTER_ISSUE)) {
			try {
				Issue issue = 
					IssueLocalServiceUtil.getIssueByJournalArticleId(
						journalArticleId);
				IssueLocalServiceUtil.deleteIssue(issue);
			}
			catch (Exception e) {
				_log.error(String.format(
					"Unable to delete Issue with journalArticleId %d: %s", 
					journalArticleId, e));
			}
		}
		else if (structureName.equalsIgnoreCase(NEWSLETTER_ARTICLE)) {
			try {
				Article article = 
					ArticleLocalServiceUtil.getArticleByJournalArticleId(
						journalArticleId);
				ArticleLocalServiceUtil.deleteArticle(article);
			}
			catch (Exception e) {
				_log.error(String.format(
					"Unable to delete Article with journalArticle %d: %s", 
					journalArticleId, e));
			}
		}
		
	}

	private String getStructureName(JournalArticle article)
		throws PortalException, SystemException, DocumentException {

		String structureKey = article.getStructureId();

		DDMStructure structure =
			DDMStructureLocalServiceUtil.getStructure(
				article.getGroupId(), CLASS_NAME_ID, structureKey);

		String structureNameXML = structure.getName();
		Document structureNameDoc = SAXReaderUtil.read(structureNameXML);

		Element root = structureNameDoc.getRootElement();
		Element nameElement = root.element(NAME);
		String structureName = nameElement.getText();

		return structureName;
	}

	private String parseField(Document articleContent, String fieldName) {

		Node field =
			articleContent.selectSingleNode(
				"/root/dynamic-element[@name='" + fieldName 
				+ "']/dynamic-content");

		return field.getText();
	}

	private static Log _log =
		LogFactoryUtil.getLog(JournalArticleListener.class.getName());

	private static final long CLASS_NAME_ID =
		ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class);

	private static String ISSUE_NO = "Issue_Number";
	private static String TITLE = "Title";
	private static String NAME = "Name";

	private static String DESCRIPTION = "Description";
	private static String ISSUE_DATE = "Issue_Date";
	private static String BYLINE = "Byline";

	private static String AUTHOR = "Author";
	private static String ORDER = "Order";
	private static String CONTENT = "Content";

	private static String NEWSLETTER_ISSUE = "Newsletter Issue";
	private static String NEWSLETTER_ARTICLE = "Newsletter Article";
}
