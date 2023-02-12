package com.dao;

import com.entity.ChongwujicunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwujicunVO;
import com.entity.view.ChongwujicunView;


/**
 * 宠物寄存
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
public interface ChongwujicunDao extends BaseMapper<ChongwujicunEntity> {
	
	List<ChongwujicunVO> selectListVO(@Param("ew") Wrapper<ChongwujicunEntity> wrapper);
	
	ChongwujicunVO selectVO(@Param("ew") Wrapper<ChongwujicunEntity> wrapper);
	
	List<ChongwujicunView> selectListView(@Param("ew") Wrapper<ChongwujicunEntity> wrapper);

	List<ChongwujicunView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwujicunEntity> wrapper);
	
	ChongwujicunView selectView(@Param("ew") Wrapper<ChongwujicunEntity> wrapper);
	
}
