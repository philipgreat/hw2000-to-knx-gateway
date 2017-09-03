package com.challenge.cube;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CubeMsgBodySerializer extends JsonSerializer<CubeMessageBody> {

	@Override
	public void serialize(CubeMessageBody body, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		
		for(CubeProperty property:body.getProperties() ){
			writeStringField(jgen,property.getPropertyName(), property.getPropertyValue());
		}
		
		
		jgen.writeEndObject();
		
	}

	private void writeStringField(JsonGenerator jgen, String propertyName,
			CubeValue propertyValue) throws IOException {
		jgen.writeStringField(propertyName, propertyValue.getStringExpr());
		
	}

		
	

}
