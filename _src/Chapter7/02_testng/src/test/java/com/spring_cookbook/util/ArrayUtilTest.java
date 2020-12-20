package com.spring_cookbook.util;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayUtilTest {

	@DataProvider
	public Object[][] integerArrays() {	
	return new Object[][] {
	  new Object[] { new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1, 0, -1, -2)) },
	  new Object[] { new ArrayList<Integer>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2)) },
	  new Object[] { new ArrayList<Integer>(Arrays.asList(100, 5, 90, 2, 89, 32)) },
	  new Object[] { new ArrayList<Integer>(Arrays.asList(80, 199, 56, 23, 342, 21)) },
	 };
	}

	@Test(dataProvider = "integerArrays")
	public void testArrayIsSorted(ArrayList<Integer> array) {
	  ArrayList<Integer> sortedArray = ArrayUtil.sortArray(array);
	  
	for (int i = 1; i < sortedArray.size(); i++) {
		assertTrue(sortedArray.get(i-1) < sortedArray.get(i));
	  } 
	}

}
