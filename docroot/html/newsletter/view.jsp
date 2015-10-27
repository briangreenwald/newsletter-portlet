<%@ include file="/html/init.jsp" %>

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

<c:set var="yearTabs" value="${fn:join(years, ',')}" />

<liferay-ui:tabs names="${yearTabs}" refresh="false" tabsValues="${yearTabs}" >

	<c:forEach items="${issuesByYear.keySet()}" var="year">
		<liferay-ui:section>
			<c:forEach items="${issuesByYear.get(year)}" var="issue">
				<c:set var="issueNo" value="${issue.getIssueNo()}" />
				<c:set var="issueMonth" value="${issue.getIssueMonth()}" />
				<c:set var="issueDate" value="${issue.getIssueDate()}" />
				<fmt:formatDate value="${issueDate}" var="formattedDate" pattern="MMMM dd, yyyy" />
				<c:set var="issueTitle" value="${issue.getTitle()}" />

				<c:if test="${currentMonth != issueMonth}">
					<div class="month-separator">${monthMap.get(issueMonth)}</div>
					<c:set var="currentMonth" value="${issueMonth}" />
				</c:if>

				<portlet:renderURL var="viewIssueURL">
					<portlet:param name="mvcPath" value="/html/newsletter/view_issue.jsp" />
					<portlet:param name="issueNo" value="${issueNo}" />
				</portlet:renderURL>

				<div class="newsletter">
					<p class="issue-info">Issue: #<c:out value="${issueNo}" />, <c:out value="${formattedDate}" /></p>

					<a class="issue-title" href="${viewIssueURL}">${issueTitle}</a>

					<%
						int issueNo = (Integer)pageContext.getAttribute("issueNo");

						List<Article> articles = ArticleLocalServiceUtil.getApprovedArticlesByIssueNo(issueNo);

						pageContext.setAttribute("articles", articles);
					%>

					<ul>
						<c:forEach items="${articles}" var="article">
							<li>
								<span class="article-title"> ${article.getTitle()} </span>
							</li>
						</c:forEach>
					</ul>
					<hr class="issue-separator">
				</div>
			</c:forEach>
		</liferay-ui:section>
	</c:forEach>
</liferay-ui:tabs>