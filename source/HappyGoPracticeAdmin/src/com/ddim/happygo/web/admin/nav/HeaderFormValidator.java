package com.ddim.happygo.web.admin.nav;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ddim.happygo.model.NavHeader;
import com.ddim.happygo.service.NavHeaderService;
import com.ddim.happygo.web.admin.nav.HeaderForm;
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
public class HeaderFormValidator {

	@Autowired
	private NavHeaderService navHeaderService;

	/**
	 * 表單驗證
	 * 
	 * @param form
	 * @param result
	 * @param managerService
	 * @throws Exception
	 */
	public void validate(HeaderForm form, BindingResult result) throws Exception {
		if (StringUtils.isBlank(form.getStatus())) {
			result.rejectValue("status", "error", "請選擇");
		}
		if (StringUtils.isBlank(form.getName())) {
			result.rejectValue("name", "error", "請輸入");
		}
		if (StringUtils.isBlank(form.getOpening_method())) {
			result.rejectValue("opening_method", "error", "請輸入");
		}
		if (StringUtils.isBlank(form.getUrl())) {
			result.rejectValue("url", "error", "請輸入");
		}
		if (!ValidatorUtil.isValidUrl(form.getUrl())) {
			result.rejectValue("tel", "error", "please input url");
		}
	}
}
