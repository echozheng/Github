package cn.edu.hnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.hnu.vo.Person;

public class PersonDAO {
	
	private String selectSql = "";
	
	public PersonDAO() {
		selectSql = "select * from c_person where c_id = ?";
	}
	
	//包裹查询结果
	public Person wrapResult(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setFields(rs);
		return person;
	}
	
	//根据id查询用户信息
	public Person getUserInfoById(long id){
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(selectSql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			Person person = new Person();
			while(rs.next()) {
				person =  wrapResult(rs);
			}
			rs.close();
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭数据库连接
			try {
				ps.close();
				JDBCConnection.closeConnectionToMysql();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
