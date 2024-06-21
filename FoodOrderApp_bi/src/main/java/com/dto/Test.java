package com.dto;
import javax.persistence.*;
public class Test {
  public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	System.out.println(factory);
}
}
