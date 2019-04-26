package ds.nabuco.webapp.testdrive;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class StringTest {

	
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
					
	public static void main(String[] args) throws InterruptedException {
		StringTest myStringTest = new StringTest();
		myStringTest.test();

	}



	private void test() throws InterruptedException {
		Jedis jedis = this.getResource();
		String commonkey = "nabuco";
		jedis.set(commonkey, "Hello World");
		System.out.println("1) "+jedis.get("nabuco"));
		jedis.append(commonkey, " and this is a bright sunny day ");
		System.out.println("2) "+jedis.get("nabuco"));
		String substring=jedis.getrange(commonkey, 0 , 5);
		System.out.println("3) "+"substring value = "+substring);
		String commonkey1 = "nabuco1";
		jedis.set(commonkey1, "Let's learn redis");
		for(String value : jedis.mget(commonkey,commonkey1)){
		System.out.println("4) "+" - "+ value);
		}
		jedis.mset("nabuco2","let's start with string","nabuco3","then we will learn other data types");
				for(String value : jedis.mget(commonkey,commonkey1,"nabuco2","nabuco3")){
				System.out.println("5) "+" -- "+ value);
				}
				jedis.msetnx("nabuco4","next in line is hashmaps");
				System.out.println("6) "+jedis.get("nabuco4"));
				jedis.msetnx("nabuco4","next in line is sorted sets");
				System.out.println("7) "+jedis.get("nabuco4"));
				jedis.psetex("nabuco5", 1000L, "this message will self destruct in 1000 milliseconds");
				System.out.println("8) "+jedis.get("nabuco5"));
				Thread.currentThread().sleep(1200);
				System.out.println("8) "+jedis.get("nabuco5"));
				Long length=jedis.strlen(commonkey);
				System.out.println("9) "+" the length of the string 'nabuco' is " +
				length);
				this.setResource(jedis);
				}
		
	

}
