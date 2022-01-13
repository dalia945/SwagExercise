package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.Constants;
import utility.ExcelUtils;

public class AddCus_throughXl extends BaseTest {
	// creating object of ExcelUtils class
	static ExcelUtils excelUtils = new ExcelUtils();
	 static String excelFilePath =Constants.Path_TestData+Constants.File_TestData;

	@Test(priority = 0)
	public void loginCusts() throws Exception {
		log.info("Home page is launched");
		lp.loginAll(prop.getProperty("un"), prop.getProperty("pwd"));
		//searchcust.searchTheCustomer();
	}

	@Test(priority = 1)
	public void RegistrationDataDrivernTest() throws Exception {
		excelUtils.setExcelFile(excelFilePath, "customer");

		// iterate over all the row to print the data present in each cell.
		for (int i = 1; i <= excelUtils.getRowCountInSheet(); i++) {
			log.info("Click on Add New button");
			searchcust.searchTheCustomer();
			addCust.clickAdd();
			log.info("Enter Email Id");
			addCust.addEmail(excelUtils.getCellData(i, 0));
			log.info("Enter password ");
			addCust.addPwd(excelUtils.getCellData(i, 1));
			log.info("Enter first name");
			addCust.addFn(excelUtils.getCellData(i, 2));
			log.info("Enter last name");
			addCust.addLn(excelUtils.getCellData(i, 3));
			log.info("Enter comapny name");
			addCust.addCompany(excelUtils.getCellData(i, 4));
			log.info("Click on save button");
			addCust.saveCust();
			// Verify the confirmation message
//			String message="The new customer has been added successfully.";
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.linkText(message)));
//			
//			Thread.sleep(3000);
			
			//boolean confirm = driver.getPageSource().contains(message);
			Thread.sleep(4000);
			WebElement confirmationMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissable')]"));
			System.out.println( "message is:"+confirmationMessage.getText());
//			WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(@class'content-wrapper']//div"));

			// check if confirmation message is displayed
			if (confirmationMessage.isDisplayed()) {
				excelUtils.setCellValue(i, 5, "FAIL", excelFilePath);
			} else {
				excelUtils.setCellValue(i, 5, "PASS", excelFilePath);
				
				
			}
		}
	}

}
