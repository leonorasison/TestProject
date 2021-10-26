package scenarios.SALES;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import auto.framework.web.WebControl1;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;

public class SalesLeadership_06_CGSKPIs extends TestBase{
	
	@Test
	public void Sales_CGSKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - CG&S KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_101");	
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.verifyText("INDUSTRY OPERATING METRICS\n" + "NEW");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText2.verifyText("NEW");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText2.verifyCssValue("color", "rgba(165, 0, 0, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_101");
		
		ReportLog.setTestCase("Sales_Reg_Auto_102");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.CGSHeatMap.waitForExist(true, 15);
		WebControl.takeScreenshot("Sales_Reg_Auto_102");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_103");
		VIPSalesPage.contents.CGSToggleSlider.verifyDisplayed(true);
		VIPSalesPage.contents.CGSToggleLabel.verifyText("View Detailed Comparison");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSSelectIndustryDropdown.waitForExist(true, 15);
		WebControl.takeScreenshot("Sales_Reg_Auto_103");
		
		ReportLog.setTestCase("Sales_Reg_Auto_104");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Consumer Goods and Services");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyCssValue("font-weight", "900");
		WebControl.takeScreenshot("Sales_Reg_Auto_104");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_105");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 5);
		String TimeFrame1 = VIPSalesPage.contents.CGSMarketShareText.getText();
		String[] TimeFrame2 = TimeFrame1.split("\\s");
		String TimeFrame = TimeFrame2[TimeFrame2.length - 1];
		VIPSalesPage.contents.CGSMarketShareText.verifyText(testDataHandler.cgsCompany + "'s market share comparison summary, by value " + TimeFrame);
		WebControl.takeScreenshot("Sales_Reg_Auto_105");
		
		ReportLog.setTestCase("Sales_Reg_Auto_106");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton2.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Beijing Yanjing Brewery");
		Thread.sleep(1500);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Beijing Yanjing Brewery Co.,Ltd.'s market share comparison summary, by value [2018]");
		WebControl.takeScreenshot("Sales_Reg_Auto_106");
		
		ReportLog.setTestCase("Sales_Reg_Auto_144");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSPieChartHeader.waitForExist(true, 10);
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL ALCOHOLIC BEVERAGES MARKET SIZE BY REGION [2018]");
		WebControl.takeScreenshot("Sales_Reg_Auto_144");
		
		ReportLog.setTestCase("Sales_Reg_Auto_114");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSFootnoteH.waitForExist(true, 10);
		VIPSalesPage.contents.CGSFootnoteH.verifyText("Note: Alcoholic Beverages data is present as of 2018 and change represents 2018 vs 2017; Market size and share based on the retail price of product paid by consumer.");
		VIPOverviewPage.contents.BackToSearchButton2.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
		Thread.sleep(1500);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.CGSCategory1.waitForExist(true, 10);
		String CGSCategory1 = VIPSalesPage.contents.CGSCategory1.getText();
		String CGSCategory2 = VIPSalesPage.contents.CGSCategory2.getText();
		String CGSCategory3 = VIPSalesPage.contents.CGSCategory3.getText();
		String CGSCategory4 = VIPSalesPage.contents.CGSCategory4.getText();
		String CGSCategory5 = VIPSalesPage.contents.CGSCategory5.getText();
		String CGSCategory6 = VIPSalesPage.contents.CGSCategory6.getText();
		if (CGSCategory1.equals("ALCOHOLIC BEVERAGES") | CGSCategory2.equals("ALCOHOLIC BEVERAGES")
		  | CGSCategory3.equals("ALCOHOLIC BEVERAGES") | CGSCategory4.equals("ALCOHOLIC BEVERAGES")
		  | CGSCategory5.equals("ALCOHOLIC BEVERAGES") | CGSCategory6.equals("ALCOHOLIC BEVERAGES"))  {
		VIPSalesPage.contents.CGSFootnoteH.verifyText("Note: Alcoholic Beverages data is present as of 2018 and change represents 2018 vs 2017; Market size and share based on the retail price of product paid by consumer.");}
		else {VIPSalesPage.contents.CGSFootnoteH.verifyText("Note: Market size and share based on the retail price of product paid by consumer.");}
		WebControl.takeScreenshot("Sales_Reg_Auto_114");
		
		ReportLog.setTestCase("Sales_Reg_Auto_115");
		VIPSalesPage.contents.CGSSourceH.verifyText("Source: GlobalData; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_115");
		
		ReportLog.setTestCase("Sales_Reg_Auto_110");
		VIPSalesPage.contents.CGSTop5LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSTop5LegendIcon.verifyCssValue("background-color", "rgba(70, 0, 115, 1)");
		VIPSalesPage.contents.CGSTop5LegendText.verifyText("Target is in Top 5");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.CGSTop10LegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSTop10LegendIcon.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.CGSTop10LegendText.verifyText("Target is in Top 10");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSTop5LegendText.verifyCssValue("font-size", "10px");
		WebControl.takeScreenshot("Sales_Reg_Auto_110");
		
