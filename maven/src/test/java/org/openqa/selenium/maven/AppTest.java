package org.openqa.selenium.maven;

import static org.junit.Assert.assertTrue;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	String driverPath = "C:\\Users\\USER\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
	WebDriver driver;
	App objapp;

	@Before

	public void setup() {

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

	}

	@Test
	public void Test_Swag_Labs() {
		objapp = new App(driver);

		// Login to the applcation
		objapp.setUserName("performance_glitch_user");
		objapp.setPassword("secret_sauce");
		objapp.clickLogin();

		// Check price of procuct
		objapp.CheckThePrice();

		// Add two products into the cart
		objapp.AddProductIntoTheCart();

		// Click cart icon in the top
		objapp.AddToCart();

		// Verify that selected items are in the cart
		objapp.VerifyItem();
		
		//Click on the Check out button
		objapp.ClickCheckoutBtn();
		//Fill Details
		objapp.FillDetails("wasana", "geeganage", "12810");
		
		//click on finish Button
		objapp.ClickonFinishBtn();

		// close the browser
		objapp.CloseBroser();

	}

}
