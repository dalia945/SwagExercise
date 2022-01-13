package dataThroughExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XldataEx {

	public static void main(String[] args) throws IOException {
		  
        FileInputStream fis = new FileInputStream("./testData/TesData.xls");
        
        
        //Control file using POI jar  -XSSFWorkbook xlsx file format
        //xls - HSSFWorkbook
        
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        
        HSSFSheet sheet = workbook.getSheet("smoke");
        
        int rowCount = sheet.getLastRowNum();
        
        int columnCount = sheet.getRow(0).getLastCellNum();
        
        System.out.println("Row Count are: " + rowCount);       //3
        System.out.println("Column Count are: " + columnCount); //5
        
        
        for(int i = 1; i<=rowCount; i++) {
            
            HSSFRow currentRow = sheet.getRow(i);
            
            
            String userName = currentRow.getCell(0).toString();
            String password = currentRow.getCell(1).toString();
            String email = currentRow.getCell(2).toString();
            String phone = currentRow.getCell(3).toString();
            String address = currentRow.getCell(4).toString();
            
            
            System.out.println("UserName information: "+ i + "    " + userName +"     " + password);
            
        }
        
        
        
        
        
        
    }

}
		