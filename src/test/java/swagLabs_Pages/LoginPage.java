package swagLabs_Pages;

	import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

	public class LoginPage {
		WebDriver driver;

		public LoginPage(WebDriver rdriver) {
			this.driver = rdriver;
			PageFactory.initElements(rdriver, this);

		}

		@FindBy(id = "login-button")
		WebElement btnLogin;
		@FindBy(id = "user-name")
		WebElement txtUN;
		@FindBy(id = "password")
		WebElement txtPwd;

		public void titleCheck() throws InterruptedException {
			String LPTitle = driver.getTitle();
			System.out.println("Login pager title is:"+LPTitle);
			Assert.assertTrue(LPTitle.contains("Swag"));
			Thread.sleep(1000);
			String LgBtnMsg = btnLogin.getText();
//			String LgBtnMsg = btnLogin.getAttribute("value");
			System.out.println("Login Text is:"+LgBtnMsg);
			if(LgBtnMsg.equals(LgBtnMsg.toUpperCase())){
			System.out.println("Login Button text is in uppercase");
			}
			else {
				System.out.println("Login Button text is in lowercase");
			}
			
		}

		public void login(String un,String pwd) {
			txtUN.sendKeys(un);
			txtPwd.sendKeys(pwd);
			btnLogin.click();
			
		}}