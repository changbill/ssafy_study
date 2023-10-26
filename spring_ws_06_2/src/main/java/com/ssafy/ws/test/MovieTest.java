package com.ssafy.ws.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.Movie;
import com.ssafy.ws.model.dto.User;

public class MovieTest {
	public static void main(String[] args) {
		//코드작성
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		MovieDao moviedao = context.getBean(MovieDao.class);
		UserDao userdao = context.getBean(UserDao.class);
		
		System.out.println(userdao.select("ssafy"));
		
		Movie movie = new Movie(123, "홍박사님을 아세요?", "최홍준", "코미디", 123);
		moviedao.insert(movie);
		
		System.out.println(moviedao.searchById(123));
		
		System.out.println(moviedao.searchByTitle("홍박사님을 아세요?"));
		
		for(Movie m : moviedao.selectAll()) {
			System.out.println(m);
		}
		
	}
}
