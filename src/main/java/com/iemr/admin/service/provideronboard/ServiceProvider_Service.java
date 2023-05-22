package com.iemr.admin.service.provideronboard;

import java.util.List;
import java.util.Set;

import com.iemr.admin.data.provideronboard.M_ProviderServiceMapping;
import com.iemr.admin.data.provideronboard.ServiceProvider_Model;

public interface ServiceProvider_Service {
	/**
	 * Author: Neeraj (298657); Date: 09-07-2017
	 */
	public Integer createProvider(Set<ServiceProvider_Model> serviceProvider_Model);

	public List<M_ProviderServiceMapping> mapProviderStateService(
			Set<M_ProviderServiceMapping> m_ProviderServiceMappingSet);

}
