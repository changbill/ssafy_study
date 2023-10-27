package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ssafy.board.model.dto.Board;

//규격을 먼저 설정해놓고 ( 컨셉 유지해줘잉 by 띵쌤)
//구현체를 만들자.
public interface BoardService {
	// 게시글 전체 조회
	List<Board> getList(int video_id);
	
	// 게시글 등록
	void writeBoard(Board board);
	
	// 게시글 상세 조회 (한 개만 조회한다아)
	Board getBoard(int id);
	
	// 게시글 수정
	void modifyBoard(Board board);
	
	// 게시글 삭제
	void removeBoard(int id, int video_id);
}
