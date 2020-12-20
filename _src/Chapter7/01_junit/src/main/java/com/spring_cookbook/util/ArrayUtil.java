package com.spring_cookbook.util;

import java.util.ArrayList;

public class ArrayUtil {
	public static ArrayList<Integer> sortArray(ArrayList<Integer> t) {
		ArrayList<Integer> array = new ArrayList<Integer>(t);
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();

		while (!array.isEmpty()) {
			Integer min = array.get(0);
			for (int i = 1; i < array.size(); i++) {
				if (array.get(i) < min) {
					min = array.get(i);
				}
			}

			sortedArray.add(min);
			array.remove(min);
		}

		return sortedArray;
	}
}
