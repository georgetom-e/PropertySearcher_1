package com.amdocs.property;

import java.sql.SQLException;
import java.util.*;
import com.amdocs.property.model.*;
import com.amdocs.property.dao.*;

public class App{
	static List<Property> propertylist=new ArrayList<Property>();
	protected static Property createProperty() {
		Scanner sc=new Scanner(System.in);
		Property obj = new Property();
		try {
			System.out.println("Enter propertyId: ");
			int id = sc.nextInt();
			obj.setPropertyId(id);
			id=obj.getPropertyId();
		
			sc.nextLine();
			System.out.println("Enter no of Rooms: ");
			String noRooms = sc.nextLine();
			obj.setNoOfRooms(noRooms);
			noRooms=obj.getNoOfRooms();
			
			System.out.println("Enter no of Area in Sqft: ");
			double areaSqft = sc.nextDouble();
			obj.setAreaInSqft(areaSqft);
			areaSqft=obj.getAreaInSqft();
			
			System.out.println("Enter the floor number: ");
			int floorNo = sc.nextInt();
			obj.setFloorNo(floorNo);
			floorNo=obj.getFloorNo();
			
			System.out.println("Enter your city: ");
			sc.nextLine();
			String city = sc.nextLine();
			obj.setCity(city);
			city=obj.getCity();
			
			System.out.println("Enter your State: ");
			String state = sc.nextLine();
			obj.setState(state);
			state=obj.getState();
			
			System.out.println("Enter the price: ");
//			double areaSqft = Double.parseDouble(scanner.nextLine());
			double cost = sc.nextDouble();
			obj.setCost(cost);
			cost=obj.getCost();
			
			System.out.println("Enter the Owner's Name: ");
			sc.nextLine();
			String oname = sc.nextLine();
			obj.setOwnerName(oname);
			oname=obj.getOwnerName();
			
			System.out.println("Enter the Owner's Contact Number: ");
			String ocontact = sc.nextLine();
			obj.setOwnerContactNo(ocontact);
			ocontact=obj.getOwnerContactNo();
			
		} catch (NumberFormatException e) {
			System.out.println("Provide a VALID Number: \n " + e.getMessage());
		}

		return obj;
	}

	protected static void displayProperty(Property property) {
		System.out.println(property);							
	}

	protected static PropertyDao dao = new PropertyDaoImp();
	

	protected static void addProperty() {
		Property createProperty;

			createProperty = createProperty();

			int id= dao.addProperty(createProperty);

			System.out.println("The property details have been added.");
		
	}
	
	protected static void deleteProperty() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Property ID to be deleted: ");
		int id=sc.nextInt();
		int del=dao.deleteProperty(id);	
		System.out.println("Yes, property details with ID: "+ del + " has been deleted!");
	}
	
	protected static void updatePropertyCost() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Product ID to be updated: ");
		int id=sc.nextInt();
		System.out.println("Enter the new cost: ");
		Double cost=sc.nextDouble();
		dao.updatePropertyCost(id,cost);
		System.out.println("Yes, property details with ID: "+ id + " has been updated");
	}
	
	protected static void searchByCity() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Desired City Name: ");
		String city=sc.nextLine();
		List<Property> list1=dao.ByCity(city);
		System.out.println(list1);
	}
	protected static void showAllProperty() {
		PropertyDao dao=new PropertyDaoImp();
		List<Property> allProperty = dao.showAllProperties();
		for (Property property : allProperty) {
			if (property != null)
				System.out.println(property);
		}
	}
	protected static void searchByCost() {
		PropertyDao dao=new PropertyDaoImp();
		System.out.println("Minimum price: ");
		Scanner sc=new Scanner(System.in);
		Double min=sc.nextDouble();
		System.out.println("Maximum price: ");
		Double max=sc.nextDouble();
		List<Property> allProperty = dao.searchByCost(min, max);
		for (Property property : allProperty) {
			if (property != null)
				System.out.println(property);
		}
	}
	protected static void searchByNoOfRoomsAndCity() {
		PropertyDao dao=new PropertyDaoImp();
		System.out.println("Enter the City's Name: ");
		Scanner sc=new Scanner(System.in);
		String room=sc.nextLine();
		System.out.println("Enter the required BHK count: ");
		String city=sc.nextLine();
		List<Property> allProperty = dao.searchByNoOfRoomsAndCity(room,city);
		for (Property property : allProperty) {
			if (property != null)
				System.out.println(property);
		}
	}
	
	
}

