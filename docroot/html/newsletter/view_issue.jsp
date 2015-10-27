<%@ include file="/html/init.jsp"%>

<%
	int issueNo = ParamUtil.getInteger(request, "issueNo");
	pageContext.setAttribute("issueNo", issueNo);

	Issue issue = null;
	try {
		issue = IssueLocalServiceUtil.getApprovedIssueByIssueNo(issueNo);
		pageContext.setAttribute("issue", issue);

		List<Article> articles = ArticleLocalServiceUtil.getApprovedArticlesByIssueNo(issueNo);
		pageContext.setAttribute("articles", articles);
	}
	catch (Exception e) {
		SessionErrors.add(renderRequest, "issue-does-not-exist-error");
	}
%>

<liferay-ui:error key="issue-does-not-exist-error" message="issue-does-not-exist-error" />

<c:if test="<%= issue != null %>">
	<c:set var="issue" value="${issue}" />
	<c:set var="issueDate" value="${issue.getIssueDate()}" />
	<fmt:formatDate value="${issueDate}" var="formattedDate" pattern="MMMM dd, yyyy" />
	<c:set var="issueTitle" value="${issue.getTitle()}" />
	<c:set var="issueByline" value="${issue.getByline()}" />
	<c:set var="issueDescription" value="${issue.getDescription()}" />

	<div class="newsletter">
		<p class="issue-info">Issue: #${issueNo}, ${formattedDate}</p>

		<p class="issue-title">${issueTitle}</p>

		<p class="issue-byline">${issueByline}</p>

		<p>${issueDescription}</p>

		<ul>
			<c:forEach items="${articles}" var="article">
				<li>
					<p class="article-title">${article.getTitle()}</p>
					<p>${article.getContent()}</p>
				</li>
			</c:forEach>
		</ul>
	</div>
</c:if>
