package retail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.pom.DashboardPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumLevelTests {

	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	LoginPOM loginPOM;
	DashboardPOM dashboard;
	ProductsPOM productsPOM;

	@BeforeClass
	public void initialization() throws IOException {
		prop = new Properties();
		fis = new FileInputStream(
				"C:\\Users\\IBM_ADMIN\\git\\Reskill\\final-framework-testng\\resources\\others.properties");
		prop.load(fis);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		productsPOM=new ProductsPOM(driver);
	}

	@Test(priority = 2)
	public void rTTC_040() throws IOException, InterruptedException {
		driver.get(prop.getProperty("baseURL"));
		driver.get(prop.getProperty("baseURL"));
		loginPOM.sendUsername("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLogin();
		String title = dashboard.pageTitle();
		Assert.assertEquals(title, "Dashboard");
		dashboard.clickNavigationBar();
		dashboard.clickCatalog();
		dashboard.clickCategories();
		dashboard.clickAustraliaCheckbox();
		dashboard.clickCategoryNameCheckbox();
		dashboard.delete();
		dashboard.alert();
		String s = dashboard.getTextSuccessMessage();
//		System.out.print(s);
		Assert.assertEquals(s, "Success: You have modified categories!\n" + "×");
	}

	@Test(priority = 1)
	public void rTTC_041() throws IOException, InterruptedException {
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("baseURL"));
		loginPOM.sendUsername("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLogin();
		String title = dashboard.pageTitle();
		Assert.assertEquals(title, "Dashboard");
		dashboard.clickNavigationBar();
		dashboard.clickCatalog();
		dashboard.clickProducts();
		dashboard.clickOnProductName("Integer vitae iaculis massa");
		dashboard.clickFilter();
		List<WebElement> s1 = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		for (WebElement s : s1) {
			Assert.assertTrue(s.getText().toLowerCase().contains("integer vitae iaculis massa"));
		}
		dashboard.clickOnPrice("515");
		dashboard.clickFilter();
		Thread.sleep(2000);
		List<WebElement> s2 = driver.findElements(By.xpath("//tbody/tr/td[5]"));
		for (WebElement s : s2) {
			Assert.assertTrue(s.getText().toLowerCase().contains("515"));
		}
		dashboard.clickOnStatus("Enabled");
		dashboard.clickFilter();
		List<WebElement> s3 = driver.findElements(By.xpath("//tbody/tr/td[7]"));
		for (WebElement s : s3) {
			Assert.assertTrue(s.getText().toLowerCase().contains("enabled"));
		}
		dashboard.clickOnModel("SKU-003");
		dashboard.clickFilter();
		List<WebElement> s4 = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		for (WebElement s : s4) {
			Assert.assertTrue(s.getText().toLowerCase().contains("sku-003"));
		}
		dashboard.clickOnQuantity("49");
		dashboard.clickFilter();
		List<WebElement> s5 = driver.findElements(By.xpath("//tbody/tr/td[6]"));
		for (WebElement s : s5) {
			Assert.assertTrue(s.getText().toLowerCase().contains("49"));
		}
		dashboard.clickOnImage("Enabled");
		dashboard.clickFilter();
		List<WebElement> s6 = driver.findElements(By.xpath("//tbody/tr/td[2]/img"));
		for (WebElement s : s6) {
			Assert.assertFalse(s.getAttribute("src").contains("no_image"));
		}
		List<WebElement> finalValues = driver.findElements(By.xpath("//tbody/tr[1]/td"));
		for (WebElement f : finalValues) {

			System.out.print(f.getText() + " , ");
		}
        driver.findElement(By.cssSelector("i.fa.fa-sign-out.fa-lg")).click();

	}


	@Test(priority = 3)
	public void rTTC_042() throws IOException, InterruptedException {
		driver.get(prop.getProperty("baseURL"));
		loginPOM.sendUsername("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLogin();
		String title = dashboard.pageTitle();
		Assert.assertEquals(title, "Dashboard");
		dashboard.clickNavigationBar();
		dashboard.clickCatalog();
		dashboard.clickProducts();
		dashboard.clickAddNewIcon();
		productsPOM.EnterproductName("Finger Ring");
		productsPOM.EnterMetaTagTitle("Finger Ring for ladies");
		productsPOM.clickDatalink();
		productsPOM.EnterModel("SKU-012");
		productsPOM.EnterPrice("500");
		productsPOM.EnterQuantity("50");
		productsPOM.clickLinkslink();
		productsPOM.clickCategory();
		productsPOM.clickSaveButton();
		String msg=productsPOM.validateModifiedSuccessmsg();
		Assert.assertEquals(msg, "Success: You have modified products!\n" + "×");

}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}	
}
