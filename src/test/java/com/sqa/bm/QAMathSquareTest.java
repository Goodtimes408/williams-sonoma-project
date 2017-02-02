package com.sqa.bm;

import org.testng.*;
// import org.junit.*;
import org.testng.annotations.*;

import com.sqa.bm.helpers.*;

public class QAMathSquareTest {

	// @Test(dataProvider = "dp")
	// public void f(Integer n, String s) {
	// }
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, 2, 1 }, new Object[] { 2, 2, 4 },
				new Object[] { 2, 8, 256 }, new Object[] { 0, 4, 0 },
				new Object[] { -3, 2, 9 }, new Object[] { 3, 3, 27 } };
	}

	@Test(dataProvider = "dp")
	public void testSquareNonStaticMethod(int number, int power, int expected) {
		int actual;
		QAMath math = new QAMath();
		// math.addNumber(number);
		math.setTotal(number);
		math.square(power);
		actual = math.getTotal();
		Assert.assertEquals(expected, actual);
	}

	@Test(dataProvider = "dp")
	public void testSquareStaticMethod(int number, int power, int expected) {
		int actual;
		actual = QAMath.square(number, power);
		Assert.assertEquals(expected, actual);
	}
}
