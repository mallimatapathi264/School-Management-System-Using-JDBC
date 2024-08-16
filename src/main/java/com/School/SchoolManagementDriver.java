package com.School;

import java.util.Scanner;
import com.SchoolDAO.AdminPage;
import com.SchoolDAO.CustomerDao;
import com.SchoolDAO.StudentDao;
import com.SchoolDAO.TeacherDao;
import com.SchoolDAO.loginPageDao;

public class SchoolManagementDriver {
	public static void main(String[] args) throws Exception
	{
		SchoolManagementDriver.main();
		
	}
	public static void main() throws Exception {
	Scanner scn= new Scanner(System.in);
	System.out.println("1.Admin Portal");
	System.out.println("2.Teacher Portal");
	System.out.println("3.Student Portal");
	System.out.println("4.Customer");
	int n=scn.nextInt();
	switch(n) {
	case 1: System.out.println("welcome Admin Portal");
			System.out.println("1. Register new Account");
			System.out.println("2. Login Account");
			int n1=scn.nextInt();
			switch(n1)
			{
			case 1: AdminPage.addAdmin();
			break;
			case 2: loginPageDao.adminLogin();
			break;
			default : System.out.println("entered valid Number");
			SchoolManagementDriver.main();
			}
	break;
			
	case 2: System.out.println("welcome to Teacher Portal");
	        System.out.println("1.Register New Teacher");
	        System.out.println("2. Login Account");
	   
	        int n2=scn.nextInt();
			switch(n2)
			{
			case 1: TeacherDao.add_teacher();
			break;
			case 2: loginPageDao.teacherLogin();
			break;
			default : System.out.println("entered valid Number");
			SchoolManagementDriver.main();
			}
	break;
	case 3: System.out.println("welcome to Student Portal");
			System.out.println("1.fetch all students ");
			System.out.println("2.fetch specfic student");
			int n3= scn.nextInt();
			switch(n3)
			{
			case 1: StudentDao.fetchallstudents();
			break;
			case 2: StudentDao.fetchstddetails();
			break;
			default : System.out.println("entered valid Number");
			SchoolManagementDriver.main();
			}
	break;
	case 4: System.out.println("Welcome to School Management System");
			System.out.println("1.Register New Customer");
		    System.out.println("2.Login Account");
		    int n4=scn.nextInt();
			switch(n4)
			{
			case 1: CustomerDao.addcustomer();
			break;
			case 2: CustomerDao.customerlogin();
			break;
			default : System.out.println("entered valid Number");
			SchoolManagementDriver.main();
			}
	default:System.out.println("entered valid Number");
	SchoolManagementDriver.main();
	}
  }
}