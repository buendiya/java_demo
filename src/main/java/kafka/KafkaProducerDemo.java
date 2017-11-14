package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;


public class KafkaProducerDemo {

    public static void producerDemo(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka001:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);

        Random rnd = new Random();
        for (long nEvents = 0; nEvents < 100; nEvents++) {
            int next = rnd.nextInt(5);
            String ip = "192.168.2." + next;

            ProducerRecord<String, String> data = new ProducerRecord<>(
                    "HbaseRecordTest", String.valueOf(next), ip);
            producer.send(data);
        }
        producer.close();
    }


    public static void main(String[] args){
        producerDemo();
    }
}
