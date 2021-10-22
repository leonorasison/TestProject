package pageobjects;

import org.openqa.selenium.By;

import auto.framework.TestBase;
import auto.framework.web.Element;


public class VIPSheldonPage extends TestBase {
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		public final Element BurgerMenu;
		public final Element SideMenuSheldonClick;
		public final Element SideMenuAcqInvClick;
		public final Element SheldonTitle;
		public final Element SheldonSubTitle1;
		public final Element SheldonSubTitle2;
		public final Element SheldonRefineCriteria;
		public final Element TechLabel1;
		public final Element TechLabel2;
		public final Element TechLabel3;
		public final Element TechLabel4;
		public final Element TechLabel5;
		public final Element TechLabel6;
		public final Element TechLabel7;
		public final Element TechLabel8;
		public final Element TechLabel9;
		public final Element TechLabel10;
		public final Element TechLabel11;
		public final Element TechLabel12;
		public final Element TechLabel13;
		public final Element TechLabel14;
		public final Element TechLabel15;
		public final Element TechLabel16;
		public final Element TechLabel17;
		public final Element TechLabel18;
		public final Element TechLabel19;
		public final Element TechLabel20;
		public final Element TechLabel21;
		public final Element BusLabel1;
		public final Element BusLabel2;
		public final Element BusLabel3;
		public final Element BusLabel4;
		public final Element BusLabel5;
		public final Element BusLabel6;
		public final Element BusLabel7;
		public final Element BusLabel8;
		public final Element BusLabel9;
		public final Element BusLabel10;
		public final Element BusLabel11;
		public final Element BusLabel12;
		public final Element BusLabel13;
		public final Element BusLabel14;
		public final Element BusLabel15;
		public final Element BusLabel16;
		public final Element BusLabel17;
		public final Element BusLabel18;
		public final Element BusLabel19;
		public final Element BusLabel20;
		public final Element BusLabel21;
		public final Element BusLabel22;
		public final Element BusLabel23;
		public final Element BusLabel24;
		public final Element BusLabel25;
		public final Element InfoIcon;
		public final Element InfoIconTooltip;
		public final Element FirstCompany;
		public final Element Footnote;
		public final Element KeyInsightsTitle;
		public final Element KeyInsightsStar;
		public final Element KeyInsightsContentMost;
		public final Element KeyInsightsContentHighest;
		public final Element SheldonLogo;
		public final Element SubHeader1;
		public final Element SubHeader2;
		public final Element SubHeader3;
		public final Element SubHeader4;
		public final Element BusinessTabClick;
		public final Element BusinessTabSelected;
		public final Element BusinessTab;
		public final Element TechnologyTabClick;
		public final Element CompetitorsTitle;
		public final Element NOtCoveredNote;
		public final Element ToolTipText;
		public final Element Print3DR1;
		public final Element Print3DR2;
		public final Element Print3DR3;
		public final Element AAR1;
		public final Element AAR2;
		public final Element AAR3;
		public final Element APIR1;
		public final Element APIR2;
		public final Element APIR3;
		public final Element AIR1;
		public final Element AIR2;
		public final Element AIR3;
		public final Element AMR1;
		public final Element AMR2;
		public final Element AMR3;
		public final Element BigDataR1;
		public final Element BigDataR2;
		public final Element BigdataR3;
		public final Element BChainR1;
		public final Element BChainR2;
		public final Element BChainR3;
		public final Element RPAR1;
		public final Element RPAR2;
		public final Element RPAR3;
		public final Element ChatbotsR1;
		public final Element ChatbotsR2;
		public final Element ChatbotsR3;
		public final Element CloudsR1;
		public final Element CloudsR2;
		public final Element CloudsR3;
		public final Element CrowdsourcingR1;
		public final Element CrowdsourcingR2;
		public final Element CrowdsourcingR3;
		public final Element ERR1;
		public final Element ERR2;
		public final Element ERR3;
		public final Element HAR1;
		public final Element HAR2;
		public final Element HAR3;
		public final Element IndustryR1;
		public final Element IndustryR2;
		public final Element IndustryR3;
		public final Element InteractiveR1;
		public final Element InteractiveR2;
		public final Element InteractiveR3;
		public final Element IoTR1;
		public final Element IoTR2;
		public final Element IoTR3;
		public final Element MobileR1;
		public final Element MobileR2;
		public final Element MobileR3;
		public final Element QuantumR1;
		public final Element QuantumR2;
		public final Element QuantumR3;
		public final Element RobotsR1;
		public final Element RobotsR2;
		public final Element RobotsR3;
		public final Element SecurityR1;
		public final Element SecurityR2;
		public final Element SecurityR3;
		public final Element SocialR1;
		public final Element SocialR2;
		public final Element SocialR3;
		public final Element BusHoverMessage;
		public final Element AUR1;
		public final Element AUR2;
		public final Element AUR3;
		public final Element BVCIR1;
		public final Element BVCIR2;
		public final Element BVCIR3;
		public final Element ComplianceR1;
		public final Element ComplianceR2;
		public final Element ComplianceR3;
		public final Element CSRR1;
		public final Element CSRR2;
		public final Element CSRR3;
		public final Element CCR1;
		public final Element CCR2;
		public final Element CCR3;
		public final Element CMFRR1;
		public final Element CMFRR2;
		public final Element CMFRR3;
		public final Element COR1;
		public final Element COR2;
		public final Element COR3;
		public final Element CSUSR1;
		public final Element CSUSR2;
		public final Element CSUSR3;
		public final Element CPEER1;
		public final Element CPEER2;
		public final Element CPEER3;
		public final Element CAR1;
		public final Element CAR2;
		public final Element CAR3;
		public final Element CRR1;
		public final Element CRR2;
		public final Element CRR3;
		public final Element CSUCR1;
		public final Element CSUCR2;
		public final Element CSUCR3;
		public final Element EAPR1;
		public final Element EAPR2;
		public final Element EAPR3;
		public final Element FRR1;
		public final Element FRR2;
		public final Element FRR3;
		public final Element MAR1;
		public final Element MAR2;
		public final Element MAR3;
		public final Element NDR1;
		public final Element NDR2;
		public final Element NDR3;
		public final Element NGR1;
		public final Element NGR2;
		public final Element NGR3;
		public final Element NAR1;
		public final Element NAR2;
		public final Element NAR3;
		public final Element NDCCR1;
		public final Element NDCCR2;
		public final Element NDCCR3;
		public final Element NBMR1;
		public final Element NBMR2;
		public final Element NBMR3;
		public final Element ORRR1;
		public final Element ORRR2;
		public final Element ORRR3;
		public final Element ORGR1;
		public final Element ORGR2;
		public final Element ORGR3;
		public final Element PEPMR1;
		public final Element PEPMR2;
		public final Element PEPMR3;
		public final Element ProductivityR1;
		public final Element ProductivityR2;
		public final Element ProductivityR3;
		public final Element SkillsR1;
		public final Element SkillsR2;
		public final Element SkillsR3;
		public final Element AcquiTitle;
		public final Element AcquiSubTitle;
		public final Element TopAcqComp1;
		public final Element TopAcqComp2;
		public final Element TopInvComp1;
		public final Element TopInvComp2;
		public final Element TopInvComp3;
		public final Element TopAcqDesc1;
		public final Element TopAcqDesc2;
		public final Element TopInvDesc1;
		public final Element TopInvDesc2;
		public final Element TopInvDesc3;
		public final Element TopInvRnd1;
		public final Element TopInvRnd2;
		public final Element TopInvRnd3;
		public final Element TopAcqTMR1;
		public final Element TopInvTMR1;
		public final Element TopInvTMR2;
		public final Element TopInvTMR3;
		public final Element TopAcqDate1;
		public final Element TopAcqDate2;
		public final Element TopInvDate1;
		public final Element TopInvDate2;
		public final Element TopInvDate3;		
		public final Element SheldonScoreClick1;
		public final Element SheldonScoreClick2;
		public final Element AcquiFootnote;
		public final Element AcquiScoreInfoIcon;
		public final Element InvScoreInfoIcon;
		public final Element ScoreInfoTooltip;
		public final Element AcquiTMRInfoIcon;
		public final Element TMRInfoTooltip;
		public final Element InvTMRInfoIcon;
		public final Element TopAcquisitionsTitle;
		public final Element TopAcquisitionsNoData;
		public final Element TopInvestmentsTitle;
		public final Element TopInvestmentsNoData;
		
		
	public Contents() {
			super("Container", By.className("mainContainer"));
			
	//Common
	BurgerMenu = new Element("Burger Menu", By.xpath("//*[@class='sidemenuexpanded-companalysis isShow']"), this);
	SideMenuSheldonClick = new Element("Technology & Business Levers Side Menu", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[10]"), this);
	SideMenuAcqInvClick = new Element("Acquisitions & Investments Side Menu", By.xpath("(//*[@class='sidemenuexpanded-otheroptions-con'])[11]"), this);		
	SheldonTitle = new Element("Sheldon Header", By.xpath("//*[@class='sheldon-header']"), this); 
	SheldonSubTitle1 = new Element("Sheldon SubTitle 1", By.xpath("//*[@class='sheldon-header-item-new']"), this);
	SheldonSubTitle2 = new Element("Sheldon SubTitle 2", By.xpath("//*[@class='sheldon-header-item']"), this);
	SheldonRefineCriteria = new Element("Sheldon Refine Criteria Link", By.xpath("//*[@class='sheldon-header-item-link']"), this); 
	SheldonLogo = new Element("Sheldon Logo", By.xpath("//img[@class='sheldon-trends-img']"), this);
	InfoIcon = new Element("Number of References Info Icon", By.xpath("//div[@class='sheldon-i']//img"), this);
	InfoIconTooltip = new Element("Info Icon Tooltip", By.xpath("//*[@class='sheldon-tooltip ng-star-inserted']"), this);
	Footnote = new Element("Sheldon Footnote", By.xpath("//*[@class='sheldon-footnote']"), this);
	KeyInsightsTitle = new Element("Sheldon Key Insights", By.xpath("//*[@class='sheldon-keyInsights-title ng-star-inserted']"), this);
	KeyInsightsContentMost = new Element("Sheldon Key Insights Content", By.xpath("(//*[@class='sheldon-keyInsights-content-text ng-star-inserted'])[1]"));
	KeyInsightsContentHighest = new Element("Sheldon Key Insights Content", By.xpath("(//*[@class='sheldon-keyInsights-content-text ng-star-inserted'])[2]"), this);
	KeyInsightsStar = new Element("Sheldon Key Insights Star", By.xpath("//img[@class='sheldon-keyInsights-content-img']"), this);
	CompetitorsTitle = new Element("Competitors Page", By.xpath("//*[@class='competitors-title']"), this);
	NOtCoveredNote = new Element("Company not covered", By.xpath("//div[@class='sheldon-unavailable-text']"), this);
	
	
	//Technology&BusinessLever
	BusinessTabClick = new Element("Business tab click", By.xpath("//*[@class='col-xs-4 bl']"), this);
	BusinessTabSelected = new Element("Business tab selected", By.xpath("//*[@class='bl-selected']"), this);
	BusinessTab = new Element("Business tab ", By.xpath("//b[text()='BUSINESS']"), this);
	TechnologyTabClick = new Element("Technology tab", By.xpath("//b[text()='TECHNOLOGY']"), this);
	
	//TechonologyTab
	TechLabel1 = new Element("Clouds, PaaS, SaaS, Iaas", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[1]"), this);
	TechLabel2 = new Element("AI", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[2]"), this);
	TechLabel3 = new Element("Mobile", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[3]"), this);
	TechLabel4 = new Element("Big Data", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[4]"), this);
	TechLabel5 = new Element("Robots and Drones", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[5]"), this);
	TechLabel6 = new Element("Extended Reality", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[6]"), this);
	TechLabel7 = new Element("Security", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[7]"), this);
	TechLabel8 = new Element("Blockchain", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[8]"), this);
	TechLabel9 = new Element("Crowdsourcing", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[9]"), this);
	TechLabel10 = new Element("Autonomous Machines", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[10]"), this);
	TechLabel11 = new Element("Human Augmentation", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[11]"), this);
	TechLabel12 = new Element("3D Printing", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[12]"), this);
	TechLabel13 = new Element("3D Printing", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[13]"), this);
	TechLabel14 = new Element("API Management Tools", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[14]"), this);
	TechLabel15 = new Element("Business Process Automation (inc. RPA)", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[15]"), this);
	TechLabel16 = new Element("Social/Collaboration", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[16]"), this);
	TechLabel17 = new Element("Interactive", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[17]"), this);
	TechLabel18 = new Element("Chatbots and Virtual Agents", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[18]"), this);
	TechLabel19 = new Element("Quantum Computing", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[19]"), this);
	TechLabel20 = new Element("Industry 4.0", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[20]"), this);
	TechLabel21 = new Element("Advanced Analytics", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[21]"), this);
	FirstCompany = new Element("1st Company Target Company", By.xpath("//*[@class='sheldon-canvas-xAxis sheldon-canvas-xAxis-target sheldon-canvas-xAxis-tooLong']"), this);
	ToolTipText = new Element("ToolTip Text", By.xpath("//*[@class='sheldon-tooltip ng-star-inserted']"), this);
	
	//TechnologiesRowsandColumns
	Print3DR1 = new Element("3D Printing Row 1", By.xpath("(//th[@class='ng-star-inserted'])[35]"), this); 
	Print3DR2 = new Element("3D Printing Row 2", By.xpath("(//th[@class='ng-star-inserted'])[56]"), this);
	Print3DR3 = new Element("3D Printing Row 3", By.xpath("(//th[@class='ng-star-inserted'])[77]"), this);
	AAR1 = new Element("Advanced Analytics Row 1", By.xpath("(//th[@class='ng-star-inserted'])[42]"), this);
	AAR2 = new Element("Advanced Analytics Row 2", By.xpath("(//th[@class='ng-star-inserted'])[63]"), this);
	AAR3 = new Element("Advanced Analytics Row 3", By.xpath("(//th[@class='ng-star-inserted'])[84]"), this);
	APIR1 = new Element("API Management Tools Row 1", By.xpath("(//th[@class='ng-star-inserted'])[36]"), this); 
	APIR2 = new Element("API Management Tools Row 2", By.xpath("(//th[@class='ng-star-inserted'])[57]"), this);
	APIR3 = new Element("API Management Tools Row 3", By.xpath("(//th[@class='ng-star-inserted'])[78]"), this);
	AIR1 = new Element("AI Row 1", By.xpath("(//th[@class='ng-star-inserted'])[23]"), this); 
	AIR2 = new Element("AI Row 2", By.xpath("(//th[@class='ng-star-inserted'])[44]"), this);
	AIR3 = new Element("AI Row 3", By.xpath("(//th[@class='ng-star-inserted'])[65]"), this);
	AMR1 = new Element("Autonomous Machines Row 1", By.xpath("(//th[@class='ng-star-inserted'])[33]"), this);
	AMR2 = new Element("Autonomous Machines Row 2", By.xpath("(//th[@class='ng-star-inserted'])[54]"), this);
	AMR3 = new Element("Autonomous Machines Row 3", By.xpath("(//th[@class='ng-star-inserted'])[75]"), this);
	BigDataR1 = new Element("Big Data Row 1", By.xpath("(//th[@class='ng-star-inserted'])[25]"), this);
	BigDataR2 = new Element("Big Data Row 2", By.xpath("(//th[@class='ng-star-inserted'])[46]"), this);
	BigdataR3 = new Element("Big Data Row 3", By.xpath("(//th[@class='ng-star-inserted'])[67]"), this);
	BChainR1 = new Element("Blockchain Row 1", By.xpath("(//th[@class='ng-star-inserted'])[29]"), this);
	BChainR2 = new Element("Blockchain Row 2", By.xpath("(//th[@class='ng-star-inserted'])[50]"), this);
	BChainR3 = new Element("Blockchain Row 3", By.xpath("(//th[@class='ng-star-inserted'])[71]"), this);
	RPAR1 = new Element("Business Process Automation (inc. RPA) Row 1", By.xpath("(//th[@class='ng-star-inserted'])[37]"), this);
	RPAR2 = new Element("Business Process Automation (inc. RPA) Row 2", By.xpath("(//th[@class='ng-star-inserted'])[58]"), this);
	RPAR3 = new Element("Business Process Automation (inc. RPA) Row 3", By.xpath("(//th[@class='ng-star-inserted'])[79]"), this);
	ChatbotsR1 = new Element("Chatbots and Virtual Agents Row 1", By.xpath("(//th[@class='ng-star-inserted'])[39]"), this);
	ChatbotsR2 = new Element("Chatbots and Virtual Agents Row 2", By.xpath("(//th[@class='ng-star-inserted'])[60]"), this);
	ChatbotsR3 = new Element("Chatbots and Virtual Agents Row 3", By.xpath("(//th[@class='ng-star-inserted'])[81]"), this);
	CloudsR1 = new Element("Clouds, PaaS, SaaS, Iaas Row 1", By.xpath("(//th[@class='ng-star-inserted'])[22]"), this);
	CloudsR2 = new Element("Clouds, PaaS, SaaS, Iaas Row 2", By.xpath("(//th[@class='ng-star-inserted'])[43]"), this);
	CloudsR3 = new Element("Clouds, PaaS, SaaS, Iaas Row 3", By.xpath("(//th[@class='ng-star-inserted'])[64]"), this);
	CrowdsourcingR1 = new Element("Crowdsourcing Row 1", By.xpath("(//th[@class='ng-star-inserted'])[32]"), this);
	CrowdsourcingR2 = new Element("Crowdsourcing Row 2", By.xpath("(//th[@class='ng-star-inserted'])[53]"), this);
	CrowdsourcingR3 = new Element("Crowdsourcing Row 3", By.xpath("(//th[@class='ng-star-inserted'])[74]"), this);
	ERR1 = new Element("Extended Reality Row 1", By.xpath("(//th[@class='ng-star-inserted'])[27]"), this);
	ERR2 = new Element("Extended Reality Row 2", By.xpath("(//th[@class='ng-star-inserted'])[48]"), this);
	ERR3 = new Element("Extended Reality Row 3", By.xpath("(//th[@class='ng-star-inserted'])[69]"), this);
	HAR1 = new Element("Human Augmentation Row 1", By.xpath("(//th[@class='ng-star-inserted'])[34]"), this);
	HAR2 = new Element("Human Augmentation Row 2", By.xpath("(//th[@class='ng-star-inserted'])[55]"), this);
	HAR3 = new Element("Human Augmentation Row 3", By.xpath("(//th[@class='ng-star-inserted'])[76]"), this);
	IndustryR1 = new Element("Industry 4.0 Row 1", By.xpath("(//th[@class='ng-star-inserted'])[41]"), this);
	IndustryR2 = new Element("Industry 4.0 Row 2", By.xpath("(//th[@class='ng-star-inserted'])[62]"), this);
	IndustryR3 = new Element("Industry 4.0 Row 3", By.xpath("(//th[@class='ng-star-inserted'])[83]"), this);
	InteractiveR1 = new Element("Interactive Row 1", By.xpath("(//th[@class='ng-star-inserted'])[38]"), this);
	InteractiveR2 = new Element("Interactive Row 2", By.xpath("(//th[@class='ng-star-inserted'])[59]"), this);
	InteractiveR3 = new Element("Interactive Row 3", By.xpath("(//th[@class='ng-star-inserted'])[80]"), this);
	IoTR1 = new Element("IoT Row 1", By.xpath("(//th[@class='ng-star-inserted'])[30]"), this);
	IoTR2 = new Element("IoT Row 2", By.xpath("(//th[@class='ng-star-inserted'])[51]"), this);
	IoTR3 = new Element("IoT Row 3", By.xpath("(//th[@class='ng-star-inserted'])[72]"), this);
	MobileR1 = new Element("Mobile Row 1", By.xpath("(//th[@class='ng-star-inserted'])[24]"), this);
	MobileR2 = new Element("Mobile Row 2", By.xpath("(//th[@class='ng-star-inserted'])[45]"), this);
	MobileR3 = new Element("Mobile Row 3", By.xpath("(//th[@class='ng-star-inserted'])[66]"), this);
	QuantumR1 = new Element("Quantum Computing Row 1", By.xpath("(//th[@class='ng-star-inserted'])[40]"), this);
	QuantumR2 = new Element("Quantum Computing Row 2", By.xpath("(//th[@class='ng-star-inserted'])[61]"), this);
	QuantumR3 = new Element("Quantum Computing Row 3", By.xpath("(//th[@class='ng-star-inserted'])[82]"), this);
	RobotsR1 = new Element("Robots and Drones Row 1", By.xpath("(//th[@class='ng-star-inserted'])[26]"), this);
	RobotsR2 = new Element("Robots and Drones Row 2", By.xpath("(//th[@class='ng-star-inserted'])[47]"), this);
	RobotsR3 = new Element("Robots and Drones Row 3", By.xpath("(//th[@class='ng-star-inserted'])[68]"), this);
	SecurityR1 = new Element("Security Row 1", By.xpath("(//th[@class='ng-star-inserted'])[28]"), this);
	SecurityR2 = new Element("Security Row 2", By.xpath("(//th[@class='ng-star-inserted'])[49]"), this);
	SecurityR3 = new Element("Security Row 3", By.xpath("(//th[@class='ng-star-inserted'])[70]"), this);
	SocialR1 = new Element("Social/Collaboration Row 1", By.xpath("(//th[@class='ng-star-inserted'])[31]"), this);
	SocialR2 = new Element("Social/Collaboration Row 2", By.xpath("(//th[@class='ng-star-inserted'])[52]"), this);
	SocialR3 = new Element("Social/Collaboration Row 3", By.xpath("(//th[@class='ng-star-inserted'])[73]"), this);
	
	//BusinessTab
	SubHeader1 = new Element("SELECT ALL", By.xpath("(//*[@class='sheldon-subheader-filter'])[2]"), this);
	SubHeader2 = new Element("GROWTH", By.xpath("(//*[@class='sheldon-subheader-filter'])[2]"), this);
	SubHeader3 = new Element("PROFITABILITY", By.xpath("(//*[@class='sheldon-subheader-filter'])[3]"), this);
	SubHeader4 = new Element("SUSTAINABILITY", By.xpath("(//*[@class='sheldon-subheader-filter'])[4]"), this);
	BusLabel1 = new Element("CSR", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[1]"), this);
	BusLabel2 = new Element("Financial Risk Reduction", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[2]"), this);
	BusLabel3 = new Element("Customer Satisfaction and User Centricity", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[3]"), this);
	BusLabel4 = new Element("Ecosystem Experience, Alliances, Partnerships", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[4]"), this);
	BusLabel5 = new Element("Cost Model & Financial Rules", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[5]"), this);
	BusLabel6 = new Element("M&A", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[6]"), this);
	BusLabel7 = new Element("New Geographic Mkts. and Intl. Growth", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[7]"), this);
	BusLabel8 = new Element("Process Eff., Process & Op Management", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[8]"), this);
	BusLabel9 = new Element("Asset Utilization", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[9]"), this);
	BusLabel10 = new Element("Customer Retention", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[10]"), this);
	BusLabel11 = new Element("Organization and Organizational Resilience", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[11]"), this);
	BusLabel12 = new Element("New Business Models", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[12]"), this);
	BusLabel13 = new Element("Brand Value and Corporate Image", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[13]"), this);
	BusLabel14 = new Element("Compliance", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[14]"), this);
	BusLabel15 = new Element("New and Digital Dist. Channels", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[15]"), this);
	BusLabel16 = new Element("Culture, People, Employee Engagement", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[16]"), this);
	BusLabel17 = new Element("Cross-Selling Up-Selling", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[17]"), this);
	BusLabel18 = new Element("Operational Risk Reduction", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[18]"), this);
	BusLabel19 = new Element("Productivity", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[19]"), this);
	BusLabel20 = new Element("New and Adjacent Products and Services", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[20]"), this);
	BusLabel21 = new Element("Cost Cutting", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[21]"), this);
	BusLabel22 = new Element("Cost Optimization", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[22]"), this);
	BusLabel23 = new Element("Customer Acquisition", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[23]"), this);
	BusLabel24 = new Element("New and Digital Communication Channels", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[24]"), this);
	BusLabel25 = new Element("Skills", By.xpath("(//*[@class='sheldon-labels-yAxis sheldon-labels-yAxis-technology'])[25]"), this);
	
	//BusinessRowsandColumns
	BusHoverMessage = new Element("CSR Hover Message", By.xpath("//*[@class='sheldon-tooltip ng-star-inserted']"), this); 
	CSRR1 = new Element("CSR Row 1", By.xpath("(//th[@class='ng-star-inserted'])[26]"), this); 
	CSRR2 = new Element("CSR Row 2", By.xpath("(//th[@class='ng-star-inserted'])[51]"), this);
	CSRR3 = new Element("CSR Row 3", By.xpath("(//th[@class='ng-star-inserted'])[76]"), this);
	FRR1 = new Element("Financial Risk Reduction Row 1", By.xpath("(//th[@class='ng-star-inserted'])[27]"), this);
	FRR2 = new Element("Financial Risk Reduction Row 2", By.xpath("(//th[@class='ng-star-inserted'])[52]"), this);
	FRR3 = new Element("Financial Risk Reduction Row 3", By.xpath("(//th[@class='ng-star-inserted'])[77]"), this);
	CSUCR1 = new Element("Customer Satisfaction and User Centricity Row 1", By.xpath("(//th[@class='ng-star-inserted'])[28]"), this); 
	CSUCR2 = new Element("Customer Satisfaction and User Centricity Row 2", By.xpath("(//th[@class='ng-star-inserted'])[53]"), this);
	CSUCR3 = new Element("Customer Satisfaction and User Centricity Row 3", By.xpath("(//th[@class='ng-star-inserted'])[78]"), this);
	EAPR1 = new Element("Ecosystem Experience, Alliances, Partnerships Row 1", By.xpath("(//th[@class='ng-star-inserted'])[29]"), this); 
	EAPR2 = new Element("Ecosystem Experience, Alliances, Partnerships Row 2", By.xpath("(//th[@class='ng-star-inserted'])[54]"), this);
	EAPR3 = new Element("Ecosystem Experience, Alliances, Partnerships Row 3", By.xpath("(//th[@class='ng-star-inserted'])[79]"), this);
	CMFRR1 = new Element("Cost Model & Financial Rules Row 1", By.xpath("(//th[@class='ng-star-inserted'])[30]"), this);
	CMFRR2 = new Element("Cost Model & Financial Rules Row 2", By.xpath("(//th[@class='ng-star-inserted'])[55]"), this);
	CMFRR3 = new Element("Cost Model & Financial Rules Row 3", By.xpath("(//th[@class='ng-star-inserted'])[80]"), this);
	MAR1 = new Element("M&A Row 1", By.xpath("(//th[@class='ng-star-inserted'])[31]"), this);
	MAR2 = new Element("M&A Row 2", By.xpath("(//th[@class='ng-star-inserted'])[56]"), this);
	MAR3 = new Element("M&A Row 3", By.xpath("(//th[@class='ng-star-inserted'])[81]"), this);
	NGR1 = new Element("New Geographic Mkts. and Intl. Growth Row 1", By.xpath("(//th[@class='ng-star-inserted'])[32]"), this);
	NGR2 = new Element("New Geographic Mkts. and Intl. Growth Row 2", By.xpath("(//th[@class='ng-star-inserted'])[57]"), this);
	NGR3 = new Element("New Geographic Mkts. and Intl. Growth Row 3", By.xpath("(//th[@class='ng-star-inserted'])[82]"), this);
	PEPMR1 = new Element("Process Eff., Process & Op Management Row 1", By.xpath("(//th[@class='ng-star-inserted'])[33]"), this);
	PEPMR2 = new Element("Process Eff., Process & Op Management Row 2", By.xpath("(//th[@class='ng-star-inserted'])[58]"), this);
	PEPMR3 = new Element("Process Eff., Process & Op Management Row 3", By.xpath("(//th[@class='ng-star-inserted'])[83]"), this);
	AUR1 = new Element("Asset Utilization Row 1", By.xpath("(//th[@class='ng-star-inserted'])[34]"), this);
	AUR2 = new Element("Asset Utilization Row 2", By.xpath("(//th[@class='ng-star-inserted'])[59]"), this);
	AUR3 = new Element("Asset Utilization Row 3", By.xpath("(//th[@class='ng-star-inserted'])[84]"), this);
	CRR1 = new Element("Customer Retention Row 1", By.xpath("(//th[@class='ng-star-inserted'])[35]"), this);
	CRR2 = new Element("Customer Retention Row 2", By.xpath("(//th[@class='ng-star-inserted'])[60]"), this);
	CRR3 = new Element("Customer Retention Row 3", By.xpath("(//th[@class='ng-star-inserted'])[85]"), this);
	ORGR1 = new Element("Organization and Organizational Resilience Row 1", By.xpath("(//th[@class='ng-star-inserted'])[36]"), this);
	ORGR2 = new Element("Organization and Organizational Resilience Row 2", By.xpath("(//th[@class='ng-star-inserted'])[61]"), this);
	ORGR3 = new Element("Organization and Organizational Resilience Row 3", By.xpath("(//th[@class='ng-star-inserted'])[86]"), this);
	NBMR1 = new Element("New Business Models Row 1", By.xpath("(//th[@class='ng-star-inserted'])[37]"), this);
	NBMR2 = new Element("New Business Models Row 2", By.xpath("(//th[@class='ng-star-inserted'])[62]"), this);
	NBMR3 = new Element("New Business Models Row 3", By.xpath("(//th[@class='ng-star-inserted'])[87]"), this);
	BVCIR1 = new Element("Brand Value and Corporate Image Row 1", By.xpath("(//th[@class='ng-star-inserted'])[38]"), this);
	BVCIR2 = new Element("Brand Value and Corporate Image Row 2", By.xpath("(//th[@class='ng-star-inserted'])[63]"), this);
	BVCIR3 = new Element("Brand Value and Corporate Image Row 3", By.xpath("(//th[@class='ng-star-inserted'])[88]"), this);
	ComplianceR1 = new Element("Compliance Row 1", By.xpath("(//th[@class='ng-star-inserted'])[39]"), this);
	ComplianceR2 = new Element("Compliance Row 2", By.xpath("(//th[@class='ng-star-inserted'])[64]"), this);
	ComplianceR3 = new Element("Compliance Row 3", By.xpath("(//th[@class='ng-star-inserted'])[89]"), this);
	NDR1 = new Element("New and Digital Dist. Channels Row 1", By.xpath("(//th[@class='ng-star-inserted'])[40]"), this);
	NDR2 = new Element("New and Digital Dist. Channels Row 2", By.xpath("(//th[@class='ng-star-inserted'])[65]"), this);
	NDR3 = new Element("New and Digital Dist. Channels Row 3", By.xpath("(//th[@class='ng-star-inserted'])[90]"), this);
	CPEER1 = new Element("Culture, People, Employee Engagement Row 1", By.xpath("(//th[@class='ng-star-inserted'])[41]"), this);
	CPEER2 = new Element("Culture, People, Employee Engagement Row 2", By.xpath("(//th[@class='ng-star-inserted'])[66]"), this);
	CPEER3 = new Element("Culture, People, Employee Engagement Row 3", By.xpath("(//th[@class='ng-star-inserted'])[91]"), this);
	CSUSR1 = new Element("Cross-Selling Up-Selling Row 1", By.xpath("(//th[@class='ng-star-inserted'])[42]"), this);
	CSUSR2 = new Element("Cross-Selling Up-Selling Row 2", By.xpath("(//th[@class='ng-star-inserted'])[67]"), this);
	CSUSR3 = new Element("Cross-Selling Up-Selling Row 3", By.xpath("(//th[@class='ng-star-inserted'])[92]"), this);
	ORRR1 = new Element("Operational Risk Reduction Row 1", By.xpath("(//th[@class='ng-star-inserted'])[43]"), this);
	ORRR2 = new Element("Operational Risk Reduction Row 2", By.xpath("(//th[@class='ng-star-inserted'])[68]"), this);
	ORRR3 = new Element("Operational Risk Reduction Row 3", By.xpath("(//th[@class='ng-star-inserted'])[93]"), this);
	ProductivityR1 = new Element("Productivity Row 1", By.xpath("(//th[@class='ng-star-inserted'])[44]"), this);
	ProductivityR2 = new Element("Productivity Row 2", By.xpath("(//th[@class='ng-star-inserted'])[69]"), this);
	ProductivityR3 = new Element("Productivity Row 3", By.xpath("(//th[@class='ng-star-inserted'])[94]"), this);
	NAR1 = new Element("New and Adjacent Products and Services Row 1", By.xpath("(//th[@class='ng-star-inserted'])[45]"), this);
	NAR2 = new Element("New and Adjacent Products and Services Row 2", By.xpath("(//th[@class='ng-star-inserted'])[70]"), this);
	NAR3 = new Element("New and Adjacent Products and Services Row 3", By.xpath("(//th[@class='ng-star-inserted'])[95]"), this);
	CCR1 = new Element("Cost Cutting Row 1", By.xpath("(//th[@class='ng-star-inserted'])[46]"), this);
	CCR2 = new Element("Cost Cutting Row 2", By.xpath("(//th[@class='ng-star-inserted'])[71]"), this);
	CCR3 = new Element("Cost Cutting Row 3", By.xpath("(//th[@class='ng-star-inserted'])[96]"), this);
	COR1 = new Element("Cost Optimization Row 1", By.xpath("(//th[@class='ng-star-inserted'])[47]"), this);
	COR2 = new Element("Cost Optimization Row 2", By.xpath("(//th[@class='ng-star-inserted'])[72]"), this);
	COR3 = new Element("Cost Optimization Row 3", By.xpath("(//th[@class='ng-star-inserted'])[97]"), this);
	CAR1 = new Element("Customer Acquisition Row 1", By.xpath("(//th[@class='ng-star-inserted'])[48]"), this);
	CAR2 = new Element("Customer Acquisition Row 2", By.xpath("(//th[@class='ng-star-inserted'])[73]"), this);
	CAR3 = new Element("Customer Acquisition Row 3", By.xpath("(//th[@class='ng-star-inserted'])[98]"), this);
	NDCCR1 = new Element("New and Digital Communication Channels Row 1", By.xpath("(//th[@class='ng-star-inserted'])[49]"), this);
	NDCCR2 = new Element("New and Digital Communication Channels Row 2", By.xpath("(//th[@class='ng-star-inserted'])[74]"), this);
	NDCCR3 = new Element("New and Digital Communication Channels Row 3", By.xpath("(//th[@class='ng-star-inserted'])[99]"), this);
	SkillsR1 = new Element("Skills Row 1", By.xpath("(//th[@class='ng-star-inserted'])[50]"), this);
	SkillsR2 = new Element("Skills Row 2", By.xpath("(//th[@class='ng-star-inserted'])[75]"), this);
	SkillsR3 = new Element("Skills Row 3", By.xpath("(//th[@class='ng-star-inserted'])[100]"), this);

	//Acquisitions&Investments
	AcquiTitle = new Element("Acquisitions & Investments", By.xpath("//*[@class='ai-header']"), this);
	AcquiSubTitle = new Element("Acquisitions & Investments Subheader", By.xpath("//*[@class='ai-subheader-item']"), this);
	SheldonScoreClick1 = new Element("Sheldon Score 1", By.xpath("(//*[@class='col-xs-1 acq-table-content-score'])[1]"), this);
	SheldonScoreClick2 = new Element("Sheldon Score 2", By.xpath("(//*[@class='col-xs-2 acq-table-content-score-inv'])[3]"), this);
	AcquiFootnote = new Element("Acquisitions & Investments Footnote", By.xpath("//*[@class='acq-footnote']"), this);
	AcquiScoreInfoIcon = new Element("Acquisition Sheldon Score Info Icon", By.xpath("(//img[@class='i-icon'])[2]"), this);
	AcquiTMRInfoIcon = new Element("Acquisition Money Info Icon", By.xpath("(//img[@class='i-icon'])[1]"), this);
	InvScoreInfoIcon = new Element("Investment Sheldon Score Info Icon", By.xpath("(//img[@class='i-icon'])[4]"), this);
	InvTMRInfoIcon = new Element("Investment Money Info Icon", By.xpath("(//img[@class='i-icon'])[3]"), this);
	ScoreInfoTooltip = new Element("Sheldon Score Info Tool Tip", By.xpath("//*[@class='sheldon-tooltip ng-star-inserted']"), this);
	TMRInfoTooltip = new Element("Total Money Raised Info Tool Tip", By.xpath("//*[@class='sheldon-tooltip-tmr ng-star-inserted']"), this);
	TopAcquisitionsTitle = new Element("TOP ACQUISITIONS", By.xpath("(//*[@class='ai-acq-header'])[1]"), this);
	TopInvestmentsTitle = new Element("TOP INVESTMENTS", By.xpath("(//*[@class='ai-acq-header'])[2]"), this);
	TopAcquisitionsNoData = new Element("Top Acquisitions No Data Available", By.xpath("(//*[@class='unavailable-noData'])[1]"), this);
	TopInvestmentsNoData = new Element("Top Investments No Data Available", By.xpath("(//*[@class='unavailable-noData'])[2]"), this);
	
	
	TopAcqComp1 = new Element("Hulu", By.xpath("(//*[@class='col-xs-2 acq-table-content-companyName'])[1]"), this);
	TopAcqComp2 = new Element("21st Century Fox", By.xpath("(//*[@class='col-xs-2 acq-table-content-companyName'])[2]"), this);
	TopInvComp1 = new Element("THE VOID", By.xpath("(//*[@class='col-xs-2 acq-table-content-companyName'])[3]"), this);
	TopInvComp2 = new Element("Quibi", By.xpath("(//*[@class='col-xs-2 acq-table-content-companyName'])[4]"), this);
	TopInvComp3 = new Element("Sphero", By.xpath("(//*[@class='col-xs-2 acq-table-content-companyName'])[5]"), this);
	TopAcqDesc1 = new Element("Hulu Description", By.xpath("(//*[@class='col-xs-4 acq-table-content-description'])[1]"), this);
	TopAcqDesc2 = new Element("21st Century Fox Description", By.xpath("(//*[@class='col-xs-4 acq-table-content-description'])[2]"), this);
	TopInvDesc1 = new Element("The Void Description", By.xpath("(//*[@class='col-xs-3 acq-table-content-description'])[1]"), this);
	TopInvDesc2 = new Element("Quibi Description", By.xpath("(//*[@class='col-xs-3 acq-table-content-description'])[2]"), this);
	TopInvDesc3 = new Element("Sphero Description", By.xpath("(//*[@class='col-xs-3 acq-table-content-description'])[3]"), this);
	TopInvRnd1 = new Element("The Void Round", By.xpath("(//*[@class='col-xs-1 acq-table-content-round'])[1]"), this);
	TopInvRnd2 = new Element("Quibi Round", By.xpath("(//*[@class='col-xs-1 acq-table-content-round'])[2]"), this);
	TopInvRnd3 = new Element("Sphero Round", By.xpath("(//*[@class='col-xs-1 acq-table-content-round'])[3]"), this);
	TopAcqTMR1 = new Element("Hulu Total Money Raised", By.xpath("(//*[@class='col-xs-2 acq-table-content-money'])[1]"), this);
	TopInvTMR1 = new Element("THE VOID Total Money Raised", By.xpath("(//*[@class='col-xs-2 acq-table-content-money'])[3]"), this);
	TopInvTMR2 = new Element("Quibi Total Money Raised", By.xpath("(//*[@class='col-xs-2 acq-table-content-money'])[4]"), this);
	TopInvTMR3 = new Element("Sphero Total Money Raised", By.xpath("(//*[@class='col-xs-2 acq-table-content-money'])[5]"), this);
	TopAcqDate1 = new Element("Hulu Announcement Date", By.xpath("(//*[@class='col-xs-2'])[2]"), this);
	TopAcqDate2 = new Element("21st Century Fox Announcement Date", By.xpath("(//*[@class='col-xs-2'])[3]"), this);
	TopInvDate1 = new Element("THE VOID Announcement Date", By.xpath("(//*[@class='col-xs-1 acq-date-inv'])[1]"), this);
	TopInvDate2 = new Element("Quibi Announcement Date", By.xpath("(//*[@class='col-xs-1 acq-date-inv'])[2]"), this);
	TopInvDate3 = new Element("Sphero Announcement Date", By.xpath("(//*[@class='col-xs-1 acq-date-inv'])[3]"), this);
	
		
	}
  }
}
