package com.slk.training.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.slk.training.entity.Person;
import com.slk.training.entity.Product;

public class P06_UsingCollections {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>(
				Arrays.asList("vinod", "shyam", "harish", "nagesh", "john", "jane", "smith"));
		print(names);
		Collections.reverse(names);
		print(names);
		Collections.swap(names, 2, 3);
		print(names);
		Collections.rotate(names, 3);
		print(names);
		Collections.sort(names);
		print(names);

		List<Person> people = new ArrayList<Person>();
		people.add(new Person(3, "Anand", "heroanand@example.com", "Delhi"));
		people.add(new Person(1, "Vinod", "vinod@vinod.co", "Bangalore"));
		people.add(new Person(2, "John Doe", "john@example.com", "Delhi"));
		people.add(new Person(4, "Praveen", "kumarpraveen@gmail.com", "Mysore"));

		print(people);
		Collections.sort(people);
		print(people);

		List<Product> products = new ArrayList<>();
		products.add(new Product("Laptop", 55000.0));
		products.add(new Product("Mobile", 15000.0));
		products.add(new Product("Television", 45000.0));
		products.add(new Product("PC", 65000.0));

		Collections.sort(products, 
				(p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		
		print(products);

		Collections.sort(products, 
				(p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		print(products);

	}

	private static void print(List<?> list) {
		for (Object data : list) {
			System.out.println(data);
		}
		System.out.println("-----------------------");
	}

}
