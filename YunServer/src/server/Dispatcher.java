package server;

import java.io.IOException;
import java.net.Socket;
import serverlet.serverlet;
import IOUtil.ioUtil;
public class Dispatcher implements Runnable{
    private Socket cleint;
    private Request req;
    private Response res;
    int code = 200;
    public Dispatcher(Socket client){
        this.cleint = client;
        try{
            req = new Request(this.cleint.getInputStream());
            res = new Response(this.cleint.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void run(){
        String url = req.getUrl();
        serverlet server = serverletConect.getServerlet(url);
        if (server == null){
            code = 404;
        }else{
            try{
                server.service(req, res);//对响应报文的编辑在serverlet中实现
            }catch(Exception e){
                e.printStackTrace();
                code = 500;
            }
        }
        res.pushToClient(code);
        ioUtil.closeAll(cleint);
    }
}