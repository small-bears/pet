package com.dao;

import com.entity.DiscusschongwulingyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschongwulingyangVO;
import com.entity.view.DiscusschongwulingyangView;


/**
 * 宠物领养评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
public interface DiscusschongwulingyangDao extends BaseMapper<DiscusschongwulingyangEntity> {
	
	List<DiscusschongwulingyangVO> selectListVO(@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);
	
	DiscusschongwulingyangVO selectVO(@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);
	
	List<DiscusschongwulingyangView> selectListView(@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);

	List<DiscusschongwulingyangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);
	
	DiscusschongwulingyangView selectView(@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);
	
}
