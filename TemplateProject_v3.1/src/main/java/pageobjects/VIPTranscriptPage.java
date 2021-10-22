package pageobjects;

import org.openqa.selenium.By;
import auto.framework.PageBase;
import auto.framework.web.Element;
import auto.framework.web.TextBox;

public class VIPTranscriptPage extends PageBase{
	
	public static final Contents contents = new Contents();
	
	public static class Contents extends Element{
		
		public final Element TranscriptTitle;
		public final Element SideMenuTranscript;
		public final Element SideMenuGuidanceIntentTranscript;
		public final Element TranscriptsTab;
		public final Element FirstTranscriptTitle;
		public final Element SelectedTranscriptTitle;
		public final Element EventType;
		public final Element EventType1;
		public final Element EventType2;
		public final Element EventType3;
		public final Element EventType4;
		public final Element EventTypeEarningsCall;
		public final Element ClearSelection;
		public final Element Executives;
		public final Element Analysts;
		public final Element Selected;
		public final Element Executives1;
		public final Element Analysts1;
		public final Element TranscriptSpeechName;
		public final Element TranscriptSpeechName2;
		public final Element TranscriptSpeechName3;
		public final Element TranscriptSpeechPosition;
		public final Element TranscriptSpeech;
		public final Element TranscriptSpeech2;
		public final Element TranscriptSpeech3;
		public final Element ExecutiveAccordion;
		public final Element FirstExecutiveName;
		public final Element FirstMoreLink;
		public final Element SecondMoreLink;
		public final Element ThirdMoreLink;
		public final Element SpeechModal;
		public final Element SpeechModalName;
		public final Element SpeechModalCloseButton;
		public final Element BackToListButton;
		public final Element TranscriptNoData;
		public final TextBox SearchTextbox;
		
