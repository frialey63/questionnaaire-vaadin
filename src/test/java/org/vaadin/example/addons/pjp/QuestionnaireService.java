package org.vaadin.example.addons.pjp;

import java.util.UUID;

import org.vaadin.addons.pjp.questionnaire.model.Question;
import org.vaadin.addons.pjp.questionnaire.model.Question.QuestionType;
import org.vaadin.addons.pjp.questionnaire.model.QuestionSet;
import org.vaadin.addons.pjp.questionnaire.model.UserAnswerSet;

public class QuestionnaireService {

    private static final String THE_UUID = UUID.randomUUID().toString();

    public QuestionSet getQuestionSet() {
        QuestionSet questionSet = new QuestionSet();
        questionSet.setText("Testing Addon");
        questionSet.setDescription("This is questionnaire testing.");
        questionSet.setUuid(THE_UUID);
        questionSet.setSubmitButtonText("Send");

        Question q1 = new Question(1, "Enter your name");
        q1.setAnswerMaxLength(100);
        q1.setRequired(true);
        q1.setRequiredError("Name is required");
        questionSet.add(q1);

        Question q2 = new Question(2, "Description", QuestionType.TEXTAREA);
        q2.setAnswerMaxLength(4000);
        q2.setRequired(true);
        q2.setRequiredError("Description is required");
        questionSet.add(q2);

        Question q3 = new Question(3, "Interestings", QuestionType.CHECKBOX);
        q3.setRequired(true);
        q3.setRequiredError("Interestings are required");
        q3.addAnswer("Sports");
        q3.addAnswer("Music");
        q3.addAnswer("Movies");
        q3.addAnswer("Books");
        questionSet.add(q3);

        Question q4 = new Question(4, "Gender", QuestionType.RADIOBUTTON);
        q4.addAnswer("Male");
        q4.addAnswer("Female");
        q4.setRequiredError("Gender is required");
        questionSet.add(q4);

        Question q5 = new Question(5, "Country", QuestionType.RADIOBUTTON);
        q5.addAnswer("Finland");
        q5.addAnswer("Other");
        q5.setRequiredError("Country is required");
        questionSet.add(q5);

        return questionSet;
    }

    public String saveUserAnswerSet(UserAnswerSet userAnswerSet) {
        return userAnswerSet.uuid();
    }
}
