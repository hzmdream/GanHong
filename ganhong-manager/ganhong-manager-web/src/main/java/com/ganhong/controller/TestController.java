package com.ganhong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganhong.pojo.TbItem;
import com.ganhong.service.TestFrameworkService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@Autowired
	private TestFrameworkService testFrameworkServiceImp;
	
	@ResponseBody
	@RequestMapping(value = "/gettbitembyid/{id}",method=RequestMethod.GET)
	public TbItem getTbItemById(@PathVariable Long id){
		System.out.println("iim coming in, and id="+id);
		TbItem tbItem = testFrameworkServiceImp.selectByPrimaryKey(id);
		System.out.println(tbItem);
		return tbItem;
	}
}
