package com.sample.test.demo.tests;

import org.testng.annotations.Test;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.page.PizzaOrderPage;

public class DemoTest extends TestBase {

	@Test(priority = 1, description = "verify order")
	public void test1() {
		PizzaOrderPage pOrderPage = new PizzaOrderPage(driver);
		pOrderPage.selectPizza1(PizzaTypes.LARGE_THREETOPPINGS.getDisplayName());
		pOrderPage.toppings1(PizzaToppings.PEPPERONI.getDisplayName());
		pOrderPage.toppings2(PizzaToppings.ONIONS.getDisplayName());
		pOrderPage.pizzaQuantity("2");
		pOrderPage.enterInfo("Omer", "1234567890", "test@sample.com");
		pOrderPage.paymentMethod("Cash on Pickup");
		pOrderPage.placeOrder();
		pOrderPage.orderValidate();
	}
	
	@Test(priority = 2, description = "verify error message")
	public void test2() {
		PizzaOrderPage pOrderPage = new PizzaOrderPage(driver);
		pOrderPage.selectPizza1(PizzaTypes.LARGE_THREETOPPINGS.getDisplayName());
		pOrderPage.toppings1(PizzaToppings.PEPPERONI.getDisplayName());
		pOrderPage.toppings2(PizzaToppings.ONIONS.getDisplayName());
		pOrderPage.pizzaQuantity("2");
		pOrderPage.enterInfo("", "", "");
		pOrderPage.paymentMethod("Cash on Pickup");
		pOrderPage.placeOrder();
		pOrderPage.validateErrorMsg();
	}

}
