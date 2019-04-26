package ds.nabuco.webapp.testdrive;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class HashTest {

	private JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
	Jedis jedis = null;

	public Jedis getResource() {
		jedis = pool.getResource();
		return jedis;
		}
		public void setResource(Jedis jedis){		
		pool.close();
		}	
	
	public static void main(String[] args) {
		HashTest hash = new HashTest();
		hash.test();

	}
	private void test() {
		Jedis jedis = this.getResource();
		String commonkey = "learning:redis";
		jedis.hset(commonkey, "class", "Terceiro Período");
		jedis.hset(commonkey, "professor", "Gênesis Lima");
		System.out.println(jedis.hgetAll(commonkey));
		Map<String,String> attributes = new HashMap<String,String>();
		attributes.put("code", "XX-XX-XX-XX");
		attributes.put("topics", "Redis,NoSQL");
		attributes.put("students", "60");
		attributes.put("class_time", "6:50PM");
		attributes.put("absences", "10");
		jedis.hmset(commonkey, attributes);
		System.out.println(jedis.hgetAll(commonkey));
		System.out.println(jedis.hget(commonkey,"class"));
		System.out.println(jedis.hmget(commonkey,"class","professor"));
		System.out.println(jedis.hvals(commonkey));
		System.out.println(jedis.hget(commonkey,"students"));
		System.out.println(jedis.hkeys(commonkey));
		System.out.println(jedis.hexists(commonkey, "topics"));
		System.out.println(jedis.hlen(commonkey));
		System.out.println(jedis.hincrBy(commonkey,"absences",10));		
		System.out.println(jedis.hdel(commonkey,"absences"));
		System.out.println(jedis.hgetAll(commonkey));
		this.setResource(jedis);
		
	}
	
	

}
