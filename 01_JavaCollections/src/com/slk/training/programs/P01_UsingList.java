package com.slk.training.programs;

import java.util.ArrayList;
import java.util.List;

public class P01_UsingList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("vinod");
		list.add("john");
		list.add("jane");
		list.add("smith");
		
		System.out.println(list);
		
		System.out.println("The names are: ");
		for(String name: list) {
			System.out.println(name);
		}
		
		System.out.println("Name at index 3 is: " + list.get(3));
		int index = list.indexOf("john");
		list.add(index+1, "martin");
		System.out.println(list);
		
		index = list.indexOf("martin");
		list.set(index, "jacob");
		System.out.println(list);
		
		list.remove("jacob");
		System.out.println(list);
		
		
	}
}









