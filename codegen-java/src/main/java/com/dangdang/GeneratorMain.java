package com.dangdang;

import com.dangdang.generator.GeneratorFacade;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(final String[] args) throws Exception {
		final GeneratorFacade g = new GeneratorFacade();
//		 g.printAllTableNames(); //打印数据库中的表名称
	  //   g.clean(); // 删除生成器的输出目录
		 g.generateByTable("upload_img","UploadImg");
//		g.generateByTable("package_item");
		// g.generateByTable("CATEGORY"); //通过数据库表生成文件,注意: oracle
		// 需要指定schema及注意表名的大小写.
		// g.generateByTable("DOC_SOURCE");
		// g.generateByTable("table_name","TableName"); //通过数据库表生成文件,并可以自定义类名
		// g.generateByAllTable(); //自动搜索数据库中的所有表并生成文件
		// g.generateByClass(Blog.class);
	}
}
