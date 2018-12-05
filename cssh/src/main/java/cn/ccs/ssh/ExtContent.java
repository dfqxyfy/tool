package cn.ccs.ssh;

import java.util.ArrayList;

public class ExtContent {
    private Shell shell ;
    public ExtContent(Shell shell){
        this.shell = shell;
    }


    public Mem checkMem(){
        String command = "free -m";
        shell.execute(command);
        ArrayList<String> stdout = shell.getStandardOutput();
        Mem mem = new Mem();
        for (String str : stdout) {
            if(str.contains("Mem")){
                String[] split = str.split("\\s+");
                mem.setTotalMem(new Integer(split[1]));
                mem.setUsedMem(new Integer(split[2]));
            }
            if(str.contains("Swap")){
                String[] split = str.split("\\s+");
                mem.setSwapTotalMem(new Integer(split[1]));
                mem.setSwapUsedMem(new Integer(split[2]));
            }
        }
        return mem;
    }

    public Disk checkDisk(){
        String command = "df -h";
        shell.execute(command);
        ArrayList<String> stdout = shell.getStandardOutput();
        Disk disk = new Disk();
        float total = 0;
        float used = 0;
        for (String str : stdout) {
            if(str.contains("dev") && (str.contains("g")||str.contains("G"))){
                String[] split = str.split("\\s+");
                total += dataChange(split[1]);
                used += dataChange(split[2]);
            }

        }
        disk.setTotal(total);
        disk.setUsed(used);
        return disk;
    }

    public Jps checkJps(){
        String command = "jps";
        shell.execute(command);
        ArrayList<String> stdout = shell.getStandardOutput();
        Jps jps = new Jps();
        for (String str : stdout) {
            if(str.contains(".jar")){
                jps.getJarList().add(str.split("\\s+")[1]);
            }
        }
        return jps;
    }

    private Integer dataChange(String ss){
        if(ss == null ){
            return 0;
        }
        if(ss.length()<2){
            return 0;
        }
        String substring = ss.substring(0, ss.length() - 1);
        if(substring.contains(".")){
            substring = substring.substring(0,substring.indexOf("."));
        }
        if(ss.endsWith("k")||ss.endsWith("K")){

            return new Integer(substring)/1000/1000;
        }
        if(ss.endsWith("m")||ss.endsWith("M")){
            return new Integer(substring)/1000;
        }
        if(ss.endsWith("g")||ss.endsWith("G")){
            return new Integer(substring);
        }
        return 0;

    }



}
