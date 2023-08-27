package ch.seg.info.unibe.example.vod;

import java.util.ArrayList;
import java.util.List;

public class Server {

	private String name; 
	
	private List<Video> videos;
	
	public Server(String name) {
		this.name = name;
		this.videos = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
