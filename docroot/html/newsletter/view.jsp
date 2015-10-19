<%@ include file="/html/init.jsp" %>

<%
	String timestampFormat = "MMMM dd, yyyy";
	DateFormat dateFormat = new SimpleDateFormat(timestampFormat);
	
	Map<Integer, List<Issue>> issuesByMonth = new LinkedHashMap<Integer, List<Issue>>();
	
	for (int month = Calendar.DECEMBER; month >= Calendar.JANUARY; month--) {
		issuesByMonth.put(month, IssueLocalServiceUtil.getIssuesByMonthAndYear(month, 2012));
	}

%>


<portlet:renderURL var="changeTabURL" />

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
				for (Issue issue : issuesByMonth.get(month)) {
					String title = issue.getTitle();
					int issueNo = issue.getIssueNo();
					Date issueDate = issue.getIssueDate();
					String issueDateFormatted = dateFormat.format(issueDate);
		%>
			<div>
				<span><%= String.format("Issue: #%d, %s", issueNo, issueDateFormatted) %></span><br>
				<span><h4><%= title %></h4></span>
				<ul>
					<%
						List<Article> articles = ArticleLocalServiceUtil.get
					%>
				</ul>
			</div>
		
		<%			
				}
			}
		%>
	</liferay-ui:section>
</liferay-ui:tabs>