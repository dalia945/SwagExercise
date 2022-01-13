package pomTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCustomer extends BaseTest {

	@Test(priority = 0)
	public void loginCusts() throws Exception {
		lp.loginAll(prop.getProperty("un"), prop.getProperty("pwd"));

	}

	@Test(priority = 1)
	public void clickCustomer1() throws Exception {
		Thread.sleep(1000);
		log.info("Click on customer tab");
		searchcust.clickCustomer();
	}

	@Test(priority = 2)
	public void clickSubCustomer2() throws InterruptedException {
		Thread.sleep(2000);
		log.info("Click on sub customer tab");
		searchcust.clickSubCustomers();
	}

	@Test(priority = 3)
	public void searchTheCustomer() throws InterruptedException {
		Thread.sleep(4000);
		log.info("Click on search text");
		Thread.sleep(2000);
		searchcust.clickSearchText();
		log.info("Enter the email id");
		Thread.sleep(2000);
		searchcust.searchCust(prop.getProperty("un"));
		log.info("Click on search button");
		Thread.sleep(4000);
		searchcust.clickSearchcust();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='admin@yourStore.com']")));
		WebElement admin = driver.findElement(By.xpath("//td[text()='admin@yourStore.com']"));
		String adminText=driver.findElement(By.xpath("//td[text()='admin@yourStore.com']")).getText();
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].scrollIntoView()", admin);
		Assert.assertTrue(prop.getProperty("un").contains("admin"), "The data is find");
		Assert.assertEquals(adminText, "admin@yourStore.com");
		
	}
}
