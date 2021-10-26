package scenarios.Q2A;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Q2A_07_RevenueGrowth extends TestBase{
	
	@Test
	public void Q2A_RevenueGrowth () throws Exception {
		ReportLog.setTestName("Q2A - Revenue Growth");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_059");	
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
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG5YrRevCAGRHeader.verifyText("5 year Revenue CAGR");
		VIPFinancialsPage.contents.RG3YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG3YrRevCAGRHeader.verifyText("3 year Revenue CAGR");
		VIPFinancialsPage.contents.RG1YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG1YrRevCAGRHeader.verifyText("1 year Revenue Growth");
		WebControl.takeScreenshot("Q2A_Reg_Auto_059");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_060");
		String RG5YrRevCAGR = VIPFinancialsPage.contents.RG5YrRevCAGRPeriod.getText();
		String RG5YrRevCAGR_1 = RG5YrRevCAGR.substring(4, 11);
		String RG5YrRevCAGR_2 = RG5YrRevCAGR.substring(18, 25);
		String RG3YrRevCAGR = VIPFinancialsPage.contents.RG3YrRevCAGRPeriod.getText();
		String RG3YrRevCAGR_1 = RG3YrRevCAGR.substring(4, 11);
		String RG3YrRevCAGR_2 = RG3YrRevCAGR.substring(18, 25);
		String RG1YrRevCAGR = VIPFinancialsPage.contents.RG1YrRevCAGRPeriod.getText();
		String RG1YrRevCAGR_1 = RG1YrRevCAGR.substring(4, 11);
		String RG1YrRevCAGR_2 = RG1YrRevCAGR.substring(18, 25);
		VIPFinancialsPage.contents.RG5YrRevCAGRPeriod.verifyText("[FY-" + RG5YrRevCAGR_1 + " - TTM-" + RG5YrRevCAGR_2 + "]");
		VIPFinancialsPage.contents.RG3YrRevCAGRPeriod.verifyText("[FY-" + RG3YrRevCAGR_1 + " - TTM-" + RG3YrRevCAGR_2 + "]");
		VIPFinancialsPage.contents.RG1YrRevCAGRPeriod.verifyText("[FY-" + RG1YrRevCAGR_1 + " - TTM-" + RG1YrRevCAGR_2 + "]");
		WebControl.takeScreenshot("Q2A_Reg_Auto_060");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_061");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.CAGR5YrKPI.waitForExist(true, 15);
		String CAGR5YrKPI1 = VIPFinancialsPage.contents.CAGR5YrKPI.getText();
		String CAGR5YrKPI2 = CAGR5YrKPI1.replace("%", "");
		Double CAGR5YrKPI = Double.parseDouble(CAGR5YrKPI2);
		Double CAGR5YrKPIAbs = Math.abs(CAGR5YrKPI);
		String CAGR3YrKPI = VIPFinancialsPage.contents.CAGR3YrKPI.getText();
		String CAGR1YrKPI1 = VIPFinancialsPage.contents.CAGR1YrKPI.getText();
		String CAGR1YrKPI2 = CAGR1YrKPI1.replace("%", "");
		Double CAGR1YrKPI = Double.parseDouble(CAGR1YrKPI2);
		Double CAGR1YrKPIAbs = Math.abs(CAGR1YrKPI);
		String CAGR5YrKPIP = VIPFinancialsPage.contents.CAGR5YrKPIP.getText();
		String CAGR3YrKPIP = VIPFinancialsPage.contents.CAGR3YrKPIP.getText();
		String CAGR1YrKPIP1 = VIPFinancialsPage.contents.CAGR1YrKPIP.getText();
		String CAGR1YrKPIP2 = CAGR1YrKPIP1.replace("%", "");
		Double CAGR1YrKPIP = Double.parseDouble(CAGR1YrKPIP2);
		Double CAGR1YrKPIPAbs = Math.abs(CAGR1YrKPIP);
		String CAGR5YrRank2_1 = VIPFinancialsPage.contents.CAGR5YrRank.getText();
		String[] CAGR5YrRank2_2 = CAGR5YrRank2_1.split("\\/");
		String CAGR5YrRank2_3 = CAGR5YrRank2_2[0];
		String CAGR5YrRank2_4 = CAGR5YrRank2_2[1];
		String CAGR5YrRank2_5 = CAGR5YrRank2_3.replace(" ", "");
		String CAGR5YrRank2_6 = CAGR5YrRank2_4.replace(" ", "");
		Double CAGR5YrRank3_1 = Double.parseDouble(CAGR5YrRank2_5);
		Double CAGR5YrRank3_2 = Double.parseDouble(CAGR5YrRank2_6);
		Double CAGR5YrRank = (CAGR5YrRank3_1/CAGR5YrRank3_2);
		String CAGR3YrRank2_1 = VIPFinancialsPage.contents.CAGR3YrRank.getText();
		String[] CAGR3YrRank2_2 = CAGR3YrRank2_1.split("\\/");
		String CAGR3YrRank2_3 = CAGR3YrRank2_2[0];
		String CAGR3YrRank2_4 = CAGR3YrRank2_2[1];
		String CAGR3YrRank2_5 = CAGR3YrRank2_3.replace(" ", "");
		String CAGR3YrRank2_6 = CAGR3YrRank2_4.replace(" ", "");
		Double CAGR3YrRank3_1 = Double.parseDouble(CAGR3YrRank2_5);
		Double CAGR3YrRank3_2 = Double.parseDouble(CAGR3YrRank2_6);
		Double CAGR3YrRank = (CAGR3YrRank3_1/CAGR3YrRank3_2);
		String CAGR1YrRank2_1 = VIPFinancialsPage.contents.CAGR1YrRank.getText();
		String[] CAGR1YrRank2_2 = CAGR1YrRank2_1.split("\\/");
		String CAGR1YrRank2_3 = CAGR1YrRank2_2[0];
		String CAGR1YrRank2_4 = CAGR1YrRank2_2[1];
		String CAGR1YrRank2_5 = CAGR1YrRank2_3.replace(" ", "");
		String CAGR1YrRank2_6 = CAGR1YrRank2_4.replace(" ", "");
		Double CAGR1YrRank3_1 = Double.parseDouble(CAGR1YrRank2_5);
		Double CAGR1YrRank3_2 = Double.parseDouble(CAGR1YrRank2_6);
		Double CAGR1YrRank = (CAGR1YrRank3_1/CAGR1YrRank3_2);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG5YrRevCAGRPeerMedian.verifyText("Peer Median: " + CAGR5YrKPIP);
		VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG3YrRevCAGRPeerMedian.verifyText("Peer Median: " + CAGR3YrKPIP);
		VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RG1YrRevCAGRPeerMedian.verifyText("Peer Median: " + CAGR1YrKPIP1);
		WebControl.takeScreenshot("Q2A_Reg_Auto_061");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_063");
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (CAGR5YrKPI < 0) {
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s revenue shrunk at a CAGR of " + CAGR5YrKPIAbs + "% over the last 5 years");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s revenue grew at a CAGR of " + CAGR5YrKPIAbs + "% over the last 5 years");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if ((CAGR1YrKPI < 0) & (CAGR1YrKPI < CAGR1YrKPIP)) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue shrunk by " + CAGR1YrKPIAbs + "%" + " (trailing the peer median of " + CAGR1YrKPIP + "%)");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("In the last 1 year, the company’s revenue grew by " + CAGR1YrKPIAbs + "%" + " (exceeding the peer median of " + CAGR1YrKPIP + "%)");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Competitive Position 2nd Bullet
		if ((CAGR1YrRank > 0) & (CAGR1YrRank <= 0.25)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the top quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((CAGR1YrRank > 0.25) & (CAGR1YrRank <= 0.5)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the 2nd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosGreenIcon2.verifyDisplayed(true, 3);}
		else if ((CAGR1YrRank > 0.5) & (CAGR1YrRank <= 0.75)) {
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the 3rd quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition2.verifyText("The company’s 1 year revenue growth performance was at the bottom quartile of the peer group");
		VIPFinancialsPage.contents.CompPosRedIcon2.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_063");
		
		if (VIPFinancialsPage.contents.FootNote.isDisplayed()) {
		ReportLog.setTestCase("Q2A_Reg_Auto_064");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		String SP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String Best = VIPFinancialsPage.contents.BestInClass.getText();
		String FootNote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_064");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_065");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
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
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(Best);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_065");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
		else {
		ReportLog.setTestCase("Q2A_Reg_Auto_064");
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		String SP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CP2 = VIPFinancialsPage.contents.CompetitivePosition2.getText();
		String Best = VIPFinancialsPage.contents.BestInClass.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_064");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_065");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
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
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.RevenueGrowthMenu.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(SP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CP1);
		VIPFinancialsPage.contents.CompetitivePosition2.verifyText(CP2);
		VIPFinancialsPage.contents.BestInClass.verifyText(Best);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(false);
		WebControl.takeScreenshot("Q2A_Reg_Auto_065");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}}
		
	}
	
}


