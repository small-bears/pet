package com.entity.view;

import com.entity.DiscusschongwuguashiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物挂失评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
@TableName("discusschongwuguashi")
public class DiscusschongwuguashiView  extends DiscusschongwuguashiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusschongwuguashiView(){
	}
 
 	public DiscusschongwuguashiView(DiscusschongwuguashiEntity discusschongwuguashiEntity){
 	try {
			BeanUtils.copyProperties(this, discusschongwuguashiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
