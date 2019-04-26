package ds.nabuco.webapp.testdrive;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ListTest {

	
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
          ListTest list = new ListTest();
          list.test();
	}
	private void test() {
		// TODO Auto-generated method stub
		
	}

}
