package com.ssafy.video.model.dto;

public class Video {
	private int video_id;
	private String title;
	private String youtube;
	private String fit_path_name;
	private int view_cnt;
	private String thumbnail;
	
	public Video() {
		// TODO Auto-generated constructor stub
		this.title = " ";
		this.youtube = " ";
		this.fit_path_name = " ";
	}

	public Video(int video_id, String title, String youtube, String fit_path_name, int view_cnt, String thumbnail) {
		super();
		this.video_id = video_id;
		this.title = title;
		this.youtube = youtube;
		this.fit_path_name = fit_path_name;
		this.view_cnt = view_cnt;
		this.thumbnail = thumbnail;
	}

	public int getvideo_id() {
		return video_id;
	}

	public void setvideo_id(int video_id) {
		this.video_id = video_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getfit_path_name() {
		return fit_path_name;
	}

	public void setfit_path_name(String fit_path_name) {
		this.fit_path_name = fit_path_name;
	}

	public int getview_cnt() {
		return view_cnt;
	}

	public void setview_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", title=" + title + ", youtube=" + youtube + ", fit_path_name=" + fit_path_name
				+ ", view_cnt=" + view_cnt + ", thumbnail=" + thumbnail + "]";
	}
	
}
