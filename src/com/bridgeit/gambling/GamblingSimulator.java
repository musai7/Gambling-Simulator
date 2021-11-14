package com.bridgeit.gambling;

public class GamblingSimulator {

	private static final int STAKE = 100;
	private static final int BET = 1;
	private static final int IS_WIN = 1;
	private static final int IS_LOOSE = 0;

	public static void main(String[] args) {

		int totalStackValue = 100, dailyBet = 0,noOfDays=0 ;
		System.out.println("gambler starting with a stake of : $" + STAKE + " and bet in every game is : $" + BET);

		while(noOfDays<20) {
			
			while (dailyBet <= STAKE / 2) {
	
				double randomCheck = Math.random() * 2;
				switch ((int) randomCheck) {
					case IS_WIN:
						totalStackValue += BET;
						break;
					default:
						totalStackValue -= BET;
				}
	
				dailyBet += BET;
			}
			noOfDays++;
			dailyBet=0;
		if (totalStackValue > STAKE)
			System.out.println("win amount in a day " + noOfDays + " is  " + (totalStackValue - STAKE));

		else
			System.out.println("loose amount in a day " + noOfDays + " is : " + (STAKE - totalStackValue));
		}
	}
}
