package com.slk.training.programs;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class P04_WordsOfLetters {
	public static void main(String[] args) {
		
		String sentence = "my name is vinod and i am from shivamogga and currently i live in bangalore my mother is from mangalore";
		String[] words = sentence.split("\\s");
		
		Map<String, Set<String>> map = new TreeMap<String, Set<String>>();
		
		for(String word: words) {
			String key = word.substring(0, 1);
			// check if the map contains the first letter (key)
			if(map.containsKey(key)) {
				// if yes, add the word the existing set
				map.get(key).add(word);
			}
			else {
				// if no, create a new set, add the word to the set, and 
				// put the word with the key in the map
				Set<String> set = new TreeSet<String>();
				set.add(word);
				map.put(key, set);
			}
		}
		// output the map
		for(Entry<String, Set<String>> eset: map.entrySet()) {
			System.out.printf("%s --> %s\n", eset.getKey(), eset.getValue());
		}
	}
	
	

}








