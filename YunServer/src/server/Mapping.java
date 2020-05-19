package server;

import java.util.ArrayList;
import java.util.List;
public class Mapping {
    private String name;
    private List<String> urlList;
    public Mapping(){
        this.urlList = new ArrayList<String>();
    }
    public Mapping(String name,ArrayList<String> list){
        this();
        this.name = name;
        urlList = list;
    } 
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<String> getUrl(){
        return urlList;
    }
    public void setUrl(ArrayList<String> list){
        urlList = list;
    }
}