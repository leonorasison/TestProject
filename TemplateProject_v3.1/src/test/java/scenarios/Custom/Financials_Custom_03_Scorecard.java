package scenarios.Custom;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCustomPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;


public class Financials_Custom_03_Scorecard extends TestBase{

	@Test(priority=1)
	public void Financials_CustomScorecard () throws Exception {
		ReportLog.setTestName("CUSTOM - Competitiveness Scorecard Dashboard");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness Scorecard Dashboard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_157");
		VIP_Common.LogInPage(testDataHandler);
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton.hover();
		//VIPLandingPage.contents.OverviewButtonTooltip.verifyText("Overview");
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		//NavigatetoFinancialsTab		
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionSVI.verifyText("Shareholder Value Indicators");
		VIPCustomPage.contents.SelectSectionFI.verifyText("Financial Indicators");
		VIPCustomPage.contents.SelectSectionRTD.verifyText("ROIC Tree Decomposition");
		VIPCustomPage.contents.SelectSectionOE.verifyText("Operational Excellence");
		WebControl.takeScreenshot("CUSTOM_RT_TC_157");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_158");
		//VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
		VIPFinancialsPage.contents.BestandRankCheckbox.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.ScorecardMetricTitle.verifyText("METRIC");
		VIPFinancialsPage.contents.ScorecardPercentileTitle.verifyText("PERCENTILE");
		//String Header = testDataHandler.company.substring(0, 18).toUpperCase();
		//VIPFinancialsPage.contents.ScorecardCompanyTitle.verifyText(Header);
		VIPFinancialsPage.contents.ScorecardPeerMedianTitle.verifyText("PEER MEDIAN");
		VIPFinancialsPage.contents.ScorecardBestTitle.verifyText("BEST");
		VIPFinancialsPage.contents.ScorecardRankTitle.verifyText("RANK");
		VIPFinancialsPage.contents.Scorecard2YrChangeTitle.verifyText("2 YEAR CHANGE");
        VIPFinancialsPage.contents.PercentileHeaderTooltip.verifyDisplayed(true, 5);
        //VIPFinancialsPage.contents.ScorecardCompanyTitle.verifyAttribute("title", testDataHandler.company);
        VIPFinancialsPage.contents.BestHeaderTooltip.verifyDisplayed(true, 5);
        VIPFinancialsPage.contents.RankHeaderTooltip.verifyDisplayed(true, 5);
        VIPFinancialsPage.contents.TwoYrChangeHeaderTooltip.verifyDisplayed(true, 5);
		
		VIPFinancialsPage.contents.BestandRankCheckbox.click();
		VIPFinancialsPage.contents.ScorecardBestTitle.verifyDisplayed(false, 5);
		VIPFinancialsPage.contents.ScorecardRankTitle.verifyDisplayed(false, 5);
		VIPFinancialsPage.contents.BestandRankCheckbox.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_158");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_159");
		VIPFinancialsPage.contents.ScoreCardDate.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_159");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_160");
		//FVI
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionSVI.click();
		VIPCustomPage.contents.ScorecardMetric1.verifyText("TRS DEVELOPMENT");
		VIPCustomPage.contents.ScorecardMetric1InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric1.verifyText("5-year Total Return to Shareholders");
		VIPCustomPage.contents.ScorecardSubMetric2.verifyText("3-year Total Return to Shareholders");
		VIPCustomPage.contents.ScorecardSubMetric3.verifyText("1-year Total Return to Shareholders");
		VIPCustomPage.contents.ScorecardMetric2.verifyText("3-YEAR TRS DECOMPOSITION");
		VIPCustomPage.contents.ScorecardSubMetric4.verifyText("Revenue Growth");
		VIPCustomPage.contents.ScorecardSubMetric5.verifyText("Excess change in EBIT Margin");
		VIPCustomPage.contents.ScorecardSubMetric6.verifyText("Investor Expectations");
		VIPCustomPage.contents.ScorecardSubMetric7.verifyText("Dividend Yield");
		VIPCustomPage.contents.ScorecardSubMetric8.verifyText("Capital Structure");
		VIPCustomPage.contents.ScorecardMetric3.verifyText("ANALYST OUTLOOK");
		VIPCustomPage.contents.ScorecardSubMetric9.verifyText("Rating Consensus");
		VIPCustomPage.contents.ScorecardSubMetric10.verifyText("1-year Share Price Growth");
		VIPCustomPage.contents.ScorecardSubMetric11.verifyText("3-year Revenue Growth CAGR");
		VIPCustomPage.contents.ScorecardSubMetric12.verifyText("3-year Operating Margin Delta");
		VIPCustomPage.contents.ScorecardMetric4.verifyText("ENTERPRISE VALUE DECOMPOSITION");
		VIPCustomPage.contents.ScorecardSubMetric13.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric1InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric14.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric2InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric15.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric3InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric16.verifyText("Current Value (in %)");
		VIPCustomPage.contents.ScorecardSubMetric17.verifyText("Future Value (in %)");
		WebControl.takeScreenshot("CUSTOM_RT_TC_160");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_161");
		//FI
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionFI.click();
		VIPCustomPage.contents.ScorecardMetric1.verifyText("VALUE CREATION");
		VIPCustomPage.contents.ScorecardSubMetric1.verifyText("ROIC (Pre-tax)");
		VIPCustomPage.contents.ScorecardSubMetric1InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric2.verifyText("WACC");
		VIPCustomPage.contents.ScorecardSubMetric2InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric3.verifyText("Spread");
		VIPCustomPage.contents.ScorecardSubMetric3InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardMetric2.verifyText("FINANCIAL MULTIPLES");
		VIPCustomPage.contents.ScorecardSubMetric4.verifyText("Invested Capital Premium (EV/IC)");
		VIPCustomPage.contents.ScorecardSubMetric4InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric5.verifyText("EV/EBIT");
		VIPCustomPage.contents.ScorecardSubMetric6.verifyText("EBIT/IC");
		VIPCustomPage.contents.ScorecardSubMetric7.verifyText("P/E (Trailing 12-Months)");
		VIPCustomPage.contents.ScorecardSubMetric8.verifyText("EV/EBITDA");
		VIPCustomPage.contents.ScorecardMetric3.verifyText("FINANCIAL LIQUIDITY");
		VIPCustomPage.contents.ScorecardSubMetric9.verifyText("Current Ratio");
		VIPCustomPage.contents.ScorecardSubMetric5InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric10.verifyText("Quick Ratio");
		VIPCustomPage.contents.ScorecardSubMetric6InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric11.verifyText("Interest Coverage");
		VIPCustomPage.contents.ScorecardSubMetric7InfoIcon.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_161");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_162");
		//RTD
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionRTD.click();
		VIPCustomPage.contents.ScorecardMetric1.verifyText("OPERATING MARGIN DECOMPOSITION");
		VIPCustomPage.contents.ScorecardSubMetric1.verifyText("Operating Margin");
		VIPCustomPage.contents.ScorecardSubMetric2.verifyText("Operating Expenses");
		VIPCustomPage.contents.ScorecardSubMetric3.verifyText("Cost of Goods Sold");
		VIPCustomPage.contents.ScorecardSubMetric4.verifyText("Selling, General & Admin. Expenses");
		VIPCustomPage.contents.ScorecardSubMetric5.verifyText("Depreciation & Amortization");
		VIPCustomPage.contents.ScorecardMetric2.verifyText("INVESTED CAPITAL DECOMPOSITION");
		VIPCustomPage.contents.ScorecardSubMetric6.verifyText("Capital Efficiency");
		VIPCustomPage.contents.ScorecardSubMetric1InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ScorecardSubMetric7.verifyText("Operating Working Capital");
		VIPCustomPage.contents.ScorecardSubMetric8.verifyText("Property, Plant & Equipment");
		VIPCustomPage.contents.ScorecardSubMetric9.verifyText("Goodwill & Intangibles");
		VIPCustomPage.contents.ScorecardSubMetric10.verifyText("Net Other Assets");
		VIPCustomPage.contents.ScorecardMetric3.verifyText("WORKING CAPITAL DECOMPOSITION");
		VIPCustomPage.contents.ScorecardSubMetric11.verifyText("Cash");
		VIPCustomPage.contents.ScorecardSubMetric12.verifyText("Net Receivables");
		VIPCustomPage.contents.ScorecardSubMetric13.verifyText("Inventory");
		VIPCustomPage.contents.ScorecardSubMetric14.verifyText("Other Current Assets");
		VIPCustomPage.contents.ScorecardSubMetric15.verifyText("Accounts Payables");
		VIPCustomPage.contents.ScorecardSubMetric16.verifyText("Taxes Payables");
		VIPCustomPage.contents.ScorecardSubMetric17.verifyText("Other Current Liabilities");
		WebControl.takeScreenshot("CUSTOM_RT_TC_162");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_163");
		//OE
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionOE.click();
		VIPCustomPage.contents.ScorecardMetric1.verifyText("CORPORATE AGILTY");
		VIPCustomPage.contents.ScorecardSubMetric1.verifyText("Cash Cycle");
		VIPCustomPage.contents.ScorecardSubMetric2.verifyText("Days Sales Outstanding");
		VIPCustomPage.contents.ScorecardSubMetric3.verifyText("Days Payables");
		VIPCustomPage.contents.ScorecardSubMetric4.verifyText("Days Inventory");
		VIPCustomPage.contents.ScorecardMetric2.verifyText("PEOPLE METRICS");
		VIPCustomPage.contents.ScorecardSubMetric5.verifyText("Overall");
		VIPCustomPage.contents.ScorecardSubMetric6.verifyText("Culture & Values");
		VIPCustomPage.contents.ScorecardSubMetric7.verifyText("Work/Life Balance");
		VIPCustomPage.contents.ScorecardSubMetric8.verifyText("Senior Management");
		VIPCustomPage.contents.ScorecardSubMetric9.verifyText("Compensation & Benefits");
		VIPCustomPage.contents.ScorecardSubMetric10.verifyText("Career Opportunities");
		VIPCustomPage.contents.ScorecardSubMetric11.verifyText("Recommend to a Friend");
		VIPCustomPage.contents.ScorecardSubMetric12.verifyText("CEO Approval");
		VIPCustomPage.contents.ScorecardSubMetric13.verifyText("Positive Business Outlook");
		WebControl.takeScreenshot("CUSTOM_RT_TC_163");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		//Scorecard1
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionSVI.click();
		VIPCustomPage.contents.DefaultTagline.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		String SVITagline = VIPCustomPage.contents.DefaultTagline.getText();
		String SVIFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((SVITagline.equals("Scorecard - Investor Focused")) & (SVIFootnote.equals("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("247 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Investor Focused_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scorecard - Investor Focused_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("247 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Investor Focused_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Investor Focused_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		
		//Scorecard2
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionFI.click();
		VIPCustomPage.contents.DefaultTagline.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		String FITagline = VIPCustomPage.contents.DefaultTagline.getText();
		String FIFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((FITagline.equals("Scorecard - Operating Performance")) & (FIFootnote.equals("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("242 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Operating Performance_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scorecard - Operating Performance_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("242 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Operating Performance_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Operating Performance_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		
		//Scorecard3
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionRTD.click();
		VIPCustomPage.contents.DefaultTagline.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		String RTDTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RTDFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RTDTagline.equals("Scorecard - Roic Framework")) & (RTDFootnote.equals("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("249 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Roic Framework_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scorecard - Roic Framework_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("249 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Roic Framework_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Roic Framework_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		
		//Scorecard4
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectSection.click();
		VIPCustomPage.contents.SelectSectionOE.click();
		VIPCustomPage.contents.DefaultTagline.verifyDisplayed(true, 5);
		Thread.sleep(1000);
		String OETagline = VIPCustomPage.contents.DefaultTagline.getText();
		String OEFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((OETagline.equals("Scorecard - Others")) & (OEFootnote.equals("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("257 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Others_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scorecard - Others_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("257 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("719 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Others_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scorecard - Others_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Target company is benchmarked vs. its peer group; Source: Annual and Quarterly reports; Accenture Client Value Services._test");
		
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
}
