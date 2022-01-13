package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "(//p[contains(text(),'Customers')])[1]")
	WebElement clickOnCustomer;

	@FindBy(xpath = "(//a[@href='/Admin/Customer/List'])[1]")
	WebElement clickOnSubCustomer;
	@FindBy(xpath="//div[contains(text(),'Search')]")
	WebElement clickSearchtext;

	@FindBy(name =  "SearchEmail")
	WebElement searchemail;
	
	@FindBy(css = "button#search-customers")
	WebElement searchClick;

	public void clickCustomer() {
		clickOnCustomer.click();
	}

	public void clickSubCustomers() {
		clickOnSubCustomer.click();
	}
	public void clickSearchText() {
		clickSearchtext.click();
	}

	public void searchCust(String un) {
		searchemail.sendKeys(un);
	}

	public void clickSearchcust() {
		searchClick.click();
	}
	public void searchTheCustomer() {
		clickCustomer();
		clickSubCustomers();
	}
}
