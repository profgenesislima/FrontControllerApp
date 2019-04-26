package ds.webapp.dao;

import java.util.HashMap;
import java.util.Map;

import d.webapp.model.Client;
import ds.webapp.dao.converter.GenericConverter;
import redis.clients.jedis.Jedis;

public class ClientDAO implements DAO<Client> {

	Jedis jedis = new Jedis();
	@Override
	public void save(Client t) {
		try {
			Map<String,String> kv = GenericConverter.toRedis(t);
//			Map<String,String> kv = new HashMap<String,String>();
//			kv.put("id", String.valueOf(t.getId()));
//			kv.put("name", t.getName());
			
			
			
			jedis.hmset("client:"+t.getName(), kv);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Client getClient(Client t) {
		System.out.println("val "+"client:"+t.getName());
		 String data = jedis.hget("client:"+t.getName(), "Name");
		 Client c = new Client();
		 System.out.println("CLIENT "+data);		 
		 c.setName(data);
		return c;
	}

}
