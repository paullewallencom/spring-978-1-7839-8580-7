package com.spring_cookbook.util;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testSortArray() {
	  // create an array
	  ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1, 0, -1, -2));
	  
	  // sort the array
	  ArrayList<Integer> sortedArray = ArrayUtil.sortArray(array);
	  
	  // test the array is actually sorted
	  for (int i = 1; i < sortedArray.size(); i++) {
		assertTrue(sortedArray.get(i-1) < sortedArray.get(i));
	  } 
	}

}
