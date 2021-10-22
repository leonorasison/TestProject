package scenarios.Custom;

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


public class Financials_Custom_15_RGvsAS extends TestBase{

	@Test(priority=1)
	public void CUSTOM_RGvsAS () throws Exception {
		ReportLog.setTestName("CUSTOM - Revenue Growth and Average Spread");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

    	/* Revenue Growth vs. Average Spread dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_136");
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
		//Navigate to Financials Tab		
		VIPCustomPage.contents.FinancialsTab.hover();
		VIPCustomPage.contents.FinancialsTab.verifyDisplayed(true, 10);
		VIPCustomPage.contents.FinancialsTab.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Revenue Growth vs. Average Spread Dashboard
		VIPCustomPage.contents.RGvsASMenu.click();
		VIPCustomPage.contents.RGvsASScatterChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASScatterChartTitle.verifyText("REVENUE GROWTH vs. AVERAGE SPREAD");
		VIPCustomPage.contents.RGvsASSpreadBarChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASSpreadBarChartTitle.verifyText("SPREAD (ROIC – WACC)");		
		VIPCustomPage.contents.RGvsASRevGrowthBarChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASRevGrowthBarChartTitle.verifyText("REVENUE GROWTH RATE");			
		WebControl.takeScreenshot("Custom_Reg_Auto_136");

		ReportLog.setTestCase("CUSTOM_Reg_Auto_137");
		//Get Target Company name
		VIPOverviewPage.contents.BackToSearchButton.click();
		String TargetCompanyName = VIPLandingPage.contents.CompanyCardName.getText();
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RGvsASMenu.click();
		String LatestPeriod = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 7, 4); 
		String SpreadYr1 = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 93, 5); //2018
		String RevGrowthYr1 = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 119, 5); //2018
		//Old format
		String[] LatestPeriodSplit = LatestPeriod.split("-");
		SimpleDateFormat oldFormatLatestPeriod = new SimpleDateFormat("MM/yyyy");
        Date LatestPeriodSplit1 = oldFormatLatestPeriod.parse(LatestPeriodSplit[1]);		
		
		SimpleDateFormat oldFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date SpreadDate1 = oldFormat.parse(SpreadYr1);
        Date RevGrowthDate1 = oldFormat.parse(RevGrowthYr1);
		
		//New format
		SimpleDateFormat newFormat = new SimpleDateFormat("MM/yyyy");
        String newLatestPeriod = newFormat.format(LatestPeriodSplit1);
        String newSpreadDate1 = newFormat.format(SpreadDate1);
        String newRevGrowthDate1 = newFormat.format(RevGrowthDate1);

		VIPCustomPage.contents.ScatterTimePeriod.verifyText("["+LatestPeriodSplit[0]+"-"+newLatestPeriod+"]");
		VIPCustomPage.contents.SpreadBarChartTimePeriod.verifyText("[FY-"+newSpreadDate1+" — "+LatestPeriodSplit[0]+"-"+newLatestPeriod+"]");
		VIPCustomPage.contents.SpreadBarChartTimePeriod.verifyText("[FY-"+newRevGrowthDate1+" — "+LatestPeriodSplit[0]+"-"+newLatestPeriod+"]");
		WebControl.takeScreenshot("Custom_Reg_Auto_137");		
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_138");
		VIPCustomPage.contents.RGvsASInfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASInfoIcon.hover();
		VIPCustomPage.contents.RGvsASInfoIconTooltip.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASInfoIconTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RGvsASInfoIcon.click();
		VIPCustomPage.contents.RGvsASInfoIconText.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASInfoIconText.verifyText("Spread is a measure of a company’s ability to make money on its capital investments. If the WACC (weighted average cost of capital) exceeds the ROIC (Return on Invested Capital), the company is losing money. Spread is measured as (post-tax ROIC – WACC).");
		VIPCustomPage.contents.RGvsASInfoIcon.click();
		WebControl.takeScreenshot("Custom_Reg_Auto_138");

		ReportLog.setTestCase("CUSTOM_Reg_Auto_139");
		VIPCustomPage.contents.RGvsASEditIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASEditIcon.hover();
		VIPCustomPage.contents.RGvsASEditIconTooltip.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASEditIconTooltip.verifyText("Click here to remove outliers from scatter");
		VIPCustomPage.contents.RGvsASEditIcon.click();
		WebControl.takeScreenshot("Custom_Reg_Auto_139");

		ReportLog.setTestCase("CUSTOM_Reg_Auto_140");
		VIPCustomPage.contents.RGvsASModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TargetCompanyCheckbox.isSelected();
		VIPCustomPage.contents.TargetCompanyCheckbox.click();
		VIPCustomPage.contents.PeerCompCheckBox1.verifyDisplayed(true, 5);
		//VIPCustomPage.contents.PeerCompCheckBox2.verifyDisplayed(true, 5);
		//VIPCustomPage.contents.PeerCompCheckBox3.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_140");

		ReportLog.setTestCase("CUSTOM_Reg_Auto_141");
		VIPCustomPage.contents.RGvsASModalHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASModalHeader.verifyText("Select/Deselect companies to show/hide");
		VIPCustomPage.contents.RGvsASModalNote.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASModalNote.verifyText("Uncheck the companies to remove outliers from the Revenue Growth vs. Average Spread scatter chart. Please note that the peer median will not be affected as it will include all companies");
		VIPCustomPage.contents.PeerCompCheckBox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PeerCompCheckBox1.click();
		VIPCustomPage.contents.PeerCompUncheckBox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASModalApplyButton.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASModalApplyButton.verifyText("Apply");
		VIPCustomPage.contents.RGvsASModalCloseButton.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASModalCloseButton.click();
		WebControl.takeScreenshot("Custom_Reg_Auto_141");

		ReportLog.setTestCase("CUSTOM_Reg_Auto_144");
		VIPCustomPage.contents.RGvsASToggleButton.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASToggleLabel.verifyText("Detailed Peer Comparison");
		VIPCustomPage.contents.RGvsASToggleButton.click();
		VIPCustomPage.contents.RGvsASSIDropdown.verifyDisplayed(true, 10);
		VIPCustomPage.contents.IndDefaultKPI.verifyText("Spread (ROIC-WACC)");
		VIPCustomPage.contents.RGvsASSIDropdown.click();
		VIPCustomPage.contents.IndSpread.verifyText("Spread (ROIC-WACC)");
		VIPCustomPage.contents.IndRevGrowthRate.verifyText("Revenue Growth Rate");
		VIPCustomPage.contents.IndSpread.click();
		VIPCustomPage.contents.SpreadInfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SpreadInfoIcon.hover();
		VIPCustomPage.contents.RGvsASInfoIconTooltip.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASInfoIconTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.SpreadInfoIcon.click();
		VIPCustomPage.contents.SpreadInfoIconText.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SpreadInfoIconText.verifyText("Spread is a measure of a company’s ability to make money on its capital investments. If the WACC (weighted average cost of capital) exceeds the ROIC (Return on Invested Capital), the company is losing money. Spread is measured as (post-tax ROIC – WACC).");
		VIPCustomPage.contents.SpreadInfoIcon.click();
		VIPCustomPage.contents.RGvsASSIDropdown.hover();
		VIPCustomPage.contents.RGvsASDetailedChartHeader.verifyText("SPREAD (ROIC-WACC)");
		VIPCustomPage.contents.RGvsASDetailedPeerBarChart1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASDetailedPeerBarChart2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASDetailedPeerBarChart3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASSIDropdown.click();
		VIPCustomPage.contents.IndRevGrowthRate.click();
		VIPCustomPage.contents.RGvsASDetailedChartHeader.verifyText("REVENUE GROWTH RATE");
		VIPCustomPage.contents.RGvsASDetailedPeerBarChart1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASDetailedPeerBarChart2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RGvsASDetailedPeerBarChart3.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_144");

		ReportLog.setTestCase("CUSTOM_Reg_Auto_145");
		String SpreadYr2 = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 93, 4); //2019
		String SpreadYr3 = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 93, 3); //2020
		String RevGrowthYr2 = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 119, 4); //2019
		String RevGrowthYr3 = TestDataHandler.getExcelData(testDataHandler.filePath, TargetCompanyName, 119, 3); //2020
		Date SpreadDate2 = oldFormat.parse(SpreadYr2);
        Date SpreadDate3 = oldFormat.parse(SpreadYr3);
		Date RevGrowthDate2 = oldFormat.parse(RevGrowthYr2);
        Date RevGrowthDate3 = oldFormat.parse(RevGrowthYr3);
		//Change time period format
		String newSpreadDate2 = newFormat.format(SpreadDate2);
        String newSpreadDate3 = newFormat.format(SpreadDate3);
		String newRevGrowthDate2 = newFormat.format(RevGrowthDate2);
        String newRevGrowthDate3 = newFormat.format(RevGrowthDate3);
		//Spread
		VIPCustomPage.contents.RGvsASSIDropdown.click();
		VIPCustomPage.contents.IndSpread.click();			
		VIPCustomPage.contents.SpreadDetailedPeerTimePeriod1.verifyText(newSpreadDate1);
		VIPCustomPage.contents.SpreadDetailedPeerTimePeriod2.verifyText(newSpreadDate2);
		VIPCustomPage.contents.SpreadDetailedPeerTimePeriod3.verifyText(newSpreadDate3);
		//Revenue Growth
		VIPCustomPage.contents.RGvsASSIDropdown.click();
		VIPCustomPage.contents.IndRevGrowthRate.click();			
		VIPCustomPage.contents.RevGrowthDetailedPeerTimePeriod1.verifyText(newRevGrowthDate1);
		VIPCustomPage.contents.RevGrowthDetailedPeerTimePeriod2.verifyText(newRevGrowthDate2);
		VIPCustomPage.contents.RevGrowthDetailedPeerTimePeriod3.verifyText(newRevGrowthDate3);
		WebControl.takeScreenshot("Custom_Reg_Auto_145");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String RGvsASTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RGvsASFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RGvsASTagline.equals("Spread Chart")) & (RGvsASFootnote.equals("Note: With net goodwill; Spread is equal to the post-tax Return on Invested Capital less the capital charge (ROIC*(1-Tr)-WACC), where Tr is the marginal tax rate; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
			VIPCustomPage.contents.DefaultTagline.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit tagline");
			VIPCustomPage.contents.DefaultFootnote.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit footnote");
			VIPCustomPage.contents.DefaultFootnote.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineFootnoteModalTitle.verifyText("Add Tagline and Footnote:");
			VIPCustomPage.contents.ModalTaglineHeader.verifyText("Tagline:");
			VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("263 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("596 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Spread Chart_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: With net goodwill; Spread is equal to the post-tax Return on Invested Capital less the capital charge (ROIC*(1-Tr)-WACC), where Tr is the marginal tax rate; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		else {
			VIPCustomPage.contents.DefaultTagline.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit tagline");
			VIPCustomPage.contents.DefaultFootnote.hover();
			VIPCustomPage.contents.TooltipText.verifyDisplayed(true, 5);
			VIPCustomPage.contents.TooltipText.verifyText("Click to edit footnote");
			VIPCustomPage.contents.DefaultFootnote.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineFootnoteModalTitle.verifyText("Add Tagline and Footnote:");
			VIPCustomPage.contents.ModalTaglineHeader.verifyText("Tagline:");
			VIPCustomPage.contents.TaglineTextBox.clear();
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Spread Chart_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: With net goodwill; Spread is equal to the post-tax Return on Invested Capital less the capital charge (ROIC*(1-Tr)-WACC), where Tr is the marginal tax rate; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("263 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("596 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Spread Chart_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: With net goodwill; Spread is equal to the post-tax Return on Invested Capital less the capital charge (ROIC*(1-Tr)-WACC), where Tr is the marginal tax rate; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Spread Chart_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: With net goodwill; Spread is equal to the post-tax Return on Invested Capital less the capital charge (ROIC*(1-Tr)-WACC), where Tr is the marginal tax rate; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
}
