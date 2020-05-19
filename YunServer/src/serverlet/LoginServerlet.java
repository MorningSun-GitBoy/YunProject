package serverlet;

import server.Request;
import server.Response;
public class LoginServerlet extends serverlet{
    public void doGet(Request request,Response response) throws Exception{
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("passwd");
        if(login(uname,pwd)){
            response.print(uname+"益云欢迎你的加入");
        }else{
            response.print("抱歉，改用户已存在，试试新的名字呢?");
        }
    }
    public void doPost(Request request,Response response) throws Exception{}
    private boolean login(String uname,String pwd){
        boolean result = false;
        return result;
    }
}