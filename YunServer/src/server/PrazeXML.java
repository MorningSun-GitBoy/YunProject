package server;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class PrazeXML {
    private List<Entity> entityList;
    private List<Mapping> mappingList;
    public PrazeXML(){
        this.entityList = new ArrayList<Entity>();
        this.mappingList = new ArrayList<Mapping>();
    }
    public PrazeXML(ArrayList<Entity> entityList,ArrayList<Mapping> mappinglist){
        this();
        this.entityList = entityList;
        this.mappingList = mappinglist;
    } 
    public List<Entity> getEntityList(){
        return entityList;
    }
    public void setEntityList(ArrayList<Entity> entityList){
        this.entityList = entityList;
    }
    public List<Mapping> getMappingList(){
        return mappingList;
    }
    public void setMappingList(ArrayList<Mapping> list){
        this.mappingList = list;
    }
    public void praseServerlet(String location){
        //在这里仿写一个NODE函数
    	Document doc = null;
        try {
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
        NodeList slist = doc.getElementsByTagName("servlet");
        NodeList mlist = doc.getElementsByTagName("servlet-mapping");
        int i,j;
        for(i=0;i<slist.getLength();i++){
            Node node = slist.item(i);
            NodeList childList = node.getChildNodes();
            Entity e = null;
            for(j=0;j<childList.getLength();j++){
                if(childList.item(j).getNodeType() == Node.ELEMENT_NODE){
                    if("servlet-name".equals(childList.item(j).getNodeName())){
                    	e = new Entity();
                    	e.setName(childList.item(j).getFirstChild().getNodeValue());
                    }else if("servlet-class".equals(childList.item(j).getNodeName())){
                        e.setClazz(childList.item(j).getFirstChild().getNodeValue());
                    }
                    if(e.getName()!=null && e.getClazz() != null){
                        this.entityList.add(e);
                    }
                }
            }
        }
        for(i=0;i<mlist.getLength();i++){
            Node node = mlist.item(i);
            NodeList childList = node.getChildNodes();
            Mapping e = null;
            for(j=0;j<childList.getLength();j++){
                if(childList.item(j).getNodeType() == Node.ELEMENT_NODE){
                    if("servlet-name".equals(childList.item(j).getNodeName())){
                    	if(e!=null && e.getName()!=null && e.getUrl().size() != 0){
                            this.mappingList.add(e);
                        }
                    	e = new Mapping();
                    	e.setName(childList.item(j).getFirstChild().getNodeValue());
                    }else if("url-pattern".equals(childList.item(j).getNodeName())){
                        e.getUrl().add(childList.item(j).getFirstChild().getNodeValue());
                    }
                }
            }
            if(e.getName()!=null && e.getUrl().size() != 0){
                this.mappingList.add(e);
            }
        }
    }
}