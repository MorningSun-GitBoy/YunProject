package Connect;

public class Requsts {
	private StringBuffer requestInfo;
    private String method;
    private String url;
    private String protocl;
    private static final String BLANK = " ";
    private static final String CRLF = "\r\n";
    public Requsts() {
    	this.protocl = "HTTP1.1";
    }
    public Requsts(String url,String method) {
    	this();
    	this.url = url;
    	this.method = method;
    }
    public Requsts setRequstInfo(StringBuffer sb) {
    	requestInfo = new StringBuffer("");
    	requestInfo.append(method.toUpperCase());
    	requestInfo.append(BLANK);
    	requestInfo.append(url);
    	requestInfo.append(protocl);
    	requestInfo.append(CRLF);
    	requestInfo.append(sb);
    	return this;
    }
    public String toString() {
    	return this.requestInfo.toString();
    }
}
