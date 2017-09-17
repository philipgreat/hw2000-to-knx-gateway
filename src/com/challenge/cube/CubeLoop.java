package com.challenge.cube;

import java.util.ArrayList;
import java.util.List;

public class CubeLoop {
	private List<CubeProperty> properties;
	

	public List<CubeProperty> getProperties() {
		if(properties == null){
			properties = new ArrayList<CubeProperty>();
		}
		return properties;
	}
	
	public CubeLoop addProperty(CubeProperty property){
		getProperties().add(property);
		return this;
	}
	
	

	
	public CubeLoop addProperty(String  propertyName, String value){
		CubeProperty property = new CubeProperty();
		property.setPropertyName(propertyName);
		property.setPropertyValue(new CubeValue(value));
		addProperty(property);
		return this;
	}
	
	public CubeLoop withMsgid(String value){ addProperty("msgid", value); return this;}
	public CubeLoop withAction(String value){ addProperty("action", value); return this;}
	public CubeLoop withSubaction(String value){ addProperty("subaction", value); return this;}
	public CubeLoop withCubeid(String value){ addProperty("cubeid", value); return this;}
	public CubeLoop withCubepwd(String value){ addProperty("cubepwd", value); return this;}
	public CubeLoop withCubeoldpwd(String value){ addProperty("cubeoldpwd", value); return this;}
	public CubeLoop withCloudid(String value){ addProperty("cloudid", value); return this;}
	public CubeLoop withCloudpwd(String value){ addProperty("cloudpwd", value); return this;}
	public CubeLoop withModuletype(String value){ addProperty("moduletype", value); return this;}
	public CubeLoop withModulemacaddr(String value){ addProperty("modulemacaddr", value); return this;}
	public CubeLoop withModuleipaddr(String value){ addProperty("moduleipaddr", value); return this;}
	public CubeLoop withModuleserialnum(String value){ addProperty("moduleserialnum", value); return this;}
	public CubeLoop withMachinetype(String value){ addProperty("machinetype", value); return this;}
	public CubeLoop withDevicetype(String value){ addProperty("devicetype", value); return this;}
	//public CubeLoop with(String value){ addProperty("", value); return this;}
	public CubeLoop withLooptype(String value){ addProperty("looptype", value); return this;}
	public CubeLoop withBrandname(String value){ addProperty("brandname", value); return this;}
	//public CubeLoop with(String value){ addProperty("", value); return this;}
	//public CubeLoop with(String value){ addProperty("", value); return this;}
	public CubeLoop withAliasname(String value){ addProperty("aliasname", value); return this;}
	public CubeLoop withSubdevtype(String value){ addProperty("subdevtype", value); return this;}
	public CubeLoop withRoomname(String value){ addProperty("roomname", value); return this;}
	public CubeLoop withErrorcode(String value){ addProperty("errorcode", value); return this;}
	//public CubeLoop with(String value){ addProperty("", value); return this;}
	public CubeLoop withModuleloopmap(String value){ addProperty("moduleloopmap", value); return this;}
	public CubeLoop withDeviceloopmap(String value){ addProperty("deviceloopmap", value); return this;}
	public CubeLoop withSparklightloopmap(String value){ addProperty("sparklightloopmap", value); return this;}
	public CubeLoop withBacnetloopmap(String value){ addProperty("bacnetloopmap", value); return this;}
	public CubeLoop withIrloopmap(String value){ addProperty("irloopmap", value); return this;}
	public CubeLoop with485Loopmap(String value){ addProperty("485loopmap", value); return this;}
	public CubeLoop withRelayloopmap(String value){ addProperty("relayloopmap", value); return this;}
	public CubeLoop withAlarmzoneloopmap(String value){ addProperty("alarmzoneloopmap", value); return this;}
	public CubeLoop withMaialoopmap(String value){ addProperty("maialoopmap", value); return this;}
	public CubeLoop withDeviceid(String value){ addProperty("deviceid", value); return this;}
	public CubeLoop withSlaveaddr(String value){ addProperty("slaveaddr", value); return this;}
	public CubeLoop withLoopnum(String value){ addProperty("loopnum", value); return this;}
	public CubeLoop withLoopid(String value){ addProperty("loopid", value); return this;}
	public CubeLoop withMaskid(String value){ addProperty("maskid", value); return this;}
	public CubeLoop withPortid(String value){ addProperty("portid", value); return this;}
	public CubeLoop withPortrate(String value){ addProperty("portrate", value); return this;}
	public CubeLoop withCubebacnetid(String value){ addProperty("cubebacnetid", value); return this;}
	public CubeLoop withBacnetdeviceid(String value){ addProperty("bacnetdeviceid", value); return this;}
	public CubeLoop withSettemp(String value){ addProperty("settemp", value); return this;}
	public CubeLoop withCurrenttmp(String value){ addProperty("currenttmp", value); return this;}
	public CubeLoop withMode(String value){ addProperty("mode", value); return this;}
	//public CubeLoop with(String value){ addProperty("", value); return this;}
	public CubeLoop withFanspeed(String value){ addProperty("fanspeed", value); return this;}
	public CubeLoop withStatus(String value){ addProperty("status", value); return this;}
	//public CubeLoop with(String value){ addProperty("", value); return this;}
	public CubeLoop withOpenclosepercent(String value){ addProperty("openclosepercent", value); return this;}
	public CubeLoop withZonetype(String value){ addProperty("zonetype", value); return this;}
	public CubeLoop withAlarmtimer(String value){ addProperty("alarmtimer", value); return this;}
	public CubeLoop withAlarmenable(String value){ addProperty("alarmenable", value); return this;}
	public CubeLoop withArmtype(String value){ addProperty("armtype", value); return this;}
	public CubeLoop withIsarm(String value){ addProperty("isarm", value); return this;}
	public CubeLoop withSecuritypwd(String value){ addProperty("securitypwd", value); return this;}
	public CubeLoop withAlarmtype(String value){ addProperty("alarmtype", value); return this;}
	public CubeLoop withAlarmmsgid(String value){ addProperty("alarmmsgid", value); return this;}
	public CubeLoop withTime(String value){ addProperty("time", value); return this;}
	public CubeLoop withRtspurl(String value){ addProperty("rtspurl", value); return this;}
	public CubeLoop withAirtype(String value){ addProperty("airtype", value); return this;}
	public CubeLoop withCurrenttime(String value){ addProperty("currenttime", value); return this;}
	public CubeLoop withCurrentco2(String value){ addProperty("currentco2", value); return this;}
	public CubeLoop withCurrentpm2_5(String value){ addProperty("currentpm2_5", value); return this;}
	public CubeLoop withCurrenthumid(String value){ addProperty("currenthumid", value); return this;}
	public CubeLoop withHnsserveraddr(String value){ addProperty("hnsserveraddr", value); return this;}
	public CubeLoop withCallmsg(String value){ addProperty("callmsg", value); return this;}
	public CubeLoop withCalltype(String value){ addProperty("calltype", value); return this;}
	//public CubeLoop withCallsessionid(String value){ addProperty("callsessionid", value); return this;}
	public CubeLoop withVideoport(String value){ addProperty("videoport", value); return this;}
	public CubeLoop withAudioport(String value){ addProperty("audioport", value); return this;}
	public CubeLoop withVideocodectype(String value){ addProperty("videocodectype", value); return this;}
	public CubeLoop withAudiocodectype(String value){ addProperty("audiocodectype", value); return this;}
	public CubeLoop withVideoratio(String value){ addProperty("videoratio", value); return this;}
	public CubeLoop withTakecallipaddr(String value){ addProperty("takecallipaddr", value); return this;}
	public CubeLoop withDooropentype(String value){ addProperty("dooropentype", value); return this;}
	public CubeLoop withDooropenway(String value){ addProperty("dooropenway", value); return this;}
	public CubeLoop withDooropenrole(String value){ addProperty("dooropenrole", value); return this;}
	public CubeLoop withDooropenid(String value){ addProperty("dooropenid", value); return this;}
	public CubeLoop withUuid(String value){ addProperty("uuid", value); return this;}
	public CubeLoop withIpctype(String value){ addProperty("ipctype", value); return this;}
	public CubeLoop withIpcsrc(String value){ addProperty("ipcsrc", value); return this;}
	public CubeLoop withIpcurl(String value){ addProperty("ipcurl", value); return this;}
	public CubeLoop withIpcusername(String value){ addProperty("ipcusername", value); return this;}
	public CubeLoop withIpcpassword(String value){ addProperty("ipcpassword", value); return this;}
	public CubeLoop withIpcloopmap(String value){ addProperty("ipcloopmap", value); return this;}
	public CubeLoop withDisturbtype(String value){ addProperty("disturbtype", value); return this;}
	//public CubeLoop withKeytype(String value){ addProperty("keytype", value); return this;}
	public CubeLoop with(String value){ addProperty("", value); return this;}
	public CubeLoop withKeyvalue(String value){ addProperty("keyvalue", value); return this;}
	public CubeLoop withKeytypeloop(String value){ addProperty("keytypeloop", value); return this;}
	public CubeLoop withVersion(String value){ addProperty("version", value); return this;}
	public CubeLoop withUpgradetype(String value){ addProperty("upgradetype", value); return this;}
	//public CubeLoop withControltype(String value){ addProperty("controltype", value); return this;}
	public CubeLoop withConfigdata(String value){ addProperty("configdata", value); return this;}
	public CubeLoop withConfigtype(String value){ addProperty("configtype", value); return this;}
	public CubeLoop withScenarioid(String value){ addProperty("scenarioid", value); return this;}
	public CubeLoop withPrimaryid(String value){ addProperty("primaryid", value); return this;}
	public CubeLoop withResponseprimaryid(String value){ addProperty("responseprimaryid", value); return this;}
	public CubeLoop withKeytype(String value){ addProperty("Keytype", value); return this;}
	//spublic CubeLoop withKeyvalue(String value){ addProperty("keyvalue", value); return this;}
	public CubeLoop withSecurityscenarioid(String value){ addProperty("securityscenarioid", value); return this;}
	public CubeLoop withCallsessionid(String value){ addProperty("callsessionid", value); return this;}
	public CubeLoop withControltype(String value){ addProperty("controltype", value); return this;}
	public CubeLoop withCycletype(String value){ addProperty("cycletype", value); return this;}
	public CubeLoop withHumidity(String value){ addProperty("humidity", value); return this;}
	public CubeLoop withDehumidity(String value){ addProperty("dehumidity", value); return this;}
	public CubeLoop withInner(String value){ addProperty("inner", value); return this;}
	public CubeLoop withOutside(String value){ addProperty("outside", value); return this;}
	
}
