package com.ddim.happygo.service;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddim.happygo.Constants;
import com.ddim.happygo.dao.MenuMainDao;
import com.ddim.happygo.model.Manager;
import com.ddim.happygo.model.ManagerRole;
import com.ddim.happygo.model.MenuMain;
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
public class HomePageService {
	@Autowired
	private MenuMainDao menuMainDao;
	
	/**
	 * 取得分頁
	 * 
	 * @param name
	 * @param status
	 * @param paging
	 * @return
	 * @throws Exception
	 */
	public Page<MenuMain> findPage(String name, String status, PagingParameter paging) throws Exception {
		return menuMainDao.findPage(name, status, paging);
	}
	
	/**
	 * 查詢列表
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<MenuMain> getList(String status) throws Exception {
		return menuMainDao.getList(status);
	}
	
	/**
	 * 取得總筆數
	 * 
	 * @return
	 * @throws Exception
	 */
	public int countList() throws Exception {
		return menuMainDao.countList();
	}

	/**
	 * 取得單一物件
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MenuMain get(String id) throws Exception {
		return menuMainDao.get(id);
	}
	
	/**
	 * 儲存
	 * 
	 * @param entity
	 * @param modifier
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(MenuMain entity, String modifier) throws Exception {
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
		if (StringUtils.isBlank(entity.getId())) {
			entity.setId(Id.id20());
			entity.setCreator(modifier);
			entity.setCreate_time(now);
			entity.setModifier(modifier);
			entity.setModify_time(now);
			entity.setSort(countList()+1);
			 menuMainDao.insert(entity);
		} else {
			entity.setModifier(modifier);
			entity.setModify_time(now);
			 menuMainDao.update(entity);
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
			MenuMain entity = get(id);
			if (!Constants.ADMIN_SN.equals(entity.getId())) {
				menuMainDao.delete(entity.getId());
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
			MenuMain entity = get(id);
			if (!Constants.ADMIN_SN.equals(entity.getId())) {
				menuMainDao.updateStatus(entity.getId(), status, modifier);
			}
		}
	}
}