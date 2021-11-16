package com.bridgeit.gambling;

public class GamblingSimulator {

	public static final int STAKE = 100;
	public static final int BET = 1;
	private static final int IS_WIN = 1;
	private static final int IS_LOOSE = 0;
	private static final int NO_OF_DAYS_IN_MONTH = 30;

	static int totalStackValue = 100;
	static int dailyBet = 0;

	public static int dailyBet() {
		while (dailyBet <= STAKE / 2) {

			double randomCheck = Math.random() * 2;
			switch ((int) randomCheck) {
			case IS_WIN:
				totalStackValue += BET;
				break;
			case IS_LOOSE:
				totalStackValue -= BET;
			}
			dailyBet += BET;
		}
		dailyBet = 0;
		return totalStackValue;
	}

	public void monthlyGamblingBet() {

		int maxWinAmount = 0, maxLostAmount = 0;
		int winDay = 0, lostDay = 0;

		int maxWinArray[] = new int[30];
		int maxLostArray[] = new int[30];

		int noOfDays = 0, winCount = 0, lostCount = 0;
		while (noOfDays < NO_OF_DAYS_IN_MONTH) {
			totalStackValue = 100;
			dailyBet();
			if (totalStackValue > STAKE) {

				System.out.println("win amount in a day " + (noOfDays + 1) + " is  " + (totalStackValue - STAKE));
				maxWinArray[winCount] = (totalStackValue - STAKE);
				if (maxWinArray[winCount] > maxWinAmount) {
					maxWinAmount = maxWinArray[winCount];
					winDay = (noOfDays + 1);
				}
				winCount++;
			} else if (totalStackValue < STAKE) {

				System.out.println("lost amount in a day " + (noOfDays + 1) + " is : " + (STAKE - totalStackValue));
				maxLostArray[lostCount] = (STAKE - totalStackValue);
				if (maxLostArray[lostCount] > maxLostAmount) {
					maxLostAmount = maxLostArray[lostCount];
					lostDay = (noOfDays + 1);
				}
				lostCount++;
			} else {
				
				System.out.println(" In day " + (noOfDays + 1) + " no lost no win ");
			}
			noOfDays++;
		}
		System.out.println("my luckiest day where i am won maximum in a day " + winDay + " is : " + maxWinAmount);
		System.out.println("my unluckiest day where i am lost maximum in a day " + lostDay + " is : " + maxLostAmount);
	}
}
