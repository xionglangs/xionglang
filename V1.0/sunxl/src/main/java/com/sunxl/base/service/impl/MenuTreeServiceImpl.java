package com.sunxl.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunxl.base.dao.MenuTreeDao;
import com.sunxl.base.entity.Menu;
import com.sunxl.base.generic.service.impl.GenericServiceImpl;
import com.sunxl.base.service.MenuTreeService;

/**
 * @author 熊浪
 * @Email xiongl@sunline.cn
 * @Time 2017年5月15日 @此类作用：
 */
@Service
public class MenuTreeServiceImpl extends GenericServiceImpl<Menu> implements MenuTreeService {
	@Autowired
	private MenuTreeDao menusDao;

	@Override
	public void setGenericDao() {
		super.genericDao = menusDao;
	}

	@Override
	@Transactional
	public Menu create(Menu entity) {
		return menusDao.create(entity);
	}

	@Override
	@Transactional
	public void delete(Object id) {
		menusDao.delete(id);
	}

	@Override
	@Transactional
	public Menu update(Menu entity) {
		return menusDao.update(entity);
	}

}
