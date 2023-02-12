package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschongwuyongpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschongwuyongpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschongwuyongpinView;


/**
 * 宠物用品评论表
 *
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
public interface DiscusschongwuyongpinService extends IService<DiscusschongwuyongpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschongwuyongpinVO> selectListVO(Wrapper<DiscusschongwuyongpinEntity> wrapper);
   	
   	DiscusschongwuyongpinVO selectVO(@Param("ew") Wrapper<DiscusschongwuyongpinEntity> wrapper);
   	
   	List<DiscusschongwuyongpinView> selectListView(Wrapper<DiscusschongwuyongpinEntity> wrapper);
   	
   	DiscusschongwuyongpinView selectView(@Param("ew") Wrapper<DiscusschongwuyongpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschongwuyongpinEntity> wrapper);
   	
}

