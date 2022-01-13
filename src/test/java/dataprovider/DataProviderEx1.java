package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx1 {
	WebDriver driver;
	
	@BeforeTest
	public void LaunchApp()
	{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("opening the app");
		}
	public void CloseApp()
	{

	   driver.close();
		System.out.println("closed the app");
	}
	@Test(dataProvider = "smoke")
	public void Login(String user, String pass) throws InterruptedException
	{
		
//		driver.get("https://www.facebook.com/");https://www.facebook.com/friends/
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys(user);
		driver.findElement(By.name("pass")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("pass")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
		System.out.println("loged in to the app");
	}

@DataProvider(name = "smoke")
public Object[][] dataTest(){
	Object [][]  data = {{"asdd@gmail.com", "asfgjjkk"},{"ghuyuiui@gmail.com", "kjhiiuyhhnk"}};
	return data;
}}

