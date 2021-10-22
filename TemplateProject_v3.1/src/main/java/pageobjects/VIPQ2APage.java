package pageobjects;

import org.openqa.selenium.By;

import auto.framework.PageBase;
import auto.framework.web.Element;


public class VIPQ2APage extends PageBase {

	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		//Common
		public final Element BurgerMenu;
		public final Element SideMenuFinancialsClick;
		public final Element SelectDashboardDropDown;
		public final Element DropDownMainHeader1;
		public final Element DropDownMainHeader2;
		public final Element DropDownMainHeader3;
		public final Element DropDownMainHeader4;
		public final Element DropDownMainHeader5;
		public final Element DropDownMainHeader6;
		public final Element SelectDropDown1;
		public final Element SelectDropDown2;
		public final Element SelectDropDown3;
		public final Element SelectDropDown4;
		public final Element SelectDropDown5;
		public final Element SelectDropDown6;
		public final Element SelectDropDown7;
		public final Element SelectDropDown8;
		public final Element SelectDropDown9;
		public final Element SelectDropDown10;
		public final Element SelectDropDown11;
		public final Element SelectDropDown12;
		public final Element SelectDropDown13;
		public final Element SelectDropDown14;
		public final Element IsPrivateCompany;
		
		//TRS
		public final Element TotalReturnToShareHolders;
		public final Element LeftChartTitle;
		public final Element TimePeriodLineChart;
		public final Element TRSInfoIcon;
		public final Element TimePeriodBarChart;
		public final Element TRSFootNoteCompanies;
		public final Element TRSKeyInsightsTitle;
		public final Element TRSKeyInsightsRedDot;
		public final Element TRSKeyInsightsGreenDot;
		public final Element SelectTimeframe;
		public final Element YearTRS;
		public final Element RightChartTitle;
		public final Element DropdownList1;
		public final Element DropdownList3;
		public final Element LeftChartContainer;
		public final Element RightChartContainer;
		public final Element TRSInfoIconText;
		
		//EVICDecomp
		public final Element EvicChartTitle;
		public final Element EvicInfoIcon;
		public final Element EVEbitTitle;
		public final Element EVEbitInfoIcon;
		public final Element EbitICTitle;
		public final Element EbitICInfoIcon;
		public final Element FChartIcon;
		public final Element XChartIcon;
		public final Element EvicDate;
		public final Element EVEbitDate;
		public final Element EbitICDate;
		public final Element EVEbitICContainer;
		public final Element EvicFootNoteCompanies;
		public final Element EvicKeyInsightsTitle;
		public final Element EvicKeyInsightsGreenDot;
		public final Element EvicKeyInsightsRedDot;
		public final Element EvicKeyInsightsStarDot;
		public final Element EvicInfoIconText;
		
		//AnalystRecommendations
		public final Element AnalystLeftChartContainer;
		public final Element AnalystLeftChartDate;
		public final Element AnalystLeftChartInfoIcon;
		public final Element AnalystLeftChartLegend;
		public final Element AnalystRightChartContainer;
		public final Element AnalystRightChartDate;
		public final Element AnalystRightChartInfoIcon;
		public final Element AnalystRightChartLegend;		
		public final Element AnalystFootNoteCompanies;
		public final Element AnalystKeyInsightsGreenDot;
		public final Element AnalystKeyInsightsRedDot;
		public final Element AnalystKeyInsightsStarDot;
		public final Element AnalystInfoIconText;
		
		//RevenueandProfitabilityEstimates
		public final Element RPELeftChartContainer;
		public final Element RPELeftChartDate;
		public final Element RPELeftChartInfoIcon;
		public final Element RPELeftChartLegend;
		public final Element RPERightChartContainer;
		public final Element RPERightChartDate;
		public final Element RPERightChartLegend;
		public final Element RPEFootNoteForecast;
		public final Element RPEKeyInsightsGreenDot;
		public final Element RPEKeyInsightsRedDot;
		public final Element RPEKeyInsightsStarDot;
		public final Element RPEInfoIconText;
		public final Element RPEKeyInsightsTitle;
		
