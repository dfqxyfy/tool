package cn.ccs.ssh;

import java.util.ArrayList;
import java.util.List;

public class Jps {
    private List<String> jarList  = new ArrayList<>();

    public List<String> getJarList() {
        return jarList;
    }

    public void setJarList(List<String> jarList) {
        this.jarList = jarList;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for(String s:jarList){
            strb.append(s).append("\t");
        }
        return "Jps{" +
                "jarList=" + strb +
                '}';
    }

}
