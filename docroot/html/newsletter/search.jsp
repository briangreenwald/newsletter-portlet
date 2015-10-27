<%@ include file="/html/init.jsp" %>

<%
	String keywords = ParamUtil.getString(request, "keywords");

	SearchContext searchContext = SearchContextFactory.getInstance(request);

	searchContext.setKeywords(keywords);
	searchContext.setAttribute("paginationType", "more");


	
	Indexer indexer = IndexerRegistryUtil.getIndexer(Issue.class);

	Hits hits = indexer.search(searchContext);
	List<Document> documents = hits.toList();
	
	List<Issue> issues = new ArrayList<Issue>();

	for (Document doc : documents) {
		
		int issueNo = Integer.valueOf(doc.get("issueNo"));
		Issue issue = null;
		
		try {
			issue = IssueLocalServiceUtil.getIssueByIssueNo(issueNo);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		issues.add(issue);
	}
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/newsletter/search.jsp");
%>

<portlet:renderURL var="searchURL">
    <portlet:param name="mvcPath" value="/html/newsletter/search.jsp" />
</portlet:renderURL>

<aui:form action="${searchURL}" method="post" name="fm">
    <div class="portlet-toolbar search-form">
    	<span class="aui-search-bar">
			<aui:input inlineField="true" label="" name="keywords" size="30" title="search-entries" type="text" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:header title='<%= String.format("Search Results for: %s", keywords) %>' />

<liferay-ui:search-container emptyResultsMessage="issue-empty-results-message" delta="5" iteratorURL="<%= iteratorURL %>">
	<liferay-ui:search-container-results results="<%= ListUtil.subList(issues, searchContainer.getStart(), searchContainer.getEnd()) %>" total="<%= issues.size() %>"/>

	<liferay-ui:search-container-row
		className="com.liferay.training.newsletter.model.Issue" keyProperty="issueId"
		modelVar="issue" escapedModel="true">
		
		<c:set var="issueNo" value="${issue.getIssueNo()}" />
		<c:set var="issueDate" value="${issue.getIssueDate()}" />
		<fmt:formatDate value="${issueDate}" var="formattedDate" pattern="MMMM dd, yyyy" />
		<c:set var="issueTitle" value="${issue.getTitle()}" />

		<portlet:renderURL var="rowURL">
			<portlet:param name="mvcPath" value="/html/newsletter/view_issue.jsp" />
			<portlet:param name="issueNo" value="${issueNo}" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text name=""
			value="
				<p class='issue-info'>Issue: #${issueNo}, ${formattedDate}</p>
				<p class='issue-title'>${issueTitle}</p>" 
			href="<%=rowURL %>" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" />
</liferay-ui:search-container>
