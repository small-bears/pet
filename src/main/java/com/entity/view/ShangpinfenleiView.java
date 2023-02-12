package com.entity.view;

import com.entity.ShangpinfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商品分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
@TableName("shangpinfenlei")
public class ShangpinfenleiView  extends ShangpinfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangpinfenleiView(){
	}
 
 	public ShangpinfenleiView(ShangpinfenleiEntity shangpinfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, shangpinfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
