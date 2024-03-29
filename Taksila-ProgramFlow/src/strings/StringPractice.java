package strings;

import java.util.Scanner;

public class StringPractice {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//printTriangle();
		System.out.println("Enter a String to check if it is a Palindrome?");
		String input = sc.nextLine();
		System.out.println(isPalindrome("Dogma: I am God"));
		System.out.println(isPalindrome2(input));
	}

	public static void printTriangle() {
		for (int row = 1; row <= 6; row++) {
			for (int col = 5; col >= row; col++) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
	/**
	 * Checks if the String is a palindrome
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome(String str) {
		String check = str.toUpperCase();
		int len = str.length();
		boolean isPalindrome = true;
		int midpoint = len/2;
		
		for (int count  = 0; count < midpoint; count++) {
			if (check.charAt(count) == check.charAt(str.length() - 1 - count)) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This is a second method to check for Palindrome
	 * This version is ignoring the whitespaces using the replaceAll method
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome2(String str) {
		System.out.println("This program checks for palindrome");
		String upper = str.toUpperCase().replaceAll("[^a-z]","");
		StringBuffer sb = new StringBuffer();
		
		if (upper.equalsIgnoreCase(sb.reverse().toString())) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
}
