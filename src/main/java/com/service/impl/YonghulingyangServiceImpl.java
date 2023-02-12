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


import com.dao.YonghulingyangDao;
import com.entity.YonghulingyangEntity;
import com.service.YonghulingyangService;
import com.entity.vo.YonghulingyangVO;
import com.entity.view.YonghulingyangView;

@Service("yonghulingyangService")
public class YonghulingyangServiceImpl extends ServiceImpl<YonghulingyangDao, YonghulingyangEntity> implements YonghulingyangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghulingyangEntity> page = this.selectPage(
                new Query<YonghulingyangEntity>(params).getPage(),
                new EntityWrapper<YonghulingyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghulingyangEntity> wrapper) {
		  Page<YonghulingyangView> page =new Query<YonghulingyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghulingyangVO> selectListVO(Wrapper<YonghulingyangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghulingyangVO selectVO(Wrapper<YonghulingyangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghulingyangView> selectListView(Wrapper<YonghulingyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghulingyangView selectView(Wrapper<YonghulingyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
