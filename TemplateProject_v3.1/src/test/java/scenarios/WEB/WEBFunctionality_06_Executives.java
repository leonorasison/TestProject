package scenarios.WEB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class WEBFunctionality_06_Executives extends TestBase{
	
	
	@Test
	public void WEBFunctionality_Executives () throws Exception {
		ReportLog.setTestName("WEB Functionality - Executives");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_153");
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
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.SideMenuExecutives.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.ExecutivesTitle.verifyDisplayed(true, 25);
		VIPExecutivesPage.contents.ExecutivesTitle.verifyText("Executives");
		VIPExecutivesPage.contents.ExecutivesTitle.hover();
		VIPExecutivesPage.contents.ExecutivesDropdown.verifyText("All Executives");
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.TopExecutivesMenu.hover();
		VIPExecutivesPage.contents.TopExecutivesMenu.verifyDisplayed(true, 5);
		VIPExecutivesPage.contents.BoardMembersMenu.hover();
		VIPExecutivesPage.contents.BoardMembersMenu.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_153");
		
		ReportLog.setTestCase("WEB_Reg_Auto_154");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.ScoreCardDate.waitForExist(true, 20);
		String[] Period = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\/");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.SideMenuExecutives.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPExecutivesPage.contents.ExecutivesTitle.verifyDisplayed(true, 25);
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.TopExecutivesMenu.click();
		String KeyExecutiveName1 = VIPExecutivesPage.contents.FirstExecutiveNameMenu.getText();
		String KeyExecutiveName2 = VIPExecutivesPage.contents.SecondExecutiveNameMenu.getText();
		String KeyExecutiveName3 = VIPExecutivesPage.contents.ThirdExecutiveNameMenu.getText();
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.BoardMembersMenu.click();
		String BoardMemberName1 = VIPExecutivesPage.contents.SecondExecutiveNameMenu.getText();
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.AllExecutivesMenu.click();
		VIPExecutivesPage.contents.FirstExecutiveNameMenu.verifyText(KeyExecutiveName1, true);
		VIPExecutivesPage.contents.SecondExecutiveNameMenu.verifyText(KeyExecutiveName2, true);
		VIPExecutivesPage.contents.ThirdExecutiveNameMenu.verifyText(KeyExecutiveName3, true);
		VIPExecutivesPage.contents.FourthExecutiveNameMenu.verifyDisplayed();
		VIPExecutivesPage.contents.FourthExecutiveNameMenu.verifyText(BoardMemberName1, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_154");
		
		ReportLog.setTestCase("WEB_Reg_Auto_160");
		String ExecutiveName1 = VIPExecutivesPage.contents.FirstExecutiveNameMenu.getText();
		String ExecutiveName2 = VIPExecutivesPage.contents.SecondExecutiveNameMenu.getText();
		String ExecutiveName3 = VIPExecutivesPage.contents.ThirdExecutiveNameMenu.getText();
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.TopExecutivesMenu.click();
		VIPExecutivesPage.contents.FirstExecutiveNameMenu.verifyText(ExecutiveName1, true);
		VIPExecutivesPage.contents.SecondExecutiveNameMenu.verifyText(ExecutiveName2, true);
		VIPExecutivesPage.contents.ThirdExecutiveNameMenu.verifyText(ExecutiveName3, true);
		VIPExecutivesPage.contents.FourthExecutiveNameMenu.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_160");
		
		ReportLog.setTestCase("WEB_Reg_Auto_161");
		VIPExecutivesPage.contents.ExecutivesDropdown.click();
		VIPExecutivesPage.contents.BoardMembersMenu.click();
		VIPExecutivesPage.contents.SecondExecutiveNameMenu.verifyText(ExecutiveName2, false);
		VIPExecutivesPage.contents.ThirdExecutiveNameMenu.verifyText(ExecutiveName3, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_161");
		
		ReportLog.setTestCase("WEB_Reg_Auto_162");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.ACBChartTitle.verifyText("ANNUAL COMPENSATION BREAKUP");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		if (VIPExecutivesPage.contents.TSAChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.TSAChartTitle.verifyText("TOTAL STOCK AWARDS (USD MN)");}
		VIPExecutivesPage.contents.TSAChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_162");
		
		ReportLog.setTestCase("WEB_Reg_Auto_163");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.ACBChartTitle.verifyText("ANNUAL COMPENSATION BREAKUP");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_163");
		
		ReportLog.setTestCase("WEB_Reg_Auto_164");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
		LocalDate datetoday = LocalDate.now();
		String currentYear = year.format(datetoday);
		VIPExecutivesPage.contents.ACBChartYear.verifyText("[ " + Period[1].replace("]", "") + " ]");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_164");
		
		ReportLog.setTestCase("WEB_Reg_Auto_165");
		if (VIPExecutivesPage.contents.ACBChartTitle.isDisplayed()) {
		VIPExecutivesPage.contents.ACBChartLegend1.verifyText("Cash");
		VIPExecutivesPage.contents.ACBChartLegend2.verifyText("Non-Cash");}
		VIPExecutivesPage.contents.ACBChartTitle.verifyDisplayed(true, 4);
		WebControl.takeScreenshot("WEB_Reg_Auto_165");
		
		ReportLog.setTestCase("WEB_Reg_Auto_166");
		String bio = VIPExecutivesPage.contents.ExecutiveBio.getText();
		String newBio = new String(bio);
	      int count = 0;
	      for(int i = 0; i<newBio.length(); i++) {
	         count++;}
	    if (count >= 353) {
	    VIPExecutivesPage.contents.MoreLink.verifyDisplayed(true);
	    }
	    else {VIPExecutivesPage.contents.MoreLink.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_166");
	
	}
	
}


