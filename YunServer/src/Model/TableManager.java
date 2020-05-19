package Model;

import com.mysql.jdbc.Driver;
import java.sql.*;
public class TableManager {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ProjectYun";
    Statement sqldb = null;
    TableManager(){
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            Connection connect = DriverManager.getConnection(DB_URL,"yun","123456");
            sqldb = connect.createStatement();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public boolean isExit(String value,String colum,String Table) {
    	String commend = null;
    	if() {
    		return true;
    	}else {
    		return false;
    	}
    }
    public void makeVeiw() {
    	
    }
    
}