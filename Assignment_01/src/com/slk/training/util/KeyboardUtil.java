package com.slk.training.util;

import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("resource")
public final class KeyboardUtil {
	private KeyboardUtil() {
	}

	public static String getString(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message);
		return scanner.nextLine();
	}

	public static int getInt(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message);
		return scanner.nextInt();
	}

	public static double getDouble(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message);
		return scanner.nextDouble();
	}

	public static Date getDate(String message) {
		String date = getString(message);
		return DateUtil.toDate(date);
	}

	public static String getUpdatedString(String field, String value) {
		System.out.printf("%s %s: ", field, value==null?"": "("+value+")");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.trim().length() == 0) {
			return value;
		} else {
			return input;
		}
	}
}
