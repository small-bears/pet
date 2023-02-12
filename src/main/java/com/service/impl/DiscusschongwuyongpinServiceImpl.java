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


import com.dao.DiscusschongwuyongpinDao;
import com.entity.DiscusschongwuyongpinEntity;
import com.service.DiscusschongwuyongpinService;
import com.entity.vo.DiscusschongwuyongpinVO;
import com.entity.view.DiscusschongwuyongpinView;

@Service("discusschongwuyongpinService")
public class DiscusschongwuyongpinServiceImpl extends ServiceImpl<DiscusschongwuyongpinDao, DiscusschongwuyongpinEntity> implements DiscusschongwuyongpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschongwuyongpinEntity> page = this.selectPage(
                new Query<DiscusschongwuyongpinEntity>(params).getPage(),
                new EntityWrapper<DiscusschongwuyongpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschongwuyongpinEntity> wrapper) {
		  Page<DiscusschongwuyongpinView> page =new Query<DiscusschongwuyongpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusschongwuyongpinVO> selectListVO(Wrapper<DiscusschongwuyongpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschongwuyongpinVO selectVO(Wrapper<DiscusschongwuyongpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschongwuyongpinView> selectListView(Wrapper<DiscusschongwuyongpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschongwuyongpinView selectView(Wrapper<DiscusschongwuyongpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
