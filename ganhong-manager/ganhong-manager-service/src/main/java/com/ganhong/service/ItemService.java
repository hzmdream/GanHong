package com.ganhong.service;

import com.ganhong.common.pojo.EasyUIDataGridResult;

public interface ItemService {
	EasyUIDataGridResult getItemList(int page,int rows);
	
}
