package com.iemr.admin.service.questionnaire;

import org.springframework.stereotype.Service;

@Service
public interface QuestionnaireService {

	String SaveQuestionnaire(String request) throws Exception;

	String getQuestionnaireList(String request);

	String deleteQuestionnaire(String request);

	String editQuestionnaire(String request);

}
