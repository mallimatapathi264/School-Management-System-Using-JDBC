package com.SchoolDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.School.Helper;

public class TeacherDao {
	public static void teachercrud() throws Exception
	{	 
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Welcome to Teacher Portal");
		System.out.println("1. Register New Teacher");
		System.out.println("2. Update Teacher Details");
		System.out.println("3. Delete Teacher");
		System.out.println("4. Fetch All Teachers");
		System.out.println("5. Fetch Specific Teacher");
		System.out.println("6. Exit from Teacher Portal");
		System.out.println("7. Exit Application");
		int n=scn.nextInt();
		switch(n) {
		case 1:	TeacherDao.add_teacher();
				TeacherDao.teachercrud();
		break;
		case 2: TeacherDao.update_teacher();
				TeacherDao.teachercrud();
		break;
		case 3: TeacherDao.delete_teacher();
		    	TeacherDao.teachercrud();
		break;
		case 4: TeacherDao.fetchallteachers();
				TeacherDao.teachercrud();
		break;
		case 5: TeacherDao.fetch_teachers();
				TeacherDao.teachercrud();
		break;
		case 6:System.out.println("Exiting Teacher Portal..."); 
		return;
		case 7:System.out.println("Exiting Application...");
        System.exit(0);
		default:System.out.println("Invalid choice. Please try again.");
		TeacherDao.teachercrud();
		}
	}
	
    public static void add_teacher() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to register:");
        int id = scn.nextInt();

        System.out.println("Enter name:");
        String name = scn.next();
        System.out.println("Enter subject:");
        String sub = scn.next();

        System.out.println("Enter age:");
        int age = scn.nextInt();

        System.out.println("Enter salary:");
        double salary = scn.nextDouble();

        System.out.println("Enter email:");
        String email = scn.next();

        System.out.println("Enter password:");
        String password = scn.next();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("insert into teacher(id, name, subject, age, salary, email, password) values(?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, sub);
        ps.setInt(4, age);
        ps.setDouble(5, salary);
        ps.setString(6, email);
        ps.setString(7, password);
        ps.execute();
        System.out.println("Registered successfully");
        
    }

    public static void fetchallteachers() throws Exception {
        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("select * from teacher");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Subject: " + rs.getString(3));
            System.out.println("Age: " + rs.getInt(4));
            System.out.println("Salary: " + rs.getDouble(5));
            System.out.println("Email: " + rs.getString(6));
            System.out.println("-----------------------------");
            
        }
        System.out.println("Data fetched successfully");
        
    }

    public static void update_teacher() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to update:");
        int id = scn.nextInt();
        System.out.println("Enter new name:");
        String name = scn.next();
        System.out.println("Enter new subject:");
        String sub = scn.next();
        System.out.println("Enter new salary:");
        int salary = scn.nextInt();
        System.out.println("Enter new age:");
        int age = scn.nextInt();
        System.out.println("Enter new email:");
        String email = scn.next();
        System.out.println("Enter new password:");
        String password = scn.next();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("update teacher set name=?, subject=?, salary=?, age=?, email=?, password=? where id=?");
        ps.setString(1, name);
        ps.setString(2, sub);
        ps.setInt(3, salary);
        ps.setInt(4, age);
        ps.setString(5, email);
        ps.setString(6, password);
        ps.setInt(7, id);
        ps.executeUpdate();
        System.out.println("Updated successfully");

    }

    public static void fetch_teachers() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to fetch:");
        int id = scn.nextInt();
        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("select * from teacher where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Name: " + rs.getString(2));
            System.out.println("Subject: " + rs.getString(3));
            System.out.println("Age: " + rs.getInt(4));
            System.out.println("Salary: " + rs.getDouble(5));
            System.out.println("Email: " + rs.getString(6));
            System.out.println("Teacher details fetched successfully");
            TeacherDao.teachercrud();
        } else {
            System.out.println("No teacher found with ID: " + id);
        }
    }

    public static void delete_teacher() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter ID to delete:");
        int id = scn.nextInt();
        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("delete from teacher where id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Deleted successfully");
    }
}
