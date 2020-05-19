package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import IOUtil.ioUtil;
public class Response {
    private StringBuffer headInfo;
    private StringBuffer content;
    private int length;
    private BufferedWriter bw;
    private static final String BLANK = " ";
    private static final String CRLF = "\r\n";
    public Response(){
        this.headInfo = new StringBuffer();
        this.content = new StringBuffer();
    }
    public Response(OutputStream os){
        this();
        try{
            bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
    public Response print(String info) {
		content.append(info);
		try {
			length += info.getBytes("utf-8").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return this;
	}
	public Response println(String info) {
		content.append(info);
		content.append(CRLF);
		try {
			length += (info + CRLF).getBytes("utf-8").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return this;
	}
	public void creatHeadInfo(int code) {
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code) {
		case 200:
			headInfo.append("OK");
			break;
		case 404:
			headInfo.append("NOT FOUND");
			break;
		default:
			headInfo.append("SERVER ERROR");
		}
		headInfo.append(CRLF);
		headInfo.append("Content-Type: text/html;charset=utf-8").append(CRLF);
		headInfo.append("Content-Length:").append(length).append(CRLF);
		headInfo.append(CRLF);
	}
	public void pushToClient(int code) {
		if(headInfo == null) {
			code = 500;
		}
		
		this.creatHeadInfo(code);
		try {
			bw.write(headInfo.toString());
			bw.write(content.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		close();
	}
	public void close() {
		ioUtil.closeAll(bw);
	}
}