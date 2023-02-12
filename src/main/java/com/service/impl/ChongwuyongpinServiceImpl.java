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


import com.dao.ChongwuyongpinDao;
import com.entity.ChongwuyongpinEntity;
import com.service.ChongwuyongpinService;
import com.entity.vo.ChongwuyongpinVO;
import com.entity.view.ChongwuyongpinView;

@Service("chongwuyongpinService")
public class ChongwuyongpinServiceImpl extends ServiceImpl<ChongwuyongpinDao, ChongwuyongpinEntity> implements ChongwuyongpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwuyongpinEntity> page = this.selectPage(
                new Query<ChongwuyongpinEntity>(params).getPage(),
                new EntityWrapper<ChongwuyongpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwuyongpinEntity> wrapper) {
		  Page<ChongwuyongpinView> page =new Query<ChongwuyongpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwuyongpinVO> selectListVO(Wrapper<ChongwuyongpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwuyongpinVO selectVO(Wrapper<ChongwuyongpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwuyongpinView> selectListView(Wrapper<ChongwuyongpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwuyongpinView selectView(Wrapper<ChongwuyongpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
