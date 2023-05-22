package com.iemr.admin.data.questionnaire;

import java.util.ArrayList;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Entity
@Table(name="m_questionnaire")
@Data
public class Questionnaire {
	public Questionnaire() {

	}
	public Questionnaire(Integer questionID, String questionType, String question, Integer questionRank, Integer questionWeightage, String answerType) {
		this.questionID = questionID;
		this.questionType = questionType;
		this.question = question;
		this.questionRank = questionRank;
		this.questionWeightage = questionWeightage;
		this.answerType = answerType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="QuestionID")
	private Integer questionID;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID", insertable = false, updatable = false)
    @Expose
    private Set<QuestionnaireValues> qvalues;

	@Expose
	@Transient
	Questionnaire questionnaireDetail;
	
	@Expose
	@Transient
	ArrayList<QuestionnaireValues> questionOptions;

	@Expose
	@Column(name="QuestionType")
	private String questionType;

	@Expose
	@Column(name="Question")
	private String question;
	@Expose
	@Column(name="QuestionWeightage")
	private Integer questionWeightage;
	@Expose
	@Column(name="AnswerType")
	private String answerType;
	@Expose
	@Column(name="QuestionRank")
	private Integer questionRank;
	@Expose
	@Column(name="QuestionTypeID")
	private Integer questionTypeID;
	
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