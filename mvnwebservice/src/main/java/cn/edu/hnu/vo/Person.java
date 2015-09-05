package cn.edu.hnu.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
	private long id;
	//姓名
	private String name;
	//身份证号
	private String idNum;
	//地址
	private String address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setFields(ResultSet rs) throws SQLException {
		//包裹查询结果
		id = rs.getLong("c_id");
		name = rs.getString("c_name");
		idNum = rs.getString("c_idnum");
		address = rs.getString("c_address");
	}
}
