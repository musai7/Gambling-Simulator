package com.bridgeit.gambling;

public class GamblingSimulator {

	private static final int STAKE = 100;
	private static final int BET = 1;
	private static final int IS_WIN = 1;
	private static final int IS_LOOSE = 0;

	public static void main(String[] args) {

		int winAmountINADay = 0, looseAmountINADay = 0;
		System.out.println("gambler starting with a stake of : $" + STAKE + " and bet in every game is : $" + BET);
		
		while ((winAmountINADay < (STAKE / 2)) && (looseAmountINADay > -(STAKE / 2))) {
		
			double randomCheck = Math.random() * 2;
			switch ((int) randomCheck) {
			case IS_WIN:
				winAmountINADay += BET;
				break;
			default:
				looseAmountINADay -= BET;
			}
			
			System.out.println("win amount in a day is = " + winAmountINADay);
			System.out.println("loose amount in a day = " + looseAmountINADay);
		}
	}
}
