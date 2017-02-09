/**
 * File Name: DataHelper.java<br>
 * Mark, Bernard<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 30, 2017
 */
package com.sqa.bm.helpers;

import java.sql.*;
import java.util.*;

/**
 * DataHelper //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mark, Bernard
 * @version 1.0.0
 * @since 1.0
 */
public class DataHelper {

	// Static Method
	public static String displayData(Object[][] data) {
		StringBuilder sb = new StringBuilder();
		// TODO Create two loops, one within another to add all items to sb
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static Object[][] evalDatabaseTable(String driverClassString,
			String databaseStringUrl, String username, String password, String tableName)
			throws ClassNotFoundException, SQLException {
		return evalDatabaseTable(driverClassString, databaseStringUrl, username, password,
				tableName, 0, 0);
	}

	public static Object[][] evalDatabaseTable(String driverClassString,
			String databaseStringUrl, String username, String password, String tableName,
			int rowOffset, int colOffset) throws ClassNotFoundException, SQLException {
		Object[][] myData;
		ArrayList<Object> myArrayData = new ArrayList<>();
		Class.forName(driverClassString);
		Connection dbconn =
				DriverManager.getConnection(databaseStringUrl, username, password);
		Statement stmt = dbconn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from " + tableName);
		int numOfColumns = rs.getMetaData().getColumnCount();
		int curRow = 1;
		while (rs.next()) {
			if (curRow > rowOffset) {
				Object[] rowData = new Object[numOfColumns - colOffset];
				for (int i = 0, j = colOffset; i < rowData.length; i++) {
					rowData[i] = rs.getString(i + colOffset + 1);
				}
				myArrayData.add(rowData);
			}
			curRow++;
		}
		myData = new Object[myArrayData.size()][];
		for (int i = 0; i < myData.length; i++) {
			myData[i] = (Object[]) myArrayData.get(i);
		}
		rs.close();
		stmt.close();
		dbconn.close();
		return myData;
	}

	private String dataString;

	// Constructor
	public DataHelper(Object[][] data) {
		this.dataString = displayData(data);
	}

	// Instance Method (Will need a constructor that takes the Object[][])
	public String displayData() {
		return this.dataString;
	}
}
