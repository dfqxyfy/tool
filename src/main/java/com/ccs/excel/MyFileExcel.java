package com.ccs.excel;

import java.util.ArrayList;
import java.util.List;

public class MyFileExcel {

    public static void main(String[] args) {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       new Thread(){
            @Override
           public void run(){

                System.out.println();
                //ExportExcel<Entity> entityExportExcel = new ExportExcel<>();
                String[] headers = new String[]{"name","age"};
                String[] orders = new String[]{"name","age"};

                List<Entity> list = new ArrayList<>();
                for(int i = 0;i<1000000;i++){
                    Entity entity = new Entity();
                    entity.setAge(100+i);
                    entity.setName("aaa"+i);
                }
                //entityExportExcel.createDataSheet("aaa",headers,orders,list,"yyyy-MM-dd",Entity.class);


                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Entity{
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}