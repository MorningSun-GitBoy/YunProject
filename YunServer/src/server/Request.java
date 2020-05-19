package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Request {
    private InputStream is;
    private String requestInfo;
    private String method;
    private String url;
    private Map<String,List<String>> parameterValues;
//    private static final String BLANK = " ";
    private static final String CRLF = "\r\n";
    public Request(){
        this.parameterValues = new HashMap<String,List<String>>();
    }
    public Request(InputStream is){
        this();
        this.is = is;
        BufferedReader br = null;
        char[] buff = new char[20480];
        int len;
        try{
            br = new BufferedReader(new InputStreamReader(this.is,"utf-8"));
            if((len = br.read(buff))!=-1){
                requestInfo = new String(buff,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
            requestInfo = "";
            return;
        }
        this.parseRequestInfo();
    }
    private void parseRequestInfo(){
        if(this.requestInfo.equals("")){return;}
        int index = this.requestInfo.indexOf("/");
        this.method = this.requestInfo.substring(0,index-1);
        int end = this.requestInfo.indexOf("HTTP/1.1")-1;
        String urlStr = this.requestInfo.substring(index,end);
        int parameterIndex;
        String parameterStr = "";
        if("get".equals(method)){
            if(urlStr.contains("?")){
                parameterIndex = parameterStr.indexOf("?");
                this.url = urlStr.substring(0, parameterIndex);
                parameterStr  = urlStr.substring(parameterIndex+1);
            }else{
                parameterStr = "";
            }
        }else{
            this.url = urlStr;
            parameterIndex = this.requestInfo.lastIndexOf(CRLF);
            parameterStr = this.requestInfo.substring(parameterIndex).trim();
        }
        if(parameterStr != null && !"".equals(parameterStr)){
            String[] parameterArr = parameterStr.split("&");
            for(String pArr : parameterArr){
                String[] pArrKV = pArr.split("=");
                pArrKV = Arrays.copyOf(pArrKV, 2);
                convertMap(pArrKV);
            }
        }
    }
    private void convertMap(String[] pArr){
        String k = pArr[0];
        String v = null;
        try{
            v = pArr[1] == null ? null : URLDecoder.decode(pArr[1],"utf-8");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        if(!this.parameterValues.containsKey(k)){
            parameterValues.put(k, new ArrayList<String>());
        }
        this.parameterValues.get(k).add(v);
    }
    public String[] getParameterValues(String name){
        List<String> list = parameterValues.get(name);
        return list == null ? null : list.toArray(new String[0]);
    }
    public String getParameter(String name){
        String[] values = this.getParameterValues(name);
        return values == null ? null : values[0];
    }
    public String getMethod() {
		return method;
	}
	public String getUrl() {
		return url;
	}
	public Map<String, List<String>> getParameterValues() {
		return parameterValues;
	}
}