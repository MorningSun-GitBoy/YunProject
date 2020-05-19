package App;

import java.util.Arrays;

public class Loader {
	private int[] port;
	private int size;
	private String passwd;
	public Loader() {}
	public Loader(String passwd,int[] port,int len) {
		this();
		this.passwd = passwd;
		this.port = Arrays.copyOf(port, len);
	}
}
