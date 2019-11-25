package controller.banco;

import redis.clients.jedis.Jedis;

public class JedisFactory {

    private Jedis jedis;

    public JedisFactory(){
        jedis = new Jedis("localhost", 6379);
    }

    public Jedis getJedis(){
        return jedis;
    }
}
