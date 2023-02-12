package com.dao;

import com.entity.ChongwuguashiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwuguashiVO;
import com.entity.view.ChongwuguashiView;


/**
 * 宠物挂失
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
public interface ChongwuguashiDao extends BaseMapper<ChongwuguashiEntity> {
	
	List<ChongwuguashiVO> selectListVO(@Param("ew") Wrapper<ChongwuguashiEntity> wrapper);
	
	ChongwuguashiVO selectVO(@Param("ew") Wrapper<ChongwuguashiEntity> wrapper);
	
	List<ChongwuguashiView> selectListView(@Param("ew") Wrapper<ChongwuguashiEntity> wrapper);

	List<ChongwuguashiView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwuguashiEntity> wrapper);
	
	ChongwuguashiView selectView(@Param("ew") Wrapper<ChongwuguashiEntity> wrapper);
	
}
