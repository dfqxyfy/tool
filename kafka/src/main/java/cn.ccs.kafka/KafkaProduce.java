package cn.ccs.kafka;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProduce {
    private static Properties properties;

    static {
        properties = new Properties();
        System.out.println(KafkaProduce.class.getResource("").getPath());
        String path = KafkaProduce.class.getResource("/").getFile().toString()
                + "kafka.properties";

        try {
            FileInputStream fis = new FileInputStream(new File(path));
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     * 
     * @param topic
     * @param key
     * @param value
     */
    public void sendMsg(String topic, byte[] key, byte[] value) {

        // 实例化produce
        KafkaProducer<byte[], byte[]> kp = new KafkaProducer<byte[], byte[]>(
                properties);

        // 消息封装
        ProducerRecord<byte[], byte[]> pr = new ProducerRecord<byte[], byte[]>(
                topic, key, value);
        for(int i = 0;i<1000;i++) {
            // 发送数据
            kp.send(pr, new Callback() {
                // 回调函数
                @Override
                public void onCompletion(RecordMetadata metadata,
                                         Exception exception) {
                    if (null != exception) {
                        System.out.println("记录的offset在:" + metadata.offset());
                        System.out.println(exception.getMessage() + exception);
                    }
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 关闭produce
        kp.close();
    }

    public static void main(String[] args) {
        KafkaProduce produce = new KafkaProduce();
        produce.sendMsg("test","ceshiAbc".getBytes(),"ceshiValue".getBytes());
    }
}
