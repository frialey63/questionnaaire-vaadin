package org.vaadin.addons.pjp.questionnaire.component;

import org.vaadin.addons.pjp.questionnaire.model.QuestionSet;
import org.vaadin.addons.pjp.questionnaire.model.UserAnswerSet;

/**
 * @author Paul Parlett
 *
 */
public interface Questionnaire {

    void setQuestionSet(QuestionSet questionSet);

    boolean isValid();

    UserAnswerSet getUserAnswerSet(String uuid);
}