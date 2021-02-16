package com.atm.presentationlayer.uilayer;

import java.util.Scanner;

import com.atm.domainlayer.atm.ATM;
import com.atm.domainlayer.atm.IATM;

public class App {
	public static void main(String[] args) {
		IATM atm = new ATM();
		boolean newtransaction = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Select Account Number \n 1.123456789 \n 2.987654321 \n");
			int accountNumber=sc.nextInt()==1?123456789:987654321;
			System.out.println("Enter Pin \n");
			int pin = sc.nextInt();
			System.out.println("Enter Amount To Dispense \n");
			int amount = sc.nextInt();
			System.out.println(atm.dispense(accountNumber, pin, amount));
			System.out.println("Do you wish to continue \n 1.Yes \n 2.No");
			if (sc.nextInt() == 1) {
				newtransaction = true;
			} else {
				newtransaction = false;
			}
		} while (newtransaction);

		// correct
		// String output = atm.dispense(123456789, 1234, 200);

		// more than ATM max
		// String output = atm.dispense(123456789, 1234, 20000);

		// wrong pin
		// String output = atm.dispense(123456789, 4321, 2);

		// System.out.println(output);

	}
}