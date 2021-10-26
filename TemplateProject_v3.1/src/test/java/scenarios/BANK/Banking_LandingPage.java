package scenarios.BANK;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPBankingPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Banking_LandingPage extends TestBase {

	@Test(priority = 1)
	public void LTB_LandingPage() throws Exception {

		ReportLog.setTestName("Link to Banking - Landing Page");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

		ReportLog.setTestCase("Banking_Bank_Reg_AutoLogin");
		VIP_Common.LogInPage(testDataHandler);
		Thread.sleep(5000);
		do {
			WebControl.waitForPageToLoad(3000);
		} while (VIPBankingPage.contents.Spinner.isDisplayed());
		VIPBankingPage.contents.ModalCloseButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
			VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
			VIPLandingPage.contents.DisclaimerProceedButton.click();
			VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
			VIPLandingPage.contents.NewDisclaimerProceedButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		} else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
			VIPLandingPage.contents.NewDisclaimerText.waitForExist(true, 10);
			VIPLandingPage.contents.NewDisclaimerProceedButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		} else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
			VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
			VIPLandingPage.contents.DisclaimerProceedButton.click();
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		} else {
			VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		}
		
		ReportLog.setTestCase("Reg_Auto_001");//ST_TC_004
		VIPBankingPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SearchDisclaimer.verifyDisplayed(true, 180);
		VIPBankingPage.contents.SearchDisclaimer.verifyText("*VIP analysis now includes major " + "Retail and Corporate Banking Clients" + ". VIP is not yet available for Capital Markets, Public Services and\n" + "Managed Health Care (i.e. Health Insurance companies/ Payers).");
		WebControl.takeScreenshot("Reg_Auto_001");	
		
		ReportLog.setTestCase("Reg_Auto_002");//ST_TC_007
		VIPBankingPage.contents.SearchDisclaimer.hover();
		VIPBankingPage.contents.TooltipText.verifyText("VIP analysis now includes major Retail and Corporate Banking clients. VIP is not yet available for Capital Markets, Public Services and Managed Health Care (i.e. Health Insurance companies/ Payers). You may still see some private companies from these industries in the search above, however please do not use VIP for them as their financials may not be correct.");
		WebControl.takeScreenshot("Reg_Auto_002");
		
		ReportLog.setTestCase("Reg_Auto_003");//ST_TC_006
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Vodafone");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPBankingPage.contents.IndustryAnalysisHeader.verifyDisplayed(false, 5);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPBankingPage.contents.BackToSearch.click();
		WebControl.takeScreenshot("Reg_Auto_003");
		
		ReportLog.setTestCase("Reg_Auto_004");//ST_TC_008
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("insurance");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(false, 5);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(false, 5);
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		VIPLandingPage.contents.HelpIcon.hover();
		WebControl.takeScreenshot("Reg_Auto_004");
		
		ReportLog.setTestCase("Reg_Auto_005");		
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("ICICI Bank Limited");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPBankingPage.contents.SideMenuBankingAnalysis.hover();
		VIPBankingPage.contents.SideMenuBankingAnalysisClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPBankingPage.contents.IndustryAnalysisHeader.verifyDisplayed(true, 10);
		VIPBankingPage.contents.IndustryAnalystText1.verifyText("Banking Industry view: Banking trends with a focus on Customers, technology, regulation and Competitive arena");
		VIPBankingPage.contents.PoweredByACNResearchLogo.hover();
		WebControl.takeScreenshot("Reg_Auto_005");

		//Verify text on Side Menu
		ReportLog.setTestCase("Reg_Auto_006");
		Thread.sleep(2000);
		VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
		String.valueOf(VIPBankingPage.contents.SideMenuBankingAnalysisText).replaceAll("\\n", " ").contains("INDUSTRY ANALYSIS");
		WebControl.takeScreenshot("Reg_Auto_006");
		
		//OverviewPage
		ReportLog.setTestCase("Reg_Auto_007");//ST_TC_022
		VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SideMenuOverview.click();
		VIPBankingPage.contents.FinancialTitle.verifyText("Financial Summary");
		VIPBankingPage.contents.FinancialHeader.verifyText("SHOWING COMPANY’S PERFORMANCE TRENDS OVER LAST YEAR");
		VIPBankingPage.contents.FinancialContent.verifyText("Displaying the company’s standalone performance; for the detailed financial analysis, please go to the Financial Pulse section of the Banking Observatory Platform");
				WebControl.takeScreenshot("Reg_Auto_007");
		
		//TODOCompareValues
		ReportLog.setTestCase("Reg_Auto_008");//ST_TC_024
		VIPBankingPage.contents.KeyInsights.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Reg_Auto_008");
				
		// News Tab
		// News Icon
		if (testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com/")) {
			//if Prod
			ReportLog.setTestCase("Reg_Auto_071");
			VIPLandingPage.contents.HelpIcon.hover();
			VIPBankingPage.contents.SideMenuBankingAnalysis.hover();
			VIPBankingPage.contents.SideMenuBankingAnalysisClick.click();
			VIPLandingPage.contents.HelpIcon.hover();
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNews.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsIconBank.verifyDisplayed(true, 10);
			String newsIconNBank = "../../assets/images/grid-b.svg";
			VIPBankingPage.contents.SideMenuNewsIconBank.getAttribute("src").equals(newsIconNBank);
			WebControl.takeScreenshot("Reg_Auto_071");

			// News Load
			ReportLog.setTestCase("Reg_Auto_072");
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNews.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsIconBank.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsIconBank.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			VIPBankingPage.contents.SideMenuNewsLoaded.waitForDisplay(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Reg_Auto_072");

			// Executives Tab
			ReportLog.setTestCase("Reg_Auto_075");
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuExecutives.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuExecutives.click();
			VIPLandingPage.contents.HelpIcon.hover();
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuExecutivesLoaded.verifyDisplayed(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Reg_Auto_075");
		} else {
			//if QA
			ReportLog.setTestCase("Reg_Auto_071");
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNewsQA.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsQAIconBank.verifyDisplayed(true, 10);
			String newsIconNBank = "../../assets/images/grid-b.svg";
			VIPBankingPage.contents.SideMenuNewsQAIconBank.getAttribute("src").equals(newsIconNBank);
			WebControl.takeScreenshot("Reg_Auto_071");

			// News Load
			ReportLog.setTestCase("Reg_Auto_072");
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNewsQA.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsQAIconBank.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsQAIconBank.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			VIPBankingPage.contents.SideMenuNewsLoaded.waitForDisplay(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Reg_Auto_072");

			// Executives Tab
			ReportLog.setTestCase("Reg_Auto_075");
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuExecutivesQA.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuExecutivesQA.click();
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuExecutivesLoaded.verifyDisplayed(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Reg_Auto_075");
		}
		
		// Verify Download Button does not exists
		ReportLog.setTestCase("Reg_Auto_076");
		//overview
		VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
		VIPBankingPage.contents.SideMenuOverview.click();
		Thread.sleep(3000);
		VIPBankingPage.contents.Footer.scrollToElement();
		Thread.sleep(3000);
		VIPBankingPage.contents.Header.hover();
		VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
		//competitors
		VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
		VIPBankingPage.contents.SideMenuOverview.click();
		Thread.sleep(3000);
		VIPBankingPage.contents.SideMenuCompetitors.click();
		VIPBankingPage.contents.Footer.scrollToElement();
		Thread.sleep(3000);
		VIPBankingPage.contents.Header.hover();
		VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
		//covid
		VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
		VIPBankingPage.contents.SideMenuOverview.click();
		Thread.sleep(3000);
		VIPBankingPage.contents.SideMenuCOVID.click();
		VIPBankingPage.contents.Footer.scrollToElement();
		Thread.sleep(3000);
		VIPBankingPage.contents.Header.hover();
		VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
		//financials
		VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
		VIPBankingPage.contents.SideMenuOverview.click();
		Thread.sleep(3000);
		VIPBankingPage.contents.SideMenuFinancials.click();
		VIPBankingPage.contents.Footer.scrollToElement();
		Thread.sleep(3000);
		VIPBankingPage.contents.Header.hover();
		VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
		if (testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com/")) {
			//if PROD
			//executives
			VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOverview.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuExecutives.click();
			VIPBankingPage.contents.Footer.scrollToElement();
			Thread.sleep(3000);
			VIPBankingPage.contents.Header.hover();
			VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
			//news
			VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOverview.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuNews.click();
			VIPBankingPage.contents.Footer.scrollToElement();
			Thread.sleep(3000);
			VIPBankingPage.contents.Header.hover();
			VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
			//transcripts
			VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOverview.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuTranscripts.click();
			VIPBankingPage.contents.Footer.scrollToElement();
			Thread.sleep(3000);
			VIPBankingPage.contents.Header.hover();
			VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
			WebControl.takeScreenshot("Reg_Auto_076");
		} else {
			//if QA
			//GIT
			VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOverview.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuGITQA.click();
			VIPBankingPage.contents.Footer.scrollToElement();
			Thread.sleep(3000);
			VIPBankingPage.contents.Header.hover();
			VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
			//executives
			VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOverview.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuExecutivesQA.click();
			VIPBankingPage.contents.Footer.scrollToElement();
			Thread.sleep(3000);
			VIPBankingPage.contents.Header.hover();
			VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
			//transcripts
			VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOverview.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuNewsQA.click();
			VIPBankingPage.contents.Footer.scrollToElement();
			Thread.sleep(3000);
			VIPBankingPage.contents.Header.hover();
			VIPBankingPage.contents.DownloadButton.verifyDisplayed(false, 10);
		}

		// Click Banking Observatory Link
		ReportLog.setTestCase("Reg_Auto_077");
		VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
		VIPBankingPage.contents.SideMenuOverview.click();
		VIPBankingPage.contents.FinancialsSummaryTitle.scrollToElement();
		VIPBankingPage.contents.BankingObservatoryPlatformLink.verifyDisplayed(true, 10);
		VIPBankingPage.contents.BankingObservatoryPlatformLink.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 20);
		WebControl.takeScreenshot("Reg_Auto_077");

		// Verify Logo exists in Financials
		ReportLog.setTestCase("Reg_Auto_078");
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPBankingPage.contents.SideMenuBankingAnalysis.scrollToElement();
		VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SideMenuOverview.click();
		VIPBankingPage.contents.SideMenuFinancials.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SideMenuFinancials.click();
		Thread.sleep(5000);
		VIPBankingPage.contents.RemoveHoverHelptext.hover();
		VIPBankingPage.contents.FinancialsTitle.waitForDisplay(true, 10);
		VIPBankingPage.contents.PoweredByACNResearchLogo.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("Reg_Auto_078");
		

	}
	
	
}
	
