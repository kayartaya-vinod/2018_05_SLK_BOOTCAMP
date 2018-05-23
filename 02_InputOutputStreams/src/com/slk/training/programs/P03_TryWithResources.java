package com.slk.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;

public class P03_TryWithResources {

	public static void main(String[] args) throws Exception {
		String filename = "./src/com/slk/training/programs/P01_ReadingFromFile.java";

		try (FileReader file = new FileReader(filename); 
				BufferedReader in = new BufferedReader(file);) {
			String line;

			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("after while loop");
		}
	}
}
