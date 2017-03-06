package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import Demo.Store;

public class Test {

	static String URL = "jdbc:mysql://localhost:3306/Assign";
	static String USERNAME = "root";
	static String PASS = "vinod213";
	static Connection conn = null;

	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
		ArrayList<Store> StoreAl = new ArrayList<Store>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASS);
			Statement st = conn.createStatement();
			ResultSet srs = st.executeQuery("SELECT * FROM store");
			while (srs.next()) {
				Store store = new Store();
				store.setProductName(srs.getString("Pname"));
				store.setQty(srs.getInt("Qty"));
				store.setPrice(srs.getDouble("Price"));
				StoreAl.add(store);
			}

			System.out.println(StoreAl.size());
			System.out.println(StoreAl.get(1).getProductName());
			//System.out.println(StoreAl.get(2).getProductName());
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
