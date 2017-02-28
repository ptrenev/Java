package petkopc.enhancedArraylist;

import java.util.Scanner;

import petkopc.arraylist.GroceryList;

public class EnhancedArrayListTest {

	private static Scanner sc = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();
	private static EnhancedGroceryList enhancedGroceryList = new EnhancedGroceryList();
	public static void main(String[] args) {

		boolean quit = false;
		int choice = 0;
		//printInstructions();

		while (!quit) {
			printInstructions();
			System.out.println("Enter your choice ");
			choice = sc.nextInt();
			// clear input buffer
			sc.nextLine();

			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				enhancedGroceryList.printGroceryList();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchForItem();
				break;
			case 6:
				quit = true;
				System.out.println("Exiting application..");
				break;
			}
		}
	}

	public static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list of grocery items.");
		System.out.println("\t 3 - To modify an item from the list of grocery items.");
		System.out.println("\t 4 - To remove an item from the list of grocery items.");
		System.out.println("\t 5 - To search for an item in the list of grocery items.");
		System.out.println("\t 6 - To quit the application.");
	}

	public static void addItem() {
		System.out.println("Please enter the grocery item to be added to the list.");
		enhancedGroceryList.addGroceryItem(sc.nextLine());
	}

	// It is not useful to modify items by index that's why a new implementation
	// is needed
	public static void modifyItem() {
		System.out.println("Current item name");
		String oldItem = sc.nextLine();
		System.out.println("Enter replacement item: ");
		String newItem = sc.nextLine();
		enhancedGroceryList.modifyGroceryItem(oldItem, newItem);
	}

	// It is not useful to remove items by index that's why a new implementation
	// is needed
	public static void removeItem() {
		System.out.println("Enter item name");
		String currentItem = sc.nextLine();
		enhancedGroceryList.removeGroceryItem(currentItem);
	}

	
	// Searches for a particular String if it's present prints out useful
	// information
	public static void searchForItem() {
		System.out.println("Enter an item to search for");
		String searchItem = sc.nextLine();
		if (enhancedGroceryList.onFile(searchItem)) {
			System.out.println("Found the searched item in grocery list.");
		} else {
			System.out.println("Search item is not in the grocery list.");
		}
	}
}
