package com.dao;

import com.entity.YonghulingyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghulingyangVO;
import com.entity.view.YonghulingyangView;


/**
 * 用户领养
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
public interface YonghulingyangDao extends BaseMapper<YonghulingyangEntity> {
	
	List<YonghulingyangVO> selectListVO(@Param("ew") Wrapper<YonghulingyangEntity> wrapper);
	
	YonghulingyangVO selectVO(@Param("ew") Wrapper<YonghulingyangEntity> wrapper);
	
	List<YonghulingyangView> selectListView(@Param("ew") Wrapper<YonghulingyangEntity> wrapper);

	List<YonghulingyangView> selectListView(Pagination page,@Param("ew") Wrapper<YonghulingyangEntity> wrapper);
	
	YonghulingyangView selectView(@Param("ew") Wrapper<YonghulingyangEntity> wrapper);
	
}
