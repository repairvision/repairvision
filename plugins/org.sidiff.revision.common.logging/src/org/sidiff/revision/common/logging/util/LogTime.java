package org.sidiff.revision.common.logging.util;

public class LogTime {
	
	protected long time = -1;

	protected long start = System.currentTimeMillis();
	
	public long start() {
		start = System.currentTimeMillis();
		return start;
	}
	
	public long stop() {
		if (time == -1) {
			time = System.currentTimeMillis() - start;
		} else {
			time += System.currentTimeMillis() - start;
		}
		return time;
	}
	
	public void reset() {
		time = -1;
		start = System.currentTimeMillis();
	}
	
	public long getTime() {
		return time;
	}
	
	public long append(long time) {
		return this.time += time;
	}
	
	public long append(LogTime time) {
		return this.time += time.getTime();
	}
	
	@Override
	public String toString() {
		return "" + time;
	}
}
