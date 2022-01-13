package swagLabsEx;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {
	@Test
	public void AddProduct() throws InterruptedException {
		logger = extent.createTest("Verify Login");
		 log.info("Performing validations in login page");
		 logger = extent.createTest("Verify Login page Title and Login Button Text");
		lp.titleCheck();
		logger = extent.createTest("Verify Login Fuction");
		log.info("Performing login operation");
		for (int i = 1; i <= excelUtils.getRowCountInSheet(); i++) {
		lp.login(excelUtils.getCellData(i, 0),excelUtils.getCellData(i, 1));
		}
//		lp.login(prop.getProperty("un"),prop.getProperty("pwd"));
		logger = extent.createTest("To verify default filter");
		log.info("Verifying the default filter selection");
		plp.VerifyDefaultDropdownValue();
		logger = extent.createTest("To verify add to cart operation");
		log.info("performing add and remove products");
		plp.Add_Remove_Prod();
		logger = extent.createTest("To verify checkout page");
		log.info("verfying the checkout page");
		cp.CartPageValidation();
		logger = extent.createTest("To verify Sort by low to high price filter ");
		log.info("Applying price low to high filter");
		plp.filter();
		
	}

}
