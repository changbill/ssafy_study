package com.ssafy.board.test;

import java.sql.SQLException;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) throws SQLException {
		BoardDao dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
		
		Board board = new Board("자기주도형 학습", "박민아", "EZ");
		
		dao.insertBoard(board);
		
		dao.deleteBoard(12);
		
		dao.updateViewCnt(15);
		
		Board b = dao.selectOne(2);
		b.setTitle("자기주도형 학습 리뉴얼");
		b.setContent("EZ 할지도");
		
		dao.updateBoard(b);
		
		for(Board bb : dao.selectAll()) {
			System.out.println(bb);
		}
		
		
		
		System.out.println(dao.selectOne(2));
	}
}
