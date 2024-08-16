package com.SchoolDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.School.Helper;

public class StudentDao {
	
	public static void stdspecific() throws Exception
	{
		 StudentDao.fetchallstudents();
		 StudentDao.fetchstddetails();
	}
	public static void stdcrud() throws Exception
	{
        Scanner scn = new Scanner(System.in);
        

		System.out.println("Welcome to Student Portal");
		System.out.println("1.Fetch all Students");
		System.out.println("2.Fetch specific student detals");
		System.out.println("3.Logout Student portal");
		System.out.println("4.Exit Application");
		int n = scn.nextInt();
		switch(n) {
		case 1: StudentDao.fetchallstudents();StudentDao.stdcrud();
		
		break;
		case 2: StudentDao.fetchstddetails();StudentDao.stdcrud();
		break;
		case 3: System.out.println("Exiting Student portal....");
		return;
		case 4: System.out.println("Exiting Application...");
        System.exit(0);
		
		default: System.out.println("please Enter Valid number");
		}
	}

    public static void Add_student() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID:");
        int id = scn.nextInt();

        System.out.println("Enter name:");
        String name = scn.next();

        System.out.println("Enter class:");
        int cls = scn.nextInt();

        System.out.println("Enter age:");
        int age = scn.nextInt();

        System.out.println("Enter score:");
        int score = scn.nextInt();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("INSERT INTO student(id, name, class, age, score) VALUES(?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, cls);
        ps.setInt(4, age);
        ps.setInt(5, score);
        ps.execute();

        System.out.println("Registered Successfully");
        loginPageDao.Teacherallcrud();
    }
    public static void update_student() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to update:");
        int id = scn.nextInt();
        System.out.println("Enter new name:");
        String name = scn.next();

        System.out.println("Enter new class:");
        int cls = scn.nextInt();

        System.out.println("Enter new age:");
        int age = scn.nextInt();

        System.out.println("Enter new score:");
        int score = scn.nextInt();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, class=?, age=?, score=? WHERE id=?");
        ps.setString(1, name);
        ps.setInt(2, cls);
        ps.setInt(3, age);
        ps.setInt(4, score);
        ps.setInt(5, id);
        ps.executeUpdate();

        System.out.println("Updated Successfully");
        loginPageDao.Teacherallcrud();

    }
    public static void delete_student() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to delete:");
        int id = scn.nextInt();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Deleted Successfully"); 
        loginPageDao.Teacherallcrud();
    }
    public static void fetchallstudents() throws Exception {
        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Class: " + rs.getInt(3) + "th");
            System.out.println("Age: " + rs.getInt(4));
            System.out.println("Score: " + rs.getInt(5));
            System.out.println("------------------------------");
        }
        System.out.println("Data fetched successfully");
    }
    public static void fetchstddetails() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to fetch:");
        int id = scn.nextInt();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Class: " + rs.getInt(3) + "th");
            System.out.println("Age: " + rs.getInt(4));
            System.out.println("Score: " + rs.getInt(5));
            System.out.println("Data fetched successfully");
        } else {
            System.out.println("No student found with ID: " + id);
 
        }
    }
    public static void updateStudentDetails() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to update:");
        int id = scn.nextInt();
        System.out.println("Enter new name:");
        String name = scn.next();

        System.out.println("Enter new class:");
        int cls = scn.nextInt();

        System.out.println("Enter new age:");
        int age = scn.nextInt();
        
        System.out.println("Enter new score:");
        int score = scn.nextInt();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?, class=?, age=?, score=? WHERE id=?");
        ps.setString(1, name);
        ps.setInt(2, cls);
        ps.setInt(3, age);
        ps.setInt(4, score);
        ps.setInt(5, id);
        ps.executeUpdate();

        System.out.println("Student details updated successfully");
        loginPageDao.Teacherallcrud();
    }
}
