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
public class MenuSub implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String type;
	private String url;
	private String opening_method;
	private String status;
	private String creator;
	private Timestamp create_time;
	private String modifier;
	private Timestamp modify_time;
	private int sort;
	private String main_menu;


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
	 * @return the opening_method
	 */
	public String getOpening_method() {
		return opening_method;
	}
	/**
	 * @param url the opening_method to set
	 */
	public void setOpening_method(String opening_method) {
		this.opening_method = opening_method;
	}
	/**
	 * @return the opening_id
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the name to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the main_menu
	 */
	public String getMain_menu() {
		return main_menu;
	}
	/**
	 * @param name the name to set
	 */
	public void setMain_menu(String main_menu) {
		this.main_menu = main_menu;
	}
	
}