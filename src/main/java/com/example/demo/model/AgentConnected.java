package com.example.demo.model;

public class AgentConnected  {
	 String agentName ;
	  String agentipadress;
	  String status ;
	  String port ;
	public String getAgentName() {
		return agentName;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public void setAgentName(String agent_Name) {
		this.agentName = agent_Name;
	}
	public String getAgentipadress() {
		return agentipadress;
	}
	public void setAgentipadress(String agent_ip_adress) {
		this.agentipadress = agent_ip_adress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AgentAdresseIp [agent_Name=" + agentName + ", agent_ip_adress=" + agentipadress + ", status="
				+ status + "]";
	}
}
