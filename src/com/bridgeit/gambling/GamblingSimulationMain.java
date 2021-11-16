package com.bridgeit.gambling;

public class GamblingSimulationMain {
	public static void main(String[] args) {

		GamblingSimulator gamblingSimulator = new GamblingSimulator();

		System.out.println("gambler starting with a stake of : $" + GamblingSimulator.STAKE
				+ " and bet in every game is : $" + GamblingSimulator.BET);
		while (true) {
			UserInterface userInterface = new UserInterface();
			int num = userInterface.showUserMenu();
			switch (num) {
				case 1:
					gamblingSimulator.monthlyGamblingBet();
					break;
				case 2:
					System.out.println("i don't wanted to gamble this month ");
					break;
				default:
					System.out.println("invalide selection");
			}
			if (num == 2) {
				break;
			}
		}
	}
}
