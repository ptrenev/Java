package challenge.array.solution;

import java.util.Scanner;

public class ArrayTest {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] myIntegers = getIntegers(5);
		printArray(myIntegers);
		System.out.println("----------------");
		int[] sortedArray = sortIntegers(myIntegers);
		System.out.println("----------------");
		printArray(sortedArray);
	}
	
	public static int[] getIntegers(int capacity) {
		int[] array = new int[capacity];
		System.out.println("Enter " + capacity + " integers values:\r");
		for (int i = 0; i < array.length; i ++) {
			array[i] = sc.nextInt();
		}
		return array;		
	}
	
	public static void printArray (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Element " + i + " contents " + array[i]);
		}
	}
	
	public static int[] sortIntegers (int[] array) {
		int[] sortedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sortedArray[i] = array[i];
		}
		
		// sorting the array
		boolean flag = true;
		int temp;
		
		while (flag) {
			flag = false;
			// if the for loop hasn't sorted all number assign it back to true
			for (int i = 0; i < sortedArray.length - 1; i++) {
				// implementation of Bubble sort
				// DESC order
				if (sortedArray[i] < sortedArray[i+1]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i+1];
					sortedArray[i+1] = temp;
					flag = true;
				}
			}
		}
		
		return sortedArray;
	}
	
}
