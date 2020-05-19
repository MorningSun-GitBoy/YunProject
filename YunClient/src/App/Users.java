package App;

import Connect.Connection;
public class Users {
	private String Name;
	private String State;
	private int Storage;
	private String passwd(String str) {
		return "";
	}
	public Users() {
		this.Name = null;
		this.State = null;
		this.Storage = 0;
	}
	public void signin(String name,String passwd) {
		StringBuffer sb = new StringBuffer();
		sb.append("uname=");
		sb.append(name);
		sb.append("&passwd=");
		sb.append(passwd);
		Connection.init("/Signin","get");
		Connection.request(sb);
		System.out.println(Connection.getResponse());
		this.Name = name;
	}
	public void login(String name,String passwd) {
		StringBuffer sb = new StringBuffer();
		sb.append("uname=");
		sb.append(name);
		sb.append("&passwd=");
		sb.append(passwd(passwd));
		Connection.init("/Login", "get");
		Connection.request(sb);
		System.out.println(Connection.getResponse());
	}
	public boolean isExit(String name) {
		StringBuffer sb = new StringBuffer();
		sb.append("uname=");
		sb.append(name);
		Connection.init("/Search", "get");
		Connection.request(sb);
		if(Connection.getResponse().equals("0")) {
			return true;
		}else {
			return false;
		}
	}
}
