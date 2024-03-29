package com.ddim.happygo.service;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddim.happygo.dao.NavHeaderDao;
import com.ddim.happygo.model.MenuMain;
import com.ddim.happygo.model.NavHeader;
import com.mdbs.jdbc.Page;
import com.mdbs.jdbc.PagingParameter;
import com.mdbs.util.Id;

/**
 * 建立日期：2015年3月9日
 * 程式摘要：com.ddim.happygo.service<P> 
 * 類別名稱：ManagerTaskService.java<P>
 * 程式內容說明：最新消息服務<P>
 * @author Yvonne
 */
@Service
public class NavHeaderService {

	@Autowired
	private NavHeaderDao navHeaderDao;

	
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
		return navHeaderDao.findPage(name, status, paging);
	}
	
	/**
	 * 查詢列表
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<NavHeader> getList(String status) throws Exception {
		return navHeaderDao.getList(status);
	}

	/**
	 * 取得總筆數
	 * 
	 * @return
	 * @throws Exception
	 */
	public int countList() throws Exception {
		return navHeaderDao.countList();
	}

	/**
	 * 取得單一物件
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NavHeader get(String id) throws Exception {
		return navHeaderDao.get(id);
	}

	/**
	 * 儲存
	 * 
	 * @param entity
	 * @param modifier
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void save(NavHeader entity, String modifier) throws Exception {
		Timestamp now = new Timestamp(new GregorianCalendar().getTimeInMillis());
		if (StringUtils.isBlank(entity.getId())) {
			entity.setId(Id.id20());
			entity.setCreator(modifier);
			entity.setCreate_time(now);
			entity.setModifier(modifier);
			entity.setModify_time(now);
			entity.setSort(countList()+1);
			navHeaderDao.insert(entity);
		} else {
			entity.setModifier(modifier);
			entity.setModify_time(now);
			navHeaderDao.update(entity);
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
			NavHeader entity = get(id);
			navHeaderDao.delete(entity.getId());
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
			NavHeader entity = get(id);
			navHeaderDao.updateStatus(entity.getId(), status, modifier);
		}
	}

	/**
	 * 更新排序
	 * 
	 * @param id
	 * @param sort
	 * @param modifier
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateSort(int sortTemp, String id, int sort, String modifier) throws Exception {
		navHeaderDao.updateSort(id, sort, sortTemp, modifier);
	}

}