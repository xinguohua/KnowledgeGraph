package com.icd.controller;

import java.io.Console;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icd.annotation.SystemControllerLog;
import com.icd.dal.RelationMapper;
import com.icd.model.RelationInfo;
import com.icd.model.demo_User;
import com.icd.model.json_Relation;
import com.icd.unti.ResultUtil;

//注解当前类为控制器
@Controller
public class RelationController {
	
	RelationMapper mapper=new RelationMapper();
	/**
	 * 创建请求图谱结构数据
	 * 带返回值
	 * */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/getrelationbyname", method = RequestMethod.POST)
	public Object getRelationByName(@RequestBody String name) {		
		if(name==null) {
			name = "安倍晋三";
		}
		List<json_Relation> list= mapper.getRelationData(name);		
		return ResultUtil.success(list, "请求成功");	
	}
}
