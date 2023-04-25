package com.ddim.happygo.web.admin.nav;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

/***
 * 建立日期：2015/03/12
 * 程式摘要：com.ddim.happygo.web.admin.news<P> 
 * 類別名稱：NewsForm.java<P>
 * 程式內容說明：最新消息表單物件<P>
 * @author Yvonne 
 * @version 1.0 
 * @since 1.0
 * */

public class HeaderForm {
	private String id;
	private String name;
	private String url;
	private int sort;
	private String opening_method;
	private String status;
	private String creator;
	private Timestamp create_time;
	private String modifier;
	private Timestamp modify_time;
	private String[] ids;

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getUrl() {
	    return url;
	}

	public void setUrl(String url) {
	    this.url = url;
	}

	public int getSort() {
	    return sort;
	}

	public void setSort(int sort) {
	    this.sort = sort;
	}

	public String getOpening_method() {
	    return opening_method;
	}

	public void setOpening_method(String opening_method) {
	    this.opening_method = opening_method;
	}

	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

	public String getCreator() {
	    return creator;
	}

	public void setCreator(String creator) {
	    this.creator = creator;
	}

	public Timestamp getCreate_time() {
	    return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
	    this.create_time = create_time;
	}

	public String getModifier() {
	    return modifier;
	}

	public void setModifier(String modifier) {
	    this.modifier = modifier;
	}

	public Timestamp getModify_time() {
	    return modify_time;
	}

	public void setModify_time(Timestamp modify_time) {
	    this.modify_time = modify_time;
	}
	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
}