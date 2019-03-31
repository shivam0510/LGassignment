package com.lgCNS.pojo;

/**
 * @author Shivam Agarwal
 *
 */
public class LGCNSpojo {

	private String title;
	private String link;
	private String guid;
	private String pubDate;
	private String description;
	private String thumbnailURL;
	private String creator;
	
	
	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return
	 */
	public String getGuid() {
		return guid;
	}
	/**
	 * @param guid
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	/**
	 * @return
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * @param pubDate
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return
	 */
	public String getThumbnailURL() {
		return thumbnailURL;
	}
	/**
	 * @param thumbnailURL
	 */
	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}
	/**
	 * @return
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
	@Override
	public String toString() {
		return "LGCNSpojo [title=" + title + ", link=" + link + ", guid=" + guid + ", pubDate=" + pubDate
				+ ", description=" + description + ", thumbnailURL=" + thumbnailURL + ", creator=" + creator + "]";
	}
	
	
}
