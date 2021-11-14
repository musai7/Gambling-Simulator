package com.bridgeit.gambling;

import java.util.Scanner;

public class GamblingSimulator {

	public static final int STAKE = 100;
	public static final int BET = 1;
	private static final int IS_WIN = 1;
	private static final int IS_LOOSE = 0;
	private static final int NO_OF_DAYS_IN_MONTH = 30;

	static int maxWinArray[] = new int[30];
	static int maxLostArray[] = new int[30];
	static int totalStackValue = 100;
	static int dailyBet = 0;

	public void maxWinOrMAxLostInDay() {
		int maxWinAmount = 0, maxlostAmount = 0, maxWinDay = 0, maxLostDay = 0, winDay = 0, lostDay = 0;
		
		for (int i = 0; i < 30; i++) {

			if (maxWinArray[i] > maxWinAmount) {
				maxWinAmount = maxWinArray[i];
				winDay = i + 1;
			}

			if (maxLostArray[i] > maxlostAmount) {
				maxlostAmount = maxLostArray[i];
				lostDay = i + 1;
			}
		}
		System.out.println("my luckiest day where i am won maximum in a day " + (winDay) + " is : " + maxWinAmount);
		System.out.println(
				"my unluckiest day where i am lost maximum in a day " + (lostDay) + " is : " + maxlostAmount);
		totalStackValue=100;
	}

	public void dailyBet() {
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
		dailyBet = 0;
	}

	public void monthlyGamblingBet() {

		int noOfDays = 0;
		while (noOfDays < NO_OF_DAYS_IN_MONTH) {

			GamblingSimulator gamblingSimulator = new GamblingSimulator();
			gamblingSimulator.dailyBet();

			if (totalStackValue > STAKE) {
				System.out.println("win amount in a day " + (noOfDays + 1) + " is  " + (totalStackValue - STAKE));
				maxWinArray[noOfDays] = (totalStackValue - STAKE);
			}

			else if (totalStackValue < STAKE) {
				System.out.println("lost amount in a day " + (noOfDays + 1) + " is : " + (STAKE - totalStackValue));
				maxLostArray[noOfDays] = (STAKE - totalStackValue);
			} else {
				System.out.println(" In day " + (noOfDays + 1) + " no lost no win ");
			}
			noOfDays++;
		}
	}
	
}
