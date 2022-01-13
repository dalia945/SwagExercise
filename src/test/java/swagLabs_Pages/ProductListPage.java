package swagLabs_Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductListPage {
	WebDriver driver;

	public ProductListPage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//select[@class ='product_sort_container']")
	WebElement FilterBox;
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement BackPack;
	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement RedTshirt;
	@FindBy(xpath ="//span[text()='1']")
	WebElement CartCount;
	@FindBy(xpath ="//span[text()='2']")
	WebElement CartCount2;
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement btnRemove_Prod1;
	@FindBy(xpath ="//div[@class='shopping_cart_container']//a[1]")
	WebElement IconCart;
	public void VerifyDefaultDropdownValue() {
		String def = FilterBox.getText();
		Assert.assertTrue(def.contains("Z"));
		
	}
	public void Add_Remove_Prod() throws InterruptedException {
		
		BackPack.click();
	    Thread.sleep(2000);
		String Count = CartCount.getText();
		Assert.assertTrue(Count.contains("1"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView;", RedTshirt);
		RedTshirt.click();
		Thread.sleep(2000);
		String Count2 = CartCount2.getText();
		Assert.assertTrue(Count2.contains("2"));
		js.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(2000);
		btnRemove_Prod1.click();
		Thread.sleep(2000);
		Assert.assertTrue(Count.contains("1"));
		IconCart.click();
		
		
	}
	
	public void filter() {
		Select List = new Select(FilterBox);
		List.isMultiple();
		List.selectByIndex(8);
	}
//	Select List = new Select(ListBox);
//	List.isMultiple();
//	Assert.assertEquals(true, List.isMultiple());
//	Assert.assertEquals("List is not Multiple", true, List.isMultiple());
//	List.selectByIndex(1);
//	List.selectByValue("Japan");

}
