package com.library.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Books<s1 , s2> {
	boolean reserv=false;
	String savedbookName="";
	String savedauthorName="";
	private final s1 userName;
	private final s2 userId;
	

	
	public Books(s1 userName, s2 userId) {
		this.userName = userName;
		this.userId = userId;
	}


	public s1 getUserName() {
		return userName;
	}


	public s2 getUserId() {
		return userId;
	}
	
 	ArrayList<Book> bookList= new ArrayList<>();

    public void bookListM() {
		bookList.add(new Book("Book1","Author1"));
		bookList.add(new Book("Book2","Author2"));
		bookList.add(new Book("Book3","Author3"));
		
//		System.out.println(bookList.get(0).getBookName()+" "+ bookList.get(0).getAuthorName()+"\n"+bookList.get(1).getBookName()+" "+ bookList.get(1).getAuthorName()+"\n"+bookList.get(2).getBookName()+" "+ bookList.get(2).getAuthorName()+"\n");
		if(savedbookName=="" && savedauthorName=="" && reserv== false) {
			for(int i=0; i<bookList.size(); i++) {
			String name = bookList.get(i).getBookName();
			String author = bookList.get(i).getAuthorName();
			System.out.println(name +" "+ author);
			}}
		else if(savedbookName!="" && savedauthorName!="") {
			bookList.add(new Book(savedbookName,savedauthorName));
			System.out.println(bookList.get(0).getBookName()+" "+ bookList.get(0).getAuthorName()+"\n"+bookList.get(1).getBookName()+" "+ bookList.get(1).getAuthorName()+"\n"+bookList.get(2).getBookName()+" "+ bookList.get(2).getAuthorName()+"\n"+ savedbookName+ " " +savedauthorName);
	
		}
		
		
	   
	
//		System.ot.println(bookList.get(0).getBookName()+" "+ bookList.get(0).getAuthorName()+"\n"+bookList.get(1).getBookName()+" "+ bookList.get(1).getAuthorName()+"\n"+bookList.get(2).getBookName()+" "+ bookList.get(2).getAuthorName()+"\n"+ savedbookName+ " " +savedauthorName);
    }
    
     
    
	void addBooks(String bookName, String authorName) {
		    
			System.out.println(bookName +" "+authorName+ " added to the library\n");
//			bookListM();
			
		
	}
	
	public void findBookName(String bookName,String bookName2) {
		if(bookName.equals(bookName2) && bookName.length()!= 0 && reserv == false) {
			System.out.println("Book found\n" + "Book Name : " + bookName +" "+"Author Name : "+ savedauthorName);
			
		}
		for(int i=0; i<3;i++) {
		if(bookList.get(i).getBookName().equals(bookName2)&& reserv == false) {
			System.out.println("Book found\n" + "Book Name : " + bookList.get(i).getBookName()+" "+"Author Name : "+bookList.get(i).getAuthorName() );
		}
	   
		}
	   	if (reserv == true) {
     		errorMessage("This Book is no longer available");
     	}
		}


	void findAuthorBook(String authorName,String authorName2) {
         if(authorName.equals(authorName2) && authorName.length() != 0 && reserv == false) {
			System.out.println("Book found\n" + "Book Name : " + savedbookName +" "+"Author Name : "+ authorName);
		}
         
     	for(int i=0; i<3;i++) {
    		if(bookList.get(i).getAuthorName().equals(authorName2) && reserv == false) {
    			System.out.println("Book found\n" + "Book Name : " + bookList.get(i).getBookName()+" "+"Author Name : "+bookList.get(i).getAuthorName() );
    		}
    	   
    		}
     	if (reserv == true) {
     		errorMessage("This Book is no longer available");
     	}
         
//         else if((bookList.get(0).getAuthorName().equals(authorName2) || bookList.get(1).getAuthorName().equals(authorName2) || bookList.get(2).getAuthorName().equals(authorName2)) && bookList.size()!= 0 && reserv == false) {
//			System.out.println("Book found\n");}
//		else {
//			errorMessage("There is no book with this Author name");
//		}
		
	}
	
	void reserved() {
		System.out.println("The Book Successfully Reserved");
		reserv=true;

	
	}
	
	void errorMessage(String message) {
		System.out.println("\n");
		System.out.println("***********");
		System.out.println(message);
		System.out.println("***********");
		System.out.println("\n");
	}
	void showMenu() {
		char option;
		Scanner scanner = new  Scanner(System.in);
		do {
			System.out.println("***********");
			System.out.println("Welcome to my Library");
			System.out.println("***********");
			System.out.println("Please select your option");
			System.out.println("***********");
			System.out.println("S : Show Books");
			System.out.println("A : Add Books");
			System.out.println("B : Search Books by Book name");
			System.out.println("C : Search Books by Author name");
			System.out.println("D : Reserve Books");
			System.out.println("E : Exit");
			option = scanner.next().charAt(0);
			switch (Character.toLowerCase(option)){
			case 's' : 
				System.out.println("***********");
				System.out.println("List of books in library");
				System.out.println("***********");
				bookListM();
				break;
			
				case 'a' : 
					System.out.println("***********");
					System.out.println("Enter the bookName and authoName");
					System.out.println("***********");					
					String bookName = scanner.next();
					String authorName = scanner.next();
					savedbookName = bookName;
					savedauthorName = authorName;
					addBooks(bookName,authorName);
					break;
				case 'b' : 
					System.out.println("***********");
					System.out.println("Enter the book name to find");
					System.out.println("***********");
					
					try {
						String bookName2 = scanner.next();
						findBookName(savedbookName,bookName2);
					}
					
					catch (Exception e) {
						errorMessage("Please don't leave it blank");
					}
					
					break;
					
				case 'c' : 
					System.out.println("***********");
					System.out.println("Enter the Author name to find");
					System.out.println("***********");
					
					try {
						String authorName2 = scanner.next();
						findAuthorBook(savedauthorName,authorName2);
					}
					
					catch (Exception e) {
						errorMessage("Please don't leave it blank");
					}
					break;
					
				case 'd' : 
					System.out.println("***********");
					System.out.println("Book Reservation");
					System.out.println("***********");
					reserved();
					break;
					
				case 'e' : 
					System.out.println("Thank you:)");
					break;
				default:
					System.out.println("Invalid Option. Please try again.");
					break;
			}
		}while(Character.toLowerCase(option) != 'e');
		scanner.close();
	} 
}
