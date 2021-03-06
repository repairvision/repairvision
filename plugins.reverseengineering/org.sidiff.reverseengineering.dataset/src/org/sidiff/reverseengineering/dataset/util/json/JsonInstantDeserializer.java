package org.sidiff.reverseengineering.dataset.util.json;

import java.lang.reflect.Type;
import java.time.Instant;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class JsonInstantDeserializer implements JsonDeserializer<Instant> {

	@Override
	public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return Instant.parse(json.getAsString());
	}
	
}
