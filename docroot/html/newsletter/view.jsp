<%@ include file="/html/init.jsp" %>

<%
	String timestampFormat = "MMMM dd, yyyy";
	DateFormat dateFormat = new SimpleDateFormat(timestampFormat);
	
	Map<Integer, String> monthMap = new HashMap<Integer, String>();
	monthMap.put(0, "January");
	monthMap.put(1, "February");
	
	Map<Integer, List<Issue>> issuesByMonth = new LinkedHashMap<Integer, List<Issue>>();
	
	for (int month = Calendar.DECEMBER; month >= Calendar.JANUARY; month--) {
		List<Issue> issues = IssueLocalServiceUtil.getIssuesByMonthAndYear(month, 2012);
		if (!issues.isEmpty()) {
			issuesByMonth.put(month, IssueLocalServiceUtil.getIssuesByMonthAndYear(month, 2012));
		}
	}

%>

<liferay-ui:tabs names="2015,2014,2013,2012" refresh="false" tabsValues="2015,2014,2013,2012" >
	<liferay-ui:section>
		This is the 2015 tab
	</liferay-ui:section>
	<liferay-ui:section>
		This is the 2014 tab
	</liferay-ui:section>
	<liferay-ui:section>
		This is the 2013 tab
	</liferay-ui:section>
	<liferay-ui:section>
		<%
			for (Integer month : issuesByMonth.keySet()) {
		%>
			<div id="month-separator" style="background: #D3D3D3; color: #FFF; text-align: center;"><%= monthMap.get(month) %></div>
			<%
				for (Issue issue : issuesByMonth.get(month)) {
					String issueTitle = issue.getTitle();
					int issueNo = issue.getIssueNo();
					Date issueDate = issue.getIssueDate();
					String issueDateFormatted = dateFormat.format(issueDate);
			%>
			<div>
				<p><%= String.format("Issue: #%d, %s", issueNo, issueDateFormatted) %></p>
				<p style="font-size: 24px;"><%= issueTitle %></p>
				<ul style="list-style: none;">
					<%
						List<Article> articles = ArticleLocalServiceUtil.getArticlesByIssueNo(issueNo);
						for (Article article : articles) {
							String articleTitle = article.getTitle();
					%>
						<li><%= article.getTitle() %></li>
					<%
						}
					%>
				</ul>
			</div>
			<hr style="border-top: dashed 2px;" />
		<%
				}
			}
		%>
	</liferay-ui:section>
</liferay-ui:tabs>