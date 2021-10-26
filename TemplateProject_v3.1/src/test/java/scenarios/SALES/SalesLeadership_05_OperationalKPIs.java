package scenarios.SALES;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;

public class SalesLeadership_05_OperationalKPIs extends TestBase{
	
	@Test
	public void Sales_OperationalKPIs () throws Exception {
		ReportLog.setTestName("Sales Leadership - Operational KPIs");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("Sales_Reg_Auto_018");	
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.telcoCompany);
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
		WebControl.takeScreenshot("Sales_Reg_Auto_018");
		
		ReportLog.setTestCase("Sales_Reg_Auto_019");
		VIPSalesPage.contents.SideMenuIndustryOperatingMetricsText.click();
		Thread.sleep(3000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.waitForExist(true, 10);
		VIPSalesPage.contents.IndustryOperatingMetricsTitle.verifyText("Industry Operating Metrics - Telecommunication");
		WebControl.takeScreenshot("Sales_Reg_Auto_019");		
		
		ReportLog.setTestCase("Sales_Reg_Auto_020");
		VIPSalesPage.contents.SelectCountryDropdown.verifyDisplayed(true, 3);
		VIPSalesPage.contents.SelectedCountry.verifyText("United Kingdom");
		WebControl.takeScreenshot("Sales_Reg_Auto_020");		
		
		ReportLog.setTestCase("Sales_Reg_Auto_021");
		VIPSalesPage.contents.ViewCompetitors.verifyDisplayed(true, 3);
		VIPSalesPage.contents.ViewCompetitors.verifyEnabled(true, 3);
		VIPSalesPage.contents.ViewCompetitors.verifyText("View Competitors");
		WebControl.takeScreenshot("Sales_Reg_Auto_021");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_022");
		VIPSalesPage.contents.DoesMetricExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMetricExist.verifyText("METRIC");
		VIPSalesPage.contents.DoesRankExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesRankExist.verifyText("RANK");
		VIPSalesPage.contents.DoesCompanyNameExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesCompanyNameExist.verifyText("VODAFONE GROUP PLC");
		VIPSalesPage.contents.DoesPeerMedianExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesPeerMedianExist.verifyText("PEER MEDIAN");
		VIPSalesPage.contents.DoesBestExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesBestExist.verifyText("BEST");
		VIPSalesPage.contents.DoesMMYYYYExist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_022");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_023");
		VIPSalesPage.contents.DoesRankExist.hover();
		VIPSalesPage.contents.RankHeaderTooltip.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesCompanyNameExist.hover();
		VIPSalesPage.contents.CompanyNameHeaderTooltip.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesBestExist.hover();
		VIPSalesPage.contents.BestHeader2Tooltip.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_023");
		
