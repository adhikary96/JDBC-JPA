package com.cg.jdbc.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.jdbc.dao.JdbcAppDAO;
import com.cg.jdbc.dto.Employee;
import com.cg.jdbc.exception.JDBCException;
import com.cg.jdbc.service.IJdbcService;
import com.cg.jdbc.service.JdbcService;

import oracle.net.aso.l;

public class Client {

	Scanner sc = new Scanner(System.in);
	IJdbcService service = new JdbcService();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client();
		String option = "";
		while (true) {
			System.out.println("1. add employee\n2. display all employee\n3. Exit");

			System.out.println("Enter option:");
			option = c.sc.nextLine();
			switch (option) {
			case "1":
				c.addEmployee();
				break;
			case "2":
				c.display();
				break;
			case "3":
				c.sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter correct option:");
				break;
			}
		}

	}
	
	private void addEmployee(){
		Employee e = new Employee();
		/*System.out.println("Enter employee code:");
		e.setId(Integer.parseInt(sc.nextLine()));*/
		
		System.out.println("Enter EMployee name:");
		e.setName(sc.nextLine());
		
		System.out.println("Enter Employee Gender:");
		e.setGender(sc.nextLine());
		
		System.out.println("Enter Employee age:");
		e.setAge(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter employee salary:");
		e.setSalary(Double.parseDouble(sc.nextLine()));
		
		try {
			int res = service.addEMployee(e);
			System.out.println("Employee added successfully with ID:"+res);
		} catch (JDBCException e1) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e1.getMessage());
			System.out.println();
		}
	}
	
	private void display(){
		try {
			List<Employee> emp = service.getAllEmployee();
			emp.forEach(System.out::println);
		} catch (JDBCException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
		}
		
	}
	

}
