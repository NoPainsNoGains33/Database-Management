package edu.northeastern.cs5200.models;

public class Widget {
	private int id;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private String url;
	private Boolean shareble;
	private Boolean expandable;
	private String src;
	private int size;
	private String html;
	private Page page;
	private int page_id;
	
	
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public enum type {
			YOUTUBE, IMAGE, WIDGET, HEADING, HTML;
	}
	private type dtype;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getShareble() {
		return shareble;
	}
	public void setShareble(Boolean shareble) {
		this.shareble = shareble;
	}
	public Boolean getExpandable() {
		return expandable;
	}
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public type getDtype() {
		return dtype;
	}
	public void setDtype(type dtype) {
		this.dtype = dtype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
	}
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, Boolean shareble, Boolean expandable, int size, String html, type dtype) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.url = url;
		this.shareble = shareble;
		this.expandable = expandable;
		this.size = size;
		this.html = html;
		this.dtype = dtype;
	}
	
	public Widget(int id, String name, int width, int height, String text, int order, String url, int page_id,
			type dtype) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.text = text;
		this.order = order;
		this.url = url;
		this.page_id = page_id;
		this.dtype = dtype;
	}
	public Widget () {}
}
