package com.bridgeit.gambling;

import java.util.Scanner;

public class GamblingSimulationMain {
	public static void main(String[] args) {

		GamblingSimulator gamblingSimulator = new GamblingSimulator();

		System.out.println("gambler starting with a stake of : $" + GamblingSimulator.STAKE
				+ " and bet in every game is : $" + GamblingSimulator.BET);
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out
					.println(" enter 1 : for continue the gambling in this month \n enter 2 : for stop gambling in this month ");
			int num = scanner.nextInt();

			switch (num) {
				case 1:
					gamblingSimulator.monthlyGamblingBet();
					gamblingSimulator.maxWinOrMAxLostInDay();
					break;
				case 2:
					System.out.println("i don't wanted to gamble this month ");
					break;
				default:
					System.out.println("invalide selection");
			}
			if(num==2) {
				break;
			}
		}
	}
}
