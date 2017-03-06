package RegisterPage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUser extends ConnectionManager {

	Scanner scan = new Scanner(System.in);
	static String UserName;
	static String Name;
	static String Email;
	static String UserId;
	static String PassWord;

	public boolean validateUserName() {

		System.out.println("Enter UserName: ");
		UserName = scan.next();
		/*
		 * length>=3 && a-z,A-z,0-9,-,.,_;
		 */
		/*
		 * You first create a Pattern object which defines the regular
		 * expression. This Pattern object allows you to create a Matcher object
		 * for a given string. This Matcher object then allows you to do regex
		 * operations on a String.
		 * 
		 */
		Pattern patt = Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
		Matcher match = patt.matcher(UserName);
		if (match.matches()) {

			return true;
		} else {
			System.out.println("Enter Valid UsrName");
			validateUserName();
		}

		return false;
	}

	public boolean validateName() {

		System.out.println("Enter Name: ");
		Name = scan.next();
		/* contains only characters */
		Pattern patt = Pattern.compile("[a-zA-Z]*");
		Matcher match = patt.matcher(Name);
		if (match.matches()) {

			return true;
		} else {
			System.out.println("Name Contains only Characters!");
			validateName();
		}

		return false;
	}

	public boolean validateEmail() {

		System.out.println("Enter your Email-Id: ");
		Email = scan.next();
		Pattern pat = Pattern
				.compile("^[_A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*@[a-zA-Z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		Matcher match = pat.matcher(Email);
		if (match.matches()) {
			return true;
		} else {
			System.out.println("Check your Email-Id");
			validateEmail();
		}
		return false;
	}

	public boolean validateUserId() {

		System.out.println("Enter your UserId: ");
		UserId = scan.next();
		Pattern pat = Pattern.compile("[a-zA-Z0-9]{6,10}");
		Matcher match = pat.matcher(UserId);
		if (match.matches()) {
			return true;
		} else {
			System.out.println("UserId Should have Alphabets and Number between 6 -10 chars..");
			validateUserId();
		}
		return false;

	}

	public boolean validatePass() {
		System.out.println("Enter your PassWord: ");
		PassWord = scan.next();
		Pattern pat = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*]).{8,16})");
		Matcher match = pat.matcher(PassWord);
		if (match.matches()) {
			return true;
		} else {
			System.out.println("Enter Valid Password! ");
			validatePass();
		}
		return false;
	}

	public static void main(String[] args) {

		try {
			RegisterUser reg = new RegisterUser();
			boolean user = false;
			boolean name = false;
			boolean email = false;
			boolean userid = false;
			boolean pass = false;

			reg.connection();
			System.out.println(
					"--------------------------------Welcomr To Registration Page-----------------------------------------------");
			System.out.println();

			System.out.println(
					"---------------------------------Enter Your Details----------------------------------------");
			user = reg.validateUserName();
			name = reg.validateName();
			email = reg.validateEmail();
			userid = reg.validateUserId();
			pass = reg.validatePass();

			if (user && name && email && userid && pass) {

				String sequel = "insert into register values(?,?,?,?,?)";

				PreparedStatement ps = conn.prepareStatement(sequel);
				ps.setString(1, UserName);
				ps.setString(2, Name);
				ps.setString(3, Email);
				ps.setString(4, UserId);
				ps.setString(5, PassWord);
				// ps.execute();

				int i = ps.executeUpdate(); /*
											 * Number of Records To be affected!
											 * 
											 */
				System.out.println("rows affected: " + i);
				System.out.println();
				System.out.println(Name + " Your Records Submitted Successfully!");

			} else {
				System.out.println("Please Enter valid Details!.");
			}
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
