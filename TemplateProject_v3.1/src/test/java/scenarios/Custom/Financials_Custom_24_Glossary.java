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
import java.util.Calendar;
import java.util.Date;

public class Financials_Custom_24_Glossary extends TestBase{
    
    @Test(priority=1)
	public void CUSTOM_Glossary () throws Exception {
		ReportLog.setTestName("CUSTOM - Glossary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");

        /* Glossary Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_213");
		VIP_Common.LogInPage(testDataHandler);
		WebControl.waitForPageToLoad(45);
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
		//VIPCustomPage.contents.FinancialsTabIcon.hover();
		//VIPCustomPage.contents.FinancialsTabIcon.verifyDisplayed(true, 10);
		VIPCustomPage.contents.FinancialsTab.hover();
		VIPCustomPage.contents.FinancialsTab.verifyDisplayed(true, 10);
		VIPCustomPage.contents.FinancialsTab.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Glossary Dashboard
		VIPCustomPage.contents.GlossaryMenu.click();
        VIPCustomPage.contents.DashboardHeader.verifyText("DASHBOARD");
		VIPCustomPage.contents.KeyIndicatorHeader.verifyText("KEY INDICATOR");
		VIPCustomPage.contents.DescriptionHeader.verifyText("DESCRIPTION");
        WebControl.takeScreenshot("Custom_Reg_Auto_213");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_214");
        VIPCustomPage.contents.Dashboard1.verifyText("Total Return to Shareholders");
		VIPCustomPage.contents.Dashboard2.verifyText("Strategic Control Map & Enterprise Value to Invested Capital Decomposition");
		VIPCustomPage.contents.Dashboard3.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPCustomPage.contents.Dashboard4.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPCustomPage.contents.Dashboard5.verifyText("EV Dissection (Future Value vs. Current Value)");
		VIPCustomPage.contents.Dashboard6.verifyText("EV Dissection (Future Value vs. Current Value)");
		VIPCustomPage.contents.Dashboard7.verifyText("Analyst Recommendations");
		VIPCustomPage.contents.Dashboard8.verifyText("Analyst Recommendations");
		VIPCustomPage.contents.Dashboard9.verifyText("Revenue and Profitability Estimates");
		VIPCustomPage.contents.Dashboard10.verifyText("Revenue and Profitability Estimates");
		VIPCustomPage.contents.Dashboard11.verifyText("Revenue and Profitability Estimates");
		VIPCustomPage.contents.Dashboard12.verifyText("Revenue Growth vs. Average Spread");
		VIPCustomPage.contents.Dashboard13.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard14.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard15.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard16.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard17.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard18.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard19.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard20.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard21.verifyText("Pre- Tax ROIC Decomposition");
		VIPCustomPage.contents.Dashboard22.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.Dashboard23.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.Dashboard24.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.Dashboard25.verifyText("Operating Working Capital Decomposition");
        VIPCustomPage.contents.Dashboard26.verifyText("Operating Working Capital Decomposition");
        VIPCustomPage.contents.Dashboard27.verifyText("Cash Cycle Analysis");
        VIPCustomPage.contents.Dashboard28.verifyText("Cash Cycle Analysis");
        VIPCustomPage.contents.Dashboard29.verifyText("Cash Cycle Analysis");
        VIPCustomPage.contents.Dashboard30.verifyText("Cash Cycle Analysis");
		VIPCustomPage.contents.Indicator1.verifyText("Total Return to Shareholders");
		VIPCustomPage.contents.Indicator2.verifyText("Premium on Invested Capital (EV/IC)");
		VIPCustomPage.contents.Indicator3.verifyText("EV/ EBIT");
		VIPCustomPage.contents.Indicator4.verifyText("Pre-Tax ROIC (EBIT/IC)");
		VIPCustomPage.contents.Indicator5.verifyText("Current Value");
		VIPCustomPage.contents.Indicator6.verifyText("Future Value");
		VIPCustomPage.contents.Indicator7.verifyText("Analyst Ratings");
		VIPCustomPage.contents.Indicator8.verifyText("Expected 1-Year Share Price Growth");
		VIPCustomPage.contents.Indicator9.verifyText("Revenue Growth Estimates");
		VIPCustomPage.contents.Indicator10.verifyText("EBIT Margin Estimates");
		VIPCustomPage.contents.Indicator11.verifyText("EBITDA Margin Estimates");
		VIPCustomPage.contents.Indicator12.verifyText("Spread");
		VIPCustomPage.contents.Indicator13.verifyText("EBIT Margin");
		VIPCustomPage.contents.Indicator14.verifyText("EBITDA Margin");
		VIPCustomPage.contents.Indicator15.verifyText("COGS/ Revenue");
		VIPCustomPage.contents.Indicator16.verifyText("SG&A/ Revenue");
		VIPCustomPage.contents.Indicator17.verifyText("Depreciation & Amortization / Revenue");
		VIPCustomPage.contents.Indicator18.verifyText("Capital Efficiency");
		VIPCustomPage.contents.Indicator19.verifyText("Working Capital / Revenue");
		VIPCustomPage.contents.Indicator20.verifyText("Net PPE/ Revenue");
		VIPCustomPage.contents.Indicator21.verifyText("Goodwill & Intangibles/ Revenue");
		VIPCustomPage.contents.Indicator22.verifyText("Operating cash/ Revenue");
		VIPCustomPage.contents.Indicator23.verifyText("Inventory/ Revenue");
		VIPCustomPage.contents.Indicator24.verifyText("Accounts Payable/ Revenue");
		VIPCustomPage.contents.Indicator25.verifyText("Net Receivables/ Revenue");
		VIPCustomPage.contents.Indicator26.verifyText("Inc Tax Payable / Revenue");
		VIPCustomPage.contents.Indicator27.verifyText("Cash Cycle");
		VIPCustomPage.contents.Indicator28.verifyText("Days Sales Outstanding");
		VIPCustomPage.contents.Indicator29.verifyText("Inventory Days");
		VIPCustomPage.contents.Indicator30.verifyText("Days Payable");
		VIPCustomPage.contents.Definition1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition7.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition8.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition9.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition10.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition11.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition12.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition13.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition14.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition15.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition16.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition17.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition18.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition19.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition20.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition21.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition22.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition23.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition24.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition25.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition26.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition27.verifyDisplayed(true, 5);
		VIPCustomPage.contents.Definition28.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Definition29.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Definition30.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_214");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String GlossaryTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String GlossaryFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((GlossaryTagline.equals("Glossary")) & (GlossaryFootnote.equals("Source: Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("267 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("805 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Glossary_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Glossary_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("267 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("805 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Glossary_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Glossary_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
    }

}
