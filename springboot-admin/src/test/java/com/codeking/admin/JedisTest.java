package com.codeking.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : codeking
 * @create : 2022/12/22 11:40
 */

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        String pong = jedis.ping();
        System.out.println("连接成功！ "+pong);
        // 关闭连接
        jedis.close();
    }

    @Test
    void testKey(){
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        jedis.flushDB();
        jedis.set("k1","按时发货");
        jedis.set("k2","按时发货2");
        Set<String> keys=jedis.keys("*");
        System.out.println(keys.size());
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.get("k1"));
    }

    @Test
    void testStrings() throws Exception {
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));
    }

    @Test
    void testList(){
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        jedis.lpush("mylist","asd","s");
        List<String> list = jedis.lrange("mylist",0,-1);
        for (String element : list) {
            System.out.println(element);
        }
    }
    @Test
    void testSet(){
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        jedis.sadd("orders", "order01");
        jedis.sadd("orders", "order02");
        jedis.sadd("orders", "order03");
        jedis.sadd("orders", "order04");
        Set<String> smembers = jedis.smembers("orders");
        for (String order : smembers) {
            System.out.println(order);
        }
        jedis.srem("orders", "order02");
    }
    @Test
    void testHash(){
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        jedis.hset("hash1","userName","lisi");
        System.out.println(jedis.hget("hash1","userName"));
        Map<String,String> map = new HashMap<String,String>();
        map.put("telphone","13810169999");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);
        List<String> result = jedis.hmget("hash2", "telphone","email");
        for (String element : result) {
            System.out.println(element);
        }
    }

    @Test
    void testZSet(){
        Jedis jedis = new Jedis("192.168.1.104", 6379);
        jedis.auth("990416");
        jedis.zadd("zset01", 100d, "z3");
        jedis.zadd("zset01", 90d, "l4");
        jedis.zadd("zset01", 80d, "w5");
        jedis.zadd("zset01", 70d, "z6");
        Set<String> zrange = jedis.zrange("zset01", 0, -1);
        for (String e : zrange) {
            System.out.println(e);
        }
    }

}
