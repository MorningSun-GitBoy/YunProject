package server;

import java.util.List;
import java.util.Map;
import serverlet.serverlet;
public class serverletConect {
    private static serverletContex context;
    static{
        context = new serverletContex();
        Map<String, String> serverlet = context.getServerlet();
        Map<String, String> mapping = context.getMapping();
        PrazeXML prazer = new PrazeXML();
        prazer.praseServerlet("bin/web.xml");
        List<Entity> entityList = prazer.getEntityList();
        List<Mapping> mappingList = prazer.getMappingList();
        for(Entity entity : entityList) {
			serverlet.put(entity.getName(), entity.getClazz());
		}
		for (Mapping mapp : mappingList) {
			for (String url : mapp.getUrl()) {
				mapping.put(url, mapp.getName());
			}
		}
    }
    public static serverlet getServerlet(String url){
        if(url==null||url.trim().equals("")){return null;}
        try {
            String serverletName = context.getMapping().get(url);
            String serverletClazz = context.getServerlet().get(serverletName);
            /* 
            xml中，serverlet-name与url-pattner一致
            先从mapping的Map中获得url-pattner作为serverlet-name
            之后从entity的Map中获得entity的clazz属性
             */
            Class<?> clazz = Class.forName(serverletClazz);
            Object theserverlet = clazz.newInstance();
            return (serverlet) theserverlet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return null;

    }
}