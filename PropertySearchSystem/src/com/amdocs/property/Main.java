package com.amdocs.property;
import java.util.*;
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("STARTING APP NOW...");
		try {
			while (true) {
				System.out.println(" 1. Add new property.");
				System.out.println(" 2. Update property.");
				System.out.println(" 3. Delete property ");
				System.out.println(" 4. Find by city");
				System.out.println(" 5. View all properties.");
				System.out.println(" 6. Find by cost.");
				System.out.println(" 7. Find by number of rooms and city.");
				System.out.println(" 8. Exit");
			
				System.out.println("\nEnter your choice");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					App.addProperty();
					break;
				case 2:
					App.updatePropertyCost();
					break;
				case 3:
					App.deleteProperty();
					break;
				case 4:
					App.searchByCity();
					break;
				case 5:
					App.showAllProperty();
					break;
				case 6:
					App.searchByCost();
					break;
				case 7:
					App.searchByNoOfRoomsAndCity();
					break;
				case 8:
					System.out.println("Exiting...App Exited.");
					System.exit(0);
				default:
					System.out.println("INVALID CHOICE:");
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("INVALID Number Format."+"\nYour Format is :" + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
	}
}
	
