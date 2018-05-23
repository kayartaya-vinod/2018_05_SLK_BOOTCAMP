package com.slk.training.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class P05_UsingIterator {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>(Arrays.asList("vinod", "shyam", "harish", "nagesh", "john", "jane", "smith"));
		
		System.out.println("Accessing elements of a List using iterator:");
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String name = it.next();
			if(name.equals("john")) {
				System.out.println("Deleting " + name + "...");
				it.remove();
			}
			else {
				System.out.println(name);
			}
		}
		System.out.println(names);
		
		System.out.println("Accessing elements of a List using enhanced for loop:");
		for(String name: names) {
			if(name.equals("harish")) {
				System.out.println("Deleting " + name + "...");
				names.remove(name);
			}
			else {
				System.out.println(name);
			}
		}
		
	}
}







