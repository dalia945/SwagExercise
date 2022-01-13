package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Add new")
	WebElement clickAddNew;
	@FindBy(id = "Email")
	WebElement txtEmail;
	@FindBy(id = "Password")
	WebElement txtpwd;
	@FindBy(id = "FirstName")
	WebElement txtFn;
	@FindBy(id = "LastName")
	WebElement txtLn;
	@FindBy(id = "Company")
	WebElement txtCompany;
	@FindBy(name = "save")
	WebElement clickSave;
	@FindBy(linkText = "Logout")
	WebElement clickLog;

	public void clickAdd() {
		clickAddNew.click();
	}

	public void addEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void addPwd(String pwd) {
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
	}

	public void addFn(String fn) {
		txtFn.clear();
		txtFn.sendKeys(fn);
	}

	public void addLn(String ln) {
		txtLn.clear();
		txtLn.sendKeys(ln);
	}

	public void addCompany(String company) {
		txtCompany.clear();
		txtCompany.sendKeys(company);
	}

	public void saveCust() {
		clickSave.click();
	}

	public void custLog() {
		clickLog.click();
	}

}
