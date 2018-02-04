package com.dangdang.db;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.dangdang.db.model.Table;
import com.dangdang.generator.IGeneratorModelProvider;
/**
 * 
 * @author badqiu
 *
 */
public class DbTableGeneratorModelProvider implements IGeneratorModelProvider {
	Table table;
	
	public DbTableGeneratorModelProvider(Table table) {
		super();
		String name =table.getSqlName();
		//table.setTableName(name.substring(name.indexOf("_")+1));
		this.table = table;
		
	}

	public String getDisaplyText() {
		return table.toString();
	}

	public void mergeFilePathModel(Map model) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		model.putAll(BeanUtils.describe(table));
	}

	public void mergeTemplateModel(Map model) {
		model.put("table",table);
	}

}
