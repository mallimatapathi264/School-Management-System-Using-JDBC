package com.SchoolDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.School.Helper;

public class AdminPage {
	public static void fetchadmin() throws Exception{
		Connection con= Helper.getConnectionobj();
		 PreparedStatement ps = con.prepareStatement("SELECT * FROM admin");
	        ResultSet rs = ps.executeQuery();
		    if(rs.next())
	{	System.out.println("manager id"+ rs.getInt(1));
		System.err.println("Manager Name"+rs.getString(2));
		System.out.println("Mobile Number"+rs.getLong(3));
		System.out.println("Email"+rs.getString(4));
	}
	}
    public static void addAdmin() throws Exception {
        Scanner scn = new Scanner(System.in);
     
            System.out.println("Enter ID to Register:");
            int id = scn.nextInt();
            scn.nextLine(); 

            System.out.println("Enter name:");
            String name = scn.nextLine();

            System.out.println("Enter mobile number:");
            long ph = scn.nextLong();
            scn.nextLine(); 

            System.out.println("Enter email:");
            String email = scn.nextLine();

            System.out.println("Enter password:");
            String pswd = scn.nextLine();

            Connection con = Helper.getConnectionobj();
            PreparedStatement ps = con.prepareStatement("INSERT INTO admin(id, name, mobilenumber, email, password) VALUES(?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setLong(3, ph);
            ps.setString(4, email);
            ps.setString(5, pswd);
            ps.execute();

            System.out.println("Registered Successfully");
        } 
}