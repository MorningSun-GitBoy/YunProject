package Connect;

public class Connection {
	private static Client client = new Client();
	private static Requsts request;
	private static Responses response = new Responses();
	private static boolean isInit = false;
	private static boolean recived = false;
	private static void flushConnect() {
		isInit = false;
		recived = false;
	}
	public static Client buildClient(int port) {
		return new Client(port);
	}
	public static void init(String url,String method) {
		request = new Requsts(url,method);
		isInit = true;
	}
	public static String getResponse() {
		if(isInit == true || recived == true) {
			flushConnect();
			return response.printContent();
		}else {
			return null;
		}
	}
	public static void request(StringBuffer sb) {
		if(isInit == true) {
			request.setRequstInfo(sb);
			client.requst(request);
			client.receive(response);
			recived = true;
		}
	}
}
