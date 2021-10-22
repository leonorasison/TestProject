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


public class CIA_Custom_05_Forecasts extends TestBase{

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
	public void CUSTOM_Forecasts () throws Exception {
		ReportLog.setTestName("CUSTOM CIA - Forecastss");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
	
		/* Forecasts Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
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
        
        //Revenue Forecast
        ReportLog.setTestCase("Custom_CIA_Reg_Revenue_Forecast_064");
        VIPCustomCIAPage.contents.RevGrowthSideMenuClick.click();
        WebControl.waitForPageToLoad(25000);
        Thread.sleep(2000);
        VIPCustomCIAPage.contents.ForecastDashboardTitle.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_Revenue_Forecast_064");

        ReportLog.setTestCase("Custom_CIA_Reg_Revenue_Forecast_066");
        VIPCustomCIAPage.contents.SelectTimeFrameHeader.verifyText("Select Timeframe");
        VIPCustomCIAPage.contents.TimeFrameDropdown.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe2.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe3.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_Revenue_Forecast_066"); 

        ReportLog.setTestCase("Custom_CIA_Reg_Revenue_Forecast_065_&_067");
        String Year1 = VIPCustomCIAPage.contents.Timeframe1.getText();
        VIPCustomCIAPage.contents.Timeframe1.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year1);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year1);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        String Year2 = VIPCustomCIAPage.contents.Timeframe2.getText();
        VIPCustomCIAPage.contents.Timeframe2.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year2);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year2);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        String Year3 = VIPCustomCIAPage.contents.Timeframe3.getText();
        VIPCustomCIAPage.contents.Timeframe3.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year3);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year3);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        WebControl.takeScreenshot("Custom_CIA_Reg_Revenue_Forecast_065_&_067");
        
        //EBIT Forecast
        ReportLog.setTestCase("Custom_CIA_Reg_EBIT_Forecast_064");
        VIPCustomCIAPage.contents.EBITSideMenuClick.click();
        WebControl.waitForPageToLoad(25000);
        Thread.sleep(2000);
        VIPCustomCIAPage.contents.ForecastDashboardTitle.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_EBIT_Forecast_064");

        ReportLog.setTestCase("Custom_CIA_Reg_EBIT_Forecast_066");
        VIPCustomCIAPage.contents.SelectTimeFrameHeader.verifyText("Select Timeframe");
        VIPCustomCIAPage.contents.TimeFrameDropdown.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe2.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe3.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_EBIT_Forecast_066"); 

        ReportLog.setTestCase("Custom_CIA_Reg_EBIT_Forecast_065_&_067");
        VIPCustomCIAPage.contents.Timeframe3.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year3);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year3);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe2.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year2);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year2);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year1);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year1);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        WebControl.takeScreenshot("Custom_CIA_Reg_EBIT_Forecast_065_&_067");
        
        //EPS Forecast
        ReportLog.setTestCase("Custom_CIA_Reg_EPS_Forecast_064");
        VIPCustomCIAPage.contents.EPSSideMenuClick.click();
        WebControl.waitForPageToLoad(25000);
        Thread.sleep(2000);
        VIPCustomCIAPage.contents.ForecastDashboardTitle.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_EPS_Forecast_064");

        ReportLog.setTestCase("Custom_CIA_Reg_EPS_Forecast_066");
        VIPCustomCIAPage.contents.SelectTimeFrameHeader.verifyText("Select Timeframe");
        VIPCustomCIAPage.contents.TimeFrameDropdown.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe2.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe3.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_EPS_Forecast_066"); 

        ReportLog.setTestCase("Custom_CIA_Reg_EPS_Forecast_065_&_067");
        VIPCustomCIAPage.contents.Timeframe1.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year1);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year1);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe2.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year2);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year2);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe3.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year3);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year3);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        WebControl.takeScreenshot("Custom_CIA_Reg_EPS_Forecast_065_&_067");

        //FCF Forecast
        ReportLog.setTestCase("Custom_CIA_Reg_FCF_Forecast_064");
        VIPCustomCIAPage.contents.FCFSideMenuClick.click();
        WebControl.waitForPageToLoad(60);
        Thread.sleep(2000);
        VIPCustomCIAPage.contents.ForecastDashboardTitle.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_FCF_Forecast_064");

        ReportLog.setTestCase("Custom_CIA_Reg_FCF_Forecast_066");
        VIPCustomCIAPage.contents.SelectTimeFrameHeader.verifyText("Select Timeframe");
        VIPCustomCIAPage.contents.TimeFrameDropdown.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe2.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe3.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_FCF_Forecast_066"); 

        ReportLog.setTestCase("Custom_CIA_Reg_FCF_Forecast_065_&_067");
        VIPCustomCIAPage.contents.Timeframe3.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year3);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year3);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe2.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year2);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year2);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year1);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year1);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        WebControl.takeScreenshot("Custom_CIA_Reg_FCF_Forecast_065_&_067");
        

        //Capex Forecast
        ReportLog.setTestCase("Custom_CIA_Reg_Capex_Forecast_064");
        VIPCustomCIAPage.contents.CapexSideMenuClick.click();
        WebControl.waitForPageToLoad(60);
        Thread.sleep(2000);
        VIPCustomCIAPage.contents.ForecastDashboardTitle.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_Capex_Forecast_064");

        ReportLog.setTestCase("Custom_CIA_Reg_Capex_Forecast_066");
        VIPCustomCIAPage.contents.SelectTimeFrameHeader.verifyText("Select Timeframe");
        VIPCustomCIAPage.contents.TimeFrameDropdown.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe1.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe2.verifyDisplayed(true, 5);
        VIPCustomCIAPage.contents.Timeframe3.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_CIA_Reg_Capex_Forecast_066"); 

        ReportLog.setTestCase("Custom_CIA_Reg_Capex_Forecast_065_&_067");
        VIPCustomCIAPage.contents.Timeframe1.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year1);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year1);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe2.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year2);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year2);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        VIPCustomCIAPage.contents.TimeFrameDropdown.click();
        VIPCustomCIAPage.contents.Timeframe3.click();
        VIPCustomCIAPage.contents.DefaultDropdownText.verifyText(Year3);
        if (VIPCustomCIAPage.contents.ForecastTable.isDisplayed()) {
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.ForecastTargetCircleLegend.verifyDisplayed(true, 5);
            //VIPCustomCIAPage.contents.ForecastTargetCompLegend.verifyText(TargetCompanyName);
            VIPCustomCIAPage.contents.ForecastPeerCircleLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.ForecastPeerCompLegend.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyDisplayed(true, 5);
            VIPCustomCIAPage.contents.TimeFrameColumnHeader.verifyText(Year3);
            VIPCustomCIAPage.contents.EstimateRevColumnHeader.verifyText("Estimate Revision from Dec'19");
            }
        else {
        	VIPCustomCIAPage.contents.NoDataAvailableNote.verifyDisplayed(true, 5);
            Thread.sleep(2000);
            VIPCustomCIAPage.contents.NoDataAvailableNote.verifyText("No Data Available.");
            }
        WebControl.takeScreenshot("Custom_CIA_Reg_Capex_Forecast_065_&_067");
	
	
	}
}
