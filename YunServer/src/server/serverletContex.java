package server;

import java.util.HashMap;
import java.util.Map;
public class serverletContex {
    private Map<String,String> serverlet;
    private Map<String,String> mapping;
    public serverletContex(){
        this.serverlet = new HashMap<String,String>();
        this.mapping = new HashMap<String,String>();
    }
    public serverletContex(Map<String, String> serverlet, Map<String, String> mapping) {
		this.serverlet = serverlet;
		this.mapping = mapping;
	}
	public Map<String, String> getServerlet() {
		return serverlet;
	}
	public void setServerlet(Map<String, String> serverlet) {
		this.serverlet = serverlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
}