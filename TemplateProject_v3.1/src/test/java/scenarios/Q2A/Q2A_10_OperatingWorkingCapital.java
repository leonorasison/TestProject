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

public class Q2A_10_OperatingWorkingCapital extends TestBase{
	
	@Test
	public void Q2A_OperatingWorkingCapital () throws Exception {
		ReportLog.setTestName("Q2A - Operating Working Capital Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		int OneYrAgo = Q2A_09_PreTaxROIC.get1YearAgo();
		String OneYear = String.valueOf(OneYrAgo);
		int TwoYrsAgo = Q2A_09_PreTaxROIC.get2YearsAgo();
		String TwoYears = String.valueOf(TwoYrsAgo);
		
		ReportLog.setTestCase("Q2A_Reg_Auto_092");
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
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		VIPFinancialsPage.contents.LeftHandChartHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.LeftHandChartHeader.verifyText("OPERATING WORKING CAPITAL DECOMPOSITION");
		VIPFinancialsPage.contents.LeftHandChartNote.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.LeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPFinancialsPage.contents.RightHandChartHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_092");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_093");
		VIPFinancialsPage.contents.PeerComparisonToggle.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.PeerComparisonToggleLabel.verifyText("Detailed Peer Comparison");
		WebControl.takeScreenshot("Q2A_Reg_Auto_093");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_094");
		VIPFinancialsPage.contents.WorkCapRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OpeCurAssRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NetRecRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherCurAssRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.AccPayRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IncTaxPayRevBox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherCurLiaRevBox.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_094");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_095");
		VIPFinancialsPage.contents.OpeCurAssRevBox.hover();
		VIPFinancialsPage.contents.OpeCurAssRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.hover();
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.CashRevBox.hover();
		VIPFinancialsPage.contents.CashRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("CASH / REVENUE");
		VIPFinancialsPage.contents.NetRecRevBox.hover();
		VIPFinancialsPage.contents.NetRecRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPFinancialsPage.contents.InventoryRevBox.hover();
		VIPFinancialsPage.contents.InventoryRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("INVENTORY / REVENUE");
		VIPFinancialsPage.contents.OtherCurAssRevBox.hover();
		VIPFinancialsPage.contents.OtherCurAssRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPFinancialsPage.contents.AccPayRevBox.hover();
		VIPFinancialsPage.contents.AccPayRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPFinancialsPage.contents.IncTaxPayRevBox.hover();
		VIPFinancialsPage.contents.IncTaxPayRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		//VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherCurLiaRevBox.hover();
		VIPFinancialsPage.contents.OtherCurLiaRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.WorkCapRevBox.hover();
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_095");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_096");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.WorkCapReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.WorkCapReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.WCRTooltip);
		VIPFinancialsPage.contents.WorkCapReviIcon.click();
		VIPFinancialsPage.contents.CashReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.CashReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.CRTooltip);
		VIPFinancialsPage.contents.CashReviIcon.click();
		VIPFinancialsPage.contents.NetRecReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.NetRecReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.NRTooltip);
		VIPFinancialsPage.contents.NetRecReviIcon.click();
		VIPFinancialsPage.contents.InventoryReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.InventoryReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.IRTooltip);
		VIPFinancialsPage.contents.InventoryReviIcon.click();
		VIPFinancialsPage.contents.AccPayReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.AccPayReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.APRTooltip);
		VIPFinancialsPage.contents.AccPayReviIcon.click();
		VIPFinancialsPage.contents.IncTaxPayReviIcon.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.IncTaxPayReviIcon.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.ITPRTooltip);
		VIPFinancialsPage.contents.IncTaxPayReviIcon.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_096");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_097");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		//VIPFinancialsPage.contents.BestandRankCheckbox.click();
		//Year Period
		String CurrentYear_1 = VIPFinancialsPage.contents.ScoreCardDate.getText();
		String CurrentYear_2[] = CurrentYear_1.split("\\/");
		String CurrentYear_3 = CurrentYear_2[1].replace("]", "");
		int CurrentYear = Integer.parseInt(CurrentYear_3);
		int LastYear = CurrentYear - 1;
		int Last2Year = CurrentYear - 2;
		//WorCapRev KPI
		String WorCapRevKPI2_1 = VIPFinancialsPage.contents.WorCapRevKPI2.getText();
		String WorCapRevKPI2_2 = WorCapRevKPI2_1.replace("%", "");
		Double WorCapRevKPI2_3 = Double.parseDouble(WorCapRevKPI2_2);
		//WorCapRev Peer Median
		String WorCapRevKPIP2_1 = VIPFinancialsPage.contents.WorCapRevKPIP2.getText();
		String WorCapRevKPIP2_2 = WorCapRevKPIP2_1.replace("%", "");
		Double WorCapRevKPIP2_3 = Double.parseDouble(WorCapRevKPIP2_2);
		//WorCapRev Best
		String WorCapRevBest1 = VIPFinancialsPage.contents.WorCapRevBest.getText();
		String WorCapRevBest2 = WorCapRevBest1.replace("%", "");
		Double WorCapRevBest3 = Double.parseDouble(WorCapRevBest2);
		VIPFinancialsPage.contents.WorCapRevBest.hover();
		String WorCapRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String WorCapRevBest1_2 = WorCapRevBest1_1.replace(WorCapRevBest1, "");
		String WorCapRevBest1_3 = WorCapRevBest1_2.replace(" : ", "");
		//WorCapRev Rank
		String WorCapRevRank1 = VIPFinancialsPage.contents.WorCapRevRank.getText();
		String[] WorCapRevRank2 = WorCapRevRank1.split("\\/");
		String WorCapRevRank2_1 = WorCapRevRank2[0];
		String WorCapRevRank2_2 = WorCapRevRank2[1];
		String WorCapRevRank2_3 = WorCapRevRank2_1.replace(" ", "");
		String WorCapRevRank2_4 = WorCapRevRank2_2.replace(" ", "");
		Double WorCapRevRank3_1 = Double.parseDouble(WorCapRevRank2_3);
		Double WorCapRevRank3_2 = Double.parseDouble(WorCapRevRank2_4);
		Double WorCapRevRank3 = (WorCapRevRank3_1/WorCapRevRank3_2);
		//WorCapRev 2 year Change
		String WorCapRev2YrChange1 = VIPFinancialsPage.contents.WorCapRev2YrChange.getText();
		String WorCapRev2YrChange2 = WorCapRev2YrChange1.replace("pps", "");
		String WorCapRev2YrChange3 = WorCapRev2YrChange2.replace("+", "");
		String WorCapRev2YrChange4 = WorCapRev2YrChange3.replace("-", "");
		Double WorCapRev2YrChange5 = Double.parseDouble(WorCapRev2YrChange4);
		Double WorCapRev2YrChange6 = Double.parseDouble(WorCapRev2YrChange3);
		//WorCapRev BigDecimal
		BigDecimal WorCapRevKPI_KPIP_1 = new BigDecimal(WorCapRevKPI2_3 - WorCapRevKPIP2_3);
		BigDecimal WorCapRevKPIP_KPI_1 = new BigDecimal(WorCapRevKPIP2_3 - WorCapRevKPI2_3);
		BigDecimal WorCapRevKPI_KPIP_2 = WorCapRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal WorCapRevKPIP_KPI_2 = WorCapRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal WorCapRevKPI_2YrCM_1 = new BigDecimal(WorCapRevKPI2_3 - WorCapRev2YrChange5);
		BigDecimal WorCapRevKPI_2YrCP_1 = new BigDecimal(WorCapRevKPI2_3 + WorCapRev2YrChange5);
		BigDecimal WorCapRevKPI_2YrCM_2 = WorCapRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal WorCapRevKPI_2YrCP_2 = WorCapRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//NetRecRev KPI
		String NetRecRevKPI2_1 = VIPFinancialsPage.contents.NetRecRevKPI2.getText();
		String NetRecRevKPI2_2 = NetRecRevKPI2_1.replace("%", "");
		Double NetRecRevKPI2_3 = Double.parseDouble(NetRecRevKPI2_2);
		//NetRecRev Peer Median
		String NetRecRevKPIP2_1 = VIPFinancialsPage.contents.NetRecRevKPIP2.getText();
		String NetRecRevKPIP2_2 = NetRecRevKPIP2_1.replace("%", "");
		Double NetRecRevKPIP2_3 = Double.parseDouble(NetRecRevKPIP2_2);
		//NetRecRev Best
		String NetRecRevBest1 = VIPFinancialsPage.contents.NetRecRevBest.getText();
		String NetRecRevBest2 = NetRecRevBest1.replace("%", "");
		Double NetRecRevBest3 = Double.parseDouble(NetRecRevBest2);
		VIPFinancialsPage.contents.NetRecRevBest.hover();
		String NetRecRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String NetRecRevBest1_2 = NetRecRevBest1_1.replace(NetRecRevBest1, "");
		String NetRecRevBest1_3 = NetRecRevBest1_2.replace(" : ", "");
		//NetRecRev Rank
		String NetRecRevRank1 = VIPFinancialsPage.contents.NetRecRevRank.getText();
		String[] NetRecRevRank2 = NetRecRevRank1.split("\\/");
		String NetRecRevRank2_1 = NetRecRevRank2[0];
		String NetRecRevRank2_2 = NetRecRevRank2[1];
		String NetRecRevRank2_3 = NetRecRevRank2_1.replace(" ", "");
		String NetRecRevRank2_4 = NetRecRevRank2_2.replace(" ", "");
		Double NetRecRevRank3_1 = Double.parseDouble(NetRecRevRank2_3);
		Double NetRecRevRank3_2 = Double.parseDouble(NetRecRevRank2_4);
		Double NetRecRevRank3 = (NetRecRevRank3_1/NetRecRevRank3_2);
		//NetRecRev 2 year Change
		String NetRecRev2YrChange1 = VIPFinancialsPage.contents.NetRecRev2YrChange.getText();
		String NetRecRev2YrChange2 = NetRecRev2YrChange1.replace("pps", "");
		String NetRecRev2YrChange3 = NetRecRev2YrChange2.replace("+", "");
		String NetRecRev2YrChange4 = NetRecRev2YrChange3.replace("-", "");
		Double NetRecRev2YrChange5 = Double.parseDouble(NetRecRev2YrChange4);
		Double NetRecRev2YrChange6 = Double.parseDouble(NetRecRev2YrChange3);
		//NetRecRev BigDecimal
		BigDecimal NetRecRevKPI_KPIP_1 = new BigDecimal(NetRecRevKPI2_3 - NetRecRevKPIP2_3);
		BigDecimal NetRecRevKPIP_KPI_1 = new BigDecimal(NetRecRevKPIP2_3 - NetRecRevKPI2_3);
		BigDecimal NetRecRevKPI_KPIP_2 = NetRecRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetRecRevKPIP_KPI_2 = NetRecRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetRecRevKPI_2YrCM_1 = new BigDecimal(NetRecRevKPI2_3 - NetRecRev2YrChange5);
		BigDecimal NetRecRevKPI_2YrCP_1 = new BigDecimal(NetRecRevKPI2_3 + NetRecRev2YrChange5);
		BigDecimal NetRecRevKPI_2YrCM_2 = NetRecRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal NetRecRevKPI_2YrCP_2 = NetRecRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//InvRev KPI
		String InvRevKPI2_1 = VIPFinancialsPage.contents.InvRevKPI2.getText();
		String InvRevKPI2_2 = InvRevKPI2_1.replace("%", "");
		Double InvRevKPI2_3 = Double.parseDouble(InvRevKPI2_2);
		//InvRev Peer Median
		String InvRevKPIP2_1 = VIPFinancialsPage.contents.InvRevKPIP2.getText();
		String InvRevKPIP2_2 = InvRevKPIP2_1.replace("%", "");
		Double InvRevKPIP2_3 = Double.parseDouble(InvRevKPIP2_2);
		//InvRev Best
		String InvRevBest1 = VIPFinancialsPage.contents.InvRevBest.getText();
		String InvRevBest2 = InvRevBest1.replace("%", "");
		Double InvRevBest3 = Double.parseDouble(InvRevBest2);
		VIPFinancialsPage.contents.InvRevBest.hover();
		String InvRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String InvRevBest1_2 = InvRevBest1_1.replace(InvRevBest1, "");
		String InvRevBest1_3 = InvRevBest1_2.replace(" : ", "");
		//InvRev Rank
