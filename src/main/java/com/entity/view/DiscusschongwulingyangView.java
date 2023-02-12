package com.entity.view;

import com.entity.DiscusschongwulingyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物领养评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
@TableName("discusschongwulingyang")
public class DiscusschongwulingyangView  extends DiscusschongwulingyangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusschongwulingyangView(){
	}
 
 	public DiscusschongwulingyangView(DiscusschongwulingyangEntity discusschongwulingyangEntity){
 	try {
			BeanUtils.copyProperties(this, discusschongwulingyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
