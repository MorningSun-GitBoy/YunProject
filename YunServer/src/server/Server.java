package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import IOUtil.ioUtil;
public class Server {
    private ServerSocket server;
    private boolean isRunning;
    private void start(int port){
        isRunning = true;
        try{
            server = new ServerSocket(port);
            recive();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void recive(){
        try{
            while (isRunning) {
                Socket cleint = server.accept();
                Dispatcher dispatcher = new Dispatcher(cleint);
                new Thread(dispatcher).start();
            }
        }catch (IOException e){
            isRunning = false;
        }
        stop();
    }
    private void stop(){
        isRunning = false;
        ioUtil.closeAll(server);
    }
    public static void main(String[] args){
        Server s = new Server();
        s.start(8888);
    }
}