package com.slk.training.programs;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P03_UsingMap {

	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();
		
		map.put("vinod", "Bangalore");
		map.put("vinod", "Shivamogga");
		map.put("jane", "Chicago");
		map.put("john", "Dallas");
		map.put("shyam", "Shivamogga");
		
		System.out.println(map);
		String name = "vinod";
		System.out.printf("%s is from %s\n", name, map.get(name));
		
		System.out.println("The keys in the map are: " + map.keySet());
		System.out.println("The values in the map are: " + map.values());
		
		System.out.println("Accessing map data in a loop#1: ");
		for(Entry<String, String> eset: map.entrySet()) {
			System.out.printf("%s is from %s\n", eset.getKey(), eset.getValue());
		}
		
		System.out.println("Accessing map data in a loop#2: ");
		for(String key: map.keySet()) {
			System.out.printf("%s is from %s\n", key, map.get(key));
		}
		
		
		
	}
}



