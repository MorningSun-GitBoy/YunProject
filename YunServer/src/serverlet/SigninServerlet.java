package serverlet;

import server.Request;
import server.Response;
import Model.UserManager;
public class SigninServerlet extends serverlet{
    public void doGet(Request request,Response response) throws Exception{
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("passwd");
        if(UserManager.Signin(uname,pwd)){
            response.print(uname+"登录成功，益云欢迎你");
        }else{
            response.print("登录失败，用户名或密码输错了哟");
        }
    }
    public void doPost(Request request,Response response) throws Exception{}
    
}