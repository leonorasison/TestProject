package scenarios.WEB;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import auto.framework.ReportLog;
import auto.framework.TestBase;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import common_scenarios.VIP_Common;
import pageobjects.VIPCompetitorPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;

public class WEBFunctionality_04_Competitors extends TestBase{
	
	@Test
	public void WEBFunctionality_Competitors () throws Exception {
		ReportLog.setTestName("WEB Functionality - Competitors");
		TestDataHandler testDataHandler = TestDataHandler.loadTestData("Sheet", "RowSelection='Test1'");
		
		ReportLog.setTestCase("WEB_Reg_Auto_122");
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
		//Work-around Script
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 10);
		VIPLandingPage.contents.CompanyNameTextbox.sendKeys(testDataHandler.privCompany);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 10);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.OverviewTitle.waitForExist(true, 60);
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.SideMenuCompetitor.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed();
		VIPCompetitorPage.contents.CompetitorNoResults.verifyText("No results. Add competitors or refine search criteria.");
		WebControl.takeScreenshot("WEB_Reg_Auto_122");
		
		ReportLog.setTestCase("WEB_Reg_Auto_123");
		String CompanyName_066 = VIPOverviewPage.contents.CompanyName.getText();
		String Industry = VIPOverviewPage.contents.Industry.getText();
		VIPCompetitorPage.contents.TargetCompName.waitForExist(true, 10);
		VIPCompetitorPage.contents.TargetCompName.verifyText(CompanyName_066);
		WebControl.takeScreenshot("WEB_Reg_Auto_123");	
		
		ReportLog.setTestCase("WEB_Reg_Auto_124");
		VIPCompetitorPage.contents.CompetitorSearchbox.sendKeys("Procter");
		Thread.sleep(3000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.waitForExist(true, 15);
		Thread.sleep(2000);
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.verifyDisplayed(true, 15);
		WebControl.takeScreenshot("WEB_Reg_Auto_124");
		
		ReportLog.setTestCase("WEB_Reg_Auto_125");
		VIPCompetitorPage.contents.CompetitorSearchTypeahead.customJavaClick();
		Thread.sleep(3000);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 10);
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
			if (Industry.equals("-")) {
				VIPCompetitorPage.contents.Competitors1stPeers.verifyText("The Procter & Gamble Company\n" + "NYSE:PG");
				VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 1 PEERS");}
			else {VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 16 PEERS");}}
		WebControl.takeScreenshot("WEB_Reg_Auto_125");
		
		ReportLog.setTestCase("WEB_Reg_Auto_126");
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		VIPCompetitorPage.contents.Competitors1stPeers.click();}
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.verifyDisplayed(true, 8);
		WebControl.takeScreenshot("WEB_Reg_Auto_126_1");
		if (VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.isDisplayed()) {
		VIPCompetitorPage.contents.CompetitorsPeersDeleteButton.click();
		VIPCompetitorPage.contents.CompetitorsPeersDeleteLoadingIcon.waitForExist(false, 10);}
		Thread.sleep(1500);
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 0 PEERS");}
		else {VIPCompetitorPage.contents.PeersCounter.verifyText("SHOWING 15 PEERS");}
		WebControl.takeScreenshot("WEB_Reg_Auto_126_2");
		
		ReportLog.setTestCase("WEB_Reg_Auto_127");
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed();
		WebControl.takeScreenshot("WEB_Reg_Auto_127");
		
		ReportLog.setTestCase("WEB_Reg_Auto_128");
		VIPCompetitorPage.contents.RefineCriteriaCloseButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_128");
		
		ReportLog.setTestCase("WEB_Reg_Auto_129");
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.RefineCriteriaModal.verifyDisplayed();
		VIPCompetitorPage.contents.SelectRegionAccordionCollapsed.click();
		VIPCompetitorPage.contents.SelectRegionDropdown.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.SelectCountryDropdown.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_129");
		
		ReportLog.setTestCase("WEB_Reg_Auto_130");
		VIPCompetitorPage.contents.SelectRegionAccordionExpanded.click();
		VIPCompetitorPage.contents.SetRevenueAccordionCollapsed.click();
		VIPCompetitorPage.contents.RevenueMin.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.RevenueMax.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.MarketCapMin.verifyDisplayed(true, 3);
		VIPCompetitorPage.contents.MarketCapMax.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_130");
		
		ReportLog.setTestCase("WEB_Reg_Auto_131");
		VIPCompetitorPage.contents.RefineCriteriaCloseButton.click();
		Thread.sleep(1500);
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.SaveCriteriaButton.verifyDisplayed(false);
		WebControl.takeScreenshot("WEB_Reg_Auto_131_1");
		VIPCompetitorPage.contents.SetRevenueAccordionCollapsed.click();
		VIPCompetitorPage.contents.RevenueMin.sendKeys("100");
		VIPCompetitorPage.contents.RevenueMax.sendKeys("1000");
		VIPCompetitorPage.contents.MarketCapMin.sendKeys("100");
		VIPCompetitorPage.contents.MarketCapMax.sendKeys("1000");
		VIPCompetitorPage.contents.SetRevenueAccordionExpanded.click();
		VIPCompetitorPage.contents.SaveCriteriaButton.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_131_2");
		
		ReportLog.setTestCase("WEB_Reg_Auto_132");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPCompetitorPage.contents.SaveCriteriaButton.click();
		Thread.sleep(1500);
		VIPCompetitorPage.contents.NameCriteriaTextBox.verifyDisplayed(true, 3);
		WebControl.takeScreenshot("WEB_Reg_Auto_132");
		
		ReportLog.setTestCase("WEB_Reg_Auto_133");
		VIPCompetitorPage.contents.NameCriteriaTextBox.sendKeys("Test");
		VIPCompetitorPage.contents.NameCriteriaCloseButton.click();
		VIPCompetitorPage.contents.NameCriteriaTextBox.verifyDisplayed(false);
		VIPCompetitorPage.contents.SaveCriteriaButton.click();
		VIPCompetitorPage.contents.NameCriteriaTextBox.sendKeys("Test");
		VIPCompetitorPage.contents.DoneCriteriaButton.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_133");
		
		ReportLog.setTestCase("WEB_Reg_Auto_134");
		VIPCompetitorPage.contents.PreSavedCriteriaAccordionCollapsed.click();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdown.click();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdownMenu.verifyText("Test");
		WebControl.takeScreenshot("WEB_Reg_Auto_134");
		
		ReportLog.setTestCase("WEB_Reg_Auto_135");
		VIPCompetitorPage.contents.PreSavedCriteriaDropdownMenu.click();
		WebControl.takeScreenshot("WEB_Reg_Auto_135");
		
		ReportLog.setTestCase("WEB_Reg_Auto_136");
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(true, 20);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		else {VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 20);
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_136");
		
		ReportLog.setTestCase("WEB_Reg_Auto_137");
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		else {
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors15thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(false);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_137_BeforeFilter");
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPCompetitorPage.contents.RefineCriteriaButton.click();
		VIPCompetitorPage.contents.PreSavedCriteriaAccordionCollapsed.click();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdown.hover();
		VIPCompetitorPage.contents.PreSavedCriteriaDropdown.click();
		//Comment out temporarily
		//VIPCompetitorPage.contents.PreSavedCriteriaDropdownMenu.verifyDisplayed(true, 5);
		WebControl.takeScreenshot("WEB_Reg_Auto_137_VerifySavedCriteria");
		VIPCompetitorPage.contents.TopFilterDropdown.click();
		VIPCompetitorPage.contents.TopFilterChoice25.click();
		VIPCompetitorPage.contents.ApplyCriteriaButton.click();
		if (Industry.equals("-")) {
		VIPCompetitorPage.contents.CompetitorNoResults.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		else {
		VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors15thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors16thPeers.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Competitors25thPeers.verifyDisplayed(true, 5);}
		WebControl.takeScreenshot("WEB_Reg_Auto_137_AfterFilter");
		
		ReportLog.setTestCase("WEB_Reg_Auto_138");
		String TargetCompName = VIPCompetitorPage.contents.TargetCompName.getText();
		if (TargetCompName.length() > 18) {
		String NewTargetCompName1 = TargetCompName.split("\n")[0];
		String NewTargetCompName = NewTargetCompName1.substring(0, 18);
		VIPCompetitorPage.contents.NewTargetCompAlias.verifyValue(NewTargetCompName);}
		else {VIPCompetitorPage.contents.NewTargetCompAlias.verifyValue(TargetCompName);}
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		String FirstPeerCompName = VIPCompetitorPage.contents.Competitors1stPeers.getText();
		if (FirstPeerCompName.length() > 18) {
		String NewFirstPeerCompName1 = FirstPeerCompName.split("\n")[0];
		String NewFirstPeerCompName = NewFirstPeerCompName1.substring(0, 18);
		VIPCompetitorPage.contents.NewFirstPeerAlias.verifyValue(NewFirstPeerCompName);}
		else {VIPCompetitorPage.contents.NewFirstPeerAlias.verifyValue(FirstPeerCompName);}}
		WebControl.takeScreenshot("WEB_Reg_Auto_138");
		
		ReportLog.setTestCase("WEB_Reg_Auto_139");
		String Digits19 = "1234567890123456789";
		String Digits18 = "123456789012345678";
		VIPCompetitorPage.contents.NewTargetCompAlias.clear();
		VIPCompetitorPage.contents.NewTargetCompAlias.type(Digits19);
		VIPCompetitorPage.contents.NewTargetCompAlias.verifyValue(Digits18);
		if (VIPCompetitorPage.contents.NewFirstPeerAlias.isDisplayed()) {
		VIPCompetitorPage.contents.NewFirstPeerAlias.clear();
		VIPCompetitorPage.contents.NewFirstPeerAlias.type(Digits19);
		VIPCompetitorPage.contents.NewFirstPeerAlias.verifyValue(Digits18);}
		WebControl.takeScreenshot("WEB_Reg_Auto_139");
		
		ReportLog.setTestCase("WEB_Reg_Auto_140");
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		String Revenue1_1 = VIPCompetitorPage.contents.Revenue1.getText();
		String Revenue1_2 = Revenue1_1.replace(",", "");
		int Revenue1 = Integer.parseInt(Revenue1_2);
		
		String Revenue2_1 = VIPCompetitorPage.contents.Revenue2.getText();
		String Revenue2_2 = Revenue2_1.replace(",", "");
		int Revenue2 = Integer.parseInt(Revenue2_2);
		
		String Revenue3_1 = VIPCompetitorPage.contents.Revenue3.getText();
		String Revenue3_2 = Revenue3_1.replace(",", "");
		int Revenue3 = Integer.parseInt(Revenue3_2);
		
		String Revenue4_1 = VIPCompetitorPage.contents.Revenue4.getText();
		String Revenue4_2 = Revenue4_1.replace(",", "");
		int Revenue4 = Integer.parseInt(Revenue4_2);
		
		String Revenue5_1 = VIPCompetitorPage.contents.Revenue5.getText();
		String Revenue5_2 = Revenue5_1.replace(",", "");
		int Revenue5 = Integer.parseInt(Revenue5_2);
		
		String Revenue6_1 = VIPCompetitorPage.contents.Revenue6.getText();
		String Revenue6_2 = Revenue6_1.replace(",", "");
		int Revenue6 = Integer.parseInt(Revenue6_2);
		
		String Revenue7_1 = VIPCompetitorPage.contents.Revenue7.getText();
		String Revenue7_2 = Revenue7_1.replace(",", "");
		int Revenue7 = Integer.parseInt(Revenue7_2);
		
		String Revenue8_1 = VIPCompetitorPage.contents.Revenue8.getText();
		String Revenue8_2 = Revenue8_1.replace(",", "");
		int Revenue8 = Integer.parseInt(Revenue8_2);
		
		String Revenue9_1 = VIPCompetitorPage.contents.Revenue9.getText();
		String Revenue9_2 = Revenue9_1.replace(",", "");
		int Revenue9 = Integer.parseInt(Revenue9_2);
		
		String Revenue10_1 = VIPCompetitorPage.contents.Revenue10.getText();
		String Revenue10_2 = Revenue10_1.replace(",", "");
		int Revenue10 = Integer.parseInt(Revenue10_2);
		
		String Revenue11_1 = VIPCompetitorPage.contents.Revenue11.getText();
		String Revenue11_2 = Revenue11_1.replace(",", "");
		int Revenue11 = Integer.parseInt(Revenue11_2);
		
		String Revenue12_1 = VIPCompetitorPage.contents.Revenue12.getText();
		String Revenue12_2 = Revenue12_1.replace(",", "");
		int Revenue12 = Integer.parseInt(Revenue12_2);
		
		String Revenue13_1 = VIPCompetitorPage.contents.Revenue13.getText();
		String Revenue13_2 = Revenue13_1.replace(",", "");
		int Revenue13 = Integer.parseInt(Revenue13_2);
		
		String Revenue14_1 = VIPCompetitorPage.contents.Revenue14.getText();
		String Revenue14_2 = Revenue14_1.replace(",", "");
		int Revenue14 = Integer.parseInt(Revenue14_2);
		
		String Revenue15_1 = VIPCompetitorPage.contents.Revenue15.getText();
		String Revenue15_2 = Revenue15_1.replace(",", "");
		int Revenue15 = Integer.parseInt(Revenue15_2);
		
		List<Integer> lList = new ArrayList<Integer>();
        lList.add(Revenue1);       
        lList.add(Revenue2);
        lList.add(Revenue3);
        lList.add(Revenue4);
        lList.add(Revenue5);
        lList.add(Revenue6);
        lList.add(Revenue7);
        lList.add(Revenue8);
        lList.add(Revenue9);
        lList.add(Revenue10);
        lList.add(Revenue11);
        lList.add(Revenue12);
        lList.add(Revenue13);
        lList.add(Revenue14);
        lList.add(Revenue15);
        
        Collections.sort(lList);
        Integer a1 = lList.get(0);
        Integer a2 = lList.get(1);
        Integer a3 = lList.get(2);
        Integer a4 = lList.get(3);
        Integer a5 = lList.get(4);
        Integer a6 = lList.get(5);
        Integer a7 = lList.get(6);
        Integer a8 = lList.get(7);
        Integer a9 = lList.get(8);
        Integer a10 = lList.get(9);
        Integer a11 = lList.get(10);
        Integer a12 = lList.get(11);
        Integer a13 = lList.get(12);
        Integer a14 = lList.get(13);
        Integer a15 = lList.get(14);
        
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        String b1 = myFormat.format(a1);
        String b2 = myFormat.format(a2);
        String b3 = myFormat.format(a3);
        String b4 = myFormat.format(a4);
        String b5 = myFormat.format(a5);
        String b6 = myFormat.format(a6);
        String b7 = myFormat.format(a7);
        String b8 = myFormat.format(a8);
        String b9 = myFormat.format(a9);
        String b10 = myFormat.format(a10);
        String b11 = myFormat.format(a11);
        String b12 = myFormat.format(a12);
        String b13 = myFormat.format(a13);
        String b14 = myFormat.format(a14);
        String b15 = myFormat.format(a15);
		
		VIPCompetitorPage.contents.Revenue1.verifyText(b15);
		VIPCompetitorPage.contents.Revenue2.verifyText(b14);
		VIPCompetitorPage.contents.Revenue3.verifyText(b13);
		VIPCompetitorPage.contents.Revenue4.verifyText(b12);
		VIPCompetitorPage.contents.Revenue5.verifyText(b11);
		VIPCompetitorPage.contents.Revenue6.verifyText(b10);
		VIPCompetitorPage.contents.Revenue7.verifyText(b9);
		VIPCompetitorPage.contents.Revenue8.verifyText(b8);
		VIPCompetitorPage.contents.Revenue9.verifyText(b7);
		VIPCompetitorPage.contents.Revenue10.verifyText(b6);
		VIPCompetitorPage.contents.Revenue11.verifyText(b5);
		VIPCompetitorPage.contents.Revenue12.verifyText(b4);
		VIPCompetitorPage.contents.Revenue13.verifyText(b3);
		VIPCompetitorPage.contents.Revenue14.verifyText(b2);
		VIPCompetitorPage.contents.Revenue15.verifyText(b1);}
		else {VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_140");
		
		ReportLog.setTestCase("WEB_Reg_Auto_141");
		if (VIPCompetitorPage.contents.Competitors1stPeers.isDisplayed()) {
		VIPCompetitorPage.contents.Symbol1.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol2.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol3.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol4.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol5.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol6.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol7.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol8.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol9.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol10.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol11.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol12.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol13.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol14.verifyDisplayed(true, 5);
		VIPCompetitorPage.contents.Symbol15.verifyDisplayed(true, 5);}
		else {VIPCompetitorPage.contents.Competitors1stPeers.verifyDisplayed(false);}
		WebControl.takeScreenshot("WEB_Reg_Auto_141");
		
	}
	
}


