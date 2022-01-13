package ParalleleExe;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowhandleEx1 {
WebDriver driver;
@BeforeTest
public void openApp() {
	WebDriverManager.chromedriver().setup();
//	ChromeOptions option = new ChromeOptions();
//	option.addArguments("--headless");
	driver= new ChromeDriver();
	driver.get("http://www.uitestpractice.com/Students/Switchto");
	driver.manage().window().maximize();
	
}
@Test 
public void Login() throws InterruptedException, IOException {
//	ChromeOptions option = new ChromeOptions();
//	option.addArguments("--headless");
//	driver= new ChromeDriver(option);
//	driver.get("http://www.uitestpractice.com/Students/Switchto");
//	driver.manage().window().maximize();
	Thread.sleep(2000);
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//button[@data-target='#myModal']"))).click().build().perform();
	Thread.sleep(3000);
//	driver.findElement(By.xpath("//button[@data-target='#myModal']")).click();
	WebElement x = driver.findElement(By.xpath("//h4[text()='Modal window demo']"));
	Thread.sleep(2000);
//	WebElement x = driver.findElement(By.xpath("//h4[@class='modal-title']"));
	String text1 = x.getText();
	System.out.println("Popup header is:"+text1);
	WebElement y = driver.findElement(By.xpath("//div[@class='modal-body']"));
	String text2 = y.getText();
//	Assert.assertEquals(text1, "Modal window demo");
	System.out.println("Popup content is:"+text2);
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	File targetLocation= new File("C:\\Users\\admin\\eclipse-workspace\\com.org.lnt.Finance\\resultscreenshot\\screen.png");
//	FileUtils.copyFile(targetLocation, screenshotFile);
//	WebElement x = driver.findElement(By.xpath("//button[text()='OK']"));
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("arguments[0].scrollIntoView;", x);
//	x.click();
//	Thread.sleep(1000);
//	String HomeWindow = driver.getWindowHandle();
//	driver.findElement(By.xpath("(//a[@href='https://www.hotel.irctctourism.com/'])[1]")).click();
//	Set<String> AllWindowHandles = driver.getWindowHandles();
//	String Window1 = (String) AllWindowHandles.toArray()[0];
//	System.out.println("1st Window id is:"+ Window1);
//	String Window2 = (String) AllWindowHandles.toArray()[1];
//	System.out.println("2nd window id is:"+ Window2);
//	
//	driver.switchTo().window(Window2);
//	driver.findElement(By.linkText("Login")).click();
//	driver.findElement(By.name("username")).sendKeys("dhgh");
//	driver.findElement(By.name("password")).sendKeys("hjkihnhdf");
//	driver.findElement(By.xpath("//button[text()='Login']")).click();
//	Thread.sleep(2000);
//	WebElement Y = driver.findElement(By.xpath("//p[text()='Invalid User details']"));
//	String Error1 = Y.getText();
//	System.out.println("error msg is:"+ Error1);
//	Assert.assertEquals(Error1, "Invalid User details");
//	Assert.assertTrue(Error1.contains("User"));
//	driver.switchTo().window(Window1);
//	driver.findElement(By.xpath("//span[text()='AGENT LOGIN']")).click();
//	Thread.sleep(2000);
//	WebElement z = driver.findElement(By.xpath("//h2[text()='Agent Login With Otp']"));
////	String PopupMsg = z.getText();
//	System.out.println("Popup msg is:"+ z.getText());
////	Assert.assertTrue(PopupMsg.contains("Otp"));
//	
//	driver.findElement(By.xpath("//span[@class='fare-detail-popup-close-sign fa fa-window-close fa-lg']")).click();
//String Title =driver.getTitle();
//System.out.println("home page title is:"+ Title);
	
}
@AfterTest
public void closeApp() throws InterruptedException {
	Thread.sleep(2000);
	driver.quit();
}
}
