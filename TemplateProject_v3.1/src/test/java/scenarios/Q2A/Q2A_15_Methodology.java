package scenarios.Q2A;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPExecutivesPage;
import pageobjects.VIPFinancialsPage;
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

public class Q2A_15_Methodology extends TestBase{
	
	@Test
	public void Q2A_Methodology () throws Exception {
		ReportLog.setTestName("Q2A - Methodology");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Q2A_Regression_145");
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
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown14.click();
		VIPFinancialsPage.contents.MethodologyTitle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.MethodologyTitle.verifyText("METHODOLOGY");
		VIPFinancialsPage.contents.KeyItemsHeader.verifyText("KEY ITEMS");
		VIPFinancialsPage.contents.MethodologyDescriptionHeader.verifyText("DESCRIPTION");
		WebControl.takeScreenshot("Q2A_Regression_145");
		
		ReportLog.setTestCase("Q2A_Regression_146");
		VIPFinancialsPage.contents.KeyItems1.verifyText("Financial Reporting");
		VIPFinancialsPage.contents.KeyItems2.verifyText("Year Alignment");
		VIPFinancialsPage.contents.KeyItems3.verifyText("Peer Median");
		VIPFinancialsPage.contents.KeyItems4.verifyText("Capital Efficiency Ratios");
		VIPFinancialsPage.contents.KeyItems5.verifyText("Trailing Twelve Months (TTM) Calculations");
		VIPFinancialsPage.contents.KeyItems6.verifyText("Unfunded Retirement Liabilities Adjustments");
		VIPFinancialsPage.contents.KeyItems7.verifyText("Operating Leases Adjustments");
		VIPFinancialsPage.contents.KeyItems8.verifyText("Data Release");
		VIPFinancialsPage.contents.Description1.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description2.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description3.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description4.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description5.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description6.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description7.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.Description8.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Regression_146");
		
		ReportLog.setTestCase("Q2A_Regression_147");
		VIPFinancialsPage.contents.MethodologyFootnote.verifyText("Note: For special financial situations such as M&A, divestments, accounting standard changes and presence of financial services arm, Custom Analysis is recommended for more accurate analysis.");
		WebControl.takeScreenshot("Q2A_Regression_147");
		
		
	}
	
}


