package RegisterPage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginUser extends ConnectionManager {

	static String Email;
	static String PassWord;
//	static boolean Status;
	static String GetColumnNumber;

	public static void main(String[] a) throws ClassNotFoundException {
		try {
			LoginUser lu = new LoginUser();
			lu.connection();
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to your Login Page:");
			System.out.println("Enter your UserName(Email):");
			Email = scan.next();
			System.out.println();
			System.out.println("Enter your Password:");
			PassWord = scan.next();

			PreparedStatement ps = conn.prepareStatement("select * from register where Email=? and PassWord=?");
			ps.setString(1, Email);
			ps.setString(2, PassWord);
			

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			GetColumnNumber = rs.getString(2);
			System.out.println();
			System.out.println("--------------------------------Login Successfull!----------------------------------------");
			System.out.println("-------------------------------Welcome: " +GetColumnNumber);
			/*if (Status == true) {

				System.out.println("Login Successfully!");
				System.out.println("Welcome: " + GetColumnNumber);

			}*/
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
