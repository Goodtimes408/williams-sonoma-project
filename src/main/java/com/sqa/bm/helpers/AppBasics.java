/**
 * File Name: AppBasics.java<br>
 * Mark, Bernard<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 14, 2017
 */
package com.sqa.bm.helpers;

import java.util.*;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mark, Bernard
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasics {

	static Scanner scanner = new Scanner(System.in);

	public static void farwellUser(String userName, String appName) {
		// TODO Auto-generated method stub
		System.out.println("Thank you for using the " + appName + " application");
		System.out.println("Have a good day " + userName);
	}

	public static String greetUserAndGetName(String appName) {
		System.out.println("Hello, Welcome to the " + appName + " App.");
		// because it's a string, program knows nameOfApp is same as appName//
		System.out.print("Could I please get your name? ");
		// println add carriage return or \n"//
		return scanner.nextLine();
		// nextLine is a method //
	}

	@SuppressWarnings("javadoc")
	public static String requestInfoFromUser(String info) {
		String response;
		System.out.println(info + " ");
		response = scanner.nextLine();
		return response;
	}
}
