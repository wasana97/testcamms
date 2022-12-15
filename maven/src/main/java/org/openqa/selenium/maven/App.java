package org.openqa.selenium.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class App {
	WebDriver driver;

	By Username = By.xpath("//input[@placeholder='Username']");
	By Password = By.xpath("//input[@placeholder='Password']");
	By LoginButton = By.xpath("//input[@type=\"submit\"]");
	
	By productWithPrice = By.xpath("//div[text()=\"Sauce Labs Fleece Jacket\"]/../../following-sibling::div/div[text()=\"49.99\"]");
	By product = By.xpath("(//button[text()=\"Add to cart\"])");
	
	By cart = By.xpath("//a[@class='shopping_cart_link']");
	By Item = By.xpath("(//div[@class=\"inventory_item_name\"])");
	
	By CheckoutBtn = By.xpath("//button[text()=\"Checkout\"]");
	
	By Firstname = By.xpath("//input[@name=\"firstName\"]");
	By Lastname = By.xpath("//input[@name=\"lastName\"]");
	By PostalCode = By.xpath("//input[@name=\"postalCode\"]");
	By ContinueBtn = By.xpath("//input[@name=\"continue\"]");
	By FinishBtn = By.xpath("//button[@name=\"finish\"]");

	public App(WebDriver driver) {

		this.driver = driver;

	}

	// Set user name in textbox

	public void setUserName(String StrUserName) {

		driver.findElement(Username).sendKeys(StrUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(Password).sendKeys(strPassword);

	}

	// Click on login
	public void clickLogin() {

		driver.findElement(LoginButton).click();

	}

	// Check the price of product
	public void CheckThePrice() {

		if (driver.findElement(productWithPrice) != null) {

			System.out.println("Element is Present");

		} else {

			System.out.println("Element is Absent");

		}
	}

	// Add two products into the cart
	public void AddProductIntoTheCart() {
		String Pro;
		for (int i = 1; i <= 2; i++) {
			Pro = product + "[" + i + "]";
			driver.findElement(product).click();
		
			System.out.println("added");
			
		}

	}

	// Click cart icon in the top
	public void AddToCart() {
		driver.findElement(cart).click();
	}

	// Verify that selected items are in the cart
	public void VerifyItem() {
		String ItemInCart;
		for (int i = 1; i <= 2; i++) {
			ItemInCart = Item + "[" + i + "]";
			if(driver.findElement(Item)!= null){

				System.out.println("Element is Present");
				String ItemName= driver.findElement(Item).getText();
				System.out.println(ItemName);

			}else{

				System.out.println("Element is Absent");

			}

	}}
	
	//Click checkout button
	public void ClickCheckoutBtn() {
		driver.findElement(CheckoutBtn).click();
	}
	
	//Provide a random firstname, lastname and a zip code
	public void FillDetails(String StrFirstName,String StrLastName,String StrPostalCode) {
		driver.findElement(Firstname).sendKeys(StrFirstName);
		driver.findElement(Lastname).sendKeys(StrLastName);
		driver.findElement(PostalCode).sendKeys(StrPostalCode);
		driver.findElement(ContinueBtn).click();
		
	}
	
	public void ClickonFinishBtn() {
		driver.findElement(FinishBtn).click();
		
	}
	
	

	// close the browser
	public void CloseBroser() {
		driver.close();
	}

}
