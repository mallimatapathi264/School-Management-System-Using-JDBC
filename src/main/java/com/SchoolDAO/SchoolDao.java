package com.SchoolDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.School.Helper;

public class SchoolDao {
	 public static void addschool() throws Exception
     {
  	   Scanner scn = new Scanner(System.in);
  	   System.out.println("Enter School ID to Register:");
         String schoolid = scn.nextLine();

         System.out.println("Enter School name:");
         String schoolname = scn.nextLine();
         
         System.out.println("Enter School Address:");
         String schooladdress = scn.nextLine();
         
         System.out.println("Enter School Phone Number:");
         Long schoolphonenumber = scn.nextLong();
         
         System.out.println("Enter School email:");
         String schoolemail = scn.next();
         
         System.out.println("Enter School Password:");
         String schoolpassword = scn.next();
         
         Connection con = Helper.getConnectionobj();
         PreparedStatement ps = con.prepareStatement("INSERT INTO school(schoolid, schoolname, schooladdress, schoolphonenumber, schoolemail, schoolpassword) VALUES(?,?,?,?,?,?)");
         ps.setString(1, schoolid);
         ps.setString(2, schoolname);
         ps.setString(3, schooladdress);
         ps.setLong(4, schoolphonenumber);
         ps.setString(5,schoolemail);
         ps.setString(6,schoolpassword);
         
         ps.execute();
         System.out.println("Registered Successfully");
     }
     
     public static void updateSchool() throws Exception
     {
  	   
  	   Scanner scn = new Scanner(System.in);
  	   System.out.println("Enter School ID to Update:");
         int id = scn.nextInt();
        
  	   System.out.println("Enter new School name:");
         String name = scn.nextLine();
         
         System.out.println("Enter new School Address:");
         String address = scn.nextLine();
         
         System.out.println("Enter new School Phone Number:");
         Long phno = scn.nextLong();
         
         System.out.println("Enter new School email:");
         String email = scn.nextLine();
         
         System.out.println("Enter new School Password:");
         String password = scn.nextLine();
         
         Connection con = Helper.getConnectionobj();
         PreparedStatement ps = con.prepareStatement("UPDATE school set schoolname=?, schooladdress=?, schoolphonenumber=?, schoolemail=?, password=? where id=?");
         ps.setString(1,name);
         ps.setString(2, address);
         ps.setLong(3, phno);
         ps.setString(4,email);
         ps.setString(5,password);
         ps.setInt(6, id);
         ps.execute();
         System.out.println("School Updated Successfully");
     }

	public static void fetchschooldetails() throws Exception
	{
		Connection con= Helper.getConnectionobj();
		 PreparedStatement ps = con.prepareStatement("SELECT * FROM school");
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("ID: " + rs.getString(1));
	            System.out.println("Name: " + rs.getString(2));
	            System.out.println("Address: " + rs.getString(3));
	            System.out.println("PhoneNumber: " + rs.getLong(4));
	            System.out.println("Email: " + rs.getString(5));
	            
	        } 
	        }
	    }