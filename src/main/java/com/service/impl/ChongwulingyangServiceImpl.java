package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChongwulingyangDao;
import com.entity.ChongwulingyangEntity;
import com.service.ChongwulingyangService;
import com.entity.vo.ChongwulingyangVO;
import com.entity.view.ChongwulingyangView;

@Service("chongwulingyangService")
public class ChongwulingyangServiceImpl extends ServiceImpl<ChongwulingyangDao, ChongwulingyangEntity> implements ChongwulingyangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwulingyangEntity> page = this.selectPage(
                new Query<ChongwulingyangEntity>(params).getPage(),
                new EntityWrapper<ChongwulingyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwulingyangEntity> wrapper) {
		  Page<ChongwulingyangView> page =new Query<ChongwulingyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwulingyangVO> selectListVO(Wrapper<ChongwulingyangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwulingyangVO selectVO(Wrapper<ChongwulingyangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwulingyangView> selectListView(Wrapper<ChongwulingyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwulingyangView selectView(Wrapper<ChongwulingyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
