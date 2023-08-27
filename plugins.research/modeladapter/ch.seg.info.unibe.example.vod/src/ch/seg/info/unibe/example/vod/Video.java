package ch.seg.info.unibe.example.vod;

public class Video {
	
	private String name; 

	private Server main;
	
	private Server mirror;
	
	public Video(String name, Server main, Server mirror) {
		this.name = name;
		this.main = main;
		this.mirror = mirror;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Server getMain() {
		return main;
	}

	public void setMain(Server main) {
		this.main = main;
	}

	public Server getMirror() {
		return mirror;
	}

	public void setMirror(Server mirror) {
		this.mirror = mirror;
	}
}
