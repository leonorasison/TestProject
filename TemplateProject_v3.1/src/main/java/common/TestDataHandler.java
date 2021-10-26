package common;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spire.presentation.IAutoShape;
import com.spire.presentation.ISlide;
import com.spire.presentation.ITable;
import com.spire.presentation.ParagraphEx;
import com.spire.presentation.Presentation;

import Fillo.Recordset;
import auto.framework.ReportLog;


public class TestDataHandler {

	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;
    
	public String site;
	public String customSite;
	public String email;
	public String eid;
	public String SignedInUser;
	public String filePath;
	public String pptFilePath;
	public String company;
	public String currComp;
	public String nonCurrComp;
	public String privCompany;
	public String telcoCompany;
	public String retailCompany;
	public String cgsCompany;
	public String hotelCompany;
	public String opexCompany;
	public String opex1PeriodCompany;
	public String noTransCompany;
	public String noTRSCompany;
	public String description;
	public String disclaimerTooltip;
	public String newQVWarningText;
	public String CVSDisclaimer;
	public String ShowCVS;
	public String VCMDisclaimer;
	public String ShowVCM;
	public String ShowVCMModal;
	public String ShowOppNavModal;
	public String restatementTooltip;
	public String affdTooltip;
	public String fsNote;
	public String downloadModalDesc;
	public String oppNaviTooltip;
	public String faqKXSite;
	public String userGuideKXSite;
	public String stiTooltip;
	public String suiTooltip;
	public String DEPSTooltip;
	public String NPPERTooltip;
	public String DSOTooltip;
	public String DIOTooltip;
	public String DPOTooltip;
	public String CCDTooltip;
	public String NDEBITDATooltip;
	public String TDETooltip;
	public String ICTooltip;
	public String FEVEBITTooltip;
	public String ScorecardNote;
	public String CRCPTooltip;
	public String ROICTooltip;
	public String EBITMTooltip;
	public String CAPEFFTooltip;
	public String EBITDATooltip;
	public String DATooltip;
	public String WCRTooltip;
	public String NPPETooltip;
	public String GITooltip;
	public String COGSTooltip;
	public String SGATooltip;
	public String CRTooltip;
	public String NRTooltip;
	public String IRTooltip;
	public String APRTooltip;
	public String ITPRTooltip;
	public String FCCDTooltip;
	public String FDIOTooltip;
	public String FDPOTooltip;
	public String FDSOTooltip;
	public String TRSTooltip;
	public String BuyTooltip;
	public String SPGTooltip;
	public String RGCAGRTooltip;
	public String EBITMDTooltip;
	public String ICPTooltip;
	public String EVEBITTooltip;
	
	//Custom_Yeye
	//public String VCATooltip;
	//public String VCPTooltip;
	//public String SCMICPTooltip;
	//public String ARTooltip;
	//public String RaPETooltip;
	
	public static int start,last, numRow, temp=0;
	public static int[] selectedRows;
	public static TestDataHandler loadTestData(String sheet, String... where) throws Exception {
		
		Recordset record = DataRepository.testDataToBeUsed().getRowData(sheet, where);
		return loadTestData(record);
		
	}
	
