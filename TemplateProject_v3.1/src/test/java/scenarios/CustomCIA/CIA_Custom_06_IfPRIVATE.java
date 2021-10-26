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


public class CIA_Custom_06_IfPRIVATE extends TestBase{
	
	
	
	@Test(priority=1)
	public void CUSTOM_IfPRIVATE () throws Exception {
		ReportLog.setTestName("CUSTOM CIA - IfPRIVATE");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		//Overview
		ReportLog.setTestCase("CUSTOM_RT_TC_005,006");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton2.hover();
		VIPLandingPage.contents.OverviewButtonTooltip.verifyText("Overview");
		VIPLandingPage.contents.OverviewButton2.click();
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
		
		
		//Navigate to TRS Dashboard
		ReportLog.setTestCase("CUSTOM_RT_TC_012");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomCIAPage.contents.CIADetailedTabTitle.click();
		VIPCustomCIAPage.contents.DetailedAnalysisDashboardPane.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.DashboardPaneCurrentScenario.verifyText("CURRENT SCENARIO");
		VIPCustomCIAPage.contents.DashboardPaneTRS.verifyText("TRS");
		VIPCustomCIAPage.contents.DashboardPaneLiquidityRatio.verifyText("Liquidity Ratios");
		VIPCustomCIAPage.contents.DashboardPaneSolvencyRatio.verifyText("Solvency Ratios");
		VIPCustomCIAPage.contents.DashboardPaneChangeInAnalystOutlook.verifyText("CHANGE IN ANALYST OUTLOOK");
		VIPCustomCIAPage.contents.DashboardPaneRevenue.verifyText("Revenue Forecast");
		VIPCustomCIAPage.contents.DashboardPaneEBIT.verifyText("EBIT Forecast");
		VIPCustomCIAPage.contents.DashboardPaneEPS.verifyText("EPS Forecast");
		VIPCustomCIAPage.contents.DashboardPaneFCF.verifyText("FCF Forecast");
		VIPCustomCIAPage.contents.DashboardPaneCapex.verifyText("Capex Forecast");
		VIPCustomCIAPage.contents.TRSIfPrivate.verifyText("No Data Available.");
		WebControl.takeScreenshot("CUSTOM_RT_TC_012");
		
        //Navigate to Liquidity Ratios Dashboard
        ReportLog.setTestCase("Custom_CIA_Reg_018");
        VIPLandingPage.contents.HelpIcon.hover();
        VIPCustomCIAPage.contents.LiquiditySideMenu.click();
        VIPCustomCIAPage.contents.RatioTitle.verifyText("LIQUIDITY RATIOS");
        WebControl.takeScreenshot("Custom_CIA_Reg_018");

        ReportLog.setTestCase("Custom_CIA_Reg_019");
        VIPCustomCIAPage.contents.RatioTimePeriod.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_019");

        ReportLog.setTestCase("Custom_CIA_Reg_020");
        VIPCustomCIAPage.contents.TrendAnalysisToggle.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendAnalysisToggleLabel.verifyText("TREND ANALYSIS");
        WebControl.takeScreenshot("Custom_CIA_Reg_020");

        ReportLog.setTestCase("Custom_CIA_Reg_021_&_022");
        VIPCustomCIAPage.contents.PercentileColumn.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PercentileHeader.verifyText("Percentiles");
        VIPCustomCIAPage.contents.TargetCompanyHeader.verifyDisplayed(true, 5);
        //VIPCustomCIAPage.contents.TargetCompanyHeader.verifyText(CUSTOM_OverviewPage.TargetCompanyName);
        VIPCustomCIAPage.contents.TargetCompanyHeader.hover();
        VIPCustomCIAPage.contents.PeerMedianTitle.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianTitle.verifyText("Peer Median");
        VIPCustomCIAPage.contents.RankHeader.verifyText("Rank");
        VIPCustomCIAPage.contents.TwoYearChangeHeader.verifyText("2 Year Change");
        VIPCustomCIAPage.contents.GrossBurnRateRunwayKPI.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.GrossBurnRateRunwayKPI.verifyText("Gross Burn Rate Runway");
        VIPCustomCIAPage.contents.CashShortTermRevKPI.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.CashShortTermRevKPI.verifyText("Cash & Short-term Investments / Revenue");
        VIPCustomCIAPage.contents.QuickRatioKPI.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.QuickRatioKPI.verifyText("Quick Ratio");
        VIPCustomCIAPage.contents.InventoryRevKPI.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.InventoryRevKPI.verifyText("Inventory / Revenue");
        VIPCustomCIAPage.contents.AccountsPayableRevKPI.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.AccountsPayableRevKPI.verifyText("Accounts Payable / Revenue");
        VIPCustomCIAPage.contents.NetReceivablesRevKPI.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.NetReceivablesRevKPI.verifyText("Net Receivables / Revenue");
        WebControl.takeScreenshot("Custom_CIA_Reg_021_&_022");

        ReportLog.setTestCase("Custom_CIA_Reg_023_to_028");
		VIPCustomCIAPage.contents.LiquidityInfoIcon1.hover();
		VIPCustomCIAPage.contents.LiquidityInfoIcon1.click();
		VIPCustomCIAPage.contents.TooltipText.verifyText("Gross Burn Rate Runway for a company measures the number of months for which the company can continue to pay for operating expenses before it runs out of cash. It is calculated as = (Cash & Cash Equivalents + Short Term Investments) / Monthly Operating Expenses.");
		VIPCustomCIAPage.contents.LiquidityInfoIcon1.click();
		VIPCustomCIAPage.contents.LiquidityInfoIcon2.hover();
		VIPCustomCIAPage.contents.LiquidityInfoIcon2.click();
		VIPCustomCIAPage.contents.TooltipText.verifyText("Cash & Short-term Investments / Revenue is a measure the company's liquidity. Short term investments are marketable securities or highly liquid assets that company can convert into cash easily.");
		VIPCustomCIAPage.contents.LiquidityInfoIcon2.click();
		VIPCustomCIAPage.contents.LiquidityInfoIcon3.hover();
		VIPCustomCIAPage.contents.LiquidityInfoIcon3.click();
		VIPCustomCIAPage.contents.TooltipText.verifyText("Quick Ratio (also known as acid test ratio) is one of the indicators of a company’s short-term liquidity position and measures a company’s ability to meet its short-term liabilities with its liquid assets. These assets are called “quick” assets as they can be quickly converted into cash. It is calculated as = (Total Current Assets – Inventory) / Total Current Liabilities.");
		VIPCustomCIAPage.contents.LiquidityInfoIcon3.click();
		VIPCustomCIAPage.contents.LiquidityInfoIcon4.hover();
		VIPCustomCIAPage.contents.LiquidityInfoIcon4.click();
		VIPCustomCIAPage.contents.TooltipText.verifyText("Inventory / Revenue is the ratio of the average inventory being held by the company to its revenues. It denotes how much of inventory is built up by the company that can be readily converted to sales. Companies from specific industries (e.g. technology services) might not have a separate line item as inventory in their financial statements.");
		VIPCustomCIAPage.contents.LiquidityInfoIcon4.click();
		VIPCustomCIAPage.contents.LiquidityInfoIcon5.hover();
		VIPCustomCIAPage.contents.LiquidityInfoIcon5.click();
		VIPCustomCIAPage.contents.TooltipText.verifyText("Accounts Payable / Revenue is the ratio of the amount the company owes to its vendors or suppliers to the revenue it generates. A higher Accounts Payable indicates that the company has been buying more goods or services on credit, rather than paying cash. This indicates better liquidity position for the company since it holds more cash on its books until final settlement is done with the suppliers.");
		VIPCustomCIAPage.contents.LiquidityInfoIcon5.click();
		VIPCustomCIAPage.contents.LiquidityInfoIcon6.hover();
		VIPCustomCIAPage.contents.LiquidityInfoIcon6.click();
		VIPCustomCIAPage.contents.TooltipText.verifyText("Net Receivables / Revenue is the ratio of the amount owed to the company resulting from the company providing goods or services to its customers on credit, to its revenue generated. Usually a lower accounts receivables is beneficial for the firm since it has lesser amount of money pending from its customers and indicates a better liquidity position.");
		VIPCustomCIAPage.contents.LiquidityInfoIcon6.click();
        WebControl.takeScreenshot("Custom_CIA_Reg_023_to_028");

        //Navigate to Trend Analysis view
        ReportLog.setTestCase("Custom_CIA_Reg_032");
        VIPCustomCIAPage.contents.TrendAnalysisToggle.click();
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_032");

        ReportLog.setTestCase("Custom_CIA_Reg_032");
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText("Gross Burn Rate Runway");
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.GrossBurnRateRunwayIndicator.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.GrossBurnRateRunwayIndicator.verifyText("Gross Burn Rate Runway");
        VIPCustomCIAPage.contents.CashShortTermRevIndicator.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.CashShortTermRevIndicator.verifyText("Cash & Short-term Investments / Revenue");
        VIPCustomCIAPage.contents.QuickRatioIndicator.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.QuickRatioIndicator.verifyText("Quick Ratio");
        VIPCustomCIAPage.contents.InventoryRevIndicator.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.InventoryRevIndicator.verifyText("Inventory / Revenue");
        VIPCustomCIAPage.contents.AccountsPayableRevIndicator.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.AccountsPayableRevIndicator.verifyText("Accounts Payable / Revenue");
        VIPCustomCIAPage.contents.NetReceivablesRevIndicator.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.NetReceivablesRevIndicator.verifyText("Net Receivables / Revenue");
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        WebControl.takeScreenshot("Custom_CIA_Reg_032");

        ReportLog.setTestCase("Custom_CIA_Reg_034");
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.GrossBurnRateRunwayIndicator.click();
        VIPCustomCIAPage.contents.TrendCircleLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendTargetCompanyLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.BrokenLineLegend.verifyDisplayed(true, 5);        
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyText("Peer Median");
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.CashShortTermRevIndicator.click();
        VIPCustomCIAPage.contents.TrendCircleLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendTargetCompanyLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.BrokenLineLegend.verifyDisplayed(true, 5);        
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyText("Peer Median");
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.QuickRatioIndicator.click();
        VIPCustomCIAPage.contents.TrendCircleLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendTargetCompanyLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.BrokenLineLegend.verifyDisplayed(true, 5);        
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyText("Peer Median");
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.InventoryRevIndicator.click();
        VIPCustomCIAPage.contents.TrendCircleLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendTargetCompanyLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.BrokenLineLegend.verifyDisplayed(true, 5);        
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyText("Peer Median");
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.AccountsPayableRevIndicator.click();
        VIPCustomCIAPage.contents.TrendCircleLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendTargetCompanyLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.BrokenLineLegend.verifyDisplayed(true, 5);        
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyText("Peer Median");
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SelectIndicatorDropdown.click();
        VIPCustomCIAPage.contents.NetReceivablesRevIndicator.click();
        VIPCustomCIAPage.contents.TrendCircleLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TrendTargetCompanyLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.BrokenLineLegend.verifyDisplayed(true, 5);        
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.PeerMedianLegend.verifyText("Peer Median");
        VIPCustomCIAPage.contents.FirstPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodHeader.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.FirstPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.SecondPeriodChart.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.ThirdPeriodChart.verifyDisplayed(true, 5);      
        WebControl.takeScreenshot("Custom_CIA_Reg_034");
        
        //Navigate to Solvency Ratios Dashboard
        ReportLog.setTestCase("CUSTOM_RT_TC_042");
        VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomCIAPage.contents.DashboardPaneSolvencyRatio.click();
		VIPCustomCIAPage.contents.KPISelected.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTitle.verifyText("SOLVENCY RATIOS");		
		WebControl.takeScreenshot("CUSTOM_RT_TC_042");	
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_043");
		VIPCustomCIAPage.contents.SolvencyRatiosTimePeriod.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_043");	
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_044");
		VIPCustomCIAPage.contents.SolvencyRatiosToggleButton.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosToggleTrendAnalysis.verifyText("TREND ANALYSIS");	
		WebControl.takeScreenshot("CUSTOM_RT_TC_044");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_045");
		VIPCustomCIAPage.contents.SolvencyRatiosPercentiles.verifyText("Percentiles");	
		VIPCustomCIAPage.contents.SolvencyRatiosPercentiles0.verifyText("0%");
		VIPCustomCIAPage.contents.SolvencyRatiosPercentiles25.verifyText("25%");
		VIPCustomCIAPage.contents.SolvencyRatiosPercentiles50.verifyText("50%");
		VIPCustomCIAPage.contents.SolvencyRatiosPercentiles75.verifyText("75%");
		VIPCustomCIAPage.contents.SolvencyRatiosPercentiles100.verifyText("100%");
		VIPCustomCIAPage.contents.SolvencyRatiosTargetCompany.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosPeerMedian.verifyText("Peer Median");
		VIPCustomCIAPage.contents.SolvencyRatiosRank.verifyText("Rank");
		VIPCustomCIAPage.contents.SolvencyRatios2YearChange.verifyText("2 Year Change");
		WebControl.takeScreenshot("CUSTOM_RT_TC_045");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_046");
		VIPCustomCIAPage.contents.SolvencyRatiosAltmanZScore.verifyText("Altman Z score");	
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtEBITDA.verifyText("Net Debt / EBITDA");
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtFCF.verifyText("Net Debt / FCF");
		VIPCustomCIAPage.contents.SolvencyRatiosTotalDebtEquity.verifyText("Total Debt / Equity");
		VIPCustomCIAPage.contents.SolvencyRatiosInterestCoverage.verifyText("Interest Coverage");
		WebControl.takeScreenshot("CUSTOM_RT_TC_046");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_047-051");
		VIPCustomCIAPage.contents.SolvencyRatiosAltmanZScoreInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosAltmanZScoreInfoIcon.click();
		//VIPCustomCIAPage.contents.SolvencyRatiosKPITooltip.verifyText("Altman Z score is used to predict likelihood of bankruptcy for a company. The score takes into account profitability, liquidity and solvency to predict whether a company has a probability of becoming insolvent. For manufacturing companies: Z score of > 2.99 means that it is safe from bankruptcy Z score of < 1.81 indicates considerable risk of going into bankruptcy Z score between 1.81 and 2.99 should be considered a red flag for possible problems The Z score has not been customized for non-manufacturers and companies in emerging markets, hence the ranges mentioned before may not be applicable for them. However, the comparison with peers should be a good indicator of company’s relative credit strength.");
		VIPCustomCIAPage.contents.SolvencyRatiosKPITooltip.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosAltmanZScoreInfoIcon.click();
		
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtEBITDAInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtEBITDAInfoIcon.click();
		VIPCustomCIAPage.contents.SolvencyRatiosKPITooltip.verifyText("Net Debt / EBITDA is a measure of company’s financial leverage and shows how many years it would take for a company to pay back its debt if it is operating at current level.");
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtEBITDAInfoIcon.click();
		
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtFCFInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtFCFInfoIcon.click();
		VIPCustomCIAPage.contents.SolvencyRatiosKPITooltip.verifyText("Net Debt / FCF is a measurement of leverage and it measures how many years it would take a company to repay its debt if it devoted all its cashflows for it. It is calculated as = (Total Debt - Short Term Investments) / Free Cash Flow.");
		VIPCustomCIAPage.contents.SolvencyRatiosNetDebtFCFInfoIcon.click();
		
		VIPCustomCIAPage.contents.SolvencyRatiosTotalDebtEquityInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTotalDebtEquityInfoIcon.click();
		VIPCustomCIAPage.contents.SolvencyRatiosKPITooltip.verifyText("Total Debt / Equity is the ratio of the company’s total debt divided by market value of equity. The ratio is used to evaluate a company's financial leverage. It is a measure of the degree to which a company is financing its operations through debt versus wholly-owned funds.");
		VIPCustomCIAPage.contents.SolvencyRatiosTotalDebtEquityInfoIcon.click();
		
		VIPCustomCIAPage.contents.SolvencyRatiosInterestCoverageInfoIcon.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosInterestCoverageInfoIcon.click();
		VIPCustomCIAPage.contents.SolvencyRatiosKPITooltip.verifyText("Interest Coverage is a ratio used to determine how easily a company can pay interest on its outstanding debt. The interest coverage ratio is calculated by dividing a company's earnings before interest and taxes (EBIT) during a given period by the company's interest payments due within the same period.");
		VIPCustomCIAPage.contents.SolvencyRatiosInterestCoverageInfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_047-051");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_056");
		VIPCustomCIAPage.contents.SolvencyRatiosToggleButton.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorTitle.verifyText("SELECT INDICATOR");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorDefaultKPI.verifyText("Altman Z score");
		WebControl.takeScreenshot("CUSTOM_RT_TC_056");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_057");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorAltman.verifyText("Altman Z score");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorNetDebtEBITDA.verifyText("Net Debt / EBITDA");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorNetDebtFCF.verifyText("Net Debt / FCF");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorTotalDebtEquity.verifyText("Total Debt / Equity");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorInterestCoverage.verifyText("Interest Coverage");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_057");
	
		
		ReportLog.setTestCase("CUSTOM_RT_TC_055,058");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorDefaultKPI.verifyText("Altman Z score");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear1.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear2.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear3.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendTarget.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendPeerMedian.verifyText("Peer Median");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorNetDebtEBITDA.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorDefaultKPI.verifyText("Net Debt / EBITDA");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear1.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear2.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear3.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendTarget.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendPeerMedian.verifyText("Peer Median");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorNetDebtFCF.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorDefaultKPI.verifyText("Net Debt / FCF");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear1.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear2.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear3.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendTarget.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendPeerMedian.verifyText("Peer Median");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorTotalDebtEquity.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorDefaultKPI.verifyText("Total Debt / Equity");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear1.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear2.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear3.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendTarget.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendPeerMedian.verifyText("Peer Median");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorButton.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorInterestCoverage.click();
		VIPCustomCIAPage.contents.SolvencyRatiosTrendSelectIndicatorDefaultKPI.verifyText("Interest Coverage");
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear1.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear2.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendChartYear3.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendTarget.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.SolvencyRatiosTrendLegendPeerMedian.verifyText("Peer Median");
		WebControl.takeScreenshot("CUSTOM_RT_TC_055,058");
		
		//Navigate to Estimate Dashboards
		ReportLog.setTestCase("CUSTOM_RT_TC_064");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomCIAPage.contents.DashboardPaneRevenue.click();
		VIPCustomCIAPage.contents.KPISelected.verifyText("Revenue Forecast");
		VIPCustomCIAPage.contents.ForecastIfPrivate.verifyText("No Data Available.");
		VIPCustomCIAPage.contents.DashboardPaneEBIT.click();
		VIPCustomCIAPage.contents.KPISelected.verifyText("EBIT Forecast");
		VIPCustomCIAPage.contents.ForecastIfPrivate.verifyText("No Data Available.");
		VIPCustomCIAPage.contents.DashboardPaneEPS.click();
		VIPCustomCIAPage.contents.KPISelected.verifyText("EPS Forecast");
		VIPCustomCIAPage.contents.ForecastIfPrivate.verifyText("No Data Available.");
		VIPCustomCIAPage.contents.DashboardPaneFCF.click();
		VIPCustomCIAPage.contents.KPISelected.verifyText("FCF Forecast");
		VIPCustomCIAPage.contents.ForecastIfPrivate.verifyText("No Data Available.");
		VIPCustomCIAPage.contents.DashboardPaneCapex.click();
		VIPCustomCIAPage.contents.KPISelected.verifyText("Capex Forecast");
		VIPCustomCIAPage.contents.ForecastIfPrivate.verifyText("No Data Available.");
		WebControl.takeScreenshot("CUSTOM_RT_TC_064");
		
	}
	

	
	
}
	
