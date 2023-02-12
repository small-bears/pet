package com.dao;

import com.entity.ChongwuyongpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwuyongpinVO;
import com.entity.view.ChongwuyongpinView;


/**
 * 宠物用品
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
public interface ChongwuyongpinDao extends BaseMapper<ChongwuyongpinEntity> {
	
	List<ChongwuyongpinVO> selectListVO(@Param("ew") Wrapper<ChongwuyongpinEntity> wrapper);
	
	ChongwuyongpinVO selectVO(@Param("ew") Wrapper<ChongwuyongpinEntity> wrapper);
	
	List<ChongwuyongpinView> selectListView(@Param("ew") Wrapper<ChongwuyongpinEntity> wrapper);

	List<ChongwuyongpinView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwuyongpinEntity> wrapper);
	
	ChongwuyongpinView selectView(@Param("ew") Wrapper<ChongwuyongpinEntity> wrapper);
	
}
