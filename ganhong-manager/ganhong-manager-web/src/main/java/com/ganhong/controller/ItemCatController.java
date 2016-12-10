package com.ganhong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganhong.common.pojo.EasyUITreeNode;
import com.ganhong.service.ItemCatService;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatServiceImpl;
	
	/**
	 * 显示商品分类
	 * easyUI
	 * 	前台传递数据：id
	 * 	后台返回数据：
	 * 				{
	 *				  "id":1,
	 *				  "text":"帽子",
	 * 				  "state":"closed"
	 * 				}
	 * @param parentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		return itemCatServiceImpl.getItemCatList(parentId);
	}
}
