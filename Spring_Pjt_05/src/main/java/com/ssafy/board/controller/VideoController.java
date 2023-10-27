package com.ssafy.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.user.model.dto.User;
import com.ssafy.user.model.service.UserService;
import com.ssafy.video.model.dto.Video;
import com.ssafy.video.model.service.VideoService;
import com.ssafy.video.model.service.VideoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-video")
@Api(tags = "비디오 컨트롤러")
public class VideoController {

	private VideoService videoService;

	@Autowired
	public VideoController(VideoService videoService) {
		super();
		this.videoService = videoService;
	}

	@GetMapping("/count")
	@ApiOperation(value = "조회수 내림차순 정렬", notes = "조회수 순서대로 위에서 부터")
	public ResponseEntity<?> sortCount() {
		List<Video> result = videoService.sortCount();

		if(result.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Video>>(result, HttpStatus.OK);
	}

	@GetMapping("/part")
	@ApiOperation(value = "부위별 운동 영상 출력", notes = "그러하-다")
	public ResponseEntity<?> sortPart(String part) {
		List<Video> result = videoService.sortPart(part);

		if(result.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Video>>(result, HttpStatus.OK);
	}

}