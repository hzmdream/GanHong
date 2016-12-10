package com.ganhong.test.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ganhong.mapper.TbItemMapper;
import com.ganhong.pojo.TbItem;
import com.ganhong.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestPageHelper {

	@Test
	public void pageHelperTest(){
		//获取mapper代理对象
		ApplicationContext apc = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper tbItemMapper = (TbItemMapper) apc.getBean(TbItemMapper.class);
		//设置分页
		PageHelper.startPage(1, 30);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//取出分页结果
		PageInfo<TbItem> pageInfo  = new PageInfo<TbItem>(list);
		//查询结果中的记录数
		long total = pageInfo.getTotal();
		System.out.println("查询结果中的记录数："+total);
		//查询的结果有多少页
		int pages = pageInfo.getPages();
		System.out.println("查询的结果有多少页："+pages);
		//一页有几条记录数
		int pageSize = pageInfo.getPageSize();
		System.out.println("一页有几条记录数："+pageSize);
	}
}
