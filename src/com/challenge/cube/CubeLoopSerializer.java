package com.challenge.cube;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CubeLoopSerializer extends JsonSerializer<CubeLoop>{

	@Override
	public void serialize(CubeLoop cubeLoop, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		
		for(CubeProperty property:cubeLoop.getProperties() ){
			writeStringField(jgen,property.getPropertyName(), property.getPropertyValue());
		}
		
		
		jgen.writeEndObject();
		
	}
	private void writeStringField(JsonGenerator jgen, String propertyName,
			CubeValue propertyValue) throws IOException {
		jgen.writeStringField(propertyName, propertyValue.getStringExpr());
		
	}
	
}
