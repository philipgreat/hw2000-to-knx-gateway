package com.challenge;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CubeMsgBodySerializer.class)
public class CubeMessageBody {
	static String testBody = "{\"msgid\":\"2387r958273894\",\"action\":\"request\",\"subaction\":\"heartbeat\"}";
	public int length() {
		// TODO Auto-generated method stub
		return testBody.length();
	}
	
	private List<CubeProperty> properties;
	

	public List<CubeProperty> getProperties() {
		if(properties == null){
			properties = new ArrayList<CubeProperty>();
		}
		return properties;
	}
	
	public CubeMessageBody addProperty(CubeProperty property){
		getProperties().add(property);
		return this;
	}
	
	public CubeMessageBody addProperty(String  propertyName, String value){
		CubeProperty property = new CubeProperty();
		property.setPropertyName(propertyName);
		property.setPropertyValue(new CubeValue(value));
		addProperty(property);
		return this;
	}
	
	public void setProperties(List<CubeProperty> properties) {
		this.properties = properties;
	}


	public String stringBody() throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(this);
	}
	
	
	public static void main(String[] args) throws JsonProcessingException {
		
		CubeMessageBody body = new CubeMessageBody();
		
		//body.withId("newid").withAction("request").withSubaction()
		body.buildHeartbeat();
		
		ObjectMapper mapper = new ObjectMapper();
		String msg = mapper.writeValueAsString(new CubeMessageBody().buildHeartbeat());
		System.out.println(msg);
		msg = mapper.writeValueAsString(new CubeMessageBody().buildLogin("cubeid", "password"));
		System.out.println(msg);
		msg = mapper.writeValueAsString(new CubeMessageBody().buildGetConfig());
		System.out.println(msg);
		//
		
		
		
	}
	
	public CubeMessageBody start(){
		return this.withMsgid(System.currentTimeMillis()+"");
	}
	public CubeMessageBody buildLogin(String cubeid, String cubepwd){
		
		return withRegister().withCubeid(cubeid).withCubepwd(cubepwd);
		
	}
	
	public CubeMessageBody buildHeartbeat(){
		
		return start().withAction("request").withSubaction("heartbeat");
		
	}
	public CubeMessageBody buildGetConfig(){
		
		return start().withAction("request").withSubaction("getdeviceconfig").withModuletype("cube").withVersion("0");
		
	}
	
	
	
	private CubeMessageBody withRegister() {
		// TODO Auto-generated method stub
		return start().withAction("request").withSubaction("register");
	}

	public CubeMessageBody withMsgid(String value){ addProperty("msgid", value); return this;}
	public CubeMessageBody withAction(String value){ addProperty("action", value); return this;}
	public CubeMessageBody withSubaction(String value){ addProperty("subaction", value); return this;}
	public CubeMessageBody withCubeid(String value){ addProperty("cubeid", value); return this;}
	public CubeMessageBody withCubepwd(String value){ addProperty("cubepwd", value); return this;}
	public CubeMessageBody withCubeoldpwd(String value){ addProperty("cubeoldpwd", value); return this;}
	public CubeMessageBody withCloudid(String value){ addProperty("cloudid", value); return this;}
	public CubeMessageBody withCloudpwd(String value){ addProperty("cloudpwd", value); return this;}
	public CubeMessageBody withModuletype(String value){ addProperty("moduletype", value); return this;}
	public CubeMessageBody withModulemacaddr(String value){ addProperty("modulemacaddr", value); return this;}
	public CubeMessageBody withModuleipaddr(String value){ addProperty("moduleipaddr", value); return this;}
	public CubeMessageBody withModuleserialnum(String value){ addProperty("moduleserialnum", value); return this;}
	public CubeMessageBody withMachinetype(String value){ addProperty("machinetype", value); return this;}
	public CubeMessageBody withDevicetype(String value){ addProperty("devicetype", value); return this;}
	//public CubeMessageBody with(String value){ addProperty("", value); return this;}
	public CubeMessageBody withLooptype(String value){ addProperty("looptype", value); return this;}
	public CubeMessageBody withBrandname(String value){ addProperty("brandname", value); return this;}
	//public CubeMessageBody with(String value){ addProperty("", value); return this;}
	//public CubeMessageBody with(String value){ addProperty("", value); return this;}
	public CubeMessageBody withAliasname(String value){ addProperty("aliasname", value); return this;}
	public CubeMessageBody withSubdevtype(String value){ addProperty("subdevtype", value); return this;}
	public CubeMessageBody withRoomname(String value){ addProperty("roomname", value); return this;}
	public CubeMessageBody withErrorcode(String value){ addProperty("errorcode", value); return this;}
	//public CubeMessageBody with(String value){ addProperty("", value); return this;}
	public CubeMessageBody withModuleloopmap(String value){ addProperty("moduleloopmap", value); return this;}
	public CubeMessageBody withDeviceloopmap(String value){ addProperty("deviceloopmap", value); return this;}
	public CubeMessageBody withSparklightloopmap(String value){ addProperty("sparklightloopmap", value); return this;}
	public CubeMessageBody withBacnetloopmap(String value){ addProperty("bacnetloopmap", value); return this;}
	public CubeMessageBody withIrloopmap(String value){ addProperty("irloopmap", value); return this;}
	public CubeMessageBody with485Loopmap(String value){ addProperty("485loopmap", value); return this;}
	public CubeMessageBody withRelayloopmap(String value){ addProperty("relayloopmap", value); return this;}
	public CubeMessageBody withAlarmzoneloopmap(String value){ addProperty("alarmzoneloopmap", value); return this;}
	public CubeMessageBody withMaialoopmap(String value){ addProperty("maialoopmap", value); return this;}
	public CubeMessageBody withDeviceid(String value){ addProperty("deviceid", value); return this;}
	public CubeMessageBody withSlaveaddr(String value){ addProperty("slaveaddr", value); return this;}
	public CubeMessageBody withLoopnum(String value){ addProperty("loopnum", value); return this;}
	public CubeMessageBody withLoopid(String value){ addProperty("loopid", value); return this;}
	public CubeMessageBody withMaskid(String value){ addProperty("maskid", value); return this;}
	public CubeMessageBody withPortid(String value){ addProperty("portid", value); return this;}
	public CubeMessageBody withPortrate(String value){ addProperty("portrate", value); return this;}
	public CubeMessageBody withCubebacnetid(String value){ addProperty("cubebacnetid", value); return this;}
	public CubeMessageBody withBacnetdeviceid(String value){ addProperty("bacnetdeviceid", value); return this;}
	public CubeMessageBody withSettemp(String value){ addProperty("settemp", value); return this;}
	public CubeMessageBody withCurrenttmp(String value){ addProperty("currenttmp", value); return this;}
	public CubeMessageBody withMode(String value){ addProperty("mode", value); return this;}
	//public CubeMessageBody with(String value){ addProperty("", value); return this;}
	public CubeMessageBody withFanspeed(String value){ addProperty("fanspeed", value); return this;}
	public CubeMessageBody withStatus(String value){ addProperty("status", value); return this;}
	//public CubeMessageBody with(String value){ addProperty("", value); return this;}
	public CubeMessageBody withOpenclosepercent(String value){ addProperty("openclosepercent", value); return this;}
	public CubeMessageBody withZonetype(String value){ addProperty("zonetype", value); return this;}
	public CubeMessageBody withAlarmtimer(String value){ addProperty("alarmtimer", value); return this;}
	public CubeMessageBody withAlarmenable(String value){ addProperty("alarmenable", value); return this;}
	public CubeMessageBody withArmtype(String value){ addProperty("armtype", value); return this;}
	public CubeMessageBody withIsarm(String value){ addProperty("isarm", value); return this;}
	public CubeMessageBody withSecuritypwd(String value){ addProperty("securitypwd", value); return this;}
	public CubeMessageBody withAlarmtype(String value){ addProperty("alarmtype", value); return this;}
	public CubeMessageBody withAlarmmsgid(String value){ addProperty("alarmmsgid", value); return this;}
	public CubeMessageBody withTime(String value){ addProperty("time", value); return this;}
	public CubeMessageBody withRtspurl(String value){ addProperty("rtspurl", value); return this;}
	public CubeMessageBody withAirtype(String value){ addProperty("airtype", value); return this;}
	public CubeMessageBody withCurrenttime(String value){ addProperty("currenttime", value); return this;}
	public CubeMessageBody withCurrentco2(String value){ addProperty("currentco2", value); return this;}
	public CubeMessageBody withCurrentpm2_5(String value){ addProperty("currentpm2_5", value); return this;}
	public CubeMessageBody withCurrenthumid(String value){ addProperty("currenthumid", value); return this;}
	public CubeMessageBody withHnsserveraddr(String value){ addProperty("hnsserveraddr", value); return this;}
	public CubeMessageBody withCallmsg(String value){ addProperty("callmsg", value); return this;}
	public CubeMessageBody withCalltype(String value){ addProperty("calltype", value); return this;}
	public CubeMessageBody withCallsessionid(String value){ addProperty("callsessionid", value); return this;}
	public CubeMessageBody withVideoport(String value){ addProperty("videoport", value); return this;}
	public CubeMessageBody withAudioport(String value){ addProperty("audioport", value); return this;}
	public CubeMessageBody withVideocodectype(String value){ addProperty("videocodectype", value); return this;}
	public CubeMessageBody withAudiocodectype(String value){ addProperty("audiocodectype", value); return this;}
	public CubeMessageBody withVideoratio(String value){ addProperty("videoratio", value); return this;}
	public CubeMessageBody withTakecallipaddr(String value){ addProperty("takecallipaddr", value); return this;}
	public CubeMessageBody withDooropentype(String value){ addProperty("dooropentype", value); return this;}
	public CubeMessageBody withDooropenway(String value){ addProperty("dooropenway", value); return this;}
	public CubeMessageBody withDooropenrole(String value){ addProperty("dooropenrole", value); return this;}
	public CubeMessageBody withDooropenid(String value){ addProperty("dooropenid", value); return this;}
	public CubeMessageBody withUuid(String value){ addProperty("uuid", value); return this;}
	public CubeMessageBody withIpctype(String value){ addProperty("ipctype", value); return this;}
	public CubeMessageBody withIpcsrc(String value){ addProperty("ipcsrc", value); return this;}
	public CubeMessageBody withIpcurl(String value){ addProperty("ipcurl", value); return this;}
	public CubeMessageBody withIpcusername(String value){ addProperty("ipcusername", value); return this;}
	public CubeMessageBody withIpcpassword(String value){ addProperty("ipcpassword", value); return this;}
	public CubeMessageBody withIpcloopmap(String value){ addProperty("ipcloopmap", value); return this;}
	public CubeMessageBody withDisturbtype(String value){ addProperty("disturbtype", value); return this;}
	public CubeMessageBody withKeytype(String value){ addProperty("keytype", value); return this;}
	public CubeMessageBody with(String value){ addProperty("", value); return this;}
	public CubeMessageBody withKeyvalue(String value){ addProperty("keyvalue", value); return this;}
	public CubeMessageBody withKeytypeloop(String value){ addProperty("keytypeloop", value); return this;}
	public CubeMessageBody withVersion(String value){ addProperty("version", value); return this;}
	public CubeMessageBody withUpgradetype(String value){ addProperty("upgradetype", value); return this;}
	public CubeMessageBody withControltype(String value){ addProperty("controltype", value); return this;}
	public CubeMessageBody withConfigdata(String value){ addProperty("configdata", value); return this;}
	public CubeMessageBody withConfigtype(String value){ addProperty("configtype", value); return this;}
	public CubeMessageBody withScenarioid(String value){ addProperty("scenarioid", value); return this;}
	public CubeMessageBody withPrimaryid(String value){ addProperty("primaryid", value); return this;}
	public CubeMessageBody withResponseprimaryid(String value){ addProperty("responseprimaryid", value); return this;}
	//public CubeMessageBody withKeytype(String value){ addProperty("Keytype", value); return this;}
	//public CubeMessageBody withKeyvalue(String value){ addProperty("keyvalue", value); return this;}
	public CubeMessageBody withSecurityscenarioid(String value){ addProperty("securityscenarioid", value); return this;}
	//public CubeMessageBody withCallsessionid(String value){ addProperty("callsessionid", value); return this;}
	//public CubeMessageBody withControltype(String value){ addProperty("controltype", value); return this;}
	public CubeMessageBody withCycletype(String value){ addProperty("cycletype", value); return this;}
	public CubeMessageBody withHumidity(String value){ addProperty("humidity", value); return this;}
	public CubeMessageBody withDehumidity(String value){ addProperty("dehumidity", value); return this;}
	public CubeMessageBody withInner(String value){ addProperty("inner", value); return this;}
	public CubeMessageBody withOutside(String value){ addProperty("outside", value); return this;}
	
	
	
}
