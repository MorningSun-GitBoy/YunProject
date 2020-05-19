package IOUtil;
import java.io.Closeable;
import java.io.IOException;
public class ioUtil{
    public static void closeAll(Closeable...c){
        for(Closeable close : c){
            if(close != null){
                try{
                    close.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}