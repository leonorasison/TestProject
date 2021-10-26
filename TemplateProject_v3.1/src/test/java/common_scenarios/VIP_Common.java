package common_scenarios;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import auto.framework.ReportLog;
import auto.framework.web.WebControl;
import common.TestDataHandler;
import pageobjects.VIPCustomPage;
import pageobjects.VIPLandingPage;
import pageobjects.VIPLogInPage;
import pageobjects.VIPOverviewPage;
import pageobjects.VIPSalesPage;


public class VIP_Common {

	
	/******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Navigate to VIP application
	 * @throws Exception
	 *****************************************************************************/

	public static void LogInPage(TestDataHandler testDataHandler) throws Exception{
		WebControl.open(testDataHandler.site);
		Thread.sleep(2500);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2500);
		VIPLogInPage.microsoftSignIn.EmailTextbox.waitForExist(true, 60);
		VIPLogInPage.microsoftSignIn.EmailTextbox.sendKeys(testDataHandler.email);
		VIPLogInPage.microsoftSignIn.NextButton.click();
		Thread.sleep(3000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		
	}
	
	/******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Upload Custom Report in VIP
	 * @throws Exception
	 *****************************************************************************/

	public static void FileUploadCustomReport_Public(TestDataHandler testDataHandler) throws Exception{
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.LoginButton.waitForExist(true, 120);
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.eid);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.DataModelUploadButton.waitForExist(true, 15);
		VIPCustomPage.contents.DataModelUploadButton.click();
		VIPCustomPage.contents.ChooseFileButton.click();
		Thread.sleep(2000);
		StringSelection ss = new StringSelection(testDataHandler.filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		VIPCustomPage.contents.UploadedFile.waitForExist(false, 10);
		String[] String = testDataHandler.filePath.split("\\\\");
		String FileName = String[String.length - 1];
		VIPCustomPage.contents.UploadedFile.verifyText(FileName);
		VIPCustomPage.contents.ReportTypeDropdown.click();
		VIPCustomPage.contents.PremiumIndustrialMenu.click();
		VIPCustomPage.contents.CompanyTypeDropdown.click();
		VIPCustomPage.contents.PublicMenu.click();
		VIPCustomPage.contents.SelectDashboardButton.click();
		VIPCustomPage.contents.DashboardsCheckbox1.click();
		VIPCustomPage.contents.ApplyButton.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.click();
	}
	
	/******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Upload Custom Report in VIP
	 * @throws Exception
	 *****************************************************************************/

