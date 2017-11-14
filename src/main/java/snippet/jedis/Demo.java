package snippet.jedis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.io.IOException;
import java.util.Set;


public class Demo {

    public static void fun1() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car"); jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        /// ... when closing your application:
        pool.destroy();
    }

    public static void fun2() {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        /// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
        try (Jedis jedis = pool.getResource()) {
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car"); jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        }
        /// ... when closing your application:
        pool.destroy();
    }

    public static void fun3() throws IOException {
        Jedis jedis = new Jedis("host", 2);
        jedis.auth("password");
        Pipeline pipeline=jedis.pipelined();
        pipeline.sync();
        pipeline.close();
        jedis.close();
    }

    public static void main(String[] args) {
    }
}
