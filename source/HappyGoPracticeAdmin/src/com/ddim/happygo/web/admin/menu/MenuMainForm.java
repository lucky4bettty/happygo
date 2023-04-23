package com.ddim.happygo.web.admin.menu;

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

public class MenuMainForm {
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
	private String[] ids;
	private String image;
	private MultipartFile img_file;


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getText_color() {
		return text_color;
	}

	public void setText_color(String text_color) {
		this.text_color = text_color;
	}
	

	public String getCursor_color() {
		return cursor_color;
	}

	public void setCursor_color(String cursor_color) {
		this.cursor_color = cursor_color;
	}
	

	public String getIcon_show() {
		return icon_show;
	}

	public void setIcon_show(String icon_show) {
		this.icon_show = icon_show;
	}
	

	public String getMain_url() {
		return main_url;
	}

	public void setMain_url(String main_url) {
		this.main_url = main_url;
	}
	

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public MultipartFile getImg_file() {
		return img_file;
	}

	public void setImg_file(MultipartFile img_file) {
		this.img_file = img_file;
	}
	
}