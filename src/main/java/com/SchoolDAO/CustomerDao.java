package com.SchoolDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.School.Helper;
import com.School.SchoolManagementDriver;

public class CustomerDao {
	
	public static void addcustomer() throws Exception
	{
		Scanner scn= new Scanner(System.in);
		System.out.println("Enter id to Register");
		int id= scn.nextInt();
		System.out.println("Enter your Name");
		String name= scn.next();
		
		System.out.println("Enter your contact number");
		long mobilenumber = scn.nextLong();
		
		System.out.println("Enter your email");
		String email= scn.next();

		System.out.println("enter your password");
		String password= scn.next();

		Connection con= Helper.getConnectionobj();
		PreparedStatement ps= con.prepareStatement("insert into customer(id, name, mobilenumber, email,password) values(?,?,?,?,?)");
		ps.setLong(1, id);
		ps.setString(2, name);
		ps.setLong(3, mobilenumber);
		ps.setString(4, email);
		ps.setString(5, password);
		ps.execute();
	    System.out.println("Customer Registered Successfully");
	    System.out.println("Login Customer");
	    CustomerDao.customerlogin();
	}
	public static void customerlogin() throws Exception
	{
		 Scanner scn = new Scanner(System.in);
	        System.out.println("Enter email:");
	        String email = scn.nextLine();
	        System.out.println("Enter password:");
	        String password = scn.nextLine();

	        Connection con = Helper.getConnectionobj();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE email=? AND password=?");
	        ps.setString(1, email);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("Welcome to Customer Portal");
	            while (true) {
	            	CustomerDao.customercrud();
	            }
	        }else
	        {
	        	System.out.println("invalid Credentials");
	        	CustomerDao.customerlogin();
	        }
}
	public static void customercrud() throws Exception
	{			 Scanner scn = new Scanner(System.in);

		System.out.println("1. School Details");
        System.out.println("2. Management Details");
        System.out.println("3. No of Teachers");
        System.out.println("4. No of. Students");
        System.out.println("5. Logout Customer Portal");
        System.out.println("6. Exit Application");
        int choice = scn.nextInt();

        switch (choice) {
            case 1:SchoolDao.fetchschooldetails();
            break;
            case 2: AdminPage.fetchadmin();
            break;
            case 3: TeacherDao.fetchallteachers();
            break;
            case 4: StudentDao.fetchallstudents();
            break;
            case 5: System.out.println("Exiting Customer Portal...");
            SchoolManagementDriver.main(); 
            break;
            case 6: System.out.println("Exiting Application...");
            System.exit(0);
            default: System.out.println("Enter valid number");	
        }
	}
}
