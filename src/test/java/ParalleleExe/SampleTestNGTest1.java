package ParalleleExe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTestNGTest1 {
	WebDriver driver;
@BeforeTest
public void LaunchApp()
{
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
//	driver.get("https://www.facebook.com/");
	System.out.println("opening the app");
	}
@AfterTest
public void CloseApp()
{

   driver.close();
	System.out.println("closed the app");
}
@Test
public void Login()
{
	
	driver.get("https://www.facebook.com/");https://www.facebook.com/friends/
	driver.findElement(By.name("email")).click();
	driver.findElement(By.name("email")).sendKeys("priyanataraj004@gmail.com");
	driver.findElement(By.name("pass")).click();
	driver.findElement(By.name("pass")).sendKeys("Kimjiwon@1");
	driver.findElement(By.name("login")).click();
	System.out.println("loged in to the app");
}
@Test
public void Logout() throws InterruptedException
{
	WebDriver driver= new ChromeDriver();
//	driver.findElement(By.name("email")).click();
	driver.get("https://www.facebook.com/");
	driver.findElement(By.name("email")).click();
	driver.findElement(By.name("email")).sendKeys("priyanataraj004@gmail.com");
	driver.findElement(By.name("pass")).click();
	driver.findElement(By.name("pass")).sendKeys("Kimjiwon@1");
	driver.findElement(By.name("login")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//body[@class='_6s5d _71pn _-kb segoe']/div/div/div/div/div[2]/div[4]/div/span/div/div[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	driver.getTitle();
	String Title= driver.getTitle();
	System.out.println("Title is:" + Title);
	System.out.println("loged out from app");
	
}	
}
