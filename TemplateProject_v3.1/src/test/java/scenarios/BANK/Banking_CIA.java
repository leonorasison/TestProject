package scenarios.BANK;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPBankingPage;
import pageobjects.VIPCIAPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Banking_CIA extends TestBase{
	
	@Test
	public void LTB_CIA() throws Exception {
		
		ReportLog.setTestName("Link to Banking - Covid19 Impact Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Banking_Reg_Auto_Login");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(3000);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPBankingPage.contents.UserEIDHeader.verifyDisplayed(true,5);
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(false, 2);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("BIT:UCG");//UniCredit S.p.A.
		Thread.sleep(5000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 60);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(2000);
		WebControl.takeScreenshot("Banking_Reg_Auto_Login");
	
		//CIAModule
		ReportLog.setTestCase("LTB_Reg_Auto_042_OverviewTab");
		VIPBankingPage.contents.IASideMenu.verifyDisplayed(true, 5);
		VIPBankingPage.contents.IASideMenu.click();
		VIPBankingPage.contents.BIASideMenu.verifyDisplayed(true, 5);
		VIPBankingPage.contents.BIASideMenu.click();
		VIPCIAPage.contents.SideMenuCIAClick.verifyDisplayed(true, 5);
		VIPCIAPage.contents.SideMenuCIAClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.CIATitle.verifyText("COVID-19 Impact Analysis");
		VIPCIAPage.contents.OverviewTab.verifyText("Overview");
		VIPCIAPage.contents.OverviewInfoIcon.click();
		VIPBankingPage.contents.TooltipText.verifyDisplayed(true, 3);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.hover();
		VIPCIAPage.contents.DetailedAnalysisTab.click();
		WebControl.waitForPageToLoad(20);
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		WebControl.takeScreenshot("LTB_Reg_Auto_042_OverviewTab");
		
		ReportLog.setTestCase("LTB_Reg_Auto_043_LiquidityHidden");
		VIPBankingPage.contents.LiquidityRatio.verifyText("Operating Income Forecast");
		WebControl.takeScreenshot("LTB_Reg_Auto_043_LiquidityHidden");
		
		ReportLog.setTestCase("LTB_Reg_Auto_044_SolvencyHidden");
		VIPCIAPage.contents.SolvencySideMenuClick.verifyText("EBT Forecast");
		WebControl.takeScreenshot("LTB_Reg_Auto_044_SolvencyHidden");
		
		ReportLog.setTestCase("LTB_Reg_Auto_045_OperatingForecast");
		VIPBankingPage.contents.OpIncForSideMenuClick.verifyDisplayed(true, 5);
		VIPBankingPage.contents.OpIncForSideMenuClick.verifyText("Operating Income Forecast");
		VIPBankingPage.contents.OpIncForSideMenuClick.click();
		WebControl.waitForPageToLoad(60);
		Thread.sleep(5000);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		VIPBankingPage.contents.KeyInsightsTitle.waitForExist(true, 60);
		VIPBankingPage.contents.KeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPBankingPage.contents.KeyInsightsText.verifyDisplayed(true, 5);
		String OpIncKeyInstightsText = VIPBankingPage.contents.KeyInsightsText.getText();
		VIPBankingPage.contents.KeyInsightsText.verifyText(OpIncKeyInstightsText, OpIncKeyInstightsText.contains("Operating Income Forecast"));
		WebControl.takeScreenshot("LTB_Reg_Auto_045_OperatingForecast");
		
		ReportLog.setTestCase("LTB_Reg_Auto_046_EBTForecast");
		VIPBankingPage.contents.EBTForSideMenuClick.verifyDisplayed(true, 5);
		VIPBankingPage.contents.EBTForSideMenuClick.verifyText("EBT Forecast");
		VIPBankingPage.contents.EBTForSideMenuClick.click();
		WebControl.waitForPageToLoad(60);
		Thread.sleep(5000);
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(2000);
		VIPBankingPage.contents.KeyInsightsTitle.waitForExist(true, 60);
		VIPBankingPage.contents.KeyInsightsTitle.verifyText("KEY INSIGHTS");
		VIPBankingPage.contents.KeyInsightsText.verifyDisplayed(true, 5);
		String EBTKeyInstightsText = VIPBankingPage.contents.KeyInsightsText.getText();
		VIPBankingPage.contents.KeyInsightsText.verifyText(EBTKeyInstightsText, EBTKeyInstightsText.contains("EBT Forecast"));
		WebControl.takeScreenshot("LTB_Reg_Auto_046_EBTForecast");
		
		ReportLog.setTestCase("LTB_Reg_Auto_047_TRS");
		VIPBankingPage.contents.TRSSideMenuClick.verifyDisplayed(true, 5);
		VIPBankingPage.contents.TRSSideMenuClick.verifyText("TRS");
		VIPBankingPage.contents.TRSSideMenuClick.click();
		WebControl.takeScreenshot("LTB_Reg_Auto_047_TRS");
	
	
	
	}

}
