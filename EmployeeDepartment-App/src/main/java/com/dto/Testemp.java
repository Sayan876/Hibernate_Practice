package com.dto;
import javax.persistence.*;
public class Testemp {
  public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	System.out.println(factory);
}
}
