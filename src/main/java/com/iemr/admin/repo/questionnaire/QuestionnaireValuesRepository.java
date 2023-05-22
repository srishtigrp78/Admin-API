package com.iemr.admin.repo.questionnaire;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.iemr.admin.data.questionnaire.QuestionnaireValues;

@Repository
@RestResource(exported = false)
public interface QuestionnaireValuesRepository extends CrudRepository<QuestionnaireValues, Integer> {

}
