package com.slk.training.programs;

import java.io.FileInputStream;

public class P01_ReadingFromFile {

	public static void main(String[] args) throws Exception {
		// relative path starts from the current project folder
		String filename = "./src/com/slk/training/programs/P01_ReadingFromFile.java";
		FileInputStream file = new FileInputStream(filename);

		// int ch;
		// while ((ch = file.read()) != -1) {
		// System.out.print((char) ch);
		// }

		int size = file.available();
		byte[] bytes = new byte[size];
		file.read(bytes);
		System.out.println(new String(bytes));

		file.close();
	}
}
