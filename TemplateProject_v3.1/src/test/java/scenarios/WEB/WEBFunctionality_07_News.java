package scenarios.WEB;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPLandingPage;
import pageobjects.VIPNewsPage;
import pageobjects.VIPOverviewPage;

public class WEBFunctionality_07_News extends TestBase{
	
	@Test
	public void WEBFunctionality_News () throws Exception {
		ReportLog.setTestName("WEB Functionality - News");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_167_to_169");	
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
		VIPLandingPage.contents.HelpIcon.hover();
		VIPNewsPage.contents.SideMenuNews.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPNewsPage.contents.NewsEvents1.verifyDisplayed(true, 15);
		WebControl.takeScreenshot("WEB_Reg_Auto_167_1");
		if (VIPNewsPage.contents.NoNewsMessage.isDisplayed()) { //Work around if Target Company has no news
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
			VIPLandingPage.contents.HelpIcon.hover();
			VIPNewsPage.contents.SideMenuNews.click();
			Thread.sleep(3000);
			VIPLandingPage.contents.HelpIcon.hover();
			VIPNewsPage.contents.SelectTimePeriod1.waitForExist(true, 15);
			VIPNewsPage.contents.SelectTimePeriod1.click();
			VIPNewsPage.contents.NewsEvents1.waitForExist(true, 15);
		}
		VIPNewsPage.contents.NewsEvents1.hover();
		VIPNewsPage.contents.NewsEvents1.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_167");
		VIPNewsPage.contents.NewsType1.hover();
		VIPNewsPage.contents.NewsType1.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("WEB_Reg_Auto_168");
		VIPNewsPage.contents.NewsTitle.verifyDisplayed();
		VIPNewsPage.contents.NewsTitle.verifyText("News");
		VIPNewsPage.contents.NewsType.verifyDisplayed(true, 5);
		VIPNewsPage.contents.NewsTypeHeader.verifyText("NEWS TYPE");
		VIPNewsPage.contents.NewsType1.verifyDisplayed();
		VIPNewsPage.contents.NewsType2.verifyDisplayed();
		WebControl.takeScreenshot("WEB_Reg_Auto_169");
		
		ReportLog.setTestCase("WEB_Reg_Auto_170");
		VIPNewsPage.contents.NewsEvents1.waitForExist(true, 25);
		String NewsEvents1 = VIPNewsPage.contents.NewsEvents1.getText();
		String NewsEvents2 = VIPNewsPage.contents.NewsEvents2.getText();
		String NewsEvents3 = VIPNewsPage.contents.NewsEvents3.getText();
		String NewsEvents4 = VIPNewsPage.contents.NewsEvents4.getText();
		String NewsEvents5 = VIPNewsPage.contents.NewsEvents5.getText();
		String NewsEvents6 = VIPNewsPage.contents.NewsEvents6.getText();
		String NewsEvents7 = VIPNewsPage.contents.NewsEvents7.getText();
		String NewsEvents8 = VIPNewsPage.contents.NewsEvents8.getText();
		String NewsEvents9 = VIPNewsPage.contents.NewsEvents9.getText();
		String NewsEvents10 = VIPNewsPage.contents.NewsEvents10.getText();
		
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents1);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents1);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents2);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents2);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents3);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents3);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents4);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents4);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents5);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents5);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents6);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents6);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents7);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents7);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents8);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents8);
		//VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents9);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents9);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents10);
		Thread.sleep(1500);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents10);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_170");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_171");
