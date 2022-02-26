import java.util.Arrays;

public class ProjectADriver {
	
	private static boolean allTestsPassed = true; 
	private static boolean testingPartOne = false, testingExtraCredit = false;
	
	private static FrontBackCappedListInterface<Integer> list;

	public static void main(String[] args) {
		list = new ArrayFrontBackCappedList<Integer>(10);
		
		// if(testingExtraCredit) {
		// 	list = new ListFrontBackCappedList<Integer>(10);
		// 	System.out.println("-----------------------------DRIVER BEING RUN WITH EXTRA CREDIT CLASS-----------------------------");
		// }
	
		// if(!testingExtraCredit && testingPartOne) {
		// 	testingPartOne();
		// } else {
		// 	runEmptyListTests();
		// 	runAddToBackTests();
		// 	runClearTests();
		// 	runAddToFrontTests();
		// 	runContainsTests();
		// 	runIndexOfTests();
		// 	runLastIndexOfTests();
		// 	runRemovesTests();
		// 	runMixOfAddsRemovesTests();
		// 	runGetEntryTests();
		// 	runTestsWithStrings();	
		// }
		
		System.out.println("\n\n-----------------------------TESTING COMPLETE-----------------------------");
		if(allTestsPassed) {
			if(!testingExtraCredit && testingPartOne) {
				System.out.println("----------Summary---------- \nAll automated tests in Part One have passed.");
				System.out.println("Make certain that you manually looked at the output to check how your list is displayed.");
				System.out.println("You should remove the hard-coded lines from your ArrayFrontBackCappedList constructor.");
				System.out.println("Then, in the driver, set the testingPartOne variable to false and test the rest of your class.");				
			} else {
				System.out.println("----------Summary---------- \nAll automated tests in Part Two have passed.");
				System.out.println("Be sure to manually look at the output to check the contents of the list.");
				System.out.println("Also be sure to manually review your code for style and efficiency.");
			}
			if(testingExtraCredit) {
				System.out.println("*****Reminder: this driver was run with the extra credit class.");
			}
		} else {
			System.out.flush();
			System.err.println("**********Summary********** ERROR: There is failure in at least one automated test. Review the output above for details.");
			System.out.flush();
			System.err.println("Reminder: this driver was run with the extra credit class.");

		}
		
	}
	
