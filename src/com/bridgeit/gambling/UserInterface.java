package com.bridgeit.gambling;

import java.util.Scanner;

public class UserInterface {

	public int showUserMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				" enter 1 : for continue the gambling in this month \n enter 2 : for stop gambling in this month ");
		int num = scanner.nextInt();
		return num;
	}
	
}
