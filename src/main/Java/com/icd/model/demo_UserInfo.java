package com.icd.model;


/**
 * @author 李耀华
 * @since 2020年7月8日
 * 实体类实现示例
 */

//demo示例用户表
public class demo_UserInfo {
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_pass;
	private String node_pass;
	private int user_role;
	private String reg_time;
	private String lastlogin_time;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getNode_pass() {
		return node_pass;
	}
	public void setNode_pass(String node_pass) {
		this.node_pass = node_pass;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}
	public String getReg_time() {
		return reg_time;
	}
	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}
	public String getLastlogin_time() {
		return lastlogin_time;
	}
	public void setLastlogin_time(String lastlogin_time) {
		this.lastlogin_time = lastlogin_time;
	}
	
}