		public Contents() {
			super("Container", By.className("mainContainer"));
			
			TranscriptTitle = new Element("Transcript Header Title", By.xpath("//*[@class='transcripts-title']"), this);
			//SideMenuTranscript = new Element("Side Menu Transcript", By.xpath("//*[@class='header-sidemenu']//*[@class='sidemenuexpanded isShow']/div[12]"), this);
			SideMenuTranscript = new Element("Side Menu Transcript", By.xpath("//*[@src='../../assets/images/file-text-b.svg' or @src='../../assets/images/file-text-p.svg']"), this);
			SideMenuGuidanceIntentTranscript = new Element("Side Menu Guidance, Intent & Transcript", By.xpath("//*[@src='../../assets/images/epiconeintent-icon-b.svg' or @src='../../assets/images/epiconeintent-icon-p.svg']"), this);
			TranscriptsTab = new Element("Transcripts Tab", By.xpath("(//*[@class='opportunity-map-tabs-item'])[3]/div"), this);
			//FirstTranscriptTitle = new Element("First Transcript Title", By.xpath("//*[@class='transcripts-body-main-kpi ng-star-inserted'][1]//*[@class='transcripts-body-main-kpi-title']/a"), this);
			FirstTranscriptTitle = new Element("First Transcript Title", By.xpath("//*[@class='transcripts-body-main-kpi ng-star-inserted'][1]//a"), this);
			SelectedTranscriptTitle = new Element("Selected Transcript Title", By.xpath("//*[@class='transcript-selected-title']"), this);
			EventType = new Element("Event Type", By.xpath("//*[@class='transcripts-body-sidemenu']"), this);
			//EventType1 = new Element("1st Event Type", By.xpath("//*[@class='transcripts-body-sidemenu-kpi onhover ng-star-inserted'][1]"), this);
			//EventType2 = new Element("2nd Event Type", By.xpath("//*[@class='transcripts-body-sidemenu-kpi onhover ng-star-inserted'][2]"), this);
			//EventType3 = new Element("3rd Event Type", By.xpath("//*[@class='transcripts-body-sidemenu-kpi onhover ng-star-inserted'][3]"), this);
			EventType1 = new Element("1st Event Type", By.xpath("//*[@class= 'transcripts-body-sidemenu' or @class='transcripts-body-sidemenu ng-star-inserted']/div[2]"), this);
			EventType2 = new Element("2nd Event Type", By.xpath("//*[@class= 'transcripts-body-sidemenu' or @class='transcripts-body-sidemenu ng-star-inserted']/div[3]"), this);
			EventType3 = new Element("3rd Event Type", By.xpath("//*[@class= 'transcripts-body-sidemenu' or @class='transcripts-body-sidemenu ng-star-inserted']/div[4]"), this);
			EventType4 = new Element("4th Event Type", By.xpath("//*[@class= 'transcripts-body-sidemenu' or @class='transcripts-body-sidemenu ng-star-inserted']/div[5]"), this);
			EventTypeEarningsCall = new Element("Earnings Call Event Type", By.xpath("//*[@class= 'transcripts-body-sidemenu' or @class='transcripts-body-sidemenu ng-star-inserted']//*[normalize-space(text())='EARNINGS CALL']"), this);
			ClearSelection = new Element("Clear Selection", By.xpath("(//*[@class='transcript-selected-presentor-list'])[1]"), this);
			Executives = new Element("Executives", By.xpath("(//*[@class='transcript-selected-presentor-list'])[2]"), this);
			Analysts = new Element("Analysts", By.xpath("(//*[@class='transcript-selected-presentor-list'])[3]"), this);
			Selected = new Element("Selected Search Words", By.xpath("(//*[@class='selected'])[1]"), this);
			Executives1 = new Element("1st Executives", By.xpath("(//*[@class='transcript-selected-exec ng-star-inserted'])[1]"), this);
			Analysts1 = new Element("1st Analysts", By.xpath("(//*[@class='transcript-selected-expand ng-star-inserted'])[1]"), this);
			TranscriptSpeechName = new Element("Transcript Speech Name 1", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][1]/*[@class='transcript-selected-speech-name'][1]"), this);
			TranscriptSpeechName2 = new Element("Transcript Speech Name 2", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][2]/*[@class='transcript-selected-speech-name'][1]"), this);
			TranscriptSpeechName3 = new Element("Transcript Speech Name 3", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][3]/*[@class='transcript-selected-speech-name'][1]"), this);
			TranscriptSpeechPosition = new Element("Transcript Speech Position", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][1]/*[@class='transcript-selected-speech-title'][1]"), this);
			TranscriptSpeech = new Element("Transcript Speech", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][1]/*[@class='transcript-selected-speech-speech ng-star-inserted'][1]"), this);
			TranscriptSpeech2 = new Element("Transcript Speech 2", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][2]/*[@class='transcript-selected-speech-speech ng-star-inserted'][1]"), this);
			TranscriptSpeech3 = new Element("Transcript Speech 3", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][3]/*[@class='transcript-selected-speech-speech ng-star-inserted'][1]"), this);
			ExecutiveAccordion = new Element("Executive Accordion", By.xpath("//*[@class='panel'][1]//*[@class='accordion-toggle']"), this);
			FirstExecutiveName = new Element("First Executive Name", By.xpath("//*[@class='transcript-selected-exec ng-star-inserted'][1]"), this);
			FirstMoreLink = new Element("First More Link", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][1]//*[@type='button'][1]"), this);
			SecondMoreLink = new Element("Second More Link", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][2]//*[@type='button'][1]"), this);
			ThirdMoreLink = new Element("Third More Link", By.xpath("//*[@class='transcript-selected-speech-container ng-star-inserted'][3]//*[@type='button'][1]"), this);
			SpeechModal = new Element("Speech Modal", By.xpath("//*[@class='modal-transcripts']"), this);
			SpeechModalName = new Element("Speech Modal Name", By.xpath("//*[@class='modal-transcripts-name']"), this);
			SpeechModalCloseButton = new Element("Speech Modal Close Button", By.xpath("//*[@class='button-close btn']"), this);
			BackToListButton = new Element("Back To List Button", By.xpath("//*[@class='transcripts-container']//*[@class='header-backsearch-text']"), this);
			TranscriptNoData = new Element("Transcript No Data Message", By.xpath("//*[@class='transcripts-nodata']"), this);
			SearchTextbox = new TextBox("Search Textbox", By.xpath("(//*[@class='tool-transcripts-input'])[1]"), this);
			
		}
	}
}