package com.ssafy.hw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean(UserDao.class);
		
		User user = new User("ssafy1", "ssafy", "김싸피", "ssafy@naver.com",123);
		dao.insert(user);
		
		System.out.println(dao.searchById("ssafy1"));
		
		for(User u : dao.selectAll()) {
			System.out.println(u);
		}
		
		for(User u1 : dao.searchByName("김싸피")) {
			System.out.println(u1);
		}
	}
}