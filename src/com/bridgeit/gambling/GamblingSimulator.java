package com.bridgeit.gambling;

import java.util.Scanner;

public class GamblingSimulator {

	private static final int STAKE = 100;
	private static final int BET = 1;
	private static final int IS_WIN = 1;
	private static final int IS_LOOSE = 0;
	private static final int NO_OF_DAYS_IN_MONTH = 30;

	static int maxWinArray[] = new int[30];
	static int maxLostArray[] = new int[30];
	static int totalStackValue = 100;
	static int dailyBet = 0;

	public void maxWinOrMAxLostInDay() {
		int maxWinAmount=0,maxlostAmount=0,maxWinDay=0,maxLostDay=0,winDay=0,lostDay=0;
		for (int i = 0; i < 30; i++) {
			
			if(maxWinArray[i]>maxWinAmount) {
				maxWinAmount=maxWinArray[i];
				winDay=i;
			}
			
			if(maxLostArray[i] > maxlostAmount) {
				maxlostAmount = maxLostArray[i];
				lostDay=i;
			}
		}
		System.out.println("my luckiest day where i am won maximum in a day " + winDay +  " is : " + maxWinAmount);
		System.out.println("my unluckiest day where i am lost maximum in a day " +lostDay + " is : " + maxlostAmount);	
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

	public static void main(String[] args) {
		int noOfDays = 0;
		GamblingSimulator gamblingSimulator = new GamblingSimulator();


		System.out.println("gambler starting with a stake of : $" + STAKE + " and bet in every game is : $" + BET);

		while (noOfDays < NO_OF_DAYS_IN_MONTH) {

			gamblingSimulator.dailyBet(); 
			if (totalStackValue > STAKE) {
				System.out.println("win amount in a day " + noOfDays + " is  " + (totalStackValue - STAKE));
				maxWinArray[noOfDays] = (totalStackValue - STAKE);
			}

			else if (totalStackValue < STAKE) {
				System.out.println("lost amount in a day " + noOfDays + " is : " + (STAKE - totalStackValue));
				maxLostArray[noOfDays] = (STAKE - totalStackValue);
			} else {
				System.out.println("no lost no win ");
			}
			noOfDays++;
		}
		gamblingSimulator.maxWinOrMAxLostInDay();
	}
}
