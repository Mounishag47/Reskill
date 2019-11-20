package retail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.DashboardPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RetailHomePOM;
import com.training.pom.RetailProductInfoPOM;
import com.training.pom.RetailSearchResultsPOM;
import com.training.pom.RetailShoppingCartPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EasyLevelTests {
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	LoginPOM loginPOM;
	DashboardPOM dashboard;
	RetailHomePOM retailHomePOM;
	RetailProductInfoPOM retailProductInfoPOM;
	RetailSearchResultsPOM retailSearchResultsPOM;
	RetailShoppingCartPOM retailShoppingCartPOM;

	@BeforeClass
	public void initialization() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(
				"C:\\Users\\IBM_ADMIN\\git\\Reskill\\final-framework-testng\\resources\\others.properties");
		prop.load(fis);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		retailHomePOM = new RetailHomePOM(driver);
		retailSearchResultsPOM = new RetailSearchResultsPOM(driver);
		retailProductInfoPOM = new RetailProductInfoPOM(driver);
		retailShoppingCartPOM = new RetailShoppingCartPOM(driver);
	}

	@Test(priority = 1)
	public void rTTC_010() throws IOException, InterruptedException {
		driver.get(prop.getProperty("RetailURL"));
		retailHomePOM.mouseHoverSearch();
		retailHomePOM.clickSearchField();
		retailHomePOM.enterSearchField("ring");
		retailHomePOM.clickSearch();
		retailSearchResultsPOM.selectearRingProd();
		retailProductInfoPOM.addToCart();
		String text = retailProductInfoPOM.cartPopupText();
		Assert.assertEquals(text, "Shopping Cart updated!");
		retailProductInfoPOM.cartPopupClose();
		retailProductInfoPOM.mouseHovershoppingCart();
		retailProductInfoPOM.viewCart();
		retailShoppingCartPOM.removeProduct();
		retailShoppingCartPOM.removeProduct();
		driver.navigate().refresh();
		String text2 = retailShoppingCartPOM.cartEmptyText();
		Assert.assertEquals(text2, "Your shopping cart is empty!");

	}

	@Test(priority = 2)
	public void rTTC_011() throws IOException, InterruptedException {
		driver.get(prop.getProperty("baseURL"));
		loginPOM.sendUsername("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLogin();
		String title = dashboard.pageTitle();
		Assert.assertEquals(title, "Dashboard");
	}

	@Test(priority = 3,dependsOnMethods= {"rTTC_011"})
	public void rTTC_012() throws IOException, InterruptedException {
		dashboard.clickNavigationBar();
		dashboard.clickCatalog();
		dashboard.clickCategories();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
