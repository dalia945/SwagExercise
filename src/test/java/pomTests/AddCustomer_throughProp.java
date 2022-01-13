package pomTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomer_throughProp extends BaseTest {
	@Test(priority = 0)
	public void loginCusts() throws Exception {
		log.info("Home page is launched");
		lp.loginAll(prop.getProperty("un"), prop.getProperty("pwd"));
		searchcust.searchTheCustomer();
	}

	@Test(priority = 1)
	public void addCustomerDetails() throws InterruptedException {
		Thread.sleep(2000);
		log.info("Click on Add New button");
		addCust.clickAdd();
		log.info("Enter Email Id");
//		String randomEmail = randomestring() + "@gmail.com";
//		addCust.addEmail(randomEmail);
//		System.out.println(randomEmail);
		log.info("Enter password ");
		addCust.addPwd(prop.getProperty("password"));
		log.info("Enter first name");
		addCust.addFn(prop.getProperty("fn"));
		log.info("Enter last name");
		addCust.addLn(prop.getProperty("ln"));
		log.info("Enter comapny name");
		addCust.addCompany(prop.getProperty("compnay"));
		log.info("Click on save button");
		addCust.saveCust();
	}

	@Test(priority = 2)
	public void logout() {
		log.info("Click on logout button");
		addCust.custLog();
		System.out.println("The page title is:" + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("store"), "Validation needed");

	}

}
