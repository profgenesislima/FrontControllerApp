package ds.nabuco.webapp.testdrive;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SetTest {


	private JedisPool pool = new JedisPool(new JedisPoolConfig(),"localhost");
			Jedis jedis = null;

			public Jedis getResource() {
				jedis = pool.getResource();
				return jedis;
				}
				public void setResource(Jedis jedis){
				//pool.returnResource(jedis);
				pool.close();
				}	
	
	public static void main(String[] args) {
		SetTest set = new SetTest();
		set.test();
		

	}
	private void test() {
		Jedis jedis = this.getResource();
		jedis.sadd("follow:mongo", "gen.lima@junk-mail.com","gen.lima@junk-mail.com","gen.lima1@junk-mail.com","gen.lima3@junk-mail.com");
		System.out.println("Who likes mongo? "+jedis.smembers("follow:mongo"));
		System.out.println("How many likes mongo? "+jedis.scard("follow:mongo"));
		jedis.sadd("follow:redis", "gen.lima1@junk-mail.com","gen.lima2@junk-mail.com");
		System.out.println("Who follows redis?"+jedis.smembers("follow:redis"));
		System.out.println("How many follows redis?"+jedis.scard("follow:redis"));
		// intersect the above sets to give name who is interested in mongo and redis
		System.out.println(jedis.sinter("Mongo:followers","follow:redis"));
		jedis.sinterstore("follow:redis+mongo","follow:mongo","follow:redis");
		System.out.println(jedis.smembers("follow:redis+mongo"));
		System.out.println(jedis.sismember("follow:redis+mongo", "gen.lima@junk-mail.com"));
		System.out.println(jedis.sismember("follow:redis+mongo", "gen.lima1@junk-mail.com"));
		System.out.println("Moving gen.lima3@junkmail.com from follow:mongo to follow:redis");
		jedis.smove("follow:mongo", "follow:redis", "gen.lima3@junkmail.com");
		System.out.println("Those who enjoy Redis: "+jedis.smembers("follow:redis"));
		System.out.println(jedis.srandmember("follow:mongo"));
		System.out.println(jedis.spop("follow:mongo"));
		System.out.println(jedis.smembers("follow:mongo"));
		jedis.sadd("follow:mongo","wrong-data@junk-mail.com");
		System.out.println(jedis.smembers("follow:mongo"));
		jedis.srem("follow:mongo","wrong-data@junk-mail.com");
		System.out.println(jedis.smembers("follow:mongo"));
		System.out.println(jedis.sunion("follow:mongo","follow:redis"));
		jedis.sunionstore("follow:mongo-or-redis","follow:mongo","follow:redis");
		System.out.println(jedis.smembers("follow:mongo-or-redis"));
		System.out.println(jedis.sdiff("follow:mongo", "follow:redis"));
		
	}

}
