package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschongwulingyangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschongwulingyangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschongwulingyangView;


/**
 * 宠物领养评论表
 *
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
public interface DiscusschongwulingyangService extends IService<DiscusschongwulingyangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschongwulingyangVO> selectListVO(Wrapper<DiscusschongwulingyangEntity> wrapper);
   	
   	DiscusschongwulingyangVO selectVO(@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);
   	
   	List<DiscusschongwulingyangView> selectListView(Wrapper<DiscusschongwulingyangEntity> wrapper);
   	
   	DiscusschongwulingyangView selectView(@Param("ew") Wrapper<DiscusschongwulingyangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschongwulingyangEntity> wrapper);
   	
}

