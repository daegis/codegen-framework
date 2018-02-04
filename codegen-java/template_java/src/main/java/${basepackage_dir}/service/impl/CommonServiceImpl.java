package com.dangdang.digital.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dangdang.digital.dao.ICommonDao;
import com.dangdang.digital.service.ICommonService;
import com.dangdang.digital.utils.PageFinder;
import com.dangdang.digital.utils.Query;
/**
 * @author lvxiang
 * @date   2015年5月13日 下午5:31:09
 * 无状态,相当一个代理,最终转到Dao执行
 */
@Service("commonService")
public  class CommonServiceImpl implements ICommonService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Resource
	ICommonDao dao;
	public ICommonDao getCommonDao() {
		return dao;
	}
	
	public <T> String getMapperName(Class<T> clzss){
		 return clzss.getSimpleName().concat(Mapper).concat(".");
	}
	
	public <PK,T> T get(final PK id,Class<T> clzss){
		return getCommonDao().get(id,clzss);
	}
	
	public <PK, T> int delete(PK id,Class<T> clzss) {
		return getCommonDao().delete(id,clzss);
	}

	public <T> int save(T target) {
		return getCommonDao().save(target);
	}
	
	public <T> int save(List<T> target) {
		return  getCommonDao().save(target);
	}

	
	public <T> int update(T target) {
		return getCommonDao().update(target);
	}
	

	
	public <PK,T> List<T> get(List<PK> ids,Class<T> clzss){
		return getCommonDao().get(ids,clzss);
	}
	
	public <PK,T> int delete(List<PK> ids,Class<T> clzss){
		return getCommonDao().delete(ids,clzss);
	}
	
	public <PK,T> List<T> findMasterByIds(List<PK> ids,Class<T> clzss){
		return getCommonDao().getFromMaster(ids,clzss);
	}

	public <T> int delete(T bean) {
		return getCommonDao().delete(bean);
	}

	
	public <T> int delete(Class<T> clzss, Object... params) {
		return getCommonDao().delete(clzss,params);
	}

	
	public <T> T get(T bean) {
		return getCommonDao().get(bean);
	}
	
	
	public <T> List<T> getList(Class<T> clzss, Object... params) {
		return getCommonDao().getList(clzss, params);
	}
	
	
	public <T> List<T> getByMapParameters(Map map, Class<T> clzss) {
		return getCommonDao().getByMapParameters(map, clzss);
	}

	
	public <T> List<T> getList(T bean) {
		return getCommonDao().getList(bean);
	}

	
	public <PK, T> T getFromMaster(PK key, Class<T> clzss) {
		return getCommonDao().getFromMaster(key, clzss);
	}

	
	public <PK, T> List<T> getFromMaster(List<PK> key, Class<T> clzss) {
		return getCommonDao().getFromMaster(key, clzss);
	}

	
	public <T> T getFromMaster(T bean) {
		return getCommonDao().getFromMaster(bean);
	}

	
	public <T> List<T> getListFromMaster(T bean) {
		return getCommonDao().getListFromMaster(bean);
	}

	
	public <T> T getFromMaster(Class<T> clzss, Object... keyValueParams) {
		return getCommonDao().getFromMaster(clzss, keyValueParams);
	}

	
	public <T> List<T> getListFromMaster(Class<T> clzss,
			Object... keyValueParams) {
		return getCommonDao().getListFromMaster(clzss, keyValueParams);
	}

	
	public <T> T get(Class<T> clzss, Object... keyValueParams) {
		return getCommonDao().get(clzss, keyValueParams);
	}

	
	public <T> PageFinder<T> findMasterPageFinder(T bean, Query query) {
		return getCommonDao().findMasterPageFinder(bean, query);
	}

	
	public <T> PageFinder<T> findPageFinder(T bean, Query query) {
		return getCommonDao().findPageFinder(bean,query);
	}


}
