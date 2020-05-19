package Model;

import java.util.ArrayList;
import IOUtil.ioUtil;
import server.ftpBuilder;
public class FTPManager {
    public static void newLoad(boolean isDownload){
        //建立一个端口列表
        //用for循环建立所有的ftpload，并开始运行
        //提交一次任务实现
    }
    public void buildThread(int port,boolean isDownload){
        ftpBuilder builder = new ftpBuilder();
        if(isDownload){
            builder.DownloadFtp(port);
        }else{
            builder.UploadFtp(port);
        }
    }
    public static boolean isleagle(String passwd){
        boolean result = false;
        //用表查询查询正误
        return result;
    }
    public static void ioFailed(int port){
        //重新建立一个对应端口的传输线程
    }
}