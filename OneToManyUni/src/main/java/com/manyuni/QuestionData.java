package com.manyuni;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column(nullable=false)
	private String question,questionBy;
	@OneToMany(cascade = CascadeType.ALL)
	private List<AnswerData> answers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionBy() {
		return questionBy;
	}
	public void setQuestionBy(String questionBy) {
		this.questionBy = questionBy;
	}
	public List<AnswerData> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerData> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "QuestionData [id=" + id + ", question=" + question + ", questionBy=" + questionBy + "]";
	}

}