//		String AllNews1 = VIPNewsPage.contents.NewsType1Title.getText();
//		String AllNews2 = AllNews1.replace("ALL NEWS (", "");
//		String AllNews1Count = AllNews2.replace(")", "");
//		String AllNews1_1 = VIPNewsPage.contents.NewsType2Title.getText();
//		String AllNews2_1 = AllNews1_1.replace("LEGAL (", "");
//		String AllNews2Count = AllNews2_1.replace(")", "");
//		VIPNewsPage.contents.LastNewsEvents1.verifyDisplayed(true, 3);
//		VIPNewsPage.contents.NewsType2.click();
//		VIPNewsPage.contents.LastNewsEvents2.verifyDisplayed(true, 3);
//		WebControl.takeScreenshot("WEB_Reg_Auto_171");
		
		ReportLog.setTestCase("WEB_Reg_Auto_172");
		VIPNewsPage.contents.TimePeriod1.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod1Title.verifyText("LAST ONE MONTH");
		VIPNewsPage.contents.TimePeriod2.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod2Title.verifyText("LAST 3 MONTHS");
		VIPNewsPage.contents.TimePeriod3.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod3Title.verifyText("LAST 6 MONTHS");
		VIPNewsPage.contents.TimePeriod4.verifyDisplayed(true, 3);
		VIPNewsPage.contents.TimePeriod4Title.verifyText("CUSTOM");
		WebControl.takeScreenshot("WEB_Reg_Auto_172");
		
		ReportLog.setTestCase("WEB_Reg_Auto_173");
		VIPNewsPage.contents.NewsSearchBox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_173");
		
		ReportLog.setTestCase("WEB_Reg_Auto_174");
		VIPNewsPage.contents.NewsSearchBox.clear();
		VIPNewsPage.contents.NewsSearchBox.sendKeys(NewsEvents1);
		Thread.sleep(2000);
		VIPNewsPage.contents.NewsEvents1.verifyText(NewsEvents1);
		VIPNewsPage.contents.NewsEvents2.verifyDisplayed(false);
		VIPNewsPage.contents.NewsType1Title.verifyText("ALL NEWS (1)");
		WebControl.takeScreenshot("WEB_Reg_Auto_174");
		
		ReportLog.setTestCase("WEB_Reg_Auto_175");
		VIPNewsPage.contents.NewsEvents1.click();
		Thread.sleep(2000);
		VIPNewsPage.contents.NewsDetailsTitle.waitForExist(true, 10);
		VIPNewsPage.contents.NewsDetailsTitle.verifyText(NewsEvents1);
		WebControl.takeScreenshot("WEB_Reg_Auto_175");
		
		ReportLog.setTestCase("WEB_Reg_Auto_176");
		String NewsDetailsBody = VIPNewsPage.contents.NewsDetailsBody.getText();
		String[] NewsBody = NewsDetailsBody.split("\\s");
		String News = NewsBody[1];
		VIPNewsPage.contents.NewsSearchBox.sendKeys(News);
		VIPNewsPage.contents.SearchedWord.verifyText(News);
		WebControl.takeScreenshot("WEB_Reg_Auto_176");
		
		ReportLog.setTestCase("WEB_Reg_Auto_177");
		VIPNewsPage.contents.NewsDetailsBody.verifyDisplayed(true);
		WebControl.takeScreenshot("WEB_Reg_Auto_177");
		
		ReportLog.setTestCase("WEB_Reg_Auto_178");
		VIPNewsPage.contents.NewsSearchBox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_178");
		
		ReportLog.setTestCase("WEB_Reg_Auto_179");
		VIPNewsPage.contents.GoBackToListButton.verifyDisplayed(true, 3);
		VIPNewsPage.contents.GoBackToListButton.click();
		VIPNewsPage.contents.NewsEvents1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_179");
		
//		ReportLog.setTestCase("WEB_Reg_Auto_180");
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPOverviewPage.contents.BackToSearchButton.hover();
//		VIPOverviewPage.contents.BackToSearchButton.click();
//		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("publix");
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
//		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
//		Thread.sleep(1000);
//		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPNewsPage.contents.SideMenuNews.click();
//		Thread.sleep(3000);
//		VIPLandingPage.contents.HelpIcon.hover();
//		VIPNewsPage.contents.NewsEvents1.waitForExist(true, 10);
//		if (VIPNewsPage.contents.SelectedTimePeriod.isDisplayed()) {
//		VIPNewsPage.contents.SelectedTimePeriod.verifyText("LAST 6 MONTHS");}
//		else {VIPNewsPage.contents.SelectedTimePeriod2.verifyText("LAST 6 MONTHS");}
//		WebControl.takeScreenshot("WEB_Reg_Auto_180");
		
	}
	
}


