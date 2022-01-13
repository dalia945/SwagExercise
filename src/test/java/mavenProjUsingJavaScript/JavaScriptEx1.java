package mavenProjUsingJavaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptEx1 {
	WebDriver driver;
@BeforeTest
public void LaunchApp()
{
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
@AfterTest
public void CloseApp() throws InterruptedException
{
   Thread.sleep(2000);
//   driver.close();
}
@Test
public void ProdSelect() throws InterruptedException {
//	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	driver.findElement(By.xpath("//input[@name='q']")).click();
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
//	WebElement y = driver.findElement(By.xpath("((//span[text() = '8% off']//ancestor::div)[19]//div[@class='_4rR01T']//ancestor::div//preceding-sibling::div)[307]"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].scrollIntoView();", y);
	WebElement x = driver.findElement(By.xpath("(//span[text() = '8% off']//ancestor::div)[19]//div[@class='_4rR01T']"));
	
	Thread.sleep(2000);
//	js.executeScript("arguments[0].scrollIntoView();", x);
    String str = x.getText();
    System.out.println("Phone Model is:"+ str);
	x.click();
	Thread.sleep(2000);
//	
//	WebElement y=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style'])[3]/div[2]/span"));
//	js.executeScript("arguments[0].scrollIntoView();", y);
//	Thread.sleep(2000);
//	String str1=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style'])[3]/div[2]/span")).getText();
//	System.out.println("Text is:"+ str1);
	
	
////	WebElement x = driver.findElement(By.xpath("(//img[@alt='test'])[12]"));
////	WebElement x = driver.findElement(By.xpath("(//img[@alt='Save Big on Electronic Accessories'])[2]"));
//	WebElement x = driver.findElement(By.xpath("(//li[@class='feed-carousel-card _deals-shoveler-v2_style_dealCard__1HqkZ'])[22]/following-sibling::li[1]"));
////	WebDriverWait wait = new WebDriverWait(driver,12);
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	Thread.sleep(2000);
//	js.executeScript("arguments[0].scrollIntoView();", x);
//	x.click();
//	
//	js.executeScript("arguments[0].click()", x);
	
	
	
}
}
