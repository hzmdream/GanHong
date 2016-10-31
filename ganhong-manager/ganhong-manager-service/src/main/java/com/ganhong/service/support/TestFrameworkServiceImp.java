package com.ganhong.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganhong.mapper.TbItemMapper;
import com.ganhong.pojo.TbItem;
import com.ganhong.service.TestFrameworkService;

@Service("testFrameworkServiceImp")
public class TestFrameworkServiceImp implements TestFrameworkService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem selectByPrimaryKey(Long id) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		return tbItem;
	}


}
