package com.challenge.cube;

import java.io.IOException;
import java.util.List;

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
	
	private void writeDeviceLoopMapField(CubeMessageBody body, JsonGenerator jgen) throws IOException {
		//jgen.writeStringField("deviceloopmap", propertyValue.getStringExpr());
		//jgen.writeFieldName("deviceloopmap");
		
		List<CubeLoop> deviceLoopMap = body.getDeviceLoopMap();
		if(deviceLoopMap == null){
			return;//do nothing when null found for this field.
		}
		//writeNumberField(jgen, "patientInfoCount",patientInfoList.getTotalCount());

		if(deviceLoopMap.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName("deviceloopmap");
		jgen.writeStartArray();
		
		for(CubeLoop loop: deviceLoopMap){
		
		//jgen.writeArrayFieldStart();
		
			jgen.writeObject(loop);
		
		
		
		}
		jgen.writeEndArray();
	}

	/*
	protected void writePatientInfoList(String fieldName, CommunityUser communityUser, JsonGenerator jgen,SerializerProvider provider)throws IOException,
	JsonProcessingException{

SmartList<PatientInfo> patientInfoList = communityUser.getPatientInfoList();

if(patientInfoList == null){
	return;//do nothing when null found for this field.
}
writeNumberField(jgen, "patientInfoCount",patientInfoList.getTotalCount());

if(patientInfoList.isEmpty()){
	return;//do nothing when no elements found for this field.
}

jgen.writeFieldName(fieldName);
jgen.writeStartArray();
//start an array [
for(PatientInfo patientInfo: patientInfoList){
		
	jgen.writeStartObject();// {

	writeStringField(jgen, PatientInfo.ID_PROPERTY,patientInfo.getId());
	writeStringField(jgen, PatientInfo.NAME_PROPERTY,patientInfo.getName());
	writeStringField(jgen, PatientInfo.NICK_NAME_PROPERTY,patientInfo.getNickName());
	writeStringField(jgen, PatientInfo.GENDER_PROPERTY,patientInfo.getGender());
	writeDateField(jgen, PatientInfo.BIRTHDAY_PROPERTY,patientInfo.getBirthday());
	writeStringField(jgen, PatientInfo.WEAR_DEVICE_TYPE_PROPERTY,patientInfo.getWearDeviceType());
	writeDateField(jgen, PatientInfo.WEAR_START_TIME_PROPERTY,patientInfo.getWearStartTime());
	writeStringField(jgen, PatientInfo.RECOVER_PLAN_PROPERTY,patientInfo.getRecoverPlan());
	writeDateField(jgen, PatientInfo.RECOVER_START_TIME_PROPERTY,patientInfo.getRecoverStartTime());
	writeNumberField(jgen, PatientInfo.VERSION_PROPERTY,patientInfo.getVersion());	
	appendFieldsToPatientInfoList(fieldName,communityUser, patientInfo, jgen, provider);
	jgen.writeEndObject();//}
	
}
jgen.writeEndArray();
//end the array ]
}
	*/

}
