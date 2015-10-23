<%@ include file="/html/init.jsp" %>

<%
	int issueNo = ParamUtil.getInteger(request, "issueNo");
	pageContext.setAttribute("issueNo", issueNo);
	Issue issue = IssueLocalServiceUtil.getApprovedIssueByIssueNo(issueNo);
	pageContext.setAttribute("issue", issue);
%>

<c:set var="issue" value="${issue}" />
<c:set var="issueDate" value="${issue.getIssueDate()}" />
<c:set var="issueTitle" value="${issue.getTitle()}" />
<c:set var="issueByline" value="${issue.getByline()}" />
<c:set var="issueDescription" value="${issue.getDescription()}" />

<p>Issue: #<c:out value="${issueNo}" />, <c:out value="${dateFormat.format(issueDate)}" /></p>

<p>${issueTitle}</p>

<p>${issueByline}</p>

<p>${issueDescription}</p>

<%	
	List<Article> articles = ArticleLocalServiceUtil.getApprovedArticlesByIssueNo(issueNo);

	pageContext.setAttribute("articles", articles);
%>
<ul>
	<c:forEach items="${articles}" var="article">
		<li>
			<p>${article.getTitle()}</p>
			<p>${article.getContent()}</p>
		</li>
	</c:forEach>
</ul>
