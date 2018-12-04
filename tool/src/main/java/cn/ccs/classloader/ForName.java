package cn.ccs.classloader;

public class ForName {
    public static void main(String[] args) {
        try {
            Class aClass = null;
            aClass = Class.forName("cn.ccs.classloader.MyClassForName");
            aClass = Class.forName("cn.ccs.classloader.MyClassForName",false,ForName.class.getClassLoader());
            MyClassForName o = (MyClassForName)aClass.newInstance();

            StringBuilder strb= new StringBuilder();
//            for(int i =0;i<10000000;i++){
//                s+=i+"asfd";
//            }
            while(true){
                strb.append("safdfasfdsafasfaf");
            }
            //Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
