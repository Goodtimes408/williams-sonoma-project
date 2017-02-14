package com.sqa.bm.ws;

import org.testng.annotations.*;

import com.sqa.bm.helpers.*;

public class WilliamsSonomaTest extends BasicTest {

	/**
	 * @param baseUrl
	 */
	public WilliamsSonomaTest() {
		super("http://williams-sonoma.com");
		// TODO Auto-generated constructor stub
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 2, "Artisan Mini Stand Mixer", 29.99 },
				new Object[] { 3, "Valentine's Day Dinnerware Collection", 4659.00 },
				new Object[] { 5, "Williams Sonoma Cherry Lover's Mix", 100000.00 },
				new Object[] { 1, "Turquoise and Raffia Box", 18.98 },
				new Object[] { 3, "Peacock Elegance", 38.98 } };
	}

	@Test(dataProvider = "dp")
	public void test(int quantity, String itemName, double totalPrice)
			throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Searching " + getBaseUrl() + " for" + itemName);
		// System.out.println("");
	}
}
