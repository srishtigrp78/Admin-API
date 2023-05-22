package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Feedbacktype;

public interface M_FeedbacktypeInter {

	ArrayList<M_Feedbacktype> getFeedbackt(Integer providerServiceMapID);

	ArrayList<M_Feedbacktype> saveFeedbackType(List<M_Feedbacktype> feedbackTypedata);

	M_Feedbacktype getDataByServId(Integer feedbackTypeID);

	M_Feedbacktype deletedataser(M_Feedbacktype getDAta);



}
