package swagLabs_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver rdriver1) {
		this.driver = rdriver1;
		PageFactory.initElements(rdriver1, this);

	}
	@FindBy(id = "continue-shopping")
	WebElement btnContinueShopping;
@FindBy(xpath = "//div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]")
WebElement Prod;
	public void CartPageValidation() {
	 Prod.isDisplayed();
	 btnContinueShopping.click();
	 
	}
}
