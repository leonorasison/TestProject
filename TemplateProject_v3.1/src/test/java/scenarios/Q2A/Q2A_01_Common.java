package scenarios.Q2A;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;


public class Q2A_01_Common extends TestBase{
	
	@Test
	public void Q2A_Common () throws Exception {
		ReportLog.setTestName("Financials - Common");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_001_to_003");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		else { VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);}
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();				
		//FinancialsCommon
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.verifyDisplayed(true, 45);
		WebControl.takeScreenshot("Q2A_Reg_Auto_001_SelectDashboard");
		VIPFinancialsPage.contents.FinancialsSubTitle1.verifyText("NOTE:");
		VIPFinancialsPage.contents.FinancialsSubTitle2.verifyText("The information displayed here depends on the current Competitors List, please go to Refine Criteria settings under Competitors tab to adjust if needed.");
		WebControl.takeScreenshot("Q2A_Reg_Auto_002_SelectDashboard");
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.DropDownMainHeader1.verifyText("Executive Summary");
		VIPFinancialsPage.contents.SelectDropDown1.verifyText("Competitiveness Scorecard");
		VIPFinancialsPage.contents.DropDownMainHeader2.verifyText("Investor Expectations");
		VIPFinancialsPage.contents.SelectDropDown2.verifyText("Total Return to Shareholders");
		VIPFinancialsPage.contents.SelectDropDown3.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.SelectDropDown4.verifyText("Analyst Recommendations");
		VIPFinancialsPage.contents.SelectDropDown5.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.DropDownMainHeader3.verifyText("Growth Indicators");
		VIPFinancialsPage.contents.SelectDropDown6.verifyText("Revenue Growth");
		VIPFinancialsPage.contents.SelectDropDown7.verifyText("Employee Productivity");
		VIPFinancialsPage.contents.DropDownMainHeader4.verifyText("Operating Performance");
		VIPFinancialsPage.contents.SelectDropDown8.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.SelectDropDown9.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.SelectDropDown10.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.DropDownMainHeader5.verifyText("Segment Trend Analysis");
		VIPFinancialsPage.contents.SelectDropDown11.verifyText("Business Segment Analysis");
		VIPFinancialsPage.contents.SelectDropDown12.verifyText("Geographic Segment Analysis");
		VIPFinancialsPage.contents.DropDownMainHeader6.verifyText("Appendix");
		VIPFinancialsPage.contents.SelectDropDown13.verifyText("Glossary");
		VIPFinancialsPage.contents.SelectDropDown14.verifyText("Methodology");
		VIPFinancialsPage.contents.SelectDropDown15.verifyText("Reference Calculations");
		WebControl.takeScreenshot("Q2A_Reg_Auto_003_SelectDashboard");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_004");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.privCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.RefineCriteriaButton.waitForExist(true, 10);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown1.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown2.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown3.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown4.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown5.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectDropDown6.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown7.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown8.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown9.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown10.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown11.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown12.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown13.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown14.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDropDown15.verifyDisplayed(true);
		WebControl.takeScreenshot("Q2A_Reg_Auto_004");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_005_IsPrivateCompany");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Huawei Investment");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.IsPrivateCompany.verifyText("No Results. Add competitors or refine search criteria to display results.");
		WebControl.takeScreenshot("Q2A_Reg_Auto_005_IsPrivateCompany");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_006_SegmentAnalysis");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("vodafone");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.EBITMarginValue.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.KeyInsights5.waitForExist(true, 60);
		Thread.sleep(2000);
		VIPOverviewPage.contents.RBBPieChart.waitForExist(true, 20);
		VIPOverviewPage.contents.RBBPieChart.hover();
		VIPOverviewPage.contents.RBBPieChart.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.RBGPieChart.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_005_SegmentAnalysis_1");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_006_SegmentAnalysis");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_007");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown2.click();
		VIPFinancialsPage.contents.TRSTitle.verifyText("3-YEAR TRS DEVELOPMENT");
		VIPFinancialsPage.contents.TRSTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.TRSPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.TRSPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_TRS");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown3.click();
		VIPFinancialsPage.contents.EVICTitle.verifyText("PREMIUM ON INVESTED CAPITAL (EV/IC)");
		VIPFinancialsPage.contents.EVICTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EVICTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.EVICPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EVICPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_EVIC");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown4.click();
		VIPFinancialsPage.contents.ANARECTitle.verifyText("EXPECTED 1-YEAR SHARE PRICE GROWTH");
		VIPFinancialsPage.contents.ANARECTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.ANARECTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.ANARECPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.ANARECPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_ANAREC");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown5.click();
		VIPFinancialsPage.contents.RPETitle1.verifyText("REVENUE YOY GROWTH ESTIMATES");
		VIPFinancialsPage.contents.RPETitle2.verifyText("REVENUE CAGR");
		VIPFinancialsPage.contents.RPETargetLegend1.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPETargetLegend2.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPETargetLegendText1.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.RPETargetLegendText2.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.RPEPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPEPeerMedianLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RPEPeerMedianText1.verifyText("Peer Median");
		VIPFinancialsPage.contents.RPEPeerMedianText2.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_RPE");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown6.click();
		VIPFinancialsPage.contents.RGTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RGTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.RGPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.RGPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_RG");
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown7.click();
		VIPFinancialsPage.contents.EPTitle.verifyText("REVENUE PER EMPLOYEE");
		VIPFinancialsPage.contents.EPTargetLegend.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EPTargetLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.EPPeerMedianLine.verifyDisplayed(true, 10);
		VIPFinancialsPage.contents.EPPeerMedianText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_007_EP");
		
				
	}
	
}
	
