package scenarios.Custom;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
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
import pageobjects.VIPOverviewPage;

public class Financials_Custom__All extends TestBase {


	
	@Test(priority=1)
	public void CUSTOM_LandingOverviewCompetitorsPage () throws Exception {
		ReportLog.setTestName("CUSTOM - Landing, Overview & Competitors Page");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_022");
		Thread.sleep(30000);
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
		WebControl.takeScreenshot("CUSTOM_RT_TC_022");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_023");
		VIPOverviewPage.contents.BackToSearchButton.click();
		//Thread.sleep(2000);
		VIPCustomPage.contents.ModalCloseButton.click(); //-- Removed in STG and PROD
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 1);
		VIPLandingPage.contents.ShareButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareButton.hover();
		VIPLandingPage.contents.ShareButtonTooltip.verifyText("Share");
		WebControl.takeScreenshot("CUSTOM_RT_TC_023");
		
		/*Share button and modal
		 * Author: alyssa.kay.n.mabababa*/
		ReportLog.setTestCase("CUSTOM_RT_TC_024");
		VIPLandingPage.contents.ShareButton.click();
		Thread.sleep(2000);
		String CompanyName_CR = VIPLandingPage.contents.CompanyCardName.getText();
		String RequestDate1 = VIPLandingPage.contents.CompanyCardDate.getText();
		DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy"); 
		Date RequestDate2 = (Date)formatter.parse(RequestDate1);
		SimpleDateFormat newFormat = new SimpleDateFormat("dd MMM yyyy");
		String RequestDate = newFormat.format(RequestDate2);
		VIPLandingPage.contents.ShareModalHeader.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalHeader.verifyText("Share Report");
		VIPLandingPage.contents.ShareModalCompany.verifyDisplayed(true, 10);
		VIPCustomPage.contents.ShareModalTargetCompany.verifyText("Target Company:");
		VIPLandingPage.contents.ShareModalCompany.verifyText(CompanyName_CR);
		VIPLandingPage.contents.ShareModalDate.verifyText("Request Date:");
		VIPLandingPage.contents.ShareModalDateValue.verifyText(RequestDate);
		VIPLandingPage.contents.ShareModalEmail.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalShareButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalCancelButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.ShareModalClose.verifyDisplayed(true, 10);
		WebControl.takeScreenshot("CUSTOM_RT_TC_024");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_025");
		VIPLandingPage.contents.ShareModalEmail.sendKeys("alyssa.kay.n.mababa@accenture.com");
		VIPLandingPage.contents.ShareModalShareButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2500);
		WebControl.takeScreenshot("CUSTOM_RT_TC_025");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_026");
		VIPLandingPage.contents.ShareButton.click();
		VIPLandingPage.contents.ShareModalCancelButton.verifyClick();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.ShareButton.click();
		VIPLandingPage.contents.ShareModalClose.verifyClick();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_026");
		
		/*Overview Page
		 * Author: jaeanne.p.s.lozares
		 * Update: charisma.l.desipeda*/
		ReportLog.setTestCase("CUSTOM_RT_TC_033");
		VIPLandingPage.contents.OverviewButton.click();
		do {
		            WebControl.waitForPageToLoad(45);
		}
		while (!VIPOverviewPage.contents.OverviewTitle.isDisplayed());
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		VIPOverviewPage.contents.OverviewDescription.verifyDisplayed(true, 30);
		WebControl.takeScreenshot("CUSTOM_RT_TC_033");
		        
		ReportLog.setTestCase("CUSTOM_RT_TC_034");
        VIPCustomPage.contents.RevenueTitle.verifyText("REVENUE");
        VIPCustomPage.contents.EBITMarginTitle.verifyText("EBIT MARGIN");
        VIPCustomPage.contents.EnterpriseValueTitle.verifyText("ENTERPRISE VALUE");
        VIPCustomPage.contents.EmployeesTitle.verifyText("EMPLOYEES");
        VIPCustomPage.contents.IndustryTitle.verifyText("INDUSTRY");
        VIPCustomPage.contents.TypeTitle.verifyText("TYPE");
        String CompanyType = VIPCustomPage.contents.CompanyType.getText();
        VIPCustomPage.contents.HeadquartersTitle.verifyText("HEADQUARTERS");
        VIPCustomPage.contents.WebsiteTitle.verifyText("WEBSITE");
		WebControl.takeScreenshot("CUSTOM_RT_TC_034");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_035 and 36");
		//Revenue
		String RevenueS = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 1, 1);
		if (!RevenueS.equals("")) {
			Double Revenue = Double.parseDouble(RevenueS);
			String[] RevenueValue = VIPCustomPage.contents.RevenueValue.getText().split("\\s");
		if (Revenue  < 1000) {
			VIPCustomPage.contents.RevenueValue.verifyText(RevenueValue[0] + " " + Revenue + " M");}
		else if (Revenue  >= 1000 & Revenue < 1000000) {
			BigDecimal Revenue1 = new BigDecimal(Revenue/1000).setScale(1, BigDecimal.ROUND_HALF_UP);
			VIPCustomPage.contents.RevenueValue.verifyText(RevenueValue[0] + " " + Revenue1 + " B");}
		else if (Revenue  >= 1000000 & Revenue < 1000000000) {
			BigDecimal Revenue1 = new BigDecimal(Revenue/1000000).setScale(1, BigDecimal.ROUND_HALF_UP);
			VIPCustomPage.contents.RevenueValue.verifyText(RevenueValue[0] + " " + Revenue1 + " T");}
		}
		else {VIPCustomPage.contents.RevenueValue.verifyText("-");}
		//EBIT Margin
		String EBITMargin = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 2, 1);
		if (!EBITMargin.equals("")) {
			Double EBITMargin2 = Double.parseDouble(EBITMargin);
			EBITMargin2 = (double) Math.round(EBITMargin2*100);
			String EBITMargin3 = EBITMargin2 + "%";
			VIPCustomPage.contents.EBITMarginValue.verifyText(EBITMargin3.replace(".0", ""));}
		else {VIPCustomPage.contents.EBITMarginValue.verifyText("-");}
		//Enterprise Value
		String EnterpriseS = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 3, 1);
		if (!EnterpriseS.equals("")) {
			Double Enterprise = Double.parseDouble(EnterpriseS);
			String[] EnterpriseValue = VIPCustomPage.contents.EnterpriseValue.getText().split("\\s");
		if (Enterprise  < 1000) {
			VIPCustomPage.contents.EnterpriseValue.verifyText(EnterpriseValue[0] + " " + Enterprise + " M");}
		else if (Enterprise  >= 1000 & Enterprise < 1000000) {
			BigDecimal Enterprise1 = new BigDecimal(Enterprise/1000).setScale(1, BigDecimal.ROUND_HALF_UP);
			VIPCustomPage.contents.EnterpriseValue.verifyText(EnterpriseValue[0] + " " + Enterprise1 + " B");}
		else if (Enterprise  >= 1000000 & Enterprise < 1000000000) {
			BigDecimal Enterprise1 = new BigDecimal(Enterprise/1000000).setScale(1, BigDecimal.ROUND_HALF_UP);
			VIPCustomPage.contents.EnterpriseValue.verifyText(EnterpriseValue[0] + " " + Enterprise1 + " T");}
		}
		else {VIPCustomPage.contents.EnterpriseValue.verifyText("-");}
		//Employees
		String Employees = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 4, 1);
		if (Employees.equals("")) {
			VIPCustomPage.contents.EmployeesValue.verifyText("-");}
		else {
			VIPCustomPage.contents.EmployeesValue.verifyText(Employees);}		
		
		//TRSFinancialSummary
		String TRS = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 8, 1);
		String TRSYOY = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 8, 3);
		VIPCustomPage.contents.TRSTitle.verifyText("TOTAL RETURN TO SHAREHOLDERS");
		VIPCustomPage.contents.TRSYOYTitle.verifyText("YOY TREND");
		VIPCustomPage.contents.TRSYear.verifyText("1 year TRS");
		if (!TRS.equals("")) {
			Double TRS1 = Double.parseDouble(TRS);
			BigDecimal TRS2 = new BigDecimal(TRS1*100).setScale(1, RoundingMode.HALF_UP);
			String TRS3 = TRS2 + "%";
			VIPCustomPage.contents.TRSValue.verifyText(TRS3);
			
			BigDecimal TRSYOY1 = new BigDecimal(TRSYOY);
			BigDecimal TRSYOY2 = TRSYOY1.setScale(1, BigDecimal.ROUND_HALF_UP);
			String TRSYOY3 = TRSYOY2 + " pps";
			VIPCustomPage.contents.TRSTrendValue.verifyText(TRSYOY3);
			
			Double TRSYOYTREND = new Double(TRSYOY);
			if (TRSYOYTREND<0) {
				VIPCustomPage.contents.TRSTrendRedIcon.verifyDisplayed(true,5);}
			else if (TRSYOYTREND>0) {
				VIPCustomPage.contents.TRSTrendGreenIcon.verifyDisplayed(true,5);}
			else {
				VIPCustomPage.contents.TrendYellowIcon.verifyDisplayed(true,5);}
		}
		else {VIPCustomPage.contents.TRSValue.verifyText("-");}
		//RGFinancialSummary
		String RG = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 9, 1);
		String RGYOY = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 9, 3);
		VIPCustomPage.contents.RGTitle.verifyText("REVENUE GROWTH");
		VIPCustomPage.contents.RGYOYTitle.verifyText("YOY TREND");
		VIPCustomPage.contents.RGYear.verifyText("1 year Growth");
		if (!RG.equals("")) {
			Double RG1 = Double.parseDouble(RG);
			BigDecimal RG2 = new BigDecimal(RG1*100).setScale(1, RoundingMode.HALF_UP);
			String RG3 = RG2 + "%";
			VIPCustomPage.contents.RGValue.verifyText(RG3);
			
			BigDecimal RGYOY1 = new BigDecimal(RGYOY);
			BigDecimal RGYOY2 = RGYOY1.setScale(1, BigDecimal.ROUND_HALF_UP);
			String RGYOY3 = RGYOY2 + " pps";
			VIPCustomPage.contents.RGTrendValue.verifyText(RGYOY3);
			
			Double RGYOYTREND = new Double(RGYOY);
			if (RGYOYTREND<0) {
				VIPCustomPage.contents.RGTrendRedIcon.verifyDisplayed(true,5);}
			else if (RGYOYTREND>0) {
				VIPCustomPage.contents.RGTrendGreenIcon.verifyDisplayed(true,5);}
			else {
				VIPCustomPage.contents.TrendYellowIcon.verifyDisplayed(true,5);}
			}

		else {VIPCustomPage.contents.RGValue.verifyText("-");}
		//ROICFinancialSummary
		String ROIC = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 10, 1);
		String ROICYOY = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 10, 3);
		String ROICYEAR = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 2);
		VIPCustomPage.contents.ROICTitle.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL (ROIC)");
		VIPCustomPage.contents.ROICYOYTitle.verifyText("YOY TREND");
		if (!ROIC.equals("")) {
			Double ROIC1 = Double.parseDouble(ROIC);
			BigDecimal ROIC2 = new BigDecimal(ROIC1*100).setScale(1, RoundingMode.HALF_UP);
			String ROIC3 = ROIC2 + "%";
			VIPCustomPage.contents.ROICValue.verifyText(ROIC3);
			
			BigDecimal ROICYOY1 = new BigDecimal(ROICYOY);
			BigDecimal ROICYOY2 = ROICYOY1.setScale(1, BigDecimal.ROUND_HALF_UP);
			String ROICYOY3 = ROICYOY2 + " pps";
			VIPCustomPage.contents.ROICTrendValue.verifyText(ROICYOY3);
			
			Double ROICYOYTREND = new Double(ROICYOY);
			if (ROICYOYTREND<0) {
				VIPCustomPage.contents.ROICTrendRedIcon.verifyDisplayed(true,5);}
			else if (ROICYOYTREND>0) {
				VIPCustomPage.contents.ROICTrendGreenIcon.verifyDisplayed(true,5);}
			else {
				VIPCustomPage.contents.TrendYellowIcon.verifyDisplayed(true,5);}
			}

		else {VIPCustomPage.contents.ROICValue.verifyText("-");}
		
		String[] ROICYear1 = VIPCustomPage.contents.ROICYear.getText().split("-");
		String[] ROICYear2 = ROICYear1[1].split("/");
		if((ROICYear2[0].equals("01")) || (ROICYear2[0].equals("02")) || (ROICYear2[0].equals("03")) || (ROICYear2[0].equals("04")) || (ROICYear2[0].equals("05")) || (ROICYear2[0].equals("06")) || (ROICYear2[0].equals("07")) || (ROICYear2[0].equals("08")) || (ROICYear2[0].equals("09"))) {
			String ROICYear3 = ROICYear2[0].substring(1);
			VIPCustomPage.contents.CEYear.verifyText(ROICYear1[0]+"-0"+ROICYear3+"/"+ROICYear2[1]);}
		else {
			VIPCustomPage.contents.CEYear.verifyText(ROICYEAR);}
		//EBITFinancialSummary
		String EBIT = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 11, 1);
		String EBITYOY = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 11, 3);
		String EBITYEAR = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 2);
		VIPCustomPage.contents.EbitTitle.verifyText("EBIT MARGIN");
		VIPCustomPage.contents.EbitYOYTitle.verifyText("YOY TREND");
		if (!EBIT.equals("")) {
			Double EBIT1 = Double.parseDouble(EBIT);
			BigDecimal EBIT2 = new BigDecimal(EBIT1*100).setScale(1, RoundingMode.HALF_UP);
			String EBIT3 = EBIT2 + "%";
			VIPCustomPage.contents.EBITValue.verifyText(EBIT3);
			
			BigDecimal EBITYOY1 = new BigDecimal(EBITYOY);
			BigDecimal EBITYOY2 = EBITYOY1.setScale(1, BigDecimal.ROUND_HALF_UP);
			String EBITYOY3 = EBITYOY2 + " pps";
			VIPCustomPage.contents.EBITTrendValue.verifyText(EBITYOY3);
			
			Double EBITYOYTREND = new Double(EBITYOY);
			if (EBITYOYTREND<0) {
				VIPCustomPage.contents.EBITTrendRedIcon.verifyDisplayed(true,5);}
			else if (EBITYOYTREND>0) {
				VIPCustomPage.contents.EBITTrendGreenIcon.verifyDisplayed(true,5);}
			else {
				VIPCustomPage.contents.TrendYellowIcon.verifyDisplayed(true,5);}
			}

		else {VIPCustomPage.contents.EBITValue.verifyText("-");}
		
		String[] EBITYear1 = VIPCustomPage.contents.EbitYear.getText().split("-");
		String[] EBITYear2 = EBITYear1[1].split("/");
		if((EBITYear2[0].equals("01")) || (EBITYear2[0].equals("02")) || (EBITYear2[0].equals("03")) || (EBITYear2[0].equals("04")) || (EBITYear2[0].equals("05")) || (EBITYear2[0].equals("06")) || (EBITYear2[0].equals("07")) || (EBITYear2[0].equals("08")) || (EBITYear2[0].equals("09"))) {
			String EBITYear3 = EBITYear2[0].substring(1);
			VIPCustomPage.contents.CEYear.verifyText(EBITYear1[0]+"-0"+EBITYear3+"/"+EBITYear2[1]);}
		else {
			VIPCustomPage.contents.CEYear.verifyText(EBITYEAR);}
		//CEFinancialSummary
		String CE = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 12, 1);
		String CEYOY = TestDataHandler.getExcelData(testDataHandler.filePath, "Overview", 12, 3);
		String CEYEAR = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 2);
		VIPCustomPage.contents.CETitle.verifyText("CAPITAL EFFICIENCY");
		VIPCustomPage.contents.CEYOYTitle.verifyText("YOY TREND");
		if (!CE.equals("")) {
			BigDecimal CE1 = new BigDecimal(CE);
			BigDecimal CE2 = CE1.setScale(2, BigDecimal.ROUND_HALF_UP);
			String CE3 = CE2 + "";
			VIPCustomPage.contents.CEValue.verifyText(CE3);
			
			BigDecimal CEYOY1 = new BigDecimal(CEYOY);
			BigDecimal CEYOY2 = CEYOY1.setScale(2, BigDecimal.ROUND_HALF_UP);
			String CEYOY3 = CEYOY2 + "";
			VIPCustomPage.contents.CETrendValue.verifyText(CEYOY3);
			
			Double CEYOYTREND = new Double(CEYOY);
			if (CEYOYTREND<0) {
				VIPCustomPage.contents.CETrendRedIcon.verifyDisplayed(true,5);}
			else if (CEYOYTREND>0) {
				VIPCustomPage.contents.CETrendGreenIcon.verifyDisplayed(true,5);}
			else {
				VIPCustomPage.contents.TrendYellowIcon.verifyDisplayed(true,5);}
			}
		else {VIPCustomPage.contents.CEValue.verifyText("-");}
		
		String[] CEYear1 = VIPCustomPage.contents.CEYear.getText().split("-");
		String[] CEYear2 = CEYear1[1].split("/");
		if((CEYear2[0].equals("01")) || (CEYear2[0].equals("02")) || (CEYear2[0].equals("03")) || (CEYear2[0].equals("04")) || (CEYear2[0].equals("05")) || (CEYear2[0].equals("06")) || (CEYear2[0].equals("07")) || (CEYear2[0].equals("08")) || (CEYear2[0].equals("09"))) {
			String CEYear3 = CEYear2[0].substring(1);
			VIPCustomPage.contents.CEYear.verifyText(CEYear1[0]+"-0"+CEYear3+"/"+CEYear2[1]);}
		else {
			VIPCustomPage.contents.CEYear.verifyText(CEYEAR);}

		//Industry		
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.DowntimeModal.waitForExist(true, 25);
		Thread.sleep(5000);
		VIPLandingPage.contents.DowntimeModalCloseButton.click();
		Thread.sleep(2000);
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
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.customJavaClick();
		Thread.sleep(1500);
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		String SSDescription = VIPCustomPage.contents.SSOverviewDescription.getText();
		String SSIndustry = VIPCustomPage.contents.SSOverviewIndustry.getText();
		String SSType = VIPCustomPage.contents.SSOverviewType.getText();
		String SSHeadquarters = VIPCustomPage.contents.SSOverviewHeadquarters.getText();
		String SSWebsite = VIPCustomPage.contents.SSOverviewWebsite.getText();
		Thread.sleep(5000);
		//NavigateToCustomAgain
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.OverviewButton.verifyDisplayed(true, 10);
		VIPLandingPage.contents.OverviewButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPOverviewPage.contents.OverviewTitle.verifyDisplayed(true, 30);
		VIPCustomPage.contents.CustomOverviewDescription.verifyText(SSDescription);
		VIPCustomPage.contents.CustomOverviewIndustry.verifyText(SSIndustry);
		VIPCustomPage.contents.CustomOverviewType.verifyText(SSType);
		VIPCustomPage.contents.CustomOverviewHeadquarters.verifyText(SSHeadquarters);
		VIPCustomPage.contents.CustomOverviewWebsite.verifyText(SSWebsite);	
		Thread.sleep(2000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_035 and 36");
		
		/*Competitors Page
		 * Author: alyssa.kay.n.mabababa*/
		ReportLog.setTestCase("CUSTOM_RT_TC_037");
		VIPCustomPage.contents.CompetitorsTab.hover();
		VIPCustomPage.contents.CompetitorsTab.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPCustomPage.contents.CompetitorsApplyButton.verifyDisplayed(true, 30);
		VIPCustomPage.contents.CompetitorsApplyButton.hover();
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorTitle.verifyDisplayed(true, 10);
		VIPCustomPage.contents.CompetitorsHeader.verifyDisplayed(true, 10);
		VIPCustomPage.contents.CompetitorsHeader.verifyCssValue("border-right", "8px solid rgb(161, 0, 255)");
		VIPCustomPage.contents.CompetitorsHeader.verifyCssValue("box-shadow", "rgb(217, 217, 214) -1px 2px 2px 0px");
		VIPCustomPage.contents.CompetitorsHeaderIcon.verifyDisplayed(true, 10);
		VIPCustomPage.contents.CompetitorsHeaderNote.verifyDisplayed(true, 10);
		VIPCustomPage.contents.CompetitorsHeaderNote.verifyCssValue("color","rgba(92, 92, 92, 1)");
		WebControl.takeScreenshot("CUSTOM_RT_TC_037");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_038");
		VIPCustomPage.contents.CompanyNameHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CompanyNameHeader.verifyText("Company Name");
		VIPCustomPage.contents.LatestFinancialsHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.LatestFinancialsHeader.verifyText("Latest\n"+"Financials");
		VIPCustomPage.contents.WACCHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WACCHeader.verifyText("WACC\n"+"(%)");

		//Currency Checking
		//Updated [3/5/2021] by alyssa.kay.n.mababa
		VIPCustomPage.contents.RevenueHeader.verifyDisplayed(true, 5);
		String[] CurrencyRev = VIPCustomPage.contents.RevenueHeader.getText().split("\\s");	
		if (CurrencyRev[1].equals("(JPY")){
			if (CurrencyRev[2].equals("bn)")) {
				VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " bn)");}
			else {VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " tn)");}}
		else if (CurrencyRev[1].equals("(KRW")){
			if (CurrencyRev[2].equals("bn)")) {
				VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " bn)");}
			else {VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " tn)");}}
		else if (CurrencyRev[1].equals("(CNY")){
			if (CurrencyRev[2].equals("bn)")) {
				VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " bn)");}
			else {VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " tn)");}}
		else if (CurrencyRev[1].equals("(IDR")){
			if (CurrencyRev[2].equals("bn)")) {
				VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " bn)");}
			else {VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " tn)");}}
		else if (CurrencyRev[1].equals("(COP")){
			if (CurrencyRev[2].equals("bn)")) {
				VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " bn)");}
			else {VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " tn)");}}
		else if (CurrencyRev[1].equals("(CLP")){
			if (CurrencyRev[2].equals("bn)")) {
				VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " bn)");}
			else {VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " tn)");}}
		else {
			VIPCustomPage.contents.RevenueHeader.verifyText(CurrencyRev[0]+"\n"+CurrencyRev[1] + " mn)");}

		VIPCustomPage.contents.EVHeader.verifyDisplayed(true, 5);
		String[] CurrencyEV = VIPCustomPage.contents.EVHeader.getText().split("\\s");	
		if (CurrencyEV[2].equals("(JPY")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " tn)");}}
		else if (CurrencyEV[2].equals("(KRW")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " tn)");}}
		else if (CurrencyEV[2].equals("(CNY")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " tn)");}}
		else if (CurrencyEV[2].equals("(IDR")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " tn)");}}
		else if (CurrencyEV[2].equals("(COP")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " tn)");}}
		else if (CurrencyEV[2].equals("(CLP")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " tn)");}}
		else {
			VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+"\n"+CurrencyEV[1]+"\n"+CurrencyEV[2]+"\n" + " mn)");}
		
		VIPCustomPage.contents.ICHeader.verifyDisplayed(true, 5);
		String[] CurrencyIC = VIPCustomPage.contents.ICHeader.getText().split("\\s");	
		if (CurrencyIC[2].equals("(JPY")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " tn)");}}
		else if (CurrencyIC[2].equals("(KRW")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " tn)");}}
		else if (CurrencyIC[2].equals("(CNY")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " tn)");}}
		else if (CurrencyIC[2].equals("(IDR")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " tn)");}}
		else if (CurrencyIC[2].equals("(COP")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " tn)");}}
		else if (CurrencyIC[2].equals("(CLP")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " tn)");}}
		else {
			VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+"\n"+CurrencyIC[1]+"\n"+CurrencyIC[2]+"\n" + " mn)");}
		WebControl.takeScreenshot("CUSTOM_RT_TC_038");

		//Updated [3/5/2021] by alyssa.kay.n.mababa - Added data validation for Time Period
		ReportLog.setTestCase("CUSTOM_RT_TC_039");
		VIPCustomPage.contents.CompetitorsCompanyNameIcon.verifyDisplayed(true, 10);
		VIPCustomPage.contents.CompetitorsCompanyNameIcon.hover();
		VIPCustomPage.contents.CompetitorsCompanyNameIconTooltip.verifyText("Click on company names to change alias");
		WebControl.takeScreenshot("CUSTOM_RT_TC_039");
		

        ReportLog.setTestCase("CUSTOM_RT_TC_044_Data_Validation");
		String TargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 0);
		String PeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 0);
		String PeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 0);
		String PeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 0);
		String TickerTargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 1);
		String TickerPeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 1);
		String TickerPeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 1);
		String TickerPeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 1);
		String TimePeriodTargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 2);
		String TimePeriodPeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 2);
		String TimePeriodPeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 2);
		String TimePeriodPeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 2);
		String RevenueTargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 3);
		String RevenuePeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 3);
		String RevenuePeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 3);
		String RevenuePeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 3);
		String EVTargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 4);
		String EVPeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 4);
		String EVPeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 4);
		String EVPeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 4);
		String ICTargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 5);
		String ICPeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 5);
		String ICPeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 5);
		String ICPeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 5);
		String WACCTargetComp = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 1, 6);
		String WACCPeerComp1 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 2, 6);
		String WACCPeerComp2 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 3, 6);
		String WACCPeerComp3 = TestDataHandler.getExcelData(testDataHandler.filePath, "Competitors", 4, 6);
		
		Double DRevenueTargetComp = Double.parseDouble(RevenueTargetComp);
		Double DRevenuePeerComp1 = Double.parseDouble(RevenuePeerComp1);
		Double DRevenuePeerComp2 = Double.parseDouble(RevenuePeerComp2);
		Double DRevenuePeerComp3 = Double.parseDouble(RevenuePeerComp3);
		Double DEVTargetComp = Double.parseDouble(EVTargetComp);
		Double DEVPeerComp1 = Double.parseDouble(EVPeerComp1);
		Double DEVPeerComp2 = Double.parseDouble(EVPeerComp2);
		Double DEVPeerComp3 = Double.parseDouble(EVPeerComp3);
		Double DICTargetComp = Double.parseDouble(ICTargetComp);
		Double DICPeerComp1 = Double.parseDouble(ICPeerComp1);
		Double DICPeerComp2 = Double.parseDouble(ICPeerComp2);
		Double DICPeerComp3 = Double.parseDouble(ICPeerComp3);
		Double DWACCTargetComp = Double.parseDouble(WACCTargetComp);
		Double DWACCPeerComp1 = Double.parseDouble(WACCPeerComp1);
		Double DWACCPeerComp2 = Double.parseDouble(WACCPeerComp2);
		Double DWACCPeerComp3 = Double.parseDouble(WACCPeerComp3);
		
		VIPCustomPage.contents.CompanyName1.verifyText(TargetComp);
		VIPCustomPage.contents.CompanyName2.verifyText(PeerComp1);
		VIPCustomPage.contents.CompanyName3.verifyText(PeerComp2);
		VIPCustomPage.contents.CompanyName4.verifyText(PeerComp3);
		VIPCustomPage.contents.TickerTargetComp.verifyText(TickerTargetComp);
		VIPCustomPage.contents.TickerPeerComp1.verifyText(TickerPeerComp1);
		VIPCustomPage.contents.TickerPeerComp2.verifyText(TickerPeerComp2);
		VIPCustomPage.contents.TickerPeerComp3.verifyText(TickerPeerComp3);
		
		//Old format
		String[] TimePeriodTargetCompSplit = TimePeriodTargetComp.split("-");
		String[] TimePeriodPeerComp1Split = TimePeriodPeerComp1.split("-");
		String[] TimePeriodPeerComp2Split = TimePeriodPeerComp2.split("-");
		String[] TimePeriodPeerComp3Split = TimePeriodPeerComp3.split("-");
		SimpleDateFormat oldFormat = new SimpleDateFormat("MM/yyyy");
        Date TimePeriodTargetCompSplit1 = oldFormat.parse(TimePeriodTargetCompSplit[1]);
		Date TimePeriodPeerComp1Split1 = oldFormat.parse(TimePeriodPeerComp1Split[1]);
		Date TimePeriodPeerComp2Split1 = oldFormat.parse(TimePeriodPeerComp2Split[1]);
		Date TimePeriodPeerComp3Split1 = oldFormat.parse(TimePeriodPeerComp3Split[1]);		
		
		//New format
		SimpleDateFormat newFormatTimePeriod = new SimpleDateFormat("MM/yyyy");
        String newTimePeriodTargetComp = newFormatTimePeriod.format(TimePeriodTargetCompSplit1);
		String newTimePeriodPeerComp1 = newFormatTimePeriod.format(TimePeriodPeerComp1Split1);
		String newTimePeriodPeerComp2 = newFormatTimePeriod.format(TimePeriodPeerComp2Split1);
		String newTimePeriodPeerComp13 = newFormatTimePeriod.format(TimePeriodPeerComp3Split1);

		VIPCustomPage.contents.TimePeriod1.verifyText(TimePeriodTargetCompSplit[0]+"-"+newTimePeriodTargetComp);
		VIPCustomPage.contents.TimePeriod2.verifyText(TimePeriodPeerComp1Split[0]+"-"+newTimePeriodPeerComp1);
		VIPCustomPage.contents.TimePeriod3.verifyText(TimePeriodPeerComp2Split[0]+"-"+newTimePeriodPeerComp2);
		VIPCustomPage.contents.TimePeriod4.verifyText(TimePeriodPeerComp3Split[0]+"-"+newTimePeriodPeerComp13);	

		if (CurrencyRev[2].equals("bn)")){
			//Revenue
			if (!RevenueTargetComp.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenueTargetComp/1000).setScale(1, RoundingMode.HALF_UP);
				String RevenueTargetCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev1.verifyText(RevenueTargetCompStr);}
			else {VIPCustomPage.contents.Rev1.verifyText("");}
			if (!RevenuePeerComp1.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp1/1000).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev2.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev2.verifyText("");}
			if (!RevenuePeerComp2.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp2/1000).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev3.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev3.verifyText("");}
			if (!RevenuePeerComp3.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp3/1000).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev4.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev4.verifyText("");}
			//EV
			if (!EVTargetComp.equals("")) {
				BigDecimal EVTargetCompValue = new BigDecimal(DEVTargetComp/1000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVTargetComp = new DecimalFormat("#,###.#");
				String EVTargetCompStr = newEVTargetComp.format(EVTargetCompValue);
				VIPCustomPage.contents.EV1.verifyText(EVTargetCompStr);}
			else {VIPCustomPage.contents.EV1.verifyText("");}
			if (!EVPeerComp1.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp1/1000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV2.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV2.verifyText("");}
			if (!EVPeerComp2.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp2/1000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV3.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV3.verifyText("");}
			if (!EVPeerComp3.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp3/1000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV4.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV4.verifyText("");}
			//IC
			if (!ICTargetComp.equals("")) {
				BigDecimal ICTargetCompValue = new BigDecimal(DICTargetComp/1000).setScale(1, RoundingMode.HALF_UP);
				String ICTargetCompStr = String.valueOf(ICTargetCompValue);
				VIPCustomPage.contents.IC1.verifyText(ICTargetCompStr);}
			else {VIPCustomPage.contents.IC1.verifyText("");}
			if (!ICPeerComp1.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp1/1000).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC2.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC2.verifyText("");}
			if (!EVPeerComp2.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp2/1000).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC3.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC3.verifyText("");}
			if (!EVPeerComp3.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp3/1000).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC4.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC4.verifyText("");}
			//WACC
			if (!WACCTargetComp.equals("")) {
				BigDecimal WACCTargetCompValue = new BigDecimal(DWACCTargetComp*100).setScale(1, RoundingMode.HALF_UP);
				String WACCTargetCompStr = String.valueOf(WACCTargetCompValue);
				VIPCustomPage.contents.WACC1.verifyText(WACCTargetCompStr+"%");}
			else {VIPCustomPage.contents.WACC1.verifyText("");}
			if (!WACCPeerComp1.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp1*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC2.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC2.verifyText("");}
			if (!WACCPeerComp2.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp2*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC3.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC3.verifyText("");}
			if (!WACCPeerComp3.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp3*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC4.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC4.verifyText("");}
		}
		else if (CurrencyRev[2].equals("tn)")){
			//Revenue
			if (!RevenueTargetComp.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenueTargetComp/1000000).setScale(1, RoundingMode.HALF_UP);
				String RevenueTargetCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev1.verifyText(RevenueTargetCompStr);}
			else {VIPCustomPage.contents.Rev1.verifyText("");}
			if (!RevenuePeerComp1.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp1/1000000).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev2.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev2.verifyText("");}
			if (!RevenuePeerComp2.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp2/1000000).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev3.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev3.verifyText("");}
			if (!RevenuePeerComp3.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp3/1000000).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev4.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev4.verifyText("");}
			//EV
			if (!EVTargetComp.equals("")) {
				BigDecimal EVTargetCompValue = new BigDecimal(DEVTargetComp/1000000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVTargetComp = new DecimalFormat("#,###.#");
				String EVTargetCompStr = newEVTargetComp.format(EVTargetCompValue);
				VIPCustomPage.contents.EV1.verifyText(EVTargetCompStr);}
			else {VIPCustomPage.contents.EV1.verifyText("");}
			if (!EVPeerComp1.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp1/1000000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV2.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV2.verifyText("");}
			if (!EVPeerComp2.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp2/1000000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV3.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV3.verifyText("");}
			if (!EVPeerComp3.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp3/1000000).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV4.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV4.verifyText("");}
			//IC
			if (!ICTargetComp.equals("")) {
				BigDecimal ICTargetCompValue = new BigDecimal(DICTargetComp/1000000).setScale(1, RoundingMode.HALF_UP);
				String ICTargetCompStr = String.valueOf(ICTargetCompValue);
				VIPCustomPage.contents.IC1.verifyText(ICTargetCompStr);}
			else {VIPCustomPage.contents.IC1.verifyText("");}
			if (!ICPeerComp1.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp1/1000000).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC2.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC2.verifyText("");}
			if (!ICPeerComp2.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp2/1000000).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC3.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC3.verifyText("");}
			if (!ICPeerComp3.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp3/1000000).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC4.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC4.verifyText("");}
			//WACC
			if (!WACCTargetComp.equals("")) {
				BigDecimal WACCTargetCompValue = new BigDecimal(DWACCTargetComp*100).setScale(1, RoundingMode.HALF_UP);
				String WACCTargetCompStr = String.valueOf(WACCTargetCompValue);
				VIPCustomPage.contents.WACC1.verifyText(WACCTargetCompStr+"%");}
			else {VIPCustomPage.contents.WACC1.verifyText("");}
			if (!WACCPeerComp1.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp1*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC2.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC2.verifyText("");}
			if (!WACCPeerComp2.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp2*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC3.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC3.verifyText("");}
			if (!WACCPeerComp3.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp3*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC4.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC4.verifyText("");}
			}
		else {
			//Revenue
			if (!RevenueTargetComp.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenueTargetComp).setScale(1, RoundingMode.HALF_UP);
				String RevenueTargetCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev1.verifyText(RevenueTargetCompStr);}
			else {VIPCustomPage.contents.Rev1.verifyText("");}
			if (!RevenuePeerComp1.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp1).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev2.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev2.verifyText("");}
			if (!RevenuePeerComp2.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp2).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev3.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev3.verifyText("");}
			if (!RevenuePeerComp3.equals("")) {
				BigDecimal RevenuePeerCompValue = new BigDecimal(DRevenuePeerComp3).setScale(1, RoundingMode.HALF_UP);
				String RevenuePeerCompStr = String.valueOf(RevenuePeerCompValue);
				VIPCustomPage.contents.Rev4.verifyText(RevenuePeerCompStr);}
			else {VIPCustomPage.contents.Rev4.verifyText("");}
			//EV
			if (!EVTargetComp.equals("")) {
				BigDecimal EVTargetCompValue = new BigDecimal(DEVTargetComp).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVTargetComp = new DecimalFormat("#,###.#");
				String EVTargetCompStr = newEVTargetComp.format(EVTargetCompValue);
				VIPCustomPage.contents.EV1.verifyText(EVTargetCompStr);}
			else {VIPCustomPage.contents.EV1.verifyText("");}
			if (!EVPeerComp1.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp1).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV2.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV2.verifyText("");}
			if (!EVPeerComp2.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp2).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV3.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV3.verifyText("");}
			if (!EVPeerComp3.equals("")) {
				BigDecimal EVPeerCompValue = new BigDecimal(DEVPeerComp3).setScale(1, RoundingMode.HALF_UP);
				DecimalFormat newEVPeerComp = new DecimalFormat("#,###.#");
				String EVPeerCompStr = newEVPeerComp.format(EVPeerCompValue);
				VIPCustomPage.contents.EV4.verifyText(EVPeerCompStr);}
			else {VIPCustomPage.contents.EV4.verifyText("");}
			//IC
			if (!ICTargetComp.equals("")) {
				BigDecimal ICTargetCompValue = new BigDecimal(DICTargetComp).setScale(1, RoundingMode.HALF_UP);
				String ICTargetCompStr = String.valueOf(ICTargetCompValue);
				VIPCustomPage.contents.IC1.verifyText(ICTargetCompStr);}
			else {VIPCustomPage.contents.IC1.verifyText("");}
			if (!ICPeerComp1.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp1).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC2.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC2.verifyText("");}
			if (!EVPeerComp2.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp2).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC3.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC3.verifyText("");}
			if (!EVPeerComp3.equals("")) {
				BigDecimal ICPeerCompValue = new BigDecimal(DICPeerComp3).setScale(1, RoundingMode.HALF_UP);
				String ICPeerCompStr = String.valueOf(ICPeerCompValue);
				VIPCustomPage.contents.IC4.verifyText(ICPeerCompStr);}
			else {VIPCustomPage.contents.IC4.verifyText("");}
			//WACC
			if (!WACCTargetComp.equals("")) {
				BigDecimal WACCTargetCompValue = new BigDecimal(DWACCTargetComp*100).setScale(1, RoundingMode.HALF_UP);
				String WACCTargetCompStr = String.valueOf(WACCTargetCompValue);
				VIPCustomPage.contents.WACC1.verifyText(WACCTargetCompStr+"%");}
			else {VIPCustomPage.contents.WACC1.verifyText("");}
			if (!WACCPeerComp1.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp1*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC2.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC2.verifyText("");}
			if (!WACCPeerComp2.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp2*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC3.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC3.verifyText("");}
			if (!WACCPeerComp3.equals("")) {
				BigDecimal WACCPeerCompValue = new BigDecimal(DWACCPeerComp3*100).setScale(1, RoundingMode.HALF_UP);
				String WACCPeerCompStr = String.valueOf(WACCPeerCompValue);
				VIPCustomPage.contents.WACC4.verifyText(WACCPeerCompStr+"%");}
			else {VIPCustomPage.contents.WACC4.verifyText("");}
		}
		WebControl.takeScreenshot("CUSTOM_RT_TC_044_Data_Validation");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_040");
		//Company1
        VIPCustomPage.contents.CompanyName1.verifyDisplayed(true, 5);
		String CompanyName1Edited = VIPCustomPage.contents.CompanyName1.getText();
        VIPCustomPage.contents.CompanyName1.click();
        VIPCustomPage.contents.CompanyNameTextBox.sendKeys("_test" + Keys.ENTER);
		VIPCustomPage.contents.CompanyName1.verifyText(CompanyName1Edited+"_test");
		//Company 2
		VIPCustomPage.contents.CompanyName2.verifyDisplayed(true, 5);
		String CompanyName2Edited = VIPCustomPage.contents.CompanyName2.getText();
        VIPCustomPage.contents.CompanyName2.click();
        VIPCustomPage.contents.CompanyNameTextBox.sendKeys("_test" + Keys.ENTER);
		VIPCustomPage.contents.CompanyName2.verifyText(CompanyName2Edited+"_test");
		//Company 3
		VIPCustomPage.contents.CompanyName3.verifyDisplayed(true, 5);
		String CompanyName3Edited = VIPCustomPage.contents.CompanyName3.getText();
        VIPCustomPage.contents.CompanyName3.click();
        VIPCustomPage.contents.CompanyNameTextBox.sendKeys("_test" + Keys.ENTER);
		VIPCustomPage.contents.CompanyName3.verifyText(CompanyName3Edited+"_test");
		//Company 4
		VIPCustomPage.contents.CompanyName4.verifyDisplayed(true, 5);
		String CompanyName4Edited = VIPCustomPage.contents.CompanyName4.getText();
        VIPCustomPage.contents.CompanyName4.click();
        VIPCustomPage.contents.CompanyNameTextBox.sendKeys("_test" + Keys.ENTER);
		VIPCustomPage.contents.CompanyName4.verifyText(CompanyName4Edited+"_test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_040");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_041");
		VIPCustomPage.contents.CheckBox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CheckBox1.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_041");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_043");
		VIPCustomPage.contents.CompetitorsApplyButton.click();
		WebControl.waitForPageToLoad(5000);
		Thread.sleep(5000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_043");
		
		//Newly added TCER [3/5/2021] by alyssa.kay.n.mababa - Added TCER 042
		ReportLog.setTestCase("CUSTOM_RT_TC_042");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.SideMenuFinancialsClick.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.SideMenuFinancialsClick.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();

		if (CompanyType.equals("Public Company")){
			VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			if (VIPCustomPage.contents.HRAMenu.isDisplayed()) {
				VIPCustomPage.contents.HRAMenu.click();
				WebControl.waitForPageToLoad(45);
				VIPCustomPage.contents.SelectDashboard.click();}
			VIPCustomPage.contents.TRSMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.TRSSummaryMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.TRSLeversMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.SCMMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.EVICDecomMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.EVDissectionMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.AnalystRecoMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.RaPEMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.RGvsASMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.RevGrowthMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.EmpProdMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.PreTaxROICDriversMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.PreTaxROICDecompMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.OWCMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.CashCycleAnalysisMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.ReferenceCalculationsMenu.click();}
		else {
			VIPFinancialsPage.contents.CompetitivenessScorecardMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			if (VIPCustomPage.contents.HRAMenu.isDisplayed()) {
				VIPCustomPage.contents.HRAMenu.click();
				WebControl.waitForPageToLoad(45);
				VIPCustomPage.contents.SelectDashboard.click();}
			VIPCustomPage.contents.RGvsASMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.RevGrowthMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.EmpProdMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.PreTaxROICDriversMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.PreTaxROICDecompMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.OWCMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.CashCycleAnalysisMenu.click();
			VIPCustomPage.contents.SelectDashboard.click();
			VIPCustomPage.contents.ReferenceCalculationsMenu.click();}
		
		//Go back to Competitors Tab
		VIPCustomPage.contents.CompetitorsTab.hover();
		VIPCustomPage.contents.CompetitorsTab.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.UncheckBox1.click();
		VIPCustomPage.contents.CheckBox1.verifyDisplayed(true, 5);
		//Remove "_test"
		VIPCustomPage.contents.CompanyName1.click();
        VIPCustomPage.contents.CompanyNameTextBox.clear();
		VIPCustomPage.contents.CompanyNameTextBox.sendKeys(TargetComp + Keys.ENTER);
		VIPCustomPage.contents.CompanyName1.verifyText(TargetComp);
		VIPCustomPage.contents.CompanyName2.click();
        VIPCustomPage.contents.CompanyNameTextBox.clear();
		VIPCustomPage.contents.CompanyNameTextBox.sendKeys(PeerComp1 + Keys.ENTER);
		VIPCustomPage.contents.CompanyName2.verifyText(PeerComp1);
		VIPCustomPage.contents.CompanyName3.click();
        VIPCustomPage.contents.CompanyNameTextBox.clear();
		VIPCustomPage.contents.CompanyNameTextBox.sendKeys(PeerComp2 + Keys.ENTER);
		VIPCustomPage.contents.CompanyName3.verifyText(PeerComp2);
		VIPCustomPage.contents.CompanyName4.click();
        VIPCustomPage.contents.CompanyNameTextBox.clear();
		VIPCustomPage.contents.CompanyNameTextBox.sendKeys(PeerComp3 + Keys.ENTER);
		VIPCustomPage.contents.CompanyName4.verifyText(PeerComp3);
		VIPCustomPage.contents.CompetitorsApplyButton.click();
		WebControl.waitForPageToLoad(5000);
		Thread.sleep(5000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_042");
		
	}
	
	@Test(priority=2)
	public void Financials_CustomScorecard () throws Exception {
		ReportLog.setTestName("CUSTOM - Competitiveness Scorecard Dashboard");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Competitiveness Scorecard Dashboard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_157");
		VIPLandingPage.contents.HelpIcon.hover();
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
	
	@Test(priority=3)
	public void Financials_VCA () throws Exception {
		ReportLog.setTestName("CUSTOM - VCA");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Value Creation Areas Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_068");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.VCATRS.verifyText("Total Return to Shareholders (TRS)");
		VIPCustomPage.contents.VCASpread.verifyText("Spread");
		VIPCustomPage.contents.VCAGrowth.verifyText("Growth");
		VIPCustomPage.contents.VCAROIC.verifyText("ROIC");
		VIPCustomPage.contents.VCAWACC.verifyText("WACC");
		VIPCustomPage.contents.VCAMA.verifyText("M&A");
		VIPCustomPage.contents.VCAOrganic.verifyText("Organic");
		VIPCustomPage.contents.VCAOM.verifyText("Operating Margin");
		VIPCustomPage.contents.VCACE.verifyText("Capital Efficiency");
		VIPCustomPage.contents.VCAOpexRev.verifyText("Opex / Revenue");
		VIPCustomPage.contents.VCADepRev.verifyText("Depreciation / Revenue");
		VIPCustomPage.contents.VCAWCRev.verifyText("Working Capital /Revenue");
		VIPCustomPage.contents.VCAPPERev.verifyText("Net PPE / Revenue");
		VIPCustomPage.contents.VCAGIRev.verifyText("Goodwill & Intangibles /Revenue");
		VIPCustomPage.contents.VCANOARev.verifyText("Net Other Assets / Revenue");
		VIPCustomPage.contents.VCACOGSRev.verifyText("COGS / Revenue");
		VIPCustomPage.contents.VCASGARev.verifyText("SG&A / Revenue");
		VIPCustomPage.contents.VCAOCARev.verifyText("Operating Current Assets /Revenue");
		VIPCustomPage.contents.VCANIBLRev.verifyText("Non -InterestBearing Liabilities / Revenue");
		VIPCustomPage.contents.VCACashRev.verifyText("Cash / Revenue");
		VIPCustomPage.contents.VCANRRev.verifyText("Net Receivables / Revenue");
		VIPCustomPage.contents.VCAInvRev.verifyText("Inventory / Revenue");
		VIPCustomPage.contents.VCAACARev.verifyText("Other Cur. Assets / Revenue");
		VIPCustomPage.contents.VCAAPRev.verifyText("Accounts Payables / Revenue");
		VIPCustomPage.contents.VCAITPRev.verifyText("Inc. Taxes Payables / Revenue");
		VIPCustomPage.contents.VCAOCLRev.verifyText("Other Current Liab . / Revenue ROIC DECOMPOSITIONWORKING CAPITAL DECOMPOSITION");
		WebControl.takeScreenshot("CUSTOM_RT_TC_068");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_073");
		VIPCustomPage.contents.VCAChart1Title.verifyText("VALUE CREATION AREAS");
		VIPCustomPage.contents.VCAChart1InfoIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.VCAChart1InfoIcon.click();
		VIPCustomPage.contents.TooltipText1.verifyText(testDataHandler.VCATooltip);
		VIPCustomPage.contents.VCAChart1InfoIcon.click();
		VIPCustomPage.contents.VCAChart2Title.verifyText("VALUE CREATION POTENTIAL");
		VIPCustomPage.contents.VCAChart2InfoIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.VCAChart2InfoIcon.click();
		VIPCustomPage.contents.TooltipText1.verifyText(testDataHandler.VCPTooltip);
		VIPCustomPage.contents.VCAChart2InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_073");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_074");
		VIPCustomPage.contents.VCAToggleTop.verifyText("VALUE CREATION POTENTIAL");
		VIPCustomPage.contents.VCAToggleTopArrow.verifyDisplayed(true, 5);
		//VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.VCAToggleTopArrow.click();
		VIPCustomPage.contents.VCAToggleBot.verifyText("VALUE CREATION AREAS");
		VIPCustomPage.contents.VCAToggleBotArrow.verifyDisplayed(true, 5);
		VIPCustomPage.contents.VCAToggleBotArrow.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_074");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String VCATagline = VIPCustomPage.contents.DefaultTagline.getText();
		String VCAFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((VCATagline.equals("Value Creation Potential")) & (VCAFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("251 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Value Creation Potential_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Value Creation Potential_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("251 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Value Creation Potential_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.DefaultTagline.verifyText("Value Creation Potential_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	@Test(priority=4)
	public void Financials_HRGlassdoor () throws Exception {
		ReportLog.setTestName("CUSTOM - HR Glassdoor Benchmarking");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* HR Glassdoor Benchmarking Dashboard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_076,077");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.HRAMenu.click();
		VIPCustomPage.contents.HRAOverall.verifyText("Overall\n" + "\n" + "Score");
		VIPCustomPage.contents.HRACulValues.verifyText("Culture\n"  + "\n" + "& Values");
		VIPCustomPage.contents.HRAWLBalance.verifyText("Work/Life\n"  + "\n" + "Balance");
		VIPCustomPage.contents.HRASrMgt.verifyText("Senior\n"  + "\n" +"Mgmt");
		VIPCustomPage.contents.HRAComBenefits.verifyText("Comp &\n"  + "\n" + "Benefits");
		VIPCustomPage.contents.HRACarOpp.verifyText("Career\n"  + "\n" + "Opportunities");
		VIPCustomPage.contents.HRARecoFriend.verifyText("Recommend\n"  + "\n" + "to Friend");
		VIPCustomPage.contents.HRACEOApproval.verifyText("CEO\n"  + "\n" +"Approval");
		VIPCustomPage.contents.HRAPosOutlook.verifyText("Positive\n"  + "\n" + "Outlook");
		VIPCustomPage.contents.HRAReviews.verifyText("# of\n"  + "\n" + "Reviews");
		VIPCustomPage.contents.HRAPMText.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue7.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue8.verifyDisplayed(true, 5);
		VIPCustomPage.contents.HRAPMValue9.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_076,077");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String GlassdoorTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String GlassdoorFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((GlassdoorTagline.equals("HR Analysis – Glassdoor Benchmarking (Absolute Values)")) & (GlassdoorFootnote.equals("Source: Glassdoor; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("221 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Glassdoor; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Glassdoor; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("221 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Glassdoor; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("HR Analysis – Glassdoor Benchmarking (Absolute Values)_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Glassdoor; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}

	
	@Test(priority=5)
	public void Financials_TRS () throws Exception {
		ReportLog.setTestName("CUSTOM - TRS");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* TRS
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_080,081");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.TRSMenu.click();
		VIPCustomPage.contents.TRSSelectTFTitle.verifyText("Select Timeframe");
		VIPCustomPage.contents.TRSSelectTFDropdown.verifyText("3-year TRS");
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRS1Year.verifyText("1-year TRS");
		VIPCustomPage.contents.TRS3Year.verifyText("3-year TRS");
		VIPCustomPage.contents.TRS5Year.verifyText("5-year TRS");
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRSChart1Title.verifyText("3-YEAR TRS DEVELOPMENT");
		VIPCustomPage.contents.TRSChart2Title.verifyText("3-YEAR TRS CAGR");
		VIPCustomPage.contents.TRSChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRS1Year.click();
		VIPCustomPage.contents.TRSChart1Title.verifyText("1-YEAR TRS DEVELOPMENT");
		VIPCustomPage.contents.TRSChart2Title.verifyText("1-YEAR TRS GROWTH");
		VIPCustomPage.contents.TRSChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSelectTFDropdown.click();
		VIPCustomPage.contents.TRS5Year.click();
		VIPCustomPage.contents.TRSChart1Title.verifyText("5-YEAR TRS DEVELOPMENT");
		VIPCustomPage.contents.TRSChart2Title.verifyText("5-YEAR TRS CAGR");
		VIPCustomPage.contents.TRSChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_080,081");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String TRSTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String TRSFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((TRSTagline.equals("Total Return to Shareholders (TRS)")) & (TRSFootnote.equals("Source: Bloomberg; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("241 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Total Return to Shareholders (TRS)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Bloomberg; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Total Return to Shareholders (TRS)_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Bloomberg; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("241 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("794 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Total Return to Shareholders (TRS)_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Bloomberg; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Total Return to Shareholders (TRS)_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Bloomberg; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	@Test(priority=6)
	public void Financials_TRSSummary () throws Exception {
		ReportLog.setTestName("CUSTOM - TRS Summary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* TRS Summary
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_085,085,088");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.TRSSummaryMenu.click();
		VIPCustomPage.contents.TRSSToggleQuartiles.verifyText("Quartiles");
		VIPCustomPage.contents.TRSS3year.verifyText("3-year TRS CAGR");
		VIPCustomPage.contents.TRSSRevGrowth.verifyText("Revenue growth");
		//VIPCustomPage.contents.TRSSExcessMargin.verifyText("Excess change in margin");
		VIPCustomPage.contents.TRSSExcessMargin.verifyDisplayed(true, 5);
		//VIPCustomPage.contents.TRSSExcessEVEBIT.verifyText("Excess change in EV/EBIT");
		VIPCustomPage.contents.TRSSExcessEVEBIT.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSFundaValue.verifyText("Fundamental Value");
		VIPCustomPage.contents.TRSSInvExpectation.verifyText("Investor Expectation");
		VIPCustomPage.contents.TRSSDividendYield.verifyText("Dividend Yield");
		//VIPCustomPage.contents.TRSSCapitalStructure.verifyText("Capital Structure Impact");
		VIPCustomPage.contents.TRSSCapitalStructure.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSTimePeriod.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSCorrelation.verifyText("Correlation with TRS");
		VIPCustomPage.contents.TRSSToggleButton.click();
		VIPCustomPage.contents.TRSSToggleAllPeers.verifyText("All peers");
		VIPCustomPage.contents.TRSS3year.verifyText("3-year TRS CAGR");
		VIPCustomPage.contents.TRSSRevGrowth.verifyText("Revenue growth");
		//VIPCustomPage.contents.TRSSExcessMarginPeer.verifyText("Excess change in margin");
		VIPCustomPage.contents.TRSSExcessMarginPeer.verifyDisplayed(true, 5);
		//VIPCustomPage.contents.TRSSExcessEVEBITPeer.verifyText("Excess change in EV/EBIT");
		VIPCustomPage.contents.TRSSExcessEVEBITPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSFundaValue.verifyText("Fundamental Value");
		VIPCustomPage.contents.TRSSInvExpectation.verifyText("Investor Expectation");
		VIPCustomPage.contents.TRSSDividendYield.verifyText("Dividend Yield");
		//VIPCustomPage.contents.TRSSCapitalStructure.verifyText("Capital Structure Impact");
		VIPCustomPage.contents.TRSSCapitalStructure.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSTimePeriod.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSSCorrelation.verifyText("Correlation with TRS");
		WebControl.takeScreenshot("CUSTOM_RT_TC_085,086,088");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String TRSSummaryTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String TRSSummaryFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((TRSSummaryTagline.equals("TRS Decom: All Peers")) & (TRSSummaryFootnote.equals("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("426 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("TRS Decom: All Peers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("TRS Decom: All Peers_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("426 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("TRS Decom: All Peers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("TRS Decom: All Peers_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; (4) For Quartile data, median value for all companies except target company within each quartile is taken; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=7)
	public void Financials_TRSLevers () throws Exception {
		ReportLog.setTestName("CUSTOM - TRS Levers");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* TRS Summary
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_093");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.TRSLeversMenu.click();
		VIPCustomPage.contents.TRSLeversSITitle.verifyText("Select Indicator");
		VIPCustomPage.contents.TRSLeversRevGrowth.verifyText("Revenue Growth");
		WebControl.takeScreenshot("CUSTOM_RT_TC_093");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_092");
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversRevGrowth.verifyText("Revenue Growth");
		VIPCustomPage.contents.TRSLeversEBITMargin.verifyText("Change in EBIT Margin");
		VIPCustomPage.contents.TRSLeversEVEBITMargin.verifyText("Change in EV/EBIT Multiple");
		VIPCustomPage.contents.TRSLeversDividendYield.verifyText("Dividend Yield");
		VIPCustomPage.contents.TRSLeversCapStructure.verifyText("Capital Structure Impact");
		VIPCustomPage.contents.TRSLeversSIButton.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_092");
		
		
		// [Updated 3/5/2021 by alyssa.kay.n.mababa]
		ReportLog.setTestCase("CUSTOM_RT_TC_096,097,098");
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("REVENUE GROWTH");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		String ObservationBoxText = VIPCustomPage.contents.ObservationsText.getText();
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}		
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversEBITMargin.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("CHANGE IN EBIT MARGIN");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversEVEBITMargin.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("CHANGE IN EV/EBIT MULTIPLE");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversDividendYield.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("DIVIDEND YIELD");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		Thread.sleep(2000);
		VIPCustomPage.contents.TRSLeversSIButton.click();
		VIPCustomPage.contents.TRSLeversCapStructure.click();
		VIPCustomPage.contents.TRSLeversChart1Title.verifyText("CAPITAL STRUCTURE IMPACT");
		VIPCustomPage.contents.TRSLeversChart2Title.verifyText("OBSERVATIONS");
		VIPCustomPage.contents.TRSLeversChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TRSLeversChart1Corre.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ObservationsBox.verifyDisplayed(true, 5);
		if (ObservationBoxText.equals("test")) {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys(" ");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("");}
		else {
			VIPCustomPage.contents.ObservationsBox.click();
			VIPCustomPage.contents.ObservationTextBox.click();
			VIPCustomPage.contents.ObservationTextBox.clear();
			VIPCustomPage.contents.ObservationTextBox.sendKeys("test");
			Thread.sleep(2000);
			VIPCustomPage.contents.ModalOKButton.click();
			VIPCustomPage.contents.ObservationsText.verifyText("test");}
		WebControl.takeScreenshot("CUSTOM_RT_TC_096,097,098");	
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String TRSLeversTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String TRSLeversFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((TRSLeversTagline.equals("3 Year TRS Decomposition - Levers")) & (TRSLeversFootnote.equals("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.FootnoteCount.verifyText("533 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("3 Year TRS Decomposition - Levers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("3 Year TRS Decomposition - Levers_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("242 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("533 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("3 Year TRS Decomposition - Levers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("3 Year TRS Decomposition - Levers_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Change in margin is calculated as excess of EBIT growth over revenue growth; (2) Change in EV/EBIT has been calculated as excess of change in EV over EBIT; (3) Change in capital structure is the excess of change in market value in EV; Source: Bloomberg; S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=8)
	public void Financials_SCM () throws Exception {
		ReportLog.setTestName("CUSTOM - Strategic Control Map");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Strategic Control Map Dashboard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_100");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.SCMMenu.click();
		VIPCustomPage.contents.SCMChart1Title.verifyText("INVESTED CAPITAL PREMIUM (EV/IC)");
		VIPCustomPage.contents.SCMChart2Title.verifyText("INVESTED CAPITAL PREMIUM (EV/IC)");
		VIPCustomPage.contents.SCMChart3Title.verifyText("INVESTED CAPITAL TREND");
		WebControl.takeScreenshot("CUSTOM_RT_TC_100");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_101");
		VIPCustomPage.contents.SCMChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart3TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_101");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_102");
		VIPCustomPage.contents.SCMChart1InfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1InfoIcon.hover();
		VIPCustomPage.contents.SCMChart1Tooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.SCMChart1InfoIcon.click();
		//VIPCustomPage.contents.SCMChart1Tooltip1.verifyText(testDataHandler.SCMICPTooltip);
		VIPCustomPage.contents.SCMChart1Tooltip1.verifyText("EV/IC indicates the premium investors are attributing to the company’s invested capital.");
		VIPCustomPage.contents.SCMChart1InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_102");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_103");
		VIPCustomPage.contents.SCMChart1PencilIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1PencilIcon.hover();
		VIPCustomPage.contents.SCMPencilIconTooltip.verifyText("Click here to remove outliers from scatter");
		WebControl.takeScreenshot("CUSTOM_RT_TC_103");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_104,105");
		//105
		VIPCustomPage.contents.SCMChart1PencilIcon.click();
		VIPCustomPage.contents.SCMChart1Modal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalHeader.verifyText("Select/Deselect companies to show/hide");
		VIPCustomPage.contents.SCMChart1ModalNote.verifyText("Uncheck the companies to remove outliers from the Invested Capital Premium scatter chart. Please note that the peer median will not be affected as it will include all companies");
		VIPCustomPage.contents.SCMChart1ModalCheckbox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalCheckbox2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalApplyButton.verifyText("Apply");
		VIPCustomPage.contents.SCMChart1ModalXButton.verifyDisplayed(true, 5);
		//104
		VIPCustomPage.contents.SCMChart1ModalCheckbox1.click();
		VIPCustomPage.contents.SCMChart1ModalCheckbox2.click();
		VIPCustomPage.contents.SCMChart1ModalCheckbox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalUnCheckbox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMChart1ModalXButton.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_104,105");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_108,109");
		VIPCustomPage.contents.SCMToggleButton.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMToggleButton.click();
		VIPCustomPage.contents.SCMDPCTitle.verifyText("Detailed Peer Comparison");
		VIPCustomPage.contents.SCMDPCSITitle.verifyText("Select Indicator");
		VIPCustomPage.contents.SCMDPCSIButton.verifyText("Invested Capital Premium (EV/IC)");
		VIPCustomPage.contents.SCMDPCChartTitle.verifyText("INVESTED CAPITAL PREMIUM (EV/IC)");
		VIPCustomPage.contents.SCMDPCChartInfoIcon.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartInfoIcon.hover();
		VIPCustomPage.contents.SCMDPCChartTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.SCMDPCChartInfoIcon.click();
		//VIPCustomPage.contents.SCMDPCChartTooltip1.verifyText(testDataHandler.SCMICPTooltip);
		VIPCustomPage.contents.SCMDPCChartTooltip1.verifyText("EV/IC indicates the premium investors are attributing to the company’s invested capital.");
		VIPCustomPage.contents.SCMDPCChartInfoIcon.click();
		VIPCustomPage.contents.SCMDPCChartYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendPeer.verifyDisplayed(true, 5);
		
		VIPCustomPage.contents.SCMDPCSIButton.click();
		VIPCustomPage.contents.SCMDPCInvestedCapital.click();
		VIPCustomPage.contents.SCMDPCChartTitle.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCChartYear3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SCMDPCLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_108,109");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String SCMTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String SCMFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((SCMTagline.equals("Scatter: Enterprise Value to IC")) & (SCMFootnote.equals("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("244 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("370 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: Enterprise Value to IC_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scatter: Enterprise Value to IC_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("244 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("370 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: Enterprise Value to IC_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: Enterprise Value to IC_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: (1) Operating Enterprise Value = sum of market capitalization and net debt (total debt less excess cash) less long term investments and assets held for sale; Operating Enterprise Value is based on closing share prices as of last day of the previous month; (2) Invested Capital is defined as total cash investment that shareholders and debt holders have made in a company; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");	
	
	}
	
	
	@Test(priority=9)
	public void Financials_EVICDecom () throws Exception {
		ReportLog.setTestName("CUSTOM - EVIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* EVIC Decomposition Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_111");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.EVICDecomMenu.click();
		VIPCustomPage.contents.EVICDecomChart1.verifyText("PREMIUM ON INVESTED CAPITAL (EV/IC)");
		VIPCustomPage.contents.EVICDecomChart2.verifyText("EV/EBIT");
		VIPCustomPage.contents.EVICDecomChart3.verifyText("PRE-TAX ROIC (EBIT/IC)");
		VIPCustomPage.contents.EVICDecomChart2FutureEx.verifyText("Future Expectations");
		VIPCustomPage.contents.EVICDecomChart3OperatingPerf.verifyText("Operating Performance");
		VIPCustomPage.contents.EVICDecomLegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVICDecomLegendPeer.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_111");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_112");
		VIPCustomPage.contents.EVICDecomChart1InfoIcon.hover();
		VIPCustomPage.contents.EVICDecomChartTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.EVICDecomChart1InfoIcon.click();
		//VIPCustomPage.contents.EVICDecomChartTooltipText.verifyText(testDataHandler.SCMICPTooltip);
		VIPCustomPage.contents.EVICDecomChartTooltipText.verifyText("EV/IC indicates the premium investors are attributing to the company’s invested capital.");
		VIPCustomPage.contents.EVICDecomChart1InfoIcon.click();
		VIPCustomPage.contents.EVICDecomChart2InfoIcon.hover();
		VIPCustomPage.contents.EVICDecomChartTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.EVICDecomChart2InfoIcon.click();
		VIPCustomPage.contents.EVICDecomChartTooltipText.verifyText(testDataHandler.FEVEBITTooltip);
		VIPCustomPage.contents.EVICDecomChart2InfoIcon.click();
		VIPCustomPage.contents.EVICDecomChart3InfoIcon.hover();
		VIPCustomPage.contents.EVICDecomChartTooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.EVICDecomChart3InfoIcon.click();
		VIPCustomPage.contents.EVICDecomChartTooltipText.verifyText(testDataHandler.ROICTooltip);
		VIPCustomPage.contents.EVICDecomChart3InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_112");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_113");
		VIPCustomPage.contents.EVICDecomChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVICDecomChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVICDecomChart3TP.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_113");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String EVICDecompTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String EVICDecompFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((EVICDecompTagline.equals("EV to IC Decom")) & (EVICDecompFootnote.equals("Note: Premium on Invested Capital = Enterprise Value / Invested Capital. For the latest period EV to IC multiple, last reported IC figure has been used; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("261 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("595 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("EV to IC Decom_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Premium on Invested Capital = Enterprise Value / Invested Capital. For the latest period EV to IC multiple, last reported IC figure has been used; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("EV to IC Decom_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Premium on Invested Capital = Enterprise Value / Invested Capital. For the latest period EV to IC multiple, last reported IC figure has been used; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("261 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("595 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("EV to IC Decom_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Premium on Invested Capital = Enterprise Value / Invested Capital. For the latest period EV to IC multiple, last reported IC figure has been used; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("EV to IC Decom_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Premium on Invested Capital = Enterprise Value / Invested Capital. For the latest period EV to IC multiple, last reported IC figure has been used; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=10)
	public void Financials_EVDissection () throws Exception {
		ReportLog.setTestName("CUSTOM - EV Dissection");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* EV Dissection Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_116");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.EVDissectionMenu.click();
		VIPCustomPage.contents.EVDissectionChart1Title.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVDissectionChart2Title.verifyText("CURRENT AND FUTURE VALUE SPLIT OF EV");
		VIPCustomPage.contents.EVDissectionChart2Legend1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVDissectionChart2Legend2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_116");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_117");
		VIPCustomPage.contents.EVDissectionChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EVDissectionChart2TP.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_117");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String EVDissecTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String EVDissecFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((EVDissecTagline.equals("Target Future Value")) & (EVDissecFootnote.equals("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("9 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Target Future Value_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Target Future Value_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("9 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Target Future Value_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Target Future Value_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("**Note: (1) Market Capitalization = total value of issued shares of a publicly traded company, equal to share price times number of shares as of last day of the previous month; (2) Operating EV = market cap + minority interest + total debt – excess cash (ST investments) – value of long-term investments (including JVs and associates, marketable securities); calculated as on last day of the previous month. Op. EV includes retirement and pension liabilities for all companies (3) Current value = present value of current operations, based on NOPAT divided by the weighted average cost of capital; (4) Future value = enterprise value less current value; Numbers may not add up due to rounding; (5) NOPAT is Net operating profit after tax; Source: Bloomberg; S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=11)
	public void Financials_AnalystReco () throws Exception {
		ReportLog.setTestName("CUSTOM - Analyst Recommendations");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Analyst Recommendations Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_120");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.AnalystRecoMenu.click();
		VIPCustomPage.contents.AnalystRecoChart1Title.verifyText("ANALYST RATINGS");
		VIPCustomPage.contents.AnalystRecoChart2Title.verifyText("EXPECTED 1-YEAR SHARE PRICE GROWTH");
		VIPCustomPage.contents.AnalystRecoChart1Legend1.verifyText("Company - Rating");
		VIPCustomPage.contents.AnalystRecoChart1Legend2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart1Legend3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart1Legend4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart2Legend1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart2Legend2.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_120");
		
		
		ReportLog.setTestCase("CUSTOM_RT_TC_121");
		VIPCustomPage.contents.AnalystRecoChart1InfoIcon.hover();
		VIPCustomPage.contents.AnalystRecoToolTip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.AnalystRecoChart1InfoIcon.click();
		Thread.sleep(2000);
		//VIPCustomPage.contents.AnalystRecoToolTipText.verifyText(testDataHandler.ARTooltip);
		VIPCustomPage.contents.AnalystRecoToolTipText.verifyText("Analyst consensus rating is the average of analysts' rating about a stock's share price performance over the next one year.");
		VIPCustomPage.contents.AnalystRecoChart1InfoIcon.click();
		VIPCustomPage.contents.AnalystRecoChart2InfoIcon.hover();
		VIPCustomPage.contents.AnalystRecoToolTip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.AnalystRecoChart2InfoIcon.click();
		VIPCustomPage.contents.AnalystRecoToolTipText.verifyText(testDataHandler.SPGTooltip);
		VIPCustomPage.contents.AnalystRecoChart2InfoIcon.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_121");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_122");
		VIPCustomPage.contents.AnalystRecoChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystRecoChart2TP.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_122");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String AnalystRecoTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String AnalystRecoFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((AnalystRecoTagline.equals("Analyst Recommendations")) & (AnalystRecoFootnote.equals("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("252 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("627 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Recommendations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Analyst Recommendations_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("252 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("627 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Recommendations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Recommendations_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Analyst score of >3 implies a buy rating; =3 implies hold rating; and <3 implies a sell rating; breakup of buy-hold-sell ratings may not add up due to rounding; Source: Bloomberg; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		
	}
	
	@Test(priority=12)
	public void Financials_AnalystComment () throws Exception {
		ReportLog.setTestName("CUSTOM - Analyst Commentary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Analyst Commentary Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_127");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.AnalystCommentMenu.click();
		Thread.sleep(5000);
		VIPCustomPage.contents.AnalystCommentBox1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentBox6.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("CUSTOM_RT_TC_127");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_128");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.AnalystCommentBox1.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox2.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox3.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox4.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox5.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox6.click();
		VIPCustomPage.contents.AnalystCommentModal.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalHeader1.verifyText("Commentary 1:");
		VIPCustomPage.contents.AnalystCommentModalHeader2.verifyText("Commentary 2:");
		VIPCustomPage.contents.AnalystCommentModalHeader3.verifyText("Commentary 3:");
		VIPCustomPage.contents.AnalystCommentModalHeader4.verifyText("Commentary 4:");
		VIPCustomPage.contents.AnalystCommentModalHeader5.verifyText("Commentary 5:");
		VIPCustomPage.contents.AnalystCommentModalHeader6.verifyText("Commentary 6:");
		VIPCustomPage.contents.AnalystCommentModalFormat1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalFormat6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount3.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount4.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount5.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextCount6.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AnalystCommentModalTextBox1.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox1.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox1.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount1.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox2.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox2.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox2.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount2.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox3.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox3.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox3.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount3.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox4.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox4.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox4.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount4.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox5.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox5.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox5.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount5.verifyText("545 characters remaining");
		VIPCustomPage.contents.AnalystCommentModalTextBox6.click();
		VIPCustomPage.contents.AnalystCommentModalTextBox6.clear();
		VIPCustomPage.contents.AnalystCommentModalTextBox6.sendKeys("test");
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentModalTextCount6.verifyText("545 characters remaining");
		VIPCustomPage.contents.ModalApplyButton.click();
		Thread.sleep(1000);
		VIPCustomPage.contents.AnalystCommentBox1.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox2.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox3.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox4.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox5.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox6.verifyText("test ");
			Thread.sleep(1000);
		WebControl.takeScreenshot("CUSTOM_RT_TC_128");

		ReportLog.setTestCase("CUSTOM_RT_TC_129");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPCustomPage.contents.ModalCloseButton.click();
        Thread.sleep(2000);
		VIPCustomPage.contents.UserEIDHeader.verifyDisplayed(true, 1);
		VIPLandingPage.contents.OverviewButton.hover();
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
		VIPCustomPage.contents.AnalystCommentMenu.click();
		Thread.sleep(5000);
		VIPCustomPage.contents.AnalystCommentBox1.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox2.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox3.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox4.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox5.verifyText("test ");
		VIPCustomPage.contents.AnalystCommentBox6.verifyText("test ");
		WebControl.takeScreenshot("CUSTOM_RT_TC_129");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String AnalystCommentTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String AnalystCommentFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((AnalystCommentTagline.equals("Analyst Commentary")) & (AnalystCommentFootnote.equals("Source: Analyst Reports; Accenture Client Value services."))) {
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
			VIPCustomPage.contents.FootnoteCount.verifyText("788 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Commentary_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Analyst Reports; Accenture Client Value services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Analyst Commentary_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Analyst Reports; Accenture Client Value services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("257 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("788 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Commentary_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Analyst Reports; Accenture Client Value services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Commentary_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Analyst Reports; Accenture Client Value services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=13)
	public void Financials_RaPE () throws Exception {
		ReportLog.setTestName("CUSTOM - Revenue and Profitability Estimates");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Revenue and Profitability Estimates Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_130");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		VIPCustomPage.contents.RaPESITitle.verifyText("Select Indicator");
		VIPCustomPage.contents.RaPESIButton.verifyText("Revenue Growth Estimates");
		VIPCustomPage.contents.RaPEChart1Title.verifyText("REVENUE YOY GROWTH ESTIMATES");
		VIPCustomPage.contents.RaPEChart2Title.verifyText("REVENUE CAGR");
		VIPCustomPage.contents.RaPEChart1LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart1LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPERevGrowth.verifyText("Revenue Growth Estimates");
		VIPCustomPage.contents.RaPEEBITMargin.verifyText("EBIT Margin Estimates");
		VIPCustomPage.contents.RaPEEBITDAMargin.verifyText("EBITDA Margin Estimates");
		VIPCustomPage.contents.RaPEEBITMargin.click();
		VIPCustomPage.contents.RaPEChart1Title.verifyText("EBIT MARGIN ESTIMATES");
		VIPCustomPage.contents.RaPEChart2Title.verifyText("CHANGE IN EBIT MARGIN (pps)");
		VIPCustomPage.contents.RaPEChart1LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart1LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITDAMargin.click();
		VIPCustomPage.contents.RaPEChart1Title.verifyText("EBITDA MARGIN ESTIMATES");
		VIPCustomPage.contents.RaPEChart2Title.verifyText("CHANGE IN EBITDA MARGIN (pps)");
		VIPCustomPage.contents.RaPEChart1LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart1LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendTarget.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2LegendPeer.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_130");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_131");
		Thread.sleep(2000);
		//VIPCustomPage.contents.RaPESIButton.click();
		//VIPCustomPage.contents.RaPERevGrowth.click();
		VIPCustomPage.contents.RaPEChart1InfoIcon.hover();
		VIPCustomPage.contents.RaPETooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPETooltipText.verifyText(testDataHandler.RGCAGRTooltip);
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITMargin.click();
		VIPCustomPage.contents.RaPEChart1InfoIcon.hover();
		VIPCustomPage.contents.RaPETooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPETooltipText.verifyText(testDataHandler.EBITMDTooltip);
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITDAMargin.click();
		VIPCustomPage.contents.RaPEChart1InfoIcon.hover();
		VIPCustomPage.contents.RaPETooltip.verifyText("Click here to view definitions");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		Thread.sleep(2000);
		//VIPCustomPage.contents.RaPETooltipText.verifyText(testDataHandler.RaPETooltip);
		VIPCustomPage.contents.RaPETooltipText.verifyText("EBITDA margin is a measure of a company's operating profit from core operations, calculated as its earnings before interest, taxes, depreciation, and amortization as a percentage of revenues. EBITDA Margin Estimates are based on the average analyst consensus EBITDA margin forecast for a given period.");
		VIPCustomPage.contents.RaPEChart1InfoIcon.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_131");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_132");
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPERevGrowth.click();
		VIPCustomPage.contents.RaPEChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITMargin.click();
		VIPCustomPage.contents.RaPEChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPESIButton.click();
		VIPCustomPage.contents.RaPEEBITDAMargin.click();
		VIPCustomPage.contents.RaPEChart1TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RaPEChart2TP.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.RaPEMenu.click();
		WebControl.takeScreenshot("CUSTOM_RT_TC_132");
		
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String RaPETagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RaPEFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RaPETagline.equals("Analyst Estimates")) & (RaPEFootnote.equals("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("258 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("645 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Estimates_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Analyst Estimates_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("258 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("645 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Estimates_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Analyst Estimates_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: All estimates are taken from Bloomberg consensus as on the day of report generation for the next 3 fiscal years. Source: Bloomberg; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=14)
	public void CUSTOM_RGvsAS () throws Exception {
		ReportLog.setTestName("CUSTOM - Revenue Growth vs Average Spread");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

    	/* Revenue Growth vs. Average Spread dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_136");
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
	
	
	@Test(priority=15)
	public void CUSTOM_RevGrowthEmpProd () throws Exception {
		ReportLog.setTestName("CUSTOM - Revenue Growth and Employee Productivity");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* RevenueGrowthdashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_148");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//NavigatetoRevenueGrowthdashboard
		VIPCustomPage.contents.RevGrowthMenu.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPCustomPage.contents.RG5YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RG5YrRevCAGRHeader.verifyText("5 year Revenue CAGR");
		VIPCustomPage.contents.RG3YrRevCAGRHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RG3YrRevCAGRHeader.verifyText("3 year Revenue CAGR");
		VIPCustomPage.contents.RG1YrRevGrowthHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RG1YrRevGrowthHeader.verifyText("1 year Revenue Growth");
		WebControl.takeScreenshot("CUSTOM_RT_TC_148");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String RGTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RGFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RGTagline.equals("Revenue Growth")) & (RGFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("261 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Revenue Growth_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Revenue Growth_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("261 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Revenue Growth_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Revenue Growth_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		
		
		/* EmployeeProductivitydashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_153");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//NavigatetoEmployeeProductivitydashboard
		VIPCustomPage.contents.EmpProdMenu.click();
		VIPCustomPage.contents.EmpProdSIDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.EmpProdIndDefaultKPI.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EmpProdIndDefaultKPI.verifyText("Revenue per Employee");
		VIPCustomPage.contents.EmpProdSIDropdown.click();
		VIPCustomPage.contents.IndRPEMenu.verifyText("Revenue per Employee");
		VIPCustomPage.contents.IndRPEMenu.click();
		VIPCustomPage.contents.EmpProdChartHeader.verifyText("REVENUE PER EMPLOYEE");
		VIPCustomPage.contents.EmpProdSIDropdown.click();
		VIPCustomPage.contents.IndAOEMenu.verifyText("Average # of Employees");
		VIPCustomPage.contents.IndAOEMenu.click();
		VIPCustomPage.contents.EmpProdChartHeader.verifyText("AVERAGE # OF EMPLOYEES");
		VIPCustomPage.contents.EmpProdSIDropdown.click();
		VIPCustomPage.contents.IndEPEMenu.verifyText("EBIT per Employee");
		VIPCustomPage.contents.IndEPEMenu.click();
		VIPCustomPage.contents.EmpProdChartHeader.verifyText("EBIT PER EMPLOYEE");
		WebControl.takeScreenshot("CUSTOM_RT_TC_153");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String EmpProdTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String EmpProdFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((EmpProdTagline.equals("Revenue and EBIT per Employee")) & (EmpProdFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("246 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Revenue and EBIT per Employee_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Revenue and EBIT per Employee_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("246 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Revenue and EBIT per Employee_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Revenue and EBIT per Employee_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	
	}
	
	
	@Test(priority=16)
	public void CUSTOM_PreTaxROICDrivers () throws Exception {
		ReportLog.setTestName("CUSTOM - Pre-Tax ROIC Drivers - Op.Margin vs. Cap. Eff.");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Pre-Tax ROIC Drivers - Op.Margin vs. Cap. Eff. Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_157");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Pre-Tax ROIC Drivers - Op.Margin vs. Cap. Eff. Dashboard
		VIPCustomPage.contents.PreTaxROICDriversMenu.click();
        VIPCustomPage.contents.ROICBarChart.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OpMagrinBarChart.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CapEffBarChart.verifyDisplayed(true, 5);
        VIPCustomPage.contents.ROICDriversChartTitle.verifyText("CHANGE IN PRE-TAX ROIC");
        VIPCustomPage.contents.OpMarginChartTitle.verifyText("CHANGE IN OPERATING MARGIN");
        VIPCustomPage.contents.CapEffChartTitle.verifyText("CHANGE IN CAPITAL EFFICIENCY");
        WebControl.takeScreenshot("Custom_Reg_Auto_157");
        
        ReportLog.setTestCase("CUSTOM_Reg_Auto_161");
        VIPCustomPage.contents.ROICInfoIcon.verifyDisplayed(true, 5);
        VIPCustomPage.contents.ROICInfoIcon.hover();
        VIPCustomPage.contents.ROICInfoIconTootltip.verifyText("Click here to view definitions");
        VIPCustomPage.contents.ROICInfoIcon.click();
        VIPCustomPage.contents.ROICInfoIconText.verifyText("Pre-tax ROIC represents a company's efficiency in generating profits from its core operations. It is calculated by dividing a company's Earnings Before Interest and Taxes (EBIT) by the average Invested Capital.");
		VIPCustomPage.contents.ROICInfoIcon.click();
		WebControl.takeScreenshot("Custom_Reg_Auto_161");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String ROICDriversTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String ROICDriversFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((ROICDriversTagline.equals("Scatter: ROIC Drivers")) & (ROICDriversFootnote.equals("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. "))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("254 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("667 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: ROIC Drivers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Scatter: ROIC Drivers_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("254 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("667 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: ROIC Drivers_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Scatter: ROIC Drivers_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Invested Capital (IC) = Op. Working Capital + Net PPE + Other Op. Assets + Goodwill; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services. _test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
	
	
	@Test(priority=17)
	public void CUSTOM_PreTaxROICDecomp () throws Exception {
		ReportLog.setTestName("CUSTOM - Pre-Tax ROIC Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Pre-Tax ROIC Decomposition Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_163");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Pre-Tax ROIC Decomposition Dashboard
		VIPCustomPage.contents.PreTaxROICDecompMenu.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
        VIPCustomPage.contents.LeftHandChartHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.LeftHandChartHeader.verifyText("RETURN ON INVESTED CAPITAL (ROIC) DECOMPOSITION");
		VIPCustomPage.contents.LeftHandChartNote.verifyDisplayed(true, 5);
		VIPCustomPage.contents.LeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPCustomPage.contents.RightHandChartHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.RightHandChartHeader.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
        VIPCustomPage.contents.PreTaxROICBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EBITMARGINBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CAPITALEFFICIENCYBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.EBITDAMarginBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.DARevenueBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WorkingCapitalRevenueBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NetPPERevenueBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.GoodwillIntangiblesRevenueBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NetOtherAssetsRevenueBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.COGSRevenueBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SGARevenueBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.MultiplySymbol.verifyDisplayed(true, 5);
        VIPCustomPage.contents.MinusSymbol.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CapEffText.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CapEffText.verifyText("1/sum of");
        VIPCustomPage.contents.ROICBetterLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICBetterLegendText.verifyText("Better than peer median");
		VIPCustomPage.contents.ROICWorseLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICWorseLegendText.verifyText("Worse than peer median");
		VIPCustomPage.contents.ROICInlineLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICInlineLegendText.verifyText("In-line with peer median");
        WebControl.takeScreenshot("Custom_Reg_Auto_163");
        
        ReportLog.setTestCase("CUSTOM_Reg_Auto_166");
		VIPCustomPage.contents.EBITMARGINiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.EBITMARGINiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.EBITMTooltip);
		VIPCustomPage.contents.EBITMARGINiIcon.click();
		VIPCustomPage.contents.CAPITALEFFICIENCYiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.CAPITALEFFICIENCYiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.CAPEFFTooltip);
		VIPCustomPage.contents.CAPITALEFFICIENCYiIcon.click();
		VIPCustomPage.contents.EBITDAMarginiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.EBITDAMarginiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.EBITDATooltip);
		VIPCustomPage.contents.EBITDAMarginiIcon.click();
		VIPCustomPage.contents.DARevenueiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.DARevenueiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.DATooltip);
		VIPCustomPage.contents.DARevenueiIcon.click();
		VIPCustomPage.contents.WorkingCapitalRevenueiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.WorkingCapitalRevenueiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.WCRTooltip);
		VIPCustomPage.contents.WorkingCapitalRevenueiIcon.click();
		VIPCustomPage.contents.NetPPERevenueiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.NetPPERevenueiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.NPPETooltip);
		VIPCustomPage.contents.NetPPERevenueiIcon.click();
		VIPCustomPage.contents.GoodwillIntangiblesRevenueiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.GoodwillIntangiblesRevenueiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.GITooltip);
		VIPCustomPage.contents.GoodwillIntangiblesRevenueiIcon.click();
		VIPCustomPage.contents.COGSRevenueiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.COGSRevenueiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.COGSTooltip);
		VIPCustomPage.contents.COGSRevenueiIcon.click();
		VIPCustomPage.contents.SGARevenueiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.SGARevenueiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.SGATooltip);
		VIPCustomPage.contents.SGARevenueiIcon.click();
		VIPCustomPage.contents.ROICiIcon.hover();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.ROICiIcon.click();
		VIPCustomPage.contents.PreTaxROICDecompTooltipText.verifyText(testDataHandler.ROICTooltip);
		VIPCustomPage.contents.ROICiIcon.click();
        WebControl.takeScreenshot("Custom_Reg_Auto_166");

        ReportLog.setTestCase("Q2A_Reg_Auto_167");
		VIPCustomPage.contents.EBITMARGINBox.hover();
		VIPCustomPage.contents.EBITMARGINBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("EBIT MARGIN");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.CAPITALEFFICIENCYBox.hover();
		VIPCustomPage.contents.CAPITALEFFICIENCYBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("CAPITAL EFFICIENCY");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.EBITDAMarginBox.hover();
		VIPCustomPage.contents.EBITDAMarginBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("EBITDA MARGIN");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.DARevenueBox.hover();
		VIPCustomPage.contents.DARevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("D&A / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.WorkingCapitalRevenueBox.hover();
		VIPCustomPage.contents.WorkingCapitalRevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.NetPPERevenueBox.hover();
		VIPCustomPage.contents.NetPPERevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("NET PPE / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.GoodwillIntangiblesRevenueBox.hover();
		VIPCustomPage.contents.GoodwillIntangiblesRevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("GOODWILL & INTANGIBLES / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.NetOtherAssetsRevenueBox.hover();
		VIPCustomPage.contents.NetOtherAssetsRevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("NET OTHER ASSETS / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.COGSRevenueBox.hover();
		VIPCustomPage.contents.COGSRevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("COGS / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.SGARevenueBox.hover();
		VIPCustomPage.contents.SGARevenueBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("SG&A / REVENUE");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		VIPCustomPage.contents.PreTaxROICBox.hover();
		VIPCustomPage.contents.PreTaxROICBox.click();
        VIPCustomPage.contents.RightHandChartHeader.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
        VIPCustomPage.contents.ROICTargetCompLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.ROICPeerMedianLegendText.verifyText("Peer Median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_167");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_169");
		VIPCustomPage.contents.PreTaxROICDecompToggleButton.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompToggleLabel.verifyText("Detailed Peer Comparison");
		VIPCustomPage.contents.PreTaxROICDecompToggleButton.click();
		VIPCustomPage.contents.PreTaxROICDecompFirstPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompSecondPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompThirdPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompFirstPeriodChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompSecondPeriodChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompThirdPeriodChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_169");

		ReportLog.setTestCase("Q2A_Reg_Auto_170");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndPreTaxROICMMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndEBITMarginMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndEBITDAMarginMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndCOGSRevenueMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndSGARevenueMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndDARevenueMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndCapitlEfficiencyMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndWorkingCapitalMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndNetPPERevenueMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndGWIntanRevMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndNetOtherAssRevMenu.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndEBITMarginMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("EBIT MARGIN");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndEBITDAMarginMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("EBITDA MARGIN");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndCOGSRevenueMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("COGS / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndSGARevenueMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("SG&A / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndDARevenueMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("D&A / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndCapitlEfficiencyMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("CAPITAL EFFICIENCY");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndWorkingCapitalMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndNetPPERevenueMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("NET PPE / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndGWIntanRevMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("GOODWILL & INTANGIBLES / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndNetOtherAssRevMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("NET OTHER ASSETS / REVENUE");
		VIPCustomPage.contents.PreTaxROICDecompSIDropdown.click();
		VIPCustomPage.contents.IndPreTaxROICMMenu.click();
		VIPCustomPage.contents.PreTaxROICDecompDetailedChartHeader.verifyText("PRE-TAX RETURN ON INVESTED CAPITAL");
		WebControl.takeScreenshot("Q2A_Reg_Auto_170");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String PreTaxROICDecompTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String PreTaxROICDecompFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((PreTaxROICDecompTagline.equals("ROIC Decomposition")) & (PreTaxROICDecompFootnote.equals("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("ROIC Decomposition_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("ROIC Decomposition_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("257 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("ROIC Decomposition_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("ROIC Decomposition_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
	}
	
	
	
    @Test(priority=18)
	public void CUSTOM_OWCDecomp () throws Exception {
		ReportLog.setTestName("CUSTOM - Operating Working Capital Decomposition");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Operating Working Capital Decomposition Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_173");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Operating Working Capital Decomposition Dashboard
		VIPCustomPage.contents.OWCMenu.click();
		VIPCustomPage.contents.LeftHandChartHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.LeftHandChartHeader.verifyText("OPERATING WORKING CAPITAL DECOMPOSITION");
		VIPCustomPage.contents.LeftHandChartNote.verifyDisplayed(true, 5);
        VIPCustomPage.contents.LeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
        VIPCustomPage.contents.WorkCapRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OpeCurAssRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NonIntBearLiabRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CashRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NetRecRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.InventoryRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OtherCurAssRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.AccPayRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IncTaxPayRevBox.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OtherCurLiaRevBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OpeCurAssRevBox.hover();
		VIPCustomPage.contents.OpeCurAssRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPCustomPage.contents.NonIntBearLiabRevBox.hover();
		VIPCustomPage.contents.NonIntBearLiabRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPCustomPage.contents.CashRevBox.hover();
		VIPCustomPage.contents.CashRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("CASH / REVENUE");
		VIPCustomPage.contents.NetRecRevBox.hover();
		VIPCustomPage.contents.NetRecRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPCustomPage.contents.InventoryRevBox.hover();
		VIPCustomPage.contents.InventoryRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("INVENTORY / REVENUE");
		VIPCustomPage.contents.OtherCurAssRevBox.hover();
		VIPCustomPage.contents.OtherCurAssRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPCustomPage.contents.AccPayRevBox.hover();
		VIPCustomPage.contents.AccPayRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPCustomPage.contents.IncTaxPayRevBox.hover();
		VIPCustomPage.contents.IncTaxPayRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		VIPCustomPage.contents.OtherCurLiaRevBox.hover();
		VIPCustomPage.contents.OtherCurLiaRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		VIPCustomPage.contents.WorkCapRevBox.hover();
		VIPCustomPage.contents.WorkCapRevBox.click();
		VIPCustomPage.contents.RightHandChartHeader.verifyText("WORKING CAPITAL / REVENUE");
        WebControl.takeScreenshot("Custom_Reg_Auto_173");
        

        ReportLog.setTestCase("Q2A_Reg_Auto_174");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.WorkCapReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.WorkCapReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.WCRTooltip);
		VIPCustomPage.contents.WorkCapReviIcon.click();
		VIPCustomPage.contents.CashReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.CashReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.CRTooltip);
		VIPCustomPage.contents.CashReviIcon.click();
		VIPCustomPage.contents.NetRecReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.NetRecReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.NRTooltip);
		VIPCustomPage.contents.NetRecReviIcon.click();
		VIPCustomPage.contents.InventoryReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.InventoryReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.IRTooltip);
		VIPCustomPage.contents.InventoryReviIcon.click();
		VIPCustomPage.contents.AccPayReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.AccPayReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.APRTooltip);
		VIPCustomPage.contents.AccPayReviIcon.click();
		VIPCustomPage.contents.IncTaxPayReviIcon.hover();
		VIPCustomPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPCustomPage.contents.IncTaxPayReviIcon.click();
		VIPCustomPage.contents.TooltipText.verifyText(testDataHandler.ITPRTooltip);
		VIPCustomPage.contents.IncTaxPayReviIcon.click();
        WebControl.takeScreenshot("Q2A_Reg_Auto_174");
		
		ReportLog.setTestCase("Q2A_Reg_Auto_175");
		VIPCustomPage.contents.WCRBetterLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCRBetterLegendText.verifyText("Better than peer median");
		VIPCustomPage.contents.WCRWorseLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCRWorseLegendText.verifyText("Worse than peer median");
		VIPCustomPage.contents.WCRInlineLegend.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCRInlineLegendText.verifyText("In-line with peer median");
		WebControl.takeScreenshot("Q2A_Reg_Auto_175");

        ReportLog.setTestCase("Q2A_Reg_Auto_176");
		VIPCustomPage.contents.OWCPeerComparisonToggle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OWCPeerComparisonToggleLabel.verifyText("Detailed Peer Comparison");
        VIPCustomPage.contents.OWCPeerComparisonToggle.click();
		VIPCustomPage.contents.OWCFirstPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCSecondPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCThirdPeriodHeader.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCFirstPeriodChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCSecondPeriodChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCThirdPeriodChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Q2A_Reg_Auto_176");

        ReportLog.setTestCase("Q2A_Reg_Auto_177");
		VIPCustomPage.contents.OWCSIDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndWorkCapRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndOpeCurAssRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndCashRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndNetRecRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndInventoryRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndOtherCurAssRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndNonIntBearLiabRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndAccPayRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndIncTaxPayRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndOtherCurLiaRev.verifyDisplayed(true, 5);
		VIPCustomPage.contents.IndWorkCapRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("WORKING CAPITAL / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndOpeCurAssRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("OPERATING CURRENT ASSETS / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndCashRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("CASH / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndNetRecRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("NET RECEIVABLES / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndInventoryRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("INVENTORY / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndOtherCurAssRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("OTHER CUR. ASSETS / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndNonIntBearLiabRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("NON-INTEREST BEARING LIABILITIES / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndAccPayRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("ACCOUNTS PAYABLE / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndIncTaxPayRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("INCOME TAX PAYABLE / REVENUE");
		VIPCustomPage.contents.OWCSIDropdown.click();
		VIPCustomPage.contents.IndOtherCurLiaRev.click();
		VIPCustomPage.contents.OWCDetailedChartHeader.verifyText("OTHER CURRENT LIABILITIES / REVENUE");
		WebControl.takeScreenshot("Q2A_Reg_Auto_177");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String OWCTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String OWCFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((OWCTagline.equals("Working Capital Tree")) & (OWCFootnote.equals("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Working Capital Tree_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Working Capital Tree_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("255 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Working Capital Tree_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Working Capital Tree_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
        
	}
    
    
    @Test(priority=19)
	public void CUSTOM_CashCycleAnalysis () throws Exception {
		ReportLog.setTestName("CUSTOM - Cash Cycle Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Cash Cycle Analysis Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_180");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Cash Cycle Analysis Dashboard
		VIPFinancialsPage.contents.CashCycleAnalysisMenu.click();
		VIPCustomPage.contents.ChartTimePeriod.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CCALeftHandChartNote.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CCALeftHandChartNote.verifyText("Click on the KPI box to view peer comparison");
		VIPFinancialsPage.contents.CCARightHandChart.verifyDisplayed(true, 5);
        VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Cash Cycle Days");
        VIPFinancialsPage.contents.CashCycleChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashCycleChartHeader.verifyText("Cash Cycle");
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysSalesOutstandingChartHeader.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.InventoryDaysChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryDaysChartHeader.verifyText("Inventory Days");
		VIPFinancialsPage.contents.DaysPayableChart.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysPayableChartHeader.verifyText("Days Payable");
        WebControl.takeScreenshot("Custom_Reg_Auto_180");
        

        ReportLog.setTestCase("Custom_Reg_Auto_181");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPFinancialsPage.contents.CashCycleChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.CashCycleChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FCCDTooltip);
		VIPFinancialsPage.contents.CashCycleChartTooltip.click();
		VIPFinancialsPage.contents.InventoryDaysChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.InventoryDaysChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FDIOTooltip);
		VIPFinancialsPage.contents.InventoryDaysChartTooltip.click();
		VIPFinancialsPage.contents.DaysSalesOutstandingChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.DaysSalesOutstandingChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FDSOTooltip);
		VIPFinancialsPage.contents.DaysSalesOutstandingChartTooltip.click();
		VIPFinancialsPage.contents.DaysPayableChartTooltip.hover();
		VIPFinancialsPage.contents.TooltipText.verifyText("Click here to view definitions");
		VIPFinancialsPage.contents.DaysPayableChartTooltip.click();
		VIPFinancialsPage.contents.TooltipText.verifyText(testDataHandler.FDPOTooltip);
		VIPFinancialsPage.contents.DaysPayableChartTooltip.click();
        WebControl.takeScreenshot("Custom_Reg_Auto_181");
        

        ReportLog.setTestCase("Custom_Reg_Auto_183");
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.hover();
		VIPFinancialsPage.contents.DaysSalesOutstandingChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Days Sales Outstanding");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.InventoryDaysChart.hover();
		VIPFinancialsPage.contents.InventoryDaysChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Inventory Days");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.DaysPayableChart.hover();
		VIPFinancialsPage.contents.DaysPayableChart.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Days Payable");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CashCycleChart2.hover();
		VIPFinancialsPage.contents.CashCycleChart2.click();
		VIPFinancialsPage.contents.RightHandChartTimePeriod.verifyDisplayed(true, 5);
		VIPFinancialsPage.contents.CCARightHandChartHeader.verifyText("Cash Cycle Days");
		VIPFinancialsPage.contents.RightHandChartPeerMedian.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_183");
        
		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String CCATagline = VIPCustomPage.contents.DefaultTagline.getText();
		String CCAFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((CCATagline.equals("Cash Cycle")) & (CCAFootnote.equals("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("265 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Cash Cycle_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Cash Cycle_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("265 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("713 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Cash Cycle_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Cash Cycle_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Note: Numbers may not add up due to rounding; Source: S&P Capital IQ; Annual and Quarterly reports; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
    
    
    
    @Test(priority=20)
	public void CUSTOM_SegmentAnalysis () throws Exception {
		ReportLog.setTestName("CUSTOM - Segment Analysis");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Business Segment Analysis Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_185");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Business Segment Analysis Dashboard
		VIPCustomPage.contents.BSAMenu.click();
		VIPCustomPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SegmentDropdownText.verifyText("All Segments");
        WebControl.takeScreenshot("Custom_Reg_Auto_185");
        
        ReportLog.setTestCase("Custom_Reg_Auto_186");
		VIPCustomPage.contents.SALeftHandChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SARighttHandChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_186");

		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String BusinessTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String BusinessFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((BusinessTagline.equals("Segment Analysis")) & (BusinessFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("259 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Segment Analysis_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Segment Analysis_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("259 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Segment Analysis_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Segment Analysis_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");


		/* Geographic Segment Analysis Dashboard
		 * Author: alyssa.kay.n.mababa*/

		//Navigate to Geographic Segment Analysis Dashboard
		ReportLog.setTestCase("Custom_Reg_Auto_200");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		VIPCustomPage.contents.GSAMenu.click();
		VIPCustomPage.contents.SegmentDropdown.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SegmentDropdownText.verifyText("All Segments");
        WebControl.takeScreenshot("Custom_Reg_Auto_199");
        
        ReportLog.setTestCase("Custom_Reg_Auto_200");
		VIPCustomPage.contents.SALeftHandChart.verifyDisplayed(true, 5);
		VIPCustomPage.contents.SARighttHandChart.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("Custom_Reg_Auto_200"); 

		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String GeoTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String GeoFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((GeoTagline.equals("Geographic Analysis")) & (GeoFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Geographic Analysis_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Geographic Analysis_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("256 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Geographic Analysis_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Geographic Analysis_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

	}
    
    
    @Test(priority=21)
	public void CUSTOM_Glossary () throws Exception {
		ReportLog.setTestName("CUSTOM - Glossary");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Glossary Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_213");
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
	
    
    @Test(priority=22)
	public void CUSTOM_Methodology () throws Exception {
		ReportLog.setTestName("CUSTOM - Methodology");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Methodology Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_217");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Methodology Dashboard
		VIPCustomPage.contents.MethodologyMenu.click();
        VIPCustomPage.contents.MethodologyText.verifyDisplayed(true, 5);
        VIPCustomPage.contents.MethodologyText.verifyText("Analysis is based on Accenture’s Shareholder Value Analysis framework. Value is created by earning an economic return on invested capital and magnifying positive spread by profitably growing revenues");
        WebControl.takeScreenshot("Custom_Reg_Auto_217");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_218");
        Thread.sleep(5000);
        VIPCustomPage.contents.TRSBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.TRSBox.verifyText("Total Return to Shareholders (TRS)");
        VIPCustomPage.contents.TRSICon.verifyDisplayed(true, 5);
        VIPCustomPage.contents.DiscountedCashFlowBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.DiscountedCashFlowBox.verifyText("Value of the discounted cash flow to shareholders");
        VIPCustomPage.contents.DiscountedCashFlowIcon.verifyDisplayed(true, 5);
        VIPCustomPage.contents.SpreadBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.SpreadBox.verifyText("Spread");
        VIPCustomPage.contents.GrowthBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.GrowthBox.verifyText("Growth");
        VIPCustomPage.contents.ROICBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.ROICBox.verifyText("ROIC");
        VIPCustomPage.contents.CostofCapitalBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CostofCapitalBox.verifyText("Cost of Capital");
        VIPCustomPage.contents.OrganicBox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.OrganicBox.verifyText("Organic");
        VIPCustomPage.contents.MABox.verifyDisplayed(true, 5);
        VIPCustomPage.contents.MABox.verifyText("M&A");
        WebControl.takeScreenshot("Custom_Reg_Auto_218");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_219");
        VIPCustomPage.contents.Text1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Text1.verifyText("Increasing spread, the difference between ROIC and WACC, creates value");
        VIPCustomPage.contents.Text2.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Text2.verifyText("Magnifying positive spread by growing revenue creates value");
        VIPCustomPage.contents.Text3.verifyDisplayed(true, 5);
        VIPCustomPage.contents.Text3.verifyText("All values in target’s currency");
        WebControl.takeScreenshot("Custom_Reg_Auto_219");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_220");
        VIPCustomPage.contents.MinusCircle.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_Reg_Auto_220");

        //Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String MethodologyTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String MethodologyFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((MethodologyTagline.equals("Methodology")) & (MethodologyFootnote.equals("Source: Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("264 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("805 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Methodology_test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Methodology_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("264 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("805 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Methodology_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Methodology_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
    }
    
    
    @Test(priority=23)
	public void CUSTOM_ReferenceCalculations () throws Exception {
		ReportLog.setTestName("CUSTOM - Reference Calculations");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

        /* Reference Calculations Dashboard
		 * Author: alyssa.kay.n.mababa*/
		
		ReportLog.setTestCase("CUSTOM_Reg_Auto_221");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboardDropdown.waitForExist(true, 10);
		VIPCustomPage.contents.SelectDashboardDropdown.click();
		//Navigate to Reference Calculations Dashboard
        VIPCustomPage.contents.ReferenceCalculationsMenu.click();
        VIPCustomPage.contents.SelectCompany.verifyDisplayed(true, 5);
        WebControl.takeScreenshot("Custom_Reg_Auto_221");

        ReportLog.setTestCase("CUSTOM_Reg_Auto_222");
        VIPCustomPage.contents.SelectCurrency.verifyDisplayed(true, 5);
        VIPCustomPage.contents.SelectCurrencyDefault.verifyText("Target company currency");
        VIPCustomPage.contents.SelectCurrency.click();
        VIPCustomPage.contents.TargetCurrency.verifyText("Target company currency");
        VIPCustomPage.contents.LocalCurrency.verifyText("Local currency");
		VIPCustomPage.contents.SelectCurrency.click();
        WebControl.takeScreenshot("Custom_Reg_Auto_222");

		//NOPAT Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_223");
		//Column Headers
        VIPCustomPage.contents.NOPATCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCalcTitle.verifyText("NOPAT Calculations");
		VIPCustomPage.contents.NOPATCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCol1.verifyText("Key Income Statement Items");
		VIPCustomPage.contents.NOPATYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATTTM.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATCAGR.verifyDisplayed(true, 5);
		VIPCustomPage.contents.NOPATCAGR.verifyText("CAGR");
		//KPIs
		VIPCustomPage.contents.NOPATCurrencyRow.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCurrencyRow.verifyText("Currency");
		VIPCustomPage.contents.NOPATRevenue.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATRevenue.verifyText("Revenue");
		VIPCustomPage.contents.NOPATCOGS.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATCOGS.verifyText("(-) Cost of Goods Sold");
		VIPCustomPage.contents.NOPATSGA.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATSGA.verifyText("(-) Selling, General and Admin Expenses");
		VIPCustomPage.contents.NOPATAdjEBIDTA.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATAdjEBIDTA.verifyText("= Adjusted EBITDA");
		VIPCustomPage.contents.NOPATDA.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATDA.verifyText("(-) Depreciation & Amortization");
		VIPCustomPage.contents.NOPATAdjEBIT.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATAdjEBIT.verifyText("= Adjusted EBIT");
		VIPCustomPage.contents.NOPATMarginalTaxes.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATMarginalTaxes.verifyText("(-) Marginal Taxes");
		VIPCustomPage.contents.NOPATKPI.verifyDisplayed(true, 5);
        VIPCustomPage.contents.NOPATKPI.verifyText("= NOPAT");
        WebControl.takeScreenshot("Custom_Reg_Auto_223");

		//Working Capital Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_224");
		//Column Headers
        VIPCustomPage.contents.WCCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCalcTitle.verifyText("Working Capital Calculations");
		VIPCustomPage.contents.WCCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCol1.verifyText("Key Balance Sheet Items");
		VIPCustomPage.contents.WCYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCTTM.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCCAGR.verifyDisplayed(true, 5);
		VIPCustomPage.contents.WCCAGR.verifyText("CAGR");
		//KPIs
		VIPCustomPage.contents.WCCurrencyRow.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCurrencyRow.verifyText("Currency");
		VIPCustomPage.contents.WCCash.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCash.verifyText("Cash");
		VIPCustomPage.contents.WCNetReceivables.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNetReceivables.verifyText("(+) Net Receivables");
		VIPCustomPage.contents.WCInventory.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCInventory.verifyText("(+) Inventory");
		VIPCustomPage.contents.WCOtherCurrAssets.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCOtherCurrAssets.verifyText("(+) Other Current Assets");
		VIPCustomPage.contents.WCOpCurrAssets.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCOpCurrAssets.verifyText("= Operating Current Assets (A)");
		VIPCustomPage.contents.WCAccPayable.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCAccPayable.verifyText("Accounts Payable");
		VIPCustomPage.contents.WCIncTaxPayable.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCIncTaxPayable.verifyText("(+) Income Tax Payable");
		VIPCustomPage.contents.WCOtherCurrLiab.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCOtherCurrLiab.verifyText("(+) Other Current Liabilities");
		VIPCustomPage.contents.WCNonIntBearLiab.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNonIntBearLiab.verifyText("= Non-Interest-Bearing Liabilities (B)");
		VIPCustomPage.contents.WCWorkingCapital.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCWorkingCapital.verifyText("= Working Capital (A - B)");
		VIPCustomPage.contents.WCNetPPE.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNetPPE.verifyText("(+) Net PPE");
		VIPCustomPage.contents.WCCapValOpLease.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCCapValOpLease.verifyText("(+) Capitalized Value of Operating Lease");
		VIPCustomPage.contents.WCUnfundedRetLiab.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCUnfundedRetLiab.verifyText("(+) Unfunded Retirement Liabilities");
		VIPCustomPage.contents.WCGoodwillIntagibles.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCGoodwillIntagibles.verifyText("(+) Goodwill & Intangibles");
		VIPCustomPage.contents.WCNetOtherOpAssets.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCNetOtherOpAssets.verifyText("(+) Net Other Operating Assets");
		VIPCustomPage.contents.WCInvCapital.verifyDisplayed(true, 5);
        VIPCustomPage.contents.WCInvCapital.verifyText("= Invested Capital");
        WebControl.takeScreenshot("Custom_Reg_Auto_224");

		//Current and Future Value Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_225");
		//Column Headers
        VIPCustomPage.contents.CurrentFutureValueCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValueCalcTitle.verifyText("Current and Future Value Calculations");
		VIPCustomPage.contents.CurrentFutureValeCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValeCol1.verifyText("Key Capital Markets Data");
		VIPCustomPage.contents.CurrentFutureYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureTTM.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureCurrentYear.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureCAGR.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CurrentFutureCAGR.verifyText("CAGR");
		//KPIs
		VIPCustomPage.contents.CurrentFutureCurrencyRow.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureCurrencyRow.verifyText("Currency");
		VIPCustomPage.contents.CurrentFutureNOPAT.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureNOPAT.verifyText("NOPAT (A)");
		VIPCustomPage.contents.CurrentFutureOpEntVal.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureOpEntVal.verifyText("Operating Enterprise Value (B)");
		VIPCustomPage.contents.CurrentFutureNetDebt.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureNetDebt.verifyText("Net Debt (C)");
		VIPCustomPage.contents.CurrentFutureWACC.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureWACC.verifyText("WACC (D)");
		VIPCustomPage.contents.CurrentFutureValCurrOp.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValCurrOp.verifyText("Value of Current Operations (E = A / D)");
		VIPCustomPage.contents.CurrentFutureCurrValWeight.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureCurrValWeight.verifyText("Current Value weight (F = E / B)");
		VIPCustomPage.contents.CurrentFutureValFutureOp.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureValFutureOp.verifyText("Value of Future Operations (G = B - E)");
		VIPCustomPage.contents.CurrentFutureFutureValWeight.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CurrentFutureFutureValWeight.verifyText("Future Value weight (H = G / B)");
        WebControl.takeScreenshot("Custom_Reg_Auto_225");

		//Cash Cycle Calculations
		ReportLog.setTestCase("CUSTOM_Reg_Auto_226");
		//Column Headers
        VIPCustomPage.contents.CashCycleCalcTitle.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleCalcTitle.verifyText("Cash Cycle Calculations");
		VIPCustomPage.contents.CashCycleCol1.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleCol1.verifyText("Key Cash Cycle Data");
		VIPCustomPage.contents.CashCycleYear1.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CashCycleYear2.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CashCycleTTM.verifyDisplayed(true, 5);
		//KPIs
		VIPCustomPage.contents.CashCycleDSO.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleDSO.verifyText("Days Sales Outstanding");
		VIPCustomPage.contents.CashCycleDIO.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleDIO.verifyText("(+) Days Inventory Outstanding");
		VIPCustomPage.contents.CashCycleDPO.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleDPO.verifyText("(-) Days Payables Outstanding");
		VIPCustomPage.contents.CashCycleKPI.verifyDisplayed(true, 5);
        VIPCustomPage.contents.CashCycleKPI.verifyText("= Cash Cycle");
        WebControl.takeScreenshot("CUSTOM_Reg_Auto_226");

		//Tagline and Footnote - Added 2/10/2021 by alyssa.kay.n.mababa
		//Tagline and Footnote - Updated 2/25/2021 by charisma.l.desipeda
		ReportLog.setTestCase("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");
		VIPLandingPage.contents.HelpIcon.hover();
		Thread.sleep(1000);
		String RefCalcTagline = VIPCustomPage.contents.DefaultTagline.getText();
		String RefCalcFootnote = VIPCustomPage.contents.DefaultFootnote.getText();
		if((RefCalcTagline.equals("Reference Calculations")) & (RefCalcFootnote.equals("Source: S&P Capital IQ; Accenture Client Value Services."))) {
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
			VIPCustomPage.contents.TaglineCount.verifyText("253 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Reference Calculations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
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
			VIPCustomPage.contents.TaglineTextBox.sendKeys("Reference Calculations_test");
			Thread.sleep(1000);
			VIPCustomPage.contents.ModalFootnoteHeader.verifyText("Footnote:");
			VIPCustomPage.contents.FootnoteTextBox.clear();
			VIPCustomPage.contents.FootnoteTextBox.sendKeys("Source: S&P Capital IQ; Accenture Client Value Services._test");
			Thread.sleep(1000);
			VIPCustomPage.contents.TaglineCount.verifyText("253 characters remaining");
			VIPCustomPage.contents.FootnoteCount.verifyText("789 characters remaining");
			VIPCustomPage.contents.ModalApplyButton.click();
			Thread.sleep(1000);
			VIPCustomPage.contents.DefaultTagline.verifyText("Reference Calculations_test");
			VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		}
		VIPCustomPage.contents.DefaultFootnote.click();
		VIPCustomPage.contents.TaglineTextBox.sendKeys("_test");
		Thread.sleep(2000);
		VIPCustomPage.contents.FootnoteTextBox.sendKeys("_test");
		VIPCustomPage.contents.TaglineFootnoteModalCloseButton.click();
		VIPCustomPage.contents.DefaultTagline.verifyText("Reference Calculations_test");
		VIPCustomPage.contents.DefaultFootnote.verifyText("Source: S&P Capital IQ; Accenture Client Value Services._test");
		WebControl.takeScreenshot("CUSTOM_RT_TC_Tagline_Footnote_048_049_050");

    }
    
	@Test(priority=24)
	public void Financials_Common () throws Exception {
		ReportLog.setTestName("CUSTOM - Common");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");

		/* Cpmmon Dashbpard
		 * Author: charisma.l.desipeda*/
		
		ReportLog.setTestCase("CUSTOM_RT_TC_045,046");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCustomPage.contents.SelectDashboard.waitForExist(true, 45);
		VIPCustomPage.contents.CommonSDTitle.verifyText("Select Dashboard");
		VIPCustomPage.contents.SelectDashboard.click();
		VIPCustomPage.contents.CommonESHeader.verifyText("Executive Summary");
		VIPCustomPage.contents.ScorecardMenu.verifyText("Competitiveness Scorecard");
		VIPCustomPage.contents.VCAMenu.verifyText("Value Creation Areas");
		VIPCustomPage.contents.HRAMenu.verifyText("HR Analysis - Glassdoor Benchmarking");
		VIPCustomPage.contents.CommonIEHeader.verifyText("Investor Expectations");
		VIPCustomPage.contents.TRSMenu.verifyText("Total Return to Shareholders");
		VIPCustomPage.contents.TRSSummaryMenu.verifyText("3-year TRS Decomposition - Summary");
		VIPCustomPage.contents.TRSLeversMenu.verifyText("3-year TRS Decomposition - Levers");
		VIPCustomPage.contents.SCMMenu.verifyText("Strategic Control Map (EV to IC)");
		VIPCustomPage.contents.EVICDecomMenu.verifyText("Enterprise Value to Invested Capital Decomposition");
		VIPCustomPage.contents.EVDissectionMenu.verifyText("EV Dissection (Future Value vs. Current Value)");
		VIPCustomPage.contents.AnalystRecoMenu.verifyText("Analyst Recommendations");
		VIPCustomPage.contents.AnalystCommentMenu.verifyText("Analyst Commentary");
		VIPCustomPage.contents.RaPEMenu.verifyText("Revenue and Profitability Estimates");
		VIPCustomPage.contents.CommonGIHeader.verifyText("Growth Indicators");
		VIPCustomPage.contents.RGvsASMenu.verifyText("Revenue Growth vs. Average Spread");
		VIPCustomPage.contents.RevGrowthMenu.verifyText("Revenue Growth");
		VIPCustomPage.contents.EmpProdMenu.verifyText("Employee Productivity");
		VIPCustomPage.contents.CommonOPHeader.verifyText("Operating Performance");
		VIPCustomPage.contents.PreTaxROICDriversMenu.verifyText("Pre-Tax ROIC Drivers – Op. Margin vs. Capital Efficiency");
		VIPCustomPage.contents.PreTaxROICDecompMenu.verifyText("Pre-Tax ROIC Decomposition");
		VIPCustomPage.contents.OWCMenu.verifyText("Operating Working Capital Decomposition");
		VIPCustomPage.contents.CashCycleAnalysisMenu.verifyText("Cash Cycle Analysis");
		VIPCustomPage.contents.CommonSTAHeader.verifyText("Segment Trend Analysis");
		VIPFinancialsPage.contents.SelectDropDown11.verifyText("Business Segment Analysis");
		VIPFinancialsPage.contents.SelectDropDown12.verifyText("Geographic Segment Analysis");
		VIPCustomPage.contents.CommonAppendixHeader.verifyText("Appendix");
		VIPCustomPage.contents.GlossaryMenu.verifyText("Glossary");
		VIPCustomPage.contents.MethodologyMenu.verifyText("Methodology");
		VIPCustomPage.contents.ReferenceCalculationsMenu.verifyText("Reference Calculations");
		WebControl.takeScreenshot("CUSTOM_RT_TC_045,046");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_053");
		VIPCustomPage.contents.VCAMenu.click();
		VIPCustomPage.contents.CommonCustomCATitle.verifyDisplayed(true, 5);
		VIPCustomPage.contents.CommonCustomCATitle.verifyText("Custom Company Analysis");
		WebControl.takeScreenshot("CUSTOM_RT_TC_053");
	
	}
}
