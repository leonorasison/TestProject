  package scenarios.Custom;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import pageobjects.VIPLogInPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;
import pageobjects.VIPFinancialsPage;


public class Financials_Custom_01_LandingOverviewCompetitorsPage extends TestBase{
	
	
	@Test(priority=1)
	public void CUSTOM_LandingOverviewCompetitorsPage () throws Exception {
		ReportLog.setTestName("CUSTOM - Landing, Overview & Competitors Page");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test2'");
		
		ReportLog.setTestCase("CUSTOM_RT_TC_022");
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
		 * Author: alyssa.kay.n.mababa*/
		ReportLog.setTestCase("CUSTOM_RT_TC_024");
		VIPLandingPage.contents.ShareButton.click();
		Thread.sleep(2000);
		String CompanyName_CR = VIPLandingPage.contents.CompanyCardName.getText();
		String RequestDate1 = VIPLandingPage.contents.CompanyCardDate.getText();
		DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy"); 
		Date RequestDate2 = (Date)formatter.parse(RequestDate1);
		SimpleDateFormat newFormatDate = new SimpleDateFormat("dd MMM yyyy");
		String RequestDate = newFormatDate.format(RequestDate2);
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
		//WebControl.navigateTo(testDataHandler.site);
		//Thread.sleep(2500);
		//WebControl.waitForPageToLoad(45);
		//Thread.sleep(2500);
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
		 * Author: alyssa.kay.n.mababa*/
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
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"tn)");}}
		else if (CurrencyEV[2].equals("(KRW")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"tn)");}}
		else if (CurrencyEV[2].equals("(CNY")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"tn)");}}
		else if (CurrencyEV[2].equals("(IDR")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"tn)");}}
		else if (CurrencyEV[2].equals("(COP")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"tn)");}}
		else if (CurrencyEV[2].equals("(CLP")){
			if (CurrencyEV[3].equals("bn)")) {
				VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"bn)");}
			else {VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"tn)");}}
		else {
			VIPCustomPage.contents.EVHeader.verifyText(CurrencyEV[0]+" "+CurrencyEV[1]+"\n"+CurrencyEV[2]+" "+"mn)");}
		
		VIPCustomPage.contents.ICHeader.verifyDisplayed(true, 5);
		String[] CurrencyIC = VIPCustomPage.contents.ICHeader.getText().split("\\s");	
		if (CurrencyIC[2].equals("(JPY")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"tn)");}}
		else if (CurrencyIC[2].equals("(KRW")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"tn)");}}
		else if (CurrencyIC[2].equals("(CNY")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"tn)");}}
		else if (CurrencyIC[2].equals("(IDR")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"tn)");}}
		else if (CurrencyIC[2].equals("(COP")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"tn)");}}
		else if (CurrencyIC[2].equals("(CLP")){
			if (CurrencyIC[3].equals("bn)")) {
				VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"bn)");}
			else {VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"tn)");}}
		else {
			VIPCustomPage.contents.ICHeader.verifyText(CurrencyIC[0]+" "+CurrencyIC[1]+"\n"+CurrencyIC[2]+" "+"mn)");}
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
		SimpleDateFormat newFormat = new SimpleDateFormat("MM/yyyy");
        String newTimePeriodTargetComp = newFormat.format(TimePeriodTargetCompSplit1);
		String newTimePeriodPeerComp1 = newFormat.format(TimePeriodPeerComp1Split1);
		String newTimePeriodPeerComp2 = newFormat.format(TimePeriodPeerComp2Split1);
		String newTimePeriodPeerComp13 = newFormat.format(TimePeriodPeerComp3Split1);

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
}
	
