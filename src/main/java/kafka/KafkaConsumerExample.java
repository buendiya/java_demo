package kafka;
/*
http://cloudurable.com/blog/kafka-tutorial-kafka-consumer/index.html
*/

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;


public class KafkaConsumerExample {

    private final static String TOPIC = "mp_sdk";
    // private final static String TOPIC = "HbaseRecordTest";
    private final static String BOOTSTRAP_SERVERS =
            "kafka001:9092,kafka002:9092,kafka003:9092,kafka004:9092,kafka005:9092";

    private static Consumer<Long, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,
                "KafkaExampleConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());

        // Create the consumer using props.
        final Consumer<Long, String> consumer =
                new KafkaConsumer<>(props);

        // Subscribe to the topic.
        consumer.subscribe(Collections.singletonList(TOPIC));
        return consumer;
    }


    static void runConsumer() throws InterruptedException {
        final Consumer<Long, String> consumer = createConsumer();

        final int giveUp = 10;   int noRecordsCount = 0;

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords =
                    consumer.poll(5000);

            if (consumerRecords.count()==0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }

            System.out.printf("count %d", consumerRecords.count());
            Thread.sleep(60 * 1000);
            // consumerRecords.forEach(record -> {
            //     System.out.printf("Consumer Record:(%s, %s, %d, %d)\n",
            //             record.key(), record.value(),
            //             record.partition(), record.offset());
            // });

            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("DONE");
    }

    public static void main(String... args) throws Exception {
        runConsumer();
    }
}
