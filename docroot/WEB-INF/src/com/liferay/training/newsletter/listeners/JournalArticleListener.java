package com.liferay.training.newsletter.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.Calendar;
import java.util.Date;

public class JournalArticleListener extends BaseModelListener<JournalArticle> {

	@Override
	public void onAfterCreate(JournalArticle article) 
		throws ModelListenerException {
		
		String structureName = StringPool.BLANK;
		try {
			structureName = getStructureName(article);
		}
		catch (Exception e) {
			_log.error(String.format(
				"Failed to retrieve structure with id %s: %s",
				article.getStructureId(), e));
		}

		try {
			Document articleContent = SAXReaderUtil.read(article.getContent());

			String titleXML = article.getTitle();
			Document titleDoc = SAXReaderUtil.read(titleXML);
			Element root = titleDoc.getRootElement();
			Element titleElement = root.element(TITLE);
			String title = titleElement.getText();

			String issueNo = parseField(articleContent, ISSUE_NO);

			System.out.println(String.format("Title: %s\nIssue No: %s", title, issueNo));

			if (structureName.equals(NEWSLETTER_ISSUE)) {
				String description = parseField(articleContent, DESCRIPTION);
				String date = parseField(articleContent, ISSUE_DATE);
				Calendar cal = Calendar.getInstance();
				Date issueDate = new Date(Long.valueOf(date));
				String byline = parseField(articleContent, BYLINE);
				System.out.println(String.format("Description: %s\nIssue Date: %s\nByline: %s", description, issueDate, byline));
				
			}
			else if (structureName.equals(NEWSLETTER_ARTICLE)) {
				String author = parseField(articleContent, AUTHOR);
				String order = parseField(articleContent, ORDER);
				String content = parseField(articleContent, CONTENT);
				System.out.println(String.format("Author: %s\nOrder: %s\nContent: %s", author, order, content));
			}

		} catch (DocumentException e) {
			_log.error(String.format(
				"Unable to retrieve contents for JournalArticle with id %d",
				article.getArticleId()));
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
			articleContent.selectSingleNode("/root/dynamic-element[@name='" +
				fieldName + "']/dynamic-content");

		return field.getText();
	}

	private static  Log _log = LogFactoryUtil.getLog(
		JournalArticleListener.class.getName());

	private static final long CLASS_NAME_ID 
		= ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class);

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
