
package com.liferay.training.newsletter.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class NewsletterPortlet
 */
public class NewsletterPortlet extends MVCPortlet {

	public void doView(RenderRequest request, RenderResponse response) 
		throws IOException, PortletException {

		Map<Integer, List<Issue>> issuesByYear 
			= new LinkedHashMap<Integer, List<Issue>>();
		List<String> years = new ArrayList<String>();

		try {
			issuesByYear = IssueLocalServiceUtil.getApprovedIssuesByYear();

			for (Integer year : issuesByYear.keySet()) {
				years.add(String.valueOf(year));
			}
		}
		catch (Exception e) {
			_log.error(String.format("Unable to retrieve issues: %s", e));
		}
		
		request.setAttribute("issuesByYear", issuesByYear);
		request.setAttribute("years", years.toArray(new String[0]));
		
		Map<Integer, String> monthMap = new HashMap<Integer, String>();
		monthMap.put(Calendar.JANUARY, "January");
		monthMap.put(Calendar.FEBRUARY, "February");
		monthMap.put(Calendar.MARCH, "March");
		monthMap.put(Calendar.APRIL, "April");
		monthMap.put(Calendar.MAY, "May");
		monthMap.put(Calendar.JUNE, "June");
		monthMap.put(Calendar.JULY, "July");
		monthMap.put(Calendar.AUGUST, "August");
		monthMap.put(Calendar.SEPTEMBER, "September");
		monthMap.put(Calendar.OCTOBER, "October");
		monthMap.put(Calendar.NOVEMBER, "November");
		monthMap.put(Calendar.DECEMBER, "December");
		request.setAttribute("monthMap", monthMap);
		
		int currentMonth = -1;
		request.setAttribute("currentMonth", currentMonth);
		
		super.doView(request, response);
	}
	
	public void render(RenderRequest request, RenderResponse response) 
		throws PortletException, IOException {
		
		DateFormat dateFormat = new SimpleDateFormat(_ISSUE_DATE_FORMAT);
		request.setAttribute("dateFormat", dateFormat);
		
		super.render(request, response);
	}
	
	private static Log _log 
		= LogFactoryUtil.getLog(NewsletterPortlet.class.getName());
	
	private static final String _ISSUE_DATE_FORMAT = "MMMM dd, yyyy";
	
}
