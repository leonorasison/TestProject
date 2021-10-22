package scenarios.WEB;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPNewsPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPTranscriptPage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WEBFunctionality_08_Architecture extends TestBase{
	
	
	@Test
	public void WEBFunctionality_Architecture () throws Exception {
		ReportLog.setTestName("WEB Functionality - Architecture");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_181");				
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
		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 15);
		String ReportsTotal = VIPLandingPage.contents.ReportsTotal.getText();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(3000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(2000);
		VIPLandingPage.contents.UserPhoto.verifyDisplayed(true, 10);
		VIPLandingPage.contents.UserEID.verifyDisplayed(true, 10);
		VIPLandingPage.contents.UserEID.verifyText(testDataHandler.eid);
		WebControl.takeScreenshot("WEB_Reg_Auto_181");
		
		ReportLog.setTestCase("WEB_Reg_Auto_183");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpFAQ.hover();
		VIPLandingPage.contents.HelpFAQ.verifyDisplayed(true, 10);
		VIPLandingPage.contents.HelpDUG.hover();
		VIPLandingPage.contents.HelpDUG.verifyDisplayed(true, 10);
		VIPLandingPage.contents.HelpEU.hover();
		VIPLandingPage.contents.HelpEU.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_183");
		
		ReportLog.setTestCase("WEB_Reg_Auto_184");
		VIPLandingPage.contents.HelpES.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_184");
		
		ReportLog.setTestCase("WEB_Reg_Auto_185");
		VIPLandingPage.contents.HelpES.hover();
		VIPLandingPage.contents.HelpES1.verifyText("VIP 2.0 Recorded Enablement Session");
		VIPLandingPage.contents.HelpES2.verifyText("VIP 3.0 Recorded Enablement Session");
		VIPLandingPage.contents.HelpES3.verifyText("VIP COVID-19 Recorded Enablement Session");
		VIPLandingPage.contents.HelpES4.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_185");
		
		ReportLog.setTestCase("WEB_Reg_Auto_186");
		VIPLandingPage.contents.FooterAU.hover();
		VIPLandingPage.contents.FooterAU.verifyDisplayed(true, 5);
		VIPLandingPage.contents.FooterFAQ.hover();
		VIPLandingPage.contents.FooterFAQ.verifyDisplayed(true, 5);
		VIPLandingPage.contents.FooterCU.hover();
		VIPLandingPage.contents.FooterCU.verifyDisplayed(true, 5);
		VIPLandingPage.contents.FooterDUG.hover();
		VIPLandingPage.contents.FooterDUG.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_186");
		
		ReportLog.setTestCase("WEB_Reg_Auto_187");
		DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
		LocalDate datetoday = LocalDate.now();
		String currentYear = year.format(datetoday);
		VIPLandingPage.contents.Copyright1.verifyText("Copyright 2001-" + currentYear + " Value Insights Platform");
		VIPLandingPage.contents.Copyright2.verifyText("Accenture. All rights reserved. Accenture");
		VIPLandingPage.contents.Copyright3.verifyText("confidential. For internal use only.");
		WebControl.takeScreenshot("WEB_Reg_Auto_187");
		
		ReportLog.setTestCase("WEB_Reg_Auto_188");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpDUG.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_188");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_189");
		VIPLandingPage.contents.FooterDUG.hover();
		VIPLandingPage.contents.FooterDUG.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		WebControl.switchWithUrl(testDataHandler.userGuideKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_189");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_190");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.HelpIcon.click();
		VIPLandingPage.contents.HelpFAQ.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_190");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_191");
		VIPLandingPage.contents.FooterFAQ.hover();
		VIPLandingPage.contents.FooterFAQ.click();
		Thread.sleep(5000);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		WebControl.switchWithUrl(testDataHandler.faqKXSite);
		Thread.sleep(5000);
		WebControl.takeScreenshot("WEB_Reg_Auto_191");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Value Insights Platform");
		WebControl.switchWithTitle("Value Insights Platform");
		
		ReportLog.setTestCase("WEB_Reg_Auto_192");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_192");
		
		ReportLog.setTestCase("WEB_Reg_Auto_193");
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyText("Download Report");
		VIPOverviewPage.contents.DownloadReportModalBody.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportDownloadButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.NotificationCloseButton.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_193");
		
		ReportLog.setTestCase("WEB_Reg_Auto_194");
		VIPOverviewPage.contents.NotificationCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_194");
		
		ReportLog.setTestCase("WEB_Reg_Auto_195_&_196");
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(5000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 600);
		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.ReportsTotal.verifyDisplayed(true, 60);
		VIPLandingPage.contents.ReportsTotal.hover();
		VIPLandingPage.contents.ReportsTotal.verifyText(ReportsTotal, false);
		WebControl.takeScreenshot("WEB_Reg_Auto_195_&_196");
		
		ReportLog.setTestCase("WEB_Reg_Auto_197");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.CompanyNameTextbox.hover();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Huawei");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(3000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		VIPOverviewPage.contents.RBBPieChartTitle.waitForExist(true, 10);
		Thread.sleep(1500);
		VIPOverviewPage.contents.GenerateFinancialReportButton.hover();
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2500);
		VIPOverviewPage.contents.DownloadReportModalHeader2.verifyText("Add Peers");
		WebControl.takeScreenshot("WEB_Reg_Auto_197");
		
	}
	
}