	public static void testingPartOne() {
		System.out.println("\n-----------------------------TESTING PART ONE-----------------------------");
		System.out.println("*****Important: make sure you have hard-coded the three lines in your constructor.");
		
		testDisplayMatch(list, "size=5; capacity=10;	[2, 4, 6, 8, 9]");
		
		// parameter 1: the list
		// parameter 2: the expected result of isEmpty
		// parameter 3: the expected result of isFull
		testIsEmptyFull(list, false, false);
					
		// parameter 1: the list
		// parameter 2: the expected size of the list
		testSize(list, 5);
					
		
		System.out.println("\n-----------------------------TESTING GET ENTRY-----------------------------");		
		// parameter 1: the list
		// parameter 2: the index at which you will get the element
		// parameter 3: the expected result (the element at the specified index)
		// parameter 4: a description of the test
		testGetEntry(list, 0, 2, "getting first position");
		testGetEntry(list, 4, 9, "getting last position");
		testGetEntry(list, 2, 6, "getting a middle position");
	
		// parameter 1: the list
		// parameter 2: the index at which you will get the element; these method calls test invalid indices
		// parameter 3: a description of the test
		testGetEntry(list, -1,   "invalid index");
		testGetEntry(list, 11,   "invalid index");
		testGetEntry(list, 5,    "invalid index");
		testGetEntry(list, 7,    "invalid index");
		
		System.out.println("\n-----------------------------TESTING CLEAR-----------------------------");
		list.clear();
		testIsEmptyFull(list, true, false);
		testDisplayMatch(list, "size=0; capacity=10;	[]");

	}
	public static void runEmptyListTests() {
		System.out.println("-----------------------------TESTING WITH EMPTY LIST-----------------------------");
		// parameter 1: the list
		// parameter 2: the expected result of isEmpty
		// parameter 3: the expected result of isFull
		testIsEmptyFull(list, true, false);
		
		// parameter 1: the list
		// parameter 2: the expected size of the list
		testSize(list, 0);
		
		// parameter 1: the list
		// parameter 2: the expected String returned from the toString method
		testDisplayMatch(list, "size=0; capacity=10;	[]");

	}
	public static void runAddToBackTests() {
		System.out.println("\n-----------------------------TESTING ADD TO BACK-----------------------------");
		// parameter 1: the list
		// parameter 2: indicates if we are adding to the front or back
		// parameter 3: the values to add; values are added from the array beginning (index 0) to end; 
		//			    for example, {1, 2, 3} will first add 1 to the back, then 2 to the back, then 3 to the back
		// parameter 4: expected return value (true if the element was added, false otherwise)
		// parameter 5: a description of the test
		testAdd(list, AddRemovePosition.BACK, new Integer[] {7}, true, "addBack to empty list");
		testDisplayMatch(list, "size=1; capacity=10;	[7]");

		testAdd(list, AddRemovePosition.BACK, new Integer[] {9, 5}, true, "addBack to non-empty list");		
		testIsEmptyFull(list, false, false);	
		testSize(list, 3);
		testDisplayMatch(list, "size=3; capacity=10;	[7, 9, 5]");
		
		testAdd(list, AddRemovePosition.BACK, new Integer[] {5, 3, 2, 1, 9, 8, 7}, true, "addBack to fill the list");
		testIsEmptyFull(list, false, true);
		testSize(list, 10);
		testDisplayMatch(list, "size=10; capacity=10;	[7, 9, 5, 5, 3, 2, 1, 9, 8, 7]");

		testAdd(list, AddRemovePosition.BACK, new Integer[] {4}, false, "addBack to full list");
		testSize(list, 10);
		testDisplayMatch(list, "size=10; capacity=10;	[7, 9, 5, 5, 3, 2, 1, 9, 8, 7]");

	}
	public static void runClearTests() {
		System.out.println("\n-----------------------------TESTING CLEAR-----------------------------");
		list.clear();
		testIsEmptyFull(list, true, false);
		testDisplayMatch(list, "size=0; capacity=10;	[]");
	}
	public static void runAddToFrontTests() {
		System.out.println("\n-----------------------------TESTING ADD TO FRONT-----------------------------");
		list.clear();

		// parameter 1: the list
		// parameter 2: indicates if we are adding to the front or back
		// parameter 3: the values to add; values are added from the array beginning (index 0) to end; 
		//			    for example, {1, 2, 3} will first add 1 to the front, then 2 to the front, then 3 to the front
		// parameter 4: expected return value (true if the element was added, false otherwise)
		// parameter 5: a description of the test
		testAdd(list, AddRemovePosition.FRONT, new Integer[] {2}, true, "addFront to empty list");
		testDisplayMatch(list, "size=1; capacity=10;	[2]");
		
		testAdd(list, AddRemovePosition.FRONT, new Integer[] {4, 3}, true, "addFront to non-empty list");
		testIsEmptyFull(list, false, false);
		testSize(list, 3);
		testDisplayMatch(list, "size=3; capacity=10;	[3, 4, 2]");
		
		testAdd(list, AddRemovePosition.FRONT, new Integer[] {7, 9, 5, 4, 3, 8, 1}, true, "addFront to fill the list");
		testIsEmptyFull(list, false, true);
		testSize(list, 10);
		testDisplayMatch(list, "size=10; capacity=10;	[1, 8, 3, 4, 5, 9, 7, 3, 4, 2]");
	
		testAdd(list, AddRemovePosition.FRONT, new Integer[] {4}, false, "addFront to full list");
		testSize(list, 10);
		testDisplayMatch(list, "size=10; capacity=10;	[1, 8, 3, 4, 5, 9, 7, 3, 4, 2]");
	}
	public static void runContainsTests() {
		System.out.println("\n-----------------------------TESTING CONTAINS-----------------------------");
		clearAndRefillTheList(list, new Integer[] {1, 8, 3, 4, 5, 9, 7, 3, 4, 2});

		// parameter 1: the list
		// parameter 2: the element to look for
		// parameter 3: the expected result (true if the list contains that element, false otherwise)
		// parameter 4: a description of the test
		testContains(list, 1, true, "element is in the first position");
		testContains(list, 2, true, "element is in the last position");
		testContains(list, 5, true, "element is in the middle");
		testContains(list, 3, true, "element is in the list more than once");
		testContains(list, 0, false, "element is not in the list");

		testDisplayMatch(list, "size=10; capacity=10;	[1, 8, 3, 4, 5, 9, 7, 3, 4, 2]");

	}
	public static void runIndexOfTests() {
		System.out.println("\n-----------------------------TESTING INDEX OF-----------------------------");
		clearAndRefillTheList(list, new Integer[] {1, 8, 3, 4, 5, 9, 7, 3, 4, 2});
		
		// parameter 1: the list
		// parameter 2: indicates if we are finding the index of the first or last match
		// parameter 3: the value to search for 
		// parameter 4: expected result (the index where the element appears)
		// parameter 5: a description of the test
		testIndexOf(list, IndexPosition.FIRST, 1, 0, "first element in the list");
		testIndexOf(list, IndexPosition.FIRST, 2, 9, "last element in the list");
		testIndexOf(list, IndexPosition.FIRST, 5, 4, "element in the middle of the list");
		testIndexOf(list, IndexPosition.FIRST, 3, 2, "repeated element in the list");
		testIndexOf(list, IndexPosition.FIRST, 0,    "element not in the list");
		
		testDisplayMatch(list, "size=10; capacity=10;	[1, 8, 3, 4, 5, 9, 7, 3, 4, 2]");
	}
	public static void runLastIndexOfTests() {
		System.out.println("\n-----------------------------TESTING LAST INDEX OF-----------------------------");
		clearAndRefillTheList(list, new Integer[] {1, 8, 3, 4, 5, 9, 7, 3, 4, 2});
		
		testIndexOf(list, IndexPosition.LAST, 1, 0, "first element in the list");
		testIndexOf(list, IndexPosition.LAST, 2, 9, "last element in the list");
		testIndexOf(list, IndexPosition.LAST, 5, 4, "element in the middle of the list");
		testIndexOf(list, IndexPosition.LAST, 3, 7, "repeated element in the list");
		testIndexOf(list, IndexPosition.LAST, 0,    "element not in the list");
			
		testDisplayMatch(list, "size=10; capacity=10;	[1, 8, 3, 4, 5, 9, 7, 3, 4, 2]");

	}
	public static void runRemovesTests() {
		System.out.println("\n-----------------------------TESTING REMOVES-----------------------------");
		clearAndRefillTheList(list, new Integer[] {1, 8, 3, 4, 5, 9, 7, 3, 4, 2});
		
		// parameter 1: the list
		// parameter 2: indicates if we are removing from the front or back
		// parameter 3: if it exists, this is the expected value returned from the remove; 
		//              if this parameter is omitted, the expected return value is null
		// parameter 4: a description of the test
		testRemove(list, AddRemovePosition.FRONT, 1, "remove from non-empty");
		testDisplayMatch(list, "size=9; capacity=10;	[8, 3, 4, 5, 9, 7, 3, 4, 2]");

		testRemove(list, AddRemovePosition.FRONT, 8, "remove from non-empty");
		testDisplayMatch(list, "size=8; capacity=10;	[3, 4, 5, 9, 7, 3, 4, 2]");
		
		testRemove(list, AddRemovePosition.BACK, 2, "remove from non-empty");
		testDisplayMatch(list, "size=7; capacity=10;	[3, 4, 5, 9, 7, 3, 4]");
		
		testRemove(list, AddRemovePosition.BACK, 4, "remove from non-empty");
		testSize(list, 6);
		testDisplayMatch(list, "size=6; capacity=10;	[3, 4, 5, 9, 7, 3]");
				
		list.clear();
		testRemove(list, AddRemovePosition.FRONT, "remove front from empty");
		testIsEmptyFull(list, true, false);
		testSize(list, 0);
		testDisplayMatch(list, "size=0; capacity=10;	[]");

		testRemove(list, AddRemovePosition.BACK, "remove back from empty");
		testIsEmptyFull(list, true, false);
		testSize(list, 0);
		testDisplayMatch(list, "size=0; capacity=10;	[]");
		
		clearAndRefillTheList(list, new Integer[] {1});
		testRemove(list, AddRemovePosition.FRONT, 1, "remove front from singleton added to back");
		testIsEmptyFull(list, true, false);
		
		clearAndRefillTheList(list, new Integer[] {1});
		list.clear(); list.addFront(1);
		testRemove(list, AddRemovePosition.BACK, 1, "remove back from singleton added to front");
		testIsEmptyFull(list, true, false);
		
		clearAndRefillTheList(list, new Integer[] {1});
		list.clear(); list.addFront(1);
		testRemove(list, AddRemovePosition.FRONT, 1, "remove front from singleton added to front");
		testIsEmptyFull(list, true, false);
		
		clearAndRefillTheList(list, new Integer[] {1});
		testRemove(list, AddRemovePosition.BACK, 1, "remove back from singleton added to back");
		testIsEmptyFull(list, true, false);

	}
	public static void runMixOfAddsRemovesTests() {
		System.out.println("\n-----------------------------TESTING MIX OF ADDS AND REMOVES-----------------------------*");
		list.clear();
		list.addFront(3); 		list.addBack(2);		list.addFront(4);
		list.addFront(5);		list.addBack(3);		list.addBack(8);
		list.addBack(9);
		testDisplayMatch(list, "size=7; capacity=10;	[5, 4, 3, 2, 3, 8, 9]");
		
		list.removeFront(); list.removeBack();
		testDisplayMatch(list, "size=5; capacity=10;	[4, 3, 2, 3, 8]");
		
		list.removeBack(); list.removeFront(); list.removeFront();
		testDisplayMatch(list, "size=2; capacity=10;	[2, 3]");
		
		list.addFront(9);		list.removeBack();
		testDisplayMatch(list, "size=2; capacity=10;	[9, 2]");
		
		list.removeFront();     list.addBack(7);
		testDisplayMatch(list, "size=2; capacity=10;	[2, 7]");

	}
	public static void runGetEntryTests() {
		System.out.println("\n-----------------------------TESTING GET ENTRY-----------------------------");
		clearAndRefillTheList(list, new Integer[] {4, 3, 2, 3, 8});
		
		// parameter 1: the list
		// parameter 2: the index at which you will get the element
		// parameter 3: the expected result (the element at the specified index)
		// parameter 4: a description of the test
		testGetEntry(list, 0, 4, "getting first position");
		testGetEntry(list, 4, 8, "getting last position");
		testGetEntry(list, 2, 2, "getting a middle position");
		
		// parameter 1: the list
		// parameter 2: the index at which you will get the element; these method calls test invalid indices
		// parameter 3: a description of the test
		testGetEntry(list, -1,   "invalid index");
		testGetEntry(list, 11,   "invalid index");
		testGetEntry(list, 5,   "invalid index");
		testGetEntry(list, 7,    "invalid index");

	}
	public static void runTestsWithStrings() {
		System.out.println("\n-----------------------------TESTING WITH STRINGS-----------------------------");
		FrontBackCappedListInterface<String> wordList = new ArrayFrontBackCappedList<String>(20);
		if(testingExtraCredit) {
			wordList = new ListFrontBackCappedList<String>(20);
		}
		testAdd(wordList, AddRemovePosition.FRONT, new String[] {"job!", "Nice", "it!", "did", "You"}, true, "test with Strings");
		testAdd(wordList, AddRemovePosition.BACK, new String[] {"You", "rock!"}, true, "test with Strings");
		testDisplayMatch(wordList, "size=7; capacity=20;	[You, did, it!, Nice, job!, You, rock!]");
		testContains(wordList, new String("it!"), true, "test with Strings");
		testIndexOf(wordList, IndexPosition.FIRST, new String("You"), 0, "test with Strings");
		testIndexOf(wordList, IndexPosition.LAST, new String("You"), 5, "test with Strings");
	}
	/*----------------------------------------------------------------------------------------------------------*/
	/* TESTER METHODS */
	/*----------------------------------------------------------------------------------------------------------*/
	/*
	 * The methods below are designed to help support the tests cases run from main. You don't
	 * need to use, modify, or understand these methods. You can safely ignore them. :) 
	 * 
	 * Also, you can ignore the use of generics in the tester methods. These methods use
	 * generics at a level beyond which we use in our class. I only use them here to make this a robust 
	 * and useful testing file. You are NOT required to understand the use of generics in this way.
	 */

