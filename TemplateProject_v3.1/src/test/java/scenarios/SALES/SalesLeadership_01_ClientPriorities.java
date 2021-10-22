package scenarios.SALES;

import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import auto.framework.web.WebControl1;
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

public class SalesLeadership_01_ClientPriorities extends TestBase{
	
	@Test
	public void Sales_ClientPriorities () throws Exception {
		ReportLog.setTestName("Sales Leadership - Client Priorities");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_001");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(3000);
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
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_001");
		
		ReportLog.setTestCase("Sales_Reg_Auto_002_&_003");
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModal.verifyDisplayed(true, 5);
		VIPSalesPage.contents.OppNavModalHeader1.verifyText("What is Opportunity Navigator?");
		VIPSalesPage.contents.OppNavModalBody1.verifyText("An automated business case tool which identifies client priorities from Earnings Call Transcripts and links client performance (financial/operational KPIs) to Value Creation Opportunities (VCOs).");
		VIPSalesPage.contents.OppNavModalHeader2.verifyText("Who can use it?");
		VIPSalesPage.contents.OppNavModalBody2.verifyText("This tool can be used for creating the value proposition for large client opportunities. Primary audience for this dashboard includes: Sales Leads/ Sales Capture Leads, Market Makers, Transformation Directors, DCALs, CALs, Bid Managers. Please reach out to the CVS Team to get Value Architect support for further refinement of the business case before sharing with the client.");
		VIPSalesPage.contents.UserGuideButton.hover();
		VIPSalesPage.contents.UserGuideButton.verifyText("DOWNLOAD USER GUIDE");
		VIPSalesPage.contents.DoNotShowCheckBox.verifyDisplayed(true, 5);
		VIPSalesPage.contents.DoNotShowLabel.verifyText("Do not show this message again");
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		else {VIPSalesPage.contents.OppNavModal.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_002_&_003");
		
		ReportLog.setTestCase("Sales_Reg_Auto_004");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ValueProposition.hover();
		VIPSalesPage.contents.ValueProposition.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ValueProposition.verifyText("VALUE PROPOSITION");
		VIPSalesPage.contents.ClientPriorities.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ClientPriorities.verifyText("CLIENT PRIORITIES\n" + "(Beta)");
		VIPSalesPage.contents.FinancialKPIs.verifyDisplayed(false);
		//VIPSalesPage.contents.FinancialKPIs.verifyText("FINANCIAL KPIs");
		VIPSalesPage.contents.OperationalKPIs.verifyDisplayed(false);
		//VIPSalesPage.contents.OperationalKPIs.verifyText("OPERATIONAL KPIs");
		WebControl.takeScreenshot("Sales_Reg_Auto_004");
		
		ReportLog.setTestCase("Sales_Reg_Auto_005");
		VIPSalesPage.contents.SalesTitle.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SalesTitle.verifyText("Opportunity Navigator");
		VIPSalesPage.contents.OppNaviTooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.OppNaviTooltipIcon.click();
		VIPSalesPage.contents.OppNavModal.verifyDisplayed(true, 5);
		VIPSalesPage.contents.OppNavModalCloseButton.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_005");
		
		ReportLog.setTestCase("Sales_Reg_Auto_006");
		VIPSalesPage.contents.SideMenuSalesSelected.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_006");
		
		ReportLog.setTestCase("Sales_Reg_Auto_007");
		VIPSalesPage.contents.SalesSubTitle2.waitForExist(true, 25);
		VIPSalesPage.contents.SalesSubTitle2.verifyText("Note: Industry specific opportunities will be coming soon!");
		WebControl.takeScreenshot("Sales_Reg_Auto_007");
		
		ReportLog.setTestCase("Sales_Reg_Auto_008");
		VIPSalesPage.contents.ClientPriorities.click();
		Thread.sleep(1500);
		VIPSalesPage.contents.Segment1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.Segment1.verifyText("Cost Reduction");
		VIPSalesPage.contents.CRStrategicIntent.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent.verifyText("STRATEGIC INTENT");
		VIPSalesPage.contents.CRSupportingInsight.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSupportingInsight.verifyText("SUPPORTING INSIGHTS");
		VIPSalesPage.contents.Segment2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.Segment2.verifyText("Revenue Growth");
		VIPSalesPage.contents.RGStrategicIntent.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent.verifyText("STRATEGIC INTENT");
		VIPSalesPage.contents.RGSupportingInsight.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGSupportingInsight.verifyText("SUPPORTING INSIGHTS");
		VIPSalesPage.contents.Segment3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.Segment3.verifyText("Structural Balance Sheet Issues");
		VIPSalesPage.contents.SBSIStrategicIntent.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent.verifyText("STRATEGIC INTENT");
		VIPSalesPage.contents.SBSISupportingInsight.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSISupportingInsight.verifyText("SUPPORTING INSIGHTS");
		WebControl.takeScreenshot("Sales_Reg_Auto_008");
		
		ReportLog.setTestCase("Sales_Reg_Auto_009");
		String SI1 = VIPSalesPage.contents.CRSupportingInsightText.getText();
		VIPSalesPage.contents.CRStrategicIntent2.click();
		VIPSalesPage.contents.CRSupportingInsightText.verifyText(SI1, false);
		String SI2 = VIPSalesPage.contents.CRSupportingInsightText.getText();
		VIPSalesPage.contents.CRStrategicIntent3.click();
		VIPSalesPage.contents.CRSupportingInsightText.verifyText(SI2, false);
		String SI3 = VIPSalesPage.contents.RGSupportingInsightText.getText();
		VIPSalesPage.contents.RGStrategicIntent2.click();
		VIPSalesPage.contents.RGSupportingInsightText.verifyText(SI3, false);
		String SI4 = VIPSalesPage.contents.RGSupportingInsightText.getText();
		VIPSalesPage.contents.RGStrategicIntent3.click();
		VIPSalesPage.contents.RGSupportingInsightText.verifyText(SI4, false);
		String SI5 = VIPSalesPage.contents.SBSISupportingInsightText.getText();
		VIPSalesPage.contents.SBSIStrategicIntent2.click();
		VIPSalesPage.contents.SBSISupportingInsightText.verifyText(SI5, false);
		String SI6 = VIPSalesPage.contents.SBSISupportingInsightText.getText();
		VIPSalesPage.contents.SBSIStrategicIntent3.click();
		VIPSalesPage.contents.SBSISupportingInsightText.verifyText(SI6, false);
		WebControl.takeScreenshot("Sales_Reg_Auto_009");
		
		ReportLog.setTestCase("Sales_Reg_Auto_010");
		VIPSalesPage.contents.GrayLine1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.GrayLine2.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_010");
		
		ReportLog.setTestCase("Sales_Reg_Auto_011");
		VIPSalesPage.contents.CRStrategicIntent1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRStrategicIntent5.verifyDisplayed(false);
		VIPSalesPage.contents.RGStrategicIntent1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGStrategicIntent5.verifyDisplayed(false);
		VIPSalesPage.contents.SBSIStrategicIntent1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent2.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent3.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent4.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSIStrategicIntent5.verifyDisplayed(false);
		WebControl.takeScreenshot("Sales_Reg_Auto_011");
		
		ReportLog.setTestCase("Sales_Reg_Auto_013");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.SideMenuTranscript.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 200);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPTranscriptPage.contents.EventTypeEarningsCall.click();
		VIPTranscriptPage.contents.FirstTranscriptTitle.waitForExist(true, 10);
		String EarningsCall = VIPTranscriptPage.contents.FirstTranscriptTitle.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.ClientPriorities.click();
		VIPSalesPage.contents.FootNote.waitForExist(true, 10);
		VIPSalesPage.contents.FootNote.verifyText("Source: " + EarningsCall + "; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_013");
		
		ReportLog.setTestCase("Sales_Reg_Auto_012");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.noTransCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.VPSegment1.waitForExist(true, 60);
		VIPSalesPage.contents.ClientPriorities.click();
		Thread.sleep(2000);
		VIPSalesPage.contents.CRNoData.verifyDisplayed(true, 10);
		VIPSalesPage.contents.CRNoData.verifyText("No Clear Guidance Available.");
		VIPSalesPage.contents.RGNoData.verifyDisplayed(true, 10);
		VIPSalesPage.contents.RGNoData.verifyText("No Clear Guidance Available.");
		VIPSalesPage.contents.SBSINoData.verifyDisplayed(true, 10);
		VIPSalesPage.contents.SBSINoData.verifyText("No Clear Guidance Available.");
		WebControl.takeScreenshot("Sales_Reg_Auto_012");
		
		ReportLog.setTestCase("Sales_Reg_Auto_014_1_&_017");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Facebook");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuSales.click();
		Thread.sleep(3000);
		if (testDataHandler.ShowOppNavModal.equals("Yes")) {
		VIPSalesPage.contents.OppNavModalCloseButton.click();}
		VIPSalesPage.contents.ClientPriorities.click();
		Thread.sleep(3000);
		if (VIPSalesPage.contents.CRStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.CRSTITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSUITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.RGSUITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISUITooltipIcon.verifyDisplayed(false);}
		else if (VIPSalesPage.contents.RGStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.RGSTITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.RGSUITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.CRSUITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.SBSISUITooltipIcon.verifyDisplayed(false);}
		else {VIPSalesPage.contents.SBSISTITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SBSISUITooltipIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CRSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.CRSUITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.RGSTITooltipIcon.verifyDisplayed(false);
		VIPSalesPage.contents.RGSUITooltipIcon.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_014_1_&_017");
		
		ReportLog.setTestCase("Sales_Reg_Auto_014_2");
		if (VIPSalesPage.contents.CRStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.CRSTITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.stiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_2_1");
		VIPSalesPage.contents.CRSTITooltipIcon.click();}
		else if (VIPSalesPage.contents.RGStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.RGSTITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.stiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_2_2");
		VIPSalesPage.contents.RGSTITooltipIcon.click();}
		else if (VIPSalesPage.contents.SBSIStrategicIntent.isDisplayed()) {
		VIPSalesPage.contents.SBSISTITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.stiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_2_3");
		VIPSalesPage.contents.SBSISTITooltipIcon.click();}
		
		ReportLog.setTestCase("Sales_Reg_Auto_014_3");
		if (VIPSalesPage.contents.CRSupportingInsight.isDisplayed()) {
		VIPSalesPage.contents.CRSUITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.suiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_3_1");
		VIPSalesPage.contents.CRSUITooltipIcon.click();}
		else if (VIPSalesPage.contents.RGSupportingInsight.isDisplayed()) {
		VIPSalesPage.contents.RGSUITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.suiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_3_2");
		VIPSalesPage.contents.RGSUITooltipIcon.click();}
		else if (VIPSalesPage.contents.SBSISupportingInsight.isDisplayed()) {
		VIPSalesPage.contents.SBSISUITooltipIcon.click();
		VIPSalesPage.contents.TooltipText.verifyDisplayed(true, 5);
		VIPSalesPage.contents.TooltipText.verifyText(testDataHandler.suiTooltip);
		WebControl.takeScreenshot("Sales_Reg_Auto_014_3_3");
		VIPSalesPage.contents.SBSISUITooltipIcon.click();}
		
		ReportLog.setTestCase("Sales_Reg_Auto_015");
		String RGStrategicIntentText1_1 = VIPSalesPage.contents.RGStrategicIntentText1.getText();
		int Length1 = RGStrategicIntentText1_1.length();
		String RGStrategicIntentText1_2 = RGStrategicIntentText1_1.substring(0, Length1 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText1.verifyText(RGStrategicIntentText1_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText1.verifyText(RGStrategicIntentText1_2 + "...");}
		
		String RGStrategicIntentText2_1 = VIPSalesPage.contents.RGStrategicIntentText2.getText();
		int Length2 = RGStrategicIntentText2_1.length();
		String RGStrategicIntentText2_2 = RGStrategicIntentText2_1.substring(0, Length2 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText2.verifyText(RGStrategicIntentText2_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText2.verifyText(RGStrategicIntentText2_2 + "...");}
		
		String RGStrategicIntentText3_1 = VIPSalesPage.contents.RGStrategicIntentText3.getText();
		int Length3 = RGStrategicIntentText3_1.length();
		String RGStrategicIntentText3_2 = RGStrategicIntentText3_1.substring(0, Length3 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText3.verifyText(RGStrategicIntentText3_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText3.verifyText(RGStrategicIntentText3_2 + "...");}
		
		String RGStrategicIntentText4_1 = VIPSalesPage.contents.RGStrategicIntentText4.getText();
		int Length4 = RGStrategicIntentText4_1.length();
		String RGStrategicIntentText4_2 = RGStrategicIntentText4_1.substring(0, Length4 - 3);
		if (Length1 < 133) {
		VIPSalesPage.contents.RGStrategicIntentText4.verifyText(RGStrategicIntentText4_1);}
		else {VIPSalesPage.contents.RGStrategicIntentText4.verifyText(RGStrategicIntentText4_2 + "...");}
		WebControl.takeScreenshot("Sales_Reg_Auto_015");
		
	}
	
}


