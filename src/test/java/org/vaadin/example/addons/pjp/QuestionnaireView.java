package org.vaadin.example.addons.pjp;

import java.util.UUID;

import org.vaadin.addons.pjp.questionnaire.component.QuestionnaireComponent;

import com.vaadin.flow.component.html.Emphasis;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;

@Route("")
public class QuestionnaireView extends VerticalLayout implements AfterNavigationObserver {

    private static final long serialVersionUID = 3146242978667883554L;

    private final QuestionnaireComponent questionnaire = new QuestionnaireComponent();

    private final QuestionnaireService service;

    public QuestionnaireView(QuestionnaireService service) {
        super();
        this.service = service;

        setSpacing(false);

        Paragraph intro = new Paragraph("Please take a few minutes to complete our survey. We aim to utilise the results from the survey to improve.");

        Emphasis anon = new Emphasis("All results are anonymous.");

        questionnaire.addSubmitButtonClickListener(l -> {
            String uuid = UUID.randomUUID().toString();
            service.saveUserAnswerSet(questionnaire.getUserAnswerSet(uuid));
        });

        add(intro, anon, questionnaire);

        setSizeFull();
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        questionnaire.setQuestionSet(service.getQuestionSet());
    }

}
