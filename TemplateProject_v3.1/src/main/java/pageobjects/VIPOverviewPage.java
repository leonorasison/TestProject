package pageobjects;

import org.openqa.selenium.By;
import auto.framework.PageBase;
import auto.framework.web.Element;
import auto.framework.web.TextBox;

public class VIPOverviewPage extends PageBase{
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		public final Element OverviewTitle;
		public final Element GenerateFinancialReportButton;
		public final Element SubmitRequestButton;
		public final Element DownloadReportModalHeader;
		public final Element DownloadReportModalHeader2;
		public final Element DownloadReportModalBody;
		public final Element DownloadReportModalBodyPriv;
		public final Element DownloadReportCloseButton;
		public final Element DownloadReportSaveButton;
		public final Element DownloadPPTReportIcon;
		public final Element DownloadReportDownloadButton;
		public final Element DownloadExcelReportIcon;
		public final Element NotificationCloseButton;
		public final Element NotificationModal;
		public final Element BackToSearchButton;
		public final Element BackToSearchButton2;
		
		// Lsison, 20211015, add report saving confirmation message before searching again
		public final Element ExitSavePopup;
		public final Element ExitSavePopupText;
		public final Element ExitSavePopupYesButton;
		
		
		// Lsison, 20211018, add save company button
		public final Element SaveCompanyButton;
		public final Element SaveReportInVIPButton;
		public final Element SaveReportInVIPPrompt;
		
		public final Element CompanyName;
		//public final Element OverviewCompanyName;
		//public final Element RefreshCompanyName;
		public final Element SearchType;
		public final Element ReportSummaryHeader;
		public final Element SideMenuOverview;
		public final Element SideMenuCompetitor;
		public final Element FinancialsLink;
		public final Element FinancialsTitle;
		public final Element PrivateCompReminder;
		public final Element OverviewDescription;
		public final Element OverviewDescription2;
		public final Element TRSValue;
		public final Element TRSTrendValue;
		public final Element TRSYear;
		public final Element TRSTrendRedIcon;
		public final Element TRSTrendGreenIcon;
		public final Element RGValue;
		public final Element RGTrendValue;
		public final Element RGYear;
		public final Element RGTrendGreenIcon;
		public final Element RGTrendRedIcon;
		public final Element ROICValue;
		public final Element ROICTrendValue;
		public final Element ROICYear;
		public final Element ROICTrendGreenIcon;
		public final Element ROICTrendRedIcon;
		public final Element EBITValue;
		public final Element EBITTrendValue;
		public final Element EBITYear;
		public final Element EBITTrendGreenIcon;
		public final Element EBITTrendRedIcon;
		public final Element CEValue;
		public final Element CETrendValue;
		public final Element CEYear;
		public final Element CETrendGreenIcon;
		public final Element CETrendRedIcon;
		public final Element FinancialSummaryNote;
		public final Element ROICTitle;
		public final Element RevenueTitle;
		public final Element RevenueiIcon;
		public final Element RevenueValue;
		public final Element EmployeesValue;
		public final Element Industry;
		public final Element Website;
		public final Element Headquarters;
		public final Element Type;
		public final Element ClientFocus;
		public final Element RefineCriteriaLink;
		public final Element EBITMarginTitle;
		public final Element EBITMarginValue;
		public final Element EnterpriseValueTitle;
		public final Element EnterpriseValue;
		public final Element RBBPieChart;
		public final Element RBBPieChartTitle;
		public final Element RBBPieChartTimePeriod;
		public final Element RBBPieChartLegendIcon1;
		public final Element RBBPieChartLegendIcon2;
		public final Element RBBPieChartLegendText1;
		public final Element RBBPieChartLegendText2;
		public final Element RBBPieChartLegendTooltip;
		public final Element RBGPieChart;
		public final Element RBGPieChartTitle;
		public final Element RBGPieChartTimePeriod;
		public final Element RBGPieChartLegendIcon1;
		public final Element RBGPieChartLegendIcon2;
		public final Element RBGPieChartLegendText1;
		public final Element RBGPieChartLegendText2;
		public final Element RBGPieChartLegendTooltip;
		public final Element TRSTrend;
		public final Element RGTrend;
		public final Element ROICTrend;
		public final Element EBITMarginTrend;
		public final Element CapEffTrend;
		public final Element ToasterMessage;
		public final Element ToasterMessageWait;
		public final Element ToasterMessageDownloaded;
		public final Element ToasterMessageCloseButton;
		public final Element TooltipTextClick;
		public final Element TooltipText;
		public final Element KeyInsights1;
		public final Element KeyInsights2;
		public final Element KeyInsights3;
		public final Element KeyInsights4;
		public final Element KeyInsights5;
		public final Element FinancialsSummaryContainer;
		
