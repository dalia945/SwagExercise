package crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserExample {
	
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))	{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
//			driver.get("http://www.uitestpractice.com/Students/Switchto");
		}
	}
	@Test
	public void login() throws InterruptedException {
		driver.get("http://www.uitestpractice.com/Students/Switchto");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//button[@data-target='#myModal']"))).click().build().perform();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@data-target='#myModal']")).click();
		WebElement x = driver.findElement(By.xpath("//h4[text()='Modal window demo']"));
		Thread.sleep(2000);
//		WebElement x = driver.findElement(By.xpath("//h4[@class='modal-title']"));
		String text1 = x.getText();
		System.out.println("Popup header is:"+text1);
	}
}
