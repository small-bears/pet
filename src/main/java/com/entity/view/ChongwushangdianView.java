package com.entity.view;

import com.entity.ChongwushangdianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物商店
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
@TableName("chongwushangdian")
public class ChongwushangdianView  extends ChongwushangdianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChongwushangdianView(){
	}
 
 	public ChongwushangdianView(ChongwushangdianEntity chongwushangdianEntity){
 	try {
			BeanUtils.copyProperties(this, chongwushangdianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
