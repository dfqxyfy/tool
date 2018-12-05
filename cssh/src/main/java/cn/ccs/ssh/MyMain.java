package cn.ccs.ssh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyMain {
    public static List<Server> readFile(){
        File f = new File("/project/tool/cssh/src/main/resources/usepwd.txt");





        List<Server> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(f));
            String s = null;
            while((s = bufferedReader.readLine())!=null){
                System.out.println(s);
                Server server = new Server();
                String[] split = s.split("\\s+");
                server.setIp(split[0]);
                server.setUser("root");
                server.setPwd(split[1]);
                list.add(server);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void main(final String [] args) {

        File ftemp = new File("aaa.txt");
        System.out.println(ftemp.getAbsolutePath());;

        if(true){
            return;
        }

        //Shell shell = new Shell("172.16.225.34", "root", "adey9291!p4");
        List<Server> list = readFile();


        List<OutFormat> resultList= new ArrayList<>();
        for(Server server:list) {
            //Shell shell = new Shell("172.16.117.7", "root", "Ll2018%t6");
            Shell shell = new Shell(server.getIp(), server.getUser(), server.getPwd());
            ExtContent extContent = new ExtContent(shell);
            //Mem mem = extContent.checkMem();
            //Disk disk = extContent.checkDisk();
            //System.out.println(mem);
            //System.out.println(disk);
            //OutFormat outFormat = new OutFormat(server,disk,mem);
            //resultList.add(outFormat);
            Jps jps = extContent.checkJps();
            System.out.println(jps);
        }

        resultList.forEach(out->{
            StringBuilder strb = new StringBuilder();
//            strb.append(out.getServer().getIp());
//            strb.append("\t");
//            strb.append((out.getMem().getUsedMem()+out.getMem().getSwapUsedMem()));
//            strb.append("\t");
//            strb.append((out.getMem().getTotalMem()));
//            strb.append("\t");
//            strb.append(out.getDisk().getUsed());
//            strb.append("\t");
//            strb.append(out.getDisk().getTotal());
            System.out.println(strb.toString());
        });
    }
}
class OutFormat{
    private Server server;
    private Disk disk;
    private Mem mem;

    public OutFormat(Server server, Disk disk, Mem mem) {
        this.server = server;
        this.disk = disk;
        this.mem = mem;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Mem getMem() {
        return mem;
    }

    public void setMem(Mem mem) {
        this.mem = mem;
    }
}
