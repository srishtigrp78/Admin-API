package com.iemr.admin.service.provideronboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.admin.data.provideronboard.M_Feedbacktype;
import com.iemr.admin.repository.provideronboard.M_FeedbacktypeRepo;
@Service
class M_FeedbacktypeImpl implements M_FeedbacktypeInter {
	
	@Autowired
	private M_FeedbacktypeRepo m_FeedbacktypeRepo;

	@Override
	public ArrayList<M_Feedbacktype> getFeedbackt(Integer providerServiceMapID) {
		 ArrayList<M_Feedbacktype> data=m_FeedbacktypeRepo.getAllFeedbackType(providerServiceMapID);
		return data;
	}

	@Override
	public ArrayList<M_Feedbacktype> saveFeedbackType(List<M_Feedbacktype> feedbackTypedata) {
		ArrayList<M_Feedbacktype> data=(ArrayList<M_Feedbacktype>) m_FeedbacktypeRepo.save(feedbackTypedata);
		return data;
	}

	@Override
	public M_Feedbacktype getDataByServId(Integer feedbackTypeID) {
		M_Feedbacktype deletefeedback=m_FeedbacktypeRepo.deleteFeedback(feedbackTypeID);
		return deletefeedback;
	}

	@Override
	public M_Feedbacktype deletedataser(M_Feedbacktype getDAta) {
		M_Feedbacktype deletefeedbackdata=m_FeedbacktypeRepo.save(getDAta);
		return deletefeedbackdata;
	}

}
