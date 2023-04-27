package com.example.demo.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.windfire.apis.asysConnectData;

/**
 * @packageName : com.java.example.vo
 * @fileName : XtormVO.java
 * @author : uk0ok
 * @version : 1.0
 * @date : 2023.04.27
 * @description : xtorm connection 관련 VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022.04.27        uk0ok            최초 생성
 */
@Component
public class XtormVO {
	private asysConnectData conn;

	@Value("${xtorm.engineIp}")
	private String engineIp;

	@Value("${xtorm.enginePort}")
	private String enginePort;

	@Value("${xtorm.description}")
	private String description;

	@Value("${xtorm.engineId}")
	private String engineId;
	
	@Value("${xtorm.enginePw}")
	private String enginePw;
	
	@Value("${xtorm.gateway}")
	private String gateway;

	public asysConnectData getConn() {
		if (conn == null) { setConn(); }
		return conn;
	}
	public void setConn() {
		this.conn = new asysConnectData(engineIp, Integer.parseInt(enginePort), description, engineId, enginePw);
	}
	public String getEngineIp() {
		return engineIp;
	}
	public void setEngineIp(String engineIp) {
		this.engineIp = engineIp;
	}
	public String getEnginePort() {
		return enginePort;
	}
	public void setEnginePort(String enginePort) {
		this.enginePort = enginePort;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEngineId() {
		return engineId;
	}
	public void setEngineId(String engineId) {
		this.engineId = engineId;
	}
	public String getEnginePw() {
		return enginePw;
	}
	public void setEnginePw(String enginePw) {
		this.enginePw = enginePw;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
}