		//EmployeeProductivity
		public final Element EmpProdBarChart1;
		public final Element EmpProdCurrency1;
		public final Element EmpProdBarChart2;
		public final Element EmpProdCurrency2;
		public final Element EmpProdBarChart3;
		public final Element EmpProdCurrencyTTM;
		public final Element EmpProdLegend;
		public final Element EmpProdFootNoteCompanies;
		public final Element EmpProdEKeyInsightsGreenDot;
		public final Element EmpProdKeyInsightsRedDot;
		public final Element EmpProdKeyInsightsStarDot;
		public final Element EmpProdKeyInsightsTitle;
		
		//CompetitivenessScorecard
		public final Element ScorecardBestandRank; 
	    public final Element ScorecardBestandRankCheckbox; 
	    public final Element ScorecardMetricTitle;
	    public final Element ScorecardPercentileTitle;
	    public final Element ScorecardCompanyTitle;
	    public final Element ScorecardPeerMedianTitle;
	    public final Element ScorecardBestTitle; 
	    public final Element ScorecardRankTitle; 
	    public final Element Scorecard2YrChangeTitle; 
	    public final Element ScoreCardDate; 
	    public final Element ScorecardMetric1;
	    public final Element ScorecardMetric1InfoIcon;
	    public final Element ScorecardSubMetric1a;
	    public final Element ScorecardSubMetric1b;
	    public final Element ScorecardSubMetric1c;
	    public final Element ScorecardMetric2;
	    public final Element ScorecardSubMetric2a;
	    public final Element ScorecardSubMetric2aInfoIcon;
	    public final Element ScorecardSubMetric2b;
	    public final Element ScorecardSubMetric2bInfoIcon;
	    public final Element ScorecardSubMetric2c;
	    public final Element ScorecardSubMetric2cInfoIcon;
	    public final Element ScorecardSubMetric2d;
	    public final Element ScorecardSubMetric2dInfoIcon;
	    public final Element ScorecardMetric3;
	    public final Element ScorecardSubMetric3a;
	    public final Element ScorecardSubMetric3aInfoIcon;
	    public final Element ScorecardSubMetric3b;
	    public final Element ScorecardSubMetric3bInfoIcon;
	    public final Element ScorecardMetric4;
	    public final Element ScorecardSubMetric4a;
	    public final Element ScorecardSubMetric4b;
	    public final Element ScorecardSubMetric4c;
	    public final Element ScorecardMetric5;
	    public final Element ScorecardSubMetric5a;
	    public final Element ScorecardSubMetric5aInfoIcon;
	    public final Element ScorecardSubMetric5b;
	    public final Element ScorecardSubMetric5bInfoIcon;
	    public final Element ScorecardSubMetric5c;
	    public final Element ScorecardSubMetric5cInfoIcon;
	    public final Element ScorecardMetric6;
	    public final Element ScorecardSubMetric6a;
	    public final Element ScorecardSubMetric6aInfoIcon;
	    public final Element ScorecardSubMetric6b;
	    public final Element ScorecardSubMetric6bInfoIcon;
		public final Element ScorecardMetric7;
	    public final Element ScorecardSubMetric7a;
	    public final Element ScorecardSubMetric7aInfoIcon;
	    public final Element ScorecardSubMetric7b;
	    public final Element ScorecardSubMetric7bInfoIcon;
	    public final Element ScorecardSubMetric7c;
	    public final Element ScorecardSubMetric7cInfoIcon;
	    public final Element ScorecardMetric8;
	    public final Element ScorecardSubMetric8a;
	    public final Element ScorecardSubMetric8aInfoIcon;
	    public final Element ScorecardSubMetric8b;
	    public final Element ScorecardSubMetric8bInfoIcon;
	    public final Element ScorecardSubMetric8c;
	    public final Element ScorecardSubMetric8cInfoIcon;
	    public final Element ScorecardMetricDivider1;
	    public final Element ScorecardMetricDivider2;
	    public final Element ScorecardMetricDivider3;
	    public final Element ScorecardMetricDivider4;
	    public final Element ScorecardMetricDivider5;
	    public final Element ScorecardMetricDivider6;
	    public final Element ScorecardMetricDivider7;
	    public final Element ScorecardMetricDivider8;
	    public final Element ScorecardFootNoteCompanies;
	    
		
			
	
	public Contents() {
		super("Container", By.className("mainContainer"));
		
		//Common
		BurgerMenu = new Element("Burger Menu", By.xpath("//*[@class='sidemenuexpanded-companalysis isShow']"), this);
		SideMenuFinancialsClick = new Element("Financials Side Menu", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[4]"), this);
		SelectDashboardDropDown = new Element("Select Dashboard", By.xpath("//*[@id='dropdownBasic1']"), this);
		DropDownMainHeader1 = new Element("Executive Summary", By.xpath("(//*[@class='dropdown-mainheader'])[1]"), this);
		SelectDropDown1 = new Element("Competitiveness Scorecard", By.xpath("//*[@id='Competitiveness Scorecard']"), this);
		DropDownMainHeader2 = new Element("Investor Expectations", By.xpath("(//*[@class='dropdown-mainheader'])[2]"), this);
		SelectDropDown2 = new Element("Total Return to Shareholders", By.xpath("//*[@id='Total Return to Shareholders']"), this);
		SelectDropDown3 = new Element("Enterprise Value to Invested Capital Decomposition", By.xpath("//*[@id='Enterprise Value to Invested Capital Decomposition']"), this);
		SelectDropDown4 = new Element("Analyst Recommendations", By.xpath("//*[@id='Analyst Recommendations']"), this);
		SelectDropDown5 = new Element("Revenue and Profitability Estimates", By.xpath("//*[@id='Revenue and Profitability Estimates']"), this);
		DropDownMainHeader3 = new Element("Growth Indicators", By.xpath("(//*[@class='dropdown-mainheader'])[3]"), this);
		SelectDropDown6 = new Element("Revenue Growth", By.xpath("//*[@id='Revenue Growth']"), this);
		SelectDropDown7 = new Element("Employee Productivity", By.xpath("//*[@id='Employee Productivity']"), this);
		DropDownMainHeader4 = new Element("Operating Performance", By.xpath("(//*[@class='dropdown-mainheader'])[4]"), this);
		SelectDropDown8 = new Element("Pre-Tax ROIC Decomposition", By.xpath("//*[@id='Pre-Tax ROIC Decomposition']"), this);
		SelectDropDown9 = new Element("Operating Working Capital Decomposition", By.xpath("//*[@id='Operating Working Capital Decomposition']"), this);
		SelectDropDown10 = new Element("Cash Cycle Analysis", By.xpath("//*[@id='Cash Cycle Analysis']"), this);
		DropDownMainHeader5 = new Element("Segment Analysis", By.xpath("(//*[@class='dropdown-mainheader'])[5]"), this);
		SelectDropDown11 = new Element("Business Segment Analysis", By.xpath("//*[@id='Business Segment Analysis']"), this);
		SelectDropDown12 = new Element("Geographic Segment Analysis", By.xpath("//*[@id='Geographic Segment Analysis']"), this);
		DropDownMainHeader6 = new Element("Appendix", By.xpath("(//*[@class='dropdown-mainheader'])[6]"), this);
		SelectDropDown13 = new Element("Glossary", By.xpath("//*[@id='Glossary']"), this);
		SelectDropDown14 = new Element("Methodology", By.xpath("//*[@id='Methodology']"), this);
		IsPrivateCompany = new Element("Validate if Private Company", By.xpath("//*[@class='financials-message ng-star-inserted']"), this);
		
		
		//TRS
		TotalReturnToShareHolders = new Element("Total Return to Shareholders", By.xpath("//*[normalize-space(text())='Total Return to Shareholders']"), this);
		SelectTimeframe = new Element ("Timeframe Dropdown", By.xpath("//*[@id='button-basic']"), this);
		YearTRS = new Element("Year TRS", By.xpath("//*[@class='btntext']"), this);
		DropdownList1 = new Element("1-year TRS", By.xpath("(//*[@class='dropdown-list ng-star-inserted'])[1]"), this);
		DropdownList3 = new Element("5-year TRS", By.xpath("(//*[@class='dropdown-list ng-star-inserted'])[2]"), this);
		LeftChartContainer = new Element("Line Chart Container", By.xpath("//*[@class='qv-chart-main-linechart-cont']"), this);
		RightChartContainer = new Element("Bar Chart Container", By.xpath("//*[@class='qv-chart-main-barchart-cont']"), this);		
		LeftChartTitle = new Element("Line Chart Title", By.xpath("//*[@class='qv-chart-main-title-linechartv2']"), this);
		TimePeriodLineChart = new Element("Line Chart Date", By.xpath("//*[@class='qv-chart-main-timeperiod-linechart']"), this);
		TRSInfoIcon = new Element("Info Icon", By.xpath("//*[@class='qvchart-container-info']"), this);
		TRSInfoIconText = new Element("Info icon tooltip text", By.xpath("//*[@class='tooltip-text']"), this);
		RightChartTitle  = new Element("Bar Chart Title", By.xpath("//*[@class='qv-chart-main-title-barchartv2']"), this);
		TimePeriodBarChart = new Element("Bar Chart Date", By.xpath("//*[@class='qv-chart-main-timeperiod-barchart']"), this);
		TRSFootNoteCompanies = new Element("TRS Footnote Companies removed", By.xpath("//*[@class='qv-footnote ng-star-inserted']//*[@class='ng-star-inserted']//*[@class='ng-star-inserted']"), this);
	    TRSKeyInsightsTitle = new Element("TRS Key Insights", By.xpath("//*[@class='qv-keyinsights-title ng-star-inserted']"), this);
	    TRSKeyInsightsRedDot= new Element("TRS Competitive Position Red Dot", By.xpath("//*[@class='star-red ng-star-inserted']"), this);
	    TRSKeyInsightsGreenDot= new Element("TRS Competitive Position Green Dot", By.xpath("//*[@class='star-green ng-star-inserted']"), this);
	
	    //EVICDecomp
	    EvicChartTitle = new Element("Premium on Invested Capital (EV/IC)", By.xpath("//*[@class='evic-chart-year']"), this);
	    EvicInfoIcon = new Element("EV/IC Info Icon", By.xpath("//*[@class='evicchart-container-info']"), this);
	    EvicInfoIconText = new Element("Info icon tooltip text", By.xpath("//*[@class='tooltip-text']"), this);
	    EvicDate = new Element("EV/IC Time Period", By.xpath("(//*[@class='evic-chart-period'])[1]"), this);
	    EVEbitTitle = new Element("EV/EBIT", By.xpath("(//*[@class='evic-chart-year-evebit'])[1]"), this);
	    EVEbitInfoIcon = new Element("EV/EBIT Info Icon", By.xpath("//*[@class='evicchart-container-info-x']"), this);
	    EVEbitDate = new Element("EV/EBIT Time Period", By.xpath("(//*[@class='evic-chart-period'])[2]"), this);
	    EbitICTitle = new Element("PRE-TAX ROIC (EBIT/IC)", By.xpath("(//*[@class='evic-chart-year-evebit'])[2]"), this);
	    EbitICInfoIcon = new Element("EBIT/IC Info Icon", By.xpath("//*[@class='evicchart-container-info-pt']"), this);
	    EbitICDate = new Element("EBIT/IC Time Period", By.xpath("(//*[@class='evic-chart-period'])[3]"), this);
	    FChartIcon = new Element("f icon", By.xpath("//*[@class='evic-chart-f']"), this);
	    XChartIcon = new Element("x icon", By.xpath("//*[@class='evic-chart-x']"), this);
	    EVEbitICContainer = new Element("EV/EBIT EBIT/IC Container", By.xpath("//*[@class='evic-rhs-container']"), this);
	    EvicFootNoteCompanies = new Element("EvicDecomp Footnote Companies removed", By.xpath("//*[@class='qv-footnote ng-star-inserted']//*[@class='ng-star-inserted']//*[@class='ng-star-inserted']"), this);
	    EvicKeyInsightsTitle = new Element("EvicDecomp Key Insights", By.xpath("//*[@class='qv-keyinsights-title ng-star-inserted']"), this);
	    EvicKeyInsightsGreenDot = new Element("EvicDecomp Competitive Position Green Dot", By.xpath("//*[@class='star-green ng-star-inserted']"), this);
	    EvicKeyInsightsRedDot = new Element("EvicDecomp Competitive Position Red Dot", By.xpath("//*[@class='star-red ng-star-inserted']"), this);
	    EvicKeyInsightsStarDot = new Element("EvicDecomp Competitive Position Star Dot", By.xpath("//*[@class='qv-keyinsights-list ng-star-inserted']//img[@class='star']"), this);
	
	    //AnalystRecommendations
	    AnalystLeftChartContainer = new Element("Analyst Ratings Container", By.xpath("//*[@class='analystrecom-lhs-container']"), this);
	    AnalystLeftChartDate = new Element("Analyst Ratings Time Period", By.xpath("//*[@class='chart-timeperiod']"), this);
	    AnalystLeftChartInfoIcon = new Element("Analyst Ratings Info Icon", By.xpath("//*[@class='analyst-container-info-ar']//img[@class='analyst-container-info-icon']"), this);
	    AnalystLeftChartLegend = new Element("Analyst Ratings Legend", By.xpath("//*[@class='chart-legend']"), this);
	    AnalystRightChartContainer = new Element("Share Price Growth Container", By.xpath("//*[@class='analystrecom-rhs-container']"), this);
	    AnalystRightChartDate = new Element("Share Price Growth Time Period", By.xpath("//*[@class='rhs-chart-timeperiod']"), this);
	    AnalystRightChartInfoIcon = new Element("Share Price Growth Info Icon", By.xpath("//*[@class='analyst-container-info-epg']//img[@class='analyst-container-info-icon']"), this);
	    AnalystRightChartLegend = new Element("Share Price Growth Legend", By.xpath("//*[@class='rhs-chart-legend']"), this);
	    AnalystInfoIconText = new Element("Info icon tooltip text", By.xpath("//*[@class='tooltip-text']"), this);
	    //dynamic
	    AnalystFootNoteCompanies = new Element("Analyst Reco Footnote Companies removed", By.xpath("//*[@class='qv-footnote ng-star-inserted']//*[@class='ng-star-inserted']//*[@class='ng-star-inserted']"), this);
	    AnalystKeyInsightsGreenDot = new Element("Analyst Reco Green Dot", By.xpath("//*[@class='star-green ng-star-inserted']"), this);
	    AnalystKeyInsightsRedDot = new Element("Analyst Reco Red Dot", By.xpath("//*[@class='star-red ng-star-inserted']"), this);
	    AnalystKeyInsightsStarDot = new Element("Analyst Reco Star Dot", By.xpath("//*[@class='qv-keyinsights-list ng-star-inserted']//img[@class='star']"), this);
	
	    //RevenueandProfitabilityEstimates
	    RPELeftChartContainer = new Element("REVENUE YOY GROWTH ESTIMATES Container", By.xpath("//*[@class='revebitestimates-lhs-container']"), this);
	    RPELeftChartDate = new Element("REVENUE YOY GROWTH ESTIMATES Time Period", By.xpath("(//*[@class='chart-timeperiod'])[1]"), this);
	    RPELeftChartInfoIcon = new Element("REVENUE YOY GROWTH ESTIMATES Info Icon", By.xpath("//*[@class='rev-container-info-cash']//img[@class='re-container-info-icon outline']"), this);
	    RPELeftChartLegend = new Element("REVENUE YOY GROWTH ESTIMATES Legend", By.xpath("(//*[@class='chart-legend'])[1]"), this);
	    RPERightChartContainer = new Element("REVENUE CAGR Container", By.xpath("//*[@class='revebitestimates-rhs-container']"), this);
	    RPERightChartDate = new Element("REVENUE CAGR Time Period", By.xpath("(//*[@class='chart-timeperiod'])[2]"), this);
	    RPERightChartLegend = new Element("REVENUE CAGR Legend", By.xpath("(//*[@class='chart-legend'])[2]"), this);
	    RPEFootNoteForecast = new Element("RPE Footnote Forecast date", By.xpath("//*[@class='qv-footnote ng-star-inserted']//*[@class='ng-star-inserted']//*[@class='ng-star-inserted']"), this);
	    RPEKeyInsightsTitle = new Element("RPE Key Insights Title", By.xpath("//*[@class='qv-keyinsights-title ng-star-inserted']"), this);
	    RPEKeyInsightsGreenDot = new Element("RPE Key Insights Green Dot", By.xpath("//*[@class='star-green ng-star-inserted']"), this);
	    RPEKeyInsightsRedDot = new Element("RPE Key Insights Red Dot", By.xpath("//*[@class='star-red ng-star-inserted']"), this);
	    RPEKeyInsightsStarDot = new Element("RPE Key Insights Star Dot", By.xpath("//*[@class='qv-keyinsights-list ng-star-inserted']//img[@class='star']"), this);
	    RPEInfoIconText = new Element("Info icon tooltip text", By.xpath("//*[@class='tooltip-text']"), this);
	    	    
	    //EmployeeProductivity
	    EmpProdBarChart1 = new Element("Bar chart 1", By.xpath("(//*[@class='empprod-chart-barchartperyear ng-star-inserted'])[1]"), this);
	    EmpProdCurrency1 = new Element("Bar chart 1 000 Currency", By.xpath("(//*[@class='empprod-chart-period'])[1]"), this);
	    EmpProdBarChart2 = new Element("Bar chart 2", By.xpath("(//*[@class='empprod-chart-barchartperyear ng-star-inserted'])[2]"), this);
	    EmpProdCurrency2 = new Element("Bar chart 2 000 Currency", By.xpath("(//*[@class='empprod-chart-period'])[2]"), this);
	    EmpProdBarChart3 = new Element("Bar chart TTM", By.xpath("(//*[@class='empprod-chart-barchartperyear ng-star-inserted'])[3]"), this);
	    EmpProdCurrencyTTM = new Element("Bar chart TTM 000 Currency", By.xpath("(//*[@class='empprod-chart-period'])[3]"), this);
	    EmpProdLegend = new Element("Employee Productivity Legend", By.xpath("(//*[@class='empprod-header']//*[@class='empprod-legend-container'])[1]"), this);
	    EmpProdFootNoteCompanies = new Element("Emp Prod Footnote Companies with no data", By.xpath("//*[@class='qv-footnote ng-star-inserted']//*[@class='ng-star-inserted']//*[@class='ng-star-inserted']"), this);
	    EmpProdKeyInsightsTitle  = new Element("Emp Prod Key Insights Title", By.xpath("//*[@class='qv-keyinsights-title ng-star-inserted']"), this); 
	    EmpProdEKeyInsightsGreenDot = new Element("Emp Prod Key Insights Green Dot", By.xpath("//*[@class='star-green ng-star-inserted']"), this);
	    EmpProdKeyInsightsRedDot = new Element("Emp Prod Key Insights Red Dot", By.xpath("//*[@class='star-red ng-star-inserted']"), this);
	    EmpProdKeyInsightsStarDot = new Element("Emp Prod Key Insights Star Dot", By.xpath("//*[@class='qv-keyinsights-list ng-star-inserted']//img[@class='star']"), this);
	
	    //CompetitivenessScorecard
	    ScorecardBestandRank = new Element("Show Best and Rank", By.xpath("//*[@class='select-note-indicator-scorecards ng-star-inserted']"), this);
	    ScorecardBestandRankCheckbox = new Element("Show Best and Rank Checkbox", By.xpath("//*[@class='select-note-indicator-scorecards ng-star-inserted']//*[@type='checkbox']"), this); 
	    ScorecardMetricTitle = new Element("METRIC Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-metric']"), this);
	    ScorecardPercentileTitle = new Element("PERCENTILE Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-percentile']"), this);
	    ScorecardCompanyTitle = new Element("Target Company Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-target2 ng-star-inserted']"), this);
	    ScorecardPeerMedianTitle = new Element("PEER MEDIAN Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-peermedian2']"), this);
	    ScorecardBestTitle = new Element("BEST Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-best ng-star-inserted']"), this);
	    ScorecardRankTitle = new Element("RANK Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-rank ng-star-inserted']"), this);
	    Scorecard2YrChangeTitle = new Element("2 YEAR CHANGE Header", By.xpath("//*[@class='scorecards-header']//*[@class='scorecards-title-yoy2']"), this);
	    ScoreCardDate = new Element("Competitiveness Scorecard Time Period", By.xpath("//*[@class='ttm']"), this);
	    ScorecardMetric1 = new Element("TRS DEVELOPMENT", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[1]"), this);
	    ScorecardMetric1InfoIcon = new Element("TRS DEVELOPMENT Info icon", By.xpath("//img[@class='score-container-info-icon trsTooltipIcon ng-star-inserted']"), this);
	    ScorecardSubMetric1a = new Element("5-year Total Return to Shareholders", By.xpath("(//*[@class='scorecards-kpi-metric'])[1]"), this);
	    ScorecardSubMetric1b = new Element("3-year Total Return to Shareholders", By.xpath("(//*[@class='scorecards-kpi-metric'])[2]"), this);
	    ScorecardSubMetric1c = new Element("1-year Total Return to Shareholders", By.xpath("(//*[@class='scorecards-kpi-metric'])[3]"), this);
	    ScorecardMetric2 = new Element("ANALYST OUTLOOK", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[2]"), this);
	    ScorecardSubMetric2a = new Element("Buy %", By.xpath("(//*[@class='scorecards-kpi-metric'])[4]"), this);
	    ScorecardSubMetric2aInfoIcon = new Element("Buy % Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[1]"), this);
	    ScorecardSubMetric2b = new Element("1-year Share Price Growth", By.xpath("(//*[@class='scorecards-kpi-metric'])[5]"), this);
	    ScorecardSubMetric2bInfoIcon = new Element("1-year Share Price Growth Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[2]"), this);
	    ScorecardSubMetric2c = new Element("2-year Revenue Growth CAGR", By.xpath("(//*[@class='scorecards-kpi-metric'])[6]"), this);
	    ScorecardSubMetric2cInfoIcon = new Element("2-year Revenue Growth CAGR Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[3]"), this);
	    ScorecardSubMetric2d = new Element("2-year EBIT Margin Delta", By.xpath("(//*[@class='scorecards-kpi-metric'])[7]"), this);
	    ScorecardSubMetric2dInfoIcon = new Element("2-year EBIT Margin Delta Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[4]"), this);
	    ScorecardMetric3 = new Element("INVESTOR EXPECTATIONS", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[3]"), this);
	    ScorecardSubMetric3a = new Element("Invested Capital Premium (EV/IC)", By.xpath("(//*[@class='scorecards-kpi-metric'])[8]"), this);
	    ScorecardSubMetric3aInfoIcon = new Element("Invested Capital Premium (EV/IC) Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[5]"), this);
	    ScorecardSubMetric3b = new Element("EV/EBIT", By.xpath("(//*[@class='scorecards-kpi-metric'])[9]"), this);
	    ScorecardSubMetric3bInfoIcon = new Element("EV/EBIT Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[6]"), this);
	    ScorecardMetric4 = new Element("REVENUE GROWTH", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[4]"), this);
	    ScorecardSubMetric4a = new Element("5-year Revenue CAGR", By.xpath("(//*[@class='scorecards-kpi-metric'])[10]"), this);
	    ScorecardSubMetric4b = new Element("3-year Revenue CAGR", By.xpath("(//*[@class='scorecards-kpi-metric'])[11]"), this);
	    ScorecardSubMetric4c = new Element("1-year Revenue Growth", By.xpath("(//*[@class='scorecards-kpi-metric'])[12]"), this);
	    ScorecardMetric5 = new Element("PRE-TAX ROIC DECOMPOSITION", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[5]"), this);
	    ScorecardSubMetric5a = new Element("ROIC (Pre-Tax)", By.xpath("(//*[@class='scorecards-kpi-metric'])[13]"), this);
	    ScorecardSubMetric5aInfoIcon = new Element("ROIC (Pre-Tax) Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[7]"), this);
	    ScorecardSubMetric5b = new Element("EBIT Margin", By.xpath("(//*[@class='scorecards-kpi-metric'])[14]"), this);
	    ScorecardSubMetric5bInfoIcon = new Element("EBIT Margin Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[8]"), this);
	    ScorecardSubMetric5c = new Element("Capital Efficiency", By.xpath("(//*[@class='scorecards-kpi-metric'])[15]"), this);
	    ScorecardSubMetric5cInfoIcon = new Element("Capital Efficiency Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[9]"), this);
	    ScorecardMetric6 = new Element("EBIT MARGIN DECOMPOSITION", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[6]"), this);
	    ScorecardSubMetric6a = new Element("Cost of Goods Sold", By.xpath("(//*[@class='scorecards-kpi-metric'])[16]"), this);
	    ScorecardSubMetric6aInfoIcon = new Element("Cost of Goods Sold Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[10]"), this);
	    ScorecardSubMetric6b = new Element("Selling, General & Administrative Expenses", By.xpath("(//*[@class='scorecards-kpi-metric'])[17]"), this);
	    ScorecardSubMetric6bInfoIcon = new Element("Selling, General & Administrative Expenses Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[11]"), this);
	    ScorecardMetric7 = new Element("INVESTED CAPITAL DECOMPOSITION", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[7]"), this);
	    ScorecardSubMetric7a = new Element("Operating Working Capital", By.xpath("(//*[@class='scorecards-kpi-metric'])[18]"), this);
	    ScorecardSubMetric7aInfoIcon = new Element("Operating Working Capital Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[12]"), this);
	    ScorecardSubMetric7b = new Element("Property, Plant & Equipment", By.xpath("(//*[@class='scorecards-kpi-metric'])[19]"), this);
	    ScorecardSubMetric7bInfoIcon = new Element("Property, Plant & Equipment Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[13]"), this);
	    ScorecardSubMetric7c = new Element("Goodwill & Intangibles", By.xpath("(//*[@class='scorecards-kpi-metric'])[20]"), this);
	    ScorecardSubMetric7cInfoIcon = new Element("Goodwill & Intangibles Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[14]"), this);
	    ScorecardMetric8 = new Element("WORKING CAPITAL DECOMPOSITION", By.xpath("(//*[@class='scorecards-kpi-maintitle']//*[@class='scorecards-kpi-title'])[8]"), this);
	    ScorecardSubMetric8a = new Element("Net Receivables", By.xpath("(//*[@class='scorecards-kpi-metric'])[21]"), this);
	    ScorecardSubMetric8aInfoIcon = new Element("Net Receivables Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[15]"), this);
	    ScorecardSubMetric8b = new Element("Inventory", By.xpath("(//*[@class='scorecards-kpi-metric'])[22]"), this);
	    ScorecardSubMetric8bInfoIcon = new Element("Inventory Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[16]"), this);
	    ScorecardSubMetric8c = new Element("Accounts Payable", By.xpath("(//*[@class='scorecards-kpi-metric'])[23]"), this);
	    ScorecardSubMetric8cInfoIcon = new Element("Accounts Payable Info Icon", By.xpath("(//*[@class='score-container-info']//img[@class='score-container-info-icon ng-star-inserted'])[17]"), this);
	    ScorecardMetricDivider1 = new Element("Metric 1 Divider", By.xpath("(//*[@class='divider'])[1]"), this);
	    ScorecardMetricDivider2 = new Element("Metric 2 Divider", By.xpath("(//*[@class='divider'])[2]"), this);
	    ScorecardMetricDivider3 = new Element("Metric 3 Divider", By.xpath("(//*[@class='divider'])[3]"), this);
	    ScorecardMetricDivider4 = new Element("Metric 4 Divider", By.xpath("(//*[@class='divider'])[4]"), this);
	    ScorecardMetricDivider5 = new Element("Metric 5 Divider", By.xpath("(//*[@class='divider'])[5]"), this);
	    ScorecardMetricDivider6 = new Element("Metric 6 Divider", By.xpath("(//*[@class='divider'])[6]"), this);
	    ScorecardMetricDivider7 = new Element("Metric 7 Divider", By.xpath("(//*[@class='divider'])[7]"), this);
	    ScorecardMetricDivider8 = new Element("Metric 8 Divider", By.xpath("(//*[@class='divider'])[8]"), this);
	    ScorecardFootNoteCompanies = new Element("Comp Scorecard Footnote Companies not available", By.xpath("(//*[@class='qv-footnote ng-star-inserted'])[1]"), this);
	    
	    
	    
	}
	
    }
}
	
	
	
	
	
