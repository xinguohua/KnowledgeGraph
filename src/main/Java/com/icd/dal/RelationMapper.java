package com.icd.dal;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.icd.idal.IRelationMapper;
import com.icd.model.RelationInfo;
import com.icd.model.json_Relation;
import com.icd.mybatisunit.MyBatisUtil;

/**
 * @author 李耀华
 * @since 2020年8月22日
 * 接口方法实现示例
 */
public class RelationMapper {
	// 创建SqlSession对象的实例
	SqlSession session = MyBatisUtil.getsqlSession(true);
	// IDemoMapper接口通过sqlsession的getmap方法,完成实现,全部自动化
	IRelationMapper mapper = session.getMapper(IRelationMapper.class);
	
	/**
	 * 根据关键字查询方法
	 * 示例
	 * */
	public List<RelationInfo> getRelationInfoByName(String name){
		return mapper.getRelationInfoByName(name);
	}
	
	
	/**
	 * 生成json数据格式方法
	 * 示例
	 * */
	public List<json_Relation> relationData(List<RelationInfo> list,String name){
		List<json_Relation> jsonData=new ArrayList<json_Relation>();
		json_Relation keys=new json_Relation();
		keys.setName(name);
		keys.setRelation(name);
		jsonData.add(keys);
		
		for(RelationInfo item:list) {
			json_Relation json=new json_Relation();
			json.setName(item.getDescript());
			json.setRelation(item.getRelation());
			
			jsonData.add(json);
		}
		
		return jsonData;
	}
	
	
	//封装方法
	public List<json_Relation> getRelationData(String name){
		return relationData(getRelationInfoByName(name),name);
	}
	
	
	
	
}
