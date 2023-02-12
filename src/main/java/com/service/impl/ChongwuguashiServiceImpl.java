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


import com.dao.ChongwuguashiDao;
import com.entity.ChongwuguashiEntity;
import com.service.ChongwuguashiService;
import com.entity.vo.ChongwuguashiVO;
import com.entity.view.ChongwuguashiView;

@Service("chongwuguashiService")
public class ChongwuguashiServiceImpl extends ServiceImpl<ChongwuguashiDao, ChongwuguashiEntity> implements ChongwuguashiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwuguashiEntity> page = this.selectPage(
                new Query<ChongwuguashiEntity>(params).getPage(),
                new EntityWrapper<ChongwuguashiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwuguashiEntity> wrapper) {
		  Page<ChongwuguashiView> page =new Query<ChongwuguashiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwuguashiVO> selectListVO(Wrapper<ChongwuguashiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwuguashiVO selectVO(Wrapper<ChongwuguashiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwuguashiView> selectListView(Wrapper<ChongwuguashiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwuguashiView selectView(Wrapper<ChongwuguashiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
