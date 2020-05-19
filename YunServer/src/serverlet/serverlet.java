package serverlet;

import server.Request;
import server.Response;
public abstract class serverlet {
    public void service(Request request,Response response) throws Exception{
        this.doGet(request,response);
        this.doPost(request,response);
    }
    public abstract void doGet(Request request,Response response) throws Exception;
    public abstract void doPost(Request request,Response response) throws Exception;
}