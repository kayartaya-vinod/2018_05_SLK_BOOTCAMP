package com.slk.training.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P07_UsingComparator {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>(
				Arrays.asList("vinod kumar", "aardhya", "shyam sundar kc", "harish", "anu", "nagesh", "john", "jane", "smith"));
		Collections.sort(names);
		System.out.println(names);

		Comparator<String> cmp = new StringLengthComparator();
		Collections.sort(names, cmp);
		System.out.println(names);

		Comparator<String> cmp1 = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		};
		Collections.sort(names, cmp1);
		System.out.println(names);

		Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
		System.out.println(names);
		
		String shortestName = Collections.min(names, (s,t)->s.length()-t.length());
		System.out.println("Shortest name = " + shortestName);

	}

	private static class StringLengthComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}

	}
}
