package com.book.main;

import java.util.Scanner;

import com.book.dao.*;
import com.book.entities.*;

public class MainStore {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String entity, ans = "";
		
		do {
			System.out.println("Which class bookstore or library?");
			entity = scan.nextLine();
			 if("bookstore".equalsIgnoreCase(entity)) {
				Entity e = EntityFactory.getEntity("bookstore");	
			}else if("library".equalsIgnoreCase(entity)) {
				Entity e = EntityFactory.getEntity("library");	
			}else
				System.out.println("Wrong choice.");
			System.out.println("Would you like to continue?");
			ans = scan.nextLine();
		}while(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y"));
		
		
		
	}
	

}
