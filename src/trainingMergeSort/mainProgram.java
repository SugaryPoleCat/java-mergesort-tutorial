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
	 * 
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
		for (int i = 0; i < numbers.length; i++) {
			// random number up to 1000000
			numbers[i] = rand.nextInt(1000000);
		}

		System.out.println("Before");
		arrPrint(numbers);

		mergeSort(numbers);

		System.out.println("After");
		arrPrint(numbers);
	}

	/**
	 * Prints the arrray
	 * 
	 * @param numbers The array of numbers
	 */
	private static void arrPrint(int[] numbers) {
		// code
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	/**
	 * this will merge sort the array
	 * What merge sort does is, you start into unsorted array, then you divide it
	 * into half.
	 * You then sort each separate array by its own, then, we merge sort those 2
	 * separate arrays
	 * And sort those 2 halves. which is much less works.
	 * Basically we break the array down into more manageable chunks.
	 * And we break those bigger halves into even smaller halves until we have 2
	 * numbers to compare and then
	 * we merge them together one by one.
	 * 
	 * @param numbers The array to mergesort
	 */
	private static void mergeSort(int[] numbers) {
		// code
		int inputLength = numbers.length;

		// since we are going to be recursively calling smaller and smaller arrays each
		// time
		// because we will be recalling this method over and over, we have to check, if
		// array is less than 2 values. Since array with just 1 index is obviously,
		// already sorted.
		if (inputLength < 2) {
			return;
		}

		// split array in half
		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];

		// fill up our arrays;
		// first lefthalf. UP TO MIDPOINT
		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = numbers[i];
		}

		// now do the right half.
		// start from MID index, where we left off previously.
		for (int i = midIndex; i < inputLength; i++) {
			// use i-midIndex to correct so tat indexes are 0, 1, 2, 3 instead of
			// wherever midindex is stareting.
			rightHalf[i - midIndex] = numbers[i];
		}

		// now we have to do this to all places in the array;
		// remember to do in right order
		mergeSort(leftHalf);
		mergeSort(rightHalf);

		// merge the things
		merge(numbers, leftHalf, rightHalf);
	}

	/**
	 * This will merge the 2 different arays
	 * 
	 * @param inputArray
	 * @param leftHalf
	 * @param rightHalf
	 */
	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		// since we need ot be crawling through 3 arrays, left half, right half and then
		// merge the 2 half together, we need 3 indexes.
		int i = 0;
		int j = 0;
		int k = 0;

		// loop until we run out of elements in left and right
		while (i < leftSize && j < rightSize) {
			// check if lefthalf is lower or equal to right
			if (leftHalf[i] <= rightHalf[j]) {
				// if it is, apply to merged array the left half.
				inputArray[k] = leftHalf[i];
				// then increase i index
				i++;
			} else {
				// if the lefthalf is not lower than right, put into the merged array
				// the right half, since that is lower.
				inputArray[k] = rightHalf[j];
				// then increase j index.
				j++;
			}
			// increment combined array iterator;
			k++;
		}

		// cleanup, add the remaning elements if there were left any.
		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
	}
}
