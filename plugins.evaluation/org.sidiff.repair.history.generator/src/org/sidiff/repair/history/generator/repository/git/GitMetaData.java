package org.sidiff.repair.history.generator.repository.git;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.sidiff.repair.history.generator.repository.git.json.JSONObject;

public class GitMetaData {

	public static String META_FILE_NAME = "metadata.json";
	
	private String json;
	
	private JSONObject obj;
	
	public GitMetaData(String path) {
		try {
			json = new String(Files.readAllBytes(Paths.get(path)));
			obj = new JSONObject(json);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate(String hash) {
	
			for (Object commit : obj.getJSONArray("commits")) {
				if (commit instanceof JSONObject) {
					String nextHash = ((JSONObject) commit).getString("commit");
					
					if (hash.equalsIgnoreCase(nextHash)) {
						String nextDate = ((JSONObject) commit).getString("data");
						return nextDate;
					}
				}
			}
			
			return null;
	}
}
