package com.book.dao;

import java.util.Scanner;

import com.book.entities.*;

public interface EntityFactory {
	public static Entity getEntity(String entity) {
		Scanner scan = new Scanner(System.in);

		int choice = 0;

		 if(entity.equalsIgnoreCase("bookstore")) {
			Dao dao = new BookstoreDao();
			BookstoreDao storedao = new BookstoreDao();
			Bookstore store; 

			do {
				System.out.println("1) create superclass \n2) create subclass"
						+ "\n3) read \n4) update \n5) delete \n6) exit");
				choice = Integer.parseInt(scan.nextLine());
				
				//int id, String title, String author, String genre, int page, double price, String pubdate,
				//String storeType, int unitsSold, boolean hasDiscount
				
				switch(choice) {
				case 1:
					store = new Bookstore(0, "Melkin", "Mety", 
							"drama",145, 15.23, "2018-02-26", "brick", 29888, true);
					dao.insert(store);
					break;
				case 2:
					store = new Bookstore();
				
					store.setId(3);
					store.setStoreType("brick");
					store.setUnitsSold(25888);
					store.setHasDiscount(false);
					storedao.insert(store);
					break;
				case 3:
					String query = "select * from book\r\n"
							+ "inner join store on \r\n"
							+ "book.id = store.id;";
					dao.readM(query);
					break;
				case 4:
					//String newValue, String column, String table, int id

					dao.update("online", "storeType", "store", 1);
					break;
				case 5:
					dao.delete("book", 8);
					break;
				case 6: 
					System.out.println("Bye.");
					break;
				default:
					System.out.println("Wrong number.");
				}
				
				
			}while(choice != 6);
		
			return new Bookstore();
			}
		else if(entity.equalsIgnoreCase("library")) {
			Dao dao = new LibraryDao();
			Library library = new Library();
			
			do {
				System.out.println("1) create \n2) read \n3) update \n4) delete \n5) exit");
				choice = Integer.parseInt(scan.nextLine());
				switch(choice) {
				case 1:
					library.setId(6);
					library.setLibrarianName("Terry");
					library.setLent(1500);
					library.setUsers(2970);
					dao.insert(library);
					break;
				case 2:
					String query = "select * from book\r\n"
							+ "inner join library on \r\n"
							+ "book.id = library.id;";
							
					dao.readM(query);
					break;
				case 3:
				//String newValue, String column, String table, int id

					dao.update("Kilop", "librarianName","library", 7);
					break;
				case 4:
					//String table, int id
					dao.delete("library",6);
					break;
				case 5:
					System.out.println("Bye.");
					break;
				default:
					System.out.println("Wrong number.");
				
				}
				
			}while(choice != 5);
			
			return new Library();
			
		}
			return null;
	}
	
	

}
