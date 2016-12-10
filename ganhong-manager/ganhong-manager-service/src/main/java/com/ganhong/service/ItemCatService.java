package com.ganhong.service;

import java.util.List;

import com.ganhong.common.pojo.EasyUITreeNode;


public interface ItemCatService {

	List<EasyUITreeNode> getItemCatList(long parentId);
}
