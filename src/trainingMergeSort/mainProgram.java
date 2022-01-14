/**
 * 
 */
package trainingMergeSort;
import java.util.Random;

/**
 * @author damia
 *
 */
public class mainProgram {
	/**
	 * So far works like C#
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * new random instnance
		 */
		Random rand = new Random();
		/**
		 * create array of 10 random numbers;
		 */
		int[] numbers = new int[10];
		// for each array index, create a new number.
		for(int i = 0; i<numbers.length;i++) {
			// random number up to 1000000
			numbers[i] = rand.nextInt(1000000);
		};
		
		System.out.println("Before");
		arrPrint(numbers);

		mergeSort(numbers);

		System.out.println("After");
		arrPrint(numbers);
	}

	/**
	 * Prints the arrray
	 * @param numbers The array of numbers
	 */
	private static void arrPrint(int[] numbers) {
		// code
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
	}
	/**
	 * this will merge sort the array
	 * What merge sort does is, you start into unsorted array, then you divide it into half.
	 * You then sort each separate array by its own, then, we merge sort those 2 separate arrays
	 * And sort those 2 halves. which is much less works.
	 * Basically we break the array down into more manageable chunks.
	 * And we break those bigger halves into even smaller halves until we have 2 numbers to compare and then
	 * we merge them together one by one.
	 * @param numbers The array to mergesort
	 */
	private static void mergeSort(int[] numbers) {
		// code
		int inputLength = numbers.length;

		// since we are going ot be recursively calling smaller and smaller arrays each time
		// becasue we wwill be recalling this method over nad over, we have to check, if
		// array is less than 2 values. Since array with just 1 index is obvoiusly,
		// already sorted.
		if (inputLength < 2) {
			return;
		}

		// split array in hald
		int midIndex = inputLength / 2;
	}
}
