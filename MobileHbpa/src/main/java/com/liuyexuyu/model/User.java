package com.liuyexuyu.model;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

@SuppressWarnings("serial")
public class User extends BmobUser {
	// 父类中已经存在的属性
	// private String id;
	// private String username;
	// private String password;
	// private String email;
	// private String regTime;
	
	private String sex;  		// 性别
	private String phonenumber; 		// 电话
	private String qqnumber; 			// QQ
	private String school = "湖北警官学院";  // 学校
	private String dorPart; 	// 校区
	private String dorNum; 		// 寝室号
	private String state = "未登陆"; 		// 登录状态
	private String type = "普通用户";		// 用户类型(普通用户、黑名单、中奖者)
	private BmobFile picUser; 	// 头像
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}
	public String getQqNumber() {
		return qqnumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqnumber = qqNumber;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDorPart() {
		return dorPart;
	}
	public void setDorPart(String dorPart) {
		this.dorPart = dorPart;
	}
	public String getDorNum() {
		return dorNum;
	}
	public void setDorNum(String dorNum) {
		this.dorNum = dorNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BmobFile getPicUser() {
		return picUser;
	}
	public void setPicUser(BmobFile picUser) {
		this.picUser = picUser;
	}


}
