package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class UserNamePasswordXredential extends Auth {
	
	private String password ;
	

	public UserNamePasswordXredential(String password) {
		super();
		this.password = password;
	}

	public UserNamePasswordXredential() {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String CrdentialSaveGroovy() {
String s = "import com.cloudbees.plugins.credentials.impl.*;\r\n" + 
		"import com.cloudbees.plugins.credentials.*;\r\n" + 
		"import com.cloudbees.plugins.credentials.domains.*;\r\n" + 
		"\r\n" + 
		"String keyfile = \"/tmp/key\"\r\n" + 
		"\r\n" + 
		"Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,java.util.UUID.randomUUID().toString()"+",\""+this.getDescription() +"\",\""+this.getUsername()+"\",\""+this.password +"\")\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"def ksm1 = new CertificateCredentialsImpl.FileOnMasterKeyStoreSource(keyfile)\r\n" + 
		"Credentials ck1 = new CertificateCredentialsImpl(CredentialsScope.GLOBAL,java.util.UUID.randomUUID().toString()"+",\""+this.getDescription() +"\",\""+this.password +"\","+" ksm1)\r\n" + 
		"\r\n" + 
		"def ksm2 = new CertificateCredentialsImpl.UploadedKeyStoreSource(keyfile)\r\n" + 
		"Credentials ck2 = new CertificateCredentialsImpl(CredentialsScope.GLOBAL,java.util.UUID.randomUUID().toString()"+",\""+this.getDescription() +"\",\""+this.password+"\","+" ksm2)\r\n" + 
		"\r\n" + 
		"SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)\r\n" + 
		"SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), ck1)\r\n" + 
		"SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), ck2)";
return s;
	}

	@Override
	public String toString() {
		return "UserNamePasswordXredential [password=" + password + ", CrdentialSaveGroovy()=" + CrdentialSaveGroovy()
				+ ", getCredentialId()=" + getCredentialId() + ", getUsername()=" + getUsername()
				+ ", getDescription()=" + getDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	public String getAllCredentialGroovyScript ()
	{ 
		String S = "import hudson.model.*\r\n" + 
				" class Cred\r\n" + 
				"{\r\n" + 
				"  String username ;\r\n" + 
				"  hudson.util.Secret password ;\r\n" + 
				"  String credentialId ;\r\n" + 
				"  def Cred (String username,  hudson.util.Secret password , String credentialId)\r\n" + 
				"  {\r\n" + 
				"    this.username = username ;\r\n" + 
				"    this.password = password ;\r\n" + 
				"    this.credentialId = credentialId ;\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"def jenkinsCredentials = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(\r\n" + 
				"       com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl.class,\r\n" + 
				"        Jenkins.instance,\r\n" + 
				"        null,\r\n" + 
				"        null\r\n" + 
				");\r\n" + 
				"  List <Cred> h = new ArrayList<Cred> () ;\r\n" + 
				"for (creds in jenkinsCredentials) \r\n" + 
				"{\r\n" + 
				"  h.add( new Cred(creds.getUsername(),creds.getPassword(),creds.getId()));\r\n" + 
				"\r\n" + 
				"  }\r\n" + 
				"builder = new groovy.json.JsonBuilder(h);\r\n" + 
				"println (builder )" ;
		return S ;
		
	}


}
