package Connect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
public class Client {
	static String SERVER_ROOT = "localhost";
	private Socket client;
	private InputStream is;
	private OutputStream os;
	public Client() {
		try {
			client = new Socket(SERVER_ROOT,8888);
			is = client.getInputStream();
			os = client.getOutputStream();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Client(int port) {
		try {
			client = new Socket(SERVER_ROOT,port);
			is = client.getInputStream();
			os = client.getOutputStream();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void requst(Requsts re) {
		PrintWriter pw = new PrintWriter(os);
		pw.write(re.toString());
	}
	public void receive(Responses res){
		res.getInfo(is);
		res.getContent();
	}
}
