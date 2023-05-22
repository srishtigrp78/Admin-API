package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Feedbacknature;
import com.iemr.admin.repository.provideronboard.M_FeedbacknatureRepo;

@Service
public class M_FeedbacknatureImpl implements M_FeedbacknatureInteger{
	
	
	@Autowired
	private M_FeedbacknatureRepo m_FeedbacknatureRepo;

	@Override
	public ArrayList<M_Feedbacknature> getFeedbackNatureType(Integer feedbackTypeID) {
		ArrayList<M_Feedbacknature>  data=m_FeedbacknatureRepo.getInstuteType(feedbackTypeID);
		return data;
	}

	@Override
	public ArrayList<M_Feedbacknature> createFeedbackNatueType(List<M_Feedbacknature> instuteType) {
		
		ArrayList<M_Feedbacknature> data=(ArrayList<M_Feedbacknature>) m_FeedbacknatureRepo.save(instuteType);
		return data;
	}

	@Override
	public M_Feedbacknature editFeedbackNatureType(Integer feedbackNatureID) {
		M_Feedbacknature data=m_FeedbacknatureRepo.editFeedbackNatureType(feedbackNatureID);
		return data;
	}

	@Override
	public M_Feedbacknature saveEditedData(M_Feedbacknature geteditFeedbackNatureData) {
		M_Feedbacknature data=m_FeedbacknatureRepo.save(geteditFeedbackNatureData);
		return data;
	}
	
	

}
