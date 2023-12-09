package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;


public class ExcelUtility {
	       @DataProvider(name="logdata")
		    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
			String excelSheetName=m.getName();
		        //File f = new File(System.getProperty("user.dir") +"\\src\\test\\resources\\testdata\\CRM_TESTDATA.xlsx");
		        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\testdata\\CRM_TESTDATA.xlsx");
		        Workbook wb = WorkbookFactory.create(fis);
		        Sheet sheetName = wb.getSheet(excelSheetName);

		        int totalRows = sheetName.getLastRowNum();
		        System.out.println(totalRows);
		        Row rowCells = sheetName.getRow(0);
		        int totalCols = rowCells.getLastCellNum();
		        System.out.println(totalCols);

		        DataFormatter format = new DataFormatter();

		        String testData[][] = new String[totalRows - 1][totalCols]; // Exclude header row
		        for (int i = 1; i < totalRows; i++) {
		            for (int j = 0; j < totalCols; j++) {
		                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
		                //System.out.println(testData[i - 1][j]);
		            }
		        }
		        return testData;
		    }
		}
