package cn.ccs.nio.learn;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by chaichuanshi on 2017/6/27.
 */
public class ByteBufferTest {

    @Test
    public void wrapByteBufferTest() {
        byte[] bytes = new byte[10];
        bytes = "abcdef".getBytes();
        out(bytes);
        // Wrap a byte array into a buffer
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        System.out.println(buf.getChar());
        System.out.println(buf.get());
        System.out.println("arrayOffset: "+buf.arrayOffset());
        while(buf.hasRemaining()){
            System.out.println(buf.get());
        }

        System.out.println(buf.isDirect());
        System.out.println(buf.position());
        buf.mark();
        buf.reset();
        buf.rewind();
        System.out.println(buf.position());
        out(buf);
        System.out.println(buf.order());
        // Retrieve bytes between the position and limit
        // (see Putting Bytes into a ByteBuffer)
        bytes = new byte[buf.remaining()];
        out(bytes);
        // transfer bytes from this buffer into the given destination array
        buf.get(bytes, 0, bytes.length);
        out(buf);
        // Retrieve all bytes in the buffer

        System.out.println(buf.toString());
        buf.clear();
        out(buf);

        bytes = new byte[buf.capacity()];

        // transfer bytes from this buffer into the given destination array
        buf.get(bytes, 0, bytes.length);
        out(buf);

    }

    public void out(ByteBuffer buf){
        if(buf == null)
            return ;
        for(int i=0;i<buf.capacity();i++){
            System.out.print(buf.get(i)+",");
        }
        System.out.println();
    }
    public void out(byte[] bytes){
        if(bytes == null)
            return ;
        for(int i=0;i<bytes.length;i++){
            System.out.print(bytes[i]+",");
        }
        System.out.println();
    }
}
