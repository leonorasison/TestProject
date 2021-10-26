package scenarios.Q2A;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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

public class Q2A_16_ReferenceCalculation extends TestBase{
	
	@Test
	public void Q2A_ReferenceCalculation () throws Exception {
		ReportLog.setTestName("Q2A - Reference Calculation");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_148");
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
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		if (VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() & VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyText("Reference Calculations");} 
		else if (!VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed() | !VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
		VIPFinancialsPage.contents.ReferenceCalculationsMenu1.verifyText("Reference Calculations");}
		else {VIPFinancialsPage.contents.ReferenceCalculationsMenu2.verifyText("Reference Calculations");}
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("text-align", "left");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("font-size", "14px");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("letter-spacing", "normal");
		VIPFinancialsPage.contents.ReferenceCalculationsMenu.verifyCssValue("line-height", "20px");
		WebControl.takeScreenshot("Q2A_Regression_148");
		
		ReportLog.setTestCase("Q2A_Regression_149_&_157");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		String TargetCompName_1 = VIPCompetitorPage.contents.TargetCompName.getText();
		String[] TargetCompName_2 = TargetCompName_1.split("\\n");
		String TargetCompName = TargetCompName_2[0];
		String Competitors1stPeers_1 = VIPCompetitorPage.contents.Competitors1stPeers.getText();
		String[] Competitors1stPeers_2 = Competitors1stPeers_1.split("\\n");
		String Competitors1stPeers = Competitors1stPeers_2[0];
		String Competitors2ndPeers_1 = VIPCompetitorPage.contents.Competitors2ndPeers.getText();
		String[] Competitors2ndPeers_2 = Competitors2ndPeers_1.split("\\n");
		String Competitors2ndPeers = Competitors2ndPeers_2[0];
		String Competitors3rdPeers_1 = VIPCompetitorPage.contents.Competitors3rdPeers.getText();
		String[] Competitors3rdPeers_2 = Competitors3rdPeers_1.split("\\n");
		String Competitors3rdPeers = Competitors3rdPeers_2[0];
		String Competitors4thPeers_1 = VIPCompetitorPage.contents.Competitors4thPeers.getText();
		String[] Competitors4thPeers_2 = Competitors4thPeers_1.split("\\n");
		String Competitors4thPeers = Competitors4thPeers_2[0];
		String Competitors5thPeers_1 = VIPCompetitorPage.contents.Competitors5thPeers.getText();
		String[] Competitors5thPeers_2 = Competitors5thPeers_1.split("\\n");
		String Competitors5thPeers = Competitors5thPeers_2[0];
		String Competitors6thPeers_1 = VIPCompetitorPage.contents.Competitors6thPeers.getText();
		String[] Competitors6thPeers_2 = Competitors6thPeers_1.split("\\n");
		String Competitors6thPeers = Competitors6thPeers_2[0];
		String Competitors7thPeers_1 = VIPCompetitorPage.contents.Competitors7thPeers.getText();
		String[] Competitors7thPeers_2 = Competitors7thPeers_1.split("\\n");
		String Competitors7thPeers = Competitors7thPeers_2[0];
		String Competitors8thPeers_1 = VIPCompetitorPage.contents.Competitors8thPeers.getText();
		String[] Competitors8thPeers_2 = Competitors8thPeers_1.split("\\n");
		String Competitors8thPeers = Competitors8thPeers_2[0];
		String Competitors9thPeers_1 = VIPCompetitorPage.contents.Competitors9thPeers.getText();
		String[] Competitors9thPeers_2 = Competitors9thPeers_1.split("\\n");
		String Competitors9thPeers = Competitors9thPeers_2[0];
		String Competitors10thPeers_1 = VIPCompetitorPage.contents.Competitors10thPeers.getText();
		String[] Competitors10thPeers_2 = Competitors10thPeers_1.split("\\n");
		String Competitors10thPeers = Competitors10thPeers_2[0];
		String Competitors11thPeers_1 = VIPCompetitorPage.contents.Competitors11thPeers.getText();
		String[] Competitors11thPeers_2 = Competitors11thPeers_1.split("\\n");
		String Competitors11thPeers = Competitors11thPeers_2[0];
		String Competitors12thPeers_1 = VIPCompetitorPage.contents.Competitors12thPeers.getText();
		String[] Competitors12thPeers_2 = Competitors12thPeers_1.split("\\n");
		String Competitors12thPeers = Competitors12thPeers_2[0];
		String Competitors13thPeers_1 = VIPCompetitorPage.contents.Competitors13thPeers.getText();
		String[] Competitors13thPeers_2 = Competitors13thPeers_1.split("\\n");
		String Competitors13thPeers = Competitors13thPeers_2[0];
		String Competitors14thPeers_1 = VIPCompetitorPage.contents.Competitors14thPeers.getText();
		String[] Competitors14thPeers_2 = Competitors14thPeers_1.split("\\n");
		String Competitors14thPeers = Competitors14thPeers_2[0];
		String Competitors15thPeers_1 = VIPCompetitorPage.contents.Competitors15thPeers.getText();
		String[] Competitors15thPeers_2 = Competitors15thPeers_1.split("\\n");
		String Competitors15thPeers = Competitors15thPeers_2[0];
		String Competitors16thPeers_1 = VIPCompetitorPage.contents.Competitors16thPeers.getText();
		String[] Competitors16thPeers_2 = Competitors16thPeers_1.split("\\n");
		String Competitors16thPeers = Competitors16thPeers_2[0];
		String Competitors17thPeers_1 = VIPCompetitorPage.contents.Competitors17thPeers.getText();
		String[] Competitors17thPeers_2 = Competitors17thPeers_1.split("\\n");
		String Competitors17thPeers = Competitors17thPeers_2[0];
		String Competitors18thPeers_1 = VIPCompetitorPage.contents.Competitors18thPeers.getText();
		String[] Competitors18thPeers_2 = Competitors18thPeers_1.split("\\n");
		String Competitors18thPeers = Competitors18thPeers_2[0];
		String Competitors19thPeers_1 = VIPCompetitorPage.contents.Competitors19thPeers.getText();
		String[] Competitors19thPeers_2 = Competitors19thPeers_1.split("\\n");
		String Competitors19thPeers = Competitors19thPeers_2[0];
		String Competitors20thPeers_1 = VIPCompetitorPage.contents.Competitors20thPeers.getText();
		String[] Competitors20thPeers_2 = Competitors20thPeers_1.split("\\n");
		String Competitors20thPeers = Competitors20thPeers_2[0];
		String Competitors21thPeers_1 = VIPCompetitorPage.contents.Competitors21thPeers.getText();
		String[] Competitors21thPeers_2 = Competitors21thPeers_1.split("\\n");
		String Competitors21thPeers = Competitors21thPeers_2[0];
		String Competitors22thPeers_1 = VIPCompetitorPage.contents.Competitors22thPeers.getText();
		String[] Competitors22thPeers_2 = Competitors22thPeers_1.split("\\n");
		String Competitors22thPeers = Competitors22thPeers_2[0];
		String Competitors23thPeers_1 = VIPCompetitorPage.contents.Competitors23thPeers.getText();
		String[] Competitors23thPeers_2 = Competitors23thPeers_1.split("\\n");
		String Competitors23thPeers = Competitors23thPeers_2[0];
		String Competitors24thPeers_1 = VIPCompetitorPage.contents.Competitors24thPeers.getText();
		String[] Competitors24thPeers_2 = Competitors24thPeers_1.split("\\n");
		String Competitors24thPeers = Competitors24thPeers_2[0];
		String Competitors25thPeers_1 = VIPCompetitorPage.contents.Competitors25thPeers.getText();
		String[] Competitors25thPeers_2 = Competitors25thPeers_1.split("\\n");
		String Competitors25thPeers = Competitors25thPeers_2[0];
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboard.waitForExist(true, 10);
		VIPFinancialsPage.contents.SelectDashboard.click();
		VIPFinancialsPage.contents.ReferenceCalculationMenu.click();
		VIPFinancialsPage.contents.SelectDashboard.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectDashboardLabel.verifyText("Select Dashboard");
		VIPFinancialsPage.contents.SelectCompany.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCompanyLabel.verifyText("Select Company");
		VIPFinancialsPage.contents.SelectCurrency.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyLabel.verifyText("Select Currency");
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCompanyMenu1.verifyText(TargetCompName);
		VIPFinancialsPage.contents.SelectCompanyMenu2.verifyText(Competitors1stPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu3.verifyText(Competitors2ndPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu4.verifyText(Competitors3rdPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu5.verifyText(Competitors4thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu6.verifyText(Competitors5thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu7.verifyText(Competitors6thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu8.verifyText(Competitors7thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu9.verifyText(Competitors8thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu10.verifyText(Competitors9thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu11.verifyText(Competitors10thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu12.verifyText(Competitors11thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu13.verifyText(Competitors12thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu14.verifyText(Competitors13thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu15.verifyText(Competitors14thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu16.verifyText(Competitors15thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu17.verifyText(Competitors16thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu18.verifyText(Competitors17thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu19.verifyText(Competitors18thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu20.verifyText(Competitors19thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu21.verifyText(Competitors20thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu22.verifyText(Competitors21thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu23.verifyText(Competitors22thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu24.verifyText(Competitors23thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu25.verifyText(Competitors24thPeers);
		VIPFinancialsPage.contents.SelectCompanyMenu26.verifyText(Competitors25thPeers);
		VIPFinancialsPage.contents.SelectCurrency.click();
		VIPFinancialsPage.contents.SelectCurrencyMenu1.verifyText("Target Company Currency");
		WebControl.takeScreenshot("Q2A_Regression_149_&_157");
		
		ReportLog.setTestCase("Q2A_Regression_150");
		VIPFinancialsPage.contents.SelectCompanyDefault.verifyText(TargetCompName);
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCurrencyDefault.verifyText("Target Company Currency");
		WebControl.takeScreenshot("Q2A_Regression_150");
		
		ReportLog.setTestCase("Q2A_Regression_151");
		VIPFinancialsPage.contents.SelectCurrency.click();
		VIPFinancialsPage.contents.SelectCurrencyMenu1.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyMenu2.verifyDisplayed(false);
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCompanyMenu2.click();
		VIPFinancialsPage.contents.SelectCurrency.click();
		VIPFinancialsPage.contents.SelectCurrencyMenu1.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyMenu2.verifyDisplayed(true);
		VIPFinancialsPage.contents.SelectCurrencyMenu2.verifyText("Local Currency");
		WebControl.takeScreenshot("Q2A_Regression_151");
		
		ReportLog.setTestCase("Q2A_Regression_152");
		VIPFinancialsPage.contents.ReferenceTitle1.verifyText("EBIT Calculations");
		VIPFinancialsPage.contents.ReferenceTitle2.verifyText("Invested Capital Calculations");
		VIPFinancialsPage.contents.ReferenceTitle3.verifyText("Cash Cycle Calculations");
		WebControl.takeScreenshot("Q2A_Regression_152");
		
		ReportLog.setTestCase("Q2A_Regression_153_Header");
		//EBIT
		VIPFinancialsPage.contents.EBITColumnHeader0.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader0.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader0.verifyCssValue("font-family", "graphik-bold");
		if (VIPFinancialsPage.contents.EBITColumnHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.EBITColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyCssValue("font-family", "graphik-bold");}
		//IC
		VIPFinancialsPage.contents.ICColumnHeader0.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader0.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader0.verifyCssValue("font-family", "graphik-bold");
		if (VIPFinancialsPage.contents.ICColumnHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader1.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader1.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader1.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader2.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader2.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader2.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader3.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader3.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader3.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader4.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader4.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader4.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnHeader5.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.ICColumnHeader5.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICColumnHeader5.verifyCssValue("font-family", "graphik-bold");}
		//CC
		VIPFinancialsPage.contents.CCColumnHeader0.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader0.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader0.verifyCssValue("font-family", "graphik-bold");
		if (VIPFinancialsPage.contents.CCColumnHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnHeader1.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader1.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader1.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.CCColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnHeader2.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader2.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader2.verifyCssValue("font-family", "graphik-bold");}
		if (VIPFinancialsPage.contents.CCColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnHeader3.verifyCssValue("color", "rgba(151, 153, 155, 1)");
		VIPFinancialsPage.contents.CCColumnHeader3.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCColumnHeader3.verifyCssValue("font-family", "graphik-bold");}
		WebControl.takeScreenshot("Q2A_Regression_153_Header");
		
		ReportLog.setTestCase("Q2A_Regression_153_SubHeader");
		//EBIT
		if (VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.EBITColumnSubHeader4.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed() & VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.EBITColumnSubHeader3.verifyDisplayed(false);}
		else if (!VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed() & VIPFinancialsPage.contents.EBITColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.EBITColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.EBITColumnSubHeader2.verifyDisplayed(false);}
		//IC
		if (VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader5.verifyText("");}
		else if (!VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader4.verifyText("");}
		else if (!VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader3.verifyText("");}
		else if (!VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyText("Currency");
		VIPFinancialsPage.contents.ICColumnSubHeader0.verifyCssValue("font-style", "italic");
		VIPFinancialsPage.contents.ICColumnSubHeader2.verifyText("");}
		//CC
		VIPFinancialsPage.contents.CCColumnSubHeader0.verifyText("");
		if (VIPFinancialsPage.contents.CCColumnSubHeader1.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnSubHeader1.verifyCssValue("font-style", "italic");}
		if (VIPFinancialsPage.contents.CCColumnSubHeader2.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnSubHeader2.verifyCssValue("font-style", "italic");}
		if (VIPFinancialsPage.contents.CCColumnSubHeader3.isDisplayed()) {
		VIPFinancialsPage.contents.CCColumnSubHeader3.verifyCssValue("font-style", "italic");}
		WebControl.takeScreenshot("Q2A_Regression_153_SubHeader");
		
		ReportLog.setTestCase("Q2A_Regression_153_Body");
		//EBIT
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		//IC
		VIPFinancialsPage.contents.ICColumn1Data1.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data1.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data2.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data2.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data3.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data3.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data4.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data4.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data5.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data5.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data6.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data6.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		VIPFinancialsPage.contents.ICColumn1Data7.verifyCssValue("font-family", "Graphik");
		VIPFinancialsPage.contents.ICColumn1Data7.verifyCssValue("color", "rgba(39, 38, 45, 1)");
		WebControl.takeScreenshot("Q2A_Regression_153_Body");
		
		ReportLog.setTestCase("Q2A_Regression_153_Total");
		VIPFinancialsPage.contents.EBITTotalData.verifyText("= Adjusted EBIT");
		VIPFinancialsPage.contents.EBITTotalData.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.EBITTotalData.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		VIPFinancialsPage.contents.EBITTotalData.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.ICTotalData.verifyText("= Invested Capital");
		VIPFinancialsPage.contents.ICTotalData.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.ICTotalData.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		VIPFinancialsPage.contents.ICTotalData.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		VIPFinancialsPage.contents.CCTotalData.verifyText("= Cash Cycle");
		VIPFinancialsPage.contents.CCTotalData.verifyCssValue("font-family", "Graphik-Bold");
		VIPFinancialsPage.contents.CCTotalData.verifyCssValue("color", "rgba(255, 255, 255, 1)");
		VIPFinancialsPage.contents.CCTotalData.verifyCssValue("background-color", "rgba(0, 0, 0, 0)");
		WebControl.takeScreenshot("Q2A_Regression_153_Total");
		
		ReportLog.setTestCase("Q2A_Regression_153_Scroll");
		VIPFinancialsPage.contents.ScrollUp.verifyDisplayed(true);
		//VIPFinancialsPage.contents.ScrollDown.verifyDisplayed(true);
		WebControl.takeScreenshot("Q2A_Regression_153_Scroll");
		
		ReportLog.setTestCase("Q2A_Regression_155_&_156_CAGR of EBIT Table and 153_Data Format");
		//************************   Period 1 to 3 is available   *****************************
		if (VIPFinancialsPage.contents.EBITColumnHeader4.isDisplayed()) {
		//Getting the Exponent
		String EBITColumnHeader1 = VIPFinancialsPage.contents.EBITColumnHeader1.getText();
		String[] EBITColumnHeader1_1 = EBITColumnHeader1.split("\\-");
		String EBITColumnHeader1_2 = EBITColumnHeader1_1[1];
		String EBITColumnHeader2 = VIPFinancialsPage.contents.EBITColumnHeader3.getText();
		String[] EBITColumnHeader2_1 = EBITColumnHeader2.split("\\-");
		String EBITColumnHeader2_2 = EBITColumnHeader2_1[1];
		String Date1 = "01/" + EBITColumnHeader1_2;
		String Date2 = "01/" + EBITColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String EBITColumn1Data1_1 = VIPFinancialsPage.contents.EBITColumn1Data1.getText();
		String EBITColumn2Data1_1 = VIPFinancialsPage.contents.EBITColumn2Data1.getText();
		String EBITColumn3Data1_1_1 = VIPFinancialsPage.contents.EBITColumn3Data1.getText();
		if (EBITColumn1Data1_1.contains("-") | EBITColumn2Data1_1.contains("-") | EBITColumn3Data1_1_1.contains("-") |
		EBITColumn1Data1_1.equals("0") | EBITColumn3Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data1.verifyText("N/M");}
		else {
		String EBITColumn1Data1_2 = EBITColumn1Data1_1.replace(",", "");
		double EBITColumn1Data1 = Double.parseDouble(EBITColumn1Data1_2);
		//Ending Data1
		String EBITColumn3Data1_1 = VIPFinancialsPage.contents.EBITColumn3Data1.getText();
		String EBITColumn3Data1_2 = EBITColumn3Data1_1.replace(",", "");
		double EBITColumn3Data1 = Double.parseDouble(EBITColumn3Data1_2);
		double Base1 = EBITColumn3Data1/EBITColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (EBITColumn1Data1_1.length() > 4) {
		String EBITColumn1Data1_1_a = EBITColumn1Data1_1.substring(0, EBITColumn1Data1_1.length() - 4);
		String EBITColumn1Data1_1_b = EBITColumn1Data1_1.substring(EBITColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1_a + "," + EBITColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (EBITColumn2Data1_1.length() > 4) {
		String EBITColumn2Data1_1_a = EBITColumn2Data1_1.substring(0, EBITColumn2Data1_1.length() - 4);
		String EBITColumn2Data1_1_b = EBITColumn2Data1_1.substring(EBITColumn2Data1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1_a + "," + EBITColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1);}
		//Validating the Data Format of Column3Data1  
		if (EBITColumn3Data1_1_1.length() > 4) {
		String EBITColumn3Data1_1_a = EBITColumn3Data1_1_1.substring(0, EBITColumn3Data1_1_1.length() - 4);
		String EBITColumn3Data1_1_b = EBITColumn3Data1_1_1.substring(EBITColumn3Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data1.verifyText(EBITColumn3Data1_1_a + "," + EBITColumn3Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data1.verifyText(EBITColumn3Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String EBITColumn1Data2_1 = VIPFinancialsPage.contents.EBITColumn1Data2.getText();
		String EBITColumn2Data2_1 = VIPFinancialsPage.contents.EBITColumn2Data2.getText();
		String EBITColumn3Data2_1_1 = VIPFinancialsPage.contents.EBITColumn3Data2.getText();
		if (EBITColumn1Data2_1.contains("-") | EBITColumn2Data2_1.contains("-") | EBITColumn3Data2_1_1.contains("-") |
		EBITColumn1Data2_1.equals("0") | EBITColumn3Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data2.verifyText("N/M");}
		else {
		String EBITColumn1Data2_2 = EBITColumn1Data2_1.replace(",", "");
		double EBITColumn1Data2 = Double.parseDouble(EBITColumn1Data2_2);
		//Ending Data2
		String EBITColumn3Data2_1 = VIPFinancialsPage.contents.EBITColumn3Data2.getText();
		String EBITColumn3Data2_2 = EBITColumn3Data2_1.replace(",", "");
		double EBITColumn3Data2 = Double.parseDouble(EBITColumn3Data2_2);
		double Base1 = EBITColumn3Data2/EBITColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (EBITColumn1Data2_1.length() > 4) {
		String EBITColumn1Data2_1_a = EBITColumn1Data2_1.substring(0, EBITColumn1Data2_1.length() - 4);
		String EBITColumn1Data2_1_b = EBITColumn1Data2_1.substring(EBITColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1_a + "," + EBITColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (EBITColumn2Data2_1.length() > 4) {
		String EBITColumn2Data2_1_a = EBITColumn2Data2_1.substring(0, EBITColumn2Data2_1.length() - 4);
		String EBITColumn2Data2_1_b = EBITColumn2Data2_1.substring(EBITColumn2Data2_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1_a + "," + EBITColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1);}
		//Validating the Data Format of Column3Data2  
		if (EBITColumn3Data2_1_1.length() > 4) {
		String EBITColumn3Data2_1_a = EBITColumn3Data2_1_1.substring(0, EBITColumn3Data2_1_1.length() - 4);
		String EBITColumn3Data2_1_b = EBITColumn3Data2_1_1.substring(EBITColumn3Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data2.verifyText(EBITColumn3Data2_1_a + "," + EBITColumn3Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data2.verifyText(EBITColumn3Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String EBITColumn1Data3_1 = VIPFinancialsPage.contents.EBITColumn1Data3.getText();
		String EBITColumn2Data3_1 = VIPFinancialsPage.contents.EBITColumn2Data3.getText();
		String EBITColumn3Data3_1_1 = VIPFinancialsPage.contents.EBITColumn3Data3.getText();
		if (EBITColumn1Data3_1.contains("-") | EBITColumn2Data3_1.contains("-") | EBITColumn3Data3_1_1.contains("-") |
		EBITColumn1Data3_1.equals("0") | EBITColumn3Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data3.verifyText("N/M");}
		else {
		String EBITColumn1Data3_2 = EBITColumn1Data3_1.replace(",", "");
		double EBITColumn1Data3 = Double.parseDouble(EBITColumn1Data3_2);
		//Ending Data3
		String EBITColumn3Data3_1 = VIPFinancialsPage.contents.EBITColumn3Data3.getText();
		String EBITColumn3Data3_2 = EBITColumn3Data3_1.replace(",", "");
		double EBITColumn3Data3 = Double.parseDouble(EBITColumn3Data3_2);
		double Base1 = EBITColumn3Data3/EBITColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (EBITColumn1Data3_1.length() > 4) {
		String EBITColumn1Data3_1_a = EBITColumn1Data3_1.substring(0, EBITColumn1Data3_1.length() - 4);
		String EBITColumn1Data3_1_b = EBITColumn1Data3_1.substring(EBITColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1_a + "," + EBITColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (EBITColumn2Data3_1.length() > 4) {
		String EBITColumn2Data3_1_a = EBITColumn2Data3_1.substring(0, EBITColumn2Data3_1.length() - 4);
		String EBITColumn2Data3_1_b = EBITColumn2Data3_1.substring(EBITColumn2Data3_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1_a + "," + EBITColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1);}
		//Validating the Data Format of Column3Data3  
		if (EBITColumn3Data3_1_1.length() > 4) {
		String EBITColumn3Data3_1_a = EBITColumn3Data3_1_1.substring(0, EBITColumn3Data3_1_1.length() - 4);
		String EBITColumn3Data3_1_b = EBITColumn3Data3_1_1.substring(EBITColumn3Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data3.verifyText(EBITColumn3Data3_1_a + "," + EBITColumn3Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data3.verifyText(EBITColumn3Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String EBITColumn1Data4_1 = VIPFinancialsPage.contents.EBITColumn1Data4.getText();
		String EBITColumn2Data4_1 = VIPFinancialsPage.contents.EBITColumn2Data4.getText();
		String EBITColumn3Data4_1_1 = VIPFinancialsPage.contents.EBITColumn3Data4.getText();
		if (EBITColumn1Data4_1.contains("-") | EBITColumn2Data4_1.contains("-") | EBITColumn3Data4_1_1.contains("-") |
		EBITColumn1Data4_1.equals("0") | EBITColumn3Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data4.verifyText("N/M");}
		else {
		String EBITColumn1Data4_2 = EBITColumn1Data4_1.replace(",", "");
		double EBITColumn1Data4 = Double.parseDouble(EBITColumn1Data4_2);
		//Ending Data4
		String EBITColumn3Data4_1 = VIPFinancialsPage.contents.EBITColumn3Data4.getText();
		String EBITColumn3Data4_2 = EBITColumn3Data4_1.replace(",", "");
		double EBITColumn3Data4 = Double.parseDouble(EBITColumn3Data4_2);
		double Base1 = EBITColumn3Data4/EBITColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (EBITColumn1Data4_1.length() > 4) {
		String EBITColumn1Data4_1_a = EBITColumn1Data4_1.substring(0, EBITColumn1Data4_1.length() - 4);
		String EBITColumn1Data4_1_b = EBITColumn1Data4_1.substring(EBITColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1_a + "," + EBITColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (EBITColumn2Data4_1.length() > 4) {
		String EBITColumn2Data4_1_a = EBITColumn2Data4_1.substring(0, EBITColumn2Data4_1.length() - 4);
		String EBITColumn2Data4_1_b = EBITColumn2Data4_1.substring(EBITColumn2Data4_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1_a + "," + EBITColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1);}
		//Validating the Data Format of Column3Data4  
		if (EBITColumn3Data4_1_1.length() > 4) {
		String EBITColumn3Data4_1_a = EBITColumn3Data4_1_1.substring(0, EBITColumn3Data4_1_1.length() - 4);
		String EBITColumn3Data4_1_b = EBITColumn3Data4_1_1.substring(EBITColumn3Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data4.verifyText(EBITColumn3Data4_1_a + "," + EBITColumn3Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data4.verifyText(EBITColumn3Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String EBITColumn1Data5_1 = VIPFinancialsPage.contents.EBITColumn1Data5.getText();
		String EBITColumn2Data5_1 = VIPFinancialsPage.contents.EBITColumn2Data5.getText();
		String EBITColumn3Data5_1_1 = VIPFinancialsPage.contents.EBITColumn3Data5.getText();
		if (EBITColumn1Data5_1.contains("-") | EBITColumn2Data5_1.contains("-") | EBITColumn3Data5_1_1.contains("-") |
		EBITColumn1Data5_1.equals("0") | EBITColumn3Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data5.verifyText("N/M");}
		else {
		String EBITColumn1Data5_2 = EBITColumn1Data5_1.replace(",", "");
		double EBITColumn1Data5 = Double.parseDouble(EBITColumn1Data5_2);
		//Ending Data5
		String EBITColumn3Data5_1 = VIPFinancialsPage.contents.EBITColumn3Data5.getText();
		String EBITColumn3Data5_2 = EBITColumn3Data5_1.replace(",", "");
		double EBITColumn3Data5 = Double.parseDouble(EBITColumn3Data5_2);
		double Base1 = EBITColumn3Data5/EBITColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (EBITColumn1Data5_1.length() > 4) {
		String EBITColumn1Data5_1_a = EBITColumn1Data5_1.substring(0, EBITColumn1Data5_1.length() - 4);
		String EBITColumn1Data5_1_b = EBITColumn1Data5_1.substring(EBITColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1_a + "," + EBITColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (EBITColumn2Data5_1.length() > 4) {
		String EBITColumn2Data5_1_a = EBITColumn2Data5_1.substring(0, EBITColumn2Data5_1.length() - 4);
		String EBITColumn2Data5_1_b = EBITColumn2Data5_1.substring(EBITColumn2Data5_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1_a + "," + EBITColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1);}
		//Validating the Data Format of Column3Data5  
		if (EBITColumn3Data5_1_1.length() > 4) {
		String EBITColumn3Data5_1_a = EBITColumn3Data5_1_1.substring(0, EBITColumn3Data5_1_1.length() - 4);
		String EBITColumn3Data5_1_b = EBITColumn3Data5_1_1.substring(EBITColumn3Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data5.verifyText(EBITColumn3Data5_1_a + "," + EBITColumn3Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data5.verifyText(EBITColumn3Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String EBITColumn1Data6_1 = VIPFinancialsPage.contents.EBITColumn1Data6.getText();
		String EBITColumn2Data6_1 = VIPFinancialsPage.contents.EBITColumn2Data6.getText();
		String EBITColumn3Data6_1_1 = VIPFinancialsPage.contents.EBITColumn3Data6.getText();
		if (EBITColumn1Data6_1.contains("-") | EBITColumn2Data6_1.contains("-") | EBITColumn3Data6_1_1.contains("-") |
		EBITColumn1Data6_1.equals("0") | EBITColumn3Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data6.verifyText("N/M");}
		else {
		String EBITColumn1Data6_2 = EBITColumn1Data6_1.replace(",", "");
		double EBITColumn1Data6 = Double.parseDouble(EBITColumn1Data6_2);
		//Ending Data6
		String EBITColumn3Data6_1 = VIPFinancialsPage.contents.EBITColumn3Data6.getText();
		String EBITColumn3Data6_2 = EBITColumn3Data6_1.replace(",", "");
		double EBITColumn3Data6 = Double.parseDouble(EBITColumn3Data6_2);
		double Base1 = EBITColumn3Data6/EBITColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (EBITColumn1Data6_1.length() > 4) {
		String EBITColumn1Data6_1_a = EBITColumn1Data6_1.substring(0, EBITColumn1Data6_1.length() - 4);
		String EBITColumn1Data6_1_b = EBITColumn1Data6_1.substring(EBITColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1_a + "," + EBITColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (EBITColumn2Data6_1.length() > 4) {
		String EBITColumn2Data6_1_a = EBITColumn2Data6_1.substring(0, EBITColumn2Data6_1.length() - 4);
		String EBITColumn2Data6_1_b = EBITColumn2Data6_1.substring(EBITColumn2Data6_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1_a + "," + EBITColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1);}
		//Validating the Data Format of Column3Data6  
		if (EBITColumn3Data6_1_1.length() > 4) {
		String EBITColumn3Data6_1_a = EBITColumn3Data6_1_1.substring(0, EBITColumn3Data6_1_1.length() - 4);
		String EBITColumn3Data6_1_b = EBITColumn3Data6_1_1.substring(EBITColumn3Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data6.verifyText(EBITColumn3Data6_1_a + "," + EBITColumn3Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data6.verifyText(EBITColumn3Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String EBITColumn1Data7_1 = VIPFinancialsPage.contents.EBITColumn1Data7.getText();
		String EBITColumn2Data7_1 = VIPFinancialsPage.contents.EBITColumn2Data7.getText();
		String EBITColumn3Data7_1_1 = VIPFinancialsPage.contents.EBITColumn3Data7.getText();
		if (EBITColumn1Data7_1.contains("-") | EBITColumn2Data7_1.contains("-") | EBITColumn3Data7_1_1.contains("-") |
		EBITColumn1Data7_1.equals("0") | EBITColumn3Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn4Data7.verifyText("N/M");}
		else {
		String EBITColumn1Data7_2 = EBITColumn1Data7_1.replace(",", "");
		double EBITColumn1Data7 = Double.parseDouble(EBITColumn1Data7_2);
		//Ending Data7
		String EBITColumn3Data7_1 = VIPFinancialsPage.contents.EBITColumn3Data7.getText();
		String EBITColumn3Data7_2 = EBITColumn3Data7_1.replace(",", "");
		double EBITColumn3Data7 = Double.parseDouble(EBITColumn3Data7_2);
		double Base1 = EBITColumn3Data7/EBITColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn4Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (EBITColumn1Data7_1.length() > 4) {
		String EBITColumn1Data7_1_a = EBITColumn1Data7_1.substring(0, EBITColumn1Data7_1.length() - 4);
		String EBITColumn1Data7_1_b = EBITColumn1Data7_1.substring(EBITColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1_a + "," + EBITColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (EBITColumn2Data7_1.length() > 4) {
		String EBITColumn2Data7_1_a = EBITColumn2Data7_1.substring(0, EBITColumn2Data7_1.length() - 4);
		String EBITColumn2Data7_1_b = EBITColumn2Data7_1.substring(EBITColumn2Data7_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1_a + "," + EBITColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1);}
		//Validating the Data Format of Column3Data7  
		if (EBITColumn3Data7_1_1.length() > 4) {
		String EBITColumn3Data7_1_a = EBITColumn3Data7_1_1.substring(0, EBITColumn3Data7_1_1.length() - 4);
		String EBITColumn3Data7_1_b = EBITColumn3Data7_1_1.substring(EBITColumn3Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn3Data7.verifyText(EBITColumn3Data7_1_a + "," + EBITColumn3Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn3Data7.verifyText(EBITColumn3Data7_1_1);}}
		
		//************************   Period 1 to 2 is available   ******************************
		else if (VIPFinancialsPage.contents.EBITColumnHeader3.isDisplayed()) {
		//Getting the Exponent
		String EBITColumnHeader1 = VIPFinancialsPage.contents.EBITColumnHeader1.getText();
		String[] EBITColumnHeader1_1 = EBITColumnHeader1.split("\\-");
		String EBITColumnHeader1_2 = EBITColumnHeader1_1[1];
		String EBITColumnHeader2 = VIPFinancialsPage.contents.EBITColumnHeader2.getText();
		String[] EBITColumnHeader2_1 = EBITColumnHeader2.split("\\-");
		String EBITColumnHeader2_2 = EBITColumnHeader2_1[1];
		String Date1 = "01/" + EBITColumnHeader1_2;
		String Date2 = "01/" + EBITColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String EBITColumn1Data1_1 = VIPFinancialsPage.contents.EBITColumn1Data1.getText();
		String EBITColumn2Data1_1_1 = VIPFinancialsPage.contents.EBITColumn2Data1.getText();
		if (EBITColumn1Data1_1.contains("-") | EBITColumn2Data1_1_1.contains("-") |
		EBITColumn1Data1_1.equals("0") | EBITColumn2Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data1.verifyText("N/M");}
		else {
		String EBITColumn1Data1_2 = EBITColumn1Data1_1.replace(",", "");
		double EBITColumn1Data1 = Double.parseDouble(EBITColumn1Data1_2);
		//Ending Data1
		String EBITColumn2Data1_1 = VIPFinancialsPage.contents.EBITColumn2Data1.getText();
		String EBITColumn2Data1_2 = EBITColumn2Data1_1.replace(",", "");
		double EBITColumn2Data1 = Double.parseDouble(EBITColumn2Data1_2);
		double Base1 = EBITColumn2Data1/EBITColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (EBITColumn1Data1_1.length() > 4) {
		String EBITColumn1Data1_1_a = EBITColumn1Data1_1.substring(0, EBITColumn1Data1_1.length() - 4);
		String EBITColumn1Data1_1_b = EBITColumn1Data1_1.substring(EBITColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1_a + "," + EBITColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data1.verifyText(EBITColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (EBITColumn2Data1_1_1.length() > 4) {
		String EBITColumn2Data1_1_a = EBITColumn2Data1_1_1.substring(0, EBITColumn2Data1_1_1.length() - 4);
		String EBITColumn2Data1_1_b = EBITColumn2Data1_1_1.substring(EBITColumn2Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1_a + "," + EBITColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data1.verifyText(EBITColumn2Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String EBITColumn1Data2_1 = VIPFinancialsPage.contents.EBITColumn1Data2.getText();
		String EBITColumn2Data2_1_1 = VIPFinancialsPage.contents.EBITColumn2Data2.getText();
		if (EBITColumn1Data2_1.contains("-") | EBITColumn2Data2_1_1.contains("-") |
		EBITColumn1Data2_1.equals("0") | EBITColumn2Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data2.verifyText("N/M");}
		else {
		String EBITColumn1Data2_2 = EBITColumn1Data2_1.replace(",", "");
		double EBITColumn1Data2 = Double.parseDouble(EBITColumn1Data2_2);
		//Ending Data2
		String EBITColumn2Data2_1 = VIPFinancialsPage.contents.EBITColumn2Data2.getText();
		String EBITColumn2Data2_2 = EBITColumn2Data2_1.replace(",", "");
		double EBITColumn2Data2 = Double.parseDouble(EBITColumn2Data2_2);
		double Base1 = EBITColumn2Data2/EBITColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (EBITColumn1Data2_1.length() > 4) {
		String EBITColumn1Data2_1_a = EBITColumn1Data2_1.substring(0, EBITColumn1Data2_1.length() - 4);
		String EBITColumn1Data2_1_b = EBITColumn1Data2_1.substring(EBITColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1_a + "," + EBITColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data2.verifyText(EBITColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (EBITColumn2Data2_1_1.length() > 4) {
		String EBITColumn2Data2_1_a = EBITColumn2Data2_1_1.substring(0, EBITColumn2Data2_1_1.length() - 4);
		String EBITColumn2Data2_1_b = EBITColumn2Data2_1_1.substring(EBITColumn2Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1_a + "," + EBITColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data2.verifyText(EBITColumn2Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String EBITColumn1Data3_1 = VIPFinancialsPage.contents.EBITColumn1Data3.getText();
		String EBITColumn2Data3_1_1 = VIPFinancialsPage.contents.EBITColumn2Data3.getText();
		if (EBITColumn1Data3_1.contains("-") | EBITColumn2Data3_1_1.contains("-") |
		EBITColumn1Data3_1.equals("0") | EBITColumn2Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data3.verifyText("N/M");}
		else {
		String EBITColumn1Data3_2 = EBITColumn1Data3_1.replace(",", "");
		double EBITColumn1Data3 = Double.parseDouble(EBITColumn1Data3_2);
		//Ending Data3
		String EBITColumn2Data3_1 = VIPFinancialsPage.contents.EBITColumn2Data3.getText();
		String EBITColumn2Data3_2 = EBITColumn2Data3_1.replace(",", "");
		double EBITColumn2Data3 = Double.parseDouble(EBITColumn2Data3_2);
		double Base1 = EBITColumn2Data3/EBITColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (EBITColumn1Data3_1.length() > 4) {
		String EBITColumn1Data3_1_a = EBITColumn1Data3_1.substring(0, EBITColumn1Data3_1.length() - 4);
		String EBITColumn1Data3_1_b = EBITColumn1Data3_1.substring(EBITColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1_a + "," + EBITColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data3.verifyText(EBITColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (EBITColumn2Data3_1_1.length() > 4) {
		String EBITColumn2Data3_1_a = EBITColumn2Data3_1_1.substring(0, EBITColumn2Data3_1_1.length() - 4);
		String EBITColumn2Data3_1_b = EBITColumn2Data3_1_1.substring(EBITColumn2Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1_a + "," + EBITColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data3.verifyText(EBITColumn2Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String EBITColumn1Data4_1 = VIPFinancialsPage.contents.EBITColumn1Data4.getText();
		String EBITColumn2Data4_1_1 = VIPFinancialsPage.contents.EBITColumn2Data4.getText();
		if (EBITColumn1Data4_1.contains("-") | EBITColumn2Data4_1_1.contains("-") |
		EBITColumn1Data4_1.equals("0") | EBITColumn2Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data4.verifyText("N/M");}
		else {
		String EBITColumn1Data4_2 = EBITColumn1Data4_1.replace(",", "");
		double EBITColumn1Data4 = Double.parseDouble(EBITColumn1Data4_2);
		//Ending Data4
		String EBITColumn2Data4_1 = VIPFinancialsPage.contents.EBITColumn2Data4.getText();
		String EBITColumn2Data4_2 = EBITColumn2Data4_1.replace(",", "");
		double EBITColumn2Data4 = Double.parseDouble(EBITColumn2Data4_2);
		double Base1 = EBITColumn2Data4/EBITColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (EBITColumn1Data4_1.length() > 4) {
		String EBITColumn1Data4_1_a = EBITColumn1Data4_1.substring(0, EBITColumn1Data4_1.length() - 4);
		String EBITColumn1Data4_1_b = EBITColumn1Data4_1.substring(EBITColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1_a + "," + EBITColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data4.verifyText(EBITColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (EBITColumn2Data4_1_1.length() > 4) {
		String EBITColumn2Data4_1_a = EBITColumn2Data4_1_1.substring(0, EBITColumn2Data4_1_1.length() - 4);
		String EBITColumn2Data4_1_b = EBITColumn2Data4_1_1.substring(EBITColumn2Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1_a + "," + EBITColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data4.verifyText(EBITColumn2Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String EBITColumn1Data5_1 = VIPFinancialsPage.contents.EBITColumn1Data5.getText();
		String EBITColumn2Data5_1_1 = VIPFinancialsPage.contents.EBITColumn2Data5.getText();
		if (EBITColumn1Data5_1.contains("-") | EBITColumn2Data5_1_1.contains("-") |
		EBITColumn1Data5_1.equals("0") | EBITColumn2Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data5.verifyText("N/M");}
		else {
		String EBITColumn1Data5_2 = EBITColumn1Data5_1.replace(",", "");
		double EBITColumn1Data5 = Double.parseDouble(EBITColumn1Data5_2);
		//Ending Data5
		String EBITColumn2Data5_1 = VIPFinancialsPage.contents.EBITColumn2Data5.getText();
		String EBITColumn2Data5_2 = EBITColumn2Data5_1.replace(",", "");
		double EBITColumn2Data5 = Double.parseDouble(EBITColumn2Data5_2);
		double Base1 = EBITColumn2Data5/EBITColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (EBITColumn1Data5_1.length() > 4) {
		String EBITColumn1Data5_1_a = EBITColumn1Data5_1.substring(0, EBITColumn1Data5_1.length() - 4);
		String EBITColumn1Data5_1_b = EBITColumn1Data5_1.substring(EBITColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1_a + "," + EBITColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data5.verifyText(EBITColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (EBITColumn2Data5_1_1.length() > 4) {
		String EBITColumn2Data5_1_a = EBITColumn2Data5_1_1.substring(0, EBITColumn2Data5_1_1.length() - 4);
		String EBITColumn2Data5_1_b = EBITColumn2Data5_1_1.substring(EBITColumn2Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1_a + "," + EBITColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data5.verifyText(EBITColumn2Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String EBITColumn1Data6_1 = VIPFinancialsPage.contents.EBITColumn1Data6.getText();
		String EBITColumn2Data6_1_1 = VIPFinancialsPage.contents.EBITColumn2Data6.getText();
		if (EBITColumn1Data6_1.contains("-") | EBITColumn2Data6_1_1.contains("-") |
		EBITColumn1Data6_1.equals("0") | EBITColumn2Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data6.verifyText("N/M");}
		else {
		String EBITColumn1Data6_2 = EBITColumn1Data6_1.replace(",", "");
		double EBITColumn1Data6 = Double.parseDouble(EBITColumn1Data6_2);
		//Ending Data6
		String EBITColumn2Data6_1 = VIPFinancialsPage.contents.EBITColumn2Data6.getText();
		String EBITColumn2Data6_2 = EBITColumn2Data6_1.replace(",", "");
		double EBITColumn2Data6 = Double.parseDouble(EBITColumn2Data6_2);
		double Base1 = EBITColumn2Data6/EBITColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (EBITColumn1Data6_1.length() > 4) {
		String EBITColumn1Data6_1_a = EBITColumn1Data6_1.substring(0, EBITColumn1Data6_1.length() - 4);
		String EBITColumn1Data6_1_b = EBITColumn1Data6_1.substring(EBITColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1_a + "," + EBITColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data6.verifyText(EBITColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (EBITColumn2Data6_1_1.length() > 4) {
		String EBITColumn2Data6_1_a = EBITColumn2Data6_1_1.substring(0, EBITColumn2Data6_1_1.length() - 4);
		String EBITColumn2Data6_1_b = EBITColumn2Data6_1_1.substring(EBITColumn2Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1_a + "," + EBITColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data6.verifyText(EBITColumn2Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String EBITColumn1Data7_1 = VIPFinancialsPage.contents.EBITColumn1Data7.getText();
		String EBITColumn2Data7_1_1 = VIPFinancialsPage.contents.EBITColumn2Data7.getText();
		if (EBITColumn1Data7_1.contains("-") | EBITColumn2Data7_1_1.contains("-") |
		EBITColumn1Data7_1.equals("0") | EBITColumn2Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.EBITColumn3Data7.verifyText("N/M");}
		else {
		String EBITColumn1Data7_2 = EBITColumn1Data7_1.replace(",", "");
		double EBITColumn1Data7 = Double.parseDouble(EBITColumn1Data7_2);
		//Ending Data7
		String EBITColumn2Data7_1 = VIPFinancialsPage.contents.EBITColumn2Data7.getText();
		String EBITColumn2Data7_2 = EBITColumn2Data7_1.replace(",", "");
		double EBITColumn2Data7 = Double.parseDouble(EBITColumn2Data7_2);
		double Base1 = EBITColumn2Data7/EBITColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.EBITColumn3Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (EBITColumn1Data7_1.length() > 4) {
		String EBITColumn1Data7_1_a = EBITColumn1Data7_1.substring(0, EBITColumn1Data7_1.length() - 4);
		String EBITColumn1Data7_1_b = EBITColumn1Data7_1.substring(EBITColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1_a + "," + EBITColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn1Data7.verifyText(EBITColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (EBITColumn2Data7_1_1.length() > 4) {
		String EBITColumn2Data7_1_a = EBITColumn2Data7_1_1.substring(0, EBITColumn2Data7_1_1.length() - 4);
		String EBITColumn2Data7_1_b = EBITColumn2Data7_1_1.substring(EBITColumn2Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1_a + "," + EBITColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.EBITColumn2Data7.verifyText(EBITColumn2Data7_1_1);}}
		
		//*************************   Period 1 is available   *******************************
		else {
		VIPFinancialsPage.contents.EBITColumn2Data1.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data2.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data3.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data4.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data5.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data6.verifyText("N/M");
		VIPFinancialsPage.contents.EBITColumn2Data7.verifyText("N/M");}
		WebControl.takeScreenshot("Q2A_Regression_155_&_156_CAGR of EBIT Table");
		
		ReportLog.setTestCase("Q2A_Regression_155_&_156_CAGR of IC Table and 153_Data Format");
		//************************   Period 1 to 4 is available   *****************************
		if (VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed()) {
		//Getting the Exponent
		String ICColumnHeader1 = VIPFinancialsPage.contents.ICColumnHeader1.getText();
		String[] ICColumnHeader1_1 = ICColumnHeader1.split("\\-");
		String ICColumnHeader1_2 = ICColumnHeader1_1[1];
		String ICColumnHeader2 = VIPFinancialsPage.contents.ICColumnHeader4.getText();
		String[] ICColumnHeader2_1 = ICColumnHeader2.split("\\-");
		String ICColumnHeader2_2 = ICColumnHeader2_1[1];
		String Date1 = "01/" + ICColumnHeader1_2;
		String Date2 = "01/" + ICColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String ICColumn1Data1_1 = VIPFinancialsPage.contents.ICColumn1Data1.getText();
		String ICColumn2Data1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		String ICColumn3Data1_1 = VIPFinancialsPage.contents.ICColumn3Data1.getText();
		String ICColumn4Data1_1_1 = VIPFinancialsPage.contents.ICColumn4Data1.getText();
		if (ICColumn1Data1_1.contains("-") | ICColumn2Data1_1.contains("-") | ICColumn3Data1_1.contains("-") | ICColumn4Data1_1_1.contains("-") |
		ICColumn1Data1_1.equals("0") | ICColumn4Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data1.verifyText("N/M");}
		else {
		String ICColumn1Data1_2 = ICColumn1Data1_1.replace(",", "");
		double ICColumn1Data1 = Double.parseDouble(ICColumn1Data1_2);
		//Ending Data1
		String ICColumn4Data1_1 = VIPFinancialsPage.contents.ICColumn4Data1.getText();
		String ICColumn4Data1_2 = ICColumn4Data1_1.replace(",", "");
		double ICColumn4Data1 = Double.parseDouble(ICColumn4Data1_2);
		double Base1 = ICColumn4Data1/ICColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (ICColumn1Data1_1.length() > 4) {
		String ICColumn1Data1_1_a = ICColumn1Data1_1.substring(0, ICColumn1Data1_1.length() - 4);
		String ICColumn1Data1_1_b = ICColumn1Data1_1.substring(ICColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1_a + "," + ICColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (ICColumn2Data1_1.length() > 4) {
		String ICColumn2Data1_1_a = ICColumn2Data1_1.substring(0, ICColumn2Data1_1.length() - 4);
		String ICColumn2Data1_1_b = ICColumn2Data1_1.substring(ICColumn2Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_a + "," + ICColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1);}
		//Validating the Data Format of Column3Data1  
		if (ICColumn3Data1_1.length() > 4) {
		String ICColumn3Data1_1_a = ICColumn3Data1_1.substring(0, ICColumn3Data1_1.length() - 4);
		String ICColumn3Data1_1_b = ICColumn3Data1_1.substring(ICColumn3Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1_a + "," + ICColumn3Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1);}
		//Validating the Data Format of Column4Data1  
		if (ICColumn4Data1_1_1.length() > 4) {
		String ICColumn4Data1_1_a = ICColumn4Data1_1_1.substring(0, ICColumn4Data1_1_1.length() - 4);
		String ICColumn4Data1_1_b = ICColumn4Data1_1_1.substring(ICColumn4Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data1.verifyText(ICColumn4Data1_1_a + "," + ICColumn4Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data1.verifyText(ICColumn4Data1_1_1);}
		
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String ICColumn1Data2_1 = VIPFinancialsPage.contents.ICColumn1Data2.getText();
		String ICColumn2Data2_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		String ICColumn3Data2_1 = VIPFinancialsPage.contents.ICColumn3Data2.getText();
		String ICColumn4Data2_1_1 = VIPFinancialsPage.contents.ICColumn4Data2.getText();
		if (ICColumn1Data2_1.contains("-") | ICColumn2Data2_1.contains("-") | ICColumn3Data2_1.contains("-") | ICColumn4Data2_1_1.contains("-") |
		ICColumn1Data2_1.equals("0") | ICColumn4Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data2.verifyText("N/M");}
		else {
		String ICColumn1Data2_2 = ICColumn1Data2_1.replace(",", "");
		double ICColumn1Data2 = Double.parseDouble(ICColumn1Data2_2);
		//Ending Data2
		String ICColumn4Data2_1 = VIPFinancialsPage.contents.ICColumn4Data2.getText();
		String ICColumn4Data2_2 = ICColumn4Data2_1.replace(",", "");
		double ICColumn4Data2 = Double.parseDouble(ICColumn4Data2_2);
		double Base1 = ICColumn4Data2/ICColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (ICColumn1Data2_1.length() > 4) {
		String ICColumn1Data2_1_a = ICColumn1Data2_1.substring(0, ICColumn1Data2_1.length() - 4);
		String ICColumn1Data2_1_b = ICColumn1Data2_1.substring(ICColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1_a + "," + ICColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (ICColumn2Data2_1.length() > 4) {
		String ICColumn2Data2_1_a = ICColumn2Data2_1.substring(0, ICColumn2Data2_1.length() - 4);
		String ICColumn2Data2_1_b = ICColumn2Data2_1.substring(ICColumn2Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_a + "," + ICColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1);}
		//Validating the Data Format of Column3Data2  
		if (ICColumn3Data2_1.length() > 4) {
		String ICColumn3Data2_1_a = ICColumn3Data2_1.substring(0, ICColumn3Data2_1.length() - 4);
		String ICColumn3Data2_1_b = ICColumn3Data2_1.substring(ICColumn3Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1_a + "," + ICColumn3Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1);}
		//Validating the Data Format of Column4Data2  
		if (ICColumn4Data2_1_1.length() > 4) {
		String ICColumn4Data2_1_a = ICColumn4Data2_1_1.substring(0, ICColumn4Data2_1_1.length() - 4);
		String ICColumn4Data2_1_b = ICColumn4Data2_1_1.substring(ICColumn4Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data2.verifyText(ICColumn4Data2_1_a + "," + ICColumn4Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data2.verifyText(ICColumn4Data2_1_1);}
		
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String ICColumn1Data3_1 = VIPFinancialsPage.contents.ICColumn1Data3.getText();
		String ICColumn2Data3_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		String ICColumn3Data3_1 = VIPFinancialsPage.contents.ICColumn3Data3.getText();
		String ICColumn4Data3_1_1 = VIPFinancialsPage.contents.ICColumn4Data3.getText();
		if (ICColumn1Data3_1.contains("-") | ICColumn2Data3_1.contains("-") | ICColumn3Data3_1.contains("-") | ICColumn4Data3_1_1.contains("-") |
		ICColumn1Data3_1.equals("0") | ICColumn4Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data3.verifyText("N/M");}
		else {
		String ICColumn1Data3_2 = ICColumn1Data3_1.replace(",", "");
		double ICColumn1Data3 = Double.parseDouble(ICColumn1Data3_2);
		//Ending Data3
		String ICColumn4Data3_1 = VIPFinancialsPage.contents.ICColumn4Data3.getText();
		String ICColumn4Data3_2 = ICColumn4Data3_1.replace(",", "");
		double ICColumn4Data3 = Double.parseDouble(ICColumn4Data3_2);
		double Base1 = ICColumn4Data3/ICColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (ICColumn1Data3_1.length() > 4) {
		String ICColumn1Data3_1_a = ICColumn1Data3_1.substring(0, ICColumn1Data3_1.length() - 4);
		String ICColumn1Data3_1_b = ICColumn1Data3_1.substring(ICColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1_a + "," + ICColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (ICColumn2Data3_1.length() > 4) {
		String ICColumn2Data3_1_a = ICColumn2Data3_1.substring(0, ICColumn2Data3_1.length() - 4);
		String ICColumn2Data3_1_b = ICColumn2Data3_1.substring(ICColumn2Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_a + "," + ICColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1);}
		//Validating the Data Format of Column3Data3  
		if (ICColumn3Data3_1.length() > 4) {
		String ICColumn3Data3_1_a = ICColumn3Data3_1.substring(0, ICColumn3Data3_1.length() - 4);
		String ICColumn3Data3_1_b = ICColumn3Data3_1.substring(ICColumn3Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1_a + "," + ICColumn3Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1);}
		//Validating the Data Format of Column4Data3  
		if (ICColumn4Data3_1_1.length() > 4) {
		String ICColumn4Data3_1_a = ICColumn4Data3_1_1.substring(0, ICColumn4Data3_1_1.length() - 4);
		String ICColumn4Data3_1_b = ICColumn4Data3_1_1.substring(ICColumn4Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data3.verifyText(ICColumn4Data3_1_a + "," + ICColumn4Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data3.verifyText(ICColumn4Data3_1_1);}
		
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String ICColumn1Data4_1 = VIPFinancialsPage.contents.ICColumn1Data4.getText();
		String ICColumn2Data4_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		String ICColumn3Data4_1 = VIPFinancialsPage.contents.ICColumn3Data4.getText();
		String ICColumn4Data4_1_1 = VIPFinancialsPage.contents.ICColumn4Data4.getText();
		if (ICColumn1Data4_1.contains("-") | ICColumn2Data4_1.contains("-") | ICColumn3Data4_1.contains("-") | ICColumn4Data4_1_1.contains("-") |
		ICColumn1Data4_1.equals("0") | ICColumn4Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data4.verifyText("N/M");}
		else {
		String ICColumn1Data4_2 = ICColumn1Data4_1.replace(",", "");
		double ICColumn1Data4 = Double.parseDouble(ICColumn1Data4_2);
		//Ending Data4
		String ICColumn4Data4_1 = VIPFinancialsPage.contents.ICColumn4Data4.getText();
		String ICColumn4Data4_2 = ICColumn4Data4_1.replace(",", "");
		double ICColumn4Data4 = Double.parseDouble(ICColumn4Data4_2);
		double Base1 = ICColumn4Data4/ICColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (ICColumn1Data4_1.length() > 4) {
		String ICColumn1Data4_1_a = ICColumn1Data4_1.substring(0, ICColumn1Data4_1.length() - 4);
		String ICColumn1Data4_1_b = ICColumn1Data4_1.substring(ICColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1_a + "," + ICColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (ICColumn2Data4_1.length() > 4) {
		String ICColumn2Data4_1_a = ICColumn2Data4_1.substring(0, ICColumn2Data4_1.length() - 4);
		String ICColumn2Data4_1_b = ICColumn2Data4_1.substring(ICColumn2Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_a + "," + ICColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1);}
		//Validating the Data Format of Column3Data4  
		if (ICColumn3Data4_1.length() > 4) {
		String ICColumn3Data4_1_a = ICColumn3Data4_1.substring(0, ICColumn3Data4_1.length() - 4);
		String ICColumn3Data4_1_b = ICColumn3Data4_1.substring(ICColumn3Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1_a + "," + ICColumn3Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1);}
		//Validating the Data Format of Column4Data4  
		if (ICColumn4Data4_1_1.length() > 4) {
		String ICColumn4Data4_1_a = ICColumn4Data4_1_1.substring(0, ICColumn4Data4_1_1.length() - 4);
		String ICColumn4Data4_1_b = ICColumn4Data4_1_1.substring(ICColumn4Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data4.verifyText(ICColumn4Data4_1_a + "," + ICColumn4Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data4.verifyText(ICColumn4Data4_1_1);}
		
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String ICColumn1Data5_1 = VIPFinancialsPage.contents.ICColumn1Data5.getText();
		String ICColumn2Data5_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		String ICColumn3Data5_1 = VIPFinancialsPage.contents.ICColumn3Data5.getText();
		String ICColumn4Data5_1_1 = VIPFinancialsPage.contents.ICColumn4Data5.getText();
		if (ICColumn1Data5_1.contains("-") | ICColumn2Data5_1.contains("-") | ICColumn3Data5_1.contains("-") | ICColumn4Data5_1_1.contains("-") |
		ICColumn1Data5_1.equals("0") | ICColumn4Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data5.verifyText("N/M");}
		else {
		String ICColumn1Data5_2 = ICColumn1Data5_1.replace(",", "");
		double ICColumn1Data5 = Double.parseDouble(ICColumn1Data5_2);
		//Ending Data5
		String ICColumn4Data5_1 = VIPFinancialsPage.contents.ICColumn4Data5.getText();
		String ICColumn4Data5_2 = ICColumn4Data5_1.replace(",", "");
		double ICColumn4Data5 = Double.parseDouble(ICColumn4Data5_2);
		double Base1 = ICColumn4Data5/ICColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (ICColumn1Data5_1.length() > 4) {
		String ICColumn1Data5_1_a = ICColumn1Data5_1.substring(0, ICColumn1Data5_1.length() - 4);
		String ICColumn1Data5_1_b = ICColumn1Data5_1.substring(ICColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1_a + "," + ICColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (ICColumn2Data5_1.length() > 4) {
		String ICColumn2Data5_1_a = ICColumn2Data5_1.substring(0, ICColumn2Data5_1.length() - 4);
		String ICColumn2Data5_1_b = ICColumn2Data5_1.substring(ICColumn2Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_a + "," + ICColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1);}
		//Validating the Data Format of Column3Data5  
		if (ICColumn3Data5_1.length() > 4) {
		String ICColumn3Data5_1_a = ICColumn3Data5_1.substring(0, ICColumn3Data5_1.length() - 4);
		String ICColumn3Data5_1_b = ICColumn3Data5_1.substring(ICColumn3Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1_a + "," + ICColumn3Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1);}
		//Validating the Data Format of Column4Data5  
		if (ICColumn4Data5_1_1.length() > 4) {
		String ICColumn4Data5_1_a = ICColumn4Data5_1_1.substring(0, ICColumn4Data5_1_1.length() - 4);
		String ICColumn4Data5_1_b = ICColumn4Data5_1_1.substring(ICColumn4Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data5.verifyText(ICColumn4Data5_1_a + "," + ICColumn4Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data5.verifyText(ICColumn4Data5_1_1);}
		
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String ICColumn1Data6_1 = VIPFinancialsPage.contents.ICColumn1Data6.getText();
		String ICColumn2Data6_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		String ICColumn3Data6_1 = VIPFinancialsPage.contents.ICColumn3Data6.getText();
		String ICColumn4Data6_1_1 = VIPFinancialsPage.contents.ICColumn4Data6.getText();
		if (ICColumn1Data6_1.contains("-") | ICColumn2Data6_1.contains("-") | ICColumn3Data6_1.contains("-") | ICColumn4Data6_1_1.contains("-") |
		ICColumn1Data6_1.equals("0") | ICColumn4Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data6.verifyText("N/M");}
		else {
		String ICColumn1Data6_2 = ICColumn1Data6_1.replace(",", "");
		double ICColumn1Data6 = Double.parseDouble(ICColumn1Data6_2);
		//Ending Data6
		String ICColumn4Data6_1 = VIPFinancialsPage.contents.ICColumn4Data6.getText();
		String ICColumn4Data6_2 = ICColumn4Data6_1.replace(",", "");
		double ICColumn4Data6 = Double.parseDouble(ICColumn4Data6_2);
		double Base1 = ICColumn4Data6/ICColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (ICColumn1Data6_1.length() > 4) {
		String ICColumn1Data6_1_a = ICColumn1Data6_1.substring(0, ICColumn1Data6_1.length() - 4);
		String ICColumn1Data6_1_b = ICColumn1Data6_1.substring(ICColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1_a + "," + ICColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (ICColumn2Data6_1.length() > 4) {
		String ICColumn2Data6_1_a = ICColumn2Data6_1.substring(0, ICColumn2Data6_1.length() - 4);
		String ICColumn2Data6_1_b = ICColumn2Data6_1.substring(ICColumn2Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_a + "," + ICColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1);}
		//Validating the Data Format of Column3Data6  
		if (ICColumn3Data6_1.length() > 4) {
		String ICColumn3Data6_1_a = ICColumn3Data6_1.substring(0, ICColumn3Data6_1.length() - 4);
		String ICColumn3Data6_1_b = ICColumn3Data6_1.substring(ICColumn3Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1_a + "," + ICColumn3Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1);}
		//Validating the Data Format of Column4Data6  
		if (ICColumn4Data6_1_1.length() > 4) {
		String ICColumn4Data6_1_a = ICColumn4Data6_1_1.substring(0, ICColumn4Data6_1_1.length() - 4);
		String ICColumn4Data6_1_b = ICColumn4Data6_1_1.substring(ICColumn4Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data6.verifyText(ICColumn4Data6_1_a + "," + ICColumn4Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data6.verifyText(ICColumn4Data6_1_1);}
		
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String ICColumn1Data7_1 = VIPFinancialsPage.contents.ICColumn1Data7.getText();
		String ICColumn2Data7_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		String ICColumn3Data7_1 = VIPFinancialsPage.contents.ICColumn3Data7.getText();
		String ICColumn4Data7_1_1 = VIPFinancialsPage.contents.ICColumn4Data7.getText();
		if (ICColumn1Data7_1.contains("-") | ICColumn2Data7_1.contains("-") | ICColumn3Data7_1.contains("-") | ICColumn4Data7_1_1.contains("-") |
		ICColumn1Data7_1.equals("0") | ICColumn4Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data7.verifyText("N/M");}
		else {
		String ICColumn1Data7_2 = ICColumn1Data7_1.replace(",", "");
		double ICColumn1Data7 = Double.parseDouble(ICColumn1Data7_2);
		//Ending Data7
		String ICColumn4Data7_1 = VIPFinancialsPage.contents.ICColumn4Data7.getText();
		String ICColumn4Data7_2 = ICColumn4Data7_1.replace(",", "");
		double ICColumn4Data7 = Double.parseDouble(ICColumn4Data7_2);
		double Base1 = ICColumn4Data7/ICColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (ICColumn1Data7_1.length() > 4) {
		String ICColumn1Data7_1_a = ICColumn1Data7_1.substring(0, ICColumn1Data7_1.length() - 4);
		String ICColumn1Data7_1_b = ICColumn1Data7_1.substring(ICColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1_a + "," + ICColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (ICColumn2Data7_1.length() > 4) {
		String ICColumn2Data7_1_a = ICColumn2Data7_1.substring(0, ICColumn2Data7_1.length() - 4);
		String ICColumn2Data7_1_b = ICColumn2Data7_1.substring(ICColumn2Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_a + "," + ICColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1);}
		//Validating the Data Format of Column3Data7  
		if (ICColumn3Data7_1.length() > 4) {
		String ICColumn3Data7_1_a = ICColumn3Data7_1.substring(0, ICColumn3Data7_1.length() - 4);
		String ICColumn3Data7_1_b = ICColumn3Data7_1.substring(ICColumn3Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1_a + "," + ICColumn3Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1);}
		//Validating the Data Format of Column4Data7  
		if (ICColumn4Data7_1_1.length() > 4) {
		String ICColumn4Data7_1_a = ICColumn4Data7_1_1.substring(0, ICColumn4Data7_1_1.length() - 4);
		String ICColumn4Data7_1_b = ICColumn4Data7_1_1.substring(ICColumn4Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data7.verifyText(ICColumn4Data7_1_a + "," + ICColumn4Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data7.verifyText(ICColumn4Data7_1_1);}
		
		//*******************************   CAGR8   *************************************
		//Beginning Data8
		String ICColumn1Data8_1 = VIPFinancialsPage.contents.ICColumn1Data8.getText();
		String ICColumn2Data8_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		String ICColumn3Data8_1 = VIPFinancialsPage.contents.ICColumn3Data8.getText();
		String ICColumn4Data8_1_1 = VIPFinancialsPage.contents.ICColumn4Data8.getText();
		if (ICColumn1Data8_1.contains("-") | ICColumn2Data8_1.contains("-") | ICColumn3Data8_1.contains("-") | ICColumn4Data8_1_1.contains("-") |
		ICColumn1Data8_1.equals("0") | ICColumn4Data8_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data8.verifyText("N/M");}
		else {
		String ICColumn1Data8_2 = ICColumn1Data8_1.replace(",", "");
		double ICColumn1Data8 = Double.parseDouble(ICColumn1Data8_2);
		//Ending Data8
		String ICColumn4Data8_1 = VIPFinancialsPage.contents.ICColumn4Data8.getText();
		String ICColumn4Data8_2 = ICColumn4Data8_1.replace(",", "");
		double ICColumn4Data8 = Double.parseDouble(ICColumn4Data8_2);
		double Base1 = ICColumn4Data8/ICColumn1Data8;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data8.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data8  
		if (ICColumn1Data8_1.length() > 4) {
		String ICColumn1Data8_1_a = ICColumn1Data8_1.substring(0, ICColumn1Data8_1.length() - 4);
		String ICColumn1Data8_1_b = ICColumn1Data8_1.substring(ICColumn1Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1_a + "," + ICColumn1Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1);}
		//Validating the Data Format of Column2Data8  
		if (ICColumn2Data8_1.length() > 4) {
		String ICColumn2Data8_1_a = ICColumn2Data8_1.substring(0, ICColumn2Data8_1.length() - 4);
		String ICColumn2Data8_1_b = ICColumn2Data8_1.substring(ICColumn2Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_a + "," + ICColumn2Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1);}
		//Validating the Data Format of Column3Data8  
		if (ICColumn3Data8_1.length() > 4) {
		String ICColumn3Data8_1_a = ICColumn3Data8_1.substring(0, ICColumn3Data8_1.length() - 4);
		String ICColumn3Data8_1_b = ICColumn3Data8_1.substring(ICColumn3Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1_a + "," + ICColumn3Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1);}
		//Validating the Data Format of Column4Data8  
		if (ICColumn4Data8_1_1.length() > 4) {
		String ICColumn4Data8_1_a = ICColumn4Data8_1_1.substring(0, ICColumn4Data8_1_1.length() - 4);
		String ICColumn4Data8_1_b = ICColumn4Data8_1_1.substring(ICColumn4Data8_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data8.verifyText(ICColumn4Data8_1_a + "," + ICColumn4Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data8.verifyText(ICColumn4Data8_1_1);}
		
		//*******************************   CAGR9   *************************************
		//Beginning Data9
		String ICColumn1Data9_1 = VIPFinancialsPage.contents.ICColumn1Data9.getText();
		String ICColumn2Data9_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		String ICColumn3Data9_1 = VIPFinancialsPage.contents.ICColumn3Data9.getText();
		String ICColumn4Data9_1_1 = VIPFinancialsPage.contents.ICColumn4Data9.getText();
		if (ICColumn1Data9_1.contains("-") | ICColumn2Data9_1.contains("-") | ICColumn3Data9_1.contains("-") | ICColumn4Data9_1_1.contains("-") |
		ICColumn1Data9_1.equals("0") | ICColumn4Data9_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data9.verifyText("N/M");}
		else {
		String ICColumn1Data9_2 = ICColumn1Data9_1.replace(",", "");
		double ICColumn1Data9 = Double.parseDouble(ICColumn1Data9_2);
		//Ending Data9
		String ICColumn4Data9_1 = VIPFinancialsPage.contents.ICColumn4Data9.getText();
		String ICColumn4Data9_2 = ICColumn4Data9_1.replace(",", "");
		double ICColumn4Data9 = Double.parseDouble(ICColumn4Data9_2);
		double Base1 = ICColumn4Data9/ICColumn1Data9;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data9.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data9  
		if (ICColumn1Data9_1.length() > 4) {
		String ICColumn1Data9_1_a = ICColumn1Data9_1.substring(0, ICColumn1Data9_1.length() - 4);
		String ICColumn1Data9_1_b = ICColumn1Data9_1.substring(ICColumn1Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1_a + "," + ICColumn1Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1);}
		//Validating the Data Format of Column2Data9  
		if (ICColumn2Data9_1.length() > 4) {
		String ICColumn2Data9_1_a = ICColumn2Data9_1.substring(0, ICColumn2Data9_1.length() - 4);
		String ICColumn2Data9_1_b = ICColumn2Data9_1.substring(ICColumn2Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_a + "," + ICColumn2Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1);}
		//Validating the Data Format of Column3Data9  
		if (ICColumn3Data9_1.length() > 4) {
		String ICColumn3Data9_1_a = ICColumn3Data9_1.substring(0, ICColumn3Data9_1.length() - 4);
		String ICColumn3Data9_1_b = ICColumn3Data9_1.substring(ICColumn3Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1_a + "," + ICColumn3Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1);}
		//Validating the Data Format of Column4Data9  
		if (ICColumn4Data9_1_1.length() > 4) {
		String ICColumn4Data9_1_a = ICColumn4Data9_1_1.substring(0, ICColumn4Data9_1_1.length() - 4);
		String ICColumn4Data9_1_b = ICColumn4Data9_1_1.substring(ICColumn4Data9_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data9.verifyText(ICColumn4Data9_1_a + "," + ICColumn4Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data9.verifyText(ICColumn4Data9_1_1);}
		
		//*******************************   CAGR10   *************************************
		//Beginning Data10
		String ICColumn1Data10_1 = VIPFinancialsPage.contents.ICColumn1Data10.getText();
		String ICColumn2Data10_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		String ICColumn3Data10_1 = VIPFinancialsPage.contents.ICColumn3Data10.getText();
		String ICColumn4Data10_1_1 = VIPFinancialsPage.contents.ICColumn4Data10.getText();
		if (ICColumn1Data10_1.contains("-") | ICColumn2Data10_1.contains("-") | ICColumn3Data10_1.contains("-") | ICColumn4Data10_1_1.contains("-") |
		ICColumn1Data10_1.equals("0") | ICColumn4Data10_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn5Data10.verifyText("N/M");}
		else {
		String ICColumn1Data10_2 = ICColumn1Data10_1.replace(",", "");
		double ICColumn1Data10 = Double.parseDouble(ICColumn1Data10_2);
		//Ending Data10
		String ICColumn4Data10_1 = VIPFinancialsPage.contents.ICColumn4Data10.getText();
		String ICColumn4Data10_2 = ICColumn4Data10_1.replace(",", "");
		double ICColumn4Data10 = Double.parseDouble(ICColumn4Data10_2);
		double Base1 = ICColumn4Data10/ICColumn1Data10;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn5Data10.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data10  
		if (ICColumn1Data10_1.length() > 4) {
		String ICColumn1Data10_1_a = ICColumn1Data10_1.substring(0, ICColumn1Data10_1.length() - 4);
		String ICColumn1Data10_1_b = ICColumn1Data10_1.substring(ICColumn1Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1_a + "," + ICColumn1Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1);}
		//Validating the Data Format of Column2Data10  
		if (ICColumn2Data10_1.length() > 4) {
		String ICColumn2Data10_1_a = ICColumn2Data10_1.substring(0, ICColumn2Data10_1.length() - 4);
		String ICColumn2Data10_1_b = ICColumn2Data10_1.substring(ICColumn2Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_a + "," + ICColumn2Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1);}
		//Validating the Data Format of Column3Data10  
		if (ICColumn3Data10_1.length() > 4) {
		String ICColumn3Data10_1_a = ICColumn3Data10_1.substring(0, ICColumn3Data10_1.length() - 4);
		String ICColumn3Data10_1_b = ICColumn3Data10_1.substring(ICColumn3Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1_a + "," + ICColumn3Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1);}
		//Validating the Data Format of Column4Data10  
		if (ICColumn4Data10_1_1.length() > 4) {
		String ICColumn4Data10_1_a = ICColumn4Data10_1_1.substring(0, ICColumn4Data10_1_1.length() - 4);
		String ICColumn4Data10_1_b = ICColumn4Data10_1_1.substring(ICColumn4Data10_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn4Data10.verifyText(ICColumn4Data10_1_a + "," + ICColumn4Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn4Data10.verifyText(ICColumn4Data10_1_1);}
		
		}
		
		//************************   Period 1 to 3 is available   *****************************
		else if (!VIPFinancialsPage.contents.ICColumnHeader5.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed()) {
		//Getting the Exponent
		String ICColumnHeader1 = VIPFinancialsPage.contents.ICColumnHeader1.getText();
		String[] ICColumnHeader1_1 = ICColumnHeader1.split("\\-");
		String ICColumnHeader1_2 = ICColumnHeader1_1[1];
		String ICColumnHeader2 = VIPFinancialsPage.contents.ICColumnHeader3.getText();
		String[] ICColumnHeader2_1 = ICColumnHeader2.split("\\-");
		String ICColumnHeader2_2 = ICColumnHeader2_1[1];
		String Date1 = "01/" + ICColumnHeader1_2;
		String Date2 = "01/" + ICColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String ICColumn1Data1_1 = VIPFinancialsPage.contents.ICColumn1Data1.getText();
		String ICColumn2Data1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		String ICColumn3Data1_1_1 = VIPFinancialsPage.contents.ICColumn3Data1.getText();
		if (ICColumn1Data1_1.contains("-") | ICColumn2Data1_1.contains("-") | ICColumn3Data1_1_1.contains("-") |
		ICColumn1Data1_1.equals("0") | ICColumn3Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data1.verifyText("N/M");}
		else {
		String ICColumn1Data1_2 = ICColumn1Data1_1.replace(",", "");
		double ICColumn1Data1 = Double.parseDouble(ICColumn1Data1_2);
		//Ending Data1
		String ICColumn3Data1_1 = VIPFinancialsPage.contents.ICColumn3Data1.getText();
		String ICColumn3Data1_2 = ICColumn3Data1_1.replace(",", "");
		double ICColumn3Data1 = Double.parseDouble(ICColumn3Data1_2);
		double Base1 = ICColumn3Data1/ICColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (ICColumn1Data1_1.length() > 4) {
		String ICColumn1Data1_1_a = ICColumn1Data1_1.substring(0, ICColumn1Data1_1.length() - 4);
		String ICColumn1Data1_1_b = ICColumn1Data1_1.substring(ICColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1_a + "," + ICColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (ICColumn2Data1_1.length() > 4) {
		String ICColumn2Data1_1_a = ICColumn2Data1_1.substring(0, ICColumn2Data1_1.length() - 4);
		String ICColumn2Data1_1_b = ICColumn2Data1_1.substring(ICColumn2Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_a + "," + ICColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1);}
		//Validating the Data Format of Column3Data1  
		if (ICColumn3Data1_1_1.length() > 4) {
		String ICColumn3Data1_1_a = ICColumn3Data1_1_1.substring(0, ICColumn3Data1_1_1.length() - 4);
		String ICColumn3Data1_1_b = ICColumn3Data1_1_1.substring(ICColumn3Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1_a + "," + ICColumn3Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data1.verifyText(ICColumn3Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String ICColumn1Data2_1 = VIPFinancialsPage.contents.ICColumn1Data2.getText();
		String ICColumn2Data2_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		String ICColumn3Data2_1_1 = VIPFinancialsPage.contents.ICColumn3Data2.getText();
		if (ICColumn1Data2_1.contains("-") | ICColumn2Data2_1.contains("-") | ICColumn3Data2_1_1.contains("-") |
		ICColumn1Data2_1.equals("0") | ICColumn3Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data2.verifyText("N/M");}
		else {
		String ICColumn1Data2_2 = ICColumn1Data2_1.replace(",", "");
		double ICColumn1Data2 = Double.parseDouble(ICColumn1Data2_2);
		//Ending Data2
		String ICColumn3Data2_1 = VIPFinancialsPage.contents.ICColumn3Data2.getText();
		String ICColumn3Data2_2 = ICColumn3Data2_1.replace(",", "");
		double ICColumn3Data2 = Double.parseDouble(ICColumn3Data2_2);
		double Base1 = ICColumn3Data2/ICColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (ICColumn1Data2_1.length() > 4) {
		String ICColumn1Data2_1_a = ICColumn1Data2_1.substring(0, ICColumn1Data2_1.length() - 4);
		String ICColumn1Data2_1_b = ICColumn1Data2_1.substring(ICColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1_a + "," + ICColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (ICColumn2Data2_1.length() > 4) {
		String ICColumn2Data2_1_a = ICColumn2Data2_1.substring(0, ICColumn2Data2_1.length() - 4);
		String ICColumn2Data2_1_b = ICColumn2Data2_1.substring(ICColumn2Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_a + "," + ICColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1);}
		//Validating the Data Format of Column3Data2  
		if (ICColumn3Data2_1_1.length() > 4) {
		String ICColumn3Data2_1_a = ICColumn3Data2_1_1.substring(0, ICColumn3Data2_1_1.length() - 4);
		String ICColumn3Data2_1_b = ICColumn3Data2_1_1.substring(ICColumn3Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1_a + "," + ICColumn3Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data2.verifyText(ICColumn3Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String ICColumn1Data3_1 = VIPFinancialsPage.contents.ICColumn1Data3.getText();
		String ICColumn2Data3_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		String ICColumn3Data3_1_1 = VIPFinancialsPage.contents.ICColumn3Data3.getText();
		if (ICColumn1Data3_1.contains("-") | ICColumn2Data3_1.contains("-") | ICColumn3Data3_1_1.contains("-") |
		ICColumn1Data3_1.equals("0") | ICColumn3Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data3.verifyText("N/M");}
		else {
		String ICColumn1Data3_2 = ICColumn1Data3_1.replace(",", "");
		double ICColumn1Data3 = Double.parseDouble(ICColumn1Data3_2);
		//Ending Data3
		String ICColumn3Data3_1 = VIPFinancialsPage.contents.ICColumn3Data3.getText();
		String ICColumn3Data3_2 = ICColumn3Data3_1.replace(",", "");
		double ICColumn3Data3 = Double.parseDouble(ICColumn3Data3_2);
		double Base1 = ICColumn3Data3/ICColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (ICColumn1Data3_1.length() > 4) {
		String ICColumn1Data3_1_a = ICColumn1Data3_1.substring(0, ICColumn1Data3_1.length() - 4);
		String ICColumn1Data3_1_b = ICColumn1Data3_1.substring(ICColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1_a + "," + ICColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (ICColumn2Data3_1.length() > 4) {
		String ICColumn2Data3_1_a = ICColumn2Data3_1.substring(0, ICColumn2Data3_1.length() - 4);
		String ICColumn2Data3_1_b = ICColumn2Data3_1.substring(ICColumn2Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_a + "," + ICColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1);}
		//Validating the Data Format of Column3Data3  
		if (ICColumn3Data3_1_1.length() > 4) {
		String ICColumn3Data3_1_a = ICColumn3Data3_1_1.substring(0, ICColumn3Data3_1_1.length() - 4);
		String ICColumn3Data3_1_b = ICColumn3Data3_1_1.substring(ICColumn3Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1_a + "," + ICColumn3Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data3.verifyText(ICColumn3Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String ICColumn1Data4_1 = VIPFinancialsPage.contents.ICColumn1Data4.getText();
		String ICColumn2Data4_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		String ICColumn3Data4_1_1 = VIPFinancialsPage.contents.ICColumn3Data4.getText();
		if (ICColumn1Data4_1.contains("-") | ICColumn2Data4_1.contains("-") | ICColumn3Data4_1_1.contains("-") |
		ICColumn1Data4_1.equals("0") | ICColumn3Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data4.verifyText("N/M");}
		else {
		String ICColumn1Data4_2 = ICColumn1Data4_1.replace(",", "");
		double ICColumn1Data4 = Double.parseDouble(ICColumn1Data4_2);
		//Ending Data4
		String ICColumn3Data4_1 = VIPFinancialsPage.contents.ICColumn3Data4.getText();
		String ICColumn3Data4_2 = ICColumn3Data4_1.replace(",", "");
		double ICColumn3Data4 = Double.parseDouble(ICColumn3Data4_2);
		double Base1 = ICColumn3Data4/ICColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (ICColumn1Data4_1.length() > 4) {
		String ICColumn1Data4_1_a = ICColumn1Data4_1.substring(0, ICColumn1Data4_1.length() - 4);
		String ICColumn1Data4_1_b = ICColumn1Data4_1.substring(ICColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1_a + "," + ICColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (ICColumn2Data4_1.length() > 4) {
		String ICColumn2Data4_1_a = ICColumn2Data4_1.substring(0, ICColumn2Data4_1.length() - 4);
		String ICColumn2Data4_1_b = ICColumn2Data4_1.substring(ICColumn2Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_a + "," + ICColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1);}
		//Validating the Data Format of Column3Data4  
		if (ICColumn3Data4_1_1.length() > 4) {
		String ICColumn3Data4_1_a = ICColumn3Data4_1_1.substring(0, ICColumn3Data4_1_1.length() - 4);
		String ICColumn3Data4_1_b = ICColumn3Data4_1_1.substring(ICColumn3Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1_a + "," + ICColumn3Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data4.verifyText(ICColumn3Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String ICColumn1Data5_1 = VIPFinancialsPage.contents.ICColumn1Data5.getText();
		String ICColumn2Data5_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		String ICColumn3Data5_1_1 = VIPFinancialsPage.contents.ICColumn3Data5.getText();
		if (ICColumn1Data5_1.contains("-") | ICColumn2Data5_1.contains("-") | ICColumn3Data5_1_1.contains("-") |
		ICColumn1Data5_1.equals("0") | ICColumn3Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data5.verifyText("N/M");}
		else {
		String ICColumn1Data5_2 = ICColumn1Data5_1.replace(",", "");
		double ICColumn1Data5 = Double.parseDouble(ICColumn1Data5_2);
		//Ending Data5
		String ICColumn3Data5_1 = VIPFinancialsPage.contents.ICColumn3Data5.getText();
		String ICColumn3Data5_2 = ICColumn3Data5_1.replace(",", "");
		double ICColumn3Data5 = Double.parseDouble(ICColumn3Data5_2);
		double Base1 = ICColumn3Data5/ICColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (ICColumn1Data5_1.length() > 4) {
		String ICColumn1Data5_1_a = ICColumn1Data5_1.substring(0, ICColumn1Data5_1.length() - 4);
		String ICColumn1Data5_1_b = ICColumn1Data5_1.substring(ICColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1_a + "," + ICColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (ICColumn2Data5_1.length() > 4) {
		String ICColumn2Data5_1_a = ICColumn2Data5_1.substring(0, ICColumn2Data5_1.length() - 4);
		String ICColumn2Data5_1_b = ICColumn2Data5_1.substring(ICColumn2Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_a + "," + ICColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1);}
		//Validating the Data Format of Column3Data5  
		if (ICColumn3Data5_1_1.length() > 4) {
		String ICColumn3Data5_1_a = ICColumn3Data5_1_1.substring(0, ICColumn3Data5_1_1.length() - 4);
		String ICColumn3Data5_1_b = ICColumn3Data5_1_1.substring(ICColumn3Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1_a + "," + ICColumn3Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data5.verifyText(ICColumn3Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String ICColumn1Data6_1 = VIPFinancialsPage.contents.ICColumn1Data6.getText();
		String ICColumn2Data6_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		String ICColumn3Data6_1_1 = VIPFinancialsPage.contents.ICColumn3Data6.getText();
		if (ICColumn1Data6_1.contains("-") | ICColumn2Data6_1.contains("-") | ICColumn3Data6_1_1.contains("-") |
		ICColumn1Data6_1.equals("0") | ICColumn3Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data6.verifyText("N/M");}
		else {
		String ICColumn1Data6_2 = ICColumn1Data6_1.replace(",", "");
		double ICColumn1Data6 = Double.parseDouble(ICColumn1Data6_2);
		//Ending Data6
		String ICColumn3Data6_1 = VIPFinancialsPage.contents.ICColumn3Data6.getText();
		String ICColumn3Data6_2 = ICColumn3Data6_1.replace(",", "");
		double ICColumn3Data6 = Double.parseDouble(ICColumn3Data6_2);
		double Base1 = ICColumn3Data6/ICColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (ICColumn1Data6_1.length() > 4) {
		String ICColumn1Data6_1_a = ICColumn1Data6_1.substring(0, ICColumn1Data6_1.length() - 4);
		String ICColumn1Data6_1_b = ICColumn1Data6_1.substring(ICColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1_a + "," + ICColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (ICColumn2Data6_1.length() > 4) {
		String ICColumn2Data6_1_a = ICColumn2Data6_1.substring(0, ICColumn2Data6_1.length() - 4);
		String ICColumn2Data6_1_b = ICColumn2Data6_1.substring(ICColumn2Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_a + "," + ICColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1);}
		//Validating the Data Format of Column3Data6  
		if (ICColumn3Data6_1_1.length() > 4) {
		String ICColumn3Data6_1_a = ICColumn3Data6_1_1.substring(0, ICColumn3Data6_1_1.length() - 4);
		String ICColumn3Data6_1_b = ICColumn3Data6_1_1.substring(ICColumn3Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1_a + "," + ICColumn3Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data6.verifyText(ICColumn3Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String ICColumn1Data7_1 = VIPFinancialsPage.contents.ICColumn1Data7.getText();
		String ICColumn2Data7_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		String ICColumn3Data7_1_1 = VIPFinancialsPage.contents.ICColumn3Data7.getText();
		if (ICColumn1Data7_1.contains("-") | ICColumn2Data7_1.contains("-") | ICColumn3Data7_1_1.contains("-") |
		ICColumn1Data7_1.equals("0") | ICColumn3Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data7.verifyText("N/M");}
		else {
		String ICColumn1Data7_2 = ICColumn1Data7_1.replace(",", "");
		double ICColumn1Data7 = Double.parseDouble(ICColumn1Data7_2);
		//Ending Data7
		String ICColumn3Data7_1 = VIPFinancialsPage.contents.ICColumn3Data7.getText();
		String ICColumn3Data7_2 = ICColumn3Data7_1.replace(",", "");
		double ICColumn3Data7 = Double.parseDouble(ICColumn3Data7_2);
		double Base1 = ICColumn3Data7/ICColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (ICColumn1Data7_1.length() > 4) {
		String ICColumn1Data7_1_a = ICColumn1Data7_1.substring(0, ICColumn1Data7_1.length() - 4);
		String ICColumn1Data7_1_b = ICColumn1Data7_1.substring(ICColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1_a + "," + ICColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (ICColumn2Data7_1.length() > 4) {
		String ICColumn2Data7_1_a = ICColumn2Data7_1.substring(0, ICColumn2Data7_1.length() - 4);
		String ICColumn2Data7_1_b = ICColumn2Data7_1.substring(ICColumn2Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_a + "," + ICColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1);}
		//Validating the Data Format of Column3Data7  
		if (ICColumn3Data7_1_1.length() > 4) {
		String ICColumn3Data7_1_a = ICColumn3Data7_1_1.substring(0, ICColumn3Data7_1_1.length() - 4);
		String ICColumn3Data7_1_b = ICColumn3Data7_1_1.substring(ICColumn3Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1_a + "," + ICColumn3Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data7.verifyText(ICColumn3Data7_1_1);}
		
		//*******************************   CAGR8   *************************************
		//Beginning Data8
		String ICColumn1Data8_1 = VIPFinancialsPage.contents.ICColumn1Data8.getText();
		String ICColumn2Data8_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		String ICColumn3Data8_1_1 = VIPFinancialsPage.contents.ICColumn3Data8.getText();
		if (ICColumn1Data8_1.contains("-") | ICColumn2Data8_1.contains("-") | ICColumn3Data8_1_1.contains("-") |
		ICColumn1Data8_1.equals("0") | ICColumn3Data8_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data8.verifyText("N/M");}
		else {
		String ICColumn1Data8_2 = ICColumn1Data8_1.replace(",", "");
		double ICColumn1Data8 = Double.parseDouble(ICColumn1Data8_2);
		//Ending Data8
		String ICColumn3Data8_1 = VIPFinancialsPage.contents.ICColumn3Data8.getText();
		String ICColumn3Data8_2 = ICColumn3Data8_1.replace(",", "");
		double ICColumn3Data8 = Double.parseDouble(ICColumn3Data8_2);
		double Base1 = ICColumn3Data8/ICColumn1Data8;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data8.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data8  
		if (ICColumn1Data8_1.length() > 4) {
		String ICColumn1Data8_1_a = ICColumn1Data8_1.substring(0, ICColumn1Data8_1.length() - 4);
		String ICColumn1Data8_1_b = ICColumn1Data8_1.substring(ICColumn1Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1_a + "," + ICColumn1Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1);}
		//Validating the Data Format of Column2Data8  
		if (ICColumn2Data8_1.length() > 4) {
		String ICColumn2Data8_1_a = ICColumn2Data8_1.substring(0, ICColumn2Data8_1.length() - 4);
		String ICColumn2Data8_1_b = ICColumn2Data8_1.substring(ICColumn2Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_a + "," + ICColumn2Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1);}
		//Validating the Data Format of Column3Data8  
		if (ICColumn3Data8_1_1.length() > 4) {
		String ICColumn3Data8_1_a = ICColumn3Data8_1_1.substring(0, ICColumn3Data8_1_1.length() - 4);
		String ICColumn3Data8_1_b = ICColumn3Data8_1_1.substring(ICColumn3Data8_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1_a + "," + ICColumn3Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data8.verifyText(ICColumn3Data8_1_1);}
		
		//*******************************   CAGR9   *************************************
		//Beginning Data9
		String ICColumn1Data9_1 = VIPFinancialsPage.contents.ICColumn1Data9.getText();
		String ICColumn2Data9_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		String ICColumn3Data9_1_1 = VIPFinancialsPage.contents.ICColumn3Data9.getText();
		if (ICColumn1Data9_1.contains("-") | ICColumn2Data9_1.contains("-") | ICColumn3Data9_1_1.contains("-") |
		ICColumn1Data9_1.equals("0") | ICColumn3Data9_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data9.verifyText("N/M");}
		else {
		String ICColumn1Data9_2 = ICColumn1Data9_1.replace(",", "");
		double ICColumn1Data9 = Double.parseDouble(ICColumn1Data9_2);
		//Ending Data9
		String ICColumn3Data9_1 = VIPFinancialsPage.contents.ICColumn3Data9.getText();
		String ICColumn3Data9_2 = ICColumn3Data9_1.replace(",", "");
		double ICColumn3Data9 = Double.parseDouble(ICColumn3Data9_2);
		double Base1 = ICColumn3Data9/ICColumn1Data9;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data9.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data9  
		if (ICColumn1Data9_1.length() > 4) {
		String ICColumn1Data9_1_a = ICColumn1Data9_1.substring(0, ICColumn1Data9_1.length() - 4);
		String ICColumn1Data9_1_b = ICColumn1Data9_1.substring(ICColumn1Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1_a + "," + ICColumn1Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1);}
		//Validating the Data Format of Column2Data9  
		if (ICColumn2Data9_1.length() > 4) {
		String ICColumn2Data9_1_a = ICColumn2Data9_1.substring(0, ICColumn2Data9_1.length() - 4);
		String ICColumn2Data9_1_b = ICColumn2Data9_1.substring(ICColumn2Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_a + "," + ICColumn2Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1);}
		//Validating the Data Format of Column3Data9  
		if (ICColumn3Data9_1_1.length() > 4) {
		String ICColumn3Data9_1_a = ICColumn3Data9_1_1.substring(0, ICColumn3Data9_1_1.length() - 4);
		String ICColumn3Data9_1_b = ICColumn3Data9_1_1.substring(ICColumn3Data9_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1_a + "," + ICColumn3Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data9.verifyText(ICColumn3Data9_1_1);}
		
		//*******************************   CAGR10   *************************************
		//Beginning Data10
		String ICColumn1Data10_1 = VIPFinancialsPage.contents.ICColumn1Data10.getText();
		String ICColumn2Data10_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		String ICColumn3Data10_1_1 = VIPFinancialsPage.contents.ICColumn3Data10.getText();
		if (ICColumn1Data10_1.contains("-") | ICColumn2Data10_1.contains("-") | ICColumn3Data10_1_1.contains("-") |
		ICColumn1Data10_1.equals("0") | ICColumn3Data10_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn4Data10.verifyText("N/M");}
		else {
		String ICColumn1Data10_2 = ICColumn1Data10_1.replace(",", "");
		double ICColumn1Data10 = Double.parseDouble(ICColumn1Data10_2);
		//Ending Data10
		String ICColumn3Data10_1 = VIPFinancialsPage.contents.ICColumn3Data10.getText();
		String ICColumn3Data10_2 = ICColumn3Data10_1.replace(",", "");
		double ICColumn3Data10 = Double.parseDouble(ICColumn3Data10_2);
		double Base1 = ICColumn3Data10/ICColumn1Data10;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn4Data10.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data10  
		if (ICColumn1Data10_1.length() > 4) {
		String ICColumn1Data10_1_a = ICColumn1Data10_1.substring(0, ICColumn1Data10_1.length() - 4);
		String ICColumn1Data10_1_b = ICColumn1Data10_1.substring(ICColumn1Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1_a + "," + ICColumn1Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1);}
		//Validating the Data Format of Column2Data10  
		if (ICColumn2Data10_1.length() > 4) {
		String ICColumn2Data10_1_a = ICColumn2Data10_1.substring(0, ICColumn2Data10_1.length() - 4);
		String ICColumn2Data10_1_b = ICColumn2Data10_1.substring(ICColumn2Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_a + "," + ICColumn2Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1);}
		//Validating the Data Format of Column3Data10  
		if (ICColumn3Data10_1_1.length() > 4) {
		String ICColumn3Data10_1_a = ICColumn3Data10_1_1.substring(0, ICColumn3Data10_1_1.length() - 4);
		String ICColumn3Data10_1_b = ICColumn3Data10_1_1.substring(ICColumn3Data10_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1_a + "," + ICColumn3Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn3Data10.verifyText(ICColumn3Data10_1_1);}}
		
		//************************   Period 1 to 2 is available   ******************************
		else if (!VIPFinancialsPage.contents.ICColumnHeader4.isDisplayed() & VIPFinancialsPage.contents.ICColumnHeader3.isDisplayed()) {
		//Getting the Exponent
		String ICColumnHeader1 = VIPFinancialsPage.contents.ICColumnHeader1.getText();
		String[] ICColumnHeader1_1 = ICColumnHeader1.split("\\-");
		String ICColumnHeader1_2 = ICColumnHeader1_1[1];
		String ICColumnHeader2 = VIPFinancialsPage.contents.ICColumnHeader2.getText();
		String[] ICColumnHeader2_1 = ICColumnHeader2.split("\\-");
		String ICColumnHeader2_2 = ICColumnHeader2_1[1];
		String Date1 = "01/" + ICColumnHeader1_2;
		String Date2 = "01/" + ICColumnHeader2_2;	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		long monthsBetween = ChronoUnit.MONTHS.between(
		LocalDate.parse(Date1, formatter).withDayOfMonth(1),
		LocalDate.parse(Date2, formatter).withDayOfMonth(1));
		double monthsBetween2 = Math.toIntExact(monthsBetween);
		double Exponent1 = 12/monthsBetween2;
		//*******************************   CAGR1   *************************************
		//Beginning Data1
		String ICColumn1Data1_1 = VIPFinancialsPage.contents.ICColumn1Data1.getText();
		String ICColumn2Data1_1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		if (ICColumn1Data1_1.contains("-") | ICColumn2Data1_1_1.contains("-") |
		ICColumn1Data1_1.equals("0") | ICColumn2Data1_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText("N/M");}
		else {
		String ICColumn1Data1_2 = ICColumn1Data1_1.replace(",", "");
		double ICColumn1Data1 = Double.parseDouble(ICColumn1Data1_2);
		//Ending Data1
		String ICColumn2Data1_1 = VIPFinancialsPage.contents.ICColumn2Data1.getText();
		String ICColumn2Data1_2 = ICColumn2Data1_1.replace(",", "");
		double ICColumn2Data1 = Double.parseDouble(ICColumn2Data1_2);
		double Base1 = ICColumn2Data1/ICColumn1Data1;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data1.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data1  
		if (ICColumn1Data1_1.length() > 4) {
		String ICColumn1Data1_1_a = ICColumn1Data1_1.substring(0, ICColumn1Data1_1.length() - 4);
		String ICColumn1Data1_1_b = ICColumn1Data1_1.substring(ICColumn1Data1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1_a + "," + ICColumn1Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data1.verifyText(ICColumn1Data1_1);}
		//Validating the Data Format of Column2Data1  
		if (ICColumn2Data1_1_1.length() > 4) {
		String ICColumn2Data1_1_a = ICColumn2Data1_1_1.substring(0, ICColumn2Data1_1_1.length() - 4);
		String ICColumn2Data1_1_b = ICColumn2Data1_1_1.substring(ICColumn2Data1_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_a + "," + ICColumn2Data1_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data1.verifyText(ICColumn2Data1_1_1);}
		//*******************************   CAGR2   *************************************
		//Beginning Data2
		String ICColumn1Data2_1 = VIPFinancialsPage.contents.ICColumn1Data2.getText();
		String ICColumn2Data2_1_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		if (ICColumn1Data2_1.contains("-") | ICColumn2Data2_1_1.contains("-") |
		ICColumn1Data2_1.equals("0") | ICColumn2Data2_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText("N/M");}
		else {
		String ICColumn1Data2_2 = ICColumn1Data2_1.replace(",", "");
		double ICColumn1Data2 = Double.parseDouble(ICColumn1Data2_2);
		//Ending Data2
		String ICColumn2Data2_1 = VIPFinancialsPage.contents.ICColumn2Data2.getText();
		String ICColumn2Data2_2 = ICColumn2Data2_1.replace(",", "");
		double ICColumn2Data2 = Double.parseDouble(ICColumn2Data2_2);
		double Base1 = ICColumn2Data2/ICColumn1Data2;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data2.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data2  
		if (ICColumn1Data2_1.length() > 4) {
		String ICColumn1Data2_1_a = ICColumn1Data2_1.substring(0, ICColumn1Data2_1.length() - 4);
		String ICColumn1Data2_1_b = ICColumn1Data2_1.substring(ICColumn1Data2_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1_a + "," + ICColumn1Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data2.verifyText(ICColumn1Data2_1);}
		//Validating the Data Format of Column2Data2  
		if (ICColumn2Data2_1_1.length() > 4) {
		String ICColumn2Data2_1_a = ICColumn2Data2_1_1.substring(0, ICColumn2Data2_1_1.length() - 4);
		String ICColumn2Data2_1_b = ICColumn2Data2_1_1.substring(ICColumn2Data2_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_a + "," + ICColumn2Data2_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data2.verifyText(ICColumn2Data2_1_1);}
		//*******************************   CAGR3   *************************************
		//Beginning Data3
		String ICColumn1Data3_1 = VIPFinancialsPage.contents.ICColumn1Data3.getText();
		String ICColumn2Data3_1_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		if (ICColumn1Data3_1.contains("-") | ICColumn2Data3_1_1.contains("-") |
		ICColumn1Data3_1.equals("0") | ICColumn2Data3_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText("N/M");}
		else {
		String ICColumn1Data3_2 = ICColumn1Data3_1.replace(",", "");
		double ICColumn1Data3 = Double.parseDouble(ICColumn1Data3_2);
		//Ending Data3
		String ICColumn2Data3_1 = VIPFinancialsPage.contents.ICColumn2Data3.getText();
		String ICColumn2Data3_2 = ICColumn2Data3_1.replace(",", "");
		double ICColumn2Data3 = Double.parseDouble(ICColumn2Data3_2);
		double Base1 = ICColumn2Data3/ICColumn1Data3;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data3.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data3  
		if (ICColumn1Data3_1.length() > 4) {
		String ICColumn1Data3_1_a = ICColumn1Data3_1.substring(0, ICColumn1Data3_1.length() - 4);
		String ICColumn1Data3_1_b = ICColumn1Data3_1.substring(ICColumn1Data3_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1_a + "," + ICColumn1Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data3.verifyText(ICColumn1Data3_1);}
		//Validating the Data Format of Column2Data3  
		if (ICColumn2Data3_1_1.length() > 4) {
		String ICColumn2Data3_1_a = ICColumn2Data3_1_1.substring(0, ICColumn2Data3_1_1.length() - 4);
		String ICColumn2Data3_1_b = ICColumn2Data3_1_1.substring(ICColumn2Data3_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_a + "," + ICColumn2Data3_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data3.verifyText(ICColumn2Data3_1_1);}
		//*******************************   CAGR4   *************************************
		//Beginning Data4
		String ICColumn1Data4_1 = VIPFinancialsPage.contents.ICColumn1Data4.getText();
		String ICColumn2Data4_1_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		if (ICColumn1Data4_1.contains("-") | ICColumn2Data4_1_1.contains("-") |
		ICColumn1Data4_1.equals("0") | ICColumn2Data4_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText("N/M");}
		else {
		String ICColumn1Data4_2 = ICColumn1Data4_1.replace(",", "");
		double ICColumn1Data4 = Double.parseDouble(ICColumn1Data4_2);
		//Ending Data4
		String ICColumn2Data4_1 = VIPFinancialsPage.contents.ICColumn2Data4.getText();
		String ICColumn2Data4_2 = ICColumn2Data4_1.replace(",", "");
		double ICColumn2Data4 = Double.parseDouble(ICColumn2Data4_2);
		double Base1 = ICColumn2Data4/ICColumn1Data4;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data4.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data4  
		if (ICColumn1Data4_1.length() > 4) {
		String ICColumn1Data4_1_a = ICColumn1Data4_1.substring(0, ICColumn1Data4_1.length() - 4);
		String ICColumn1Data4_1_b = ICColumn1Data4_1.substring(ICColumn1Data4_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1_a + "," + ICColumn1Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data4.verifyText(ICColumn1Data4_1);}
		//Validating the Data Format of Column2Data4  
		if (ICColumn2Data4_1_1.length() > 4) {
		String ICColumn2Data4_1_a = ICColumn2Data4_1_1.substring(0, ICColumn2Data4_1_1.length() - 4);
		String ICColumn2Data4_1_b = ICColumn2Data4_1_1.substring(ICColumn2Data4_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_a + "," + ICColumn2Data4_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data4.verifyText(ICColumn2Data4_1_1);}
		//*******************************   CAGR5   *************************************
		//Beginning Data5
		String ICColumn1Data5_1 = VIPFinancialsPage.contents.ICColumn1Data5.getText();
		String ICColumn2Data5_1_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		if (ICColumn1Data5_1.contains("-") | ICColumn2Data5_1_1.contains("-") |
		ICColumn1Data5_1.equals("0") | ICColumn2Data5_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText("N/M");}
		else {
		String ICColumn1Data5_2 = ICColumn1Data5_1.replace(",", "");
		double ICColumn1Data5 = Double.parseDouble(ICColumn1Data5_2);
		//Ending Data5
		String ICColumn2Data5_1 = VIPFinancialsPage.contents.ICColumn2Data5.getText();
		String ICColumn2Data5_2 = ICColumn2Data5_1.replace(",", "");
		double ICColumn2Data5 = Double.parseDouble(ICColumn2Data5_2);
		double Base1 = ICColumn2Data5/ICColumn1Data5;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data5.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data5  
		if (ICColumn1Data5_1.length() > 4) {
		String ICColumn1Data5_1_a = ICColumn1Data5_1.substring(0, ICColumn1Data5_1.length() - 4);
		String ICColumn1Data5_1_b = ICColumn1Data5_1.substring(ICColumn1Data5_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1_a + "," + ICColumn1Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data5.verifyText(ICColumn1Data5_1);}
		//Validating the Data Format of Column2Data5  
		if (ICColumn2Data5_1_1.length() > 4) {
		String ICColumn2Data5_1_a = ICColumn2Data5_1_1.substring(0, ICColumn2Data5_1_1.length() - 4);
		String ICColumn2Data5_1_b = ICColumn2Data5_1_1.substring(ICColumn2Data5_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_a + "," + ICColumn2Data5_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data5.verifyText(ICColumn2Data5_1_1);}
		//*******************************   CAGR6   *************************************
		//Beginning Data6
		String ICColumn1Data6_1 = VIPFinancialsPage.contents.ICColumn1Data6.getText();
		String ICColumn2Data6_1_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		if (ICColumn1Data6_1.contains("-") | ICColumn2Data6_1_1.contains("-") |
		ICColumn1Data6_1.equals("0") | ICColumn2Data6_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText("N/M");}
		else {
		String ICColumn1Data6_2 = ICColumn1Data6_1.replace(",", "");
		double ICColumn1Data6 = Double.parseDouble(ICColumn1Data6_2);
		//Ending Data6
		String ICColumn2Data6_1 = VIPFinancialsPage.contents.ICColumn2Data6.getText();
		String ICColumn2Data6_2 = ICColumn2Data6_1.replace(",", "");
		double ICColumn2Data6 = Double.parseDouble(ICColumn2Data6_2);
		double Base1 = ICColumn2Data6/ICColumn1Data6;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data6.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data6  
		if (ICColumn1Data6_1.length() > 4) {
		String ICColumn1Data6_1_a = ICColumn1Data6_1.substring(0, ICColumn1Data6_1.length() - 4);
		String ICColumn1Data6_1_b = ICColumn1Data6_1.substring(ICColumn1Data6_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1_a + "," + ICColumn1Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data6.verifyText(ICColumn1Data6_1);}
		//Validating the Data Format of Column2Data6  
		if (ICColumn2Data6_1_1.length() > 4) {
		String ICColumn2Data6_1_a = ICColumn2Data6_1_1.substring(0, ICColumn2Data6_1_1.length() - 4);
		String ICColumn2Data6_1_b = ICColumn2Data6_1_1.substring(ICColumn2Data6_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_a + "," + ICColumn2Data6_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data6.verifyText(ICColumn2Data6_1_1);}
		//*******************************   CAGR7   *************************************
		//Beginning Data7
		String ICColumn1Data7_1 = VIPFinancialsPage.contents.ICColumn1Data7.getText();
		String ICColumn2Data7_1_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		if (ICColumn1Data7_1.contains("-") | ICColumn2Data7_1_1.contains("-") |
		ICColumn1Data7_1.equals("0") | ICColumn2Data7_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText("N/M");}
		else {
		String ICColumn1Data7_2 = ICColumn1Data7_1.replace(",", "");
		double ICColumn1Data7 = Double.parseDouble(ICColumn1Data7_2);
		//Ending Data7
		String ICColumn2Data7_1 = VIPFinancialsPage.contents.ICColumn2Data7.getText();
		String ICColumn2Data7_2 = ICColumn2Data7_1.replace(",", "");
		double ICColumn2Data7 = Double.parseDouble(ICColumn2Data7_2);
		double Base1 = ICColumn2Data7/ICColumn1Data7;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data7.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data7  
		if (ICColumn1Data7_1.length() > 4) {
		String ICColumn1Data7_1_a = ICColumn1Data7_1.substring(0, ICColumn1Data7_1.length() - 4);
		String ICColumn1Data7_1_b = ICColumn1Data7_1.substring(ICColumn1Data7_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1_a + "," + ICColumn1Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data7.verifyText(ICColumn1Data7_1);}
		//Validating the Data Format of Column2Data7  
		if (ICColumn2Data7_1_1.length() > 4) {
		String ICColumn2Data7_1_a = ICColumn2Data7_1_1.substring(0, ICColumn2Data7_1_1.length() - 4);
		String ICColumn2Data7_1_b = ICColumn2Data7_1_1.substring(ICColumn2Data7_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_a + "," + ICColumn2Data7_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data7.verifyText(ICColumn2Data7_1_1);}
		//*******************************   CAGR8   *************************************		
		//Beginning Data8
		String ICColumn1Data8_1 = VIPFinancialsPage.contents.ICColumn1Data8.getText();
		String ICColumn2Data8_1_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		if (ICColumn1Data8_1.contains("-") | ICColumn2Data8_1_1.contains("-") |
		ICColumn1Data8_1.equals("0") | ICColumn2Data8_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText("N/M");}
		else {
		String ICColumn1Data8_2 = ICColumn1Data8_1.replace(",", "");
		double ICColumn1Data8 = Double.parseDouble(ICColumn1Data8_2);
		//Ending Data8
		String ICColumn2Data8_1 = VIPFinancialsPage.contents.ICColumn2Data8.getText();
		String ICColumn2Data8_2 = ICColumn2Data8_1.replace(",", "");
		double ICColumn2Data8 = Double.parseDouble(ICColumn2Data8_2);
		double Base1 = ICColumn2Data8/ICColumn1Data8;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data8.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data8  
		if (ICColumn1Data8_1.length() > 4) {
		String ICColumn1Data8_1_a = ICColumn1Data8_1.substring(0, ICColumn1Data8_1.length() - 4);
		String ICColumn1Data8_1_b = ICColumn1Data8_1.substring(ICColumn1Data8_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1_a + "," + ICColumn1Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data8.verifyText(ICColumn1Data8_1);}
		//Validating the Data Format of Column2Data8  
		if (ICColumn2Data8_1_1.length() > 4) {
		String ICColumn2Data8_1_a = ICColumn2Data8_1_1.substring(0, ICColumn2Data8_1_1.length() - 4);
		String ICColumn2Data8_1_b = ICColumn2Data8_1_1.substring(ICColumn2Data8_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_a + "," + ICColumn2Data8_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data8.verifyText(ICColumn2Data8_1_1);}
		//*******************************   CAGR9   *************************************		
		//Beginning Data9
		String ICColumn1Data9_1 = VIPFinancialsPage.contents.ICColumn1Data9.getText();
		String ICColumn2Data9_1_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		if (ICColumn1Data9_1.contains("-") | ICColumn2Data9_1_1.contains("-") |
		ICColumn1Data9_1.equals("0") | ICColumn2Data9_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText("N/M");}
		else {
		String ICColumn1Data9_2 = ICColumn1Data9_1.replace(",", "");
		double ICColumn1Data9 = Double.parseDouble(ICColumn1Data9_2);
		//Ending Data9
		String ICColumn2Data9_1 = VIPFinancialsPage.contents.ICColumn2Data9.getText();
		String ICColumn2Data9_2 = ICColumn2Data9_1.replace(",", "");
		double ICColumn2Data9 = Double.parseDouble(ICColumn2Data9_2);
		double Base1 = ICColumn2Data9/ICColumn1Data9;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data9.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data9  
		if (ICColumn1Data9_1.length() > 4) {
		String ICColumn1Data9_1_a = ICColumn1Data9_1.substring(0, ICColumn1Data9_1.length() - 4);
		String ICColumn1Data9_1_b = ICColumn1Data9_1.substring(ICColumn1Data9_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1_a + "," + ICColumn1Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data9.verifyText(ICColumn1Data9_1);}
		//Validating the Data Format of Column2Data9  
		if (ICColumn2Data9_1_1.length() > 4) {
		String ICColumn2Data9_1_a = ICColumn2Data9_1_1.substring(0, ICColumn2Data9_1_1.length() - 4);
		String ICColumn2Data9_1_b = ICColumn2Data9_1_1.substring(ICColumn2Data9_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_a + "," + ICColumn2Data9_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data9.verifyText(ICColumn2Data9_1_1);}
		//*******************************   CAGR10   *************************************		
		//Beginning Data10
		String ICColumn1Data10_1 = VIPFinancialsPage.contents.ICColumn1Data10.getText();
		String ICColumn2Data10_1_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		if (ICColumn1Data10_1.contains("-") | ICColumn2Data10_1_1.contains("-") |
		ICColumn1Data10_1.equals("0") | ICColumn2Data10_1_1.equals("0")) {
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText("N/M");}
		else {
		String ICColumn1Data10_2 = ICColumn1Data10_1.replace(",", "");
		double ICColumn1Data10 = Double.parseDouble(ICColumn1Data10_2);
		//Ending Data10
		String ICColumn2Data10_1 = VIPFinancialsPage.contents.ICColumn2Data10.getText();
		String ICColumn2Data10_2 = ICColumn2Data10_1.replace(",", "");
		double ICColumn2Data10 = Double.parseDouble(ICColumn2Data10_2);
		double Base1 = ICColumn2Data10/ICColumn1Data10;
		//Computing the CAGR1
		double CAGR1_1 = (Math.pow(Base1, Exponent1) - 1);
		BigDecimal CAGR1_2 = new BigDecimal(CAGR1_1 * 100);
		BigDecimal CAGR1 = CAGR1_2.setScale(1, BigDecimal.ROUND_HALF_UP);
		VIPFinancialsPage.contents.ICColumn3Data10.verifyText(CAGR1 + "%");}
		//Validating the Data Format of Column1Data10  
		if (ICColumn1Data10_1.length() > 4) {
		String ICColumn1Data10_1_a = ICColumn1Data10_1.substring(0, ICColumn1Data10_1.length() - 4);
		String ICColumn1Data10_1_b = ICColumn1Data10_1.substring(ICColumn1Data10_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1_a + "," + ICColumn1Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn1Data10.verifyText(ICColumn1Data10_1);}
		//Validating the Data Format of Column2Data10  
		if (ICColumn2Data10_1_1.length() > 4) {
		String ICColumn2Data10_1_a = ICColumn2Data10_1_1.substring(0, ICColumn2Data10_1_1.length() - 4);
		String ICColumn2Data10_1_b = ICColumn2Data10_1_1.substring(ICColumn2Data10_1_1.length() - 3);
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_a + "," + ICColumn2Data10_1_b);
		}
		else {VIPFinancialsPage.contents.ICColumn2Data10.verifyText(ICColumn2Data10_1_1);}}
		
		//*************************   Period 1 is available   *******************************
		else {
		VIPFinancialsPage.contents.ICColumn2Data1.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data2.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data3.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data4.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data5.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data6.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data7.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data8.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data9.verifyText("N/M");
		VIPFinancialsPage.contents.ICColumn2Data10.verifyText("N/M");}
		WebControl.takeScreenshot("Q2A_Regression_155_&_156_CAGR of IC Table");
		
		ReportLog.setTestCase("Q2A_Regression_158");
		VIPFinancialsPage.contents.RefCalcFootnote.verifyText("Note: The balance sheet assets and liabilities may not add up to the total Invested Capital value in TTM period due to adjustments. Please refer to the Methodology for details on TTM Adjustments.");
		WebControl.takeScreenshot("Q2A_Regression_158");
		
		ReportLog.setTestCase("Q2A_Regression_159");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 10);
		VIPCompetitorPage.contents.Competitors1stPeers.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.waitForExist(true, 10);
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Essendant Inc");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.customJavaClick();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboard.waitForExist(true, 10);
		VIPFinancialsPage.contents.SelectDashboard.click();
		VIPFinancialsPage.contents.ReferenceCalculationMenu.click();
		VIPFinancialsPage.contents.SelectCompany.click();
		VIPFinancialsPage.contents.SelectCompanyMenu.click();
		VIPFinancialsPage.contents.EBITColumnHeader1.verifyDisplayed(true);
		VIPFinancialsPage.contents.EBITColumnHeader2.verifyDisplayed(true);
		VIPFinancialsPage.contents.EBITColumnHeader3.verifyDisplayed(false);
		VIPFinancialsPage.contents.EBITColumnHeader4.verifyDisplayed(false);
		VIPFinancialsPage.contents.ICColumnHeader1.verifyDisplayed(true);
		VIPFinancialsPage.contents.ICColumnHeader2.verifyDisplayed(true);
		VIPFinancialsPage.contents.ICColumnHeader3.verifyDisplayed(true);
		VIPFinancialsPage.contents.ICColumnHeader4.verifyDisplayed(false);
		VIPFinancialsPage.contents.ICColumnHeader5.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Regression_159");
		
		
	}
	
}


