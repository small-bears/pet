package com.entity.vo;

import com.entity.ChatEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 客服聊天表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-16 09:02:06
 */
public class ChatVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 管理员id
	 */
	
	private Long adminid;
		
	/**
	 * 提问
	 */
	
	private String ask;
		
	/**
	 * 回复
	 */
	
	private String reply;
		
	/**
	 * 是否回复
	 */
	
	private Integer isreply;
				
	
	/**
	 * 设置：管理员id
	 */
	 
	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}
	
	/**
	 * 获取：管理员id
	 */
	public Long getAdminid() {
		return adminid;
	}
				
	
	/**
	 * 设置：提问
	 */
	 
	public void setAsk(String ask) {
		this.ask = ask;
	}
	
	/**
	 * 获取：提问
	 */
	public String getAsk() {
		return ask;
	}
				
	
	/**
	 * 设置：回复
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * 获取：回复
	 */
	public String getReply() {
		return reply;
	}
				
	
	/**
	 * 设置：是否回复
	 */
	 
	public void setIsreply(Integer isreply) {
		this.isreply = isreply;
	}
	
	/**
	 * 获取：是否回复
	 */
	public Integer getIsreply() {
		return isreply;
	}
			
}
