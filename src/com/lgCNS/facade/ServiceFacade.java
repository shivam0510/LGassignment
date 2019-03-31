package com.lgCNS.facade;

import java.util.List;

import com.lgCNS.pojo.LGCNSpojo;

public interface ServiceFacade {

	/**
	 * @param url
	 * @return
	 */
	public List<LGCNSpojo> getFeeds(String url);
	
	/**
	 * @param feedDataList
	 * @return
	 */
	public boolean generateFiles(List<LGCNSpojo> feedDataList);
	
}
