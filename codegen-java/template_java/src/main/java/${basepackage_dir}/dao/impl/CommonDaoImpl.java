package com.dangdang.digital.dao.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.dangdang.digital.dao.ICommonDao;
import com.dangdang.digital.utils.PageFinder;
import com.dangdang.digital.utils.Query;
/**
 * @author lvxiang
 * @date   2015年5月13日 下午5:12:12
 * 所有数据库操作实现　
 */
@Repository
public class CommonDaoImpl implements ICommonDao{
	
	/**主库**/
	@Resource(name = "master_sqlSession")
	private SqlSessionTemplate sqlSession;

	/**从库**/
	@Resource(name = "slave_sqlSession")
	private SqlSessionTemplate sqlSessionQurey;

	public SqlSessionTemplate getSqlSessionQueryTemplate(){
		return this.sqlSessionQurey;
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return this.sqlSession;
	}
	
	/**
	 * 得到clzss Bean对应的Mapper文件名称
	 */
	public <T> String getMapperName(Class<T> clzss){
		 return clzss.getSimpleName().concat(Mapper).concat(".");
	}
	
	/**
	 * 从库查询
	 * @param <T>
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> T selectOne(String statement) {
		return (T) this.getSqlSessionQueryTemplate().selectOne(statement);
	}

	/**
	 * 从库查询
	 * @param <T>
	 */
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> T selectOne(String statement, Object parameter) {
		return (T)this.getSqlSessionQueryTemplate().selectOne(statement, parameter);
	}

	/**
	 * 从库查询
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public Map<?, ?> selectMap(String statement, String mapKey) {
		return this.getSqlSessionQueryTemplate().selectMap(statement, mapKey);
	}

	/**
	 * 从库查询
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public Map<?, ?> selectMap(String statement, Object parameter, String mapKey) {
		return this.getSqlSessionQueryTemplate().selectMap(statement, parameter, mapKey);
	}

	/**
	 * 从库查询
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public Map<?, ?> selectMap(String statement, Object parameter,
			String mapKey, RowBounds rowBounds) {
		return this.getSqlSessionQueryTemplate().selectMap(statement, parameter, mapKey,
				rowBounds);
	}

	/**
	 * 从库查询
	 * @param <T>
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> List<T> selectList(String statement) {
		return (List<T>)this.getSqlSessionQueryTemplate().selectList(statement);
	}

	/**
	 * 从库查询
	 * @param <T>
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> List<T> selectList(String statement, Object parameter) {
		return (List<T>)this.getSqlSessionQueryTemplate().selectList(statement, parameter);
	}

	/**
	 * 从库查询
	 * @param <T>
	 */
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> List<T> selectList(String statement, Object parameter,
			RowBounds rowBounds) {
		return (List<T>)this.getSqlSessionQueryTemplate().selectList(statement, parameter, rowBounds);
	}

	/**
	 * 从库查询
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public void select(String statement, ResultHandler handler) {
		this.getSqlSessionQueryTemplate().select(statement, handler);
	}

	/**
	 * 从库查询
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public void select(String statement, Object parameter, ResultHandler handler) {
		this.getSqlSessionQueryTemplate().select(statement, parameter, handler);
	}

	/**
	 * 从库查询
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public void select(String statement, Object parameter, RowBounds rowBounds,
			ResultHandler handler) {
		this.getSqlSessionQueryTemplate().select(statement, parameter, rowBounds, handler);
	}

	/**
	 * 主库插入
	 */
	
	public int insert(String statement) {
		return this.getSqlSessionTemplate().insert(statement);
	}

	/**
	 * 主库插入
	 */
	public int insert(String statement, Object parameter) {
		return this.getSqlSessionTemplate().insert(statement, parameter);
	}
	
	public <T> int insert(T target) {
		return insert(getMapperName(target.getClass())+INSERT_SELECTIVE_ID, target);
	}
	public <T> int insert(List<T> target) {
		return insert(getMapperName(target.get(0).getClass())+INSERT_BATCH_ID, target);
	}

	/**
	 * 主库更新
	 */
	public int update(String statement) {
		return this.getSqlSessionTemplate().update(statement);
	}

	/**
	 * 主库更新
	 */
	public int update(String statement, Object parameter) {
		if(parameter != null){
			return this.getSqlSessionTemplate().update(statement, parameter);
		}
		return 0;
	}
	
	

	/**
	 * 主库删除
	 */
	public int delete(String statement) {
		return this.getSqlSessionTemplate().delete(statement);
	}

