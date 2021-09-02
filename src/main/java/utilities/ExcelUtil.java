package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static Cell cell;
	public static Row row;
	
	
	public static void setExcelFile() throws IOException{
		
		String file =  System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";
		//create an object of file class to open xlsx file
		File filePath = new File(file);
		//create an object of FilenputStram class to read xlsx fie
		FileInputStream inputStream = new FileInputStream(filePath);
		//create object of XSSF workbook class
		 workBook = new XSSFWorkbook(inputStream);
		//read sheet inside the workbook by its name
		 sheet = workBook.getSheet("Sheet1");
		
	}
	
	public static String getCellData(int rowNum, int columNum){
		DataFormatter formatter = new DataFormatter();
		cell=sheet.getRow(rowNum).getCell(columNum);
		String cellData =formatter.formatCellValue(cell);
		return cellData;
		
	}
}

