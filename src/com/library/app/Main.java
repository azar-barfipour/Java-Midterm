package com.library.app;


public class Main {


	public static void main(String[] args) {
		Books<String , String> book = new Books<>("azar","12");
		System.out.println("Hi " + book.getUserName());
		System.out.println("Your ID is: " + book.getUserId());
		System.out.println("\n");
		System.out.println("\n");
		book.showMenu();
		
	}

}
