package ch.seg.info.unibe.example.vod;

public class User {
	
	private Video open;
	
	private String name;

	public User(String name) {
		this.name = name;
	}

	public Video getOpen() {
		return open;
	}

	public void setOpen(Video open) {
		this.open = open;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
