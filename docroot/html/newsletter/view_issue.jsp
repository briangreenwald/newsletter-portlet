<%@ include file="/html/init.jsp"%>

<%
	int issueNo = ParamUtil.getInteger(request, "issueNo");
	pageContext.setAttribute("issueNo", issueNo);
	Issue issue = IssueLocalServiceUtil
			.getApprovedIssueByIssueNo(issueNo);
	pageContext.setAttribute("issue", issue);
	
	List<Article> articles = ArticleLocalServiceUtil.getApprovedArticlesByIssueNo(issueNo);

	pageContext.setAttribute("articles", articles);
	
	DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
	
	pageContext.setAttribute("dateFormat", dateFormat);
%>

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
