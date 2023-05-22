package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Feedbacktype;

@Repository
@RestResource(exported = false)
public interface M_FeedbacktypeRepo extends CrudRepository<M_Feedbacktype, Integer> {

	
	
	 @Query("SELECT u FROM M_Feedbacktype u where u.providerServiceMapID=:providerServiceMapID")
	ArrayList<M_Feedbacktype> getAllFeedbackType(@Param("providerServiceMapID")Integer providerServiceMapID);
	
	
	@Query("SELECT u FROM M_Feedbacktype u where u.feedbackTypeID=:feedbackTypeID")
	M_Feedbacktype deleteFeedback(@Param ("feedbackTypeID")Integer feedbackTypeID);

}
