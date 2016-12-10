package com.ganhong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganhong.common.pojo.EasyUIDataGridResult;
import com.ganhong.service.ItemService;

@Controller
public class TbItemController {

	@Autowired
	private ItemService itemServiceImpl;
	/**
	 * 显示TbItem分页查询结果
	 * 请求参数：page：第几页，rows：每页显示几行
	 * 相应数据：json  包含两个属性：Total：查询结果的总记录数，Rows：当前页所有记录，是一个集合，其中集合的key应该与easyUi中datagrid的field对应
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/item/list")
	public EasyUIDataGridResult list(@RequestParam("page") String page,
			@RequestParam("rows") String rows){
		EasyUIDataGridResult itemList = itemServiceImpl.getItemList(Integer.parseInt(page), Integer.parseInt(rows));
		return itemList;
	}
}
