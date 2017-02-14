/**
 * File Name: QAMath.java<br>
 * Mark, Bernard<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 28, 2017
 */
package com.sqa.bm.helpers;

/**
 * QAMath //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mark, Bernard
 * @version 1.0.0
 * @since 1.0
 */
public class QAMath {

	// all public static are non-instant variables - do not require
	// constructors//
	public static int addNumbers(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public static int square(int num, int pow) {
		int result = num;
		for (int i = 0; i < pow - 1; i++) {
			result *= num;
		}
		return result;
	}

	public static int subtractNumbers(int num1, int num3) {
		int result = num3 - num1;
		return result;
	}

	public int total;

	// instance (non-static) variables require constructor//
	public int addNumber(int num) {
		// total +=num;//
		// return total;//
		setTotal(getTotal() + num);
		return getTotal();
	}

	public int getTotal() {
		return this.total;
	}

	/**
	 * @param i
	 */
	public void setTotal(int total) {
		// TODO Auto-generated method stub
		this.total = total;
	}

	public int square(int pow) {
		this.total = QAMath.square(getTotal(), pow);
		return this.total;
	}

	public int subNumber(int num) {
		return num;
	}
	// public int getResult() {
	// return result;
	// }
}