	public static void FileUploadCustomReport_Private(TestDataHandler testDataHandler) throws Exception{
		WebControl.open(testDataHandler.customSite);
		VIPCustomPage.contents.LoginButton.waitForExist(true, 120);
		VIPCustomPage.contents.LoginButton.click();
		VIPCustomPage.contents.EIDTextBox.sendKeys(testDataHandler.eid);
		VIPCustomPage.contents.ModalLoginButton.click();
		VIPCustomPage.contents.DataModelUploadButton.waitForExist(true, 15);
		VIPCustomPage.contents.DataModelUploadButton.click();
		VIPCustomPage.contents.ChooseFileButton.click();
		Thread.sleep(2000);
		StringSelection ss = new StringSelection(testDataHandler.filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		VIPCustomPage.contents.UploadedFile.waitForExist(false, 10);
		String[] String = testDataHandler.filePath.split("\\\\");
		String FileName = String[String.length - 1];
		VIPCustomPage.contents.UploadedFile.verifyText(FileName);
		VIPCustomPage.contents.ReportTypeDropdown.click();
		VIPCustomPage.contents.PremiumIndustrialMenu.click();
		VIPCustomPage.contents.CompanyTypeDropdown.click();
		VIPCustomPage.contents.PrivateMenu.click();
		VIPCustomPage.contents.SelectDashboardButton.click();
		VIPCustomPage.contents.DashboardsCheckbox1.click();
		VIPCustomPage.contents.ApplyButton.click();
		Thread.sleep(2000);
		VIPCustomPage.contents.SubmitButton.click();
		
	}
	
	/******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Searching a Company
	 * @throws Exception
	 *****************************************************************************/

	public static void Searching(TestDataHandler testDataHandler) throws Exception{
		//WebControl.open(testDataHandler.site);
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(false, 2);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		VIPLandingPage.contents.CompanyNameTextbox.type(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
	}
	
	/*******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Verify if File is downloaded
	 * @throws Exception
	 ******************************************************************************/    
		
		public static boolean isFileDownloaded(String downloadPath, String fileName) {
			 
			File dir = new File(downloadPath);
		    File[] dirContents = dir.listFiles();
			  for (int i = 0; i < dirContents.length; i++) {
			      if (dirContents[i].getName().equals(fileName)) {
			          // File has been found, it can now be deleted:
			    	  ReportLog.passed("The Downloaded File : "+fileName+ " Exist");
			          //dirContents[i].delete();
			          return true;
			      }
			          
			    }
			  
			ReportLog.failed("The Downloaded File : "+fileName+ " Does Not Exist");
			          return false;
		 }
		
	/*******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Verify if File is downloaded
	 * @throws Exception
	******************************************************************************/
		
		public static boolean isFileDownloaded2(String folderName) {
			 
			//String folderName = "."; // Give your folderName
			File[] listFiles = new File(folderName).listFiles();

			for (int i = 0; i < listFiles.length; i++) {

			    if (listFiles[i].isFile()) {
			        String fileName = listFiles[i].getName();
			        if (fileName.startsWith("companyanalysis_")
			                && fileName.endsWith(".pptx")) {
			        	ReportLog.passed("The Downloaded File : "+fileName+ " Exist");
			        	return true;
			        }
			    }
			}
			
			ReportLog.failed("The Downloaded File : Does Not Exist");
			return false;
		}		
		
		
	/*******************************************************************************
	  * @author arjay.b.asuncion
	  * @return Description: Open a File
      * @throws Exception
	******************************************************************************/ 
		
		public static void openFile(String fileName) {
		 
			try  
			{  
			//constructor of file class having file as argument  
			File file = new File(fileName);   
			if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
			{  
			System.out.println("not supported");  
			return;  
			}  
			Desktop desktop = Desktop.getDesktop();  
			if(file.exists())         //checks file exists or not  
			desktop.open(file);      //opens the specified file  
			ReportLog.passed("The File is Open");
			}  
			catch(Exception e)  
			{  
			e.printStackTrace();  
			} 
		
		 }

	/*******************************************************************************
		  * @author arjay.b.asuncion
		  * @return Description: Closing a File
	      * @throws Exception
	*****************************************************************************
	*/ 
		
		public static boolean isFileDeleted(String downloadPath, String fileName) {
			 
			File dir = new File(downloadPath);
		    File[] dirContents = dir.listFiles();
			  for (int i = 0; i < dirContents.length; i++) {
			      if (dirContents[i].getName().equals(fileName)) {
			          // File has been found, it can now be deleted:
			    	  dirContents[i].delete();
			    	  ReportLog.passed("The File : "+fileName+ " Deleted");
			          return true;
			      }
			          
			  }
			  
			ReportLog.failed("The Downloaded File : "+fileName+ " Does Not Exist");
			          return false;
		 }
		
	/*******************************************************************************
	  * @author arjay.b.asuncion
	  * @return Description: Verify if File is downloaded
	  * @throws Exception
	******************************************************************************/

		public static boolean isFileDeleted2(String folderName) {
			 
			//String folderName = "."; // Give your folderName
			File[] listFiles = new File(folderName).listFiles();

			for (int i = 0; i < listFiles.length; i++) {

			    if (listFiles[i].isFile()) {
			        String fileName = listFiles[i].getName();
			        if (fileName.startsWith("companyanalysis_")
			                && fileName.endsWith(".pptx")) {
			        	listFiles[i].delete();
				    	ReportLog.passed("The File : "+fileName+ " Deleted");
				        return true;
			        }
			    }
			}
			
			ReportLog.failed("The Downloaded File : Does Not Exist");
			return false;
		}	
	
	/******************************************************************************
	 * @author arjay.b.asuncion
	 * @return Description: Download Report - PPT
	 * @throws Exception
	 *****************************************************************************/

	public static void DownloadReport(TestDataHandler testDataHandler) throws Exception{
		
		ReportLog.setTestName("Editable PPT Regression - Download Report - " + testDataHandler.company);
		
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat2 = new SimpleDateFormat("MMM dd, yyyy");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat1.format(cal.getTime());
		String cal2 = dateFormat2.format(cal.getTime());
		
		//Login
//		ReportLog.setTestCase("Successful Login");
//		WebControl.open(testDataHandler.site);Thread.sleep(2500);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(2500);
//		VIPLogInPage.microsoftSignIn.EmailTextbox.waitForExist(true, 60);
//		VIPLogInPage.microsoftSignIn.EmailTextbox.sendKeys(testDataHandler.email);
//		VIPLogInPage.microsoftSignIn.NextButton.click();
//		Thread.sleep(3000);
//		WebControl.waitForPageToLoad(45);
//		Thread.sleep(3000);
//		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		//Searching
		ReportLog.setTestCase("Searching of Company - " + testDataHandler.company);
		VIPLandingPage.contents.LandingPageLoadedCompletely.waitForExist(true, 120);
		VIPLandingPage.contents.StartNowButton.click();
		if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("Yes")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(true, 5);
		VIPLandingPage.contents.DisclaimerProceedButton.click();
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("Yes"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(true, 5);
		VIPLandingPage.contents.NewDisclaimerText.verifyText(testDataHandler.VCMDisclaimer);
		VIPLandingPage.contents.NewDisclaimerProceedButton.click();
		Thread.sleep(2000);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		else if ((testDataHandler.ShowCVS.equals("No")) & (testDataHandler.ShowVCM.equals("No"))) {
		Thread.sleep(2000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(3000);
		VIPLandingPage.contents.DisclaimerModal.verifyDisplayed(false, 2);
		VIPLandingPage.contents.NewDisclaimerText.verifyDisplayed(false, 2);
		VIPLandingPage.contents.CompanyNameTextbox.verifyDisplayed(true, 60);
		VIPLandingPage.contents.StartNowButton.verifyDisplayed(false, 2);}
		String s1 = VIPLandingPage.contents.ReportsTotal.getText();
		String s2 = s1.replace("/ ", "");
		int s3 = Integer.parseInt(s2);
		int s4 = s3 + 1;
		String s5 = Integer.toString(s4);
		String s6 = "/ " + s5;
		VIPLandingPage.contents.CompanyNameTextbox.type(testDataHandler.company);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.waitForExist(true, 20);
		Thread.sleep(3000);
		VIPLandingPage.contents.CompanyTypeAhead.verifyDisplayed(true, 20);
		VIPLandingPage.contents.CompanyTypeAhead.click();
		Thread.sleep(4000);
		WebControl.waitForPageToLoad(45);
		Thread.sleep(4000);
		if (VIPSalesPage.contents.FinancialDisclaimerCloseButton.isDisplayed()) {
		VIPSalesPage.contents.FinancialDisclaimerCloseButton.click();}
		VIPOverviewPage.contents.EnterpriseValue.waitForExist(true, 60);
		VIPOverviewPage.contents.GenerateFinancialReportButton.waitForExist(true, 10);
		VIPOverviewPage.contents.RBBPieChartTitle.waitForExist(true, 10);
		//Downloading - Download Excel
		ReportLog.setTestCase("Downloading Financials Report (Excel) for Company - " + testDataHandler.company);
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportModalHeader.verifyText("Download Report");
		VIPOverviewPage.contents.DownloadReportModalBody.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportDownloadButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.NotificationCloseButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportDownloadButton.click();
		Thread.sleep(2000);
		isFileDownloaded("C:\\Users\\" + testDataHandler.eid + "\\Downloads", testDataHandler.company + " Report - " + cal1 + ".xlsx");
		isFileDeleted("C:\\Users\\" + testDataHandler.eid + "\\Downloads", testDataHandler.company + " Report - " + cal1 + ".xlsx");
		//Downloading - Download PPT
		ReportLog.setTestCase("Downloading Report (PPT) for Company - " + testDataHandler.company);
		VIPOverviewPage.contents.GenerateFinancialReportButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.DownloadReportSaveButton.verifyDisplayed(true, 5);
		VIPOverviewPage.contents.DownloadReportSaveButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 15);
		VIPOverviewPage.contents.ToasterMessage.verifyText("The PPT generation may take 5-10 minutes to complete. Once it is completed, you will get another notification and the PPT report will be available in your ‘Downloads’ folder.");
		VIPOverviewPage.contents.ToasterMessageCloseButton.click();
		Thread.sleep(2000);
		VIPOverviewPage.contents.ToasterMessage.verifyDisplayed(true, 240);
		VIPOverviewPage.contents.ToasterMessage.verifyText("Your report has been generated successfully");
		Thread.sleep(3000);
		isFileDownloaded2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
		isFileDeleted2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
		VIPLandingPage.contents.HelpIcon.hover();
		VIPOverviewPage.contents.BackToSearchButton.hover();
		VIPOverviewPage.contents.BackToSearchButton.click();
		VIPLandingPage.contents.ReportsTotal.waitForExist(true, 60);
		VIPLandingPage.contents.ReportsTotal.verifyText(s6);	
		VIPLandingPage.contents.CompanyCardType.verifyText("Company Analysis");
		VIPLandingPage.contents.CompanyCardDate.verifyText(cal2);
		VIPLandingPage.contents.CompanyCardName.verifyText(testDataHandler.company);
		//Downloading - Download Report Card
		ReportLog.setTestCase("Downloading Report Card (PPT) for Company - " + testDataHandler.company);
		VIPLandingPage.contents.DownloadPPTButton.hover();
		VIPLandingPage.contents.DownloadPPTButtonTooltip.verifyText("Download PPT");
		VIPLandingPage.contents.DownloadPPTButton.click();
		Thread.sleep(3000);
		isFileDownloaded2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
		isFileDeleted2("C:\\Users\\" + testDataHandler.eid + "\\Downloads");
		
	}
	
//	public static boolean isFileDownloaded(String downloadPath, String fileName) {
//		  File dir = new File(downloadPath);
//		  File[] dirContents = dir.listFiles();
//
//		  for (int i = 0; i < dirContents.length; i++) {
//		      if (dirContents[i].getName().equals(fileName)) {
//		          // File has been found, it can now be deleted:
//		          dirContents[i].delete();
//		          return true;
//		      }
//		          }
//		      return false;
//		  }
	
}


		
		
		


