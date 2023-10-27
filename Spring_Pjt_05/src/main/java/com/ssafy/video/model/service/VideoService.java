package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Video;

// 규격을 먼저 설정해주자 by 띵쌤

public interface VideoService {
	// 운동 영상 조회수 순서
	List<Video> sortCount();
	
	// 운동 부위별 영상
	List<Video> sortPart(String part);
}
