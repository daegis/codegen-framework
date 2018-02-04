package com.dangdang.digital.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.dangdang.digital.utils.PageFinder;
import com.dangdang.digital.utils.Query;

/**
 * @author lvxiang
 * @date   2015年5月13日 下午5:05:39
 * 通用Dao 接口
 */
public interface ICommonDao  extends IMapper{
	/**
	 * 从库查询
	 * @param <T>
	 */
	public <T> T selectOne(String statement);
	/**
	 * 从库查询
	 * @param <T>
	 */
	public <T> T selectOne(String statement, Object parameter);
	/**
	 * 从库查询
	 */	
	public Map<?, ?> selectMap(String statement, String mapKey);
	/**
	 * 从库查询
	 */	
	public Map<?, ?> selectMap(String statement, Object parameter, String mapKey);
	/**
	 * 从库查询
	 */	
	public Map<?, ?> selectMap(String statement, Object parameter,
			String mapKey, RowBounds rowBounds);
	/**
	 * 从库查询
	 * @param <T>
	 */	
	public <T> List<T> selectList(String statement);
	/**
	 * 从库查询
	 * @param <T>
	 */	
	public <T> List<T> selectList(String statement, Object parameter);
	/**
	 * 从库查询
	 * @param <T>
	 */	
	public <T> List<T> selectList(String statement, Object parameter,
			RowBounds rowBounds);
	/**
	 * 从库查询
	 */	
	public void select(String statement, ResultHandler handler);
	/**
	 * 从库查询
	 */	
	public void select(String statement, Object parameter, ResultHandler handler);
	/**
	 * 从库查询
	 */	
	public void select(String statement, Object parameter, RowBounds rowBounds,
			ResultHandler handler);
	
	
	/**
	 * 主库查询(查询及时信息)
	 * @param <T>
	 */	
	public <T> List<T> selectMasterList(String statement, Object parameter);
	/**
	 * 主库查询(查询及时信息)
	 * @param <T>
	 */	
	public <T> List<T> selectMasterList(String statement);
	/**
	 * 主库查询(查询及时信息)
	 * @param <T>
	 */	
	public <T> T selectMasterOne(String statement, Object parameter);
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
	public <T> PageFinder<T> getPageFinderObjs(Object params, Query query,String countSql, String dataSql);
	
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
	public <T> PageFinder<T> getMasterPageFinderObjs(Object params, Query query,String countSql, String dataSql);
	
	/**
	 * 主库插入
	 */	
	public int insert(String statement);
	/**
	 * 主库插入
	 */	
	public int insert(String statement, Object parameter);
	/**
	 * 主库更新
	 */	
	public int update(String statement);
	/**
	 * 主库更新
	 */	
	public int update(String statement, Object parameter);
	/**
	 * 主库删除
	 */	
	public int delete(String statement);
	/**
	 * 主库删除
	 */	
	public int delete(String statement, Object parameter);
	
}
