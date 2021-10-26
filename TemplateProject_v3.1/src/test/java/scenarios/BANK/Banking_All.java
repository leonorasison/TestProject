package scenarios.BANK;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPBankingPage;
import pageobjects.VIPCIAPage;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;

public class Banking_All extends TestBase {
	public
		// for extracting period date -mico
		String getPeriodDate(String text){
	        String FY = "[FY - ";
	        String TTM = "[TTM - ";
	        String endBracket = "]";
	        String pDate;
	        
	        int indexFY = text.indexOf(FY);
	        int indexTTM = text.indexOf(TTM);
	        int indexEndBracket = text.indexOf(endBracket);
	        
	        if(text.contains(FY)){
	            pDate = text.substring(indexFY + FY.length(), indexEndBracket);
	            return pDate;
	        } else {
	            pDate = text.substring(indexTTM + TTM.length(), indexEndBracket);
	            return pDate;
	        }
	    }
	
	@Test(priority=1)
	public void LTB_LandingPage() throws Exception {

		ReportLog.setTestName("Link to Banking - Landing Page");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Bank_Reg_AutoLogin");
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
		
		ReportLog.setTestCase("Bank_Reg_Auto_001");//ST_TC_004
		VIPBankingPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SearchDisclaimer.verifyDisplayed(true, 180);
		VIPBankingPage.contents.SearchDisclaimer.verifyText("*VIP analysis now includes major " + "Retail and Corporate Banking Clients" + ". VIP is not yet available for Capital Markets, Public Services and\n" + "Managed Health Care (i.e. Health Insurance companies/ Payers).");
		WebControl.takeScreenshot("Bank_Reg_Auto_001");	
		
		ReportLog.setTestCase("Bank_Reg_Auto_002");//ST_TC_007
		VIPBankingPage.contents.SearchDisclaimer.hover();
		VIPBankingPage.contents.TooltipText.verifyText("VIP analysis now includes major Retail and Corporate Banking clients. VIP is not yet available for Capital Markets, Public Services and Managed Health Care (i.e. Health Insurance companies/ Payers). You may still see some private companies from these industries in the search above, however please do not use VIP for them as their financials may not be correct.");
		WebControl.takeScreenshot("Bank_Reg_Auto_002");
		
		ReportLog.setTestCase("Bank_Reg_Auto_003");//ST_TC_006
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
		WebControl.takeScreenshot("Bank_Reg_Auto_003");
		
		ReportLog.setTestCase("Bank_Reg_Auto_004");//ST_TC_008
		VIPLandingPage.contents.HelpIcon.hover();
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("insurance");
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(false, 5);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(false, 5);
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		VIPLandingPage.contents.HelpIcon.hover();
		WebControl.takeScreenshot("Bank_Reg_Auto_004");
		
		ReportLog.setTestCase("Bank_Reg_Auto_005");		
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
		WebControl.takeScreenshot("Bank_Reg_Auto_005");

		//Verify text on Side Menu
		ReportLog.setTestCase("Bank_Reg_Auto_006");
		Thread.sleep(2000);
		VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
		String.valueOf(VIPBankingPage.contents.SideMenuBankingAnalysisText).replaceAll("\\n", " ").contains("INDUSTRY ANALYSIS");
		WebControl.takeScreenshot("Bank_Reg_Auto_006");
		
		//OverviewPage
		ReportLog.setTestCase("Bank_Reg_Auto_007");//ST_TC_022
		VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
		VIPBankingPage.contents.SideMenuOverview.click();
		VIPBankingPage.contents.FinancialTitle.verifyText("Financial Summary");
		VIPBankingPage.contents.FinancialHeader.verifyText("SHOWING COMPANY’S PERFORMANCE TRENDS OVER LAST YEAR");
		VIPBankingPage.contents.FinancialContent.verifyText("Displaying the company’s standalone performance; for the detailed financial analysis, please go to the Financial Pulse section of the Banking Observatory Platform");
		WebControl.takeScreenshot("Bank_Reg_Auto_007");
		
		//TODOCompareValues
		ReportLog.setTestCase("Bank_Reg_Auto_008");//ST_TC_024
		VIPBankingPage.contents.KeyInsights.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Bank_Reg_Auto_008");
				
		// News Tab
		// News Icon
		if (testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com/")) {
			//if Prod
			ReportLog.setTestCase("Bank_Reg_Auto_009");//Reg_Auto_071
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
			WebControl.takeScreenshot("Bank_Reg_Auto_009");

			// News Load
			ReportLog.setTestCase("Bank_Reg_Auto_010");//Reg_Auto_072
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNews.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsIconBank.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsIconBank.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			VIPBankingPage.contents.SideMenuNewsLoaded.waitForDisplay(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Bank_Reg_Auto_010");

			// Executives Tab
			ReportLog.setTestCase("Bank_Reg_Auto_011");//Reg_Auto_075
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuExecutives.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuExecutives.click();
			VIPLandingPage.contents.HelpIcon.hover();
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuExecutivesLoaded.verifyDisplayed(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Bank_Reg_Auto_011");
		} else {
			//if QA
			ReportLog.setTestCase("Bank_Reg_Auto_009");//Reg_Auto_071
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNewsQA.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsQAIconBank.verifyDisplayed(true, 10);
			String newsIconNBank = "../../assets/images/grid-b.svg";
			VIPBankingPage.contents.SideMenuNewsQAIconBank.getAttribute("src").equals(newsIconNBank);
			WebControl.takeScreenshot("Bank_Reg_Auto_009");

			// News Load
			ReportLog.setTestCase("Bank_Reg_Auto_010");//Reg_Auto_072
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuNewsQA.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsQAIconBank.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuNewsQAIconBank.click();
			Thread.sleep(3000);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			VIPBankingPage.contents.SideMenuNewsLoaded.waitForDisplay(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Bank_Reg_Auto_010");

			// Executives Tab
			ReportLog.setTestCase("Bank_Reg_Auto_011");//Reg_Auto_075
			VIPBankingPage.contents.SideMenuBankingAnalysis.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOverview.click();
			VIPBankingPage.contents.SideMenuExecutivesQA.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuExecutivesQA.click();
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			Thread.sleep(3000);
			VIPBankingPage.contents.SideMenuExecutivesLoaded.verifyDisplayed(true, 20);
			VIPBankingPage.contents.RemoveHoverHelptext.hover();
			WebControl.takeScreenshot("Bank_Reg_Auto_011");
		}
		
		// Verify Download Button does not exists
		ReportLog.setTestCase("Bank_Reg_Auto_012");//Reg_Auto_076
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
			WebControl.takeScreenshot("Bank_Reg_Auto_012");
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
		ReportLog.setTestCase("Bank_Reg_Auto_013");//Reg_Auto_077
		VIPBankingPage.contents.SideMenuOverview.scrollToElementViewCenter();
		VIPBankingPage.contents.SideMenuOverview.click();
		VIPBankingPage.contents.FinancialsSummaryTitle.scrollToElement();
		VIPBankingPage.contents.BankingObservatoryPlatformLink.verifyDisplayed(true, 10);
		VIPBankingPage.contents.BankingObservatoryPlatformLink.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 20);
		WebControl.takeScreenshot("Bank_Reg_Auto_013");

		// Verify Logo exists in Financials
		ReportLog.setTestCase("Bank_Reg_Auto_014");//Reg_Auto_078
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
		WebControl.takeScreenshot("Bank_Reg_Auto_014");
				
	}
	
	    @Test(priority=2)
		public void LTB_Competitors() throws Exception {
			
			ReportLog.setTestName("Link to Banking - Competitors");
			
			VIPLandingPage.contents.HelpIcon.hover();
			VIPBankingPage.contents.BackToSearch.click();
			VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
			VIPLandingPage.contents.CompanyNameTextbox.sendKeys("BIT:UCG");//UniCredit S.p.A.
			Thread.sleep(5000);
			VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 60);
			VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
			WebControl.waitForPageToLoad(45);
			Thread.sleep(2000);
			VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
			Thread.sleep(2000);
		
			ReportLog.setTestCase("Bank_Reg_Auto_015");//LTB_Reg_Auto_025_Header
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
			WebControl.takeScreenshot("Bank_Reg_Auto_015");
			
			ReportLog.setTestCase("Bank_Reg_Auto_016");//LTB_Reg_Auto_034_RefineCriteria
			VIPBankingPage.contents.RefineCriteriaText.verifyDisplayed();
			VIPBankingPage.contents.RefineCriteriaText.verifyText("REFINE CRITERIA");
			VIPBankingPage.contents.RefineCriteriaIcon.verifyDisplayed();
			WebControl.takeScreenshot("Bank_Reg_Auto_016");
			
			ReportLog.setTestCase("Bank_Reg_Auto_017");//LTB_Reg_Auto_035_DeletePeer
			VIPBankingPage.contents.PeerItem.click();
			VIPBankingPage.contents.DeleteButton.verifyDisplayed(true, 2);
			VIPBankingPage.contents.DeleteButton.click();
			WebControl.takeScreenshot("Bank_Reg_Auto_017");
			
			ReportLog.setTestCase("Bank_Reg_Auto_018");//LTB_Reg_Auto_036_AddBank
			VIPBankingPage.contents.AddBank.verifyDisplayed();
			VIPBankingPage.contents.AddBank.getAttribute("placeholder");
			WebControl.takeScreenshot("cBank_Reg_Auto_018");
			
			ReportLog.setTestCase("Bank_Reg_Auto_019");//LTB_Reg_Auto_037_SubTitle
			VIPBankingPage.contents.SubTitle.verifyDisplayed();
			String CompetitorsSubTitle = VIPBankingPage.contents.SubTitle.getText();
			VIPBankingPage.contents.SubTitle.verifyText(CompetitorsSubTitle);
			WebControl.takeScreenshot("Bank_Reg_Auto_019");
			
			ReportLog.setTestCase("Bank_Reg_Auto_020");//LTB_Reg_Auto_038_AddPeer
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
			WebControl.takeScreenshot("Bank_Reg_Auto_020");
			
			ReportLog.setTestCase("Bank_Reg_Auto_021");//LTB_Reg_Auto_039_RefineCriteria
			VIPLandingPage.contents.HelpIcon.hover();
			VIPCompetitorPage.contents.RefineCriteriaButton.click();
			VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed();
			WebControl.takeScreenshot("Bank_Reg_Auto_021");
			
			ReportLog.setTestCase("Bank_Reg_Auto_022");//LTB_Reg_Auto_041_RefineCriteriaItems
			VIPBankingPage.contents.RefineCriteriaItem1.verifyText("SELECT PRE-SAVED CRITERIA");
			VIPBankingPage.contents.RefineCriteriaItem2.verifyText("SELECT INDUSTRY");
			VIPBankingPage.contents.RefineCriteriaItem3.verifyText("SELECT REGION");
			VIPBankingPage.contents.RefineCriteriaItem4.verifyText("SET OPERATING INCOME AND TOTAL ASSETS");
			VIPCompetitorPage.contents.RefineCriteriaCloseButton.click();
			WebControl.takeScreenshot("Bank_Reg_Auto_022");
			
		}
		
		@Test(priority=3)
		public void LTB_CIA () throws Exception {
			
			ReportLog.setTestName("Link to Banking - Covid19 Impact Analysis");
			
			//CIAModule
			ReportLog.setTestCase("Bank_Reg_Auto_023");//LTB_Reg_Auto_042_OverviewTab
			VIPLandingPage.contents.HelpIcon.hover();
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
			WebControl.takeScreenshot("Bank_Reg_Auto_023");
			
			ReportLog.setTestCase("Bank_Reg_Auto_024");//LTB_Reg_Auto_043_LiquidityHidden
			VIPBankingPage.contents.LiquidityRatio.verifyText("Operating Income Forecast");
			WebControl.takeScreenshot("Bank_Reg_Auto_024");
			
			ReportLog.setTestCase("Bank_Reg_Auto_025");//LTB_Reg_Auto_044_SolvencyHidden
			VIPCIAPage.contents.SolvencySideMenuClick.verifyText("EBT Forecast");
			WebControl.takeScreenshot("Bank_Reg_Auto_025");
			
			ReportLog.setTestCase("Bank_Reg_Auto_026");//LTB_Reg_Auto_045_OperatingForecast
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
			WebControl.takeScreenshot("Bank_Reg_Auto_026");
			
			ReportLog.setTestCase("Bank_Reg_Auto_027");//LTB_Reg_Auto_046_EBTForecast
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
			WebControl.takeScreenshot("Bank_Reg_Auto_027");
			
			ReportLog.setTestCase("Bank_Reg_Auto_028");//LTB_Reg_Auto_047_TRS
			VIPBankingPage.contents.TRSSideMenuClick.verifyDisplayed(true, 5);
			VIPBankingPage.contents.TRSSideMenuClick.verifyText("TRS");
			VIPBankingPage.contents.TRSSideMenuClick.click();
			WebControl.takeScreenshot("Bank_Reg_Auto_028");
		}
	
		@Test(priority=4)
		 public void LTB_FinancialsPage() throws Exception {
			
			ReportLog.setTestName("Link to Banking - Financials Page");
			Banking_All BOFinancial = new Banking_All();
				
				// ST_TC_055
				ReportLog.setTestCase("Reg_Auto_029");
				VIPLandingPage.contents.HelpIcon.hover();
				VIPBankingPage.contents.SideMenuFinancials.scrollToElementViewCenter();
				VIPBankingPage.contents.SideMenuFinancials.verifyDisplayed(true, 10);
				VIPBankingPage.contents.SideMenuFinancials.click();
				Thread.sleep(3000);
				
				// Verify if Show Best/Rank exist
				VIPBankingPage.contents.FinancialBestRank.verifyDisplayed(true, 10);
				VIPBankingPage.contents.FinancialBestRank.verifyText("Show Best and Rank");
				// Verify if Show Best/Rank checkbox is ticked, Best and Rank column should be visible
				if(VIPBankingPage.contents.FinancialBestRankCheckbox.isSelected()){
					VIPBankingPage.contents.FinancialBestColumn.verifyDisplayed(true, 10);
					VIPBankingPage.contents.FinancialBestRank.verifyDisplayed(true, 10);
				} else {
					VIPBankingPage.contents.FinancialBestColumn.verifyDisplayed(false, 10);
					VIPBankingPage.contents.FinancialBestRank.verifyDisplayed(false, 10);
				}
				Thread.sleep(2000);
				WebControl.takeScreenshot("Reg_Auto_029");
				
				// ST_TC_056
				ReportLog.setTestCase("Reg_Auto_030");
				VIPBankingPage.contents.FinancialTimePeriod.hover();
				// Extracting the date
				String fTimePeriod = VIPBankingPage.contents.FinancialTimePeriod.getText();
				String fDate = BOFinancial.getPeriodDate(fTimePeriod);
				// Checking if FY or TTM then validating if correct format
				// This process needs to be updated in the future -mico
				if(fTimePeriod.contains("FY")) {
					if(fDate.length() == 7 && fTimePeriod.length() == 14) {
						ReportLog.passed("Time Period format is correct: " + fTimePeriod);
					}
					else {
						ReportLog.failed("Time Period format is not correct: " + fTimePeriod);
					}
				} else if (fTimePeriod.contains("TTM"))  {
					if(fDate.length() == 7 && fTimePeriod.length() == 15) {
						ReportLog.passed("Time Period format is correct: " + fTimePeriod);
					}
					else {
						ReportLog.failed("Time Period format is not correct: " + fTimePeriod);
					}
				} else {
					ReportLog.failed("Please check code or if the format rules have been updated: " + fTimePeriod);
				}
				Thread.sleep(2000);
				WebControl.takeScreenshot("Reg_Auto_030");
				
								
				//ST_TC_057
				ReportLog.setTestCase("Reg_Auto_031");
				String TRSHeader= "TRS DEVELOPMENT";
				VIPBankingPage.contents.FinancialTRSHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialTRSHeader.verifyText(TRSHeader);
				
				String AOHeader= "ANALYST OUTLOOK";
				VIPBankingPage.contents.FinancialAOHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialAOHeader.verifyText(AOHeader);
				
				String IEHeader= "INVESTOR EXPECTATIONS";
				VIPBankingPage.contents.FinancialIEHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialIEHeader.verifyText(IEHeader);
				
				String OIGHeader= "OPERATING INCOME GROWTH";
				VIPBankingPage.contents.FinancialOIGHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialOIGHeader.verifyText(OIGHeader);
				
				String EPHeader= "EMPLOYEE PRODUCTIVITY";
				VIPBankingPage.contents.FinancialEPHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialEPHeader.verifyText(EPHeader);
				
				String RDHeader= "ROE DECOMPOSITION";
				VIPBankingPage.contents.FinancialRDHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialRDHeader.verifyText(RDHeader);
				
				String AIHeader= "ADDITIONAL INDICATORS";
				VIPBankingPage.contents.FinancialAIHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialAIHeader.verifyText(AIHeader);
				
				VIPBankingPage.contents.FinancialEPHeader.scrollToElementViewCenter();
				Thread.sleep(2000);
				WebControl.takeScreenshot("Reg_Auto_031");
				
						
				//ST_TC_059
				ReportLog.setTestCase("Reg_Auto_032");
				
				String AIAssetGrowth = "1-year Assets Growth";
				VIPBankingPage.contents.FinancialAIHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialAIAssetGrowth.verifyText(AIAssetGrowth);
				
				String AIDepositGrowth = "1-year Deposits Growth";
				VIPBankingPage.contents.FinancialAIDepositGrowth.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialAIDepositGrowth.verifyText(AIDepositGrowth);
				Thread.sleep(2000);
				WebControl.takeScreenshot("Reg_Auto_032");
				
				
				//ST_TC_060
				ReportLog.setTestCase("Reg_Auto_033");
				VIPBankingPage.contents.FinancialIEHeader.scrollToElementViewCenter();
				VIPBankingPage.contents.FinancialPBVIcon.click();
				Thread.sleep(2000);
				
				// check if hover message is present or available on screen
				Boolean pbvHoverExist = VIPBankingPage.contents.FinancialPBVHover.isExisting();
				if(pbvHoverExist) {
					String PBVHover = VIPBankingPage.contents.FinancialPBVHover.getText();
					String PBVHovTTM = "Book value is as of [TTM - ";
					String PBVHovFY = "Book value is as of [FY - ";
					String hovDate;
					
					if(PBVHover.contains(PBVHovTTM)) {
						// date extraction
						hovDate = BOFinancial.getPeriodDate(PBVHover);
						if(hovDate.length() == 7) {
							ReportLog.passed("[TTM] P/BV Hover message is correct");
						}
					} else if (PBVHover.contains(PBVHovFY)) {
						// date extraction
						hovDate = BOFinancial.getPeriodDate(PBVHover);
						if(hovDate.length() == 7) {
							ReportLog.passed("[FY] P/BV Hover message is correct");
						}
					} else {
						ReportLog.failed("P/BV Hover message is wrong!");
					}
				} else {
					ReportLog.failed("Missing P/BV hover message");
				}
				Thread.sleep(2000);
				WebControl.takeScreenshot("Reg_Auto_033");
				
		}
		
		@Test(priority=5)
		 public void LTB_IOM() throws Exception {
			
			ReportLog.setTestName("Link to Banking - Industry Operating Metrics");
			Banking_IOM BOperational = new Banking_IOM();
			
			//ST_TC_063
			ReportLog.setTestCase("Reg_Auto_034");
			VIPBankingPage.contents.SideMenuOpMetrics.scrollToElementViewCenter();
			VIPBankingPage.contents.SideMenuOpMetrics.verifyDisplayed(true, 10);
			VIPBankingPage.contents.SideMenuOpMetrics.click();
			Thread.sleep(3000);
			
			// Verify if Show Best/Rank exist
			VIPBankingPage.contents.OperationalBestRank.verifyDisplayed(true, 10);
			VIPBankingPage.contents.OperationalBestRank.verifyText("Show Best and Rank");
			// Verify if Show Best/Rank checkbox is ticked, Best and Rank column should be visible
			if(VIPBankingPage.contents.OperationalBestRankCheckbox.isSelected()){
				VIPBankingPage.contents.OperationalBestColumn.verifyDisplayed(true, 10);
				VIPBankingPage.contents.OperationalRankColumn.verifyDisplayed(true, 10);
			} else {
				VIPBankingPage.contents.OperationalBestColumn.verifyDisplayed(false, 10);
				VIPBankingPage.contents.OperationalRankColumn.verifyDisplayed(false, 10);
			}
			Thread.sleep(2000);
			WebControl.takeScreenshot("Reg_Auto_034");
			
			
			//ST_TC_064
			ReportLog.setTestCase("Reg_Auto_035");
			VIPBankingPage.contents.OperationalTimePeriod.hover();
			// Extracting the date
			String fTimePeriod = VIPBankingPage.contents.OperationalTimePeriod.getText();
			String fDate = BOperational.getPeriodDate(fTimePeriod);
			// Checking if FY or TTM then validating if correct format
			// This process needs to be updated in the future -mico
			if(fTimePeriod.contains("FY")) {
				if(fDate.length() == 7 && fTimePeriod.length() == 14) {
					ReportLog.passed("Time Period format is correct: " + fTimePeriod);
				}
				else {
					ReportLog.failed("Time Period format is not correct: " + fTimePeriod);
				}
			} else if(fTimePeriod.contains("TTM")) {
				if(fDate.length() == 7 && fTimePeriod.length() == 15) {
					ReportLog.passed("Time Period format is correct: " + fTimePeriod);
				}
				else {
					ReportLog.failed("Time Period format is not correct: " + fTimePeriod);
				}
			} else {
				ReportLog.failed("Please check code or if the format rules have been updated: " + fTimePeriod);
			}
			Thread.sleep(2000);
			WebControl.takeScreenshot("Reg_Auto_035");
			
			
			//ST_TC_067
			ReportLog.setTestCase("Reg_Auto_036");
			VIPBankingPage.contents.OperationalSCRTimePeriod.scrollToElementViewCenter();
			// check if time period for SCR is available or present
			VIPBankingPage.contents.OperationalSCRTimePeriod.verifyDisplayed(true, 10);
			Thread.sleep(2000);
			WebControl.takeScreenshot("Reg_Auto_037");
			
			
			//ST_TC_068
			ReportLog.setTestCase("Reg_Auto_038");
			VIPBankingPage.contents.OperationalBranchAnalyis.scrollToElementViewCenter();
			
			String branchAnalysisText = "BRANCH ANALYSIS";
			String SCRatioText = "STATUTORY CAPITAL RATIO";
			
			VIPBankingPage.contents.OperationalBranchAnalyis.verifyText(branchAnalysisText);
			if (VIPBankingPage.contents.OperationalSCRatio.getText().contains(SCRatioText)) {
				ReportLog.passed("[Operational Statutory Capital Ratio] Verify that text equals STATUTORY CAPITAL RATIO");
			} else {
				ReportLog.failed("[Operational Statutory Capital Ratio] not equals STATUTORY CAPITAL RATIO: ");
			}
			Thread.sleep(2000);
			WebControl.takeScreenshot("Reg_Auto_038");
			
		
	}

}
