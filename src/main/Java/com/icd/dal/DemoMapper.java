package com.icd.dal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.icd.idal.IDemoMapper;
import com.icd.model.demo_UserInfo;
import com.icd.mybatisunit.MyBatisUtil;

/**
 * @author 李耀华
 * @since 2020年7月8日
 * 接口方法实现示例
 */

public class DemoMapper {
	// 创建SqlSession对象的实例
	SqlSession session =MyBatisUtil.getsqlSession(true);
	// IDemoMapper接口通过sqlsession的getmap方法,完成实现,全部自动化
	IDemoMapper mapper = session.getMapper(IDemoMapper.class);
	
	
	//查询方法
	public List<demo_UserInfo> getAllUsers(){
		//标准写法
//		List<demo_UserInfo> users =mapper.getAllUsers();
//		session.close();
//		return users;
		
		//简化写法：
		return mapper.getAllUsers();
	}
	
	//
	public int insertDemoUser(demo_UserInfo user) {
		return mapper.insertDemoUser(user);
	}
}
