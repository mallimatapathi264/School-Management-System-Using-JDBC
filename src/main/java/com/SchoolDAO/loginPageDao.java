package com.SchoolDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.School.Helper;
import com.School.SchoolManagementDriver;

public class loginPageDao  {
	

    public static void adminLogin() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter email:");
        String email = scn.nextLine();
        System.out.println("Enter password:");
        String password = scn.nextLine();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE email=? AND password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Welcome to Admin Portal");
            while (true) {
            	System.out.println("1. Teacher Portal");
     
            	System.out.println("2. Student Portal");
             
                System.out.println("3. Update School Details");
                System.out.println("4. Logout Admin Portal");
                System.out.println("5. Logout Application");
              //System.out.println("6. Register School");

                int choice = scn.nextInt();

                switch (choice) {
                    case 1:
                        TeacherDao.teachercrud();
                        break;
                    case 2:
                        StudentDao.stdcrud();
                        break;
                    case 3:
                    	SchoolDao.updateSchool();
                        break;
                    case 4:
                    	System.out.println("Exiting Admin Portal...");
                        SchoolManagementDriver.main(); loginPageDao.adminLogin();
                        break;
                    case 5:System.out.println("Exiting Application...");
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login credentials");
        }
    }

    public static void teacherLogin() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter email:");
        String email = scn.nextLine();
        System.out.println("Enter password:");
        String password = scn.nextLine();

        Connection con = Helper.getConnectionobj();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM teacher WHERE email=? AND password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Welcome to Teacher Portal");
            while (true) {
            	loginPageDao.Teacherallcrud();
            }
        }
        else {
            System.out.println("Invalid credentials");
            loginPageDao.teacherLogin();
        }
            	
       
    }
    
    public static void Teacherallcrud() throws Exception
    {	Scanner scn = new Scanner(System.in);
    	System.out.println("1. Update Teacher Details");//
        System.out.println("2. Delete Teacher");//
        System.out.println("3. Fetch All Teachers");//
        System.out.println("4. Fetch Specific Teacher");//
        System.out.println("5. Add Students");
        System.out.println("6. Fetch All Students");//
        System.out.println("7. Fetch Specific Student");//
        System.out.println("8. Update Student Details");
        System.out.println("9. Delete Student");
        System.out.println("10. Logout Teacher Portal");
        System.out.println("11. Exit Application");

        int choice = scn.nextInt();

        switch (choice) {
            case 1:
                TeacherDao.update_teacher();
                break;
            case 2:
                TeacherDao.delete_teacher();
                break;
            case 3:
                TeacherDao.fetchallteachers();
                break;
            case 4:
                TeacherDao.fetch_teachers();
                break;
            case 5:
                StudentDao.Add_student();
                break;
            case 6:
                StudentDao.fetchallstudents();
                break;
            case 7:
                StudentDao.fetchstddetails();
                break;
            case 8:
                StudentDao.updateStudentDetails();
                break;
            case 9: StudentDao.delete_student();
            	break;
            case 10:
                System.out.println("Exiting Teacher Portal...");
                SchoolManagementDriver.main(); loginPageDao.teacherLogin();
                break;
            case 11:System.out.println("Exiting Application...");
            System.exit(0);
            break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    
    	} 
	}

