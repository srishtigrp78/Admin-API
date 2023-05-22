package com.iemr.admin.data.questionnaire;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Entity
@Table(name="m_questionnairevalues")
@Data
public class QuestionnaireValues {
	public QuestionnaireValues() {
		
	}
	public QuestionnaireValues(Integer questionValuesID, String option, Integer optionWeightage){
		this.questionValuesID = questionValuesID;
		this.option = option;
		this.optionWeightage = optionWeightage;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="QuestionValuesID")
	private Integer questionValuesID;
	
	@Expose
	@Column(name="QuestionID")
	private Integer questionID;
	
	@Expose
	@Column(name="QuestionValues")
	private String option;
	@Expose
	@Column(name="QuestionValuesWeightage")
	private Integer optionWeightage;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;

	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Column(name="Deleted")
	private Boolean deleted;
}