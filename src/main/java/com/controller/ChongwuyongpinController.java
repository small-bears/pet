package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChongwuyongpinEntity;
import com.entity.view.ChongwuyongpinView;

import com.service.ChongwuyongpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 宠物用品
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-16 09:02:05
 */
@RestController
@RequestMapping("/chongwuyongpin")
public class ChongwuyongpinController {
    @Autowired
    private ChongwuyongpinService chongwuyongpinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){

        EntityWrapper<ChongwuyongpinEntity> ew = new EntityWrapper<ChongwuyongpinEntity>();
		PageUtils page = chongwuyongpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuyongpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){
        EntityWrapper<ChongwuyongpinEntity> ew = new EntityWrapper<ChongwuyongpinEntity>();
		PageUtils page = chongwuyongpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuyongpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwuyongpinEntity chongwuyongpin){
       	EntityWrapper<ChongwuyongpinEntity> ew = new EntityWrapper<ChongwuyongpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwuyongpin, "chongwuyongpin")); 
        return R.ok().put("data", chongwuyongpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwuyongpinEntity chongwuyongpin){
        EntityWrapper< ChongwuyongpinEntity> ew = new EntityWrapper< ChongwuyongpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwuyongpin, "chongwuyongpin")); 
		ChongwuyongpinView chongwuyongpinView =  chongwuyongpinService.selectView(ew);
		return R.ok("查询宠物用品成功").put("data", chongwuyongpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwuyongpinEntity chongwuyongpin = chongwuyongpinService.selectById(id);
		chongwuyongpin.setClicknum(chongwuyongpin.getClicknum()+1);
		chongwuyongpin.setClicktime(new Date());
		chongwuyongpinService.updateById(chongwuyongpin);
        return R.ok().put("data", chongwuyongpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwuyongpinEntity chongwuyongpin = chongwuyongpinService.selectById(id);
		chongwuyongpin.setClicknum(chongwuyongpin.getClicknum()+1);
		chongwuyongpin.setClicktime(new Date());
		chongwuyongpinService.updateById(chongwuyongpin);
        return R.ok().put("data", chongwuyongpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){
    	chongwuyongpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwuyongpin);

        chongwuyongpinService.insert(chongwuyongpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){
    	chongwuyongpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwuyongpin);

        chongwuyongpinService.insert(chongwuyongpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwuyongpin);
        chongwuyongpinService.updateById(chongwuyongpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongwuyongpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ChongwuyongpinEntity> wrapper = new EntityWrapper<ChongwuyongpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = chongwuyongpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChongwuyongpinEntity chongwuyongpin, HttpServletRequest request,String pre){
        EntityWrapper<ChongwuyongpinEntity> ew = new EntityWrapper<ChongwuyongpinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = chongwuyongpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuyongpin), params), params));
        return R.ok().put("data", page);
    }


}
