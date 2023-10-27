package com.ssafy.video.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.video.model.dao.VideoDao;
import com.ssafy.video.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService{
	private static VideoService service = new VideoServiceImpl();
	
	// 의존성 주입
	private VideoDao dao;
	
	@Autowired
	public VideoServiceImpl(VideoDao dao) {
		this.dao = dao;
	}

	public VideoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static VideoService getInstance() {
		return service;
	}

	@Override
	public List<Video> sortCount() {
		// TODO Auto-generated method stub
		return dao.sortCount();
	}

	@Override
	public List<Video> sortPart(String part) {
		return dao.sortPart(part);
	}
	
	

}
