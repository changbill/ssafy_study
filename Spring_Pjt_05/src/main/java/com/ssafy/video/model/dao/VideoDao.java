package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Video;

// DB 너낌 나게 작성해라아 by 띵쌤
public interface VideoDao {
	// 운동 영상 조회수 순서
	List<Video> sortCount();
	
	// 운동 부위별 영상
	List<Video> sortPart(String part);
}
