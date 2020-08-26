package com.icd.idal;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.icd.model.RelationInfo;

/**
 * @author 李耀华
 * @since 2020年8月22日
 * 接口定义示例
 */
public interface IRelationMapper {
	/**
	 * 根据关键字查询方法
	 * 示例
	 * */
	@Select("SELECT * from test_jp where name=#{name}")
	public List<RelationInfo> getRelationInfoByName(@Param("name") String name);
}
