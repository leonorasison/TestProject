package scenarios.Custom;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCustomPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;


public class Financials_Custom_02_Common extends TestBase{

	@Test(priority=1)
	public void Financials_Common () throws Exception {
		ReportLog.setTestName("CUSTOM - Common");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Common Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_045,046");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton.hover();
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		//NavigatetoFinancialsTab		
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.CommonSDTitle.verifyText("Select Dashboard");
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.CommonESHeader.verifyText("Executive Summary");
		VIPCustomPage.contents.ScorecardMenu.verifyText("Competitiveness Scorecard");
		VIPCustomPage.contents.VCAMenu.verifyText("Value Creation Areas");
		VIPCustomPage.contents.HRAMenu.verifyText("HR Analysis - Glassdoor Benchmarking");
		VIPCustomPage.contents.CommonIEHeader.verifyText("Investor Expectations");
		VIPCustomPage.contents.TRSMenu.verifyText("Total Return to Shareholders");
		VIPCustomPage.contents.TRSSummaryMenu.verifyText("3-year TRS Decomposition - Summary");
		VIPCustomPage.contents.TRSLeversMenu.verifyText("3-year TRS Decomposition - Levers");
		VIPCustomPage.contents.SCMMenu.verifyText("Strategic Control Map (EV to IC)");
		VIPCustomPage.contents.EVICDecomMenu.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPCustomPage.contents.EVDissectionMenu.verifyText("EV Dissection (Future Value vs. Current Value)");
		VIPCustomPage.contents.AnalystRecoMenu.verifyText("Analyst Recommendations");
		VIPCustomPage.contents.AnalystCommentMenu.verifyText("Analyst Commentary");
		VIPCustomPage.contents.RaPEMenu.verifyText("Revenue and Profitability Estimates");
		VIPCustomPage.contents.CommonGIHeader.verifyText("Growth Indicators");
		VIPCustomPage.contents.RGvsASMenu.verifyText("Revenue Growth vs. Average Spread");
		VIPCustomPage.contents.RevGrowthMenu.verifyText("Revenue Growth");
		VIPCustomPage.contents.EmpProdMenu.verifyText("Employee Productivity");
		VIPCustomPage.contents.CommonOPHeader.verifyText("Operating Performance");
		VIPCustomPage.contents.PreTaxROICDriversMenu.verifyText("Pre-Tax ROIC Drivers – Op. Margin vs. Capital Efficiency");
		VIPCustomPage.contents.PreTaxROICDecompMenu.verifyText("Pre-Tax ROIC Decomposition");
		VIPCustomPage.contents.OWCMenu.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.CashCycleAnalysisMenu.verifyText("Cash Cycle Analysis");
		VIPCustomPage.contents.CommonSTAHeader.verifyText("Segment Trend Analysis");
		VIPFinancialsPage.contents.SelectDropDown11.verifyText("Business Segment Analysis");
		VIPFinancialsPage.contents.SelectDropDown12.verifyText("Geographic Segment Analysis");
		VIPCustomPage.contents.CommonAppendixHeader.verifyText("Appendix");
		VIPCustomPage.contents.GlossaryMenu.verifyText("Glossary");
		VIPCustomPage.contents.MethodologyMenu.verifyText("Methodology");
		VIPCustomPage.contents.ReferenceCalculationsMenu.verifyText("Reference Calculations");
		WebControl.takeScreenshot("CUSTOM_RT_TC_045,046");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_053");
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.CommonCustomCATitle.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CommonCustomCATitle.verifyText("Custom Company Analysis");
		WebControl.takeScreenshot("CUSTOM_RT_TC_053");
	
	}
}
