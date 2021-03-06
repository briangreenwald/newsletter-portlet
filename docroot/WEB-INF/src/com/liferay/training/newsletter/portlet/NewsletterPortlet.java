
package com.liferay.training.newsletter.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.training.newsletter.model.Issue;
import com.liferay.training.newsletter.service.IssueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
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

		// Months are 0-based so start before that
		int currentMonth = -1;
		request.setAttribute("currentMonth", currentMonth);

		super.doView(request, response);
	}

	private static Log _log 
		= LogFactoryUtil.getLog(NewsletterPortlet.class.getName());

}
