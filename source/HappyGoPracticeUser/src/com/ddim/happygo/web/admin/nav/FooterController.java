package com.ddim.happygo.web.admin.nav;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddim.happygo.Constants;
import com.ddim.happygo.MessageConstants;
import com.ddim.happygo.model.ManagerRole;
import com.ddim.happygo.model.ManagerTask;
import com.ddim.happygo.model.News;
import com.ddim.happygo.model.NavHeader;
import com.ddim.happygo.service.ManagerRoleService;
import com.ddim.happygo.service.ManagerTaskService;
import com.ddim.happygo.service.NavFooterService;
import com.ddim.happygo.util.ManagerUtil;
import com.ddim.happygo.web.admin.news.NewsForm;
import com.mdbs.jdbc.Page;
import com.mdbs.jdbc.PagingParameter;
import com.mdbs.util.LogUtil;

/**
 * 建立日期：2015年3月7日
 * 程式摘要：com.ddim.happygo.web.admin.role<P> 
 * 類別名稱：RoleController.java<P>
 * 程式內容說明：header<P>
 * @author Yvonne
 * */
@Controller
@RequestMapping(value = "/admin/nav/footer")
public class FooterController {
	@Value("${page_size}")
	private int pageItems;
	@Autowired
	private NavFooterService navFooterService;
	@Autowired
	private ManagerUtil managerUtil;
	@Autowired
	private HeaderFormValidator formValidator;
	
	@Resource(name = "statusOption")
	private Map<String, String> statusOption;
	
	@Resource(name = "targetOption")
	private Map<String, String> targetOption;
	
	protected String getPath() {
		return "admin/nav/footer";
	}
	
	protected String getRightID() {
		return Constants.HG_WEBSITE_FOOTER;
	}
	private void setCommonData(HttpServletRequest request) throws Exception {
		request.setAttribute("statusOption", statusOption);
		request.setAttribute("targetOption", targetOption);
	}
	/**
	 * 列表
	 * @param request
	 * @param form
	 * @param paging
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, @ModelAttribute("command") HeaderForm form, PagingParameter paging,
			ModelMap model) throws Exception {
		try {
			String returnPath = managerUtil.haveRight(request, getRightID());
			if (returnPath != null) {
				return returnPath;
			}
			setCommonData(request);
			paging.setPageSize(pageItems);
			Page<NavHeader> page = navFooterService.findPage(form.getName(), form.getStatus(), paging);
			model.addAttribute("page", page);
			return getPath() + "/list";
		} catch (Exception e) {
			LogUtil.setErrorLog("list", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);
			return "common/jsAlert";
		}
	}
	
	/**
	 * 編輯
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, @ModelAttribute("command") HeaderForm form, ModelMap model)
			throws Exception {
		try {
			String returnPath = managerUtil.haveRight(request, getRightID());
			if (returnPath != null) {
				return returnPath;
			}
			if (StringUtils.isNotBlank(form.getId())) {
				NavHeader data = navFooterService.get(form.getId());
				if (data == null) {
					model.addAttribute("message", MessageConstants.MESSAGE_NO_DATA);
					model.addAttribute("relativeUrl", "list.do");
					return "common/jsAlert";
				}
				BeanUtils.copyProperties(data, form);
			}
			setCommonData(request);
			return getPath() + "/edit";
		} catch (Exception e) {
			LogUtil.setErrorLog("edit", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);
			return "common/jsAlert";
		}
	}
	
	
	/**
	 * 存檔
	 * @param request
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, @ModelAttribute("command") HeaderForm form, BindingResult result,
			ModelMap model) throws Exception {
		try {
			String returnPath = managerUtil.haveRight(request, getRightID());
			if (returnPath != null) {
				return returnPath;
			}
			formValidator.validate(form, result);
			if (result.hasErrors()) {
				setCommonData(request);
				return getPath() + "/edit";
			}
			NavHeader navHeader = new NavHeader();
			BeanUtils.copyProperties(form, navHeader);

			navFooterService.save(navHeader, managerUtil.getManagerAccount(request));
			LogUtil.setSaveLog(managerUtil.getManagerAccount(request),
					"save manager success: " + navHeader.getId());
			model.addAttribute("message", MessageConstants.MESSAGE_SAVE_SUCCESS);
			model.addAttribute("relativeUrl", "list.do");
			return "common/jsAlert";
		} catch (Exception e) {
			LogUtil.setErrorLog("save", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_EXCEPTION);
			model.addAttribute("relativeUrl", Constants.ADMIN_INDEX_URI);
			return "common/jsAlert";
		}
	}

	/**
	 * 更新狀態
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, @ModelAttribute("command") HeaderForm form, ModelMap model)
			throws Exception {
		try {
			String returnPath = managerUtil.haveRight(request, getRightID());
			if (returnPath != null) {
				return returnPath;
			}
			navFooterService.updateStatus(form.getIds(), form.getStatus(), managerUtil.getManagerAccount(request));
			LogUtil.setSaveLog(managerUtil.getManagerAccount(request),
					"update manager status success: " + form.getIds());
			model.addAttribute("message", MessageConstants.MESSAGE_SAVE_SUCCESS);
			model.addAttribute("relativeUrl", "list.do");
			return "common/jsAlert";
		} catch (Exception e) {
			LogUtil.setErrorLog("update", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);
			return "common/jsAlert";
		}
	}

	/**
	 * 刪除
	 * @param request
	 * @param ids
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, @ModelAttribute("command") HeaderForm form, ModelMap model)
			throws Exception {
		try {
			String returnPath = managerUtil.haveRight(request, getRightID());
			if (returnPath != null) {
				return returnPath;
			}
			navFooterService.delete(form.getIds(), managerUtil.getManagerAccount(request));
			LogUtil.setSaveLog(managerUtil.getManagerAccount(request),
					"delete manager success: " + form.getIds());
			model.addAttribute("message", MessageConstants.MESSAGE_DELETE_SUCCESS);
			model.addAttribute("relativeUrl", "list.do");
			return "common/jsAlert";
		} catch (Exception e) {
			LogUtil.setErrorLog("delete", e);
			model.addAttribute("message", MessageConstants.MESSAGE_SYSTEM_BUSY);
			model.addAttribute("relativeUrl", Constants.LOGIN_PAGE);
			return "common/jsAlert";
		}
	}

}