		ReportLog.setTestCase("Sales_Reg_Auto_111");
		VIPSalesPage.contents.CGSIncreasedLegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSIncreasedLegendIcon.verifyCssValue("border-bottom", "0px none rgb(92, 92, 92)");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyText("Increased vs 2017");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSIncreasedLegendText.verifyCssValue("font-size", "10px");
		VIPSalesPage.contents.CGSDecreasedLegendIcon.verifyDisplayed(true);
		VIPSalesPage.contents.CGSDecreasedLegendIcon.verifyCssValue("border-top", "0px none rgb(92, 92, 92)");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyText("Decreased vs 2017");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyCssValue("color", "rgba(92, 92, 92, 1)");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyCssValue("font-family", "Graphik-bold");
		VIPSalesPage.contents.CGSDecreasedLegendText.verifyCssValue("font-size", "10px");
		WebControl.takeScreenshot("Sales_Reg_Auto_111");
		
		ReportLog.setTestCase("Sales_Reg_Auto_117");
		VIPSalesPage.contents.CGSToggleSlider.verifyDisplayed(true);
		VIPSalesPage.contents.CGSToggleLabel.verifyText("View Detailed Comparison");
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSSelectIndustryDropdown.waitForExist(true, 15);
		WebControl.takeScreenshot("Sales_Reg_Auto_117");
		
		ReportLog.setTestCase("Sales_Reg_Auto_118");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Consumer Goods and Services");
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyCssValue("font-weight", "900");
		WebControl.takeScreenshot("Sales_Reg_Auto_118");
		
