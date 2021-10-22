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



public class Banking_IOM extends TestBase {
	
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
	public void BO_OperationalPage() throws Exception {
		
		ReportLog.setTestName("Link to Banking - Industry Operating Metrics");
		Banking_IOM BOperational = new Banking_IOM();
		
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
		
		//ST_TC_063
		ReportLog.setTestCase("Reg_Auto_63");
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
		
		WebControl.takeScreenshot("Reg_Auto_063");
		Thread.sleep(2000);
		
		//ST_TC_064
		ReportLog.setTestCase("Reg_Auto_064");
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
		
		WebControl.takeScreenshot("Reg_Auto_064");
		Thread.sleep(2000);
		
		//ST_TC_067
		ReportLog.setTestCase("Reg_Auto_067");
		VIPBankingPage.contents.OperationalSCRTimePeriod.scrollToElementViewCenter();
		// check if time period for SCR is available or present
		VIPBankingPage.contents.OperationalSCRTimePeriod.verifyDisplayed(true, 10);
		
		WebControl.takeScreenshot("Reg_Auto_067");
		Thread.sleep(2000);
		
		//ST_TC_068
		ReportLog.setTestCase("Reg_Auto_068");
		VIPBankingPage.contents.OperationalBranchAnalyis.scrollToElementViewCenter();
		
		String branchAnalysisText = "BRANCH ANALYSIS";
		String SCRatioText = "STATUTORY CAPITAL RATIO";
		
		VIPBankingPage.contents.OperationalBranchAnalyis.verifyText(branchAnalysisText);
		if (VIPBankingPage.contents.OperationalSCRatio.getText().contains(SCRatioText)) {
			ReportLog.passed("[Operational Statutory Capital Ratio] Verify that text equals STATUTORY CAPITAL RATIO");
		} else {
			ReportLog.failed("[Operational Statutory Capital Ratio] not equals STATUTORY CAPITAL RATIO: ");
		}
		
		WebControl.takeScreenshot("Reg_Auto_068");
		Thread.sleep(2000);
		
	}
}
		