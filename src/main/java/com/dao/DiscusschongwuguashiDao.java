package com.dao;

import com.entity.DiscusschongwuguashiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschongwuguashiVO;
import com.entity.view.DiscusschongwuguashiView;


/**
 * 宠物挂失评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
public interface DiscusschongwuguashiDao extends BaseMapper<DiscusschongwuguashiEntity> {
	
	List<DiscusschongwuguashiVO> selectListVO(@Param("ew") Wrapper<DiscusschongwuguashiEntity> wrapper);
	
	DiscusschongwuguashiVO selectVO(@Param("ew") Wrapper<DiscusschongwuguashiEntity> wrapper);
	
	List<DiscusschongwuguashiView> selectListView(@Param("ew") Wrapper<DiscusschongwuguashiEntity> wrapper);

	List<DiscusschongwuguashiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschongwuguashiEntity> wrapper);
	
	DiscusschongwuguashiView selectView(@Param("ew") Wrapper<DiscusschongwuguashiEntity> wrapper);
	
}
