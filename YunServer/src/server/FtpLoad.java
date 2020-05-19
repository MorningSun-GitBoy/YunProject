package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import IOUtil.ioUtil;
import Model.FTPManager;
public class FtpLoad implements Runnable{
    private ServerSocket server;
    private Socket cleint;
    private boolean isRunning;
    private String commend;
    private boolean isleagle;
    private int count;
    private void stop(){
        isRunning = false;
        ioUtil.closeAll(server);
    }
    public FtpLoad(){this.isRunning=true;}
    public FtpLoad(int port,String commend){
        this();
        isRunning = true;
        count = 0;
        this.commend = commend;
        try{
            server = new ServerSocket(port);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
        try{
            while (isRunning) {
                Socket cleint = server.accept();
                
            }
        }catch(IOException e){
            isRunning = false;
            FTPManager.ioFailed(server.getLocalPort());
        }
        stop();
    }
}