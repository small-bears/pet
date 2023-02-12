package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwujicunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwujicunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwujicunView;


/**
 * 宠物寄存
 *
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
public interface ChongwujicunService extends IService<ChongwujicunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwujicunVO> selectListVO(Wrapper<ChongwujicunEntity> wrapper);
   	
   	ChongwujicunVO selectVO(@Param("ew") Wrapper<ChongwujicunEntity> wrapper);
   	
   	List<ChongwujicunView> selectListView(Wrapper<ChongwujicunEntity> wrapper);
   	
   	ChongwujicunView selectView(@Param("ew") Wrapper<ChongwujicunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwujicunEntity> wrapper);
   	
}

