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


public class CIA_Custom_02_TRS extends TestBase{
	
	
	@Test(priority=1)
	public void CUSTOM_TRSPage () throws Exception {
		ReportLog.setTestName("CUSTOM CIA - TRSPage");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_012");
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
		VIPCustomCIAPage.contents.TRSTitle.verifyText("TOTAL RETURN TO SHAREHOLDERS");
		VIPCustomCIAPage.contents.TRSInfoIcon.verifyDisplayed(true, 5);
		//VIPCustomCIAPage.contents.TRSInfoIcon.click();
		//VIPCustomCIAPage.contents.TRSInfoIconMessage.verifyDisplayed(true, 5);
		//VIPCustomCIAPage.contents.TRSInfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_012");	
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_013");
		VIPCustomCIAPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomCIAPage.contents.TRSLegentPeer.verifyText("Peer");
		VIPCustomCIAPage.contents.TRSLegentPeerMedian.verifyText("Peer Median");
		WebControl.takeScreenshot("CUSTOM_RT_TC_013");	
		
	

		
	}
	

	
	
}
	
