<%@ include file="/html/init.jsp" %>

<c:set var="yearTabs" value="${fn:join(years, ',')}" />

<liferay-ui:tabs names="${yearTabs}" refresh="false" tabsValues="${yearTabs}" >

	<c:forEach items="${issuesByYear.keySet()}" var="year">
		<liferay-ui:section>
			<c:forEach items="${issuesByYear.get(year)}" var="issue">
				<c:set var="issueNo" value="${issue.getIssueNo()}" />
				<c:set var="issueMonth" value="${issue.getIssueMonth()}" />
				<c:set var="issueDate" value="${issue.getIssueDate()}" />
				<c:set var="issueTitle" value="${issue.getTitle()}" />

				<c:if test="${currentMonth != issueMonth}">
					<div id="month-separator">${monthMap.get(issueMonth)}</div>
					<c:set var="currentMonth" value="${issueMonth}" />
				</c:if>

				<portlet:renderURL var="viewIssueURL">
					<portlet:param name="mvcPath" value="/html/newsletter/view_issue.jsp" />
					<portlet:param name="issueNo" value="${issueNo}" />
				</portlet:renderURL>

				<div>
					<p>Issue: #<c:out value="${issueNo}" />, <c:out value="${dateFormat.format(issueDate)}" /></p>

					<a href="${viewIssueURL}">${issueTitle}</a>

					<%
						int issueNo = (Integer)pageContext.getAttribute("issueNo");

						List<Article> articles = ArticleLocalServiceUtil.getApprovedArticlesByIssueNo(issueNo);

						pageContext.setAttribute("articles", articles);
					%>

					<ul>
						<c:forEach items="${articles}" var="article">
							<li>
								<c:out value="${article.getTitle()}" />
							</li>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</liferay-ui:section>
	</c:forEach>
</liferay-ui:tabs>