	public static <T> void testDisplayMatch(FrontBackCappedListInterface<T> list, String expectedOutput) {
		System.out.println("\nManual check of contents using toString: \nExpected output: " + expectedOutput);
		System.out.println("  Actual output: " + list.toString() +"\n");
	}
	public static <T> void testIsEmptyFull(FrontBackCappedListInterface<T> list, boolean expectedEmptyResult, boolean expectedFullResult) {
		System.out.println("\nTesting isEmpty for list: " + list);
		System.out.println("Expected: " + expectedEmptyResult + "\n  Actual: " + list.isEmpty());
		if(expectedEmptyResult !=  list.isEmpty()) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED");
		}

		System.out.println("\nTesting isFull for list: " + list);
		System.out.println("Expected: " + expectedFullResult + "\n  Actual: " + list.isFull());
		if(expectedFullResult !=  list.isFull()) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED");
		}
	}
	public static <T> void testSize(FrontBackCappedListInterface<T> list, int expectedSize) {
		System.out.println("\nTesting size method for list: " + list);
		System.out.println("Expected size: " + expectedSize + "\n  Actual size: " + list.size() );
		if(expectedSize !=  list.size()) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED");
		}
	}
	public static <T> void clearAndRefillTheList(FrontBackCappedListInterface<T> list, T[] valuesToAdd) {
		list.clear();
		for(T value : valuesToAdd) {
			list.addBack(value);
		}
		System.out.println("\nList cleared and refilled and now contains: " + list);
	}
	public static <T> void testAdd(FrontBackCappedListInterface<T> list, AddRemovePosition positionToAdd, T[] valuesToAdd, boolean expectedResult, String testDescription) {
		System.out.println("\nTesting add method: trying to add " + Arrays.toString(valuesToAdd) + " to " + positionToAdd + " of list");
		System.out.println("List before adding: " + list);

		int beforeSize = list.size();
		for(T value : valuesToAdd) {
			boolean actualResult;
			if(positionToAdd==AddRemovePosition.FRONT) { 	
				actualResult = list.addFront(value);
			} else { // positionToAdd==Position.BACK
				actualResult = list.addBack(value);
			}
			if(actualResult!=expectedResult) {
				allTestsPassed = false;
				System.out.println("**********TEST FAILED: incorrect return value when adding " + value + ".\ttest:" + testDescription);
				System.out.println("Expected return result: " + expectedResult + "\n  Actual return result: " + actualResult);
			}
		}
		if(expectedResult==false && beforeSize==list.size()) {
			System.out.println("List was full and add was unsuccessful, as expected.");
		}
		System.out.println("List after adding:  " + list);
		if(expectedResult==true) {
			int afterSize = list.size();
			int expectedAfterSize = beforeSize+valuesToAdd.length;
			if(expectedAfterSize != afterSize) {
				allTestsPassed = false;
				System.out.println("**********TEST FAILED: incorrect size after adding " + Arrays.toString(valuesToAdd) + ".\ttest:" + testDescription);
				System.out.println("\nExpected after size: " + expectedAfterSize + "\n  Actual after size: " + afterSize);
			} else { // expectedAfterSize == afterSize
				T expectedLastAddedValue = valuesToAdd[valuesToAdd.length-1];
				T actualLastAddedValue;
				if(positionToAdd==AddRemovePosition.FRONT) { 	 
					actualLastAddedValue = list.getEntry(0);
				} else { // positionToAdd==Position.BACK
					actualLastAddedValue = list.getEntry(list.size()-1);
				}
				if(!expectedLastAddedValue.equals(actualLastAddedValue)) {
					allTestsPassed = false;
					System.out.println("**********TEST FAILED: incorrect list contents. Review the output below.\ttest:" + testDescription);
				}
			}
		}
	}
	public static <T> void testContains(FrontBackCappedListInterface<T> list, T element, boolean expectedResult, String testDescription) {
		boolean actualResult = list.contains(element);
		System.out.println("\nTesting contains for target=" + element + " in list: " + list);
		System.out.println("Expected result: " + expectedResult);
		System.out.println("  Actual result: " + actualResult);
		if(expectedResult!=actualResult) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED.\ttest:" + testDescription);
		}
	}
	public static <T> void testIndexOf(FrontBackCappedListInterface<T> list, IndexPosition indexPosition, T element, String testDescription) {
		testIndexOf(list, indexPosition, element, -1, testDescription);
	}
	public static <T> void testIndexOf(FrontBackCappedListInterface<T> list, IndexPosition indexPosition, T element, int expectedResult, String testDescription) {
		int actualResult;
		String methodName = "ndexOf";
		if(indexPosition==IndexPosition.FIRST) {
			actualResult = list.indexOf(element);
			methodName = "i" + methodName;
		} else { // position==IndexPosition.LAST
			actualResult = list.lastIndexOf(element);
			methodName = "lastI" + methodName;
		}
		System.out.println("\nTesting " + methodName + ": finding target=" + element + " in list: " + list);
		System.out.println("Expected " + indexPosition + " index result: " + expectedResult);
		System.out.println("  Actual " + indexPosition + " index result: " + actualResult);

		if(expectedResult<0 && actualResult>=0) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED when finding the index of an element not in the list. \ttest:" + testDescription);
			System.out.println("     Result should indicate the element is NOT on the list.");
		} else if(expectedResult!=actualResult) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED when finding the index. \ttest:" + testDescription);
		}
	}
	public static <T> void testGetEntry(FrontBackCappedListInterface<T> list, int position, String testDescription) {
		testGetEntry(list, position, null, testDescription);
	}
	public static <T> void testGetEntry(FrontBackCappedListInterface<T> list, int position, T expectedResult, String testDescription) {
		T actualResult = list.getEntry(position);

		System.out.println("\nTesting getEntry for target index = " + position + " in list: " + list);
		System.out.println("Expected element at index " + position + ": " + expectedResult);
		System.out.println("  Actual element at index " + position + ": " + actualResult);

		if(expectedResult==null && actualResult!=null) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED when using an invalid position. \ttest:" + testDescription);
		} else if(expectedResult!=null && !expectedResult.equals(actualResult)) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED to get the expected element. \ttest:" + testDescription);
		}
	}
	public static <T> void testRemove(FrontBackCappedListInterface<T> list, AddRemovePosition positionToRemove, String testDescription) {
		testRemove(list, positionToRemove, null, testDescription);
	}
	public static <T> void testRemove(FrontBackCappedListInterface<T> list, AddRemovePosition positionToRemove, T expectedResult, String testDescription) {
		System.out.println("\nTesting remove: trying to remove from the " + positionToRemove + " of list");
		System.out.println("List before removing: " + list);

		int beforeSize = list.size();

		T actualResult;
		if(positionToRemove==AddRemovePosition.FRONT) { 	
			actualResult = list.removeFront();		
		} else { // positionToRemove==Position.BACK
			actualResult = list.removeBack();
		}
	
		System.out.println("List after  removing: " + list);
		System.out.println("Expected returned result: " + expectedResult + "\n  Actual returned result: " + actualResult);	

		int expectedAfterSize = 0, actualAfterSize = 0;
		if(expectedResult!=null) {
			actualAfterSize = list.size();
			expectedAfterSize = beforeSize-1;
			if(expectedAfterSize != actualAfterSize) {
				allTestsPassed = false;
				System.out.println("**********TEST FAILED with the wrong list size when removing from " + positionToRemove + ". \ttest: " + testDescription);
				System.out.println("Expected after size: " + expectedAfterSize + "\n  Actual after size: " + actualAfterSize);
			} 
		}
		if(expectedResult==null && actualResult!=null) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: incorrect element returned. \ttest:" + testDescription);
		} else if(expectedResult!=null && !expectedResult.equals(actualResult)) {
			allTestsPassed = false;
			System.out.println("**********TEST FAILED: incorrect element returned. \ttest:" + testDescription);
		}
	}
	public static enum AddRemovePosition {
		FRONT, BACK;	
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	public static enum IndexPosition {
		FIRST, LAST;
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
