package swagLabsEx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import swagLabs_Pages.CartPage;
import swagLabs_Pages.LoginPage;
import swagLabs_Pages.ProductListPage;
import utility.Constants;
import utility.ExcelUtils;

public class BaseTest {
		WebDriver driver;
//		Properties prop;
		LoginPage lp;
		CartPage cp;
		ProductListPage plp;
		Properties prop;
		Logger log;
		public ExtentHtmlReporter htmlReporter;
	    public ExtentReports extent;
	    public ExtentTest logger;
	    static ExcelUtils excelUtils;
		public  void ConfigReader() throws IOException {
			String ConfFilePath =Constants.Configprop_filepath;
		FileInputStream fis= new FileInputStream(ConfFilePath);
		prop = new Properties();
		prop.load(fis);
		}
		@BeforeTest
	    public void startReport() {
	        // htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
	        // "/test-output/LT_ExtentReport.html");
	        String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        htmlReporter = new ExtentHtmlReporter("./test-output/LT_NOPComm_ExtentReport"+dateName_number+".html");
	        // Create an object of Extent Reports
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	    }
		 public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		        TakesScreenshot ts = (TakesScreenshot) driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        // after execution, you could see a folder "FailedTestsScreenshots" under src
		        // folder
		        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		        File finalDestination = new File(destination);
		        FileUtils.copyFile(source, finalDestination);
		        return destination;
		    }
		
		
		@BeforeClass
		@Parameters("browser")
		public void openBrowser(String browser) throws Throwable {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				
			}
			else if(browser.equalsIgnoreCase("edge"))	{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			lp = new LoginPage(driver);
			cp = new CartPage(driver);
			plp = new ProductListPage(driver);
			ConfigReader();
			 log = Logger.getLogger("LT_Logger");
		    PropertyConfigurator.configure(Constants.Log4j_path);
//			driver.get("https://www.saucedemo.com/");
		    excelUtils = new ExcelUtils();
			  String xlFilePath =Constants.Path_TestData+Constants.File_TestData;
			  excelUtils.setExcelFile(xlFilePath, "Login");
		    log.info("launching the url in Chrome");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			
		}
		 @AfterMethod
		    public void getResult(ITestResult result) throws Exception {
		        if (result.getStatus() == ITestResult.FAILURE) {
		            // MarkupHelper is used to display the output in different colors
		            logger.log(Status.FAIL,
		                    MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		            logger.log(Status.FAIL,
		                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		            String screenshotPath = getScreenShot(driver, result.getName());
//		             To add it in the extent report
		            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		        } 
		        else if (result.getStatus() == ITestResult.SKIP) {
		            logger.log(Status.SKIP,
		                    MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		        } 
		        else if (result.getStatus() == ITestResult.SUCCESS) {
		            logger.log(Status.PASS,
		                    MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		        }
		        
		    }

		@AfterClass
		public void tearDown() throws InterruptedException {
		
			    
			Thread.sleep(3000);
			driver.close();
		}
		 @AfterTest
		    public void endReport() {
		        extent.flush();
		    }
		
		}

