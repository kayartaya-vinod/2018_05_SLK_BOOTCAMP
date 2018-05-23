package com.slk.training.programs;

import java.util.Set;
import java.util.TreeSet;

import com.slk.training.entity.Person;

public class P02_UsingSet {

	public static void main(String[] args) {

		Set<String> names = new TreeSet<String>();

		names.add("vinod");
		names.add("vinod");
		names.add("vinay");
		names.add("harish");
		names.add("vinod");
		names.add("nagesh");
		names.add("anand");

		System.out.println(names);
		
		Set<Person> people = new TreeSet<Person>();
		
		Person p1 = new Person(1, "Vinod", "vinod@vinod.co", "Bangalore");
		people.add(p1);
		
		Person p2 = new Person(1, "Vinod", "vinod@vinod.co", "Bangalore");
		people.add(p2);
		
		System.out.println("p1.hashCode() is " + p1.hashCode());
		System.out.println("p2.hashCode() is " + p2.hashCode());
		System.out.println("p1.equals(p2) is " + p1.equals(p2));
		
		people.add(new Person(2, "John Doe", "john@example.com", "Delhi"));
		people.add(new Person(3, "Anand", "heroanand@example.com", "Delhi"));
		people.add(new Person(4, "Praveen", "kumarpraveen@gmail.com", "Mysore"));
		
		System.out.printf("There are %d people in the set\n", people.size());
		
		for(Person p: people) {
			System.out.println(p);
		}
	}
}













