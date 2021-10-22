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
import pageobjects.VIPCustomCIAPage;
import pageobjects.VIPCustomPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;


public class CIA_Custom_04_SolvencyRatios extends TestBase{
	
	
	@Test(priority=1)
	public void CUSTOM_SolvencyRatiosPage () throws Exception {
		ReportLog.setTestName("CUSTOM CIA - SolvencyRatiosPage");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_042");
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
		VIPCustomCIAPage.contents.CIAOverviewIndustryLink.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.CIADetailedTabTitle.click();
		VIPCustomCIAPage.contents.TRSTitle.verifyDisplayed(true, 5);
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

		
	}
	

	
	
}
	
