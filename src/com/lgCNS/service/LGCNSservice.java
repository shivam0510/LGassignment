package com.lgCNS.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;

import com.lgCNS.facade.RepoFacade;
import com.lgCNS.facade.ServiceFacade;
import com.lgCNS.main.MainClass;
import com.lgCNS.pojo.LGCNSpojo;
import com.lgCNS.repo.LGCNSrepository;

/**
 * @author Shivam Agarwal
 *
 */
public class LGCNSservice implements ServiceFacade {
	
	final RepoFacade repoFacade = LGCNSrepository.getInstance();
	Logger logger = Logger.getLogger(LGCNSservice.class.getName());
	
	/**
	 * @return
	 */
	public static LGCNSservice getInstance() {
		return new LGCNSservice();
	}

	/* (non-Javadoc)
	 * @see com.lgCNS.facade.ServiceFacade#getFeeds(java.lang.String)
	 */
	@Override
	public List<LGCNSpojo> getFeeds(String url) {
		logger.log(Level.INFO,"**************** Start of Service getFeeds *********************");
		List<LGCNSpojo> feedDataList = null;
		try {
			feedDataList = repoFacade.getFeeds(url);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}catch (XMLStreamException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}catch (FactoryConfigurationError e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		logger.log(Level.INFO,"**************** End of Service getFeeds *********************");
		return feedDataList;
	}

	/* (non-Javadoc)
	 * @see com.lgCNS.facade.ServiceFacade#generateFiles(java.util.List)
	 */
	@Override
	public boolean generateFiles(List<LGCNSpojo> feedDataList) {
		logger.log(Level.INFO,"**************** Start of Service generateFiles *********************");
		PrintWriter writer = null;
		for (LGCNSpojo item : feedDataList) {
			try {
				writer = new PrintWriter(item.getGuid()+".txt");
				writer.println(item.getTitle());
				writer.println(item.getLink());
				writer.println(item.getDescription());
				writer.println(item.getCreator());
				writer.println(item.getPubDate());
			} catch (FileNotFoundException e) {
				logger.log(Level.SEVERE, e.getMessage());
				return false;
			}finally {
				writer.close();
			}	
		}
		logger.log(Level.INFO,"**************** End of Service generateFiles *********************");
		return true;
	}

}
