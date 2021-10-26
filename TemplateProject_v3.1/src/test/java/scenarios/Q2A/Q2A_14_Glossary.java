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

public class Q2A_14_Glossary extends TestBase{
	
	@Test
	public void Q2A_Glossary () throws Exception {
		ReportLog.setTestName("Q2A - Glossary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_141");
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown13.click();
		VIPFinancialsPage.contents.GlossaryTitle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.GlossaryTitle.verifyText("GLOSSARY");
		VIPFinancialsPage.contents.DashboardHeader.verifyText("DASHBOARD");
		VIPFinancialsPage.contents.KeyIndicatorHeader.verifyText("KEY INDICATOR");
		VIPFinancialsPage.contents.DescriptionHeader.verifyText("DESCRIPTION");
		WebControl.takeScreenshot("Q2A_Regression_141");
		
		ReportLog.setTestCase("Q2A_Regression_142_1");
		VIPFinancialsPage.contents.Dashboard1.verifyText("Total Return to Shareholders");
		VIPFinancialsPage.contents.Dashboard2.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard3.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard4.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard5.verifyText("Analyst Recommendations");
		VIPFinancialsPage.contents.Dashboard6.verifyText("Analyst Recommendations");
		VIPFinancialsPage.contents.Dashboard7.verifyText("Scorecard");
		VIPFinancialsPage.contents.Dashboard8.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.Dashboard9.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.Dashboard10.verifyText("Revenue and Profitability Estimates");
		VIPFinancialsPage.contents.Dashboard11.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard12.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard13.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard14.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard15.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard16.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard17.verifyText("Pre-Tax ROIC Decomposition");
		VIPFinancialsPage.contents.Dashboard18.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard19.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard20.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard21.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard22.verifyText("Operating Working Capital Decomposition");
		VIPFinancialsPage.contents.Dashboard23.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Dashboard24.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Dashboard25.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Dashboard26.verifyText("Cash Cycle Analysis");
		//VIPFinancialsPage.contents.Dashboard27.verifyText("Cash Cycle Analysis");
		//VIPFinancialsPage.contents.Dashboard28.verifyText("Cash Cycle Analysis");
		VIPFinancialsPage.contents.Indicator1.verifyText("Total Return to Shareholders");
		VIPFinancialsPage.contents.Indicator2.verifyText("Premium on Invested Capital (EV / IC)");
		VIPFinancialsPage.contents.Indicator3.verifyText("EV / EBIT");
		VIPFinancialsPage.contents.Indicator4.verifyText("Pre-Tax ROIC (EBIT / IC)");
		VIPFinancialsPage.contents.Indicator5.verifyText("Analyst Ratings");
		VIPFinancialsPage.contents.Indicator6.verifyText("Expected 1-Year Share Price Growth");
		VIPFinancialsPage.contents.Indicator7.verifyText("Buy %");
		VIPFinancialsPage.contents.Indicator8.verifyText("Revenue Growth Estimates");
		VIPFinancialsPage.contents.Indicator9.verifyText("EBIT Margin Estimates");
		VIPFinancialsPage.contents.Indicator10.verifyText("EBITDA Margin Estimates");
		VIPFinancialsPage.contents.Indicator11.verifyText("COGS / Revenue");
		VIPFinancialsPage.contents.Indicator12.verifyText("SG&A / Revenue");
		VIPFinancialsPage.contents.Indicator13.verifyText("Depreciation & Amortization / Revenue");
		VIPFinancialsPage.contents.Indicator14.verifyText("Capital Efficiency");
		VIPFinancialsPage.contents.Indicator15.verifyText("Working Capital / Revenue");
		VIPFinancialsPage.contents.Indicator16.verifyText("Net PPE / Revenue");
		VIPFinancialsPage.contents.Indicator17.verifyText("Goodwill & Intangibles / Revenue");
		VIPFinancialsPage.contents.Indicator18.verifyText("Operating cash / Revenue");
		VIPFinancialsPage.contents.Indicator19.verifyText("Inventory / Revenue");
		VIPFinancialsPage.contents.Indicator20.verifyText("Accounts Payable / Revenue");
		VIPFinancialsPage.contents.Indicator21.verifyText("Net Receivables / Revenue");
		VIPFinancialsPage.contents.Indicator22.verifyText("Inc Tax Payable / Revenue");
		VIPFinancialsPage.contents.Indicator23.verifyText("Cash Cycle");
		VIPFinancialsPage.contents.Indicator24.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.Indicator25.verifyText("Inventory Days");
		VIPFinancialsPage.contents.Indicator26.verifyText("Days Payable");
//		VIPFinancialsPage.contents.Indicator27.verifyText("Inventory Days");
//		VIPFinancialsPage.contents.Indicator28.verifyText("Days Payable");
		VIPFinancialsPage.contents.Definition1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition3.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition4.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition5.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition6.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition7.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition8.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition9.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition10.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition11.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition12.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition13.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition14.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition15.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition16.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition17.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition18.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition19.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition20.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition21.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition22.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition23.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition24.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition25.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Definition26.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.Definition27.verifyDisplayed(true, 5);
//		VIPFinancialsPage.contents.Definition28.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Positive1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_142_1");
		
		ReportLog.setTestCase("Q2A_Regression_142_2");
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
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.SideMenuCompetitor.waitForExist(true, 10);
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPCompetitorPage.contents.RefineCriteriaButton.waitForExist(true, 10);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown13.click();
		VIPFinancialsPage.contents.GlossaryTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.Negative1.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative2.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative3.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative4.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative5.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative6.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative7.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative8.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative9.verifyDisplayed(false);
		VIPFinancialsPage.contents.Negative10.verifyDisplayed(false);
		VIPFinancialsPage.contents.Positive1.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive2.verifyDisplayed(true, 3);
		VIPFinancialsPage.contents.Positive3.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Q2A_Regression_142_2");
		
		ReportLog.setTestCase("Q2A_Regression_144");
		VIPFinancialsPage.contents.GlossaryFootnote.verifyText("Note: Please refer to Methodology for impact of Capitalized Value of Operating Lease & Unfunded Retirement Liability adjustments");
		WebControl.takeScreenshot("Q2A_Regression_144");
		
	}
	
}