		ReportLog.setTestCase("Sales_Reg_Auto_119");
		String CGSSelectedIndustry = VIPSalesPage.contents.CGSSelectedIndustry.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedIndustry + " industry");
		VIPSalesPage.contents.CGSSelectSectorDropdown.click();
		VIPSalesPage.contents.CGSSectorMenu2.click();
		Thread.sleep(1000);
		String CGSSelectedSector = VIPSalesPage.contents.CGSSelectedSector.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedSector + " sector");
		VIPSalesPage.contents.CGSSelectCategoryDropdown.click();
		VIPSalesPage.contents.CGSCategoryMenu2.click();
		Thread.sleep(1000);
		String CGSSelectedCategory = VIPSalesPage.contents.CGSSelectedCategory.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedCategory + " category");
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		VIPSalesPage.contents.CGSRegionMenu2.click();
		VIPSalesPage.contents.CGSSelectCountryDropdown.click();
		VIPSalesPage.contents.CGSCountryMenu2.click();
		Thread.sleep(1000);
		String CGSSelectedCountry = VIPSalesPage.contents.CGSSelectedCountry.getText();
		VIPSalesPage.contents.CGSMarketShareText.waitForExist(true, 10);
		VIPSalesPage.contents.CGSMarketShareText.verifyText("Market share trend and peer comparison in " + CGSSelectedCategory + " category" + " in " + CGSSelectedCountry);
		WebControl.takeScreenshot("Sales_Reg_Auto_119");
		
		ReportLog.setTestCase("Sales_Reg_Auto_121");
		VIPSalesPage.contents.CGSSelectIndustryDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectIndustryDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectSectorDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectSectorDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCategoryDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCategoryDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectRegionDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectRegionDropdownLabel.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCountryDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectCountryDropdownLabel.verifyDisplayed(true);
		if (CGSSelectedIndustry.equals("Alcoholic Beverages") | CGSSelectedIndustry.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(true);}
		WebControl.takeScreenshot("Sales_Reg_Auto_121");
		
		ReportLog.setTestCase("Sales_Reg_Auto_122");
		VIPSalesPage.contents.CGSSelectIndustryDropdown.click();
		if (VIPSalesPage.contents.CGSIndustryMenuAlcoholic.isDisplayed()) {
		VIPSalesPage.contents.CGSIndustryMenuAlcoholic.click();
		VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(true);}
		else if (VIPSalesPage.contents.CGSIndustryMenuNonAlcoholic.isDisplayed()) {
		VIPSalesPage.contents.CGSIndustryMenuNonAlcoholic.click();
		VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(true);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(true);}
		else {VIPSalesPage.contents.CGSSelectMeasureDropdown.verifyDisplayed(false);
		VIPSalesPage.contents.CGSSelectMeasureDropdownLabel.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_122");
		
		ReportLog.setTestCase("Sales_Reg_Auto_124");
		//Industry
		VIPSalesPage.contents.CGSSelectIndustryDropdown.click();
		String CGSIndustryMenu1 = VIPSalesPage.contents.CGSIndustryMenu1.getText();
		VIPSalesPage.contents.CGSIndustryMenu1.click();
		VIPSalesPage.contents.CGSPieChart.verifyDisplayed(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSIndustryMenu1.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSIndustryMenu1.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Sector
		VIPSalesPage.contents.CGSSelectSectorDropdown.click();
		String CGSSectorMenu2 = VIPSalesPage.contents.CGSSectorMenu2.getText();
		VIPSalesPage.contents.CGSSectorMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSSectorMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSSectorMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Category
		VIPSalesPage.contents.CGSSelectCategoryDropdown.click();
		String CGSCategoryMenu2 = VIPSalesPage.contents.CGSCategoryMenu2.getText();
		VIPSalesPage.contents.CGSCategoryMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Region
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		VIPSalesPage.contents.CGSRegionMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		//Country
		VIPSalesPage.contents.CGSSelectCountryDropdown.click();
		VIPSalesPage.contents.CGSCountryMenu2.click();
		VIPSalesPage.contents.CGSPieChart.waitForExist(true, 10);
		if (CGSIndustryMenu1.equals("Alcoholic Beverages") | CGSIndustryMenu1.equals("Non-Alcoholic Beverages")) {
		VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2018]");}
		else {VIPSalesPage.contents.CGSPieChartHeader.verifyText("GLOBAL " + CGSCategoryMenu2.toUpperCase() + " MARKET SIZE BY REGION [2019]");}
		WebControl.takeScreenshot("Sales_Reg_Auto_124");
		
		ReportLog.setTestCase("Sales_Reg_Auto_128");
		VIPSalesPage.contents.CGSSelectIndustryDropdown.click();
		VIPSalesPage.contents.CGSIndustryMenu1.click();
		VIPSalesPage.contents.CGSPieChartLegendColor1.verifyCssValue("background-color", "rgba(0, 0, 0, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText1.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue1.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor2.verifyCssValue("background-color", "rgba(117, 0, 192, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText2.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue2.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor3.verifyCssValue("background-color", "rgba(161, 0, 255, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText3.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue3.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor4.verifyCssValue("background-color", "rgba(182, 32, 224, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText4.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue4.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor5.verifyCssValue("background-color", "rgba(190, 130, 255, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText5.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue5.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendColor6.verifyCssValue("background-color", "rgba(220, 175, 255, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText6.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue6.verifyDisplayed(true); 
		if (VIPSalesPage.contents.CGSPieChartLegend7.isDisplayed()) {
		VIPSalesPage.contents.CGSPieChartLegendColor7.verifyCssValue("background-color", "rgba(170, 171, 173, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText7.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue7.verifyDisplayed(true);}
		else {VIPSalesPage.contents.CGSPieChartLegendColor7.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendText7.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendValue7.verifyDisplayed(false);}
		if (VIPSalesPage.contents.CGSPieChartLegend8.isDisplayed()) {
		VIPSalesPage.contents.CGSPieChartLegendColor8.verifyCssValue("background-color", "rgba(17, 209, 198, 1)");
		VIPSalesPage.contents.CGSPieChartLegendText8.verifyDisplayed(true); 
		VIPSalesPage.contents.CGSPieChartLegendValue8.verifyDisplayed(true);}
		else {VIPSalesPage.contents.CGSPieChartLegendColor8.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendText8.verifyDisplayed(false);
		VIPSalesPage.contents.CGSPieChartLegendValue8.verifyDisplayed(false);}
		WebControl.takeScreenshot("Sales_Reg_Auto_128");
		
		ReportLog.setTestCase("Sales_Reg_Auto_129");
		VIPSalesPage.contents.CGSPieChart.verifyCssValue("background-color", "rgba(235, 235, 235, 1)");
		WebControl.takeScreenshot("Sales_Reg_Auto_129");
		
		ReportLog.setTestCase("Sales_Reg_Auto_130");
		VIPSalesPage.contents.CGSVerticalChart.verifyDisplayed(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - GLOBAL");
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		String CGSRegionMenu2 = VIPSalesPage.contents.CGSRegionMenu2.getText();
		VIPSalesPage.contents.CGSRegionMenu2.click();
		VIPSalesPage.contents.CGSVerticalChart.waitForExist(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - " + CGSRegionMenu2.toUpperCase());
		VIPSalesPage.contents.CGSSelectCountryDropdown.click();
		String CGSCountryMenu2 = VIPSalesPage.contents.CGSCountryMenu2.getText();
		VIPSalesPage.contents.CGSCountryMenu2.click();
		VIPSalesPage.contents.CGSVerticalChart.waitForExist(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - " + CGSCountryMenu2.toUpperCase());
		VIPSalesPage.contents.CGSSelectRegionDropdown.click();
		VIPSalesPage.contents.CGSRegionMenu1.click();
		VIPSalesPage.contents.CGSVerticalChart.waitForExist(true, 10); 
		VIPSalesPage.contents.CGSVerticalChartHeader.verifyText("MARKET SHARE - GLOBAL");
		WebControl.takeScreenshot("Sales_Reg_Auto_130");
		
		ReportLog.setTestCase("Sales_Reg_Auto_131");
		VIPSalesPage.contents.CGSVerticalChartSubHeader.verifyText("Click on the bars to view peer comparison for each year");
		WebControl.takeScreenshot("Sales_Reg_Auto_131");
		
		ReportLog.setTestCase("Sales_Reg_Auto_134");
		WebControl1.ClickByCoordinates_VerticalChart(424, 750, 1, "//*[@class='vertical-chart-div']//canvas");
		Thread.sleep(1500);
		VIPSalesPage.contents.CGSHorizontalChartHeader.verifyText("TOP 10 PLAYERS BY MARKET SHARE\n" + "[2017]");
		WebControl1.ClickByCoordinates_VerticalChart(424, 750, 2, "//*[@class='vertical-chart-div']//canvas");
		Thread.sleep(1500);
		VIPSalesPage.contents.CGSHorizontalChartHeader.verifyText("TOP 10 PLAYERS BY MARKET SHARE\n" + "[2018]");
		WebControl1.ClickByCoordinates_VerticalChart(424, 750, 3, "//*[@class='vertical-chart-div']//canvas");
		Thread.sleep(1500);
		VIPSalesPage.contents.CGSHorizontalChartHeader.verifyText("TOP 10 PLAYERS BY MARKET SHARE\n" + "[2019]");
		WebControl.takeScreenshot("Sales_Reg_Auto_134");
		
		ReportLog.setTestCase("Sales_Reg_Auto_139");
		VIPSalesPage.contents.CGSSourceD.verifyText("Source: GlobalData; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_139");
		
		ReportLog.setTestCase("Sales_Reg_Auto_141_&_142");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.cgsCompany);
		Thread.sleep(1500);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 10);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.CGSCategory1.waitForExist(true, 10);
		List<String> lList = new ArrayList<String>();
		if (VIPSalesPage.contents.CGSCategory1.isDisplayed()) {
		String Industry1 = VIPSalesPage.contents.CGSCategory1.getText();
		lList.add(Industry1);}
		if (VIPSalesPage.contents.CGSCategory2.isDisplayed()) {
		String Industry2 = VIPSalesPage.contents.CGSCategory2.getText();
		lList.add(Industry2);}
		if (VIPSalesPage.contents.CGSCategory3.isDisplayed()) {
		String Industry3 = VIPSalesPage.contents.CGSCategory3.getText();
		lList.add(Industry3);}
		if (VIPSalesPage.contents.CGSCategory4.isDisplayed()) {
		String Industry4 = VIPSalesPage.contents.CGSCategory4.getText();
		lList.add(Industry4);}
		if (VIPSalesPage.contents.CGSCategory5.isDisplayed()) {
		String Industry5 = VIPSalesPage.contents.CGSCategory5.getText();
		lList.add(Industry5);}
		if (VIPSalesPage.contents.CGSCategory6.isDisplayed()) {
		String Industry6 = VIPSalesPage.contents.CGSCategory6.getText();
		lList.add(Industry6);}
		Collections.sort(lList);
        String a1 = lList.get(0).toLowerCase();
		VIPSalesPage.contents.CGSToggleSlider.click();
		VIPSalesPage.contents.CGSSelectIndustryDropdown.waitForExist(true, 10);
		String[] input1 = a1.split("\\s");
		String output = input1[0].substring(0, 1).toUpperCase() + input1[0].substring(1) +
		" " + input1[1].substring(0, 1).toUpperCase() + input1[1].substring(1);
		VIPSalesPage.contents.CGSSelectedIndustry.verifyText(output);
		VIPSalesPage.contents.CGSSelectedSector.verifyText("All");
		VIPSalesPage.contents.CGSSelectedCategory.verifyText("All");
		VIPSalesPage.contents.CGSSelectedRegion.verifyText("Global");
		VIPSalesPage.contents.CGSSelectedCountry.verifyText("All");
		WebControl.takeScreenshot("Sales_Reg_Auto_141_&_142");
		
		ReportLog.setTestCase("Sales_Reg_Auto_146");
		VIPSalesPage.contents.CGSSourceD.verifyText("Source: GlobalData; Accenture Client Value Services.");
		WebControl.takeScreenshot("Sales_Reg_Auto_146");
	
	}
		
}


