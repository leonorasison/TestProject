package scenarios.PPT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.Comparator;
import java.util.Date;
import org.testng.annotations.Test;
import auto.framework.ReportLog;
import auto.framework.TestBase;
//import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCIAPage;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPFinancialsPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;


public class PPT_Download extends TestBase{
	
	public int SlideCount = 0;
	
	
	@Test(priority=1)
	public void TRS () throws Exception {
		ReportLog.setTestName("Common & Static Slides TCERs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("PPT_Reg_Auto_000_SlidesCounter");
		VIP_Common.LogInPage(testDataHandler);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.StartNowButton.click();
		if (VIPLandingPage.contents.DisclaimerModal.isDisplayed()) {
		VIPLandingPage.contents.DisclaimerModal.waitForExist(true, 10);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		}
		VIPLandingPage.contents.CompanyNameTextbox.waitForExist(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		//Revenue Growth Slide
		//To check if Target Company has Revenue Growth Adjusted and As Reported
		int RG = 1;
		if (VIPOverviewPage.contents.RevenueiIcon.isDisplayed()) { 
			RG = 2; 
		}
		//Hospitality Slide
		//To check if Target Company is under Hospitality industry
		int HospitalitySlideCount = 0;
		if (VIPOverviewPage.contents.RevenueiIcon.isDisplayed()) { 
			HospitalitySlideCount = 7; 
		}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		//Opex View Slide
		//To check if Target Company falls in OpEx view or SGA and COGS view
		int OV = 2;
		if (VIPFinancialsPage.contents.OPEXMetricTitle.isDisplayed()) {
			OV = 1;
		}
		//Business Segment Slide
		//To check if Target Company has Business Segment slides and count if there is any
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		int BSSlideCount = 0;
		if (VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.isDisplayed()) {
			VIPFinancialsPage.contents.BusinessSegmentAnalysisMenu.click();
			VIPFinancialsPage.contents.SegmentDropdown.waitForExist(true, 10);
			VIPFinancialsPage.contents.SegmentDropdown.click();
			VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
			int RGY = 0; int EBIT = 0; int AT = 0; int PBT = 0;
			if (VIPFinancialsPage.contents.RGYBarChartTitle2.isDisplayed()) {
				RGY = 1;
			}
			if (VIPFinancialsPage.contents.ATBarChartTitle2.isDisplayed()) {
				AT = 1;
			}
			if (VIPFinancialsPage.contents.EBITChartTitle2.isDisplayed()) {
				EBIT = 1;
			}
			if (VIPFinancialsPage.contents.PBTChartTitle.isDisplayed()) {
				PBT = 1;
			}
			BSSlideCount = RGY + EBIT + AT + PBT;
		}
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		//Geographic Segment Slide
		//To check if Target Company has Geographic Segment slides and count if there is any
		int GSSlideCount = 0;
		if (VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.isDisplayed()) {
			VIPFinancialsPage.contents.GeographicSegmentAnalysisMenu.click();
			VIPFinancialsPage.contents.SegmentDropdown.waitForExist(true, 10);
			VIPFinancialsPage.contents.SegmentDropdown.click();
			VIPFinancialsPage.contents.SegmentDropdownMenu2.click();
			int RGY = 0; int AT = 0; int EBIT = 0; int PBT = 0;
			if (VIPFinancialsPage.contents.RGYBarChartTitle2.isDisplayed()) {
				RGY = 1;
			}
			if (VIPFinancialsPage.contents.ATBarChartTitle2.isDisplayed()) {
				AT = 1;
			}
			if (VIPFinancialsPage.contents.EBITChartTitle2.isDisplayed()) {
				EBIT = 1;
			}
			if (VIPFinancialsPage.contents.PBTChartTitle.isDisplayed()) {
				PBT = 1;
			}
			GSSlideCount = RGY + AT + EBIT + PBT;
		}
		//Segment Content Slide
		//To check if Segment Content Slide should be available
		int SegmentCSlideCount = 0;
		if (VIPFinancialsPage.contents.RGYBarChartTitle2.isDisplayed() || VIPFinancialsPage.contents.ATBarChartTitle2.isDisplayed() || 
			VIPFinancialsPage.contents.PBTChartTitle.isDisplayed() || VIPFinancialsPage.contents.RGYBarChartTitle2.isDisplayed() || 
			VIPFinancialsPage.contents.ATBarChartTitle2.isDisplayed()) {
			SegmentCSlideCount = 1;
		}
		//Financial Total Slide Count
		//(35) default slides for Financials
		int FinancialsSlideCount = 35 + BSSlideCount + GSSlideCount + SegmentCSlideCount + OV + RG;
		System.out.println("Financials Slide Count: " + FinancialsSlideCount);
		System.out.println("Business Segment Slide Count: " + BSSlideCount);
		System.out.println("Geo Segment Slide Count: " + GSSlideCount);
		System.out.println("Segment Content Slide Count: " + SegmentCSlideCount);
		System.out.println("Opex View Slide Count: " + OV);
		System.out.println("Revenue Growth Slide Count: " + RG);
		//CIA Slide
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.BurgerMenu.waitForExist(true, 10);
		VIPCIAPage.contents.BurgerMenu.click();
		VIPCIAPage.contents.SideMenuCIAClick.waitForExist(true, 5);
		VIPCIAPage.contents.SideMenuCIAClick.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCIAPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCIAPage.contents.SelectDashboardDropdown.click();
		VIPCIAPage.contents.DashboardDropdownMenu2.waitForExist(true, 10);
		VIPCIAPage.contents.DashboardDropdownMenu2.click();
		Thread.sleep(2000);
		VIPCIAPage.contents.DetailedAnalysisToggle.waitForExist(true, 10);
		VIPCIAPage.contents.DetailedAnalysisToggle.click();
		Thread.sleep(2000);
		VIPCIAPage.contents.SelectPeriodDropdown.waitForExist(true, 10);
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		//Gross Burn Rate Runway
		int GBRR = 1;  
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { GBRR = 2; }
		//Cash & Short Term Investments
		int CSIR = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu2.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { CSIR = 2; }
		//Quick Ratio
		int QR = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu3.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { QR = 2; }
		//Inventory / Revenue
		int IR = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu4.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { IR = 2; }
		//Accounts Payable / Revenue
		int PR = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu5.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { PR = 2; }
		//Net Receivables / Revenue
		int RR = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu6.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { RR = 2; }
		//Net Debt / FCF
		int NDF = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu7.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { NDF = 2; }
		//Total Debr / Equity
		int TDE = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu8.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { TDE = 2; }
		//Interest Coverage
		int IC = 1;
		VIPCIAPage.contents.SelectViewDropdown.click();
		VIPCIAPage.contents.ViewDropdownMenu9.click();
		VIPCIAPage.contents.SelectPeriodDropdown.click();
		if (VIPCIAPage.contents.PeriodDropdownMenu2.isDisplayed()) { IC = 2; }
		//(8) CIA Content Slide + CIA TRS, L&S, 5 Change in Analyst Outlook
		int CIASlideCount = 8 + GBRR + CSIR + QR + IR + PR + RR + NDF + TDE + IC;
		System.out.print("Slide Count for CIA"+ CIASlideCount);
		//ESG Slide
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuESG.click();
		VIPFinancialsPage.contents.ESGDisclaimerModalAccept.waitForExist(true, 10);
		VIPFinancialsPage.contents.ESGDisclaimerModalAccept.click();
		do {
			Thread.sleep(1500);
		}
		while (VIPFinancialsPage.contents.ESGLoadingBar.isDisplayed());
		Thread.sleep(2000);
		int ESGSlideCount = 0;
		if (VIPFinancialsPage.contents.ESGMainTitle.isDisplayed()) {
			ESGSlideCount = 5;
		}
		
		ReportLog.setTestCase("PPT_Reg_Auto_001_&_002");
		TestDataHandler.initPPT(testDataHandler.pptFilePath);
		//Slide 2 Title
		TestDataHandler.verifyPPTTextFontSize(2, 1, "32.0");
		TestDataHandler.verifyPPTTextFontColor(2, 1, "Purple");
		TestDataHandler.verifyPPTText(2, 1, "DISCLAIMER");
		//Slide 4 Title
		TestDataHandler.verifyPPTTextFontSize(4, 3, "32.0");
		TestDataHandler.verifyPPTTextFontColor(4, 3, "Purple");
		TestDataHandler.verifyPPTText(4, 3, "Shareholder Value Analysis: In a Snapshot");
		//Slide 6 Title
		TestDataHandler.verifyPPTTextFontSize(6, 2, "32.0");
		TestDataHandler.verifyPPTTextFontColor(6, 2, "Purple");
		TestDataHandler.verifyPPTText(6, 2, "COMPANY OVERVIEW");
		//Slide 7 Title
		TestDataHandler.verifyPPTTextFontSize(7, 2, "32.0");
		TestDataHandler.verifyPPTTextFontColor(7, 2, "Purple");
		TestDataHandler.verifyPPTText(7, 2, "SEGMENT OVERVIEW");
		
		ReportLog.setTestCase("PPT_Reg_Auto_009");
		TestDataHandler.verifyPPTText(1, 1, "Value Insights Platform  –  Self-Service Value Report ");
		TestDataHandler.verifyPPTText(1, 2, testDataHandler.company);
		TestDataHandler.verifyPPTText(1, 3, "SELF-SERVICE REPORT");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy");
		TestDataHandler.verifyPPTText(1, 4, format.format(date));
		
		ReportLog.setTestCase("PPT_Reg_Auto_010_Disclaimer");
		//Disclaimer Slide
		TestDataHandler.verifyPPTText(2, 1, "DISCLAIMER");
		TestDataHandler.verifyPPTTextFontSize(2, 1, "32.0");
		TestDataHandler.verifyPPTTextFontColor(2, 1, "Purple");
		TestDataHandler.verifyPPTText(2, 2, "This Self-Service Value Report and the analysis contained in it was prepared based on financials sourced from S&P Capital IQ. The data has not been normalized per Accenture’s standard Shareholder Value Analysis (SVA) methodology. The analysis contained herein is based on key assumptions described in the ‘Methodology’ section. ");
		TestDataHandler.verifyPPTTextFontSize(2, 2, "16.0");
		TestDataHandler.verifyPPTTextFontColor(2, 2, "Black");
		
		ReportLog.setTestCase("PPT_Reg_Auto_010_Methodology");
		//Methodology Slide - Title
		//(7) Slides 1 to 7
		//(4) Content Slide for Appendix, 3 Key Executives Slides
		SlideCount = 7 + FinancialsSlideCount + CIASlideCount + HospitalitySlideCount + ESGSlideCount + 4 + 1;
		System.out.print("Slide Count before Methodology"+ SlideCount);
		TestDataHandler.verifyPPTText(SlideCount, 1, "METHODOLOGY");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "32.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Purple");
		//Methodology Slide - Table Header
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 1, "Key Items ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 2, 1, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 2, 1, 1, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 1, "Description");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 2, 2, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 2, 2, 1, "Black");
		//Methodology Slide - Table Row 1
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 2, "Financial Reporting");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 2, 1, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 2, 1, 2, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 2, "Original (as reported) financials from S&P Capital IQ are used for the analysis. Press releases are not considered as they often have incomplete financials");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 2, 2, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 2, 2, 2, "Black");
		//Methodology Slide - Table Row 2
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 3, "Year Alignment");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 3, "Any company with Fiscal Year (FY) end from Jan-May will be labeled as previous year (e.g. FY end Apr 2018 will be considered as 2017)");
		//Methodology Slide - Table Row 3
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 4, "Peer Median");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 4, "Median is calculated excluding the target company");
		//Methodology Slide - Table Row 4
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 5, "Capital Efficiency Ratios");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 5, "Balance sheet components have been taken as average of last two periods except case of Q1 where average of Q1 and 1-yr previous FY is used");
		//Methodology Slide - Table Row 5
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 6, "Trailing Twelve Months (TTM) Calculations");
//		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 6, "Income statement: If detailed breakup of operating expenses are not available, COGS and SG&A are calculated using the same proportion of the total operating expenses as in the last FY\n"
//				+ "Balance Sheet:\n"
//				+ "i. Working Capital components such as cash, inventory, receivables, payables have been calculated using the same proportion of current assets or current liabilities as in the last FY given limited disclosure in quarterly reports\n"
//				+ "ii. Components of non-current assets/liabilities have been carried forward from last FY if not reported\n"
//				+ "Other assumptions: Numbers are carried forward from last FY if they are not available in TTM, e.g. operating leases, unfunded pension liabilities, number of employees, cost of debt etc.");
		//Methodology Slide - Table Row 6
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 7, "Unfunded Retirement Liabilities Adjustments");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 7, "Unfunded Pension and Other Post Employment Benefits have been adjusted across all companies");
		//Methodology Slide - Table Row 7
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 8, "Operating Leases Adjustments");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 8, "Operating lease adjustments are made to historical periods based on the company’s latest accounting standard. Some Japanese and Korean companies may have limited disclosure for operating leases and hence these may not have a similar lease adjustment");
		//Methodology Slide - Table Row 8
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 1, 9, "Data Release");
		TestDataHandler.verifyPPTTableText(SlideCount, 2, 2, 9, "Financial data released through only original filings has been considered for TTM period. If the latest financial data available is through a press release, data from the most recent original filing has been used");
		
		ReportLog.setTestCase("PPT_Reg_Auto_010_Glossary_1");
		//Glossary Slide 1 - Title
		SlideCount = 7 + FinancialsSlideCount + CIASlideCount + HospitalitySlideCount + ESGSlideCount + 4 + 2;
		TestDataHandler.verifyPPTText(SlideCount, 1, "GLOSSARY (1/4)");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "32.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Black");
		//Glossary Slide 1 - Table Header
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 1, "Key Indicators");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount + 1, 3, 1, 1, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 1, "Description");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 1, "Black");
		//Glossary Slide 1 - Table Row 1
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 2, "Total Return to Shareholders");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 2, "Black");
//		TestDataHandler.verifyPPTTableText(SlideCount + 1, 3, 2, 2, "TRS is total financial return a shareholder would make from holding the company’s stock. It is measured as sum of capital appreciation and dividends received by a shareholder. The TRS represents the ending value of an initial investment of GBP 1.00 in a company (for example: GBP 1.00 invested in GlaxoSmithKline plc on May 29, 2020 would be worth GBP 0.85 on May 28, 2021).");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 2, "Black");
		//Glossary Slide 1 - Table Row 2
