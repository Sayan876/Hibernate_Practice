package Fetchingdata;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entitys.PanCard;

public class FetchPanCardNumberandDob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    System.out.println("Enter the pan number");
	    String pnum = sc.next();
	    System.out.println("Enter the date of birth");
	    System.out.print("Enter year: ");
	    int year = sc.nextInt();
	    System.out.print("Enter month: ");
	    int month = sc.nextInt();
	    System.out.print("Enter day: ");
	    int day = sc.nextInt();
	    LocalDate dob = LocalDate.of(year, month, day);
		
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select p from PanCard p where p.number=?1 and p.dob=?2");
		query.setParameter(1, pnum);
		query.setParameter(2, dob);
		try {
			PanCard p =(PanCard) query.getSingleResult();
			System.out.println(p);
		}catch(NoResultException e) {
			System.err.println("No data");
		}
				
	}

}
