package com.org.control;
import com.datainst.Dao.*;
import com.merch.dto.*;
import java.util.*;
public class RunMerchant {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   MerchantDao dao = new MerchantDao();
	   System.out.println("1. Insert Merchant details ");
	   System.out.println("2. Update Merchant details");
	   System.out.println("3. Fetch Merchant details by id");
	   System.out.println("4. Verify Merchant by phone and Password");
	   System.out.println("5. Verify Merchant by email and Password");
	   System.out.println("6. Delete merchant by id");
	   
	   
	   switch(sc.nextInt()) {
	   case 1:{
		   
	   Merchant m = new Merchant();
	   System.out.println("Enter the name");
	   String mname = sc.next();
	   m.setName(mname);
	   
	   System.out.println("Enter a unique email");
	   m.setEmail(sc.next());
	   System.out.println("Set your password");
	   m.setPassword(sc.next());
	   System.out.println("Enter a unique phone number");
	   m.setPhone(sc.nextLong());
	   
	   m = dao.saveMerchant(m);
	   } break;
	   
	   case 2:{
		   System.out.println("Enter the details");
		   Merchant m = new Merchant();
		   System.out.println("Enter the id");
		   m.setId(sc.nextInt());
		   System.out.println("Enter the name");
		   m.setName(sc.next());
		   
		   System.out.println("Enter a unique email");
		   m.setEmail(sc.next());
		   System.out.println("Set your password");
		   m.setPassword(sc.next());
		   System.out.println("Enter a unique phone number");
		   m.setPhone(sc.nextLong());
		   m = dao.updateMerchant(m);
		   if(m!=null) {
			   System.out.println("Successfully Updated");
		   }else {
			   System.err.println("sorry");
		   }
	   }break;
	   
	   
	   
	   
	   case 3:{
		   System.out.println("Enter the Merchant id");
		   Merchant m = dao.verifybyId(sc.nextInt());
		   if(m!= null) {
			   System.out.println(m);
			   break;
		   }else {
			   System.out.println("Invalid id");
		   }
	   }
	   
	   
	   
	   case 4:{
		   System.out.println("Enter the phone and Password");
		   long phone = sc.nextLong();
		   String pass = sc.next();
		   Merchant merchant = dao.verifybyPhoneAndPassword(phone, pass);
		   
		   if(merchant!=null) {
			   System.out.println(merchant);
			   break;
		   }else {
			   System.out.println("Verification failed");
		   }
	   }
	   
	   
	   case 5:{
		   System.out.println("Enter the email and Password");
		   String email = sc.next();
		   String pass = sc.next();
		   Merchant merchant = dao.verifyByEmailAndPassword(email, pass);
		   
		   if(merchant!=null) {
			   System.out.println(merchant);
			   break;
		   }else {
			   System.out.println("Verification failed");
		   }
	   } 
	   
	   
	   case 6:{
		   System.out.println("Enter the id to delete the Merchant");
		   Merchant merch = dao.deleteMerchant(sc.nextInt());
		   if(merch!=null) {
			   System.out.println("Merchant found and deleted");
		   }else {
			   System.out.println("Error 404");
		   }
	   }break;
	   default: System.out.println("invalid option"); 
	   }
	   
	   
	
}
}
