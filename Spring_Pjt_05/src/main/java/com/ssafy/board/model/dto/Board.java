package com.ssafy.board.model.dto;

import java.util.Date;

public class Board {
	private int video_id;
	private int id;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int view_cnt;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int video_id) {
		this.setvideo_id(video_id);
	}
	public Board(int id, String title, String writer, String content, int video_id) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = new Date().toString();
		this.video_id = video_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getview_cnt() {
		return view_cnt;
	}

	public void setview_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", view_cnt=" + view_cnt + "]";
	}

	public int getvideo_id() {
		return video_id;
	}

	public void setvideo_id(int video_id) {
		this.video_id = video_id;
	}
	
}
