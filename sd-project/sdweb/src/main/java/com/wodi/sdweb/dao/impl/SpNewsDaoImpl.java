/*
 * 版权所有 (C) 2014 
 * 未经许可不得擅自公开、复制这些机密资料及其中任何部分，
 * 只可按照其使用许可协议。
 *
 * File Name: $(#)SpProductDaoImpl.java
 * Creation Date: 2014年9月23日 下午3:37:20
 * $Id$
 */
package com.wodi.sdweb.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.wodi.sdweb.dao.SpNewsDao;
import com.wodi.sdweb.model.SpNews;

/**
 * <p>
 * SpNewsDao接口实现
 * </p>
 *
 * @author Rory.luo
 * 
 */
@Repository
public class SpNewsDaoImpl extends SqlSessionDaoSupport implements
		SpNewsDao {

	@Override
	public void insert(SpNews spNews) {
		this.getSqlSession().getMapper(SpNewsDao.class).insert(spNews);;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<SpNews> pageSelect(int startRow, int endRow)
			throws SQLException {
		List<SpNews> spNewsList = new ArrayList<SpNews>();    
        Map params =new HashMap();    
        params.put("startRow", new Integer(startRow));    
        params.put("endRow", new Integer(endRow));    
        spNewsList = this.getSqlSession().selectList("com.wodi.sdweb.dao.SpNewsDao.pageSelect", params);    
       return spNewsList; 
	}

}
