package com.lgCNS.repo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import com.lgCNS.facade.RepoFacade;
import com.lgCNS.pojo.LGCNSpojo;
import com.lgCNS.service.LGCNSservice;

/**
 * @author Shivam Agarwal
 *
 */
public class LGCNSrepository implements RepoFacade {
	
	Logger logger = Logger.getLogger(LGCNSservice.class.getName());

	public static LGCNSrepository getInstance() {
		return new LGCNSrepository();
	}
	

	/* (non-Javadoc)
	 * @see com.lgCNS.facade.RepoFacade#getFeeds(java.lang.String)
	 */
	public List<LGCNSpojo> getFeeds(String url) throws IOException, XMLStreamException, FactoryConfigurationError {
		logger.log(Level.INFO,"**************** Start of Repo getFeeds *********************");
		LGCNSpojo feed = null;
		List<LGCNSpojo> feedDataList = new ArrayList<LGCNSpojo>();
		boolean isFeedHeader = true;
		String description ="";
		String title ="";
		String link = "";
		String pubDate = "";
		String guid = "";
		String creator = "";
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		URL feedURL = new URL(url);
		InputStream in = feedURL.openStream();
		XMLEventReader eventReader = factory.createXMLEventReader(in);
		
		while(eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			if(event.isStartElement()) {
				String tag = event.asStartElement().getName().getLocalPart();
				switch(tag) {
					case "item":
						if(isFeedHeader) {
							isFeedHeader = false;
							feed = new LGCNSpojo();
						}
						break;
					case "title":
						title = getCharacterData(event, eventReader);
						break;
					case "link":
						link = getCharacterData(event, eventReader);
						break;
					case "guid":
						guid = getCharacterData(event, eventReader);
						break;
					case "pubDate":
						pubDate = getCharacterData(event, eventReader);
						break;
					case "creator":
						creator = getCharacterData(event, eventReader);
						break;
					case "description":
						description = getCharacterData(event, eventReader);
						break;
				}
			}else if(event.isEndElement()) {
				if (event.asEndElement().getName().getLocalPart() == ("item")) {
					LGCNSpojo item = new LGCNSpojo();
					item.setCreator(creator);
					item.setDescription(description);
					item.setGuid(guid);
					item.setLink(link);
					item.setPubDate(pubDate);
					item.setTitle(title);
					feedDataList.add(item);
					event = eventReader.nextEvent();
					continue;
				}
			}
		}
		logger.log(Level.INFO,"**************** End of Repo getFeeds *********************");
		return feedDataList;
	}
	
    /**
     * @param event
     * @param eventReader
     * @return
     * @throws XMLStreamException
     */
    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

}
