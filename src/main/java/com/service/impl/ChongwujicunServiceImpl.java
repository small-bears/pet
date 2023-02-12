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


import com.dao.ChongwujicunDao;
import com.entity.ChongwujicunEntity;
import com.service.ChongwujicunService;
import com.entity.vo.ChongwujicunVO;
import com.entity.view.ChongwujicunView;

@Service("chongwujicunService")
public class ChongwujicunServiceImpl extends ServiceImpl<ChongwujicunDao, ChongwujicunEntity> implements ChongwujicunService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwujicunEntity> page = this.selectPage(
                new Query<ChongwujicunEntity>(params).getPage(),
                new EntityWrapper<ChongwujicunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwujicunEntity> wrapper) {
		  Page<ChongwujicunView> page =new Query<ChongwujicunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwujicunVO> selectListVO(Wrapper<ChongwujicunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwujicunVO selectVO(Wrapper<ChongwujicunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwujicunView> selectListView(Wrapper<ChongwujicunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwujicunView selectView(Wrapper<ChongwujicunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
