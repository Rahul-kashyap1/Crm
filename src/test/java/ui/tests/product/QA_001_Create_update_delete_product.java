package ui.tests.product;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.TestListeners;
import Home.Home;
import Products.ProductsPage;
import Utility.Methods;
import loginPage.LoginPage;

public class QA_001_Create_update_delete_product extends Methods {

	@Test
	public void create_Product() {
		try {
			TestListeners test = new TestListeners();
			ExtentTest reference = test.testReference();
			LoginPage login = new LoginPage();
			login.login(reference);
			Home home = new Home();
			ProductsPage product = new ProductsPage();
			switchToFrameByElement(home.frameElement);
			click(home.productsTab);
			reference.log(reference.getStatus(), "Click on Product button");
			click(product.newProduct);
			reference.log(reference.getStatus(), "Click on New Product");
			product.create_Product("create");
			Assert.assertTrue(product.productDisplay);
			reference.log(reference.getStatus(), "Product is created successfully");
			click(product.editButton);
			reference.log(reference.getStatus(), "Click on Edit Button");
			product.create_Product("create");
			Assert.assertTrue(product.productDisplay);
			reference.log(reference.getStatus(), "product is updated successfully");
			click(home.productsTab);
			reference.log(reference.getStatus(), "Click on Product Tab");
			product.create_Product("delete");
			reference.log(reference.getStatus(), "Click on Delete Button");
			Assert.assertFalse(product.productDisplay);
			reference.log(reference.getStatus(), "Product is Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
