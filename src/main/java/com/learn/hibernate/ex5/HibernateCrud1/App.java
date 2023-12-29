package com.learn.hibernate.ex5.HibernateCrud1;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
	public static void main( String[] args )
	{
		//Creating the object of Configuration
		Configuration cfg = new Configuration();
		cfg.configure();

		//building the session
		SessionFactory factory = cfg.buildSessionFactory();
		//opening the session
		Session session = factory.openSession();
		//Begin the transaction
		Transaction trans = session.beginTransaction();

		Scanner sc = new Scanner(System.in);

		boolean b = true;
		//creating a infinite loop for continuously running the program
		while(b)
		{
			System.out.println("Enter 1 for insertion, 2 for update, 3 for delete, 4 for retrive and any other for terminate");
			int a = sc.nextInt();
			
			//Creating the switch condition for calling the methods
			switch(a)
			{
			case 1:
				create(session, sc);
				break;
			case 2:
				update(session, sc);
				break;
			case 3:
				delete(session, sc);
				break;
			case 4:
				retrive(session, sc);
				break;
			default:
				b=false;
				trans.commit();
				break;


			}
		}
		sc.close();
	}
	public static void create(Session s, Scanner sc) 
	{
		System.out.println("Enter number of rows");
		int rows = sc.nextInt();
		Student1 arr[] = new Student1[rows];

		for(int i =0;i<rows;i++)
		{
			System.out.println("Enter roll no");
			int rollNo = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter age");
			int age = sc.nextInt();
			System.out.println("Enter marks");
			int marks = sc.nextInt();

			arr[i] = new Student1(rollNo, name, age, marks);
			s.save(arr[i]);
			System.out.println("Data saved");
		}

	}
	public static void update(Session s, Scanner sc) 
	{
		try {
			System.out.println("Enter roll no where you want to update:");
			int rollNo = sc.nextInt();
			Student1 st = s.get(Student1.class, rollNo);

			System.out.println("What you want to update");
			String str = sc.next();

			if(str.equals("name"))
			{
				System.out.println("Enter name to update");
				String name = sc.next();
				st.setName(name);
			}
			else if(str.equals("age"))
			{
				System.out.println("Enter age to update");
				int age = sc.nextInt();
				st.setAge(age);
			}
			else if(str.equals("Enter marks to update"))
			{
				System.out.println("Enter marks");
				int marks = sc.nextInt();
				st.setMarks(marks);
			}
			else
			{
				System.out.println("Wrong choice:");
			}
			s.save(st);
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered wrong input");
		}

	}
	public static void delete(Session s, Scanner sc) 
	{
		try {
			System.out.println("Enter the roll no for which you want to delete the data");
			int rollNo = sc.nextInt();

			Student1 st = s.get(Student1.class, rollNo);
			s.remove(st);
			System.out.println("Data is deleted");
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered wrong input");
		}

	}
	public static void retrive(Session s,Scanner sc) 
	{
		try {
			System.out.println("Enter the roll no for which you want to see data");
			int rollNo = sc.nextInt();

			Student1 s1 = s.get(Student1.class, rollNo);
			System.out.println(s1);
			System.out.println();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong input");
		}

	}
}
