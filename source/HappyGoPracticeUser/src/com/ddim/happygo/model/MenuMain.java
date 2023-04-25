package com.ddim.happygo.model;

import java.io.Serializable;
import java.sql.Timestamp;

/***
 * 建立日期：2016/1/10 
 * 程式摘要：com.ddim.happygo.model
 * 類別名稱：CardMemberJoinBasic.java
 * 程式內容說明：後台角色物件
 * @author Yvonne
 * */
public class MenuMain implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String type;
	private String status;
	private String creator;
	private Timestamp create_time;
	private String modifier;
	private Timestamp modify_time;
	private int sort;
	private String text_color;
	private String cursor_color;
	private String icon_show;
	private String main_url;
	private String ad_name;
	private String ad_content;
	private String image;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param name the name to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return the create_time
	 */
	public Timestamp getCreate_time() {
		return create_time;
	}
	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier;
	}
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	/**
	 * @return the modify_time
	 */
	public Timestamp getModify_time() {
		return modify_time;
	}
	/**
	 * @param modify_time the modify_time to set
	 */
	public void setModify_time(Timestamp modify_time) {
		this.modify_time = modify_time;
	}
	
	/**
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	/**
	 * @return the text_color
	 */
	public String getText_color() {
		return text_color;
	}
	/**
	 * @param text_color the name to set
	 */
	public void setText_color(String text_color) {
		this.text_color = text_color;
	}
	
	/**
	 * @return the cursor_color
	 */
	public String getCursor_color() {
		return cursor_color;
	}
	/**
	 * @param name the cursor_color to set
	 */
	public void setCursor_color(String cursor_color) {
		this.cursor_color = cursor_color;
	}
	
	/**
	 * @return the icon_show
	 */
	public String getIcon_show() {
		return icon_show;
	}
	/**
	 * @param name the icon_show to set
	 */
	public void setIcon_show(String icon_show) {
		this.icon_show = icon_show;
	}
	
	/**
	 * @return the main_url
	 */
	public String getMain_url() {
		return main_url;
	}
	/**
	 * @param name the main_url to set
	 */
	public void setMain_url(String main_url) {
		this.main_url = main_url;
	}
	
	/**
	 * @return the ad_name
	 */
	public String getAd_name() {
		return ad_name;
	}
	/**
	 * @param name the ad_name to set
	 */
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	
	/**
	 * @return the ad_content
	 */
	public String getAd_content() {
		return ad_content;
	}
	/**
	 * @param name the ad_content to set
	 */
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
}