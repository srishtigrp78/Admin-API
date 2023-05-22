package com.iemr.admin.sevice.labmodule;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iemr.admin.data.labmodule.ProcedureComponentMapping;
import com.iemr.admin.repo.labmodule.ProcedureComponentMappingRepo;
import com.iemr.admin.utils.mapper.InputMapper;

/***
 * 
 * @author Rajeev Tripathi
 *
 */
@Service
public class MastersMappingServiceImpl implements MastersMappingService {
	private ProcedureComponentMappingRepo procedureComponentMappingRepo;

	@Autowired
	public void setProcedureComponentMappingRepo(ProcedureComponentMappingRepo procedureComponentMappingRepo) {
		this.procedureComponentMappingRepo = procedureComponentMappingRepo;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String createProcedureComponentMapping(String requestOBJ) throws Exception {
		ProcedureComponentMapping pcmOBJ = InputMapper.gson().fromJson(requestOBJ, ProcedureComponentMapping.class);
		ArrayList<Map<String, Object>> compList = pcmOBJ.getCompList();
		if (compList != null && compList.size() > 0 && pcmOBJ != null) {
			ArrayList<ProcedureComponentMapping> pcmList = ProcedureComponentMapping
					.getProcedureComponentMappingObjList(compList, pcmOBJ.getProcedureID(),
							pcmOBJ.getProviderServiceMapID(), pcmOBJ.getCreatedBy());
			Integer x = procedureComponentMappingRepo.softDeleteProcCompMapping(pcmOBJ.getProcedureID(),
					pcmOBJ.getCreatedBy());
			ArrayList<ProcedureComponentMapping> pcmListRS = (ArrayList<ProcedureComponentMapping>) procedureComponentMappingRepo
					.save(pcmList);
			if (pcmList.size() == pcmListRS.size()) {
				ArrayList<Object[]> tempListRS = procedureComponentMappingRepo
						.getProcedureComponentMappingListForProcedureID(pcmOBJ.getProcedureID());
				ArrayList<Map<String, Object>> responseList = ProcedureComponentMapping
						.getProcedureComponentMappingObjListDetails(tempListRS);
				return new Gson().toJson(responseList);
			} else {
				return null;
			}
		} else {
			return "1";
		}
	}

}
