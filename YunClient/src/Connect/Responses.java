package Connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Responses {
	private int length;
	private String content;
	private String info;
	private static final String CRLF = "\r\n";
	public Responses() {
		this.info = null;
		this.content = "";
	}
	public void getInfo(InputStream is) {
		BufferedReader br = null;
        char[] buff = new char[20480];
        int len;
        try{
            br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            if((len = br.read(buff))!=-1){
                this.info = new String(buff,0,len);
            }
        }catch(IOException e) {
        	e.printStackTrace();
        	this.info = "";
        }
	}
	public void getLength() {
		if(info == null && info.equals("")) {
			this.length = 0;
		}else {
			int index = this.info.indexOf("Content-Length")+"Content-Length".length();
			int end = this.info.substring(index).indexOf(CRLF+CRLF);
			String thelength = this.info.substring(index, end);
			this.length = new Integer(thelength).intValue();
		}
	}
	public void getContent() {
		this.getLength();
		this.content = this.info.substring(this.info.lastIndexOf(length));
		//this.content = this.info.substring(this.info.indexOf(CRLF+CRLF));
	}
	public String printContent() {
		return content;
	}
}
