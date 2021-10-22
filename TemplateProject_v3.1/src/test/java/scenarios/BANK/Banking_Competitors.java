package scenarios.BANK;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPBankingPage;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Banking_Competitors extends TestBase{
	
	@Test
	public void LTB_Competitors() throws Exception {
		
		ReportLog.setTestName("Link to Banking - Competitors");
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
		
		ReportLog.setTestCase("LTB_Reg_Auto_025_Header");
		VIPBankingPage.contents.IASideMenu.verifyDisplayed(true, 5);
		VIPBankingPage.contents.IASideMenu.click();
		VIPBankingPage.contents.BIASideMenu.verifyDisplayed(true, 5);
		VIPBankingPage.contents.BIASideMenu.click();
		VIPBankingPage.contents.CompetitorsSideMenu.verifyDisplayed(true, 5);
		VIPBankingPage.contents.CompetitorsSideMenu.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPBankingPage.contents.CompetitorsTitle.verifyText("Competitors");
		VIPBankingPage.contents.CompanyNameHeader.verifyDisplayed();
		VIPBankingPage.contents.IndustryCountryHeader.verifyDisplayed();
		VIPBankingPage.contents.FinancialsHeader.verifyDisplayed();
		VIPBankingPage.contents.OperatingIncomeHeader.verifyDisplayed();
		VIPBankingPage.contents.TotalAssetsHeader.verifyDisplayed();
		VIPBankingPage.contents.MarketCapHeader.verifyDisplayed();
		VIPBankingPage.contents.EditAliasHeader.verifyDisplayed();
		WebControl.takeScreenshot("LTB_Reg_Auto_025_Header");
		
		ReportLog.setTestCase("LTB_Reg_Auto_034_RefineCriteria");
		VIPBankingPage.contents.RefineCriteriaText.verifyDisplayed();
		VIPBankingPage.contents.RefineCriteriaText.verifyText("REFINE CRITERIA");
		VIPBankingPage.contents.RefineCriteriaIcon.verifyDisplayed();
		WebControl.takeScreenshot("LTB_Reg_Auto_034_RefineCriteria");
		
		ReportLog.setTestCase("LTB_Reg_Auto_035_DeletePeer");
		VIPBankingPage.contents.PeerItem.click();
		VIPBankingPage.contents.DeleteButton.verifyDisplayed(true, 2);
		VIPBankingPage.contents.DeleteButton.click();
		WebControl.takeScreenshot("LTB_Reg_Auto_035_DeletePeer");
		
		ReportLog.setTestCase("LTB_Reg_Auto_036_AddBank");
		VIPBankingPage.contents.AddBank.verifyDisplayed();
		VIPBankingPage.contents.AddBank.getAttribute("placeholder");
		WebControl.takeScreenshot("LTB_Reg_Auto_036_AddBank");
		
		ReportLog.setTestCase("LTB_Reg_Auto_037_SubTitle");
		VIPBankingPage.contents.SubTitle.verifyDisplayed();
		String CompetitorsSubTitle = VIPBankingPage.contents.SubTitle.getText();
		VIPBankingPage.contents.SubTitle.verifyText(CompetitorsSubTitle);
		WebControl.takeScreenshot("LTB_Reg_Auto_037_SubTitle");
		
		ReportLog.setTestCase("LTB_Reg_Auto_038_AddPeer");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("ICICI Bank Limited");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.customJavaClick();
		Thread.sleep(2000);		
		String LastPeerText = VIPBankingPage.contents.LastPeerItem.getText();
		VIPBankingPage.contents.LastPeerItem.verifyText(LastPeerText, LastPeerText.contains("ICICI Bank Limited"));
		WebControl.takeScreenshot("LTB_Reg_Auto_038_AddPeer");
		
		ReportLog.setTestCase("LTB_Reg_Auto_039_RefineCriteria");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed();
		WebControl.takeScreenshot("LTB_Reg_Auto_039_RefineCriteria");
		
		ReportLog.setTestCase("LTB_Reg_Auto_041_RefineCriteriaItems");
		VIPBankingPage.contents.RefineCriteriaItem1.verifyText("SELECT PRE-SAVED CRITERIA");
		VIPBankingPage.contents.RefineCriteriaItem2.verifyText("SELECT INDUSTRY");
		VIPBankingPage.contents.RefineCriteriaItem3.verifyText("SELECT REGION");
		VIPBankingPage.contents.RefineCriteriaItem4.verifyText("SET OPERATING INCOME AND TOTAL ASSETS");
		VIPCompetitorPage.contents.RefineCriteriaCloseButton.click();
		WebControl.takeScreenshot("LTB_Reg_Auto_041_RefineCriteriaItems");
		
	}
}