  package scenarios.CustomCIA;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCustomCIAPage;
import pageobjects.VIPCustomPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;


public class CIA_Custom_01_OverviewPage extends TestBase{
	
	
	@Test(priority=1)
	public void CUSTOM_OverviewsPage () throws Exception {
		ReportLog.setTestName("CUSTOM CIA - OverviewPage");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_005,006");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton.hover();
		VIPLandingPage.contents.OverviewButtonTooltip.verifyText("Overview");
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		VIPCustomCIAPage.contents.SideMenuCIAClick.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SideMenuCIAClick.click();	
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomCIAPage.contents.CIATitlte.verifyText("COVID-19 Impact Analysis");
		VIPCustomCIAPage.contents.CIAOverviewTabTitle.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIAOverviewTabTitle.verifyText("Overview");
		VIPCustomCIAPage.contents.CIADetailedTabTitle.verifyText("Detailed Analysis");
		WebControl.takeScreenshot("CUSTOM_RT_TC_005,006");	
		
		ReportLog.setTestCase("CUSTOM_RT_TC_007");
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryTitle.verifyText("INSIGHTS SUMMARY");
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryInfoIconHoverMessage.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.hover();
		VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereHover.verifyText("Click to edit insights");
		String EditTextHere = VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.getText();
		
		if(EditTextHere.equals("Enter text here")) {
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.hover();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereXButton.click();
			Thread.sleep(2000);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.hover();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModal.verifyDisplayed(true, 5);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalHeader.verifyText("Add Insights:");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBoxTitle.verifyText("Insights Summary:");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalCharacters.verifyDisplayed(true, 5);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalCharacters.verifyText("1054 characters remaining");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBox.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBox.sendKeys("1\n"+"2\n"+"3\n"+"4\n"+"5\n"+"6\n"+"7\n"+"8\n"+"9\n"+"10\n"+"11\n"+"12\n"+"\n");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalCharacters.verifyText("1017 characters remaining");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereApplyButton.click();	
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.verifyText("1");
		}
		else {
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.hover();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereXButton.click();
			Thread.sleep(2000);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.hover();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModal.verifyDisplayed(true, 5);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalHeader.verifyText("Add Insights:");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBoxTitle.verifyText("Insights Summary:");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBox.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBox.clear();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereApplyButton.click();
			Thread.sleep(2000);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.hover();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalCharacters.verifyDisplayed(true, 5);
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBox.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalBox.sendKeys("1\n"+"2\n"+"3\n"+"4\n"+"5\n"+"6\n"+"7\n"+"8\n"+"9\n"+"10\n"+"11\n"+"12\n"+"\n");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereModalCharacters.verifyText("1017 characters remaining");
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHereApplyButton.click();
			VIPCustomCIAPage.contents.CIAOverviewInsightSummaryEditTextHere.verifyText("1");
		}
		WebControl.takeScreenshot("CUSTOM_RT_TC_007");	
		
		ReportLog.setTestCase("CUSTOM_RT_TC_009");
		VIPCustomCIAPage.contents.CIAOverviewRelevantNewsTitle.verifyText("RELEVANT NEWS");
		VIPCustomCIAPage.contents.CIAOverviewAccenturePOVTitle.verifyText("ACCENTURE POV");
		VIPCustomCIAPage.contents.CIAOverviewIndustryLink.verifyText("Now/Next industry perspectives");
		VIPCustomCIAPage.contents.CIAOverviewScenarioLink.verifyText("Scenarios of a post COVID-19 world");
		WebControl.takeScreenshot("CUSTOM_RT_TC_009");	
		
		ReportLog.setTestCase("CUSTOM_RT_TC_011");
		VIPCustomCIAPage.contents.CIAOverviewScenarioLink.click();
		WebControl.waitForPageToLoad(50); 
		Thread.sleep(2000);
		WebControl.switchWithTitle("COVID-19 Scenarios");
		Thread.sleep(5000);
		WebControl.verifyURL(
		"https://kxdocuments.accenture.com/contribution/e3a8184a-92fe-4187-bc17-d2b425ae178d");
		WebControl.takeScreenshot("CUSTOM_RT_TC_011_ScenarioLink");
		Thread.sleep(2000);
		WebControl.switchWithTitle("Custom Company Analysis");
		WebControl.takeScreenshot("CUSTOM_RT_TC_011");	

		
	}
	

	
	
}
	
