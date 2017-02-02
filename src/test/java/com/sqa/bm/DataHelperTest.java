package com.sqa.bm;

import org.testng.*;
import org.testng.annotations.*;

import com.sqa.bm.helpers.*;

public class DataHelperTest {
	// @Test(dataProvider = "dp")
	// public void f(Integer n, String s) {
	// }

	// @DataProvider
	// public Object[][] dp() {
	// return new Object[][] {
	// new Object[] { 1, "a" },
	// new Object[] { 2, "b" },
	// };
	// }
	// }
	public Object[][] dp() {
		return new Object[][] { new Object[] { 3, 5, 4, 1 },
				new Object[] { 3.1, 5.55, 4.1, 1.3 }, new Object[] { "3", "5", "4", "1" },
				new Object[] { '3', '5', '4', '1' }, };
	}

	@Test
	public void testNonStaticDataHelper() {
		String expected =
				"3	5	4	1	\n3.1	5.55	4.1	1.3	\n3	5	4	1	\n3	5	4	1	\n";
		DataHelper dh = new DataHelper(dp());
		String actual = dh.displayData();
		// System.out.println(actual);
		Assert.assertEquals(actual, expected, "does not work correctly");
	}

	@Test // (dataProvider="dp") - Again, should comment out because you do not
			 // need this method
	public void testStaticDataHelper() {
		Object[][] data = dp();
		String expected =
				"3	5	4	1	\n3.1	5.55	4.1	1.3	\n3	5	4	1	\n3	5	4	1	\n";
		String actual = DataHelper.displayData(data);
		Assert.assertEquals(actual, expected, "does not work correctly");
	}
}
