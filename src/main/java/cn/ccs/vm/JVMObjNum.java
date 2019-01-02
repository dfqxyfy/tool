//package cn.ean();
//        String name = bean.getName();
//        int index = name.indexOf('@');
//        String pid = name.substring(0, index);
//        //这里要区分操作系统
//        //HotSpotVirtualMachine machine = (HotSpotVirtualMachine) new sugn.tools.attach.WindowsAttachProvider().attachVirtualMachine(pid);
//        HotSpotVirtualMachine machine = (HotSpotVirtualMachine) new sun.tools.attach.BsdAttachProvider().attachVirtualMachine(pid);
//        InputStream is = machine.heapHisto("-all");
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        int readed;
//        byte[] buff = new byte[1024];
//        while((readed = is.read(buff)) > 0) {
//            baos.write(buff, 0, readed);
//        }
//        is.close();
//
//        machine.detach();
//        System.out.println(baos);
//    }
//}
