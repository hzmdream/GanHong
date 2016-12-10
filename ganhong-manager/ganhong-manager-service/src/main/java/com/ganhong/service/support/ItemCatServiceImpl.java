package com.ganhong.service.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganhong.common.pojo.EasyUITreeNode;
import com.ganhong.mapper.TbItemCatMapper;
import com.ganhong.pojo.TbItemCat;
import com.ganhong.pojo.TbItemCatExample;
import com.ganhong.pojo.TbItemCatExample.Criteria;
import com.ganhong.service.ItemCatService;
@Service("itemCatServiceImpl")
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		//根据parentId查询分类
		TbItemCatExample tbItemCatExample = new TbItemCatExample();
		Criteria createCriteria = tbItemCatExample.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		List<TbItemCat> selectByExample = tbItemCatMapper.selectByExample(tbItemCatExample);
		//创建返回的集合
		List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
		//转换为easyUI需要的数据格式
		for (TbItemCat tbItemCat : selectByExample) {
			EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
			easyUITreeNode.setId(tbItemCat.getId());
			easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			easyUITreeNode.setText(tbItemCat.getName());
			resultList.add(easyUITreeNode);
		}
		return resultList;
	}
	
}
