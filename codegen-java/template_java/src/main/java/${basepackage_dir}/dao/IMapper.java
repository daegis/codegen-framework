package com.dangdang.digital.dao;

import java.util.List;
import java.util.Map;

import com.dangdang.digital.utils.PageFinder;
import com.dangdang.digital.utils.Query;

/**
 * 数据库操作常用方法定义,定义Mapper文件中常用id 值
 * @author lvxiang
 * @date   2015年5月14日 下午4:05:56
 * 
 */
public interface IMapper {
	/**
	 * Mapper 文件命名规则,BeanClasName+Mapper
	 */
	 String Mapper = "Mapper";
	 
	//下面定义的常量为Mapper中常用到 sql Id,必须与*Mapper.xml  sql Id对应才可以使用
	 
	 
	/** 查询所有数据的 select id **/
	String SELECT_GET_ALL_ID ="getAll";
	/** 通过主键查询sql id**/
	String SELECT_BY_PRIMARYKEY_ID ="selectByPrimaryKey";
	/** 通过主键删除sql id **/
	String DELETE_BY_PRIMARYKEY_ID = "deleteByPrimaryKey";
	
	/** 通过主键更新 update id **/
	 String UPDATE_BY_PRIMARYKEY_ID ="updateByPrimaryKeySelective";
	
	
	/** 选择性插入 insert id **/
	 String INSERT_SELECTIVE_ID ="insertSelective";
	
	
	/** 批量插入 insert id **/
	 String INSERT_BATCH_ID ="insertBatch";
	
	/** 根据Map 参数删除 delete id **/
	 String DELETE_BY_MAP_ID ="deleteByMap";
	 
	 /** 获取总条数**/
	 String SELECT_PAGECOUNT_ID =  "pageCount";
	 
	 String SELECT_PAGEDATA_ID =  "pageData";
	 
	 String SELECT_BY_IDS_ID = "selectByIds";
	 
	 String DELETE_BY_IDS_ID = "deleteByIds";
	
	 /**
	  * 返回class(T类型)对应的Mapper文件名称
	  * @param clzss
	  * @return
	  */
	 public <T> String getMapperName(Class<T> clzss);
	 
	 
	 /*************************************常用方法************************************************/
		
		/** 从库操作**/
		/**
		 * PK 主键
		 * 根据主键查询对应的实体Bean
		 * @param key
		 * @param clzss  实体Bean Class
		 * @return
		 */
		public <PK,T> T get(final PK key,Class<T> clzss);
		
		
		public <PK,T> List<T> get(final List<PK> key,Class<T> clzss);
		
		/**
		 * 根据Bean 实体参数,返回唯一Bean
		 * @param bean 具体Bean 对象
		 * @return
		 */
		public <T> T get(T bean);
		
		
		public <T> List<T> getByMapParameters(Map map, Class<T> clzss);
		
		/**
		 * 根据Bean 实体参数,返回Bean List
		 * @param bean 具体Bean 对象
		 * @return
		 */
		public <T>   List<T> getList(T bean);
		
		/**
		 * 根据 key-value 实体参数,返回唯一Bean
		 * @param bean
		 * @return
		 */
		public <T> T get(Class<T> clzss,Object ... keyValueParams);
		
		/**
		 * 根据 key-value 参数对,返回Bean List
		 * @param bean
		 * @return
		 */
		
		public <T> List<T> getList(Class<T> clzss, Object... keyValueParams);
		
		/**
		 * 删除 clzss 对应表中 主键为 key的记录
		 * @param key 
		 * @param clzss
		 * @return
		 */
		public <PK,T>  int delete(final PK key,Class<T> clzss);
		
		public <PK,T>  int delete(final List<PK> key,Class<T> clzss);
		
		/**
		 * 根据bean 参数删除bean对应表的符合条件的记录
		 * @param bean
		 * @return
		 */
		public <T> int delete(T bean);
		
		/**
		 * 根据 key-value 参数 删除Bean对应数据表符合条件的记录
		 * @param clzss
		 * @param params
		 * @return
		 */
		public <T> int delete(Class<T> clzss, Object... params );
		
		/**
		 * 根据bean 参数更新bean 对应数据表符合条件记录
		 * @param bean
		 * @return
		 */
		public <T> int update(T bean);
		
		
		public <T> int save(T bean);
		
		
		public <T> int save(List<T> beanList);
		
		
		/** 主库操作**/
		public <PK,T> T getFromMaster(final PK key,Class<T> clzss);
		
		public <PK,T> List<T> getFromMaster(final List<PK> key,Class<T> clzss);
		
		/**
		 * 根据Bean 实体参数,返回唯一Bean
		 * @param bean 具体Bean 对象
		 * @return
		 */
		public <T> T getFromMaster(T bean);
		
		/**
		 * 根据Bean 实体参数,返回Bean List
		 * @param bean 具体Bean 对象
		 * @return
		 */
		public <T>   List<T> getListFromMaster(T bean);
		
		/**
		 * 根据 key-value 实体参数,返回唯一Bean
		 * @param bean
		 * @return
		 */
		public <T> T getFromMaster(Class<T> clzss,Object ... keyValueParams);
		
		/**
		 * 根据 key-value 参数对,返回Bean List
		 * @param bean
		 * @return
		 */
		public <T>   List<T> getListFromMaster(Class<T> clzss, Object ... keyValueParams);
		
		
		public <T> PageFinder<T> findMasterPageFinder(T bean, Query query);
		
		
		public <T> PageFinder<T> findPageFinder(T bean, Query query);
}