//		String InvRevRank1 = VIPFinancialsPage.contents.InvRevRank.getText();
//		String[] InvRevRank2 = InvRevRank1.split("\\/");
//		String InvRevRank2_1 = InvRevRank2[0];
//		String InvRevRank2_2 = InvRevRank2[1];
//		String InvRevRank2_3 = InvRevRank2_1.replace(" ", "");
//		String InvRevRank2_4 = InvRevRank2_2.replace(" ", "");
//		Double InvRevRank3_1 = Double.parseDouble(InvRevRank2_3);
//		Double InvRevRank3_2 = Double.parseDouble(InvRevRank2_4);
//		Double InvRevRank3 = (InvRevRank3_1/InvRevRank3_2);
		//InvRev 2 year Change
		String InvRev2YrChange1 = VIPFinancialsPage.contents.InvRev2YrChange.getText();
		String InvRev2YrChange2 = InvRev2YrChange1.replace("pps", "");
		String InvRev2YrChange3 = InvRev2YrChange2.replace("+", "");
		String InvRev2YrChange4 = InvRev2YrChange3.replace("-", "");
		Double InvRev2YrChange5 = Double.parseDouble(InvRev2YrChange4);
		Double InvRev2YrChange6 = Double.parseDouble(InvRev2YrChange3);
		//InvRev BigDecimal
		BigDecimal InvRevKPI_KPIP_1 = new BigDecimal(InvRevKPI2_3 - InvRevKPIP2_3);
		BigDecimal InvRevKPIP_KPI_1 = new BigDecimal(InvRevKPIP2_3 - InvRevKPI2_3);
		BigDecimal InvRevKPI_KPIP_2 = InvRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal InvRevKPIP_KPI_2 = InvRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal InvRevKPI_2YrCM_1 = new BigDecimal(InvRevKPI2_3 - InvRev2YrChange5);
		BigDecimal InvRevKPI_2YrCP_1 = new BigDecimal(InvRevKPI2_3 + InvRev2YrChange5);
		BigDecimal InvRevKPI_2YrCM_2 = InvRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal InvRevKPI_2YrCP_2 = InvRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//AccPayRev KPI
		String AccPayRevKPI2_1 = VIPFinancialsPage.contents.AccPayRevKPI2.getText();
		String AccPayRevKPI2_2 = AccPayRevKPI2_1.replace("%", "");
		Double AccPayRevKPI2_3 = Double.parseDouble(AccPayRevKPI2_2);
		//AccPayRev Peer Median
		String AccPayRevKPIP2_1 = VIPFinancialsPage.contents.AccPayRevKPIP2.getText();
		String AccPayRevKPIP2_2 = AccPayRevKPIP2_1.replace("%", "");
		Double AccPayRevKPIP2_3 = Double.parseDouble(AccPayRevKPIP2_2);
		//AccPayRev Best
		String AccPayRevBest1 = VIPFinancialsPage.contents.AccPayRevBest.getText();
		String AccPayRevBest2 = AccPayRevBest1.replace("%", "");
		Double AccPayRevBest3 = Double.parseDouble(AccPayRevBest2);
		VIPFinancialsPage.contents.AccPayRevBest.hover();
		String AccPayRevBest1_1 = VIPFinancialsPage.contents.BestTooltip.getText();
		String AccPayRevBest1_2 = AccPayRevBest1_1.replace(AccPayRevBest1, "");
		String AccPayRevBest1_3 = AccPayRevBest1_2.replace(" : ", "");
		//AccPayRev Rank
		String AccPayRevRank1 = VIPFinancialsPage.contents.AccPayRevRank.getText();
		String[] AccPayRevRank2 = AccPayRevRank1.split("\\/");
		String AccPayRevRank2_1 = AccPayRevRank2[0];
		String AccPayRevRank2_2 = AccPayRevRank2[1];
		String AccPayRevRank2_3 = AccPayRevRank2_1.replace(" ", "");
		String AccPayRevRank2_4 = AccPayRevRank2_2.replace(" ", "");
		Double AccPayRevRank3_1 = Double.parseDouble(AccPayRevRank2_3);
		Double AccPayRevRank3_2 = Double.parseDouble(AccPayRevRank2_4);
		Double AccPayRevRank3 = (AccPayRevRank3_1/AccPayRevRank3_2);
		//AccPayRev 2 year Change
		String AccPayRev2YrChange1 = VIPFinancialsPage.contents.AccPayRev2YrChange.getText();
		String AccPayRev2YrChange2 = AccPayRev2YrChange1.replace("pps", "");
		String AccPayRev2YrChange3 = AccPayRev2YrChange2.replace("+", "");
		String AccPayRev2YrChange4 = AccPayRev2YrChange3.replace("-", "");
		Double AccPayRev2YrChange5 = Double.parseDouble(AccPayRev2YrChange4);
		Double AccPayRev2YrChange6 = Double.parseDouble(AccPayRev2YrChange3);
		//AccPayRev BigDecimal
		BigDecimal AccPayRevKPI_KPIP_1 = new BigDecimal(AccPayRevKPI2_3 - AccPayRevKPIP2_3);
		BigDecimal AccPayRevKPIP_KPI_1 = new BigDecimal(AccPayRevKPIP2_3 - AccPayRevKPI2_3);
		BigDecimal AccPayRevKPI_KPIP_2 = AccPayRevKPI_KPIP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal AccPayRevKPIP_KPI_2 = AccPayRevKPIP_KPI_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal AccPayRevKPI_2YrCM_1 = new BigDecimal(AccPayRevKPI2_3 - AccPayRev2YrChange5);
		BigDecimal AccPayRevKPI_2YrCP_1 = new BigDecimal(AccPayRevKPI2_3 + AccPayRev2YrChange5);
		BigDecimal AccPayRevKPI_2YrCM_2 = AccPayRevKPI_2YrCM_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal AccPayRevKPI_2YrCP_2 = AccPayRevKPI_2YrCP_1.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		//Final Best Values - WorCapRev
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(WorCapRevBest1_3);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		String WorCapRevBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String WorCapRevBestFinal_2[] = WorCapRevBestFinal_1.split("\\|");
		String WorCapRevBestFinal_3 = WorCapRevBestFinal_2[0];
		String WorCapRevBestFinal = WorCapRevBestFinal_3.substring(0, WorCapRevBestFinal_3.length() - 1);
		//Final Best Values - NetRecRev
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(NetRecRevBest1_3);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		String NetRecRevBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String NetRecRevBestFinal_2[] = NetRecRevBestFinal_1.split("\\|");
		String NetRecRevBestFinal_3 = NetRecRevBestFinal_2[0];
		String NetRecRevBestFinal = NetRecRevBestFinal_3.substring(0, NetRecRevBestFinal_3.length() - 1);
		//Final Best Values - InvRev
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(InvRevBest1_3);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		String InvRevBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String InvRevBestFinal_2[] = InvRevBestFinal_1.split("\\|");
		String InvRevBestFinal_3 = InvRevBestFinal_2[0];
		String InvRevBestFinal = InvRevBestFinal_3.substring(0, InvRevBestFinal_3.length() - 1);
		//Final Best Values - AccPayRev
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(AccPayRevBest1_3);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		String AccPayRevBestFinal_1 = VIPLandingPage.contents.CompanyTypeAhead.getText();
		String AccPayRevBestFinal_2[] = AccPayRevBestFinal_1.split("\\|");
		String AccPayRevBestFinal_3 = AccPayRevBestFinal_2[0];
		String AccPayRevBestFinal = AccPayRevBestFinal_3.substring(0, AccPayRevBestFinal_3.length() - 1);
		VIPLandingPage.contents.CompanyNameTextbox.clear();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		//WorCapRev
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 20);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 15);
		VIPFinancialsPage.contents.ScoreCardDate.waitForExist(true, 15);
		String[] Period1 = VIPFinancialsPage.contents.ScoreCardDate.getText().split("\\/");
		String Period2 = Period1[1].replace("]", "");
		int Period = Integer.parseInt(Period2);
		int Period_1 = Period - 1;
		int Period_2 = Period - 2;
		String Period_1yr = Integer.toString(Period_1);
		String Period_2yr = Integer.toString(Period_2);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		if (WorCapRevKPI2_3 > WorCapRevKPIP2_3) {
		VIPFinancialsPage.contents.WorkCapRevRedIcon.verifyDisplayed(true, 5);}
		else if (WorCapRevKPI2_3 < WorCapRevKPIP2_3) {
		VIPFinancialsPage.contents.WorkCapRevGreenIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.WorkCapRevYellowIcon.verifyDisplayed(true, 5);}
		//OpeCurAssRev, NonIntBearLiabRev, CashRev
		VIPFinancialsPage.contents.OpeCurAssRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.NonIntBearLiabRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashRevGaugeIcon.verifyDisplayed(true, 5);
		//NetRecRev
		if (NetRecRevKPI2_3 > NetRecRevKPIP2_3) {
		VIPFinancialsPage.contents.NetRecRevRedIcon.verifyDisplayed(true, 5);}
		else if (NetRecRevKPI2_3 < NetRecRevKPIP2_3) {
		VIPFinancialsPage.contents.NetRecRevGreenIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.NetRecRevYellowIcon.verifyDisplayed(true, 5);}
		//InvRev
		if (InvRevKPI2_3 > InvRevKPIP2_3) {
		VIPFinancialsPage.contents.InvRevRedIcon.verifyDisplayed(true, 5);}
		else if (InvRevKPI2_3 < InvRevKPIP2_3) {
		VIPFinancialsPage.contents.InvRevGreenIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.InvRevYellowIcon.verifyDisplayed(true, 5);}
		//OtherCurAssRev
		VIPFinancialsPage.contents.OtherCurAssRevGaugeIcon.verifyDisplayed(true, 5);
		//AccPayRev
		if (AccPayRevKPI2_3 > AccPayRevKPIP2_3) {
		VIPFinancialsPage.contents.AccPayRevGreenIcon.verifyDisplayed(true, 5);}
		else if (AccPayRevKPI2_3 < AccPayRevKPIP2_3) {
		VIPFinancialsPage.contents.AccPayRevRedIcon.verifyDisplayed(true, 5);}
		else {VIPFinancialsPage.contents.AccPayRevYellowIcon.verifyDisplayed(true, 5);}
		//IncTaxPayRev, OtherCurLiaRev
		VIPFinancialsPage.contents.IncTaxPayRevGaugeIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.OtherCurLiaRevGaugeIcon.verifyDisplayed(true, 5);
		//Legend
		VIPFinancialsPage.contents.WCRTargetCompLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRTargetCompLegendText.verifyText(testDataHandler.company);
		VIPFinancialsPage.contents.WCRPeerMedianLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRPeerMedianLegendText.verifyText("Peer Median");
		VIPFinancialsPage.contents.WCRBetterLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRBetterLegendText.verifyText("Better than peer median");
		VIPFinancialsPage.contents.WCRWorseLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRWorseLegendText.verifyText("Worse than peer median");
		VIPFinancialsPage.contents.WCRInlineLegend.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.WCRInlineLegendText.verifyText("In-line with peer median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_097");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_100");
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.FirstPeriodHeader.verifyText(Period_2yr);
		VIPFinancialsPage.contents.SecondPeriodHeader.verifyText(Period_1yr);
		VIPFinancialsPage.contents.ThirdPeriodHeader.verifyText("TTM");
		VIPFinancialsPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_100");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_101");
		VIPFinancialsPage.contents.SelectIndicatorDropdown.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndWorkCapRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOpeCurAssRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndNonIntBearLiabRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndCashRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndNetRecRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndInventoryRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOtherCurAssRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndAccPayRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndIncTaxPayRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndOtherCurLiaRev.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.IndWorkCapRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + WorCapRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOpeCurAssRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndCashRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("CASH / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNetRecRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + NetRecRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndInventoryRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("INVENTORY / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + InvRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOtherCurAssRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndNonIntBearLiabRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndAccPayRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyText("Peer Median: " + AccPayRevKPIP2_1);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndIncTaxPayRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SelectIndicatorDropdown.click();
		VIPFinancialsPage.contents.IndOtherCurLiaRev.click();
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		VIPFinancialsPage.contents.FirstPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SecondPeriodPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ThirdPeriodPeerMedian.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_101");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_WorCapRev");
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		//WorCapRev
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);    
		if (WorCapRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue decreased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + WorCapRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (WorCapRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue increased by " + WorCapRev2YrChange5 + " pps over the last 2 years from " + (WorCapRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + WorCapRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Working Capital/Revenue remained constant at " + WorCapRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (WorCapRevKPI2_3 > WorCapRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is higher than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Working Capital/Revenue in TTM is lower than the peer median of " + WorCapRevKPIP2_3 + "%" + " by " + WorCapRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(WorCapRevBestFinal + " (" + WorCapRevBest3 + "%) " + "ranked the best in terms of Working Capital/Revenue in TTM");
		//Footnote
		String FootNote00_1 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_1.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_1 + " Working Capital / Revenue uses working capital value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Working Capital / Revenue uses working capital value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String WCRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String WCRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String WCRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String WCRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_WorCapRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_NetRecRev");
		//NetRecRev
		VIPFinancialsPage.contents.NetRecRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (NetRecRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue decreased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + NetRecRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (NetRecRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue increased by " + NetRecRev2YrChange5 + " pps over the last 2 years from " + (NetRecRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + NetRecRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Net Receivables/Revenue remained constant at " + NetRecRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (NetRecRevKPI2_3 > NetRecRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in TTM is higher than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Net Receivables/Revenue in TTM is lower than the peer median of " + NetRecRevKPIP2_3 + "%" + " by " + NetRecRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(NetRecRevBestFinal + " (" + NetRecRevBest3 + "%) " + "ranked the best in terms of Net Receivables/Revenue in TTM");
		//Footnote
		String FootNote00_2 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_2.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_2 + " Net Receivables / Revenue uses net receivables value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Net Receivables / Revenue uses net receivables value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String NRRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String NRRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String NRRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String NRRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_NetRecRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_InvRev");
		//InvRev
		VIPFinancialsPage.contents.InventoryRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (InvRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue decreased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + InvRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else if (InvRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue increased by " + InvRev2YrChange5 + " pps over the last 2 years from " + (InvRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + InvRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Inventory/Revenue remained constant at " + InvRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (InvRevKPI2_3 > InvRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in TTM is higher than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Inventory/Revenue in TTM is lower than the peer median of " + InvRevKPIP2_3 + "%" + " by " + InvRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(InvRevBestFinal + " (" + InvRevBest3 + "%) " + "ranked the best in terms of Inventory/Revenue in TTM");
		//Footnote
		String FootNote00_3 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_3.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_3 + " Inventory / Revenue uses inventory value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Inventory / Revenue uses inventory value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String IRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String IRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String IRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String IRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_InvRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_AccPayRev");
		//AccPayRev
		VIPFinancialsPage.contents.AccPayRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		if (AccPayRev2YrChange6 < 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue decreased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCP_2) + "% in " + Last2Year + " to " + AccPayRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfRedIcon.verifyDisplayed(true, 3);}
		else if (AccPayRev2YrChange6 > 0) {																					
		VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue increased by " + AccPayRev2YrChange5 + " pps over the last 2 years from " + (AccPayRevKPI_2YrCM_2) + "% in " + Last2Year + " to " + AccPayRevKPI2_3 + "% in TTM");
		VIPFinancialsPage.contents.StandalonePerfGreenIcon.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.StandalonePerf.verifyText(testDataHandler.company + "’s Accounts Payable/Revenue remained constant at " + AccPayRevKPI2_3 + "% over the last 2 years");
		VIPFinancialsPage.contents.StandalonePerfYellowIcon.verifyDisplayed(true, 3);}
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		if (AccPayRevKPI2_3 > AccPayRevKPIP2_3) {
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in TTM is higher than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPI_KPIP_2 + " pps");
		VIPFinancialsPage.contents.CompPosGreenIcon1.verifyDisplayed(true, 3);}
		else {VIPFinancialsPage.contents.CompetitivePosition1.verifyText("The company’s Accounts Payable/Revenue in TTM is lower than the peer median of " + AccPayRevKPIP2_3 + "%" + " by " + AccPayRevKPIP_KPI_2 + " pps");
		VIPFinancialsPage.contents.CompPosRedIcon1.verifyDisplayed(true, 3);}
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClass.verifyText(AccPayRevBestFinal + " (" + AccPayRevBest3 + "%) " + "ranked the best in terms of Accounts Payable/Revenue in TTM");
		//Footnote
		String FootNote00_4 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_4.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_4 + " Accounts Payable / Revenue uses accounts payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Accounts Payable / Revenue uses accounts payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String APRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String APRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String APRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String APRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_AccPayRev");	
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_OpeCurAssRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//OpeCurAssRev
		VIPFinancialsPage.contents.OpeCurAssRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_5 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_5.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_5 + " Operating Current Assets / Revenue uses operating current assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Operating Current Assets / Revenue uses operating current assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String OCARSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OCARCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OCARBest = VIPFinancialsPage.contents.BestInClass.getText();
		String OCARFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_OpeCurAssRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_NonIntBeaLiaRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//NonIntBeaLiaRev
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_6 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_6.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_6 + " Non-Interest Bearing Liabilities / Revenue uses non-interest bearing liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Non-Interest Bearing Liabilities / Revenue uses non-interest bearing liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String NIBLRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String NIBLRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String NIBLRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String NIBLRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_NonIntBeaLiaRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_CashRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//CashRev
		VIPFinancialsPage.contents.CashRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_7 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_7.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_7 + " Cash / Revenue uses cash value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Cash / Revenue uses cash value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String CRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String CRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String CRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_CashRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_OthCurAssRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//OthCurAssRev
		VIPFinancialsPage.contents.OtherCurAssRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_8 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_8.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_8 + " Other Current Assets / Revenue uses other cur. assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Other Current Assets / Revenue uses other cur. assets value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String OCAR1SP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OCAR1CP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OCAR1Best = VIPFinancialsPage.contents.BestInClass.getText();
		String OCAR1Footnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_OthCurAssRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_IncTaxPayRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//IncTaxPayRev
		VIPFinancialsPage.contents.IncTaxPayRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_9 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_9.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_9 + " Income Taxes Payable / Revenue uses income taxes payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Income Taxes Payable / Revenue uses income taxes payable value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String ITPRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String ITPRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String ITPRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String ITPRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_IncTaxPayRev");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_103_&_104_OtherCurLiaRev");
		VIPLandingPage.contents.HelpIcon.hover();
		//OtherCurLiaRev
		VIPFinancialsPage.contents.OtherCurLiaRevBox.click();
		//Stand Alone
		VIPFinancialsPage.contents.StandalonePerfHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.StandalonePerfIcon.verifyDisplayed(true, 3);
		//Competitive Position 1st Bullet
		VIPFinancialsPage.contents.CompetitivePositionHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CompPosIcon1.verifyDisplayed(true, 3);
		//Best in Class
		VIPFinancialsPage.contents.BestInClassHeader.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.BestInClassIcon.verifyDisplayed(true, 5);
		//Footnote
		String FootNote00_10 = VIPFinancialsPage.contents.FootNote00.getText();
		if (FootNote00_10.contains("Note: Companies with no financial data are excluded")) {
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote00_10 + " Other Current Liabilities / Revenue uses other current liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		else {VIPFinancialsPage.contents.FootNote.verifyText("Note:" + " Other Current Liabilities / Revenue uses other current liabilities value averaged over two periods for KPI calculation. For further details, you may refer to the Methodology. Currency conversion is based on a floating exchange rate as on the relevant period end date, as reported by S&P Global");}
		//TestData
		String OCLRSP = VIPFinancialsPage.contents.StandalonePerf.getText();
		String OCLRCP1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String OCLRBest = VIPFinancialsPage.contents.BestInClass.getText();
		String OCLRFootnote = VIPFinancialsPage.contents.FootNote.getText();
		VIPFinancialsPage.contents.FootNoteMethodologyLink.click();
		VIPFinancialsPage.contents.MethodologyTitle.waitForExist(true, 10);
		VIPFinancialsPage.contents.MethodologyTitle.verifyText("METHODOLOGY");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		WebControl.takeScreenshot("Q2A_Reg_Auto_103_&_104_OtherCurLiaRev");
			
		ReportLog.setTestCase("Q2A_Reg_Auto_105");
		VIPFinancialsPage.contents.CashRevBox.click();
		String StandalonePerf = VIPFinancialsPage.contents.StandalonePerf.getText();
		String CompetitivePosition1 = VIPFinancialsPage.contents.CompetitivePosition1.getText();
		String BestInClass = VIPFinancialsPage.contents.BestInClass.getText();
		String RightHandChartHeader = VIPFinancialsPage.contents.RightHandChartHeader.getText();
		String FootNote2 = VIPFinancialsPage.contents.FootNote.getText();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote2);
		VIPFinancialsPage.contents.FootNote.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DetailedChartHeader.verifyText(RightHandChartHeader);
		VIPFinancialsPage.contents.PeerComparisonToggle.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(StandalonePerf);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CompetitivePosition1);
		VIPFinancialsPage.contents.BestInClass.verifyText(BestInClass);
		VIPFinancialsPage.contents.FootNote.verifyText(FootNote2);
		VIPFinancialsPage.contents.RightHandChartHeader.verifyText(RightHandChartHeader);
		WebControl.takeScreenshot("Q2A_Reg_Auto_105");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_106");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
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
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.FinancialsTitle.waitForExist(true, 10);
		VIPOverviewPage.contents.FinancialsTitle.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropDown.hover();
		VIPFinancialsPage.contents.SelectDashboardDropDown.click();
		VIPFinancialsPage.contents.OpeWorCapDecMenu.click();
		VIPFinancialsPage.contents.WorkCapRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(WCRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(WCRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(WCRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(WCRFootnote);
		VIPFinancialsPage.contents.NetRecRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NRRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NRRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(NRRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(NRRFootnote);
		VIPFinancialsPage.contents.InventoryRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(IRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(IRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(IRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(IRFootnote);
		VIPFinancialsPage.contents.AccPayRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(APRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(APRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(APRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(APRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OpeCurAssRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OCARSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OCARCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OCARBest);
		VIPFinancialsPage.contents.FootNote.verifyText(OCARFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.NonIntBearLiabRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(NIBLRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(NIBLRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(NIBLRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(NIBLRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.CashRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(CRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(CRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(CRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(CRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherCurAssRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OCAR1SP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OCAR1CP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OCAR1Best);
		VIPFinancialsPage.contents.FootNote.verifyText(OCAR1Footnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.IncTaxPayRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(ITPRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(ITPRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(ITPRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(ITPRFootnote);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.OtherCurLiaRevBox.click();
		VIPFinancialsPage.contents.StandalonePerf.verifyText(OCLRSP);
		VIPFinancialsPage.contents.CompetitivePosition1.verifyText(OCLRCP1);
		VIPFinancialsPage.contents.BestInClass.verifyText(OCLRBest);
		VIPFinancialsPage.contents.FootNote.verifyText(OCLRFootnote);
		WebControl.takeScreenshot("Q2A_Reg_Auto_106");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);}
		
	}
	
}


