package com.ddim.happygo.service;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddim.happygo.Constants;
import com.ddim.happygo.dao.MenuSubDao;
import com.ddim.happygo.model.MenuMain;
import com.ddim.happygo.model.MenuSub;
import com.ddim.happygo.model.News;
import com.mdbs.jdbc.Page;
import com.mdbs.jdbc.PagingParameter;
import com.mdbs.util.Id;

/**
 * 建立日期：2015年3月9日
 * 程式摘要：com.ddim.happygo.service<P> 
 * 類別名稱：MenuMainService.java<P>
 * 程式內容說明：最新消息服務<P>
 * @author Yvonne
 */
@Service
public class MenuSubService {
	@Autowired
	private MenuSubDao menuSubDao;
	
	/**
	 * 取得分頁
	 * 
	 * @param name
	 * @param status
	 * @param paging
	 * @return
	 * @throws Exception
	 */
	public Page<MenuSub> findPage(String name, String status,String mainMenuId, PagingParameter paging) throws Exception {
		return menuSubDao.findPage(name, status,mainMenuId , paging);
	}
	
	/**
	 * 取得總筆數
	 * 
	 * @return
	 * @throws Exception
	 */
	public int countList() throws Exception {
		return menuSubDao.countList();
	}

	/**
	 * 取得單一物件
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MenuSub get(String id) throws Exception {
		return menuSubDao.get(id);
	}
	
	/**
	 * 儲存
	 * 
	 * @param entity
	 * @param modifier
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(MenuSub entity, String modifier) throws Exception {
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
		if (StringUtils.isBlank(entity.getId())) {
			entity.setId(Id.id20());
			entity.setCreator(modifier);
			entity.setCreate_time(now);
			entity.setModifier(modifier);
			entity.setModify_time(now);
			entity.setSort(countList()+1);
			 menuSubDao.insert(entity);
		} else {
			entity.setModifier(modifier);
			entity.setModify_time(now);
			 menuSubDao.update(entity);
		}
	}
	
	/**
	 * 刪除
	 * 
	 * @param ids
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void delete(String[] ids, String modifier) throws Exception {
		for (String id : ids) {
			MenuSub entity = get(id);
			if (!Constants.ADMIN_SN.equals(entity.getId())) {
				menuSubDao.delete(entity.getId());
			}
		}
	}

	/**
	 * 更新狀態
	 * 
	 * @param ids
	 * @param status
	 * @param modifier
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateStatus(String[] ids, String status, String modifier) throws Exception {
		for (String id : ids) {
			MenuSub entity = get(id);
			if (!Constants.ADMIN_SN.equals(entity.getId())) {
				menuSubDao.updateStatus(entity.getId(), status, modifier);
			}
		}
	}

}