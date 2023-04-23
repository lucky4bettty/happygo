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

import com.ddim.happygo.model.NavHeader;
import com.mdbs.jdbc.ClassRowMapperFactory;
import com.mdbs.jdbc.Page;
import com.mdbs.jdbc.PagingParameter;
import com.mdbs.jdbc.SimpleJdbc;

/***
 * 建立日期：2016/01/15
 * 程式摘要：com.ddim.happygo.dao<P>
 * 類別名稱：NewsDao.java<P>
 * 程式內容說明：最新消息連結資料表<P>
 * @author Yvonne
 * */
@Repository
public class NavFooterDao {
	@Autowired
	private SimpleJdbc simpleJdbc;
	public final static String TABLE_NAME = "HG_WEBSITE_FOOTER";
	private SimpleJdbcInsert simpleJdbcInsert;

	@Autowired
	public void init(DataSource dataSource) throws Exception {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingColumns("ID", "NAME",
				"URL","SORT" ,"OPENING_METHOD" , "STATUS", "CREATOR", "CREATE_TIME",
				"MODIFIER", "MODIFY_TIME");
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
	public Page<NavHeader> findPage(String name, String status, PagingParameter paging) throws Exception {
		List<Object> args = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer("SELECT * FROM ");
		sb.append(TABLE_NAME);
		sb.append(" WHERE ID IS NOT NULL");
		if (StringUtils.isNotBlank(name)) {
			sb.append(" AND NAME LIKE ?");
			args.add("%" + name + "%");
		}
		if (StringUtils.isNotBlank(status)) {
			sb.append(" AND STATUS = ?");
			args.add(status);
		}
		sb.append(" ORDER BY SORT DESC");
		return simpleJdbc.findPage(sb.toString(), args.toArray(), paging, ClassRowMapperFactory.get(NavHeader.class));
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
	public NavHeader get(String id) throws Exception {
		StringBuffer sb = new StringBuffer("SELECT * FROM ");
		sb.append(TABLE_NAME);
		sb.append(" WHERE ID=?");
		Object[] args = { id };
		return simpleJdbc.getFirst(simpleJdbc.query(sb.toString(), args, ClassRowMapperFactory.get(NavHeader.class)));
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
	 * 新增
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void insert(NavHeader entity) throws Exception {
		simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(entity));
	}

	/**
	 * 編輯
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(NavHeader entity) throws Exception {
		String sql = "UPDATE " + TABLE_NAME
				+ " SET NAME=?, URL=?, OPENING_METHOD=?, STATUS=?, MODIFIER=?, MODIFY_TIME=? WHERE ID=?";
		Object[] args = { 
				entity.getName(),entity.getUrl(),entity.getOpening_method(),
				entity.getStatus(), entity.getModifier(), entity.getModify_time(),
				entity.getId() };
		simpleJdbc.update(sql, args);
	}

	/**
	 * 更新狀態
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
		sb.append(" SET STATUS=?, MODIFIER=?, MODIFY_TIME=? WHERE ID = ?");
		Object[] args = { status, modifier, now, id };
		simpleJdbc.update(sb.toString(), args);
	}

	/**
	 * 更新排序
	 * 
	 * @param id
	 * @param sort
	 * @param modifier
	 * @throws Exception
	 */
	public void updateSort(String id, int sort, int sortTemp, String modifier) throws Exception {
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
		StringBuffer sb = new StringBuffer("UPDATE ");
		sb.append(TABLE_NAME);
		sb.append(" SET SORT = SORT");
		if (sort < sortTemp) {
			sb.append("+1 WHERE SORT>");
			sb.append(sort-1);
			sb.append(" AND SORT<");
			sb.append(sortTemp);
		} else if (sort > sortTemp) {
			sb.append("-1 WHERE SORT<");
			sb.append(sort+1);
			sb.append(" AND SORT>");
			sb.append(sortTemp);
		}
		sb.append(" UPDATE ");
		sb.append(TABLE_NAME);
		sb.append(" SET SORT=?, MODIFIER=?, MODIFY_TIME=? WHERE ID = ?");
		Object[] args = { sort, modifier, now, id };
		simpleJdbc.update(sb.toString(), args);
	}
	
}


