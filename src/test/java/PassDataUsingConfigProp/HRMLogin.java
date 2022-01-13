package PassDataUsingConfigProp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLogin {
	
	WebDriver driver;
	ConfigPropEx conf;
	@BeforeTest
	public void Openapp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		conf= new ConfigPropEx();	
		}

@Test
public void login() {
	driver.get(conf.getAppURL());
	driver.findElement(By.id("txtUsername")).sendKeys(conf.getAdminuser());
	driver.findElement(By.id("txtPassword")).sendKeys(conf.getAdminPassword());
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
}}