	/**
	 * 主库删除
	 */
	public int delete(String statement, Object parameter) {
		if(parameter != null){
			return this.getSqlSessionTemplate().delete(statement, parameter);
		}
		return 0;
	}
	
	public int deleteByParamsObjs(Object params){
		return delete(getMapperName(params.getClass())+DELETE_BY_MAP_ID, convertBeanToMap(params));
	}

	/**
	 * 主库查询(查询及时信息)
	 * @param <T>
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> List<T> selectMasterList(String statement, Object parameter) {
		return (List<T>)this.getSqlSessionTemplate().selectList(statement, parameter);
	}
	
	/**
	 * 主库查询(查询及时信息)
	 * @param <T>
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> List<T> selectMasterList(String statement) {
		return (List<T>)this.getSqlSessionTemplate().selectList(statement);
	}
	
	/**
	 * 主库查询(查询及时信息)
	 * @param <T>
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> T selectMasterOne(String statement, Object parameter) {
		return (T)this.getSqlSessionTemplate().selectOne(statement, parameter);
	}

	/**
	 * 查询分页（从库）
	 * @param <T>
	 * 
	 * @param params
	 *            参数对象
	 * @param query
	 *            查询query
	 * @param countSql
	 *            总记录数的查询sqlid 返回结果是int类型
	 * @param dataSql
	 *            结果集的查询sqlid
	 * @return
	 */
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> PageFinder<T> getPageFinderObjs(Object params, Query query,String countSql, String dataSql) {
		int count = (Integer) getSqlSessionQueryTemplate().selectOne(countSql, params);
		List<T> datas = (List<T>) getSqlSessionQueryTemplate().selectList(dataSql, params,new RowBounds(query.getOffset(), query.getPageSize()));
		PageFinder<T> pageFinder = new PageFinder<T>(query.getPage(),query.getPageSize(), count, datas);
		return pageFinder;
	}
	
	
	/**
	 * 查询分页（主库）
	 * @param <T>
	 * 
	 * @param params
	 *            参数对象
	 * @param query
	 *            查询query
	 * @param countSql
	 *            总记录数的查询sqlid 返回结果是int类型
	 * @param dataSql
	 *            结果集的查询sqlid
	 * @return
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public <T> PageFinder<T> getMasterPageFinderObjs(Object params, Query query,String countSql, String dataSql) {
		int count = (Integer) getSqlSessionTemplate().selectOne(countSql, params);
		List<T> datas = (List<T>) getSqlSessionTemplate().selectList(dataSql, params,new RowBounds(query.getOffset(), query.getPageSize()));
		PageFinder<T> pageFinder = null;
		if(count>0) {
			pageFinder = new PageFinder<T>(query.getPage(),query.getPageSize(), count, datas);
		}else{
			pageFinder = new PageFinder<T>(1,query.getPageSize(), 0);
		}
		return pageFinder;
	}
	
	
	
	/**
	 * 根据参数构造map，参数必须为偶数个，依次为key1，value1，key2，value2……. key是Bean 的属性字段
	 * @param datas 参数列表
	 * @return 构造出的map
	 */
	protected Map map(final Object... datas) {
		Assert.isTrue(datas.length % 2 == 0, "参数必须为偶数个");
		final Map map = new HashMap();
		for (int i = 0; i < datas.length; i += 2) {
			map.put(datas[i], datas[i + 1]);
		}
		return map;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String, Object> convertBeanToMap(Object bean){ 
		Map<String, Object> returnMap = new HashMap<String, Object>(); 
		if(bean == null){
			return returnMap;
		}
		if(bean instanceof Map){
			return (Map<String, Object>)bean;
		}
        Class type = bean.getClass(); 
        try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type); 
			PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors(); 
			for (int i = 0; i< propertyDescriptors.length; i++) { 
			    PropertyDescriptor descriptor = propertyDescriptors[i]; 
			    String propertyName = descriptor.getName(); 
			    if (!propertyName.equals("class")) { 
			        Method readMethod = descriptor.getReadMethod(); 
			        Object result = readMethod.invoke(bean, new Object[0]); 
			        if (result != null) { 
			        	if(result instanceof String && StringUtils.isEmpty(result.toString())){
			        		continue;
			        	}
			            returnMap.put(propertyName, result); 
			        }
			    } 
			}
		} catch (Exception e) {
			throw new RuntimeException("将 JavaBean : " + bean.getClass().getSimpleName() + " 转化为 Map失败！");
		}
        return returnMap; 
    }

	public <PK, T> T get(PK key, Class<T> clzss) {
		return this.selectOne(getMapperName(clzss)+SELECT_BY_PRIMARYKEY_ID, key);
	}

	public <T> T get(T bean) {
		return selectOne(getMapperName(bean.getClass())+SELECT_GET_ALL_ID, convertBeanToMap(bean));
	}

	
	public <T> List<T> getList(T bean) {
		return selectList(getMapperName(bean.getClass())+SELECT_GET_ALL_ID, convertBeanToMap(bean));
	}

	
	public <T> T get(Class<T> clzss,Object... keyValueParams) {
		return selectOne(getMapperName(clzss)+SELECT_GET_ALL_ID, map(keyValueParams));
	}

	
	public <PK, T> int delete(PK key, Class<T> clzss) {
		return delete(getMapperName(clzss)+DELETE_BY_PRIMARYKEY_ID, key);
	}

	
	public <T> int delete(T bean) {
		return delete(getMapperName(bean.getClass())+DELETE_BY_MAP_ID, convertBeanToMap(bean));
	}

	
	public <T> int delete(Class<T> clzss,Object... params) {
		return delete(getMapperName(clzss)+DELETE_BY_MAP_ID,map(params));
	}

	
	public <T> int save(T bean) {
		return insert(getMapperName(bean.getClass())+INSERT_SELECTIVE_ID, bean);
	}

	
	public <T> int save(List<T> beanList) {
		return insert(getMapperName(beanList.get(0).getClass())+INSERT_BATCH_ID, beanList);
	}

	
	public <T> int update(T target) {
		return update(getMapperName(target.getClass())+UPDATE_BY_PRIMARYKEY_ID, target);
	}

	
	public <PK, T> T getFromMaster(PK key, Class<T> clzss) {
		return selectMasterOne(getMapperName(clzss)+SELECT_BY_PRIMARYKEY_ID, key);
	}

	
	public <T> T getFromMaster(T bean) {
		return selectMasterOne(getMapperName(bean.getClass())+SELECT_GET_ALL_ID, convertBeanToMap(bean));
	}

	
	public <T> List<T> getListFromMaster(T bean) {
		return selectMasterList(getMapperName(bean.getClass())+SELECT_GET_ALL_ID, convertBeanToMap(bean));
	}

	
	public <T> T getFromMaster(Class<T> clzss,Object... keyValueParams) {
		return selectMasterOne(getMapperName(clzss)+SELECT_GET_ALL_ID, map(keyValueParams));
	}

	
	public <T> List<T> getListFromMaster(Class<T> clzss,Object... keyValueParams) {
		return selectMasterList(getMapperName(clzss)+SELECT_GET_ALL_ID, map(keyValueParams));
	}

	
	public <PK, T> List<T> get(List<PK> key, Class<T> clzss) {
		return selectList(getMapperName(clzss)+SELECT_BY_IDS_ID, key);
	}

	
	public <PK, T> int delete(List<PK> key, Class<T> clzss) {
		return delete(getMapperName(clzss)+DELETE_BY_IDS_ID, key);
	}

	
	public <PK, T> List<T> getFromMaster(List<PK> key, Class<T> clzss) {
		return selectMasterList(getMapperName(clzss)+SELECT_BY_IDS_ID, key);
	}

	
	public <T> List<T> getByMapParameters(Map map, Class<T> clzss) {
		return selectList(getMapperName(clzss)+SELECT_GET_ALL_ID, map);
	}

	
	public <T> List<T> getList(Class<T> clzss, Object... params) {
		return selectList(getMapperName(clzss)+SELECT_GET_ALL_ID, map(params));
	}

	
	public <T> PageFinder<T> findMasterPageFinder(T bean, Query query) {
		return getMasterPageFinderObjs(convertBeanToMap(bean), query, getMapperName(bean.getClass())+SELECT_PAGECOUNT_ID, getMapperName(bean.getClass())+SELECT_PAGEDATA_ID);

	}
	
	
	public <T> PageFinder<T> findPageFinder(T bean, Query query) {
		Map params = convertBeanToMap(bean);
		return getPageFinderObjs(params, query, getMapperName(bean.getClass())+SELECT_PAGECOUNT_ID, getMapperName(bean.getClass())+SELECT_PAGEDATA_ID);
	}


}
