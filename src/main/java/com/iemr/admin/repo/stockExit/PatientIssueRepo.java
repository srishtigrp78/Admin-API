package com.iemr.admin.repo.stockExit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.admin.data.stockExit.T_PatientIssue;

@Repository
@RestResource(exported = false)
public interface PatientIssueRepo  extends CrudRepository<T_PatientIssue, Integer>{

}
