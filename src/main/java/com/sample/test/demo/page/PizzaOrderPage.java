package com.sample.test.demo.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sample.test.demo.TestBase;
import com.sample.test.util.ElementUtil;

public class PizzaOrderPage extends TestBase{
	
	// Locators
	@FindBy(id = "pizza1Pizza") public WebElement pizza1;
	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']") public WebElement toppings1;
	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']") public WebElement toppings2;
	@FindBy(id = "pizza1Qty") public WebElement pizzaQuantity;
	@FindBy(id = "pizza1Cost") public WebElement pizzaCost;
	@FindBy(id = "ccpayment") public WebElement creditCardPayment;
	@FindBy(id = "cashpayment") public WebElement cashPayment;
	@FindBy(id = "email") public WebElement email;
	@FindBy(id = "name") public WebElement name;
	@FindBy(id = "phone") public WebElement phone;
	@FindBy(id = "placeOrder") public WebElement placeOrderBtn;
	@FindBy(id = "reset") public WebElement buttonRreset;
	@FindBy(id = "dialog") public WebElement msgElement;
	@FindBy(xpath = "//div[@id='dialog']/p") public WebElement dialogBoxText;
	
	// Constractor
	public PizzaOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	public void selectPizza1(String size) {
		ElementUtil.selectByValue(pizza1, size);
	}
	
	public void toppings1(String topping1) {
		ElementUtil.selectByValue(toppings1, topping1);
	}
	
	public void toppings2(String topping2) {
		ElementUtil.selectByValue(toppings2, topping2);
	}
	
	public void pizzaQuantity(String quantity) {
		ElementUtil.sendKeys(pizzaQuantity, quantity);
	}

	public String validatePrice() {
		return ElementUtil.getText(pizzaCost);
	}
	
	public void enterInfo(String nameString, String phoneString, String emailString) {
		name.sendKeys(nameString);
		email.sendKeys(emailString);
		phone.sendKeys(phoneString);
	}
	
	public void paymentMethod(String paymentType) {
		switch (paymentType) {
		case "Credit Card":
			creditCardPayment.click();
			break;
		case "Cash on Pickup":
			cashPayment.click();
			break;
		default:
			break;
		}
	}
	
	public void orderValidate() {
		boolean confirmationFrame = msgElement.isDisplayed();
		Assert.assertTrue(confirmationFrame, "Not Displayed!...");
		String thankYouText = "Thank you for your order! ";
		String boxText = ElementUtil.getText(dialogBoxText);
		Assert.assertTrue(boxText.contains(thankYouText), "Some problem occured!...");
	}
	
	public void validateErrorMsg() {
		boolean confirmationFrame = msgElement.isDisplayed();
		assertTrue(confirmationFrame, "Not Displayed!...");
		String boxText = ElementUtil.getText(dialogBoxText);
		String thankYouText = "Thank you for your order! ";
		Assert.assertTrue(!thankYouText.contains(boxText), "Some problem occured!...");
	}
	
	public void placeOrder() {
		ElementUtil.clickOn(placeOrderBtn);
	}
	
}
