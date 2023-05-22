package com.iemr.admin.repository.provideronboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.provideronboard.M_Feedbacknature;

@Repository
@RestResource(exported = false)
public interface M_FeedbacknatureRepo extends CrudRepository<M_Feedbacknature, Integer>{

	
	
	@Query("SELECT u FROM M_Feedbacknature u where u.feedbackTypeID=:feedbackTypeID")
	ArrayList<M_Feedbacknature> getInstuteType(@Param("feedbackTypeID") Integer feedbackTypeID);
    
	
	@Query("SELECT u FROM M_Feedbacknature u where u.feedbackNatureID=:feedbackNatureID")
	  M_Feedbacknature editFeedbackNatureType(@Param("feedbackNatureID") Integer feedbackNatureID);
	

}
