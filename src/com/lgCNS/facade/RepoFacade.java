package com.lgCNS.facade;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import com.lgCNS.pojo.LGCNSpojo;
import com.lgCNS.repo.LGCNSrepository;

public interface RepoFacade {
	
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws XMLStreamException
	 * @throws FactoryConfigurationError
	 */
	public List<LGCNSpojo> getFeeds(String url) throws IOException, XMLStreamException, FactoryConfigurationError  ;
	
	//public LGCNSrepository getInstance();

}
