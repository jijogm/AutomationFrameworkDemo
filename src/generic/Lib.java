package generic;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
public class Lib implements IAutoConstant{
	public static Workbook wb;
public static String getCellValue(String excelFileName, String sheetName, int rowNum, int colNum) {
		String cellValue = "";
		try {
			 wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE_PATH + excelFileName+".xlsx"));
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} catch (Exception e) {
			
		}
		return cellValue;
	}
	public static int getRowCount(String excelFileName, String sheetName) {
		int rowCount = 0;
		try {
			 wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE_PATH + excelFileName+".xlsx"));
			 rowCount = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			
		}	
		return rowCount;
	}
	public static String getPropertyValue(String propertyName) {
		String propertyValue="";
		System.out.println(propertyName);
		try {
			System.out.println("try block");
			Properties prop = new Properties();
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
			propertyValue = prop.getProperty(propertyName);
		} catch (Exception e) {
		
		}
		System.out.println(propertyValue);
		return propertyValue;
	}
	public static void captureScreenshot(WebDriver driver, String testMethodName) {
		try {
			String currentDateAndTime = new Date().toString().replaceAll(":", "__");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(SCREENSHOT_PATH + testMethodName+"__"+currentDateAndTime+".png");
			Files.copy(srcFile, destFile);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
