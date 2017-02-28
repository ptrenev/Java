package algo.recursion;

// FUNDAMENTAL

public class Test {
	private static int sum = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(sum);
		int[] array = {41, 48, 4, 28, 34, 76, 9, 3};
		recursiveLinearSearch(76, 0, array);
		reduceByOne(10);
		System.out.println("Sum: " + sum);
	}

	// this method reduces the value n recursively
	public static void reduceByOne(int n) {
		// base case
		if (n >= 0) {
			// recursive method
			sum+=n;
			reduceByOne(n - 1);
			
		}
		// Every call is waiting the one it invoked
	    System.out.println("Completed call: " + n); // it's called 11 times
		// output
		/*	
		    Completed call: -1
			Completed call: 0
			Completed call: 1
			Completed call: 2
			Completed call: 3
			Completed call: 4
			Completed call: 5
			Completed call: 6
			Completed call: 7
			Completed call: 8
			Completed call: 9
			Completed call: 10
		*/
		
	}
	
	// This method starts at position i and search for x in the array
	public static int recursiveLinearSearch (int x, int i, int arr[]) { // i is the starting position of the array
		if ( i > arr.length - 1)  { 
			return -1;               // nothing was found
		} else if(arr[i] == x) {
			System.out.println("Found item at index: " + i);
			return i;                // found item at index
		} else {
			System.out.println("Index at: " + i);
			return recursiveLinearSearch(x, i+1, arr); // with i+1 we move a slot in the array
		}
	}

}