		ReportLog.setTestCase("Sales_Reg_Auto_024");
		VIPSalesPage.contents.DoesMobileExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesFixedExist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesPayTVExist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_024");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_025");
		VIPSalesPage.contents.DoesMobileSubMetric1Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMobileSubMetric2Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMobileSubMetric3Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesMobileSubMetric4Exist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_025");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_026");
		VIPSalesPage.contents.DoesFixedSubMetric1Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesFixedSubMetric2Exist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_026");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_027");
		VIPSalesPage.contents.DoesPayTVSubMetric1Exist.verifyDisplayed(true, 3);
		VIPSalesPage.contents.DoesPayTVSubMetric2Exist.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_027");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_028");
		VIPSalesPage.contents.MobileSubMetric1iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric1iIcon.click();
		VIPSalesPage.contents.MobileSubMetric1iIconToolTip.verifyText("Operator market share of total active mobile connections excluding M2M/IoT (handset and mobile broadband).\n" + 
				"Active connections: Active subscribers exclude customers who have not used their mobile account for more than 3 months. Connections metrics relate to the end-of-period figure.\n" + 
				"Operator attribution: Mobile subscribers are counted on a network or wholesale basis – that is, customers of service providers without their own network infrastructure are allocated to the network operator(s) that support their service.");	
		VIPSalesPage.contents.MobileSubMetric1iIcon.click();
		VIPSalesPage.contents.MobileSubMetric2iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric2iIcon.click();
		VIPSalesPage.contents.MobileSubMetric2iIconToolTip.verifyText("Year on Year growth in total active mobile connections excluding M2M/IoT (handset and mobile broadband).");
		VIPSalesPage.contents.MobileSubMetric2iIcon.click();
		VIPSalesPage.contents.MobileSubMetric3iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric3iIcon.click();
		VIPSalesPage.contents.MobileSubMetric3iIconToolTip.verifyText("Total mobile service revenue (including IoT (M2M)) divided by total average mobile connections (excluding IoT (M2M)) per month.\n" + 
				"Operator service revenue allocation: Total service revenue for mobile services generally from an operator's own and hosted MVNOs’ subscribers, including termination (interconnection and roaming-in) revenue.");
		VIPSalesPage.contents.MobileSubMetric3iIcon.click();
		VIPSalesPage.contents.MobileSubMetric4iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.MobileSubMetric4iIcon.click();
		VIPSalesPage.contents.MobileSubMetric4iIconToolTip.verifyText("The number of disconnections from the operator's network during the period divided by the average number of subscribers during the period, expressed on a monthly basis.");
		VIPSalesPage.contents.MobileSubMetric4iIcon.click();
		VIPSalesPage.contents.FixedSubMetric1iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.FixedSubMetric1iIcon.click();
		VIPSalesPage.contents.FixedSubMetric1iIconToolTip.verifyText("Operator market share of fixed broadband connections, which are defined as all fixed broadband connections (xDSL, FTTP/B, cable modem, FWA and other fixed broadband).\n" + 
				"Note that satellite broadband connections are not measured. This metric excludes dedicated leased connections. Connections metrics relate to the end-of-period figure.");
		VIPSalesPage.contents.FixedSubMetric1iIcon.click();
		VIPSalesPage.contents.FixedSubMetric2iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.FixedSubMetric2iIcon.click();
		VIPSalesPage.contents.FixedSubMetric2iIconToolTip.verifyText("Year on Year growth in all fixed broadband connections (xDSL, FTTP/B, cable modem, FWA and other fixed broadband).");
		VIPSalesPage.contents.FixedSubMetric2iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric1iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.PayTVSubMetric1iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric1iIconToolTip.verifyText("Operator market share of total operator Pay-TV, which is defined as total number of traditional pay-tv connections, including cable, internet protocol television (iptv), pay–analogue terrestrial, pay–digital terrestrial television (pay-dtt), and satellite, plus the total number of users of paid-for 'over-the-top' (ott) video services that are sold independently of a traditional pay-tv service and are provided by a telecoms operator or a pay-tv provider that also offers traditional pay-tv services in the country. Multichannel multipoint distribution service (mmds), also known as wireless cable, is counted as part of the cable platform categories, split between analogue and digital.");
		VIPSalesPage.contents.PayTVSubMetric1iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric2iIcon.verifyDisplayed(true, 3);
		VIPSalesPage.contents.PayTVSubMetric2iIcon.click();
		VIPSalesPage.contents.PayTVSubMetric2iIconToolTip.verifyText("Year on Year growth in total number of traditional Pay-TV connections (which include the categories defined in Pay-TV market share KPI).");
		VIPSalesPage.contents.PayTVSubMetric2iIcon.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_028");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_030");
		VIPSalesPage.contents.FootNote.verifyDisplayed(true, 5);	
		String FootNote = VIPSalesPage.contents.FootNote.getText();
		WebControl.takeScreenshot("Sales_Reg_Auto_030");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_031_Target");
		//Mobile connections market share
		String MCMSKPI1 = VIPSalesPage.contents.MCMSKPI.getText();
		if (!MCMSKPI1.contains("N/A")) {
		String MCMSKPI2 = MCMSKPI1.substring(MCMSKPI1.length() - 2, MCMSKPI1.length() - 1);
		String MCMSKPI3 = MCMSKPI1.substring(0, MCMSKPI1.length() - 3);
		VIPSalesPage.contents.MCMSKPI.verifyText(MCMSKPI3 + "." + MCMSKPI2 + "%");}
		else {VIPSalesPage.contents.MCMSKPI.verifyText("N/A");}
		//Growth in mobile connections (YoY)
		String GIMCKPI1 = VIPSalesPage.contents.GIMCKPI.getText();
		if (!GIMCKPI1.contains("N/A")) {
		String GIMCKPI2 = GIMCKPI1.substring(GIMCKPI1.length() - 2, GIMCKPI1.length() - 1);
		String GIMCKPI3 = GIMCKPI1.substring(0, GIMCKPI1.length() - 3);
		VIPSalesPage.contents.GIMCKPI.verifyText(GIMCKPI3 + "." + GIMCKPI2 + "%");}
		else {VIPSalesPage.contents.GIMCKPI.verifyText("N/A");}
		//ARPU (GBP)
		String ARPUKPI1 = VIPSalesPage.contents.ARPUKPI.getText();
		if (!ARPUKPI1.contains("N/A")) {
		String ARPUKPI2 = ARPUKPI1.substring(ARPUKPI1.length() - 1, ARPUKPI1.length());
		String ARPUKPI3 = ARPUKPI1.substring(0, ARPUKPI1.length() - 2);
		VIPSalesPage.contents.ARPUKPI.verifyText(ARPUKPI3 + "." + ARPUKPI2);}
		else {VIPSalesPage.contents.ARPUKPI.verifyText("N/A");}
		//Churn rate
		String CRKPI1 = VIPSalesPage.contents.CRKPI.getText();
		if (!CRKPI1.contains("N/A")) {
		String CRKPI2 = CRKPI1.substring(CRKPI1.length() - 2, CRKPI1.length() - 1);
		String CRKPI3 = CRKPI1.substring(0, CRKPI1.length() - 3);
		VIPSalesPage.contents.CRKPI.verifyText(CRKPI3 + "." + CRKPI2 + "%");}
		else {VIPSalesPage.contents.CRKPI.verifyText("N/A");}
		//Broadband connections market share
		String BCMSKPI1 = VIPSalesPage.contents.BCMSKPI.getText();
		if (!BCMSKPI1.contains("N/A")) {
		String BCMSKPI2 = BCMSKPI1.substring(BCMSKPI1.length() - 2, BCMSKPI1.length() - 1);
		String BCMSKPI3 = BCMSKPI1.substring(0, BCMSKPI1.length() - 3);
		VIPSalesPage.contents.BCMSKPI.verifyText(BCMSKPI3 + "." + BCMSKPI2 + "%");}
		else {VIPSalesPage.contents.BCMSKPI.verifyText("N/A");}
		//Growth in broadband connections (YoY)​
		String GIBCKPI1 = VIPSalesPage.contents.GIBCKPI.getText();
		if (!GIBCKPI1.contains("N/A")) {
		String GIBCKPI2 = GIBCKPI1.substring(GIBCKPI1.length() - 2, GIBCKPI1.length() - 1);
		String GIBCKPI3 = GIBCKPI1.substring(0, GIBCKPI1.length() - 3);
		VIPSalesPage.contents.GIBCKPI.verifyText(GIBCKPI3 + "." + GIBCKPI2 + "%");}
		else {VIPSalesPage.contents.GIBCKPI.verifyText("N/A");}
		//Pay-TV connections market share​
		String PCMSKPI1 = VIPSalesPage.contents.PCMSKPI.getText();
		if (!PCMSKPI1.contains("N/A")) {
		String PCMSKPI2 = PCMSKPI1.substring(PCMSKPI1.length() - 2, PCMSKPI1.length() - 1);
		String PCMSKPI3 = PCMSKPI1.substring(0, PCMSKPI1.length() - 3);
		VIPSalesPage.contents.PCMSKPI.verifyText(PCMSKPI3 + "." + PCMSKPI2 + "%");}
		else {VIPSalesPage.contents.PCMSKPI.verifyText("N/A");}
		//Growth in Pay-TV connections (YoY)​​
		String GIPCKPI1 = VIPSalesPage.contents.GIPCKPI.getText();
		if (!GIPCKPI1.contains("N/A")) {
		String GIPCKPI2 = GIPCKPI1.substring(GIPCKPI1.length() - 2, GIPCKPI1.length() - 1);
		String GIPCKPI3 = GIPCKPI1.substring(0, GIPCKPI1.length() - 3);
		VIPSalesPage.contents.GIPCKPI.verifyText(GIPCKPI3 + "." + GIPCKPI2 + "%");}
		else {VIPSalesPage.contents.GIPCKPI.verifyText("N/A");}
		WebControl.takeScreenshot("Sales_Reg_Auto_031_Target");
		
		ReportLog.setTestCase("Sales_Reg_Auto_031_Peer");
		//Mobile connections market share
		String MCMSKPIP1 = VIPSalesPage.contents.MCMSKPIP.getText();
		if (MCMSKPIP1 != "N/A") {
		String MCMSKPIP2 = MCMSKPIP1.substring(MCMSKPIP1.length() - 2, MCMSKPIP1.length() - 1);
		String MCMSKPIP3 = MCMSKPIP1.substring(0, MCMSKPIP1.length() - 3);
		VIPSalesPage.contents.MCMSKPIP.verifyText(MCMSKPIP3 + "." + MCMSKPIP2 + "%");}
		else {VIPSalesPage.contents.MCMSKPIP.verifyText(MCMSKPIP1);}
		//Growth in mobile connections (YoY)
		String GIMCKPIP1 = VIPSalesPage.contents.GIMCKPIP.getText();
		if (GIMCKPIP1 != "N/A") {
		String GIMCKPIP2 = GIMCKPIP1.substring(GIMCKPIP1.length() - 2, GIMCKPIP1.length() - 1);
		String GIMCKPIP3 = GIMCKPIP1.substring(0, GIMCKPIP1.length() - 3);
		VIPSalesPage.contents.GIMCKPIP.verifyText(GIMCKPIP3 + "." + GIMCKPIP2 + "%");}
		else {VIPSalesPage.contents.GIMCKPIP.verifyText(GIMCKPIP1);}
		//ARPU (GBP)
		String ARPUKPIP1 = VIPSalesPage.contents.ARPUKPIP.getText();
		if (ARPUKPIP1 != "N/A") {
		String ARPUKPIP2 = ARPUKPIP1.substring(ARPUKPIP1.length() - 1, ARPUKPIP1.length());
		String ARPUKPIP3 = ARPUKPIP1.substring(0, ARPUKPIP1.length() - 2);
		VIPSalesPage.contents.ARPUKPIP.verifyText(ARPUKPIP3 + "." + ARPUKPIP2);}
		else {VIPSalesPage.contents.ARPUKPIP.verifyText(ARPUKPIP1);}
		//Churn rate
		String CRKPIP1 = VIPSalesPage.contents.CRKPIP.getText();
		if (CRKPIP1 != "N/A") {
		String CRKPIP2 = CRKPIP1.substring(CRKPIP1.length() - 2, CRKPIP1.length() - 1);
		String CRKPIP3 = CRKPIP1.substring(0, CRKPIP1.length() - 3);
		VIPSalesPage.contents.CRKPIP.verifyText(CRKPIP3 + "." + CRKPIP2 + "%");}
		else {VIPSalesPage.contents.CRKPIP.verifyText(CRKPIP1);}
		//Broadband connections market share
		String BCMSKPIP1 = VIPSalesPage.contents.BCMSKPIP.getText();
		if (BCMSKPIP1 != "N/A") {
		String BCMSKPIP2 = BCMSKPIP1.substring(BCMSKPIP1.length() - 2, BCMSKPIP1.length() - 1);
		String BCMSKPIP3 = BCMSKPIP1.substring(0, BCMSKPIP1.length() - 3);
		VIPSalesPage.contents.BCMSKPIP.verifyText(BCMSKPIP3 + "." + BCMSKPIP2 + "%");}
		else {VIPSalesPage.contents.BCMSKPIP.verifyText(BCMSKPIP1);}
		//Growth in broadband connections (YoY)​
		String GIBCKPIP1 = VIPSalesPage.contents.GIBCKPIP.getText();
		if (GIBCKPIP1 != "N/A") {
		String GIBCKPIP2 = GIBCKPIP1.substring(GIBCKPIP1.length() - 2, GIBCKPIP1.length() - 1);
		String GIBCKPIP3 = GIBCKPIP1.substring(0, GIBCKPIP1.length() - 3);
		VIPSalesPage.contents.GIBCKPIP.verifyText(GIBCKPIP3 + "." + GIBCKPIP2 + "%");}
		else {VIPSalesPage.contents.GIBCKPIP.verifyText(GIBCKPIP1);}
		//Pay-TV connections market share​
		String PCMSKPIP1 = VIPSalesPage.contents.PCMSKPIP.getText();
		if (PCMSKPIP1 != "N/A") {
		String PCMSKPIP2 = PCMSKPIP1.substring(PCMSKPIP1.length() - 2, PCMSKPIP1.length() - 1);
		String PCMSKPIP3 = PCMSKPIP1.substring(0, PCMSKPIP1.length() - 3);
		VIPSalesPage.contents.PCMSKPIP.verifyText(PCMSKPIP3 + "." + PCMSKPIP2 + "%");}
		else {VIPSalesPage.contents.PCMSKPIP.verifyText(PCMSKPIP1);}
		//Growth in Pay-TV connections (YoY)​​
		String GIPCKPIP1 = VIPSalesPage.contents.GIPCKPIP.getText();
		if (GIPCKPIP1 != "N/A") {
		String GIPCKPIP2 = GIPCKPIP1.substring(GIPCKPIP1.length() - 2, GIPCKPIP1.length() - 1);
		String GIPCKPIP3 = GIPCKPIP1.substring(0, GIPCKPIP1.length() - 3);
		VIPSalesPage.contents.GIPCKPIP.verifyText(GIPCKPIP3 + "." + GIPCKPIP2 + "%");}
		else {VIPSalesPage.contents.GIPCKPIP.verifyText(GIPCKPIP1);}
		WebControl.takeScreenshot("Sales_Reg_Auto_031_Peer");
		
		ReportLog.setTestCase("Sales_Reg_Auto_031_Best");
		//Mobile connections market share
		String MCMSKPIB1 = VIPSalesPage.contents.MCMSKPIB.getText();
		if (MCMSKPIB1 != "N/A") {
		String MCMSKPIB2 = MCMSKPIB1.substring(MCMSKPIB1.length() - 2, MCMSKPIB1.length() - 1);
		String MCMSKPIB3 = MCMSKPIB1.substring(0, MCMSKPIB1.length() - 3);
		VIPSalesPage.contents.MCMSKPIB.verifyText(MCMSKPIB3 + "." + MCMSKPIB2 + "%");}
		else {VIPSalesPage.contents.MCMSKPIB.verifyText(MCMSKPIB1);}
		//Growth in mobile connections (YoY)
		String GIMCKPIB1 = VIPSalesPage.contents.GIMCKPIB.getText();
		if (GIMCKPIB1 != "N/A") {
		String GIMCKPIB2 = GIMCKPIB1.substring(GIMCKPIB1.length() - 2, GIMCKPIB1.length() - 1);
		String GIMCKPIB3 = GIMCKPIB1.substring(0, GIMCKPIB1.length() - 3);
		VIPSalesPage.contents.GIMCKPIB.verifyText(GIMCKPIB3 + "." + GIMCKPIB2 + "%");}
		else {VIPSalesPage.contents.GIMCKPIB.verifyText(GIMCKPIB1);}
		//ARPU (GBP)
		String ARPUKPIB1 = VIPSalesPage.contents.ARPUKPIB.getText();
		if (ARPUKPIB1 != "N/A") {
		String ARPUKPIB2 = ARPUKPIB1.substring(ARPUKPIB1.length() - 1, ARPUKPIB1.length());
		String ARPUKPIB3 = ARPUKPIB1.substring(0, ARPUKPIB1.length() - 2);
		VIPSalesPage.contents.ARPUKPIB.verifyText(ARPUKPIB3 + "." + ARPUKPIB2);}
		else {VIPSalesPage.contents.ARPUKPIB.verifyText(ARPUKPIB1);}
		//Churn rate
		String CRKPIB1 = VIPSalesPage.contents.CRKPIB.getText();
		if (CRKPIB1 != "N/A") {
		String CRKPIB2 = CRKPIB1.substring(CRKPIB1.length() - 2, CRKPIB1.length() - 1);
		String CRKPIB3 = CRKPIB1.substring(0, CRKPIB1.length() - 3);
		VIPSalesPage.contents.CRKPIB.verifyText(CRKPIB3 + "." + CRKPIB2 + "%");}
		else {VIPSalesPage.contents.CRKPIB.verifyText(CRKPIB1);}
		//Broadband connections market share
		String BCMSKPIB1 = VIPSalesPage.contents.BCMSKPIB.getText();
		if (BCMSKPIB1 != "N/A") {
		String BCMSKPIB2 = BCMSKPIB1.substring(BCMSKPIB1.length() - 2, BCMSKPIB1.length() - 1);
		String BCMSKPIB3 = BCMSKPIB1.substring(0, BCMSKPIB1.length() - 3);
		VIPSalesPage.contents.BCMSKPIB.verifyText(BCMSKPIB3 + "." + BCMSKPIB2 + "%");}
		else {VIPSalesPage.contents.BCMSKPIB.verifyText(BCMSKPIB1);}
		//Growth in broadband connections (YoY)​
		String GIBCKPIB1 = VIPSalesPage.contents.GIBCKPIB.getText();
		if (GIBCKPIB1 != "N/A") {
		String GIBCKPIB2 = GIBCKPIB1.substring(GIBCKPIB1.length() - 2, GIBCKPIB1.length() - 1);
		String GIBCKPIB3 = GIBCKPIB1.substring(0, GIBCKPIB1.length() - 3);
		VIPSalesPage.contents.GIBCKPIB.verifyText(GIBCKPIB3 + "." + GIBCKPIB2 + "%");}
		else {VIPSalesPage.contents.GIBCKPIB.verifyText(GIBCKPIB1);}
		//Pay-TV connections market share​
		String PCMSKPIB1 = VIPSalesPage.contents.PCMSKPIB.getText();
		if (PCMSKPIB1 != "N/A") {
		String PCMSKPIB2 = PCMSKPIB1.substring(PCMSKPIB1.length() - 2, PCMSKPIB1.length() - 1);
		String PCMSKPIB3 = PCMSKPIB1.substring(0, PCMSKPIB1.length() - 3);
		VIPSalesPage.contents.PCMSKPIB.verifyText(PCMSKPIB3 + "." + PCMSKPIB2 + "%");}
		else {VIPSalesPage.contents.PCMSKPIB.verifyText(PCMSKPIB1);}
		//Growth in Pay-TV connections (YoY)​​
		String GIPCKPIB1 = VIPSalesPage.contents.GIPCKPIB.getText();
		if (GIPCKPIB1 != "N/A") {
		String GIPCKPIB2 = GIPCKPIB1.substring(GIPCKPIB1.length() - 2, GIPCKPIB1.length() - 1);
		String GIPCKPIB3 = GIPCKPIB1.substring(0, GIPCKPIB1.length() - 3);
		VIPSalesPage.contents.GIPCKPIB.verifyText(GIPCKPIB3 + "." + GIPCKPIB2 + "%");}
		else {VIPSalesPage.contents.GIPCKPIB.verifyText(GIPCKPIB1);}
		WebControl.takeScreenshot("Sales_Reg_Auto_031_Best");
		
		ReportLog.setTestCase("Sales_Reg_Auto_032");
		VIPSalesPage.contents.ViewCompetitors.click();
		VIPSalesPage.contents.CompetitorsPagePopUp.verifyDisplayed(true, 30);
		WebControl.takeScreenshot("Sales_Reg_Auto_032");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_033");
		VIPSalesPage.contents.CompetitorsPagePopUpTitle.verifyDisplayed(true, 30);
		WebControl.takeScreenshot("Sales_Reg_Auto_033");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_034");
		VIPSalesPage.contents.CompetitorsCompanyNameLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsCompanyNameLbl.verifyText("Company Name");
		VIPSalesPage.contents.CompetitorsNoOfMobileLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsNoOfMobileLbl.verifyText("Number of Mobile Connections ('000s)");
		VIPSalesPage.contents.CompetitorsNoOfBroadbandLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsNoOfBroadbandLbl.verifyText("Number of Broadband Connections ('000s)");
		VIPSalesPage.contents.CompetitorsNoOfPayTVLbl.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsNoOfPayTVLbl.verifyText("Number of Pay-TV Connections ('000s)");
		WebControl.takeScreenshot("Sales_Reg_Auto_034");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_035");
		VIPSalesPage.contents.CompetitorsTarget.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsTargetName.verifyText("Vodafone Group Plc");
		VIPSalesPage.contents.CompetitorsTargetNMC.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsTargetNBC.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsTargetNPC.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeers.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersName1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersNMC1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersNBC1.verifyDisplayed(true, 3);
		VIPSalesPage.contents.CompetitorsPeersNPC1.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("Sales_Reg_Auto_035");
		
		ReportLog.setTestCase("Sales_Reg_Auto_033_Prep");
		String CompetitorsTargetName = VIPSalesPage.contents.CompetitorsTargetName.getText();
		String CompetitorsTargetNMC = VIPSalesPage.contents.CompetitorsTargetNMC.getText();
		String CompetitorsTargetNBC = VIPSalesPage.contents.CompetitorsTargetNBC.getText();
		String CompetitorsTargetNPC = VIPSalesPage.contents.CompetitorsTargetNPC.getText();
		String CompetitorsPeersName1 = VIPSalesPage.contents.CompetitorsPeersName1.getText();
		String CompetitorsPeersNMC1 = VIPSalesPage.contents.CompetitorsPeersNMC1.getText();
		String CompetitorsPeersNBC1 = VIPSalesPage.contents.CompetitorsPeersNBC1.getText();
		String CompetitorsPeersNPC1 = VIPSalesPage.contents.CompetitorsPeersNPC1.getText();
		String CompetitorsPeersName2 = VIPSalesPage.contents.CompetitorsPeersName2.getText();
		String CompetitorsPeersNMC2 = VIPSalesPage.contents.CompetitorsPeersNMC2.getText();
		String CompetitorsPeersNBC2 = VIPSalesPage.contents.CompetitorsPeersNBC2.getText();
		String CompetitorsPeersNPC2 = VIPSalesPage.contents.CompetitorsPeersNPC2.getText();
		String CompetitorsPeersName3 = VIPSalesPage.contents.CompetitorsPeersName3.getText();
		String CompetitorsPeersNMC3 = VIPSalesPage.contents.CompetitorsPeersNMC3.getText();
		String CompetitorsPeersNBC3 = VIPSalesPage.contents.CompetitorsPeersNBC3.getText();
		String CompetitorsPeersNPC3 = VIPSalesPage.contents.CompetitorsPeersNPC3.getText();
		String CompetitorsPeersName4 = VIPSalesPage.contents.CompetitorsPeersName4.getText();
		String CompetitorsPeersNMC4 = VIPSalesPage.contents.CompetitorsPeersNMC4.getText();
		String CompetitorsPeersNBC4 = VIPSalesPage.contents.CompetitorsPeersNBC4.getText();
		String CompetitorsPeersNPC4 = VIPSalesPage.contents.CompetitorsPeersNPC4.getText();
		String CompetitorsPeersName5 = VIPSalesPage.contents.CompetitorsPeersName5.getText();
		String CompetitorsPeersNMC5 = VIPSalesPage.contents.CompetitorsPeersNMC5.getText();
		String CompetitorsPeersNBC5 = VIPSalesPage.contents.CompetitorsPeersNBC5.getText();
		String CompetitorsPeersNPC5 = VIPSalesPage.contents.CompetitorsPeersNPC5.getText();
		String CompetitorsPeersName6 = VIPSalesPage.contents.CompetitorsPeersName6.getText();
		String CompetitorsPeersNMC6 = VIPSalesPage.contents.CompetitorsPeersNMC6.getText();
		String CompetitorsPeersNBC6 = VIPSalesPage.contents.CompetitorsPeersNBC6.getText();
		String CompetitorsPeersNPC6 = VIPSalesPage.contents.CompetitorsPeersNPC6.getText();
		String CompetitorsPeersName7 = VIPSalesPage.contents.CompetitorsPeersName7.getText();
		String CompetitorsPeersNMC7 = VIPSalesPage.contents.CompetitorsPeersNMC7.getText();
		String CompetitorsPeersNBC7 = VIPSalesPage.contents.CompetitorsPeersNBC7.getText();
		String CompetitorsPeersNPC7 = VIPSalesPage.contents.CompetitorsPeersNPC7.getText();
		VIPSalesPage.contents.CloseCompetitorsPagePopUp.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_033_Prep");	
		
		ReportLog.setTestCase("Sales_Reg_Auto_036_to_042");
		if (!testDataHandler.site.equals("https://web.valueinsightsplatform.accentureanalytics.com")) {
		WebControl.openNew("https://web.valueinsightsplatform.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();}
		else { WebControl.openNew("https://valueinsightsplatform-stage.accentureanalytics.com");
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.WhatsNewModal.waitForExist(true, 25);
		VIPLandingPage.contents.WhatsNewModalCloseButton.click();}
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.telcoCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.MCMSKPI.waitForExist(true, 25);
		VIPSalesPage.contents.MCMSKPI.verifyText(MCMSKPI1);
		VIPSalesPage.contents.GIMCKPI.verifyText(GIMCKPI1);
		VIPSalesPage.contents.ARPUKPI.verifyText(ARPUKPI1);
		VIPSalesPage.contents.CRKPI.verifyText(CRKPI1);
		VIPSalesPage.contents.BCMSKPI.verifyText(BCMSKPI1);
		VIPSalesPage.contents.GIBCKPI.verifyText(GIBCKPI1);
		VIPSalesPage.contents.PCMSKPI.verifyText(PCMSKPI1);
		VIPSalesPage.contents.GIPCKPI.verifyText(GIPCKPI1);
		VIPSalesPage.contents.MCMSKPIP.verifyText(MCMSKPIP1);
		VIPSalesPage.contents.GIMCKPIP.verifyText(GIMCKPIP1);
		VIPSalesPage.contents.ARPUKPIP.verifyText(ARPUKPIP1);
		VIPSalesPage.contents.CRKPIP.verifyText(CRKPIP1);
		VIPSalesPage.contents.BCMSKPIP.verifyText(BCMSKPIP1);
		VIPSalesPage.contents.GIBCKPIP.verifyText(GIBCKPIP1);
		VIPSalesPage.contents.PCMSKPIP.verifyText(PCMSKPIP1);
		VIPSalesPage.contents.GIPCKPIP.verifyText(GIPCKPIP1);
		VIPSalesPage.contents.MCMSKPIB.verifyText(MCMSKPIB1);
		VIPSalesPage.contents.GIMCKPIB.verifyText(GIMCKPIB1);
		VIPSalesPage.contents.ARPUKPIB.verifyText(ARPUKPIB1);
		VIPSalesPage.contents.CRKPIB.verifyText(CRKPIB1);
		VIPSalesPage.contents.BCMSKPIB.verifyText(BCMSKPIB1);
		VIPSalesPage.contents.GIBCKPIB.verifyText(GIBCKPIB1);
		VIPSalesPage.contents.PCMSKPIB.verifyText(PCMSKPIB1);
		VIPSalesPage.contents.GIPCKPIB.verifyText(GIPCKPIB1);
		VIPSalesPage.contents.FootNote.verifyText(FootNote);
		WebControl.takeScreenshot("Sales_Reg_Auto_036_to_042");
		
		ReportLog.setTestCase("Sales_Reg_Auto_033_Validation");
		VIPSalesPage.contents.ViewCompetitors.click();
		VIPSalesPage.contents.CompetitorsPagePopUp.verifyDisplayed(true, 30);
		VIPSalesPage.contents.CompetitorsPagePopUpTitle.verifyDisplayed(true, 30);
		VIPSalesPage.contents.CompetitorsTargetName.waitForExist(true, 30);
		VIPSalesPage.contents.CompetitorsTargetName.verifyText(CompetitorsTargetName);
		VIPSalesPage.contents.CompetitorsTargetNMC.verifyText(CompetitorsTargetNMC);
		VIPSalesPage.contents.CompetitorsTargetNBC.verifyText(CompetitorsTargetNBC);
		VIPSalesPage.contents.CompetitorsTargetNPC.verifyText(CompetitorsTargetNPC);
		VIPSalesPage.contents.CompetitorsPeersName1.verifyText(CompetitorsPeersName1);
		VIPSalesPage.contents.CompetitorsPeersNMC1.verifyText(CompetitorsPeersNMC1);
		VIPSalesPage.contents.CompetitorsPeersNBC1.verifyText(CompetitorsPeersNBC1);
		VIPSalesPage.contents.CompetitorsPeersNPC1.verifyText(CompetitorsPeersNPC1);
		VIPSalesPage.contents.CompetitorsPeersName2.verifyText(CompetitorsPeersName2);
		VIPSalesPage.contents.CompetitorsPeersNMC2.verifyText(CompetitorsPeersNMC2);
		VIPSalesPage.contents.CompetitorsPeersNBC2.verifyText(CompetitorsPeersNBC2);
		VIPSalesPage.contents.CompetitorsPeersNPC2.verifyText(CompetitorsPeersNPC2);
		VIPSalesPage.contents.CompetitorsPeersName3.verifyText(CompetitorsPeersName3);
		VIPSalesPage.contents.CompetitorsPeersNMC3.verifyText(CompetitorsPeersNMC3);
		VIPSalesPage.contents.CompetitorsPeersNBC3.verifyText(CompetitorsPeersNBC3);
		VIPSalesPage.contents.CompetitorsPeersNPC3.verifyText(CompetitorsPeersNPC3);
		VIPSalesPage.contents.CompetitorsPeersName4.verifyText(CompetitorsPeersName4);
		VIPSalesPage.contents.CompetitorsPeersNMC4.verifyText(CompetitorsPeersNMC4);
		VIPSalesPage.contents.CompetitorsPeersNBC4.verifyText(CompetitorsPeersNBC4);
		VIPSalesPage.contents.CompetitorsPeersNPC4.verifyText(CompetitorsPeersNPC4);
		VIPSalesPage.contents.CompetitorsPeersName5.verifyText(CompetitorsPeersName5);
		VIPSalesPage.contents.CompetitorsPeersNMC5.verifyText(CompetitorsPeersNMC5);
		VIPSalesPage.contents.CompetitorsPeersNBC5.verifyText(CompetitorsPeersNBC5);
		VIPSalesPage.contents.CompetitorsPeersNPC5.verifyText(CompetitorsPeersNPC5);
		VIPSalesPage.contents.CompetitorsPeersName6.verifyText(CompetitorsPeersName6);
		VIPSalesPage.contents.CompetitorsPeersNMC6.verifyText(CompetitorsPeersNMC6);
		VIPSalesPage.contents.CompetitorsPeersNBC6.verifyText(CompetitorsPeersNBC6);
		VIPSalesPage.contents.CompetitorsPeersNPC6.verifyText(CompetitorsPeersNPC6);
		VIPSalesPage.contents.CompetitorsPeersName7.verifyText(CompetitorsPeersName7);
		VIPSalesPage.contents.CompetitorsPeersNMC7.verifyText(CompetitorsPeersNMC7);
		VIPSalesPage.contents.CompetitorsPeersNBC7.verifyText(CompetitorsPeersNBC7);
		VIPSalesPage.contents.CompetitorsPeersNPC7.verifyText(CompetitorsPeersNPC7);
		VIPSalesPage.contents.CloseCompetitorsPagePopUp.click();
		WebControl.takeScreenshot("Sales_Reg_Auto_033_Validation");
		WebControl.close();
		WebControl.switchWithUrl(testDataHandler.site);
		
		ReportLog.setTestCase("Sales_Reg_Auto_043");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.ClickSelectCountryDropdown.click();
		VIPSalesPage.contents.SelectGermany.click();
		VIPSalesPage.contents.FootNote.waitForExist(true, 15);
		VIPSalesPage.contents.FootNote.verifyText("Source: Analysys Mason; Accenture Client Value Services.\n" + 
		"Disclaimer: Analysys Mason content is to be used for Accenture business purposes only. If you use this material, you are responsible for reading and complying with the posted contract terms and conditions.\n" + 
		"Use within Accenture: You may use, copy, distribute and display portions of the deliverables for internal business purposes only by and among Accenture's employees globally, including employees of its affiliates. Please note that full reports may not be shared. The following statement must be included with each quote or excerpt: © Analysys Mason. Insert report title and date.\n" + 
		"Use outside Accenture: The Analysys Mason deliverables are prepared for Accenture's internal use and cannot be distributed in whole or in part outside of the company without the prior written consent of Analysys Mason.");
		WebControl.takeScreenshot("Sales_Reg_Auto_043");
		
		ReportLog.setTestCase("Sales_Reg_Auto_044");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("NZSE:CNU");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.Message.verifyDisplayed(true, 15);
		VIPSalesPage.contents.Message.verifyText("No Information Available.");
		WebControl.takeScreenshot("Sales_Reg_Auto_044");
		
		ReportLog.setTestCase("Sales_Reg_Auto_045");
		VIPOverviewPage.contents.BackToSearchButton2.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys("Pfizer");
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1000);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPSalesPage.contents.SideMenuIndustryOperatingMetrics.click();
		VIPSalesPage.contents.Message.verifyDisplayed(true, 15);
		VIPSalesPage.contents.Message.verifyText("Coming Soon – Industry Specific Operating KPIs.");
		WebControl.takeScreenshot("Sales_Reg_Auto_045");
	
	}
		
}


