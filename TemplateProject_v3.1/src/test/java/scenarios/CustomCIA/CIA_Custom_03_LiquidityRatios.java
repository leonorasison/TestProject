package scenarios.CustomCIA;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPCustomPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPCustomCIAPage;


public class CIA_Custom_03_LiquidityRatios extends TestBase{

    @Test(priority=1)
	public void CUSTOM_OverviewPage () throws Exception {
		ReportLog.setTestName("CUSTOM CIA - OverviewPage");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_XXX");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		//String TargetCompanyName = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.OverviewButton.hover();
		VIPLandingPage.contents.OverviewButtonTooltip.verifyText("Overview");
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		
		WebControl.takeScreenshot("CUSTOM_RT_TC_XXX");
    }

    @Test(priority=2)
	public void CUSTOM_CIA_Liquidity_Ratios () throws Exception {
		ReportLog.setTestName("CUSTOM - Liquidity Ratios");
        TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
     
        /* Liquidity Ratios Dashboard
         * Author: alyssa.kay.n.mababa */

        //Navigate to COVID IMPACT ANALYSIS TAB
        ReportLog.setTestCase("Custom_CIA_NavigateToCIA");      
        VIPCustomCIAPage.contents.BurgerMenu.verifyDisplayed(true, 10);
        VIPCustomCIAPage.contents.BurgerMenu.hover();
        VIPCustomCIAPage.contents.CIASideMenu.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIASideMenu.click();
		VIPLandingPage.contents.HelpIcon.hover();
        WebControl.takeScreenshot("Custom_CIA_NavigateToCIA");

        //Navigate to Detailed Analysis Tab
        ReportLog.setTestCase("Custom_CIA_NavigateToDetailedAnalysis");
		VIPCustomCIAPage.contents.DetailedAnalysisTab.hover();
		VIPCustomCIAPage.contents.DetailedAnalysisTab.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomCIAPage.contents.TRSTitle.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.DetailedAnalysisTab.verifyText("Detailed Analysis");
        WebControl.takeScreenshot("Custom_CIA_NavigateToDetailedAnalysis");

        //Navigate to Liquidity Ratios Dashboard
        ReportLog.setTestCase("Custom_CIA_Reg_018");
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

        ReportLog.setTestCase("Custom_CIA_Reg_033");
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
        WebControl.takeScreenshot("Custom_CIA_Reg_033");

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

    }
}
