package cn.ccs.network;

import java.net.DatagramPacket;
import java.net.InetAddress;  
import java.net.MulticastSocket;  
  
public class MultiCastReceive {  
    public static void main(String[]args){  
        try {  
            //IP组  
            InetAddress ip = InetAddress.getByName("228.15.6.7");
            //组播监听端口  
            MulticastSocket s = new MulticastSocket(6789);  
            //加入该组   
            s.joinGroup(ip);  
  
            byte[] arb = new byte[24];  
            while (true) {  
                DatagramPacket datagramPacket = new DatagramPacket(arb,arb.length);  
                s.receive(datagramPacket);  
                System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));  
                System.out.println(arb.length);  
                System.out.println(new String(arb));  
            }  
        } catch (Exception e) {  
            e.printStackTrace();
        }  
    }  
}