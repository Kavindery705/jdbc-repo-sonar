package com.jdbcproj;

import java.util.List;
import java.util.Scanner;

public class GetRecordCaller {

	public static void main(String[] args) {
		McaDao mca = new McaDao();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Exit!");
//			System.out.println("2. get Selected record");
//			System.out.println("3. get All record");
//			System.out.println("4. get record by pages");
//			System.out.println("5. insert record ");
//			System.out.println("6. delete record by id");
//			System.out.println("7. update record ");

			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				System.out.println("Good Bye :)");
				break;
			case 2:
				System.out.println("Enter rollno. to get selected record ");
				int roll = sc.nextInt();
				Mca m = mca.getRecord(roll);
				if(m!=null) {
					System.out.println(m.toString());					
				}
				break;
			case 3:
				List<Mca> m1 = mca.getAllRecords();
				System.out.println(m1.toString());
				break;
			case 4:
				System.out.print("Enter page number :");
				int page = sc.nextInt();
				System.out.println();
				if (page <= 3 && page > 0) {
					if (page != 1) {
						page = (page - 1) * 2;
					} else {
						page--;
					}
					System.out.println(mca.getRecordsByPage(page, 2));
				} else {
					System.out.println("page not found");
				}
				break;
			case 5:
				Mca m11 = new Mca();
				sc.nextLine();
				System.out.println("Enter id:");
				m11.setRollno(sc.nextInt());
				
				sc.nextLine();
				System.out.println("Enter name :");
				m11.setName(sc.nextLine());
				
				System.out.println("Enter city :");
				m11.setCity(sc.nextLine());
				
				System.out.println("Enter subject");
				m11.setSubject(sc.nextLine());
				
				System.out.println("Enter phone :");
				m11.setPhone(sc.nextLong());
				
				
				int status =mca.insertRecord(m11);
				if(status==1)
				{
					System.out.println("Record is inserted");
				}
				else
				{
					System.out.println("unable to insert record");
				}
				break;
			case 6:
				System.out.print("Enter rollno. to delete his/her record : ");
				int roll1 = sc.nextInt();
				System.out.println();
				int status1 = mca.deleteRecord(roll1);
				if(status1==1)
				{
					System.out.println("Record is deleted");
				}
				else
				{
					System.out.println("unable to delete record");
				}
				break;
			case 7:	
				System.out.println("Enter rollno :");
				int id = sc.nextInt();
				Mca m111 =  mca.getRecord(id);
				System.out.println("Student roll no. :"+m111.getRollno());
				System.out.println("Student name :"+m111.getName());
				System.out.println("Student subject :"+m111.getSubject());
				System.out.println("Student phone :"+m111.getPhone());
				System.out.println("Student city :"+m111.getCity());
				
				System.out.println("Update following ");
				System.out.println("Student id:");
				System.out.println("1. Student name");
				System.out.println("2. Student subject");
				System.out.println("3. Student phone");
				System.out.println("4. Student city");
				
				System.out.println("Enter choice to update record :");
				int ch = sc.nextInt();
				sc.nextLine();
				if(ch==1)
				{
					sc.nextLine();
					System.out.println("Enter name :");
					m111.setName(sc.nextLine());
				}
				else if(ch==2)
				{
					System.out.println("Enter Subject :");
					m111.setSubject(sc.nextLine());
				}
				else if(ch==3)
				{
					System.out.println("Enter phone ");
					m111.setPhone(sc.nextLong());
				}
				else if(ch==4)
				{
					sc.nextLine();
					System.out.println("Enter city :");
					m111.setCity(sc.nextLine());
				}
				else
				{
					System.out.println("Wrong choice ");
				}
				int status11 = mca.updateRecord(m111);
				if(status11==1)
				{
					System.out.println("Update succesfully");
				}
				else
				{
					System.out.println("not updated");
				}
			
			break;
		default :
				System.out.println("Wrong choice !!");
				break;
			}
		} while (choice != 1);
		mca.closeObject();
		sc.close();
	}
}
