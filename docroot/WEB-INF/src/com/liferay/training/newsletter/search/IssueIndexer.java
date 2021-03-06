
package com.liferay.training.newsletter.search;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.training.newsletter.model.Article;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.ArticleLocalServiceUtil;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

public class IssueIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = { Issue.class.getName() };

	public static final String PORTLET_ID = "newsletter_WAR_newsletterportlet";

	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		Issue issue = (Issue) obj;
		Document document = new DocumentImpl();

		document.addUID(PORTLET_ID, issue.getPrimaryKey());

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();

		SearchEngineUtil.deleteDocument(
			searchEngineId, issue.getCompanyId(), document.get(Field.UID),
			false);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		Issue issue = (Issue) obj;
		long groupId = getSiteGroupId(issue.getGroupId());
		long scopeGroupId = issue.getGroupId();
		long companyId = issue.getCompanyId();

		int issueNo = issue.getIssueNo();

		Document document = getBaseModelDocument(PORTLET_ID, issue);

		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword("issueNo", issueNo);

		String[] description = { issue.getTitle(), issue.getDescription() };
		document.addText(Field.DESCRIPTION, description);

		List<Article> articles =
			ArticleLocalServiceUtil.getApprovedArticlesByIssueNo(issueNo);

		List<String> articleTitles = new ArrayList<String>();
		List<String> articleContent = new ArrayList<String>();

		for (Article article : articles) {
			articleTitles.add(article.getTitle());
			articleContent.add(article.getContent());
		}

		document.addText(Field.TITLE, articleTitles.toArray(new String[0]));
		document.addText(Field.CONTENT, articleContent.toArray(new String[0]));

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, 
		PortletURL portletURL) {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		Issue issue = (Issue) obj;

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();

		SearchEngineUtil.updateDocument(
			searchEngineId, issue.getCompanyId(), getDocument(issue), false);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		Issue issue = IssueLocalServiceUtil.getIssue(classPK);

		doReindex(issue);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		doReindexAll(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

	protected void reindexIssues(long companyId, int start, int end)
		throws Exception {

		List<Issue> issues = IssueLocalServiceUtil.getIssues(start, end);

		if (issues.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (Issue issue : issues) {
			Document document = getDocument(issue);

			documents.add(document);
		}

		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();

		SearchEngineUtil.updateDocuments(
			searchEngineId, companyId, documents, false);
	}

	private void doReindexAll(long companyId)
		throws Exception {

		int count = IssueLocalServiceUtil.getIssuesCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexIssues(companyId, start, end);
		}
	}

}