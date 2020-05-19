package serverlet;

import Model.FTPManager;
import server.Request;
import server.Response;
public class DownloadServerlet {
	public void doGet(Request request,Response response) throws Exception{
        String state = request.getParameter("state");
        String name = request.getParameter("name");
        FTPManager.newLoad(isDownload);
    }
    public void doPost(Request request,Response response) throws Exception{}
    
}
