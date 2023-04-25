package com.ddim.happygo.web.admin.menu;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ddim.happygo.model.NavHeader;
import com.ddim.happygo.service.MenuMainService;
import com.ddim.happygo.web.admin.menu.MenuMainForm;
import com.mdbs.util.ValidatorUtil;

/**
 * 建立日期：2015年3月18日
 * 程式摘要：com.ddim.happygo.web.admin.manager<P> 
 * 類別名稱：ManagerFormValidator.java<P>
 * 程式內容說明：管理者表單資料 驗證<P>
 * @author Yvonne
 *
 **/
@Component
public class MenuMainFormValidator {

	@Autowired
	private MenuMainService menuMainService;

	/**
	 * 表單驗證
	 * 
	 * @param form
	 * @param result
	 * @param managerService
	 * @throws Exception
	 */
	public void validate(MenuMainForm form, BindingResult result) throws Exception {
		if (StringUtils.isBlank(form.getStatus())) {
			result.rejectValue("status", "error", "請選擇");
		}
		if (StringUtils.isBlank(form.getName())) {
			result.rejectValue("name", "error", "請輸入");
		}
	}
}