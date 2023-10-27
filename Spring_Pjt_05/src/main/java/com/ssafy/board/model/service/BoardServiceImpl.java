package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;


@Service
public class BoardServiceImpl implements BoardService{
	
	//의존성 주입
	@Autowired
	private BoardDao dao;

	private BoardServiceImpl() {
		
	}
	
	
	@Override
	public List<Board> getList(int video_id) {
		// TODO Auto-generated method stub
		return dao.selectAll(video_id);
	}

	@Override
	public void writeBoard(Board board) {
		dao.insertBoard(board);
	}

	@Override
	public Board getBoard(int id) {
		dao.updateViewCnt(id);
		return dao.selectOne(id);
	}

	@Override
	public void modifyBoard(Board board) {
		dao.updateBoard(board);
		
	}

	@Override
	public void removeBoard(int id, int video_id) {
		// TODO Auto-generated method stub
		dao.deleteBoard(id, video_id);
	}

}