	public static TestDataHandler loadTestData(Recordset record) throws Exception {
		TestDataHandler testDataHandler = new TestDataHandler();
		
		testDataHandler.site = record.getField("URL");	
		testDataHandler.customSite = record.getField("CustomURL");	
		testDataHandler.email = record.getField("Email");
		testDataHandler.eid = record.getField("EID");
		testDataHandler.SignedInUser = record.getField("SignedInUser");
		testDataHandler.filePath = record.getField("FilePath");
		testDataHandler.pptFilePath = record.getField("PPTFilePath");
		testDataHandler.company = record.getField("Company");
		testDataHandler.currComp = record.getField("CurrComp");
		testDataHandler.nonCurrComp = record.getField("NonCurrComp");
		testDataHandler.privCompany = record.getField("PrivCompany");
		testDataHandler.telcoCompany = record.getField("TelcoCompany");
		testDataHandler.retailCompany = record.getField("RetailCompany");
		testDataHandler.cgsCompany = record.getField("CGSCompany");
		testDataHandler.hotelCompany = record.getField("HOTELCompany");
		testDataHandler.opexCompany = record.getField("OPEXCompany");
		testDataHandler.opex1PeriodCompany = record.getField("OPEX1PeriodCompany");
		testDataHandler.noTransCompany = record.getField("NoTransCompany");
		testDataHandler.noTRSCompany = record.getField("NoTRSCompany");
		testDataHandler.description = record.getField("Description");
		testDataHandler.disclaimerTooltip = record.getField("DisclaimerTooltip");
		testDataHandler.newQVWarningText = record.getField("NewQVWarningText");
		testDataHandler.CVSDisclaimer = record.getField("CVSDisclaimer");
		testDataHandler.ShowCVS = record.getField("ShowCVS");
		testDataHandler.VCMDisclaimer = record.getField("VCMDisclaimer");
		testDataHandler.restatementTooltip = record.getField("RestatementTooltip");
		testDataHandler.ShowVCM = record.getField("ShowVCM");
		testDataHandler.ShowOppNavModal = record.getField("ShowOppNavModal");
		testDataHandler.ShowVCMModal = record.getField("ShowVCMModal");
		testDataHandler.affdTooltip = record.getField("AFFDTooltip");
		testDataHandler.fsNote = record.getField("FSNote");
		testDataHandler.downloadModalDesc = record.getField("DownloadModalDesc");
		testDataHandler.oppNaviTooltip = record.getField("OppNaviTooltip");
		testDataHandler.faqKXSite = record.getField("FAQKXSite");
		testDataHandler.userGuideKXSite = record.getField("UserGuideKXSite");
		testDataHandler.stiTooltip = record.getField("STITooltip");
		testDataHandler.suiTooltip = record.getField("SUITooltip");
		testDataHandler.DEPSTooltip = record.getField("DEPSTooltip");
		testDataHandler.NPPERTooltip = record.getField("NPPERTooltip");
		testDataHandler.DSOTooltip = record.getField("DSOTooltip");
		testDataHandler.DIOTooltip = record.getField("DIOTooltip");
		testDataHandler.DPOTooltip = record.getField("DPOTooltip");
		testDataHandler.CCDTooltip = record.getField("CCDTooltip");
		testDataHandler.NDEBITDATooltip = record.getField("NDEBITDATooltip");
		testDataHandler.TDETooltip = record.getField("TDETooltip");
		testDataHandler.ICTooltip = record.getField("ICTooltip");
		testDataHandler.FEVEBITTooltip = record.getField("FEVEBITTooltip");
		testDataHandler.ScorecardNote = record.getField("ScorecardNote");
		testDataHandler.CRCPTooltip = record.getField("CRCPTooltip");
		testDataHandler.ROICTooltip = record.getField("ROICTooltip");
		testDataHandler.EBITMTooltip = record.getField("EBITMTooltip");
		testDataHandler.CAPEFFTooltip = record.getField("CAPEFFTooltip");
		testDataHandler.EBITDATooltip = record.getField("EBITDATooltip");
		testDataHandler.DATooltip = record.getField("DATooltip");
		testDataHandler.WCRTooltip = record.getField("WCRTooltip");
		testDataHandler.NPPETooltip = record.getField("NPPETooltip");
		testDataHandler.GITooltip = record.getField("GITooltip");
		testDataHandler.GITooltip = record.getField("GITooltip");
		testDataHandler.COGSTooltip = record.getField("COGSTooltip");
		testDataHandler.SGATooltip = record.getField("SGATooltip");
		testDataHandler.CRTooltip = record.getField("CRTooltip");
		testDataHandler.NRTooltip = record.getField("NRTooltip");
		testDataHandler.IRTooltip = record.getField("IRTooltip");
		testDataHandler.APRTooltip = record.getField("APRTooltip");
		testDataHandler.ITPRTooltip = record.getField("ITPRTooltip");
		testDataHandler.FCCDTooltip = record.getField("FCCDTooltip");
		testDataHandler.FDSOTooltip = record.getField("FDSOTooltip");
		testDataHandler.FDIOTooltip = record.getField("FDIOTooltip");
		testDataHandler.FDPOTooltip = record.getField("FDPOTooltip");
		testDataHandler.TRSTooltip = record.getField("TRSTooltip");
		testDataHandler.BuyTooltip = record.getField("BuyTooltip");
		testDataHandler.SPGTooltip = record.getField("SPGTooltip");
		testDataHandler.RGCAGRTooltip = record.getField("RGCAGRTooltip");
		testDataHandler.EBITMDTooltip = record.getField("EBITMDTooltip");
		testDataHandler.ICPTooltip = record.getField("ICPTooltip");
		testDataHandler.EVEBITTooltip = record.getField("EVEBITTooltip");
		
		//Custom_Yeye
		//testDataHandler.VCATooltip = record.getField("VCATooltip");
		//testDataHandler.VCPTooltip = record.getField("VCPTooltip");
		//testDataHandler.SCMICPTooltip = record.getField("SCMICPTooltip");
		//testDataHandler.SCMICPTooltip = record.getField("ARTooltip");
		//testDataHandler.SCMICPTooltip = record.getField("RaPETooltip");
		
		return testDataHandler;
	}
	//updated for review
	public static int getRowContains(int colNum, String sTestCaseName) throws Exception{
		int i;

		try {
			
			int rowCount = getRowUsed();
			int ctr=0;
			selectedRows = new int[rowCount];
			for ( i=1 ; i <= rowCount; i++){
  				if  (getCellData(i,colNum).contains(sTestCaseName)){
  					numRow++;
  					selectedRows[ctr] = i;
  					last =i;
  					ctr++;
				} 
			}
			
			outer:
			for ( i=1 ; i < rowCount; i++){
  				if  (getCellData(i,colNum).contains(sTestCaseName)){
  					start = i;
	    			break outer;
				} 
			}
			
			return i;
				}catch (Exception e){
			throw(e);
			}
		}
	
