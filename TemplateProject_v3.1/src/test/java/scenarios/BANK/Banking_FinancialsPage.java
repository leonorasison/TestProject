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



public class Banking_FinancialsPage extends TestBase {
	
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

	@Test
	public void BO_FinancialPage() throws Exception {
		ReportLog.setTestName("Link to Banking - Financials Page");
		
		Banking_FinancialsPage BOFinancial = new Banking_FinancialsPage();
		
		// Recycled Log-In process
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("ICICI Bank Limited");
		Thread.sleep(5000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 60);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(2000);
		WebControl.takeScreenshot("Banking_Reg_Auto_Login");
		
		// ST_TC_055
		ReportLog.setTestCase("Reg_Auto_055");
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
		WebControl.takeScreenshot("Reg_Auto_055");
		
		
		// ST_TC_056
		ReportLog.setTestCase("Reg_Auto_056");
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
		
		
		WebControl.takeScreenshot("Reg_Auto_056");
		Thread.sleep(2000);
		
		
		//ST_TC_057
		ReportLog.setTestCase("Reg_Auto_057");
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
		WebControl.takeScreenshot("Reg_Auto_057");
		Thread.sleep(2000);
				
		//ST_TC_059
		ReportLog.setTestCase("Reg_Auto_059");
		
		String AIAssetGrowth = "1-year Assets Growth";
		VIPBankingPage.contents.FinancialAIHeader.scrollToElementViewCenter();
		VIPBankingPage.contents.FinancialAIAssetGrowth.verifyText(AIAssetGrowth);
		
		String AIDepositGrowth = "1-year Deposits Growth";
		VIPBankingPage.contents.FinancialAIDepositGrowth.scrollToElementViewCenter();
		VIPBankingPage.contents.FinancialAIDepositGrowth.verifyText(AIDepositGrowth);
		WebControl.takeScreenshot("Reg_Auto_059");
		Thread.sleep(2000);
		
		//ST_TC_060
		ReportLog.setTestCase("Reg_Auto_060");
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
		
		WebControl.takeScreenshot("Reg_Auto_060");
		Thread.sleep(2000);
		
		
		
		
		
		
	}
}