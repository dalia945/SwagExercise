package pomTests;

import java.io.FileInputStream;
import java.util.Properties;

//import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.AddCustomerPage;
import pomPages.LoginPage;
import pomPages.SearchPage;
import utility.Constants;
import utility.ExcelUtils;

public class BaseTest {
	WebDriver driver;
	Properties prop;
	LoginPage lp;
	SearchPage searchcust;
	AddCustomerPage addCust;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	Logger log;
	

	public void readConfig() throws Throwable {
		String configPath = Constants.Configprop_filepath;
		FileInputStream fis= new FileInputStream(configPath);
		prop = new Properties();
		prop.load(fis);
	}

	
//	public static String randomestring(){
////		String generatedString1 = RandomStringUtils.randomAlphabetic(8);
////		return (generatedString1);
//		}
	@BeforeClass
	public void openBrowser() throws Throwable {
		 log = Logger.getLogger("LT_Logger");
		    PropertyConfigurator.configure(Constants.Log4j_path);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		searchcust = new SearchPage(driver);
		addCust=new AddCustomerPage(driver);
		readConfig();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	}
