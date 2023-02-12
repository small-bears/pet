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


import com.dao.DiscusschongwulingyangDao;
import com.entity.DiscusschongwulingyangEntity;
import com.service.DiscusschongwulingyangService;
import com.entity.vo.DiscusschongwulingyangVO;
import com.entity.view.DiscusschongwulingyangView;

@Service("discusschongwulingyangService")
public class DiscusschongwulingyangServiceImpl extends ServiceImpl<DiscusschongwulingyangDao, DiscusschongwulingyangEntity> implements DiscusschongwulingyangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschongwulingyangEntity> page = this.selectPage(
                new Query<DiscusschongwulingyangEntity>(params).getPage(),
                new EntityWrapper<DiscusschongwulingyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschongwulingyangEntity> wrapper) {
		  Page<DiscusschongwulingyangView> page =new Query<DiscusschongwulingyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusschongwulingyangVO> selectListVO(Wrapper<DiscusschongwulingyangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschongwulingyangVO selectVO(Wrapper<DiscusschongwulingyangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschongwulingyangView> selectListView(Wrapper<DiscusschongwulingyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschongwulingyangView selectView(Wrapper<DiscusschongwulingyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
