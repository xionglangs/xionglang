package com.sunxl.privates.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunxl.base.entity.SysTidData;
import com.sunxl.base.form.EasyUIDataGridForm;
import com.sunxl.base.form.FieldForm;
import com.sunxl.base.service.SysTidDataService;
import com.sunxl.base.util.JSON;
import com.sunxl.base.util.Page;
import com.sunxl.base.util.PrivateBaseMethodUtil;

/**
 * @author 熊浪
 * @Email xiongl@sunline.cn
 * @Time 2017年6月1日 @此类作用：
 */
@Controller
@RequestMapping(value = "/private/sysTidData")
public class PrivateSysTidDataController {
	private static final Logger logger = LoggerFactory.getLogger(PrivateSysTidDataController.class);
	private static final String OBJECTINFO = "系统来源";
	@Autowired
	private SysTidDataService sysTidDataService;

	@RequestMapping(value = "/viewSysTidDataJson")
	public String goSysTidData(HttpServletRequest request) {
		List<FieldForm> searchParamList = new ArrayList<FieldForm>();
		searchParamList.add(new FieldForm("tableName", "表名"));
		searchParamList.add(new FieldForm("entityKey", "类路径"));
		searchParamList.add(new FieldForm("entityValue", "索引值"));
		searchParamList.add(new FieldForm("smrytx", "表用途"));
		try {
			PrivateBaseMethodUtil.goObjectViewList(request, searchParamList, "/private/sysTidData", Page.create(), "#idSysTidDataForm", PrivateSysTidDataController.OBJECTINFO);
			return "private.sysTidData.list";
		} catch (Exception e) {
			logger.error("错误行号:【"+new Throwable().getStackTrace()[0].getLineNumber()+"】"+e.getMessage());
			return "private.error";
		}
	}

	@RequestMapping(value = "/goViewList", params = "method=ajaxList", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public EasyUIDataGridForm goSysTidDataList(HttpServletRequest request) {
		return PrivateBaseMethodUtil.getEasyUIDataGridJSON(request, sysTidDataService);
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewSysTidData(@PathVariable("id") int id, HttpServletRequest request) {
		return PrivateBaseMethodUtil.viewObject(request, sysTidDataService, "private.sysTidData.view", id, "sysTidData");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSysTidData(HttpServletRequest request) {
		return "private.sysTidData.add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JSON addSysTidData(HttpServletRequest request, SysTidData sysTidData) {
		return PrivateBaseMethodUtil.addObject(sysTidDataService, sysTidData, PrivateSysTidDataController.OBJECTINFO);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JSON deleteSysTidData(@PathVariable("id") int id, HttpServletRequest request) {
		return PrivateBaseMethodUtil.deleteObject(sysTidDataService, id, PrivateSysTidDataController.OBJECTINFO);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateSysTidData(@PathVariable("id") int id, HttpServletRequest request) {
		return PrivateBaseMethodUtil.viewObject(request, sysTidDataService, "private.sysTidData.update", id, "sysTidData");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JSON updateSysTidData(HttpServletRequest request, SysTidData sysTidData) {
		return PrivateBaseMethodUtil.updateObject(sysTidDataService, sysTidData, PrivateSysTidDataController.OBJECTINFO);
	}
}