		public Contents() {
			super("Container", By.className("mainContainer"));
			
			OverviewTitle = new Element("Overview Title", By.xpath("//*[@class='overview-title']"), this);
			//GenerateFinancialReportButton = new Element("Download Report Button", By.xpath("//*[@class='header-feedback-button']/div"), this);
			GenerateFinancialReportButton = new Element("Download Report Button", By.xpath("//*[@class='download-infocontainer-info ng-tns-c39-1 ng-star-inserted']"), this);
			SubmitRequestButton = new Element("Submit Request Button", By.xpath("//*[@class='report-header-button']"), this);
			DownloadReportModalHeader = new Element("Download Report Modal Title", By.xpath("//*[@class='modal-content modal-content-summary modal-content-summary-genReport']//*[@class='modal-title']"), this);
			DownloadReportModalHeader2 = new Element("Download Report Modal Title", By.xpath("//*[@class='modal-content modal-content-summary' or @class='modal-content modal-content-summary modal-content-summary-genReport']//*[@class='modal-title']"), this);
			DownloadReportModalBody = new Element("Download Report Modal Text Body", By.xpath("//*[@class='modal-content modal-content-summary modal-content-summary-genReport']//*[@class='textbody-start textbody-start-genReport ng-star-inserted']"), this);
			DownloadReportModalBodyPriv = new Element("Download Report Modal Text Body", By.xpath("//*[@class='modal-content modal-content-summary']//*[@class='modal-body']/div"), this);
			DownloadReportCloseButton = new Element("Download Report Close Button", By.xpath("//*[@class='modal-content modal-content-summary modal-content-summary-genReport']//*[@class='close']"), this);
			DownloadReportSaveButton = new Element("Download PPT Report Button", By.xpath("//*[@class='modal-body']//*[@class='modal-footer ng-star-inserted'][1]/button/img[@src='../../../assets/images/PowerPoint_Icon.svg']"), this);
			DownloadPPTReportIcon = new Element("Download PPT Report Icon", By.xpath("//*[@class='modal-body']//*[@class='modal-footer ng-star-inserted'][1]//*[@src='../../../assets/images/PowerPoint_Icon.svg']"), this);
			DownloadReportDownloadButton = new Element("Download Financials to Excel Button", By.xpath("(//*[@class='button-proceedReport btn ng-star-inserted'])[2]"), this);
			DownloadExcelReportIcon = new Element("Download Excel Report Icon", By.xpath("//*[@src='../../../assets/images/Excel_Icon.svg']"), this);
			NotificationCloseButton = new Element("Notification Close Button", By.xpath("//*[@class='modal-content modal-content-summary modal-content-summary-genReport']//*[@class='close']"), this);
			NotificationModal = new Element("Download Report Modal Popup", By.xpath("//*[@class='modal-content modal-content-summary modal-content-summary-genReport']//*[@id='exampleModalLongTitle']"), this);
			BackToSearchButton = new Element("Back To Search Button", By.xpath("//*[@class='header-backsearch-text']"), this);
			BackToSearchButton2 = new Element("Back To Search Button 2", By.xpath("//*[@src='../../assets/images/arrow-left.png']"), this);
			
			//Lsison, 20211018, New modal and function for save report
			ExitSavePopup = new Element ("Exit Save Popup Window", By.xpath("//*[@id=\"exitsavePopup\"]/div/div"), this);
			ExitSavePopupText = new Element ("Exit Save Popup Text", By.xpath("(//*[@class=\"modal-body-esg-text\"])[2]"), this);
			ExitSavePopupYesButton = new Element ("Exit Save Popup Yes Button", By.xpath("//*[@id=\"exitsavePopup\"]/div/div/div[2]/div[1]/button[1]"), this);
			SaveCompanyButton = new Element ("SaveCompanyButton", By.xpath("//*[@data-target = '#popup-save-report']"), this);
			SaveReportInVIPButton = new Element("Save Report In VIP Button", By.xpath(" //*[@class='save-report ng-star-inserted']"), this);
			SaveReportInVIPPrompt = new Element("Save Report In VIP Button", By.xpath("//*[@id=\"toast-container\"]/div/div"), this);
			CompanyName = new Element("Company Name", By.xpath("//*[@class='header-text']/div[2]/div[1]"), this);
			//OverviewCompanyName = new Element("Company Name Label", By.xpath("//*[@class='header-text']/div[2]//*[@class='ng-tns-c27-2 ng-star-inserted']"), this);
			//RefreshCompanyName = new Element("Company Name Label", By.xpath("//*[@class='header-text']/div[2]//*[@class='ng-tns-c27-3 ng-star-inserted']"), this);
			SearchType = new Element("Type Of Search", By.xpath("//*[@class='header-company-analysis expandCompAnalysis']/div[1]"), this);
			ReportSummaryHeader = new Element("Report Summary Header", By.xpath("//*[@class='report-summary']"), this);
			//SideMenuOverview = new Element("Side Menu Overview", By.xpath("//*[@class='header-sidemenu']//*[@class='sidemenuexpanded isShow']/div[2]"), this);
			SideMenuOverview = new Element("Side Menu Overview", By.xpath("//*[@src='../../assets/images/globe-p.svg' or @src='../../assets/images/globe-b.svg']"), this);
			SideMenuCompetitor = new Element("Side Menu Competitor", By.xpath("//*[@src='../../assets/images/users-b.svg' or @src='../../assets/images/users-p.svg']"), this);
			FinancialsLink = new Element("Financials Link", By.xpath("//*[@class='link']"), this);
			FinancialsTitle = new Element("Financials Title", By.xpath("//*[@class='financials-title']"), this);
			PrivateCompReminder = new Element("Private Company Reminder Banner", By.xpath("//*[@class='header-private-info']"), this);
			OverviewDescription = new Element("Overview Description", By.xpath("//*[@class='overview-description-span']"), this);
			OverviewDescription2 = new Element("Overview Description", By.xpath("//*[@class='overview-description-span']/span"), this);
			TRSValue = new Element("TRS Value", By.xpath("(//*[@class='financial-gauge-value'])[1]/span"), this);
			TRSTrendValue = new Element("TRS Trend Value", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[1]/div[1]"), this);
			TRSYear = new Element("TRS Year", By.xpath("(//*[@class='financial-gauge-year'])[1]"), this);
			TRSTrendGreenIcon = new Element("TRS Trend Green Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[1]//*[@class='kpiTrendArrowGreen ng-star-inserted']"), this);
			TRSTrendRedIcon = new Element("TRS Trend Red Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[1]//*[@class='kpiTrendArrowRed ng-star-inserted']"), this);
			RGValue = new Element("Revenue Growth Value", By.xpath("(//*[@class='financial-gauge-value'])[2]/span"), this);
			RGTrendValue = new Element("Revenue Growth Trend Value", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[2]/div[1]"), this);
			RGYear = new Element("RG Year", By.xpath("(//*[@class='financial-gauge-year'])[2]"), this);
			RGTrendGreenIcon = new Element("Revenue Growth Trend Green Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[2]//*[@class='kpiTrendArrowGreen ng-star-inserted']"), this);
			RGTrendRedIcon = new Element("Revenue Growth Trend Red Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[2]//*[@class='kpiTrendArrowRed ng-star-inserted']"), this);
			ROICValue = new Element("Pre-Tax ROIC Value", By.xpath("(//*[@class='financial-gauge-value'])[3]/span"), this);
			ROICTrendValue = new Element("Pre-Tax ROIC Trend Value", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[3]/div[1]"), this);
			ROICYear = new Element("ROIC Year", By.xpath("(//*[@class='financial-gauge-year'])[3]"), this);
			ROICTrendGreenIcon = new Element("Pre-Tax ROIC Trend Green Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[3]//*[@class='kpiTrendArrowGreen ng-star-inserted']"), this);
			ROICTrendRedIcon = new Element("Pre-Tax ROIC Trend Red Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[3]//*[@class='kpiTrendArrowRed ng-star-inserted']"), this);
			EBITValue = new Element("EBIT Margin Value", By.xpath("(//*[@class='financial-gauge-value'])[4]/span"), this);
			EBITTrendValue = new Element("EBIT Margin Trend Value", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[4]/div[1]"), this);
			EBITYear = new Element("EBIT Year", By.xpath("(//*[@class='financial-gauge-year'])[4]"), this);
			EBITTrendGreenIcon = new Element("EBIT Margin Trend Green Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[4]//*[@class='kpiTrendArrowGreen ng-star-inserted']"), this);
			EBITTrendRedIcon = new Element("EBIT Margin Trend Red Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[4]//*[@class='kpiTrendArrowRed ng-star-inserted']"), this);
			CEValue = new Element("Capital Efficiency Value", By.xpath("(//*[@class='financial-gauge-value'])[5]/span"), this);
			CETrendValue = new Element("Capital Efficiency Trend Value", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[5]/div[1]"), this);
			CEYear = new Element("CE Year", By.xpath("(//*[@class='financial-gauge-year'])[5]"), this);
			CETrendGreenIcon = new Element("Capital Efficiency Trend Green Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[5]//*[@class='kpiTrendArrowGreen ng-star-inserted']"), this);
			CETrendRedIcon = new Element("Capital Efficiency Trend Red Icon", By.xpath("(//*[@class='financial-gauge-trend ng-star-inserted'])[5]//*[@class='kpiTrendArrowRed ng-star-inserted']"), this);
			FinancialSummaryNote = new Element("Financial Summary Note", By.xpath("//*[@class='overview-financials-title-notetext']"), this);
			ROICTitle = new Element("ROIC Title", By.xpath("(//*[@class='financial-gauge-title'])[3]"), this);
			RevenueTitle = new Element("Revenue Title", By.xpath("//*[@class='overview-info-left']//*[@class='overview-info-left-cont'][1]//*[@class='overview-info-left-title']"), this);
			RevenueiIcon = new Element("Revenue i Icon", By.xpath("//*[@class='overview-container-info-icon trsTooltipIcon ng-star-inserted']"), this);
			RevenueValue = new Element("Revenue Value", By.xpath("//*[@class='overview-info-left-cont'][1]//*[@class='overview-info-left-text' or @class='overview-info-left-text ng-star-inserted']"), this);
			EmployeesValue = new Element("Employees Value", By.xpath("//*[@class='overview-info-left-cont'][4]//*[@class='overview-info-left-text' or @class='overview-info-left-text ng-star-inserted']"), this);
			Industry = new Element("Industry", By.xpath("//*[@class='overview-info-right-text ng-star-inserted']//span"), this);
			Website = new Element("Website", By.xpath("//*[@class='overview-info-right-cont ng-star-inserted']//*[@class='overview-info-right-text']"), this);
			Headquarters = new Element("Headquarters", By.xpath("(//*[@class='overview-info-right-text'])[2]//span"), this);
			Type = new Element("Type", By.xpath("(//*[@class='overview-info-right-text'])[1]//span"), this);
			ClientFocus = new Element("Client Focus", By.xpath("//*[@class='report-note-text']"), this);
			RefineCriteriaLink = new Element("Refine Criteria Link", By.xpath("//*[@class='report-disclaimer-refine']"), this);
			EBITMarginTitle = new Element("EBIT Margin Title", By.xpath("//*[@class='overview-info-left']//*[@class='overview-info-left-cont'][2]//*[@class='overview-info-left-title']"), this);
			EBITMarginValue = new Element("EBIT Margin Value", By.xpath("//*[@class='overview-info-left-cont'][2]//*[@class='overview-info-left-text' or @class='overview-info-left-text ng-star-inserted']"), this);
			EnterpriseValueTitle = new Element("Enterprise Value Title", By.xpath("//*[@class='overview-info-left']//*[@class='overview-info-left-cont'][3]//*[@class='overview-info-left-title']"), this);
			EnterpriseValue = new Element("Enterprise Value", By.xpath("//*[@class='overview-info-left-cont'][3]//*[@class='overview-info-left-text' or @class='overview-info-left-text ng-star-inserted']"), this);
			RBBPieChart = new Element("Revenue by Business Pie Chart", By.xpath("//*[normalize-space(text())='Revenue by Business']"), this);
			RBBPieChartTitle = new Element("Revenue by Business Pie Chart Title", By.xpath("(//*[@class='piechart-title' or @class='piechart-title ng-star-inserted'])[1]"), this);
			RBBPieChartTimePeriod = new Element("Revenue by Business Pie Chart Time Period", By.xpath("(//*[@class='piechart-subtitle' or @class='piechart-subtitle ng-star-inserted'])[1]"), this);
			RBBPieChartLegendIcon1 = new Element("Revenue by Business Pie Chart Legend Icon 1", By.xpath("(//*[@class='piechart-legend-color'])[1]"), this);
			RBBPieChartLegendIcon2 = new Element("Revenue by Business Pie Chart Legend Icon 2", By.xpath("(//*[@class='piechart-legend-color'])[2]"), this);
			RBBPieChartLegendText1 = new Element("Revenue by Business Pie Chart Legend Text 1", By.xpath("(//*[@class='piechart-legend-company'])[1]"), this);
			RBBPieChartLegendText2 = new Element("Revenue by Business Pie Chart Legend Text 2", By.xpath("(//*[@class='piechart-legend-company'])[2]"), this);
			RBBPieChartLegendTooltip = new Element("Revenue by Business Pie Chart Legend Tooltip", By.xpath("//*[@class='tooltip ng-star-inserted']"), this);
			RBGPieChart = new Element("Revenue by Geography Pie Chart", By.xpath("//*[normalize-space(text())='Revenue by Geography']"), this);
			RBGPieChartTitle = new Element("Revenue by Geography Pie Chart Title", By.xpath("(//*[@class='piechart-title' or @class='piechart-title ng-star-inserted'])[2]"), this);
			RBGPieChartTimePeriod = new Element("Revenue by Geography Pie Chart Time Period", By.xpath("(//*[@class='piechart-subtitle' or @class='piechart-subtitle ng-star-inserted'])[2]"), this);
			RBGPieChartLegendIcon1 = new Element("Revenue by Geography Pie Chart Legend Icon 1", By.xpath("(//*[@class='piechart-legend-color'])[3]"), this);
			RBGPieChartLegendIcon2 = new Element("Revenue by Geography Pie Chart Legend Icon 2", By.xpath("(//*[@class='piechart-legend-color'])[4]"), this);
			RBGPieChartLegendText1 = new Element("Revenue by Geography Pie Chart Legend Text 1", By.xpath("(//*[@class='piechart-legend-company'])[3]"), this);
			RBGPieChartLegendText2 = new Element("Revenue by Geography Pie Chart Legend Text 2", By.xpath("(//*[@class='piechart-legend-company'])[4]"), this);
			RBGPieChartLegendTooltip = new Element("Revenue by Geography Pie Chart Legend Tooltip", By.xpath("//*[@class='tooltip ng-star-inserted']"), this);
			TRSTrend = new Element("TRS Trend", By.xpath("(//*[@class='financial-gauge-label'])[1]"), this);
			RGTrend = new Element("Revenue Growth Trend", By.xpath("(//*[@class='financial-gauge-label'])[2]"), this);
			ROICTrend = new Element("Pre Tax ROIC Trend", By.xpath("(//*[@class='financial-gauge-label'])[3]"), this);
			EBITMarginTrend = new Element("EBIT Margin Trend", By.xpath("(//*[@class='financial-gauge-label'])[4]"), this);
			CapEffTrend = new Element("Capital Efficiency Trend", By.xpath("(//*[@class='financial-gauge-label'])[5]"), this);
			ToasterMessage = new Element("Toaster Message", By.xpath("//*[@class='toast-message ng-star-inserted']"), this);
			ToasterMessageWait = new Element("Toaster Message - Wait", By.xpath("//*[@class='toast-message ng-star-inserted']"), this);
			ToasterMessageDownloaded = new Element("Toaster Message - Downloaded", By.xpath("//*[@class='toast-message ng-star-inserted']"), this);
			ToasterMessageCloseButton = new Element("Toaster Message - Close Button", By.xpath("//*[@id='toast-container']//*[@aria-label='Close']"), this);
			TooltipText = new Element("Tooltip Text", By.xpath("//*[@class='tooltip-text']"), this);
			TooltipTextClick = new Element("Tooltip Text when Clicked", By.xpath("//*[@class='tooltip-text ng-star-inserted']"), this);
			KeyInsights1 = new Element("Key Insights - 1st Bullet", By.xpath("//*[@class='keyinsights-list']//*[@class='keyinsights-blocks ng-star-inserted'][1]//*[@class='keyinsights-blocks-item']"), this);
			KeyInsights2 = new Element("Key Insights - 2nd Bullet", By.xpath("//*[@class='keyinsights-list']//*[@class='keyinsights-blocks ng-star-inserted'][2]//*[@class='keyinsights-blocks-item']"), this);
			KeyInsights3 = new Element("Key Insights - 3rd Bullet", By.xpath("//*[@class='keyinsights-list']//*[@class='keyinsights-blocks ng-star-inserted'][3]//*[@class='keyinsights-blocks-item']"), this);
			KeyInsights4 = new Element("Key Insights - 4th Bullet", By.xpath("//*[@class='keyinsights-list']//*[@class='keyinsights-blocks ng-star-inserted'][4]//*[@class='keyinsights-blocks-item']"), this);
			KeyInsights5 = new Element("Key Insights - 5th Bullet", By.xpath("//*[@class='keyinsights-list']//*[@class='keyinsights-blocks ng-star-inserted'][5]//*[@class='keyinsights-blocks-item']"), this);
			FinancialsSummaryContainer = new Element("Financials Summary Container", By.xpath("//*[@class='overview-financials-gauge-container ng-star-inserted' or @class='overview-financials-gauge-container']"), this);
			
		}
	}
}