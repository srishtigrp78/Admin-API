package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import com.iemr.admin.data.provideronboard.M_Feedbacknature;

public interface M_FeedbacknatureInteger {

	ArrayList<M_Feedbacknature> getFeedbackNatureType(Integer feedbackTypeID);

	ArrayList<M_Feedbacknature> createFeedbackNatueType(List<M_Feedbacknature> instuteType);

	M_Feedbacknature editFeedbackNatureType(Integer feedbackNatureID);

	M_Feedbacknature saveEditedData(M_Feedbacknature geteditFeedbackNatureData);

}
