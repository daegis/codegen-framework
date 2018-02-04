package com.dangdang.digital.service;


import com.dangdang.digital.dao.ICommonDao;
import com.dangdang.digital.dao.IMapper;
/**
 * 
 * @author lvxiang
 * @date   2015年5月13日 下午5:18:03
 * 通用Service
 */
public interface ICommonService extends IMapper {
	public ICommonDao getCommonDao();
}
