package com.icd.idal;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.icd.model.demo_UserInfo;

/**
 * @author 李耀华
 * @since 2020年7月8日
 * 接口定义示例
 */

public interface IDemoMapper {	
	/**
	 * 查询方法
	 * 使用@Select 注解指明getAllUsers方法要执行的SQL
	 * */
	@Select("select * from demo_user_tb")
	public List<demo_UserInfo> getAllUsers();
	
	
	/**
	 * Insert方法
	 * 传参为对象方法
	 * */
	@Insert("insert into demo_user_tb(user_name,user_pass)value(#{user_name},#{user_pass})")
	public int insertDemoUser(demo_UserInfo user);
	
	/**
	 * 登录方法
	 * 传参为多个参数
	 * @Param("user_name")中user_name为数据表中的字段，方法参数可以与我们的字段命名不同，
	 * 但是为了书写规范，我们命名保持一致。
	 * */
	@Select("select * from demo_user_tb where user_name=#{user_name} and user_pass=#{user_pass}")
	public demo_UserInfo validateLogin(@Param("user_name") String user_name,@Param("user_pass") String user_pass);
	
	
	/**
	 * 更新方法
	 * 示例
	 * */
	@Update("update demo_user_tb set user_role=1 where user_name=#{user_name}")
	public int updateActivationStateByActivationCode(@Param("user_name") String user_name);
	
	
	/**
	 * 删除方法
	 * 示例
	 * */
	@Delete("delete from demo_user_tb where user_name=#{user_name}")
	public int deleteDemoUser(@Param("user_name") String user_name);	
	
	
	/**
	 * 调用存储过程
	 * statementType启用存储过程
	 * 示例
	 * */
	@Select("CALL 存储过程名")
	@Options(statementType = StatementType.CALLABLE)
	public demo_UserInfo getUserInfo(int id);
}