	private static int getRowUsed() throws Exception {
			try{
				int RowCount = ExcelWSheet.getLastRowNum();
				return RowCount;
			}catch (Exception e){
				System.out.println(e.getMessage());
				throw (e);
			}

		} 
	
	 //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	 private static String getCellData(int RowNum, int ColNum) throws Exception{
	      String CellData = null;

	  	try{	        	   
	      	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);	        	  
	      	  //Cell.setCellType(Cell.CELL_TYPE_STRING);
	      	  CellData = Cell.getStringCellValue();
	       
	  	  		return CellData;
	            
	            }catch (Exception e){
	              return"";
	            }
	  }	  
	 
	 //UPDATED: for review
	public static void loadIterativeTestData(String sheetName,  String sTestCaseName) throws Exception { 
		//These steps iterates the input of Worksheet information which are derived from excel
		FileInputStream ExcelFile = new FileInputStream("./src/test/resources/data/VIPTestDataHandler.xlsx");
		ExcelWBook = new XSSFWorkbook(ExcelFile);
	    ExcelWSheet = ExcelWBook.getSheet(sheetName);
        int startRow = getRowContains(0, sTestCaseName);
        System.out.println("[Test Data] Start Row with data is:  "+ startRow);
        System.out.println("[Test Data] Last Row with data is:  "+ last);
	}
	
	//UPDATED: for review
	public static String writeCellValue(int RowNum, int ColNum, String text) throws Exception{
			      String text1 = "exception error";
			  	try{	
			  		  
			  		  
			      	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			      	  if(Cell==null)
			      	  {
			      		  Cell =ExcelWSheet.getRow(RowNum).createCell(ColNum);
			      	  }
			      	  System.out.println("setCellValue Row Number: "+RowNum+" and colnum "+ColNum);      	 
			      	  Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);   
			      	  System.out.println("success");
			      	  String filepath = "./src/test/resources/data/VIPTestDataHandler.xlsx";
			      	  Cell.setCellValue(text); 
			      	  FileOutputStream webdata = new FileOutputStream(filepath);
			      	 
			      	  if(RowNum <= last)
			      		  ExcelWBook.write(webdata);
			      	  
			      	  return text1;            
			            }catch (Exception e){
			            	return text1;
			            }
			  	}

	public static String getExcelData(String filePath, String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
		
		//Create an object of File class to open file
		File file =    new File(filePath);
		        
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		        
		//Creating workbook instance that refers to file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		        
		//Creating a Sheet object using the sheet Name
		XSSFSheet sheet = wb.getSheet(sheetName);
		        
		//Create a row object to retrieve row at desired row number
		XSSFRow row = sheet.getRow(rowNum);
		        
		//Create a cell object to retrieve cell at at desired column number
		XSSFCell cell = row.getCell(colNum);
		        
		//Get the value in a variable
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			double data = cell.getNumericCellValue(); 
			return Double.toString(data);
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			String data = cell.getStringCellValue(); 
			return data;
		}
		else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			String data = cell.getStringCellValue(); 
			return data;
		}
		else {
			double data = cell.getNumericCellValue();
			return Double.toString(data);
		}
		
		
	}
	
	public static Double getLastRowDataByColumnName(String filePath, String sheetName , String columnName) throws IOException {
    	
    	FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet worksheet = workbook.getSheet(sheetName);
 
        int r = worksheet.getLastRowNum();
        XSSFRow row2 = worksheet.getRow(r);
        
        XSSFRow row = worksheet.getRow(1);
        
        int col_num = -1;
 
        for(int i=1; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(columnName))
                col_num = i;
        }
 
        XSSFCell cell = row2.getCell(col_num);
 
       Double value = cell.getNumericCellValue();
       return value;
    	
    }
	
	public static void deleteRow(String filePath, int column) throws IOException, InvalidFormatException {
        
        Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
        Sheet worksheet = workbook.getSheetAt(0);
        worksheet.shiftRows(column, worksheet.getLastRowNum(), -1);
        workbook.write(new FileOutputStream(filePath));
    	
    }
	
	static Presentation ppt;
	public static void initPPT(String path) throws Exception {
		  ppt = new Presentation();
		  ppt.loadFromFile(path);
	} 
	
	public static String getPPTSpeakerNotes(int slideNumber) throws Exception {
        
        //Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Get the content of notes from note slide
        String notes = slide.getNotesSlide().getNotesTextFrame().getText();
        
        return notes;
    	
    }
	
	public static String getPPTText(int slideNumber, int textNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Loop through the selected slides and extract the texts  
        StringBuilder buffer = new StringBuilder();
        String text = null;
        
        for (Object shape : ((ISlide) slide).getShapes()) {
            if (shape instanceof IAutoShape) {
                for (Object tp : ((IAutoShape) shape).getTextFrame().getParagraphs()) {
                    buffer.append(((ParagraphEx) tp).getText());
                    buffer.append("\n");
                    text =  buffer.toString();
                }
            }
        }
        
        String[] texts = text.split("\\n");
        return texts[textNumber - 1];
    	
    }
	
	public static void verifyPPTText(int slideNumber, int textNumber, String text1) throws Exception {
		
		String text2 = getPPTText(slideNumber, textNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
	public static String getPPTTableText(int slideNumber, int shapeNumber, int columnNumber, int rowNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Extract the texts inside the table  
        ITable table = (ITable) slide.getShapes().get(shapeNumber - 1);
        String text = table.get(columnNumber - 1, rowNumber - 1).getTextFrame().getText();
        return text;
    }
	
	public static void verifyPPTTableText(int slideNumber, int shapeNumber, int columnNumber, int rowNumber, String text1) throws Exception {
		
		String text2 = getPPTTableText(slideNumber, shapeNumber, columnNumber, rowNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
	public static String getPPTTextFontSize(int slideNumber, int textNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Loop through the selected slides and extract the texts  
        StringBuilder buffer = new StringBuilder();
        String text = null;
        
        for (Object shape : ((ISlide) slide).getShapes()) {
            if (shape instanceof IAutoShape) {
                for (Object tp : ((IAutoShape) shape).getTextFrame().getParagraphs()) {
                	float fontSize1 = (((ParagraphEx) tp).getTextRanges().get(0).getFontHeight());
                	String fontSize = Float.toString(fontSize1);
                    buffer.append(fontSize);
                    buffer.append("\n");
                    text =  buffer.toString();
                }
            }
        }
        
        String[] texts = text.split("\\n");
        return texts[textNumber - 1];
    	
    }
	
	public static void verifyPPTTextFontSize(int slideNumber, int textNumber, String text1) throws Exception {
		
		String text2 = getPPTTextFontSize(slideNumber, textNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
	public static String getPPTTableTextFontSize(int slideNumber, int shapeNumber, int columnNumber, int rowNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Extract the texts inside the table  
        ITable table = (ITable) slide.getShapes().get(shapeNumber - 1);
        float font = table.get(columnNumber - 1, rowNumber - 1).getTextFrame().getTextRange().getFontHeight();
        String text = Float.toString(font);
        return text;
    }
	
	public static void verifyPPTTableTextFontSize(int slideNumber, int shapeNumber, int columnNumber, int rowNumber, String text1) throws Exception {
		
		String text2 = getPPTTableTextFontSize(slideNumber, shapeNumber, columnNumber, rowNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
	public static String getPPTTextFontColor(int slideNumber, int textNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Loop through the selected slides and extract the texts  
        StringBuilder buffer = new StringBuilder();
        String text = null;
        
        for (Object shape : ((ISlide) slide).getShapes()) {
            if (shape instanceof IAutoShape) {
                for (Object tp : ((IAutoShape) shape).getTextFrame().getParagraphs()) {
                	Color color1 = (((ParagraphEx) tp).getTextRanges().get(0).getFill().getSolidColor().getColor());
                	String color = color1 + "";
               
                	Color PURPLE = new Color(117, 0, 192);
                	Color DARKGRAY = new Color(89, 89, 89);
                	
                	if (color1.equals(Color.BLUE)) {
                		color = "Blue";
                	}
                	
                	else if (color1.equals(Color.RED)) {
                		color = "Red";
                	}
                	
                	else if (color1.equals(Color.GREEN)) {
                		color = "Green";
                	}
                	
                	else if (color1.equals(Color.BLACK)) {
                		color = "Black";
                	}
                	
                	else if (color1.equals(Color.WHITE)) {
                		color = "White";
                	}
                	
                	else if (color1.equals(Color.YELLOW)) {
                		color = "Yellow";
                	}
                	
                	else if (color1.equals(DARKGRAY)) {
                		color = "Dark Gray";
                	}
                	
                	else if (color1.equals(PURPLE)) {
                		color = "Purple";
                	}
                	
                	else {
                		color = "Color not yet included. Please add it.";
                	}
                	
                    buffer.append(color);
                    buffer.append("\n");
                    text =  buffer.toString();
                }
            }
        }
        
        String[] texts = text.split("\\n");
        return texts[textNumber - 1];
    	
    }
	
	public static void verifyPPTTextFontColor(int slideNumber, int textNumber, String text1) throws Exception {
		
		String text2 = getPPTTextFontColor(slideNumber, textNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
	public static String getPPTTableTextFontColor(int slideNumber, int shapeNumber, int columnNumber, int rowNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Extract the texts inside the table  
        ITable table = (ITable) slide.getShapes().get(shapeNumber - 1);
        Color color1 = table.get(columnNumber - 1, rowNumber - 1).getTextFrame().getTextRange().getFill().getSolidColor().getColor();
        String color = color1.toString();
        
        Color PURPLE = new Color(117, 0, 192);
    	
    	if (color1.equals(Color.BLUE)) {
    		color = "Blue";
    	}
    	
    	else if (color1.equals(Color.RED)) {
    		color = "Red";
    	}
    	
    	else if (color1.equals(Color.GREEN)) {
    		color = "Green";
    	}
    	
    	else if (color1.equals(Color.BLACK)) {
    		color = "Black";
    	}
    	
    	else if (color1.equals(Color.WHITE)) {
    		color = "White";
    	}
    	
    	else if (color1.equals(Color.YELLOW)) {
    		color = "Yellow";
    	}
    	
    	else if (color1.equals(PURPLE)) {
    		color = "Purple";
    	}
        return color;
    }
	
	public static void verifyPPTTableTextFontColor(int slideNumber, int shapeNumber, int columnNumber, int rowNumber, String text1) throws Exception {
		
		String text2 = getPPTTableTextFontColor(slideNumber, shapeNumber, columnNumber, rowNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
	public static String getPPTTextFontStyle(int slideNumber, int textNumber) throws Exception {
        
		//Get the first slide
        ISlide slide = ppt.getSlides().get(slideNumber - 1);

        //Loop through the selected slides and extract the texts  
        StringBuilder buffer = new StringBuilder();
        String text = null;
        
        for (Object shape : ((ISlide) slide).getShapes()) {
            if (shape instanceof IAutoShape) {
                for (Object tp : ((IAutoShape) shape).getTextFrame().getParagraphs()) {
                	String style = null;
                	if ((((ParagraphEx) tp).getTextRanges().get(0).getLatinFont() != null)) {
                		style = (((ParagraphEx) tp).getTextRanges().get(0).getLatinFont().getFontName());
                	}
                	else if ((((ParagraphEx) tp).getTextRanges().get(0).getComplexScriptFont() != null)) {
                		style = (((ParagraphEx) tp).getTextRanges().get(0).getComplexScriptFont().getFontName());
                	}
                	else if ((((ParagraphEx) tp).getTextRanges().get(0).getDefaultLatinFont() != null)) {
                		style = (((ParagraphEx) tp).getTextRanges().get(0).getDefaultLatinFont().getFontName());
                	}
                	else if ((((ParagraphEx) tp).getTextRanges().get(0).getEastAsianFont() != null)) {
                		style = (((ParagraphEx) tp).getTextRanges().get(0).getEastAsianFont().getFontName());
                	}
                	else if ((((ParagraphEx) tp).getTextRanges().get(0).getSymbolFont() != null)) {
                		style = (((ParagraphEx) tp).getTextRanges().get(0).getSymbolFont().getFontName());
                	}
                	
                    buffer.append(style);
                    buffer.append("\n");
                    text =  buffer.toString();
                }
            }
        }
        
        String[] texts = text.split("\\n");
        return texts[textNumber - 1];
    	
    }
	
	public static void verifyPPTTextFontStyle(int slideNumber, int textNumber, String text1) throws Exception {
		
		String text2 = getPPTTextFontStyle(slideNumber, textNumber);
		
		if (text2.equals(text1)) {
			ReportLog.passed("Verify Text is equals: " + text1);
		}
		else {
			ReportLog.failed("Verify Text is equals: " + text1 + " | " + "Actual Text is equals: " + text2);
		}
		
	}
	
}
