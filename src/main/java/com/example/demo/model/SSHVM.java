package com.example.demo.model;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SSHVM {
private String name ; 
private  String agentlabel ;
private  String Remotefs ;
private String nodeDescription ;
private int  numExecutors ;
private String  labelString ;
private String adreeseIp ;
private int  port ;
private  String groovyScript ;
private  String jvmOptions ;
private String  sshHostKeyVerificationStrategy ;
private String credentialId ;
private String Sourcegroovy ;
private String javaPath ;
private String prefixStartSlaveCmd ;
private  String suffixStartSlaveCmd ;
private Integer launchTimeoutSeconds ;
private  Integer maxNumRetries ;
private Integer  retryWaitTime ;
private String JvmPath ;

/*public SSHVM(String name, String agentlabel, String remoteFs, String nodeDescription, int numExecutors,
		String labelString, String adreeseIp, int port, String groovyScript, String jvmOptions,
		String sshHostKeyVerificationStrategy, String credentialId, String sourcegroovy, String javaPath,
		String prefixStartSlaveCmd, String suffixStartSlaveCmd, Integer launchTimeoutSeconds, Integer maxNumRetries,
		Integer retryWaitTime, String jvmPath) {
	super();
	this.name = name;
	this.agentlabel = agentlabel;
	this.remoteFs = remoteFs;
	this.nodeDescription = nodeDescription;
	this.numExecutors = numExecutors;
	this.labelString = labelString;
	this.adreeseIp = adreeseIp;
	this.port = port;
	this.groovyScript = groovyScript;
	this.jvmOptions = jvmOptions;
	this.sshHostKeyVerificationStrategy = sshHostKeyVerificationStrategy;
	this.credentialId = credentialId;
	this.Sourcegroovy = sourcegroovy;
	this.javaPath = javaPath;
	this.prefixStartSlaveCmd = prefixStartSlaveCmd;
	this.suffixStartSlaveCmd = suffixStartSlaveCmd;
	this.launchTimeoutSeconds = launchTimeoutSeconds;
	this.maxNumRetries = maxNumRetries;
	this.retryWaitTime = retryWaitTime;
	this.JvmPath = jvmPath;
}*/
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAgentlabel() {
	return agentlabel;
}
public void setAgentlabel(String agentlabel) {
	this.agentlabel = agentlabel;
}
public String getRemoteFs() {
	return Remotefs;
}
public void setRemoteFs(String remoteFs) {
	this.Remotefs = remoteFs;
}
public String getNodeDescription() {
	return nodeDescription;
}
public void setNodeDescription(String nodeDescription) {
	this.nodeDescription = nodeDescription;
}
public int getNumExecutors() {
	return numExecutors;
}
public void setNumExecutors(int numExecutors) {
	this.numExecutors = numExecutors;
}
public String getLabelString() {
	return labelString;
}
public void setLabelString(String labelString) {
	this.labelString = labelString;
}
public String getAdreeseIp() {
	return adreeseIp;
}
public void setAdreeseIp(String adreeseIp) {
	this.adreeseIp = adreeseIp;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
public String getJvmOptions() {
	return jvmOptions;
}
public void setJvmOptions(String jvmOptions) {
	this.jvmOptions = jvmOptions;
}
public String getSshHostKeyVerificationStrategy() {
	return sshHostKeyVerificationStrategy;
}
public void setSshHostKeyVerificationStrategy(String sshHostKeyVerificationStrategy) {
	this.sshHostKeyVerificationStrategy = sshHostKeyVerificationStrategy;
}
public Integer getLaunchTimeoutSeconds() {
	return launchTimeoutSeconds;
}
public void setLaunchTimeoutSeconds(Integer launchTimeoutSeconds) {
	this.launchTimeoutSeconds = launchTimeoutSeconds;
}

public String creatSSHVMgroovy ()
{
	String s = "import hudson.model.*\r\n" + 
			"import jenkins.model.*\r\n" + 
			"import hudson.slaves.*\r\n" + 
			"import hudson.slaves.EnvironmentVariablesNodeProperty.Entry\r\n" + 
			"import hudson.plugins.sshslaves.* ;\r\n" + 
			"import hudson.plugins.sshslaves.verifiers.ManuallyTrustedKeyVerificationStrategy\r\n" + 
			"import hudson.plugins.sshslaves.SSHLauncher\r\n" ;
		//permanente agent 
	 s+= "Slave agent = new DumbSlave(\""+this.name+"\",\r\n\""+
	 		"c:/dd"+"\",\r\n" + 
	 		"new SSHLauncher(\""+this.adreeseIp+"\","+this.port+",\""+this.credentialId+"\",\""+this.jvmOptions+"\",\""+this.javaPath+"\",\"\",\"\","+this.launchTimeoutSeconds+","+this.maxNumRetries+","+this.retryWaitTime+","+"new "+"ManuallyTrustedKeyVerificationStrategy(true)" +"\r\n"+ 
	 		") \r\n) ; \r\n" ;
	 s+="agent.nodeDescription = \""+this.nodeDescription+"\"\r\n"+"agent.numExecutors ="+this.numExecutors+"\r\n"+"agent.labelString =\""+this.labelString+"\"\r\n"+"agent.mode = Node.Mode.NORMAL"+ "\r\n"+ "agent.retentionStrategy = new RetentionStrategy.Always() ;";
			  // Create a "Permanent Agent"
			s+= " Jenkins.instance.addNode(agent);";
	 
	return s  ;
}
@Override
public String toString() {
	return "SSHVM [name=" + name + ", agentlabel=" + agentlabel + ", Remotefs=" + Remotefs + ", nodeDescription="
			+ nodeDescription + ", numExecutors=" + numExecutors + ", labelString=" + labelString + ", adreeseIp="
			+ adreeseIp + ", port=" + port + ", groovyScript=" + groovyScript + ", jvmOptions=" + jvmOptions
			+ ", sshHostKeyVerificationStrategy=" + sshHostKeyVerificationStrategy + ", credentialId=" + credentialId
			+ ", Sourcegroovy=" + Sourcegroovy + ", javaPath=" + javaPath + ", prefixStartSlaveCmd="
			+ prefixStartSlaveCmd + ", suffixStartSlaveCmd=" + suffixStartSlaveCmd + ", launchTimeoutSeconds="
			+ launchTimeoutSeconds + ", maxNumRetries=" + maxNumRetries + ", retryWaitTime=" + retryWaitTime
			+ ", JvmPath=" + JvmPath + "]";
}





}
