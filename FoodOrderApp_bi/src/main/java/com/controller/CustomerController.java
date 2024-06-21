package com.controller;
import javax.persistence.*;
import java.util.*;
import com.dao.*;
import com.dto.*;
public class CustomerController {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	
	CustomerDao cdao = new CustomerDao();
	System.out.println("Enter an option below");
	System.out.println("1.Save details of the Customer"
			+ "\n2.Update Customer details"
			+ "\n3.Find Customer by id"
			+ "\n4.Verify Customer by Phone and Password"
			+ "\n5.Verify Customer by email and Password");
	int op = sc.nextInt();
	
	switch(op) {
	case 1:{
		System.out.println("Enter the details of the Customer");
		Customer cst = new Customer();
		cst.setName(sc.next());
		cst.setEmail(sc.next());
		cst.setAge(sc.nextInt());
		cst.setGender(sc.next());
		cst.setPhone(sc.nextLong());
		cst.setPassword(sc.next());
		
		cst=cdao.saveCustomer(cst); 
		
		if(cst!=null) {
			System.out.println("Data inserted successfully");
		}else {
			System.err.println("Oops");
		}
	}break;
	
	case 2:{
		System.out.println("Enter the details of customer");
		Customer cust = new Customer();
		System.out.println("Enter the id");
		cust.setId(sc.nextInt());
		System.out.println("Enter the name");
		cust.setName(sc.next());
		System.out.println("Enter the Age");
		cust.setAge(sc.nextInt());
		System.out.println("Enter Gender");
		cust.setGender(sc.next());
		System.out.println("Enter the new email");
		cust.setEmail(sc.next());
		System.out.println("Enter the phone number");
		cust.setPhone(sc.nextLong());
		System.out.println("Set a new password");
		cust.setPassword(sc.next());
		cust = cdao.updateCustomer(cust);
		
		if(cust!=null) {
			System.out.println("User details have been updated");
		}else {
			System.out.println("Error");
		}
		
	}break;
	
	case 3:{
		System.out.println("Give the id number of the customer");
		int id = sc.nextInt();
		
		Customer cer = cdao.findbyid(id);
		
		if(cer!=null) {
			System.out.println(cer);
		}else {
			System.err.println("Oops! Double check the id");
		}
	}break;
	
	case 4:{
		System.out.println("Give phone number");
		long phn = sc.nextLong();
		System.out.println("Give the Password");
		String passw = sc.next();
		
		Customer mer = cdao.verifybyPhoneAndPassword(phn, passw);
		
		if(mer!=null) {
			System.out.println(mer);
		}else {
			System.out.println("Sorry");
		}
	}break;
	
	case 5: {
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		Customer mer = cdao.VerifybyEmailAndPassword(email, pass);
		if(mer!=null) {
			System.out.println(mer);
		}else {
			System.out.println("sorry");
		}
	}
	break;
	default: {System.out.println("Invalid option");}
	}
	
}
}
