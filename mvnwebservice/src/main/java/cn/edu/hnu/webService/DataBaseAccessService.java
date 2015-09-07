package cn.edu.hnu.webService;

import cn.edu.hnu.dao.PersonDAO;
import cn.edu.hnu.vo.Person;

import com.google.gson.Gson;

public class DataBaseAccessService {
	
	public String getUserInfoById() {
		System.out.println("in the method of getUserInfoById1");
		PersonDAO personDAO = new PersonDAO();
		System.out.println("in the method of getUserInfoById2");
		Person person = personDAO.getUserInfoById(1);
		System.out.println("in the method of getUserInfoById3");
		String userInfoInJson = new Gson().toJson(person);
		System.out.println("in the method of getUserInfoById4");
		System.out.println(userInfoInJson);
		return userInfoInJson;
	}
	
	public static void main(String[] args) {
		DataBaseAccessService dataBaseAccessService = new DataBaseAccessService();
		dataBaseAccessService.getUserInfoById();
		dataBaseAccessService.getUserInfoById();
	}
}
