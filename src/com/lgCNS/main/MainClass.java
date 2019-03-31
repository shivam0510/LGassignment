package com.lgCNS.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import com.lgCNS.facade.ServiceFacade;
import com.lgCNS.pojo.LGCNSpojo;
import com.lgCNS.service.LGCNSservice;

/**
 * @author Shivam Agarwal
 *
 */
public class MainClass {
	
	static Logger logger = Logger.getLogger(MainClass.class.getName());

	/**
	 * @param args
	 * @throws IOException
	 * @throws XMLStreamException
	 * @throws FactoryConfigurationError
	 */
	public static void main(String[] args){
		logger.log(Level.INFO,"**************** Start of main *********************");
		ServiceFacade serviceFacade = LGCNSservice.getInstance();
		List<LGCNSpojo> feedDataList = serviceFacade.getFeeds("https://www.cnet.com/rss/news/");
		boolean success = serviceFacade.generateFiles(feedDataList);
		if(success) {
			logger.log(Level.INFO,"**************** text files generated *********************");
		}else {
			logger.log(Level.INFO,"**************** error generating text files *********************");
		}
		logger.log(Level.INFO,"**************** End of main *********************");
	}

}
