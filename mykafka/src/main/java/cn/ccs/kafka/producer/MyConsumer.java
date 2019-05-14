package cn.ccs.kafka.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyConsumer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "172.16.225.65:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        //consumer.subscribe(Arrays.asList("foo", "bar"));
        consumer.subscribe(Arrays.asList("my-topic"));
        Map<String, List<PartitionInfo>> stringListMap = consumer.listTopics();
        stringListMap.forEach((k,v)->{
            System.out.println("&&&&&&&&");

            System.out.println(k);
            v.forEach(info->{
                System.out.print(info.topic()+"\t");
            });
            System.out.println();
            System.out.println("&&&&&&&&");

        });
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            System.out.println("****************");
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("<<<<<<<<<<<<,*******************");
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
}
