package com.manyuni;
import java.util.Arrays;

import javax.persistence.*;
public class SaveQuestionsAndAnswers {
   public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	QuestionData qst = new QuestionData();
	qst.setQuestion("What are the Specification of Anime?");
	qst.setQuestionBy("George");
	
	AnswerData ans1 = new AnswerData();
	ans1.setAnswer("Anime has a good storyline");
	ans1.setAnsweredBy("Rayan");;
	
	AnswerData ans2 = new AnswerData();
	ans2.setAnswer("Studios make nice animations to represent the storyline");
	ans2.setAnsweredBy("Lucy");
	
	AnswerData ans3 = new AnswerData();
	ans3.setAnswer("It's basically written in Japanese");
	ans3.setAnsweredBy("Symonds");
	
	qst.setAnswers(Arrays.asList(ans1,ans2,ans3));
	manager.persist(qst);
	
	transaction.begin();
	transaction.commit();
	
	
}
}
