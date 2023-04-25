package com.ddim.happygo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddim.happygo.Constants;
import com.ddim.happygo.model.MenuMain;
import com.ddim.happygo.model.MenuSub;
import com.ddim.happygo.model.NavHeader;
import com.mdbs.jdbc.ClassRowMapperFactory;
import com.mdbs.jdbc.Page;
import com.mdbs.jdbc.PagingParameter;
import com.mdbs.jdbc.SimpleJdbc;

/***
 * 建立日期：2016/01/15
 * 程式摘要：com.ddim.happygo.dao<P>
 * 類別名稱：MenuSubDao.java<P>
 * 程式內容說明：最新消息連結資料表<P>
 * @author Yvonne
 * */
@Repository
public class MenuSubDao {
	@Autowired
	private SimpleJdbc simpleJdbc;
	public final static String TABLE_NAME = "HG_MENU_SUB_LIST";
	private SimpleJdbcInsert simpleJdbcInsert;
	@Autowired
	public void init(DataSource dataSource) throws Exception {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingColumns("ID", "NAME",
				"TYPE","SORT" , "STATUS", "CREATOR", "CREATE_TIME",
				"MODIFIER", "MODIFY_TIME","MAIN_MENU","URL",
				"OPENING_METHOD"
				);
	}
	
	/**
	 * 取得分頁
	 * 
	 * @param name
	 * @param status
	 * @param paging
	 * @return
	 * @throws Exception
	 */
	public Page<MenuSub> findPage(String name, String status,String mainMenuId , PagingParameter paging) throws Exception {
		List<Object> args = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer("SELECT HG_MENU_SUB_LIST.* FROM ");
		sb.append(TABLE_NAME);
		sb.append(" INNER JOIN HG_MENU_MAIN_LIST ");
		sb.append(" ON HG_MENU_SUB_LIST.MAIN_MENU = HG_MENU_MAIN_LIST.ID ");
		sb.append(" WHERE HG_MENU_SUB_LIST.ID IS NOT NULL");
		if (StringUtils.isNotBlank(name)) {
			sb.append(" AND NAME LIKE ?");
			args.add("%" + name + "%");
		}
		if (StringUtils.isNotBlank(status)) {
			sb.append(" AND HG_MENU_SUB_LIST.STATUS = ?");
			args.add(status);
		}
		if (StringUtils.isNotBlank(mainMenuId)) {
			sb.append(" AND HG_MENU_SUB_LIST.MAIN_MENU = ?");
			args.add(mainMenuId);
		}
		sb.append(" ORDER BY SORT DESC");
		return simpleJdbc.findPage(sb.toString(), args.toArray(), paging, ClassRowMapperFactory.get(MenuSub.class));
	}
	
	/**
	 * 取得總筆數
	 * 
	 * @return
	 * @throws Exception
	 */
	public int countList() throws Exception {
		StringBuffer sb = new StringBuffer("SELECT COUNT(1) FROM ");
		sb.append(TABLE_NAME);
		List<Object> args = new ArrayList<Object>();
		return simpleJdbc.queryForInt(sb.toString(), args.toArray());
	}
	
	/**
	 * 依ID取得單一物件
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MenuSub get(String id) throws Exception {
		StringBuffer sb = new StringBuffer("SELECT * FROM ");
		sb.append(TABLE_NAME);
		sb.append(" WHERE ID=?");
		Object[] args = { id };
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(MenuSub.class)));
	}
	
	/**
	 * 新增
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void insert(MenuSub entity) throws Exception {
		System.out.println(entity);
		simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(entity));
	}
	
	/**
	 * 編輯
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(MenuSub entity) throws Exception {
		String sql = "UPDATE " + TABLE_NAME
				+ " SET NAME=?, TYPE=? ,  STATUS=?, CREATOR=?, CREATE_TIME=?, MODIFIER=?, MODIFY_TIME=? ,MAIN_MENU =? ,URL=? ,OPENING_METHOD  WHERE ID=?";
		Object[] args = { entity.getName(), entity.getType(),entity.getStatus(),
				entity.getCreator(), entity.getCreate_time(),
				entity.getModifier(), entity.getModify_time(),
				entity.getMain_menu(), entity.getUrl(),entity.getOpening_method(),
				entity.getId() };
		simpleJdbc.update(sql, args);
	}
	
	/**
	 * 刪除
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		StringBuffer sb = new StringBuffer("DELETE FROM " + TABLE_NAME + " WHERE ID=? ");
		Object[] args = { id };
		simpleJdbc.update(sb.toString(), args);
	}
	
	/**
	 * 依 ID 更新狀態
	 * 
	 * @param id
	 * @param status
	 * @param modifier
	 * @throws Exception
	 */
	public void updateStatus(String id, String status, String modifier) throws Exception {
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
		StringBuffer sb = new StringBuffer("UPDATE ");
		sb.append(TABLE_NAME);
		sb.append(" SET STATUS=?, MODIFIER=?, MODIFY_TIME=? WHERE ID=?");
		Object[] args = { status, modifier, now, id };
		simpleJdbc.update(sb.toString(), args);
	}
}