package scenarios.WEB;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;

public class WEBFunctionality_02_Search extends TestBase{
	
	@Test
	public void WEBFunctionality_Search () throws Exception {
		ReportLog.setTestName("WEB Functionality - Search");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_082");
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
		VIPLandingPage.contents.CompanyAnalysisTab.verifyDisplayed(false);
		VIPLandingPage.contents.VCMTab.verifyDisplayed(false);
		VIPLandingPage.contents.SearchButton1.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_082");
		
		ReportLog.setTestCase("WEB_Reg_Auto_083");
		if (VIPLandingPage.contents.MyLastReports2.isDisplayed()) {
		VIPLandingPage.contents.MyLastReports2.verifyDisplayed(true, 10);
		VIPLandingPage.contents.MyLastReports2.verifyText("My Last Reports");}
		else {VIPLandingPage.contents.MyLastReports.verifyDisplayed(true, 10);
		VIPLandingPage.contents.MyLastReports.verifyText("My Last Reports");}
		WebControl.takeScreenshot("WEB_Reg_Auto_083");
		
		ReportLog.setTestCase("WEB_Reg_Auto_084");
//		WebControl.switchWithTitle("Value Insights Platform");
		Thread.sleep(1000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Nestlé");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_084");
		
		ReportLog.setTestCase("WEB_Reg_Auto_085");
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("NYSE:PFE");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 15);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_085");
		
		ReportLog.setTestCase("WEB_Reg_Auto_086");
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfi");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 5);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_086");
		
		ReportLog.setTestCase("WEB_Reg_Auto_087");
		String Rev1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String[] Rev2 = Rev1.split("\\|");
		String Rev = Rev2[Rev2.length - 1];
		VIPLandingPage.contents.CompanyTypeAhead.verifyText("Pfizer Inc. | Ticker: NYSE:PFE |" + Rev);
		Thread.sleep(1000);
		WebControl.takeScreenshot("WEB_Reg_Auto_087");
		
		ReportLog.setTestCase("WEB_Reg_Auto_088");
		String ReportsTotal_042 = VIPLandingPage.contents.ReportsTotal.getText();
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 5);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(3000);
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(5000);
		if (VIPOverviewPage.contents.DownloadReportModalHeader.isDisplayed()) {
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		Thread.sleep(3000);}
		else {VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		Thread.sleep(3000);}
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 45);
		VIPLandingPage.contents.CompanyCardName.verifyText(testDataHandler.company);
		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal_042,false);
		WebControl.takeScreenshot("WEB_Reg_Auto_088");
		
		ReportLog.setTestCase("WEB_Reg_Auto_089");
		String CompanyName_043 = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.OverviewButton.verifyDisplayed(true, 40);
		VIPLandingPage.contents.OverviewButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 10);
		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName_043);
		WebControl.takeScreenshot("WEB_Reg_Auto_089");
		
		ReportLog.setTestCase("WEB_Reg_Auto_090");
		VIPOverviewPage.contents.BackToSearchButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyCardName.hover();
		String CompanyName_044 = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.RefreshButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.RefreshModalHeader.verifyDisplayed();
		VIPLandingPage.contents.RefreshModalHeader.verifyText("Refresh this Report?");
		VIPLandingPage.contents.RefreshModalCompany.verifyText(CompanyName_044);
		VIPLandingPage.contents.RefreshModalDate.verifyText("Request Date");
		WebControl.takeScreenshot("WEB_Reg_Auto_090");
		
		ReportLog.setTestCase("WEB_Reg_Auto_091");
		VIPLandingPage.contents.RefreshModalClose.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.RefreshModalHeader.verifyDisplayed(false);
		//VIPLandingPage.contents.StartNowButton.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_091");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_092_&_093");
//		String CompanyName_046_047 = VIPLandingPage.contents.CompanyCardName.getText();
//		String ReportsTotal_046_047 = VIPLandingPage.contents.ReportsTotal.getText();
//		VIPLandingPage.contents.RefreshButton.click();
//		Thread.sleep(2000);
//		VIPLandingPage.contents.RefreshCloseButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
//		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
//		Thread.sleep(2000);
//		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
//		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
//		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 60);
//		VIPOverviewPage.contents.CompanyName.verifyText(CompanyName_046_047);
//		WebControl.takeScreenshot("WEB_Reg_Auto_092");
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		Thread.sleep(2000);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyCardName.waitForExist(true, 15);
//		//VIPLandingPage.contents.NewDisclaimerProceedButton.click();
//		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal_046_047, false);
//		VIPLandingPage.contents.CompanyCardName.verifyText(CompanyName_046_047);
//		WebControl.takeScreenshot("WEB_Reg_Auto_093");
		
		ReportLog.setTestCase("WEB_Reg_Auto_094");
		if (VIPLandingPage.contents.FirstSavedComp.isDisplayed()) {
		do { VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.DeleteButton.click();} 
		while (VIPLandingPage.contents.FirstSavedComp.isDisplayed());}
		
		VIPLandingPage.contents.SavedCompaniesEditIcon.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.click();
		VIPLandingPage.contents.SavedCompaniesSearchBox.sendKeys("Pfi");
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		WebControl.takeScreenshot("WEB_Reg_Auto_094");
		
		ReportLog.setTestCase("WEB_Reg_Auto_095");
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(3000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.AddButton.waitForExist(true, 5);
		VIPLandingPage.contents.AddButton.click();
		Thread.sleep(2500);
		VIPLandingPage.contents.NewsList.verifyDisplayed(true, 20);
		WebControl.takeScreenshot("WEB_Reg_Auto_095");
		
		ReportLog.setTestCase("WEB_Reg_Auto_096");
		VIPLandingPage.contents.CompanyNameColumn.verifyDisplayed();
		VIPLandingPage.contents.CompanyNameColumn.verifyText("COMPANY NAME");
		VIPLandingPage.contents.IndustryColumn.verifyDisplayed();
		VIPLandingPage.contents.IndustryColumn.verifyText("INDUSTRY");
		VIPLandingPage.contents.LocationColumn.verifyDisplayed();
		VIPLandingPage.contents.LocationColumn.verifyText("LOCATION");
		WebControl.takeScreenshot("WEB_Reg_Auto_096");
		
		ReportLog.setTestCase("WEB_Reg_Auto_097");
		VIPLandingPage.contents.SavedCompaniesEditIcon.click(); 
		Thread.sleep(1500);
		VIPLandingPage.contents.DeleteButton.verifyDisplayed();
		WebControl.takeScreenshot("WEB_Reg_Auto_097");
		
		ReportLog.setTestCase("WEB_Reg_Auto_098");
		//String FirstCompany = VIPLandingPage.contents.FirstSavedComp.getText();
		VIPLandingPage.contents.DeleteButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.FirstSavedComp.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_098");
		
	}
	
}


