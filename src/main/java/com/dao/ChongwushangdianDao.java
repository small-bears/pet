package com.dao;

import com.entity.ChongwushangdianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwushangdianVO;
import com.entity.view.ChongwushangdianView;


/**
 * 宠物商店
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
public interface ChongwushangdianDao extends BaseMapper<ChongwushangdianEntity> {
	
	List<ChongwushangdianVO> selectListVO(@Param("ew") Wrapper<ChongwushangdianEntity> wrapper);
	
	ChongwushangdianVO selectVO(@Param("ew") Wrapper<ChongwushangdianEntity> wrapper);
	
	List<ChongwushangdianView> selectListView(@Param("ew") Wrapper<ChongwushangdianEntity> wrapper);

	List<ChongwushangdianView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwushangdianEntity> wrapper);
	
	ChongwushangdianView selectView(@Param("ew") Wrapper<ChongwushangdianEntity> wrapper);
	
}