//		TestDataHandler.verifyPPTTableText(SlideCount + 1, 3, 1, 3, "Premium on Invested Capital \n" + "(EV / IC)");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 3, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 3, "EV / IC ratio measures the premium assigned by the market, per unit of company's invested capital. Key drivers of premium are operating performance and/or future expectations.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 3, "Black");
		//Glossary Slide 1 - Table Row 3
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 4, "EV / EBIT");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 4, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 4, "EV / EBIT is a valuation metric which measures how many times the Operating Enterprise Value of a company is valued against its annual EBIT.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 4, "Black");
		//Glossary Slide 1 - Table Row 4
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 5, "Pre-Tax ROIC (EBIT / IC)");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 5, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 5, "Pre-tax ROIC represents a company's efficiency in generating profits from its core operations. It is calculated by dividing a company's Earnings Before Interest and Taxes (EBIT) by the average Invested Capital.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 5, "Black");
		//Glossary Slide 1 - Table Row 5
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 6, "Analyst Ratings");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 6, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 6, "Analyst consensus rating is the average of analysts' buy-hold-sell rating about a stock's share price performance over the next one year.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 6, "Black");
		//Glossary Slide 1 - Table Row 6
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 7, "Expected 1-Year Share Price Growth");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 7, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 7, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 7, "Analysts' estimated share price change in next 1 year compared to current price level.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 7, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 7, "Black");
		//Glossary Slide 1 - Table Row 7
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 8, "Buy %");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 8, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 8, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 8, "Buy % indicates the percentage of analysts who have given the firm's stock a buy rating as opposed to hold or sell.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 8, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 8, "Black");
		//Glossary Slide 1 - Table Row 8
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 9, "Revenue Growth Estimates");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 9, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 9, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 9, "Revenue Growth Estimates are based on the average analyst consensus revenue forecasts for a given period.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 9, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 9, "Black");
		//Glossary Slide 1 - Table Row 9
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 10, "EBIT Margin Estimates");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 10, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 10, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 10, "EBIT margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest and taxes as a percentage of revenues. EBIT Margin Estimates are based on the average analyst consensus EBIT margin forecast for a given period.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 10, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 10, "Black");
		//Glossary Slide 1 - Table Row 10
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 11, "EBITDA Margin Estimates");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 11, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 11, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 11, "EBITDA margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest, taxes, depreciation, and amortization as a percentage of revenues. EBITDA Margin Estimates are based on the average analyst consensus EBITDA margin forecast for a given period.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 11, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 11, "Black");
		
		ReportLog.setTestCase("PPT_Reg_Auto_010_Glossary_2");
		SlideCount = 7 + FinancialsSlideCount + CIASlideCount + HospitalitySlideCount + ESGSlideCount + 4 + 3;
		//Glossary Slide 2 - Title
		TestDataHandler.verifyPPTText(SlideCount, 1, "GLOSSARY (2/4)");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "32.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Black");
		//Glossary Slide 2 - Table Header
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 1, "Key Indicators");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 1, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 1, "Description");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 1, "Black");
		//Glossary Slide 2 - Table Row 1
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 2, "EBIT Margin");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 2, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 2, "EBIT margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest and taxes as a percentage of revenues. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 2, "Black");
		//Glossary Slide 2 - Table Row 2
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 3, "EBITDA Margin");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 3, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 3, "EBITDA margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest, taxes, depreciation, and amortization as a percentage of revenues. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 3, "Black");
		//Glossary Slide 2 - Table Row 3
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 4, "COGS / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 4, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 4, "COGS / Revenue indicates COGS as a percentage of sales, where Cost of goods sold (COGS) refers to the direct costs of producing the goods or services sold by a company. This amount includes the cost of the production and labor directly used to manufacture the goods or deliver the services.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 4, "Black");
		//Glossary Slide 2 - Table Row 4
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 5, "SG&A / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 5, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 5, "SG&A / Revenue indicates SG&A as a percentage of sales, where SG&A refers to the sum of all sales, marketing, general, administrative and other overhead expenses of a company.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 5, "Black");
		//Glossary Slide 2 - Table Row 5
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 6, "Depreciation & Amortization / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 6, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 6, "Depreciation & Amortization / Revenue indicates total annual depreciation and amortization cost as a percentage of sales. Depreciation is the expensing of a fixed asset (or Plant, Property & Equipment) over its useful life. Amortization is the practice of spreading an intangible asset's cost over that asset's useful life. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 6, "Black");
		//Glossary Slide 2 - Table Row 6
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 7, "Capital Efficiency ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 7, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 7, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 7, "Capital efficiency measures revenue generated by a company, per unit of capital invested in the business. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 7, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 7, "Black");
		//Glossary Slide 2 - Table Row 7
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 8, "Working Capital / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 8, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 8, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 8, "Working capital is a measure of net short-term capital invested in a business. Key components include Cash, Receivables, Inventory and Payables. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 8, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 8, "Black");
		//Glossary Slide 2 - Table Row 8
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 1, 9, "Net PPE / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 1, 9, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 1, 9, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 3, 2, 9, "Net PPE /Revenue measures how efficiently the company is generating sales from its Net PPE or Fixed Assets Investments. Net PPE is abbreviation for Net Property, Plant and Equipment and it is calculated as Gross PPE – Accumulated Depreciation.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 3, 2, 9, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 3, 2, 9, "Black");
		
		ReportLog.setTestCase("PPT_Reg_Auto_010_Glossary_3");
		SlideCount = 7 + FinancialsSlideCount + CIASlideCount + HospitalitySlideCount + ESGSlideCount + 4 + 4;
		//Glossary Slide 3 - Title
		TestDataHandler.verifyPPTText(SlideCount, 3, "GLOSSARY (3/4)");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 3, "32.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 3, "Black");
		//Glossary Slide 3 - Table Header
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 1, "Key Indicators");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 1, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 1, "Description");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 1, "Black");
		//Glossary Slide 3 - Table Row 1
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 2, "Goodwill & Intangibles / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 2, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 2, "Goodwill & Intangibles / Revenue indicates Goodwill and Other Intangibles of a company as percentage of sales. Goodwill is an intangible asset that is associated with the purchase of one company by another. It is the portion of the purchase price that is higher than the net fair value of the acquired company. Items included in goodwill (example: brand reputation, customer loyalty, company’s R&D record) are not easily quantifiable. Other intangibles (excl. Goodwill) are non-physical but identifiable assets e.g. copyrights, patents, licensing agreements. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 2, "Black");
		//Glossary Slide 3 - Table Row 2
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 3, "Operating cash / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 3, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 3, "Operating cash / Revenue is the ratio of average cash and cash equivalents held by a company to its revenue. Cash and Cash Equivalents represents funds in the form of cash or readily convertible deposits, securities and other instruments having maturities of less than 3 months at the time of purchase.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 3, "Black");
		//Glossary Slide 3 - Table Row 3
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 4, "Inventory / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 4, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 4, "Inventory / Revenue is the ratio of the average inventory being held by the company to its revenues. Companies from specific industries (e.g. technology services) might not have a separate line item as Inventory in their Balance Sheet.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 4, "Black");
		//Glossary Slide 3 - Table Row 4
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 5, "Accounts Payable / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 5, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 5, "Accounts Payable / Revenue is the ratio of the amount the company owes to its vendors or suppliers, to the revenue it generates. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 5, "Black");
		//Glossary Slide 3 - Table Row 5
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 6, "Net Receivables / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 6, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 6, "Net Receivables / Revenue is the ratio of the amount owed by the customers to the company to its revenue generated.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 6, "Black");
		//Glossary Slide 3 - Table Row 6
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 7, "Inc Tax Payable / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 7, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 7, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 7, "Income tax payable / Revenue depicts income taxes due to the government and payable within one year as a percentage revenues.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 7, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 7, "Black");
		//Glossary Slide 3 - Table Row 7
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 8, "Cash Cycle ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 8, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 8, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 8, "Cash Cycle Days is defined as Days Sales Outstanding + Days Inventory Outstanding - Days Payables Outstanding. It measures the number of days it takes a company to convert resource inputs into cash flows.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 8, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 8, "Black");
		//Glossary Slide 3 - Table Row 8
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 9, "Days Sales Outstanding");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 9, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 9, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 9, "Days sales outstanding (DSO) measures the number of days it takes a company to collect payment after a sale has been made.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 9, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 9, "Black");
		//Glossary Slide 3 - Table Row 9
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 10, "Inventory Days");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 10, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 10, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 10, "Inventory days is a measure of time taken by a company to turn its inventory into sales. ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 10, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 10, "Black");
		
		ReportLog.setTestCase("PPT_Reg_Auto_010_Glossary_4");
		SlideCount = 7 + FinancialsSlideCount + CIASlideCount + HospitalitySlideCount + ESGSlideCount + 4 + 5;
		//Glossary Slide 4 - Title
		TestDataHandler.verifyPPTText(SlideCount, 3, "GLOSSARY (4/4)");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 3, "32.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 3, "Black");
		//Glossary Slide 4 - Table Header
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 1, "Key Indicators");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 1, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 1, "Description");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 1, "14.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 1, "Black");
		//Glossary Slide 4 - Table Row 1
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 2, "Gross Burn Rate Runway");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 2, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 2, "Gross Burn Rate Runway for a company measures the number of months for which the company can continue to pay for operating expenses before it runs out of cash. It is calculated as = (Cash & Cash Equivalents + Short Term Investments) / Monthly Operating Expenses.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 2, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 2, "Black");
		//Glossary Slide 4 - Table Row 2
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 3, "Cash & ST Investments / Revenue");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 3, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 3, "Cash & Short-term Investments/ Revenue is a measure the company's liquidity. Short term investments are marketable securities or highly liquid assets that company can convert into cash easily.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 3, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 3, "Black");
		//Glossary Slide 4 - Table Row 3
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 4, "Quick Ratio");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 4, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 4, "Quick Ratio (Acid test ratio) is one of the indicators of a company’s short-term liquidity position and measures a company’s ability to meet its short-term liabilities with its liquid assets. These assets are called “quick” assets as they can be quickly converted into cash. Quick Ratio = (Total Current Assets – Inventory) / Total Current Liabilities.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 4, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 4, "Black");
		//Glossary Slide 4 - Table Row 4
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 5, "Total Debt / Equity ");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 5, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 5, "Total Debt / Equity is the ratio of the company’s total debt divided by market value of equity. The ratio is used to evaluate a company's financial leverage. It is a measure of the degree to which a company is financing its operations through debt versus wholly-owned funds.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 5, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 5, "Black");
		//Glossary Slide 4 - Table Row 5
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 1, 6, "Interest Coverage");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 1, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 1, 6, "Black");
		TestDataHandler.verifyPPTTableText(SlideCount, 4, 2, 6, "Interest Coverage is a ratio used to determine how easily a company can pay interest on its outstanding debt. The interest coverage ratio is calculated by dividing a company's earnings before interest and taxes (EBIT) during a given period by the company's interest payments due within the same period.");
		TestDataHandler.verifyPPTTableTextFontSize(SlideCount, 4, 2, 6, "12.0");
		TestDataHandler.verifyPPTTableTextFontColor(SlideCount, 4, 2, 6, "Black");
		
		//TRS Definition on Glossary
		ReportLog.setTestCase("PPT_Reg_Auto_011");
		SlideCount = 7 + FinancialsSlideCount + CIASlideCount + HospitalitySlideCount + ESGSlideCount + 4 + 2;
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		Thread.sleep(1500);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SelectDashboardDropdown.waitForExist(true, 45);
		VIPFinancialsPage.contents.SelectDashboardDropdown.click();
		VIPFinancialsPage.contents.SelectDropDown13.click();
		String TRSDef = TestDataHandler.getPPTTableText(SlideCount, 3, 2, 2);
		VIPFinancialsPage.contents.Definition1.verifyText(TRSDef);

		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_01");
		//Contents Slide 01
		TestDataHandler.verifyPPTText(3, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(3, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(3, 1, "Black");
		TestDataHandler.verifyPPTText(3, 8, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(3, 8, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 8, "Black");
		TestDataHandler.verifyPPTText(3, 9, "01");
		TestDataHandler.verifyPPTTextFontSize(3, 9, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 9, "White");
		TestDataHandler.verifyPPTText(3, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(3, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 2, "Black");
		TestDataHandler.verifyPPTText(3, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(3, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 3, "White");
		TestDataHandler.verifyPPTText(3, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(3, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 4, "Black");
		TestDataHandler.verifyPPTText(3, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(3, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 5, "White");
		TestDataHandler.verifyPPTText(3, 6, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(3, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 6, "Black");
		TestDataHandler.verifyPPTText(3, 7, "04");
		TestDataHandler.verifyPPTTextFontSize(3, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 7, "White");
		if (HospitalitySlideCount != 0 && ESGSlideCount != 0) {
		TestDataHandler.verifyPPTText(3, 10, "OPERATING METRICS");
		TestDataHandler.verifyPPTTextFontSize(3, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 10, "Black");
		TestDataHandler.verifyPPTText(3, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(3, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 11, "White");
		TestDataHandler.verifyPPTText(3, 12, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(3, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 12, "Black");
		TestDataHandler.verifyPPTText(3, 13, "06");
		TestDataHandler.verifyPPTTextFontSize(3, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 13, "White");
		TestDataHandler.verifyPPTText(3, 14, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(3, 14, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 14, "Black");
		TestDataHandler.verifyPPTText(3, 15, "07");
		TestDataHandler.verifyPPTTextFontSize(3, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 15, "White");
		}
		if (HospitalitySlideCount != 0 && ESGSlideCount == 0){
		TestDataHandler.verifyPPTText(3, 10, "OPERATING METRICS");
		TestDataHandler.verifyPPTTextFontSize(3, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 10, "Black");
		TestDataHandler.verifyPPTText(3, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(3, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 11, "White");
		TestDataHandler.verifyPPTText(3, 12, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(3, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 12, "Black");
		TestDataHandler.verifyPPTText(3, 13, "06");
		TestDataHandler.verifyPPTTextFontSize(3, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 13, "White");
		}
		if (HospitalitySlideCount == 0 && ESGSlideCount != 0) {
		TestDataHandler.verifyPPTText(3, 10, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(3, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 10, "Black");
		TestDataHandler.verifyPPTText(3, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(3, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 11, "White");
		TestDataHandler.verifyPPTText(3, 12, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(3, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 12, "Black");
		TestDataHandler.verifyPPTText(3, 13, "06");
		TestDataHandler.verifyPPTTextFontSize(3, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 13, "White");
		}
		if (HospitalitySlideCount == 0 && ESGSlideCount == 0) {
		TestDataHandler.verifyPPTText(3, 10, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(3, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(3, 10, "Black");
		TestDataHandler.verifyPPTText(3, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(3, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(3, 11, "White");
		}
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_02");
		//Contents Slide 02
		TestDataHandler.verifyPPTText(5, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(5, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(5, 1, "Black");
		TestDataHandler.verifyPPTText(5, 6, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(5, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 6, "Black");
		TestDataHandler.verifyPPTText(5, 7, "01");
		TestDataHandler.verifyPPTTextFontSize(5, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 7, "White");
		TestDataHandler.verifyPPTText(5, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(5, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 2, "Black");
		TestDataHandler.verifyPPTText(5, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(5, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 3, "White");
		TestDataHandler.verifyPPTText(5, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(5, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 4, "Black");
		TestDataHandler.verifyPPTText(5, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(5, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 5, "White");
		TestDataHandler.verifyPPTText(5, 8, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(5, 8, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 8, "Black");
		TestDataHandler.verifyPPTText(5, 9, "04");
		TestDataHandler.verifyPPTTextFontSize(5, 9, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 9, "White");
		if (HospitalitySlideCount != 0 && ESGSlideCount != 0) {
		TestDataHandler.verifyPPTText(5, 10, "OPERATING METRICS");
		TestDataHandler.verifyPPTTextFontSize(5, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 10, "Black");
		TestDataHandler.verifyPPTText(5, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(5, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 11, "White");
		TestDataHandler.verifyPPTText(5, 13, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(5, 13, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 13, "Black");
		TestDataHandler.verifyPPTText(5, 15, "06");
		TestDataHandler.verifyPPTTextFontSize(5, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 15, "White");
		TestDataHandler.verifyPPTText(5, 16, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(5, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 16, "Black");
		TestDataHandler.verifyPPTText(5, 17, "07");
		TestDataHandler.verifyPPTTextFontSize(5, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 17, "White");
		}
		if (HospitalitySlideCount != 0 && ESGSlideCount == 0){
		TestDataHandler.verifyPPTText(5, 10, "OPERATING METRICS");
		TestDataHandler.verifyPPTTextFontSize(5, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 10, "Black");
		TestDataHandler.verifyPPTText(5, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(5, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 11, "White");
		TestDataHandler.verifyPPTText(5, 13, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(5, 13, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 13, "Black");
		TestDataHandler.verifyPPTText(5, 15, "06");
		TestDataHandler.verifyPPTTextFontSize(5, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 15, "White");
		}
		if (HospitalitySlideCount == 0 && ESGSlideCount != 0) {
		TestDataHandler.verifyPPTText(5, 10, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(5, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 10, "Black");
		TestDataHandler.verifyPPTText(5, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(5, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 11, "White");
		TestDataHandler.verifyPPTText(5, 13, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(5, 13, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 13, "Black");
		TestDataHandler.verifyPPTText(5, 15, "06");
		TestDataHandler.verifyPPTTextFontSize(5, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 15, "White");
		}
		if (HospitalitySlideCount == 0 && ESGSlideCount == 0) {
		TestDataHandler.verifyPPTText(5, 10, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(5, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(5, 10, "Black");
		TestDataHandler.verifyPPTText(5, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(5, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(5, 11, "White");
		}

		ReportLog.setTestCase("PPT_CHECK_OBJECT");
		System.out.println("getPPTText_1: " + TestDataHandler.getPPTText(8, 1));
		System.out.println("getPPTText_2: " + TestDataHandler.getPPTText(8, 2));
		System.out.println("getPPTText_3: " + TestDataHandler.getPPTText(8, 3));
		System.out.println("getPPTText_4: " + TestDataHandler.getPPTText(8, 4));
		System.out.println("getPPTText_5: " + TestDataHandler.getPPTText(8, 5));
		System.out.println("getPPTText_6: " + TestDataHandler.getPPTText(8, 6));
		System.out.println("getPPTText_7: " + TestDataHandler.getPPTText(8, 7));
		System.out.println("getPPTText_8: " + TestDataHandler.getPPTText(8, 8));
		System.out.println("getPPTText_9: " + TestDataHandler.getPPTText(8, 9));
		System.out.println("getPPTText_10: " + TestDataHandler.getPPTText(8, 10));
		System.out.println("getPPTText_11: " + TestDataHandler.getPPTText(8, 11));
		System.out.println("getPPTText_12: " + TestDataHandler.getPPTText(8, 12));
		System.out.println("getPPTText_13: " + TestDataHandler.getPPTText(8, 13));
		System.out.println("getPPTText_14: " + TestDataHandler.getPPTText(8, 14));
		System.out.println("getPPTText_15: " + TestDataHandler.getPPTText(8, 15));
		System.out.println("getPPTText_16: " + TestDataHandler.getPPTText(8, 16));
		System.out.println("getPPTText_17: " + TestDataHandler.getPPTText(8, 17));
		System.out.println("getPPTText_18: " + TestDataHandler.getPPTText(8, 18));
		System.out.println("getPPTTextFontColor_1: " + TestDataHandler.getPPTTextFontColor(8, 1));
		System.out.println("getPPTTextFontColor_2: " + TestDataHandler.getPPTTextFontColor(8, 2));
		System.out.println("getPPTTextFontColor_3: " + TestDataHandler.getPPTTextFontColor(8, 3));
		System.out.println("getPPTTextFontColor_4: " + TestDataHandler.getPPTTextFontColor(8, 4));
		System.out.println("getPPTTextFontColor_5: " + TestDataHandler.getPPTTextFontColor(8, 5));
		System.out.println("getPPTTextFontColor_6: " + TestDataHandler.getPPTTextFontColor(8, 6));
		System.out.println("getPPTTextFontColor_7: " + TestDataHandler.getPPTTextFontColor(8, 7));
		System.out.println("getPPTTextFontColor_8: " + TestDataHandler.getPPTTextFontColor(8, 8));
		System.out.println("getPPTTextFontColor_9: " + TestDataHandler.getPPTTextFontColor(8, 9));
		System.out.println("getPPTTextFontColor_10: " + TestDataHandler.getPPTTextFontColor(8, 10));
		System.out.println("getPPTTextFontColor_11: " + TestDataHandler.getPPTTextFontColor(8, 11));
		System.out.println("getPPTTextFontColor_12: " + TestDataHandler.getPPTTextFontColor(8, 12));
		System.out.println("getPPTTextFontColor_13: " + TestDataHandler.getPPTTextFontColor(8, 13));
		System.out.println("getPPTTextFontColor_14: " + TestDataHandler.getPPTTextFontColor(8, 14));
		System.out.println("getPPTTextFontColor_15: " + TestDataHandler.getPPTTextFontColor(8, 15));
		System.out.println("getPPTTextFontColor_16: " + TestDataHandler.getPPTTextFontColor(8, 16));
		System.out.println("getPPTTextFontColor_17: " + TestDataHandler.getPPTTextFontColor(8, 17));
		System.out.println("getPPTTextFontColor_18: " + TestDataHandler.getPPTTextFontColor(8, 18));
		System.out.println("getPPTTextFontSize_1: " + TestDataHandler.getPPTTextFontSize(8, 1));
		System.out.println("getPPTTextFontSize_2: " + TestDataHandler.getPPTTextFontSize(8, 2));
		System.out.println("getPPTTextFontSize_3: " + TestDataHandler.getPPTTextFontSize(8, 3));
		System.out.println("getPPTTextFontSize_4: " + TestDataHandler.getPPTTextFontSize(8, 4));
		System.out.println("getPPTTextFontSize_5: " + TestDataHandler.getPPTTextFontSize(8, 5));
		System.out.println("getPPTTextFontSize_6: " + TestDataHandler.getPPTTextFontSize(8, 6));
		System.out.println("getPPTTextFontSize_7: " + TestDataHandler.getPPTTextFontSize(8, 7));
		System.out.println("getPPTTextFontSize_8: " + TestDataHandler.getPPTTextFontSize(8, 8));
		System.out.println("getPPTTextFontSize_9: " + TestDataHandler.getPPTTextFontSize(8, 9));
		System.out.println("getPPTTextFontSize_10: " + TestDataHandler.getPPTTextFontSize(8, 10));
		System.out.println("getPPTTextFontSize_11: " + TestDataHandler.getPPTTextFontSize(8, 11));
		System.out.println("getPPTTextFontSize_12: " + TestDataHandler.getPPTTextFontSize(8, 12));
		System.out.println("getPPTTextFontSize_13: " + TestDataHandler.getPPTTextFontSize(8, 13));
		System.out.println("getPPTTextFontSize_14: " + TestDataHandler.getPPTTextFontSize(8, 14));
		System.out.println("getPPTTextFontSize_15: " + TestDataHandler.getPPTTextFontSize(8, 15));
		System.out.println("getPPTTextFontSize_16: " + TestDataHandler.getPPTTextFontSize(8, 16));
		System.out.println("getPPTTextFontSize_17: " + TestDataHandler.getPPTTextFontSize(8, 17));
		System.out.println("getPPTTextFontSize_18: " + TestDataHandler.getPPTTextFontSize(8, 18));
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_03_1");
		//Contents Slide 03.1
		TestDataHandler.verifyPPTText(8, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(8, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(8, 1, "Black");
		TestDataHandler.verifyPPTText(8, 8, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(8, 8, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 8, "Black");
		TestDataHandler.verifyPPTText(8, 9, "01");
		TestDataHandler.verifyPPTTextFontSize(8, 9, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 9, "White");
		TestDataHandler.verifyPPTText(8, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(8, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 2, "Black");
		TestDataHandler.verifyPPTText(8, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(8, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 3, "White");
		TestDataHandler.verifyPPTText(8, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(8, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 4, "Black");
		TestDataHandler.verifyPPTText(8, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(8, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 5, "White");
		if (BSSlideCount != 0 || GSSlideCount != 0) {
		TestDataHandler.verifyPPTText(8, 12, "Competitiveness Scorecard");
		TestDataHandler.verifyPPTTextFontSize(8, 12, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 12, "Dark Gray");
		TestDataHandler.verifyPPTText(8, 13, "Investor Expectation");
		TestDataHandler.verifyPPTTextFontSize(8, 13, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 13, "Dark Gray");
		TestDataHandler.verifyPPTText(8, 14, "Financial Performance");
		TestDataHandler.verifyPPTTextFontSize(8, 14, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 14, "Dark Gray");
		TestDataHandler.verifyPPTText(8, 15, "Segmental Analysis");
		TestDataHandler.verifyPPTTextFontSize(8, 15, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 15, "Dark Gray");
		}
		if (BSSlideCount == 0 && GSSlideCount == 0) {
		TestDataHandler.verifyPPTText(8, 12, "Competitiveness Scorecard");
		TestDataHandler.verifyPPTTextFontSize(8, 12, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 12, "Dark Gray");
		TestDataHandler.verifyPPTText(8, 13, "Investor Expectation");
		TestDataHandler.verifyPPTTextFontSize(8, 13, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 13, "Dark Gray");
		TestDataHandler.verifyPPTText(8, 14, "Financial Performance");
		TestDataHandler.verifyPPTTextFontSize(8, 14, "14.0");
		TestDataHandler.verifyPPTTextFontColor(8, 14, "Dark Gray");
		}
		TestDataHandler.verifyPPTText(8, 6, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(8, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 6, "Black");
		TestDataHandler.verifyPPTText(8, 7, "04");
		TestDataHandler.verifyPPTTextFontSize(8, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 7, "White");
		if (HospitalitySlideCount != 0 && ESGSlideCount != 0) {
		TestDataHandler.verifyPPTText(8, 10, "OPERATING METRICS");
		TestDataHandler.verifyPPTTextFontSize(8, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 10, "Black");
		TestDataHandler.verifyPPTText(8, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(8, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 11, "White");
		TestDataHandler.verifyPPTText(8, 16, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(8, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 16, "Black");
		TestDataHandler.verifyPPTText(8, 17, "06");
		TestDataHandler.verifyPPTTextFontSize(8, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 17, "White");
		TestDataHandler.verifyPPTText(8, 18, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(8, 18, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 18, "Black");
		TestDataHandler.verifyPPTText(8, 19, "07");
		TestDataHandler.verifyPPTTextFontSize(8, 19, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 19, "White");
		}
		if (HospitalitySlideCount != 0 && ESGSlideCount == 0) {
		TestDataHandler.verifyPPTText(8, 10, "OPERATING METRICS");
		TestDataHandler.verifyPPTTextFontSize(8, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 10, "Black");
		TestDataHandler.verifyPPTText(8, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(8, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 11, "White");
		TestDataHandler.verifyPPTText(8, 16, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(8, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 16, "Black");
		TestDataHandler.verifyPPTText(8, 17, "06");
		TestDataHandler.verifyPPTTextFontSize(8, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 17, "White");
		}
		if (HospitalitySlideCount == 0 && ESGSlideCount != 0) {
		TestDataHandler.verifyPPTText(8, 10, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(8, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 10, "Black");
		TestDataHandler.verifyPPTText(8, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(8, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 11, "White");
		TestDataHandler.verifyPPTText(8, 16, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(8, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 16, "Black");
		TestDataHandler.verifyPPTText(8, 17, "06");
		TestDataHandler.verifyPPTTextFontSize(8, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 17, "White");
		}
		if (HospitalitySlideCount == 0 && ESGSlideCount == 0) {
		TestDataHandler.verifyPPTText(8, 10, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(8, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(8, 10, "Black");
		TestDataHandler.verifyPPTText(8, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(8, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(8, 11, "White");
		}
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_03_2");
		//Contents Slide 03.2
		TestDataHandler.verifyPPTText(12, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(12, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(12, 1, "Black");
		TestDataHandler.verifyPPTText(12, 6, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(12, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(12, 6, "Black");
		TestDataHandler.verifyPPTText(12, 7, "01");
		TestDataHandler.verifyPPTTextFontSize(12, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(12, 7, "White");
		TestDataHandler.verifyPPTText(12, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(12, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(12, 2, "Black");
		TestDataHandler.verifyPPTText(12, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(12, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(12, 3, "White");
		TestDataHandler.verifyPPTText(12, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(12, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(12, 4, "Black");
		TestDataHandler.verifyPPTText(12, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(12, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(12, 5, "White");
		TestDataHandler.verifyPPTText(12, 12, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(12, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(12, 12, "Black");
		TestDataHandler.verifyPPTText(12, 13, "04");
		TestDataHandler.verifyPPTTextFontSize(12, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(12, 13, "White");
		TestDataHandler.verifyPPTText(12, 14, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(12, 14, "15.99");
		TestDataHandler.verifyPPTTextFontColor(12, 14, "Black");
		TestDataHandler.verifyPPTText(12, 15, "05");
		TestDataHandler.verifyPPTTextFontSize(12, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(12, 15, "White");
		TestDataHandler.verifyPPTText(12, 8, "Competitiveness Scorecard");
		TestDataHandler.verifyPPTTextFontSize(12, 8, "14.0");
		TestDataHandler.verifyPPTTextFontColor(12, 8, "Dark Gray");
		TestDataHandler.verifyPPTText(12, 9, "Investor Expectation");
		TestDataHandler.verifyPPTTextFontSize(12, 9, "14.0");
		TestDataHandler.verifyPPTTextFontColor(12, 9, "Dark Gray");
		TestDataHandler.verifyPPTText(12, 10, "Financial Performance");
		TestDataHandler.verifyPPTTextFontSize(12, 10, "14.0");
		TestDataHandler.verifyPPTTextFontColor(12, 10, "Dark Gray");
		TestDataHandler.verifyPPTText(12, 11, "Segmental Analysis");
		TestDataHandler.verifyPPTTextFontSize(12, 11, "14.0");
		TestDataHandler.verifyPPTTextFontColor(12, 11, "Dark Gray");
		TestDataHandler.verifyPPTText(12, 16, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(12, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(12, 16, "Black");
		TestDataHandler.verifyPPTText(12, 17, "06");
		TestDataHandler.verifyPPTTextFontSize(12, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(12, 17, "White");
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_03_3");
		//Contents Slide 03.3
		TestDataHandler.verifyPPTText(21, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(21, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(21, 1, "Black");
		TestDataHandler.verifyPPTText(21, 6, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(21, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(21, 6, "Black");
		TestDataHandler.verifyPPTText(21, 7, "01");
		TestDataHandler.verifyPPTTextFontSize(21, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(21, 7, "White");
		TestDataHandler.verifyPPTText(21, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(21, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(21, 2, "Black");
		TestDataHandler.verifyPPTText(21, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(21, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(21, 3, "White");
		TestDataHandler.verifyPPTText(21, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(21, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(21, 4, "Black");
		TestDataHandler.verifyPPTText(21, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(21, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(21, 5, "White");
		TestDataHandler.verifyPPTText(21, 12, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(21, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(21, 12, "Black");
		TestDataHandler.verifyPPTText(21, 13, "04");
		TestDataHandler.verifyPPTTextFontSize(21, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(21, 13, "White");
		TestDataHandler.verifyPPTText(21, 14, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(21, 14, "15.99");
		TestDataHandler.verifyPPTTextFontColor(21, 14, "Black");
		TestDataHandler.verifyPPTText(21, 15, "05");
		TestDataHandler.verifyPPTTextFontSize(21, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(21, 15, "White");
		TestDataHandler.verifyPPTText(21, 8, "Competitiveness Scorecard");
		TestDataHandler.verifyPPTTextFontSize(21, 8, "14.0");
		TestDataHandler.verifyPPTTextFontColor(21, 8, "Dark Gray");
		TestDataHandler.verifyPPTText(21, 9, "Investor Expectation");
		TestDataHandler.verifyPPTTextFontSize(21, 9, "14.0");
		TestDataHandler.verifyPPTTextFontColor(21, 9, "Dark Gray");
		TestDataHandler.verifyPPTText(21, 10, "Financial Performance");
		TestDataHandler.verifyPPTTextFontSize(21, 10, "14.0");
		TestDataHandler.verifyPPTTextFontColor(21, 10, "Dark Gray");
		TestDataHandler.verifyPPTText(21, 11, "Segmental Analysis");
		TestDataHandler.verifyPPTTextFontSize(21, 11, "14.0");
		TestDataHandler.verifyPPTTextFontColor(21, 11, "Dark Gray");
		TestDataHandler.verifyPPTText(21, 16, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(21, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(21, 16, "Black");
		TestDataHandler.verifyPPTText(21, 17, "06");
		TestDataHandler.verifyPPTTextFontSize(21, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(21, 17, "White");
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_03_4");
		//Contents Slide 03.4
		SlideCount = 21 + RG + 6 + OV +  16;
		TestDataHandler.verifyPPTText(SlideCount, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 6, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 6, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 7, "01");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 7, "White");
		TestDataHandler.verifyPPTText(SlideCount, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 2, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 3, "White");
		TestDataHandler.verifyPPTText(SlideCount, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 4, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 5, "White");
		TestDataHandler.verifyPPTText(SlideCount, 12, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 12, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 13, "04");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 13, "White");
		TestDataHandler.verifyPPTText(SlideCount, 14, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 14, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 14, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 15, "05");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 15, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 15, "White");
		TestDataHandler.verifyPPTText(SlideCount, 8, "Competitiveness Scorecard");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 8, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 8, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 9, "Investor Expectation");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 9, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 9, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 10, "Financial Performance");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 10, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 10, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 11, "Segmental Analysis");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 11, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 11, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 16, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 16, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 16, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 17, "06");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 17, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 17, "White");
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_04");
		//Contents Slide 04
		SlideCount = SlideCount + BSSlideCount + GSSlideCount + 1;
		TestDataHandler.verifyPPTText(SlideCount, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 8, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 8, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 8, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 9, "01");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 9, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 9, "White");
		TestDataHandler.verifyPPTText(SlideCount, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 2, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 3, "White");
		TestDataHandler.verifyPPTText(SlideCount, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 4, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 5, "White");
		TestDataHandler.verifyPPTText(SlideCount, 6, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 6, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 7, "04");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 7, "White");
		TestDataHandler.verifyPPTText(SlideCount, 10, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 10, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 11, "05");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 11, "White");
		TestDataHandler.verifyPPTText(SlideCount, 12, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 12, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 13, "06");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 13, "White");
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_05");
		//Contents Slide 05
		SlideCount = SlideCount + CIASlideCount;
		TestDataHandler.verifyPPTText(SlideCount, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 8, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 8, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 8, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 9, "01");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 9, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 9, "White");
		TestDataHandler.verifyPPTText(SlideCount, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 2, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 3, "White");
		TestDataHandler.verifyPPTText(SlideCount, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 4, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 5, "White");
		TestDataHandler.verifyPPTText(SlideCount, 12, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 12, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 13, "04");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 13, "White");
		TestDataHandler.verifyPPTText(SlideCount, 6, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 6, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 7, "05");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 7, "White");
		TestDataHandler.verifyPPTText(SlideCount, 10, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 10, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 11, "06");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 11, "White");
		
		ReportLog.setTestCase("PPT_Reg_Auto_012_Content_06");
		//Contents Slide 06
		SlideCount = SlideCount + 5;
		TestDataHandler.verifyPPTText(SlideCount, 1, "CONTENTS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 1, "40.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 1, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 8, "EXECUTIVE SUMMARY");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 8, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 8, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 9, "01");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 9, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 9, "White");
		TestDataHandler.verifyPPTText(SlideCount, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 2, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 2, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 3, "02");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 3, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 3, "White");
		TestDataHandler.verifyPPTText(SlideCount, 4, "FINANCIAL ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 4, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 4, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 5, "03");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 5, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 5, "White");
		TestDataHandler.verifyPPTText(SlideCount, 12, "COVID IMPACT ANALYSIS");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 12, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 12, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 13, "04");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 13, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 13, "White");
		TestDataHandler.verifyPPTText(SlideCount, 6, "SUSTAINABILITY SCORES");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 6, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 6, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 7, "05");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 7, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 7, "White");
		TestDataHandler.verifyPPTText(SlideCount, 10, "APPENDIX");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 10, "15.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 10, "Black");
		TestDataHandler.verifyPPTText(SlideCount, 11, "06");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 11, "17.99");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 11, "White");
		TestDataHandler.verifyPPTText(SlideCount, 14, "Key Executives");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 14, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 14, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 15, "Methodology");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 15, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 15, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 16, "Glossary");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 16, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 16, "Dark Gray");
		TestDataHandler.verifyPPTText(SlideCount, 17, "Reference Calculations");
		TestDataHandler.verifyPPTTextFontSize(SlideCount, 17, "14.0");
		TestDataHandler.verifyPPTTextFontColor(SlideCount, 17, "Dark Gray");
		
	}
	

	@Test(priority=2)
	public void ExecutiveSummaryAndOverviewSlide () throws Exception {
		ReportLog.setTestName("Executive Summary & Overview Slide TCERs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("PPT_Reg_Auto_013");
		TestDataHandler.verifyPPTText(4, 3, "Shareholder Value Analysis: In a Snapshot");
		TestDataHandler.verifyPPTTextFontSize(4, 3, "32.0");
		TestDataHandler.verifyPPTTextFontColor(4, 3, "Purple");
		TestDataHandler.verifyPPTText(4, 4, "Our analysis has highlighted key insights and trends for " + testDataHandler.company + " to grow its Enterprise Value ");
		TestDataHandler.verifyPPTTextFontSize(4, 4, "20.0");
		
		ReportLog.setTestCase("PPT_Reg_Auto_014");
		TestDataHandler.verifyPPTText(4, 47, "LOOKING BACK: " + testDataHandler.company + "’s performance over the past 1-year");
		TestDataHandler.verifyPPTTextFontSize(4, 47, "18.0");
		TestDataHandler.verifyPPTTextFontColor(4, 47, "Black");
		TestDataHandler.verifyPPTText(4, 6, "LOOKING FORWARD: A look at " + testDataHandler.company + "'s future performance expectation");
		TestDataHandler.verifyPPTTextFontSize(4, 6, "18.0");
		TestDataHandler.verifyPPTTextFontColor(4, 6, "Black");
		TestDataHandler.verifyPPTText(4, 7, "POTENTIAL OPPORTUNITIES: " + testDataHandler.company + " should consider these top levers to sustain and grow its Enterprise Value");
		TestDataHandler.verifyPPTTextFontSize(4, 7, "18.0");
		TestDataHandler.verifyPPTTextFontColor(4, 7, "Black");
		
		ReportLog.setTestCase("PPT_Reg_Auto_020");
		TestDataHandler.verifyPPTText(6, 2, "COMPANY OVERVIEW");
		TestDataHandler.verifyPPTTextFontSize(6, 2, "32.0");
		TestDataHandler.verifyPPTTextFontColor(6, 2, "Purple");
		TestDataHandler.verifyPPTText(6, 23, "Description");
		TestDataHandler.verifyPPTTextFontSize(6, 23, "13.0");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuOverview.click();
		VIPOverviewPage.contents.OverviewDescription2.waitForExist(true, 10);
		String Description1 = VIPOverviewPage.contents.OverviewDescription2.getText();
		String Description = Description1.substring(0, 1096);
		TestDataHandler.verifyPPTText(6, 3, Description + "...");
		TestDataHandler.verifyPPTTextFontSize(6, 3, "12.0");
		TestDataHandler.verifyPPTText(6, 6, "Key Facts");
		TestDataHandler.verifyPPTTextFontSize(6, 6, "13.0");
		TestDataHandler.verifyPPTText(6, 7, "REVENUE");
		TestDataHandler.verifyPPTTextFontSize(6, 7, "12.0");
		String Revenue = VIPOverviewPage.contents.RevenueValue.getText();
		TestDataHandler.verifyPPTText(6, 8, Revenue);
		TestDataHandler.verifyPPTTextFontSize(6, 8, "12.0");
		TestDataHandler.verifyPPTText(6, 13, "EMPLOYEES");
		TestDataHandler.verifyPPTTextFontSize(6, 13, "12.0");
		String Employees = VIPOverviewPage.contents.EmployeesValue.getText();
		TestDataHandler.verifyPPTText(6, 14, Employees);
		TestDataHandler.verifyPPTTextFontSize(6, 14, "12.0");
		TestDataHandler.verifyPPTText(6, 21, "HEADQUARTERS");
		TestDataHandler.verifyPPTTextFontSize(6, 21, "12.0");
		String Headquarters = VIPOverviewPage.contents.Headquarters.getText();
		TestDataHandler.verifyPPTText(6, 19, Headquarters);
		TestDataHandler.verifyPPTTextFontSize(6, 19, "12.0");
		TestDataHandler.verifyPPTText(6, 9, "EBIT MARGIN");
		TestDataHandler.verifyPPTTextFontSize(6, 9, "12.0");
		String EBITMargin = VIPOverviewPage.contents.EBITMarginValue.getText();
		TestDataHandler.verifyPPTText(6, 10, EBITMargin);
		TestDataHandler.verifyPPTTextFontSize(6, 10, "12.0");
		TestDataHandler.verifyPPTText(6, 15, "INDUSTRY ");
		TestDataHandler.verifyPPTTextFontSize(6, 15, "12.0");
		String Industry = VIPOverviewPage.contents.Industry.getText();
		TestDataHandler.verifyPPTText(6, 16, Industry);
		TestDataHandler.verifyPPTTextFontSize(6, 16, "12.0");
		TestDataHandler.verifyPPTText(6, 22, "WEBSITE");
		TestDataHandler.verifyPPTTextFontSize(6, 22, "12.0");
		String Website = VIPOverviewPage.contents.Website.getText();
		TestDataHandler.verifyPPTText(6, 20, Website);
		TestDataHandler.verifyPPTTextFontSize(6, 20, "12.0");
		TestDataHandler.verifyPPTText(6, 11, "ENTERPRISE VALUE ");
		TestDataHandler.verifyPPTTextFontSize(6, 11, "12.0");
		String EnterpriseValue = VIPOverviewPage.contents.EnterpriseValue.getText();
		TestDataHandler.verifyPPTText(6, 12, EnterpriseValue);
		TestDataHandler.verifyPPTTextFontSize(6, 12, "12.0");
		TestDataHandler.verifyPPTText(6, 17, "TYPE");
		TestDataHandler.verifyPPTTextFontSize(6, 17, "12.0");
		String Type = VIPOverviewPage.contents.Type.getText();
		TestDataHandler.verifyPPTText(6, 18, Type);
		TestDataHandler.verifyPPTTextFontSize(6, 18, "12.0");
		TestDataHandler.verifyPPTText(6, 4, "Financial Summary ");
		TestDataHandler.verifyPPTTextFontSize(6, 4, "13.0");
		TestDataHandler.verifyPPTText(6, 24, "TOTAL RETURN TO SHAREHOLDERS");
		TestDataHandler.verifyPPTTextFontSize(6, 24, "10.0");
		String TRSValue = VIPOverviewPage.contents.TRSValue.getText();
		TestDataHandler.verifyPPTText(6, 25, TRSValue);
		TestDataHandler.verifyPPTTextFontSize(6, 25, "14.0");
		String TRSYear = VIPOverviewPage.contents.TRSYear.getText();
		TestDataHandler.verifyPPTText(6, 42, TRSYear);
		TestDataHandler.verifyPPTTextFontSize(6, 42, "10.0");
		TestDataHandler.verifyPPTText(6, 51, "YOY TREND");
		TestDataHandler.verifyPPTTextFontSize(6, 51, "10.0");
		String TRSTrend = VIPOverviewPage.contents.TRSTrendValue.getText();
		TestDataHandler.verifyPPTText(6, 34, TRSTrend);
		TestDataHandler.verifyPPTTextFontSize(6, 34, "10.0");
		TestDataHandler.verifyPPTText(6, 26, "REVENUE");
		TestDataHandler.verifyPPTTextFontSize(6, 26, "10.0");
		String RGValue = VIPOverviewPage.contents.RGValue.getText();
		TestDataHandler.verifyPPTText(6, 28, RGValue);
		TestDataHandler.verifyPPTTextFontSize(6, 28, "14.0");
		String RGYear = VIPOverviewPage.contents.RGYear.getText();
		TestDataHandler.verifyPPTText(6, 43, RGYear);
		TestDataHandler.verifyPPTTextFontSize(6, 43, "10.0");
		TestDataHandler.verifyPPTText(6, 52, "YOY TREND");
		TestDataHandler.verifyPPTTextFontSize(6, 52, "10.0");
		String RGTrend = VIPOverviewPage.contents.RGTrendValue.getText();
		TestDataHandler.verifyPPTText(6, 35, RGTrend);
		TestDataHandler.verifyPPTTextFontSize(6, 35, "10.0");
		TestDataHandler.verifyPPTText(6, 39, "PRE-TAX ROIC");
		TestDataHandler.verifyPPTTextFontSize(6, 39, "10.0");
		String ROICValue = VIPOverviewPage.contents.ROICValue.getText();
		TestDataHandler.verifyPPTText(6, 40, ROICValue);
		TestDataHandler.verifyPPTTextFontSize(6, 40, "14.0");
		String ROICYear = VIPOverviewPage.contents.ROICYear.getText();
		TestDataHandler.verifyPPTText(6, 44, ROICYear);
		TestDataHandler.verifyPPTTextFontSize(6, 44, "10.0");
		TestDataHandler.verifyPPTText(6, 53, "YOY TREND");
		TestDataHandler.verifyPPTTextFontSize(6, 53, "10.0");
		String ROICTrend = VIPOverviewPage.contents.ROICTrendValue.getText();
		TestDataHandler.verifyPPTText(6, 41, ROICTrend);
		TestDataHandler.verifyPPTTextFontSize(6, 41, "10.0");
		TestDataHandler.verifyPPTText(6, 29, "EBIT MARGIN");
		TestDataHandler.verifyPPTTextFontSize(6, 29, "10.0");
		String EBITValue = VIPOverviewPage.contents.EBITValue.getText();
		TestDataHandler.verifyPPTText(6, 30, EBITValue);
		TestDataHandler.verifyPPTTextFontSize(6, 30, "14.0");
		String EBITYear = VIPOverviewPage.contents.EBITYear.getText();
		TestDataHandler.verifyPPTText(6, 45, EBITYear);
		TestDataHandler.verifyPPTTextFontSize(6, 45, "10.0");
		TestDataHandler.verifyPPTText(6, 54, "YOY TREND");
		TestDataHandler.verifyPPTTextFontSize(6, 54, "10.0");
		String EBITTrend = VIPOverviewPage.contents.EBITTrendValue.getText();
		TestDataHandler.verifyPPTText(6, 36, EBITTrend);
		TestDataHandler.verifyPPTTextFontSize(6, 36, "10.0");
		TestDataHandler.verifyPPTText(6, 31, "CAPITAL ");
		TestDataHandler.verifyPPTTextFontSize(6, 31, "10.0");
		String CEValue = VIPOverviewPage.contents.CEValue.getText();
		TestDataHandler.verifyPPTText(6, 33, CEValue);
		TestDataHandler.verifyPPTTextFontSize(6, 33, "14.0");
		String CEYear = VIPOverviewPage.contents.CEYear.getText();
		TestDataHandler.verifyPPTText(6, 46, CEYear);
		TestDataHandler.verifyPPTTextFontSize(6, 46, "10.0");
		TestDataHandler.verifyPPTText(6, 55, "YOY TREND");
		TestDataHandler.verifyPPTTextFontSize(6, 55, "10.0");
		String CETrend = VIPOverviewPage.contents.CETrendValue.getText();
		TestDataHandler.verifyPPTText(6, 37, CETrend);
		TestDataHandler.verifyPPTTextFontSize(6, 37, "10.0");
		
		
		
	
	}
	

	@Test(priority=3)
	public void PeersetSlides () throws Exception {
		ReportLog.setTestName("Peerset Slides TCERs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("PPT_Reg_Auto_021");
		TestDataHandler.verifyPPTTableText(9, 2, 1, 1, "Company");
		TestDataHandler.verifyPPTTableTextFontSize(9, 2, 1, 1, "9.0");
		TestDataHandler.verifyPPTTableTextFontColor(9, 2, 1, 1, "White");
		TestDataHandler.verifyPPTTableText(9, 2, 2, 1, "Latest Period");
		TestDataHandler.verifyPPTTableTextFontSize(9, 2, 2, 1, "9.0");
		TestDataHandler.verifyPPTTableTextFontColor(9, 2, 2, 1, "White");
		TestDataHandler.verifyPPTTableText(9, 2, 3, 1, "Revenue \n" + " (USD MN)");
		TestDataHandler.verifyPPTTableTextFontSize(9, 2, 3, 1, "9.0");
		TestDataHandler.verifyPPTTableTextFontColor(9, 2, 3, 1, "White");
		TestDataHandler.verifyPPTTableText(9, 2, 4, 1, "Market Cap \n" + " (USD MN)");
		TestDataHandler.verifyPPTTableTextFontSize(9, 2, 4, 1, "9.0");
		TestDataHandler.verifyPPTTableTextFontColor(9, 2, 4, 1, "White");
		TestDataHandler.verifyPPTTableText(9, 2, 5, 1, "Country");
		TestDataHandler.verifyPPTTableTextFontSize(9, 2, 5, 1, "9.0");
		TestDataHandler.verifyPPTTableTextFontColor(9, 2, 5, 1, "White");
		
		ReportLog.setTestCase("PPT_Reg_Auto_022");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.Competitors1stPeers.waitForExist(true, 15);
		//Company Name
		String Comp1 = ""; String Comp2 = ""; String Comp3 = ""; String Comp4 = ""; 
		String Comp5 = ""; String Comp6 = ""; String Comp7 = ""; String Comp8 = ""; 
		String Comp9 = ""; String Comp10 = ""; String Comp11 = "";	String Comp12 = "";
		String Comp13 = ""; String Comp14 = ""; String Comp15 = ""; String Comp16 = "";
		String[] Compa1 = VIPCompetitorPage.contents.TargetCompName.getText().split("\\n");
		Comp1 = Compa1[0];
		if (Comp1.length() > 17) { Comp1 = Comp1.substring(0, 18);}
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
			String[] Compa2 = VIPCompetitorPage.contents.Competitors1stPeers.getText().split("\\n");
			Comp2 = Compa2[0];
			if (Comp2.length() > 17) {Comp2 = Comp2.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors2ndPeers.isDisplayed()) {
			String[] Compa3 = VIPCompetitorPage.contents.Competitors2ndPeers.getText().split("\\n");
			Comp3 = Compa3[0];
			if (Comp3.length() > 17) {Comp3 = Comp3.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors3rdPeers.isDisplayed()) {
			String[] Compa4 = VIPCompetitorPage.contents.Competitors3rdPeers.getText().split("\\n");
			Comp4 = Compa4[0];
			if (Comp4.length() > 17) {Comp4 = Comp4.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors4thPeers.isDisplayed()) {
			String[] Compa5 = VIPCompetitorPage.contents.Competitors4thPeers.getText().split("\\n");
			Comp5 = Compa5[0];
			if (Comp5.length() > 17) {Comp5 = Comp5.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors5thPeers.isDisplayed()) {
			String[] Compa6 = VIPCompetitorPage.contents.Competitors5thPeers.getText().split("\\n");
			Comp6 = Compa6[0];
			if (Comp6.length() > 17) {Comp6 = Comp6.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors6thPeers.isDisplayed()) {
			String[] Compa7 = VIPCompetitorPage.contents.Competitors6thPeers.getText().split("\\n");
			Comp7 = Compa7[0];
			if (Comp7.length() > 17) {Comp7 = Comp7.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors7thPeers.isDisplayed()) {
			String[] Compa8 = VIPCompetitorPage.contents.Competitors7thPeers.getText().split("\\n");
			Comp8 = Compa8[0];
			if (Comp8.length() > 17) {Comp8 = Comp8.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors8thPeers.isDisplayed()) {
			String[] Compa9 = VIPCompetitorPage.contents.Competitors8thPeers.getText().split("\\n");
			Comp9 = Compa9[0];
			if (Comp9.length() > 17) {Comp9 = Comp9.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors9thPeers.isDisplayed()) {
			String[] Compa10 = VIPCompetitorPage.contents.Competitors9thPeers.getText().split("\\n");
			Comp10 = Compa10[0];
			if (Comp10.length() > 17) {Comp10 = Comp10.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors10thPeers.isDisplayed()) {
			String[] Compa11 = VIPCompetitorPage.contents.Competitors10thPeers.getText().split("\\n");
			Comp11 = Compa11[0];
			if (Comp11.length() > 17) {Comp11 = Comp11.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors11thPeers.isDisplayed()) {
			String[] Compa12 = VIPCompetitorPage.contents.Competitors11thPeers.getText().split("\\n");
			Comp12 = Compa12[0];
			if (Comp12.length() > 17) {Comp12 = Comp12.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors12thPeers.isDisplayed()) {
			String[] Compa13 = VIPCompetitorPage.contents.Competitors12thPeers.getText().split("\\n");
			Comp13 = Compa13[0];
			if (Comp13.length() > 17) {Comp13 = Comp13.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors13thPeers.isDisplayed()) {
			String[] Compa14 = VIPCompetitorPage.contents.Competitors13thPeers.getText().split("\\n");
			Comp14 = Compa14[0];
			if (Comp14.length() > 17) {Comp14 = Comp14.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors14thPeers.isDisplayed()) {
			String[] Compa15 = VIPCompetitorPage.contents.Competitors14thPeers.getText().split("\\n");
			Comp15 = Compa15[0];
			if (Comp15.length() > 17) {Comp15 = Comp15.substring(0, 18);}}
		if (VIPCompetitorPage.contents.Competitors15thPeers.isDisplayed()) {
			String[] Compa16 = VIPCompetitorPage.contents.Competitors15thPeers.getText().split("\\n");
			Comp16 = Compa16[0];
			if (Comp16.length() > 17) {Comp16 = Comp16.substring(0, 18);}}
		//Revenue
		String Rev1 = ""; String Rev2 = ""; String Rev3 = ""; String Rev4 = ""; 
		String Rev5 = ""; String Rev6 = ""; String Rev7 = ""; String Rev8 = ""; 
		String Rev9 = ""; String Rev10 = ""; String Rev11 = "";	String Rev12 = "";
		String Rev13 = ""; String Rev14 = ""; String Rev15 = ""; String Rev16 = "";
		Rev1 = VIPCompetitorPage.contents.TargetCompRevenue.getText();
		if (VIPCompetitorPage.contents.Revenue1.isDisplayed()) {
			Rev2 = VIPCompetitorPage.contents.Revenue1.getText();}
		if (VIPCompetitorPage.contents.Revenue2.isDisplayed()) {
			Rev3 = VIPCompetitorPage.contents.Revenue2.getText();}
		if (VIPCompetitorPage.contents.Revenue3.isDisplayed()) {
			Rev4 = VIPCompetitorPage.contents.Revenue3.getText();}
		if (VIPCompetitorPage.contents.Revenue4.isDisplayed()) {
			Rev5 = VIPCompetitorPage.contents.Revenue4.getText();}
		if (VIPCompetitorPage.contents.Revenue5.isDisplayed()) {
			Rev6 = VIPCompetitorPage.contents.Revenue5.getText();}
		if (VIPCompetitorPage.contents.Revenue6.isDisplayed()) {
			Rev7 = VIPCompetitorPage.contents.Revenue6.getText();}
		if (VIPCompetitorPage.contents.Revenue7.isDisplayed()) {
			Rev8 = VIPCompetitorPage.contents.Revenue7.getText();}
		if (VIPCompetitorPage.contents.Revenue8.isDisplayed()) {
			Rev9 = VIPCompetitorPage.contents.Revenue8.getText();}
		if (VIPCompetitorPage.contents.Revenue9.isDisplayed()) {
			Rev10 = VIPCompetitorPage.contents.Revenue9.getText();}
		if (VIPCompetitorPage.contents.Revenue10.isDisplayed()) {
			Rev11 = VIPCompetitorPage.contents.Revenue10.getText();}
		if (VIPCompetitorPage.contents.Revenue11.isDisplayed()) {
			Rev12 = VIPCompetitorPage.contents.Revenue11.getText();}
		if (VIPCompetitorPage.contents.Revenue12.isDisplayed()) {
			Rev13 = VIPCompetitorPage.contents.Revenue12.getText();}
		if (VIPCompetitorPage.contents.Revenue13.isDisplayed()) {
			Rev14 = VIPCompetitorPage.contents.Revenue13.getText();}
		if (VIPCompetitorPage.contents.Revenue14.isDisplayed()) {
			Rev15 = VIPCompetitorPage.contents.Revenue14.getText();}
		if (VIPCompetitorPage.contents.Revenue15.isDisplayed()) {
			Rev16 = VIPCompetitorPage.contents.Revenue15.getText();}
		//Market Cap
		String Cap1 = ""; String Cap2 = ""; String Cap3 = ""; String Cap4 = ""; 
		String Cap5 = ""; String Cap6 = ""; String Cap7 = ""; String Cap8 = ""; 
		String Cap9 = ""; String Cap10 = ""; String Cap11 = "";	String Cap12 = "";
		String Cap13 = ""; String Cap14 = ""; String Cap15 = ""; String Cap16 = "";
		Cap1 = VIPCompetitorPage.contents.TargetMarketCap.getText();
		if (VIPCompetitorPage.contents.Peer1MarketCap.isDisplayed()) {
			Cap2 = VIPCompetitorPage.contents.Peer1MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer2MarketCap.isDisplayed()) {
			Cap3 = VIPCompetitorPage.contents.Peer2MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer3MarketCap.isDisplayed()) {
			Cap4 = VIPCompetitorPage.contents.Peer3MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer4MarketCap.isDisplayed()) {
			Cap5 = VIPCompetitorPage.contents.Peer4MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer5MarketCap.isDisplayed()) {
			Cap6 = VIPCompetitorPage.contents.Peer5MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer6MarketCap.isDisplayed()) {
			Cap7 = VIPCompetitorPage.contents.Peer6MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer7MarketCap.isDisplayed()) {
			Cap8 = VIPCompetitorPage.contents.Peer7MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer8MarketCap.isDisplayed()) {
			Cap9 = VIPCompetitorPage.contents.Peer8MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer9MarketCap.isDisplayed()) {
			Cap10 = VIPCompetitorPage.contents.Peer9MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer10MarketCap.isDisplayed()) {
			Cap11 = VIPCompetitorPage.contents.Peer10MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer11MarketCap.isDisplayed()) {
			Cap12 = VIPCompetitorPage.contents.Peer11MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer12MarketCap.isDisplayed()) {
			Cap13 = VIPCompetitorPage.contents.Peer12MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer13MarketCap.isDisplayed()) {
			Cap14 = VIPCompetitorPage.contents.Peer13MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer14MarketCap.isDisplayed()) {
			Cap15 = VIPCompetitorPage.contents.Peer14MarketCap.getText();}
		if (VIPCompetitorPage.contents.Peer15MarketCap.isDisplayed()) {
			Cap16 = VIPCompetitorPage.contents.Peer15MarketCap.getText();}
		//Country
		String Country1 = ""; String Country2 = ""; String Country3 = ""; String Country4 = ""; 
		String Country5 = ""; String Country6 = ""; String Country7 = ""; String Country8 = ""; 
		String Country9 = ""; String Country10 = ""; String Country11 = "";	String Country12 = "";
		String Country13 = ""; String Country14 = ""; String Country15 = ""; String Country16 = "";
		Country1 = VIPCompetitorPage.contents.TargetCountry.getText();
		if (VIPCompetitorPage.contents.PeerCountry1.isDisplayed()) {
			Country2 = VIPCompetitorPage.contents.PeerCountry1.getText();}
		if (VIPCompetitorPage.contents.PeerCountry2.isDisplayed()) {
			Country3 = VIPCompetitorPage.contents.PeerCountry2.getText();}
		if (VIPCompetitorPage.contents.PeerCountry3.isDisplayed()) {
			Country4 = VIPCompetitorPage.contents.PeerCountry3.getText();}
		if (VIPCompetitorPage.contents.PeerCountry4.isDisplayed()) {
			Country5 = VIPCompetitorPage.contents.PeerCountry4.getText();}
		if (VIPCompetitorPage.contents.PeerCountry5.isDisplayed()) {
			Country6 = VIPCompetitorPage.contents.PeerCountry5.getText();}
		if (VIPCompetitorPage.contents.PeerCountry6.isDisplayed()) {
			Country7 = VIPCompetitorPage.contents.PeerCountry6.getText();}
		if (VIPCompetitorPage.contents.PeerCountry7.isDisplayed()) {
			Country8 = VIPCompetitorPage.contents.PeerCountry7.getText();}
		if (VIPCompetitorPage.contents.PeerCountry8.isDisplayed()) {
			Country9 = VIPCompetitorPage.contents.PeerCountry8.getText();}
		if (VIPCompetitorPage.contents.PeerCountry9.isDisplayed()) {
			Country10 = VIPCompetitorPage.contents.PeerCountry9.getText();}
		if (VIPCompetitorPage.contents.PeerCountry10.isDisplayed()) {
			Country11 = VIPCompetitorPage.contents.PeerCountry10.getText();}
		if (VIPCompetitorPage.contents.PeerCountry11.isDisplayed()) {
			Country12 = VIPCompetitorPage.contents.PeerCountry11.getText();}
		if (VIPCompetitorPage.contents.PeerCountry12.isDisplayed()) {
			Country13 = VIPCompetitorPage.contents.PeerCountry12.getText();}
		if (VIPCompetitorPage.contents.PeerCountry13.isDisplayed()) {
			Country14 = VIPCompetitorPage.contents.PeerCountry13.getText();}
		if (VIPCompetitorPage.contents.PeerCountry14.isDisplayed()) {
			Country15 = VIPCompetitorPage.contents.PeerCountry14.getText();}
		if (VIPCompetitorPage.contents.PeerCountry15.isDisplayed()) {
			Country16 = VIPCompetitorPage.contents.PeerCountry15.getText();}
		//Building of Array
		ArrayList<String[]> listOfStringArrays = new ArrayList<String[]>();
		listOfStringArrays.add(new String[] {Rev1+"|",Comp1+"|",Cap1+"|",Country1});
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
			listOfStringArrays.add(new String[] {Rev2+"|",Comp2+"|",Cap2+"|",Country2});}
		if (VIPCompetitorPage.contents.Competitors2ndPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev3+"|",Comp3+"|",Cap3+"|",Country3});}
		if (VIPCompetitorPage.contents.Competitors3rdPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev4+"|",Comp4+"|",Cap4+"|",Country4});}
		if (VIPCompetitorPage.contents.Competitors4thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev5+"|",Comp5+"|",Cap5+"|",Country5});}
		if (VIPCompetitorPage.contents.Competitors5thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev6+"|",Comp6+"|",Cap6+"|",Country6});}
		if (VIPCompetitorPage.contents.Competitors6thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev7+"|",Comp7+"|",Cap7+"|",Country7});}
		if (VIPCompetitorPage.contents.Competitors7thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev8+"|",Comp8+"|",Cap8+"|",Country8});}
		if (VIPCompetitorPage.contents.Competitors8thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev9+"|",Comp9+"|",Cap9+"|",Country9});}
		if (VIPCompetitorPage.contents.Competitors9thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev10+"|",Comp10+"|",Cap10+"|",Country10});}
		if (VIPCompetitorPage.contents.Competitors10thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev11+"|",Comp11+"|",Cap11+"|",Country11});}
		if (VIPCompetitorPage.contents.Competitors11thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev12+"|",Comp12+"|",Cap12+"|",Country12});}
		if (VIPCompetitorPage.contents.Competitors12thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev13+"|",Comp13+"|",Cap13+"|",Country13});}
		if (VIPCompetitorPage.contents.Competitors13thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev14+"|",Comp14+"|",Cap14+"|",Country14});}
		if (VIPCompetitorPage.contents.Competitors14thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev15+"|",Comp15+"|",Cap15+"|",Country15});}
		if (VIPCompetitorPage.contents.Competitors15thPeers.isDisplayed()) {
	        listOfStringArrays.add(new String[] {Rev16+"|",Comp16+"|",Cap16+"|",Country16});}
		
//        Collections.sort(listOfStringArrays,new Comparator<String[]>() {
//            public int compare(String[] strings, String[] otherStrings) {
//                return strings[0].compareTo(otherStrings[0]);
//            }
//        });
        
        StringBuilder buffer = new StringBuilder();
        String text = null;
        
        for (String[] sa : listOfStringArrays) {
        	buffer.append(Arrays.toString(sa));
        	buffer.append("\n");
            text =  buffer.toString().replace("[", "").replace("]", "");
        }
        String[] texts = text.split("\\n");
        Arrays.sort(texts, Collections.reverseOrder());
        
        //Row 1 Data Validation
        String[] list1 = texts[0].split("\\|, ");
        TestDataHandler.verifyPPTTableText(9, 2, 1, 2, list1[1]);
        TestDataHandler.verifyPPTTableText(9, 2, 3, 2, list1[0]);
        TestDataHandler.verifyPPTTableText(9, 2, 4, 2, list1[2]);
        TestDataHandler.verifyPPTTableText(9, 2, 5, 2, list1[3]);
        //Row 2 Data Validation
        if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
        	String[] list2 = texts[1].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 3, list2[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 3, list2[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 3, list2[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 3, list2[3]);
        }
        //Row 3 Data Validation
        if (VIPCompetitorPage.contents.Competitors2ndPeers.isDisplayed()) {
        	String[] list3 = texts[2].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 4, list3[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 4, list3[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 4, list3[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 4, list3[3]);
        }
        //Row 4 Data Validation
        if (VIPCompetitorPage.contents.Competitors3rdPeers.isDisplayed()) {
        	String[] list4 = texts[3].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 5, list4[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 5, list4[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 5, list4[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 5, list4[3]);
        }
        //Row 5 Data Validation
        if (VIPCompetitorPage.contents.Competitors4thPeers.isDisplayed()) {
        	String[] list5 = texts[4].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 6, list5[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 6, list5[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 6, list5[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 6, list5[3]);
        }
        //Row 6 Data Validation
        if (VIPCompetitorPage.contents.Competitors5thPeers.isDisplayed()) {
        	String[] list6 = texts[5].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 7, list6[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 7, list6[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 7, list6[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 7, list6[3]);
        }
        //Row 7 Data Validation
        if (VIPCompetitorPage.contents.Competitors6thPeers.isDisplayed()) {
        	String[] list7 = texts[6].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 8, list7[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 8, list7[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 8, list7[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 8, list7[3]);
        }
        //Row 8 Data Validation
        if (VIPCompetitorPage.contents.Competitors7thPeers.isDisplayed()) {
        	String[] list8 = texts[7].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 9, list8[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 9, list8[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 9, list8[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 9, list8[3]);
        }
        //Row 9 Data Validation
        if (VIPCompetitorPage.contents.Competitors8thPeers.isDisplayed()) {
        	String[] list9 = texts[8].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 10, list9[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 10, list9[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 10, list9[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 10, list9[3]);
        }
        //Row 10 Data Validation
        if (VIPCompetitorPage.contents.Competitors9thPeers.isDisplayed()) {
        	String[] list10 = texts[9].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 11, list10[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 11, list10[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 11, list10[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 11, list10[3]);
        }
        //Row 11 Data Validation
        if (VIPCompetitorPage.contents.Competitors10thPeers.isDisplayed()) {
        	String[] list11 = texts[10].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 12, list11[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 12, list11[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 12, list11[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 12, list11[3]);
        }
        //Row 12 Data Validation
        if (VIPCompetitorPage.contents.Competitors11thPeers.isDisplayed()) {
        	String[] list12 = texts[11].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 13, list12[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 13, list12[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 13, list12[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 13, list12[3]);
        }
        //Row 13 Data Validation
        if (VIPCompetitorPage.contents.Competitors12thPeers.isDisplayed()) {
        	String[] list13 = texts[12].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 14, list13[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 14, list13[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 14, list13[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 14, list13[3]);
        }
        //Row 14 Data Validation
        if (VIPCompetitorPage.contents.Competitors13thPeers.isDisplayed()) {
        	String[] list14 = texts[13].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 15, list14[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 15, list14[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 15, list14[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 15, list14[3]);
        }
        //Row 15 Data Validation
        if (VIPCompetitorPage.contents.Competitors14thPeers.isDisplayed()) {
        	String[] list15 = texts[14].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 16, list15[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 16, list15[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 16, list15[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 16, list15[3]);
        }
        //Row 16 Data Validation
        if (VIPCompetitorPage.contents.Competitors15thPeers.isDisplayed()) {
        	String[] list16 = texts[15].split("\\|, ");
            TestDataHandler.verifyPPTTableText(9, 2, 1, 17, list16[1]);
            TestDataHandler.verifyPPTTableText(9, 2, 3, 17, list16[0]);
            TestDataHandler.verifyPPTTableText(9, 2, 4, 17, list16[2]);
            TestDataHandler.verifyPPTTableText(9, 2, 5, 17, list16[3]);
        }
		
		ReportLog.setTestCase("PPT_Reg_Auto_023");
		TestDataHandler.verifyPPTText(9, 2, "PEER-SET");
		TestDataHandler.verifyPPTTextFontSize(9, 2, "32.0");
		TestDataHandler.verifyPPTTextFontColor(9, 2, "Purple");
		TestDataHandler.verifyPPTText(9, 1, testDataHandler.company.toUpperCase() + "Has been benchmarked against its key global peers");
		TestDataHandler.verifyPPTTextFontSize(9, 1, "20.0");
		TestDataHandler.verifyPPTTextFontColor(9, 1, "Black");
		
	}

}
